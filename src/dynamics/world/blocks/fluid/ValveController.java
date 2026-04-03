package dynamics.world.blocks.fluid;

import mindustry.gen.Building;
import mindustry.world.blocks.liquid.LiquidJunction;

public class ValveController extends LiquidJunction {

    public int updateTimer = timers++;
    public float minPressure = 0.1f;

    public boolean invert = true;

    public ValveController(String name) {
        super(name);
    }

    float total;

    public class ValveControllerBuild extends LiquidJunctionBuild{

        @Override
        public void updateTile() {
            super.updateTile();

            total = 0;
            proximity.each(b -> {
                if(b.liquids != null) total += b.liquids.currentAmount()/b.block.liquidCapacity;
            });

            boolean enable = total >= minPressure;

            if(invert) enable = !enable;

            for(Building b: proximity){
                if(b.block.configurable) b.configure(enable);
            }
        }
    }
}

// Thanks, Sh1penfire!
// Source: https://github.com/Sh1penfire/meld-java/blob/cb0d574b98defc12e14f2e7c0b0524802b64f116/src/meld/world/blocks/fluid/ValveController.java