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
        // yes, I didn't need to make a custom class for this, I just felt like it
    }
}
