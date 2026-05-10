package dynamics.world.blocks.production;

import arc.math.Mathf;
import arc.util.io.Reads;
import arc.util.io.Writes;
import dynamics.content.DyFX;
import dynamics.content.blocks.DyEnvironment;
import mindustry.content.Blocks;
import mindustry.game.Team;
import mindustry.world.Tile;
import mindustry.world.blocks.production.Drill;
import mindustry.world.draw.*;

public class OreGrinder extends Drill {
    public float countdownMultiplier;
    public DrawBlock drawer = new DrawDefault();

    public OreGrinder(String name) {
        super(name);
        countdownMultiplier = 1f;
        drillEffect = DyFX.groundCrack;
        drillEffectChance = 0.05f;
    }

    protected float setCountdown(float delay){
        int timeMultiplier = 60;
        return delay * timeMultiplier * countdownMultiplier;
    }

    protected void tryOre(Tile tile){
        for (Tile other : tile.getLinkedTilesAs(this, tempTiles)){
            if (Mathf.random(1, size * size) == 1){
                destroyOre(other);
            }
        }
    }

    protected void destroyOre(Tile tile){
        tile.setOverlay(Blocks.air);
        if (tile.floor() == DyEnvironment.gildedChalcocite){
            tile.setFloor(DyEnvironment.chalcociteFloor.asFloor());
        }
    }

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation){
        if(isMultiblock()){
            for(Tile other : tile.getLinkedTilesAs(this, tempTiles)){
                if(canMine(other) && other.floor() != DyEnvironment.resonantChalcocite){
                    return true;
                }
            }
            return false;
        }else{
            return canMine(tile) && tile.floor() != DyEnvironment.resonantChalcocite;
        }
    }

    public class OreGrinderBuild extends DrillBuild {
        public float countdown;
        public boolean initialisedCountdown;

        @Override
        public void updateTile(){
            if(timer(timerDump, dumpTime / timeScale)){
                dump(dominantItem != null && items.has(dominantItem) ? dominantItem : null);
            }

            if(dominantItem == null){
                return;
            }

            timeDrilled += warmup * delta();

            float delay = getDrillTime(dominantItem);

            if (!initialisedCountdown){
                countdown = setCountdown(delay);
                initialisedCountdown = true;
            }

            if(items.total() < itemCapacity && dominantItems > 0 && efficiency > 0){
                float speed = Mathf.lerp(1f, liquidBoostIntensity, optionalEfficiency) * efficiency;

                lastDrillSpeed = (speed * dominantItems * warmup) / delay;
                warmup = Mathf.approachDelta(warmup, speed, warmupSpeed);
                progress += delta() * dominantItems * speed * warmup;

                countdown -= 1;
                if (countdown < 1){
                    tryOre(this.tile);
                    countdown = setCountdown(delay);
                }

                if(Mathf.chanceDelta(updateEffectChance * warmup))
                    updateEffect.at(x + Mathf.range(size * 2f), y + Mathf.range(size * 2f));
            }else{
                lastDrillSpeed = 0f;
                warmup = Mathf.approachDelta(warmup, 0f, warmupSpeed);
                return;
            }

            if(dominantItems > 0 && progress >= delay && items.total() < itemCapacity){
                int amount = (int)(progress / delay);
                for(int i = 0; i < amount; i++){
                    offload(dominantItem);
                }

                progress %= delay;

                if(wasVisible && Mathf.chanceDelta(drillEffectChance * warmup)) drillEffect.at(x + Mathf.range(drillEffectRnd), y + Mathf.range(drillEffectRnd), dominantItem.color);
            }
        }

        @Override
        public void draw(){
            drawer.draw(this);
        }

        @Override
        public void write(Writes write){
            super.write(write);
            write.f(progress);
            write.f(warmup);
            write.f(countdown);
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);
            if(revision >= 1){
                progress = read.f();
                warmup = read.f();
                countdown = read.f();
            }
        }
    }
}
