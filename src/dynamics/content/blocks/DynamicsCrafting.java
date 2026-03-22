package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsLiquids;
import dynamics.graphics.DrawPress;
import mindustry.content.Fx;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawPistons;
import mindustry.world.draw.DrawRegion;

import static mindustry.type.ItemStack.with;

public class DynamicsCrafting {
    public static Block
            mechanicalPress
            ;

    public static void load() {
        mechanicalPress = new GenericCrafter("mechanical-press"){{
            requirements(Category.crafting, with(DynamicsItems.zinc, 60, DynamicsItems.malachite, 20));

            outputItem = new ItemStack(DynamicsItems.component, 1);
            craftTime = 150f;
            size = 2;
            hasItems = true;
            craftEffect =  Fx.drillSteam;

            consumeItems(with(DynamicsItems.zinc, 10, DynamicsItems.malachite, 5));
            consumeLiquid(DynamicsLiquids.steam, 12f / 60f);

            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPistons(){{
                sinMag = 3f;
                sinScl = 15f;
                sides = 8;
            }}, new DrawDefault(), new DrawPress(""){{
                maxScale = 1.5f;
            }}
            );
        }};
    }
}
