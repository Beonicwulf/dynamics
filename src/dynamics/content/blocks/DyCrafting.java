package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.content.DyRecipes;
import dynamics.content.DyLiquids;
import dynamics.graphics.DrawPress;
import dynamics.world.blocks.crafting.RecipeCrafter;
import mindustry.content.Fx;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.blocks.production.HeatCrafter;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class DyCrafting {
    public static Block
            // steam input
            mechanicalPress,
            // heat
            waterPurifier,
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
        waterPurifier = new HeatCrafter("water-purifier") {{
            requirements(Category.crafting, with(DyItems.zinc, 40, DyItems.partBasic, 3));
            researchCost = with(DyItems.zinc, 40 * 10 * 5, DyItems.partBasic, 3 * 10 * 5);
            size = 3;
            heatRequirement = 12f;
            maxEfficiency = 1f;
            craftTime = 240f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(DyLiquids.purifiedWater), new DrawDefault(), new DrawHeatInput());
            consumeLiquid(DyLiquids.hotSpringWater, 20f/60f * 4f);
            outputLiquid = new LiquidStack(DyLiquids.purifiedWater, 15f/60f * 4f);
            outputItem = new ItemStack(DyItems.halite, 1);
        }};
        steamHeater = new HeatProducer("steam-heater") {{
            requirements(Category.crafting, with(DyItems.zinc, 30, DyItems.partBasic, 2));
            size = 2;
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput());
            itemCapacity = 0;
            liquidCapacity = 30f;
            rotateDraw = false;
            regionRotated1 = 1;
            ambientSound = Sounds.loopHum;
            consumeLiquid(DyLiquids.steam, 5f / 60f);
            heatOutput = 3f;
            researchCost = with(DyItems.zinc, 30 * 10 * 5, DyItems.partBasic, 2 * 10 * 5);
        }};
    }
}
