package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.liquid.*;

import static mindustry.type.ItemStack.*;

public class DynamicsLiquidBlocks {
    public static Block
            pipe, pipeRouter
            ;

    public static void load() {
        pipe = new ArmoredConduit("pipe") {{
            requirements(Category.liquid, with(DynamicsItems.zinc, 2));
            leaks = true;
            underBullets = true;

        }};
        pipeRouter = new LiquidRouter("pipe-router") {{
            requirements(Category.liquid, with(DynamicsItems.zinc, 10, DynamicsItems.partBasic, 1));
            liquidCapacity = 40;
            size = 1;
        }};
    }
}
