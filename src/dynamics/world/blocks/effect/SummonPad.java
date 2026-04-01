package dynamics.world.blocks.effect;

import dynamics.content.DynamicsUnitTypes;
import dynamics.graphics.DynamicsPal;
import mindustry.world.blocks.units.UnitCargoLoader;

public class SummonPad extends UnitCargoLoader {
    public SummonPad(String name) {
        super(name);
        unitType = DynamicsUnitTypes.augerDrone;
        unitBuildTime = 60f * 8f;
        polyColor = DynamicsPal.malachite;
        itemCapacity = 0;
    }
    public class SummonPadBuild extends UnitCargoLoader.UnitTransportSourceBuild {

        @Override
        public boolean shouldConsume(){
            return true;
        }

        @Override
        public void updateTile(){
            super.updateTile();
            if(efficiency < 1 && unit != null){unit.destroy();}
        }
    }
}


