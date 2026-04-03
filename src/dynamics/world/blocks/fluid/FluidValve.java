package dynamics.world.blocks.fluid;

import arc.Core;
import arc.audio.Sound;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import mindustry.gen.Sounds;
import mindustry.world.blocks.liquid.LiquidJunction;

//A switch + liquid junction
public class FluidValve extends LiquidJunction {
    public Sound clickSound = Sounds.click;

    public TextureRegion onRegion;

    @Override
    public void load() {
        super.load();
        onRegion = Core.atlas.find(name + "-on", "clear");
    }

    public FluidValve(String name) {
        super(name);
        configurable = true;
        update = true;
        drawDisabled = false;
        autoResetEnabled = false;
        configureSound = Sounds.none;

        config(Boolean.class, (FluidValve.ValveBuild entity, Boolean b) -> entity.enabled = b);
    }

    public class ValveBuild extends LiquidJunctionBuild{

        @Override
        public boolean configTapped(){
            configure(!enabled);
            clickSound.at(this);
            return false;
        }

        @Override
        public Boolean config(){
            return enabled;
        }

        @Override
        public void draw(){
            super.draw();

            if(enabled){
                Draw.rect(onRegion, x, y);
            }
        }
    }
}

// Thanks, Sh1penfire!
// Source: https://github.com/Sh1penfire/meld-java/blob/cb0d574b98defc12e14f2e7c0b0524802b64f116/src/meld/world/blocks/fluid/ChannelValve.java