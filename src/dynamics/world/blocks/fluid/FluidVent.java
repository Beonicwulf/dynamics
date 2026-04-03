package dynamics.world.blocks.fluid;

import mindustry.entities.Puddles;
import mindustry.type.Liquid;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.meta.Attribute;

public class FluidVent extends LiquidRouter {

    public float minPressure = 0;
    public float ventRate = 1;
    public float ventDelay = 10;

    int ventTimer = timers++;

    public FluidVent(String name) {
        super(name);
    }

    public class FluidVentBuild extends LiquidRouterBuild{
        @Override
        public void updateTile() {
            super.updateTile();

            Liquid liquid = liquids.current();

            if(timer.get(ventTimer, ventDelay) && liquid.gas || liquid.boilPoint <= Attribute.heat.env()){
                float ventEfficiency = (liquids.get(liquid)/liquidCapacity - minPressure)/(1 - minPressure);

                if(ventEfficiency > 0){

                    float leakAmount = Math.min(ventEfficiency * ventRate * ventDelay, liquids.get(liquid));

                    if(leakAmount > 1E-4){
                        Puddles.deposit(tile, tile, liquid, leakAmount, true, true);
                        liquids.remove(liquid, leakAmount);
                    }
                }
            }
        }
    }
}

// Thanks Sh1penfire!
// Source: https://github.com/Sh1penfire/meld-java/blob/cb0d574b98defc12e14f2e7c0b0524802b64f116/src/meld/world/blocks/fluid/ChannelVent.java