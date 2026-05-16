package dynamics.world.blocks.effect;

import arc.Core;
import arc.math.Mathf;
import arc.util.Eachable;
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import dynamics.content.DyFX;
import dynamics.graphics.DyPal;
import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.units.BuildPlan;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.ui.Bar;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.draw.DrawBlock;
import mindustry.world.draw.DrawDefault;

public class FoundationBuilder extends Block {
    public DrawBlock drawer = new DrawDefault();
    public Block foundation = Blocks.coreZone;
    public float warmupSpeed = 0.019f;
    public float buildTime = 0.5f * 60 * 60; // half a minute in ticks

    public Effect buildEffect = DyFX.blast;
    public Effect updateEffect = Fx.none;
    public float updateEffectChance = 0.04f;
    public float updateEffectSpread = 4f;

    public FoundationBuilder(String name) {
        super(name);
        update = true;
        solid = true;
        hasItems = true;
        hasLiquids = true;
        ambientSound = Sounds.loopMachine;
        sync = true;
    }

    public void buildFoundation(Tile tile){
        for (Tile other : tile.getLinkedTilesAs(this, tempTiles)){
            if (other.floor() != foundation.asFloor()){
                other.setFloor(foundation.asFloor());
                return;
            }
        }
    }

    public boolean canBuildFoundation(Tile tile){
        for (Tile other : tile.getLinkedTilesAs(this, tempTiles)){
            if (other.floor() != foundation.asFloor()){
                return true;
            }
        }
        return false;
    }
    
    public int foundations(Tile tile){
        int foundations = 0;
        for (Tile other : tile.getLinkedTilesAs(this, tempTiles)){
            if (other.floor() == foundation.asFloor()){
                foundations += 1;
            }
        }
        return foundations;
    }

    @Override
    public void setBars(){
        super.setBars();
        int maxArea = size * size;
        addBar("foundations", entity -> new Bar(
                () -> Core.bundle.format("bar.foundations", foundations(entity.tile)),
                () -> DyPal.fluxLight,
                () -> (float) foundations(entity.tile) / maxArea)
        );
    }

    @Override
    public void load(){
        super.load();
        drawer.load(this);
    }

    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list){
        drawer.drawPlan(this, plan, list);
    }

    public class FoundationBuilderBuild extends Building {
        public float progress;
        public float totalProgress;
        public float warmup;

        @Override
        public void draw(){
            drawer.draw(this);
        }

        @Override
        public void drawLight(){
            super.drawLight();
            drawer.drawLight(this);
        }

        @Override
        public void updateTile(){
            if (efficiency > 0){
                progress += getProgressIncrease(buildTime);
                warmup = Mathf.approachDelta(warmup, warmupTarget(), warmupSpeed);

                if(wasVisible && Mathf.chanceDelta(updateEffectChance)){
                    updateEffect.at(x + Mathf.range(size * updateEffectSpread), y + Mathf.range(size * updateEffectSpread));
                }
            }else{
                warmup = Mathf.approachDelta(warmup, 0f, warmupSpeed);
            }

            totalProgress += warmup * Time.delta;

            if(progress >= 1f){
                if (canBuildFoundation(this.tile)){
                    consume();
                    buildFoundation(this.tile);
                    buildEffect.at(x, y);
                }
                progress %= 1f;
            }
        }

        public float warmupTarget(){
            return 1f;
        }

        @Override
        public float warmup(){
            return warmup;
        }

        @Override
        public float totalProgress(){
            return totalProgress;
        }

        @Override
        public boolean shouldAmbientSound(){
            return efficiency > 0;
        }

        @Override
        public float progress(){
            return Mathf.clamp(progress);
        }

        @Override
        public void write(Writes write){
            super.write(write);
            write.f(progress);
            write.f(warmup);
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);
            progress = read.f();
            warmup = read.f();
        }
    }
}
