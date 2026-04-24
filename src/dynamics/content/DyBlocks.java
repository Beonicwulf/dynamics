package dynamics.content;

import dynamics.content.blocks.*;

public class DyBlocks {
    public static void load() {
        DyEnvironment.load();
        DyCrafting.load();
        DyProduction.load();
        DyDistribution.load();
        DyLiquidBlocks.load();
        DyDefense.load();
        DyEffectBlocks.load();
        //DyComponentBlocks.load();
        DyPayloadBlocks.load();
    }
}
