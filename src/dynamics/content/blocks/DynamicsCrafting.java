package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsRecipes;
import dynamics.content.DynamicsLiquids;
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

public class DynamicsCrafting {
    public static Block
            mechanicalPress
            ;

    public static void load() {
        mechanicalPress = new RecipeCrafter("mechanical-press"){{
            requirements(Category.crafting, with(DynamicsItems.zinc, 60, DynamicsItems.malachite, 20));
            recipes.addAll(DynamicsRecipes.basicComponentRecipe);
            size = 2;
            hasItems = true;
            craftEffect =  Fx.drillSteam;
            consumeLiquid(DynamicsLiquids.steam, 15f / 60f);

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
