package dynamics.content;

import dynamics.content.blocks.*;

public class DynamicsBlocks {
    public static void load() {
        DynamicsEnvironment.load();
        DynamicsCrafting.load();
        DynamicsDistribution.load();
        DynamicsLiquidBlocks.load();
        DynamicsProduction.load();
        DynamicsTurrets.load();
    }
}
