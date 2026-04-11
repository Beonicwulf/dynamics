package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.content.DyRecipes;
import dynamics.content.DyLiquids;
import dynamics.graphics.DrawPress;
import dynamics.world.blocks.crafting.RecipeCrafter;
import mindustry.content.Fx;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawMulti;
import mindustry.world.draw.DrawPistons;
import mindustry.world.draw.DrawRegion;

import static mindustry.type.ItemStack.with;

public class DyCrafting {
    public static Block
            mechanicalPress
            ;

    public static void load() {
        mechanicalPress = new RecipeCrafter("mechanical-press"){{
            requirements(Category.crafting, with(DyItems.zinc, 60, DyItems.malachite, 20));
            recipes.addAll(DyRecipes.basicComponentRecipe);
            size = 2;
            hasItems = true;
            itemCapacity = 40;
            craftEffect =  Fx.drillSteam;
            consumeLiquid(DyLiquids.steam, 5f / 60f);

            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPistons(){{
                sinMag = 3f;
                sinScl = 15f;
                sides = 8;
            }}, new DrawDefault(), new DrawPress(""){{
                maxScale = 1.5f;
            }}
            );
            researchCost = with(DyItems.zinc, 60 * 5, DyItems.malachite, 20 * 5);
        }};
    }
}
