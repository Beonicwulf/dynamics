package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.graphics.DrawPress;
import mindustry.content.Fx;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.BurstDrill;
import mindustry.world.blocks.production.Drill;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class DynamicsProduction {
    public static Block
            // vents
            steamCollector,
            // drills
            clockworkDrill, microDrill
                    ;

    public static void load() {
        microDrill = new Drill("micro-drill") {{
            requirements(Category.production, BuildVisibility.sandboxOnly, with(DyItems.zinc,10, DyItems.malachite, 5));
            size = 1;
            tier = 1;
            drillTime = 60f * 10f;
        }};
        clockworkDrill = new BurstDrill("clockwork-drill") {{
            requirements(Category.production, with(DyItems.zinc, 50, DyItems.partBasic, 2));
            size = 3;
            drillTime = 60f * 18f;
            shake = 2f;
            drillEffect = new MultiEffect(Fx.mineImpact, Fx.drillSteam, Fx.mineImpactWave.wrap(Pal.redLight, 40f));
            consumeLiquid(DyLiquids.steam, 5f / 60f);
            hasPower = false;
            tier = 2;
            drillMultipliers.put(DyItems.zinc, 2f);
            arrows = 1;
            placeableLiquid = true;
            researchCost = with(DyItems.zinc, 50 * 5, DyItems.partBasic, 2 * 5);
        }};
        steamCollector = new AttributeCrafter("steam-collector"){{
            requirements(Category.liquid, with(DyItems.zinc, 60, DyItems.malachite, 20));
            attribute = Attribute.steam;
            group = BlockGroup.liquids;
            minEfficiency = 9f - 0.0001f;
            baseEfficiency = 0f;
            displayEfficiency = false;
            hasPower = false;
            craftEffect = new MultiEffect(Fx.turbinegenerate, Fx.drillSteam);
            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    // new DrawBlurSpin("-rotator", 6f),
                    new DrawRegion("-mid"), new DrawLiquidTile(DyLiquids.steam, 38f / 4f), new DrawDefault(), new DrawPress("-press") {{maxScale = 1.3f;}});
            craftTime = 120f;
            size = 3;
            ambientSound = Sounds.loopHum;
            ambientSoundVolume = 0.06f;
            hasLiquids = true;
            boostScale = 1f / 9f;
            itemCapacity = 0;
            outputLiquid = new LiquidStack(DyLiquids.steam, 30f / 60f);
            liquidCapacity = 60f;
            researchCost = with(DyItems.zinc, 60 * 5, DyItems.malachite, 20 * 5);
        }};

    }
}
