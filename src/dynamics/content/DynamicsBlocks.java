package dynamics.content;

import dynamics.content.blocks.DynamicsCrafting;
import dynamics.content.blocks.DynamicsDistribution;
import dynamics.content.blocks.DynamicsLiquidBlocks;

public class DynamicsBlocks {
    public static void load() {
        DynamicsCrafting.load();
        DynamicsDistribution.load();
        DynamicsLiquidBlocks.load();
    }
}
