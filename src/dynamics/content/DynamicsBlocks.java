package dynamics.content;

import dynamics.content.blocks.*;

public class DynamicsBlocks {
    public static void load() {
        DynamicsEnvironment.load();
        DynamicsCrafting.load();
        DynamicsProduction.load();
        DynamicsDistribution.load();
        DynamicsLiquidBlocks.load();
        DynamicsDefense.load();
    }
}
