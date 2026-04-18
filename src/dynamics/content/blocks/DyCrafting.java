package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.content.DyRecipes;
import dynamics.content.DyLiquids;
import dynamics.graphics.DrawPress;
import dynamics.world.blocks.crafting.RecipeCrafter;
import mindustry.content.Fx;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class DyCrafting {
    public static Block
            // steam input
            mechanicalPress,
            // heaters
            steamHeater;
    public static void load() {
        mechanicalPress = new RecipeCrafter("mechanical-press"){{
            requirements(Category.crafting, with(DyItems.zinc, 60, DyItems.malachite, 20));
            recipes.add(DyRecipes.basicComponentRecipe);
            recipes.add(DyRecipes.powerComponentRecipe);
            size = 2;
            hasItems = true;
            itemCapacity = 40;
            craftEffect =  Fx.drillSteam;
            consumeLiquid(DyLiquids.steam, 5f / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPistons(){{sinMag = 3f; sinScl = 15f; sides = 8;}}, new DrawDefault(), new DrawPress(""){{maxScale = 1.5f;}});
            researchCost = with(DyItems.zinc, 60 * 5, DyItems.malachite, 20 * 5);
        }};
        steamHeater = new HeatProducer("steam-heater") {{
            requirements(Category.crafting, with(DyItems.zinc, 60, DyItems.malachite, 20, DyItems.partBasic, 5));
            size = 2;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(DyLiquids.steam), new DrawDefault(), new DrawHeatOutput());
            size = 3;
            itemCapacity = 0;
            liquidCapacity = 120f;
            rotateDraw = false;
            regionRotated1 = 1;
            ambientSound = Sounds.loopHum;
            consumeLiquid(DyLiquids.steam, 5f / 60f);
            heatOutput = 3f;
            researchCost = with(DyItems.zinc, 60 * 10 * 5, DyItems.malachite, 20 * 10 * 5, DyItems.partBasic, 5 * 5 * 5);
        }};
    }
}
