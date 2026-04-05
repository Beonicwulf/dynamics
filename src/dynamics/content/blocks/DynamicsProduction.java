package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsLiquids;
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
            requirements(Category.production, BuildVisibility.sandboxOnly, with(DynamicsItems.zinc,10, DynamicsItems.malachite, 5));
            size = 1;
            tier = 1;
            drillTime = 60f * 10f;
        }};
        clockworkDrill = new BurstDrill("clockwork-drill") {{
            requirements(Category.production, with(DynamicsItems.zinc, 50, DynamicsItems.partBasic, 2));
            size = 3;
            drillTime = 60f * 18f;
            shake = 2f;
            drillEffect = new MultiEffect(Fx.mineImpact, Fx.drillSteam, Fx.mineImpactWave.wrap(Pal.redLight, 40f));
            consumeLiquid(DynamicsLiquids.steam, 5f / 60f);
            hasPower = false;
            tier = 2;
            drillMultipliers.put(DynamicsItems.zinc, 2f);
            arrows = 1;
            placeableLiquid = true;
            researchCost = with(DynamicsItems.zinc, 50 * 5, DynamicsItems.partBasic, 2 * 5);
        }};
        steamCollector = new AttributeCrafter("steam-collector"){{
            requirements(Category.liquid, with(DynamicsItems.zinc, 60, DynamicsItems.malachite, 20));
            attribute = Attribute.steam;
            group = BlockGroup.liquids;
            minEfficiency = 9f - 0.0001f;
            baseEfficiency = 0f;
            displayEfficiency = false;
            hasPower = false;
            craftEffect = new MultiEffect(Fx.turbinegenerate, Fx.drillSteam);
            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    // new DrawBlurSpin("-rotator", 6f),
                    new DrawRegion("-mid"), new DrawLiquidTile(DynamicsLiquids.steam, 38f / 4f), new DrawDefault(), new DrawPress("-press") {{maxScale = 1.3f;}});
            craftTime = 120f;
            size = 3;
            ambientSound = Sounds.loopHum;
            ambientSoundVolume = 0.06f;
            hasLiquids = true;
            boostScale = 1f / 9f;
            itemCapacity = 0;
            outputLiquid = new LiquidStack(DynamicsLiquids.steam, 30f / 60f);
            liquidCapacity = 60f;
            researchCost = with(DynamicsItems.zinc, 60 * 5, DynamicsItems.malachite, 20 * 5);
        }};

    }
}
