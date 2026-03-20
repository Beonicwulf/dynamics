package dynamics.content;

import arc.math.Mathf;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class DynamicsBlocks {
    public static Block
            //crafting
            mechanicalPress
            ;

    public static void load() {
        //crafting
        mechanicalPress = new GenericCrafter("mechanical-press"){{
            requirements(Category.crafting, with(DynamicsItems.zinc, 80));

            outputItem = new ItemStack(DynamicsItems.component, 1);
            craftTime = 90f;
            size = 2;
            hasItems = true;

            consumeItem(DynamicsItems.zinc, 3);
            consumeLiquid(DynamicsLiquids.steam, 12f / 60f);

            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawPistons(){{
                        sinMag = 2.75f;
                        sinScl = 5f;
                        sides = 8;
                        sideOffset = Mathf.PI / 2f;
                    }},
                    new DrawRegion("-top"),
                    new DrawDefault()
            );
        }};
    }
}
