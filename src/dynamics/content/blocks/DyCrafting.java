package dynamics.content.blocks;

import arc.math.Mathf;
import dynamics.content.DyFX;
import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.graphics.DyPal;
import mindustry.content.Fx;
import mindustry.entities.effect.WrapEffect;
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
            fluxHeater, grafter, saltSplitter;
    public static void load() {
        fluxHeater = new HeatProducer("flux-heater") {{
            requirements(Category.crafting, with(DyItems.zinc, 20, DyItems.malachite, 5));
            researchCost = ItemStack.mult(requirements, 5);
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput());
            rotateDraw = false;
            size = 1;
            itemCapacity = 0;
            liquidCapacity = 30f;
            regionRotated1 = 1;
            ambientSound = Sounds.loopHum;
            consumeLiquid(DyLiquids.flux, 5f / 60f);
            heatOutput = 1f;
        }};
        grafter = new HeatCrafter("grafter") {{
            requirements(Category.crafting, with(DyItems.zinc, 60, DyItems.malachite, 20));
            researchCost = ItemStack.mult(requirements, 5);
            hasItems = true;
            itemCapacity = 40;
            craftEffect =  new WrapEffect(Fx.drillSteam, DyPal.flux);
            size = 3;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPistons(){{sides = 8; sideOffset = Mathf.PI / 2f;}}, new DrawHeatInput(), new DrawDefault());
            consumeItems(with(DyItems.zinc, 10, DyItems.malachite, 5));
            craftTime = 60f;
            outputItem = new ItemStack(DyItems.partBasic, 1);
            heatRequirement = 6f;
            maxEfficiency = 1f;
        }};
        saltSplitter = new HeatCrafter("salt-splitter") {{
            requirements(Category.crafting, with(DyItems.zinc, 100, DyItems.partBasic, 20));
            researchCost = ItemStack.mult(requirements, 50);
            size = 3;
            heatRequirement = 6f;
            maxEfficiency = 1f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(DyLiquids.purifiedWater),
                    new DrawBubbles(DyPal.steam){{
                        sides = 10;
                        recurrence = 3f;
                        spread = 6;
                        radius = 1.5f;
                        amount = 20;
                    }},
                    new DrawRegion()
            );
            ambientSound = Sounds.loopElectricHum;
            ambientSoundVolume = 0.08f;
            outputLiquid = new LiquidStack(DyLiquids.chlorine, 6f/ 60f);
            outputItem = new ItemStack(DyItems.sodium, 3);
            craftTime = 90;
            itemCapacity = 15;
            consumeLiquid(DyLiquids.purifiedWater, 20f/ 60f);
        }};
    }
}
