package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import dynamics.world.blocks.defense.ComponentBlock;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;

public class DynamicsComponentBlocks {
    public static Block
            bUAK, splitFrame
            ;

    public static void load() {
        bUAK = new ComponentBlock("b-u-a-k") {{
            requirements(Category.units, ItemStack.with(DynamicsItems.zinc, 10, DynamicsItems.partBasic, 5));
            size = 1;
            researchCost = ItemStack.with(DynamicsItems.zinc, 10 * 5, DynamicsItems.partBasic, 5 * 5);
        }};
        splitFrame = new ComponentBlock("split-frame") {{
            requirements(Category.units, ItemStack.with(DynamicsItems.zinc, 20, DynamicsItems.malachite, 10));
            size = 1;
            researchCost = ItemStack.with(DynamicsItems.zinc, 20 * 5, DynamicsItems.malachite, 10 * 5);
        }};
    }
}
