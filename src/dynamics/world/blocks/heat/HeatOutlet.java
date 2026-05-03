package dynamics.world.blocks.heat;

import arc.Core;
import arc.audio.Sound;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import mindustry.gen.Sounds;
import mindustry.world.blocks.heat.HeatProducer;

public class HeatOutlet extends HeatProducer {
    public Sound clickSound = Sounds.click;
    public TextureRegion onRegion;

    @Override
    public void load() {
        super.load();
        onRegion = Core.atlas.find(name + "-on", "clear");
    }

    public HeatOutlet(String name) {
        super(name);
        configurable = true;
        update = true;
        drawDisabled = false;
        autoResetEnabled = false;
        configureSound = Sounds.none;

        config(Boolean.class, (HeatOutlet.HeatOutletBuild entity, Boolean b) -> entity.enabled = b);
    }

    public class HeatOutletBuild extends HeatProducerBuild{
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
