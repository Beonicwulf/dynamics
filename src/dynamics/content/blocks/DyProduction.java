package dynamics.content.blocks;

import dynamics.content.DyAttributes;
import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.graphics.DrawPress;
import dynamics.graphics.DyPal;
import mindustry.content.Fx;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WrapEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.Drill;
import mindustry.world.draw.*;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class DyProduction {
    public static Block
            // attribute
            fluxCollector,
            // drills
            clockworkDrill, microDrill;
    public static void load() {
        microDrill = new Drill("micro-drill") {{
            requirements(Category.production, BuildVisibility.sandboxOnly, with(DyItems.zinc,10, DyItems.malachite, 5));
            size = 1;
            tier = 1;
            drillTime = 60f * 10f;
        }};
        clockworkDrill = new Drill("clockwork-drill") {{
            requirements(Category.production, with(DyItems.zinc, 50, DyItems.partBasic, 2));
            size = 3;
            drillTime = 60f * 18f;
            //consumeLiquid(DyLiquids.steam, 5f / 60f);
            hasPower = false;
            tier = 2;
            drillMultipliers.put(DyItems.zinc, 2f);
            placeableLiquid = true;
            researchCost = with(DyItems.zinc, 50 * 5, DyItems.partBasic, 2 * 5);
        }};
        fluxCollector = new AttributeCrafter("flux-collector"){{
            requirements(Category.production, with(DyItems.zinc, 60, DyItems.malachite, 20));
            attribute = DyAttributes.flux;
            baseEfficiency = 0f;
            minEfficiency = 1f;
            displayEfficiency = false;
            boostScale = 1f / 9f;
            hasPower = false;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawRegion("-mid"), new DrawLiquidTile(DyLiquids.steam, 38f / 4f), new DrawDefault(), new DrawPress("-press") {{maxScale = 1.3f;}});
            craftTime = 120f;
            craftEffect = new MultiEffect(Fx.turbinegenerate, new WrapEffect(Fx.drillSteam, DyPal.flux));
            size = 3;
            ambientSound = Sounds.loopHum;
            ambientSoundVolume = 0.06f;
            hasLiquids = true;
            itemCapacity = 0;
            outputLiquid = new LiquidStack(DyLiquids.flux, 45f / 60f);
            liquidCapacity = 60f;
            researchCost = with(DyItems.zinc, 60 * 5, DyItems.malachite, 20 * 5);
        }};
    }
}
