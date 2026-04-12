package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.world.blocks.defense.ComponentBlock;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;

public class DyComponentBlocks {
    public static Block
            bUAK, splitFrame
            ;

    public static void load() {
        bUAK = new ComponentBlock("b-u-a-k") {{
            requirements(Category.units, BuildVisibility.editorOnly, ItemStack.with(DyItems.zinc, 10, DyItems.partBasic, 5));
            size = 1;
            researchCost = ItemStack.with(DyItems.zinc, 10 * 5, DyItems.partBasic, 5 * 5);
        }};
        splitFrame = new ComponentBlock("split-frame") {{
            requirements(Category.units, BuildVisibility.editorOnly, ItemStack.with(DyItems.zinc, 20, DyItems.malachite, 10));
            size = 1;
            researchCost = ItemStack.with(DyItems.zinc, 20 * 5, DyItems.malachite, 10 * 5);
        }};
    }
}
