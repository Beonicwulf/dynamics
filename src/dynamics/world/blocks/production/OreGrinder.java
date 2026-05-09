package dynamics.world.blocks.production;

import arc.math.Mathf;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.content.Blocks;
import mindustry.world.Tile;
import mindustry.world.blocks.production.Drill;

public class OreGrinder extends Drill {
    public float countdownMultiplier;

    public OreGrinder(String name) {
        super(name);
        countdownMultiplier = 1f;
    }

    protected float setCountdown(float delay){
        int timeMultiplier = 60;
        return delay * timeMultiplier * countdownMultiplier;
    }

    protected void destroyOre(Tile tile){
        for (Tile other : tile.getLinkedTilesAs(this, tempTiles)){
            other.setOverlay(Blocks.air);
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
                    destroyOre(this.tile);
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
