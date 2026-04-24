package dynamics.content.blocks;

import arc.math.Mathf;
import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.graphics.DyPal;
import mindustry.content.Fx;
import mindustry.entities.effect.WrapEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.blocks.production.HeatCrafter;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class DyCrafting {
    public static Block
            fluxHeater, grafter;
    public static void load() {
        fluxHeater = new HeatProducer("flux-heater") {{
            requirements(Category.crafting, with(DyItems.zinc, 20, DyItems.malachite, 5));
            drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput());
            rotateDraw = false;
            size = 1;
            itemCapacity = 0;
            liquidCapacity = 30f;
            regionRotated1 = 1;
            ambientSound = Sounds.loopHum;
            consumeLiquid(DyLiquids.flux, 5f / 60f);
            heatOutput = 1f;
            researchCost = with(DyItems.zinc, 20 * 5, DyItems.malachite, 5 * 5);
        }};
        grafter = new HeatCrafter("grafter"){{
            requirements(Category.crafting, with(DyItems.zinc, 60, DyItems.malachite, 20));
            researchCost = with(DyItems.zinc, 60 * 5, DyItems.malachite, 20 * 5);
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
    }
}
