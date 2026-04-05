package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsLiquids;
import dynamics.content.DynamicsUnitTypes;
import dynamics.graphics.DynamicsPal;
import dynamics.world.blocks.effect.SummonPad;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.logic.MessageBlock;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class DynamicsEffectBlocks {
    public static Block
            coreSurface, augerPad,
            zincMessage
            ;

    public static void load() {
        coreSurface = new CoreBlock("core-surface") {{
            requirements(Category.effect, with(DynamicsItems.zinc, 2000, DynamicsItems.partBasic, 200));
            size = 4;
            unitType = DynamicsUnitTypes.breathe;
            itemCapacity = 2000;
            health = 4000;
            armor = 4;
            alwaysUnlocked = true;
            isFirstTier = true;
            unitCapModifier = 15;
            requiresCoreZone = true;
            incinerateNonBuildable = true;
        }};
        augerPad = new SummonPad("auger-pad") {{
            requirements(Category.effect, BuildVisibility.sandboxOnly, with(DynamicsItems.zinc, 2000, DynamicsItems.partBasic, 200));
            hasPower = false;
            size = 2;
            consumeLiquid(DynamicsLiquids.steam, 45f / 60f);
            unitType = DynamicsUnitTypes.augerDrone;
            polyStroke = 1.8f;
            polyRadius = 10f;
            polySides = 3;
            polyRotateSpeed = 1f;
            unitBuildTime = 60f * 10f;
            polyColor = DynamicsPal.malachite;
            drawTeamOverlay = true;
            alwaysUnlocked = true;
        }};
        zincMessage = new MessageBlock("zinc-message") {{
           requirements(Category.logic, with(DynamicsItems.zinc, 10, DynamicsItems.malachite, 5, DynamicsItems.partBasic, 1));
           researchCost = with(DynamicsItems.zinc, 100 * 5, DynamicsItems.malachite, 50 * 5, DynamicsItems.partBasic, 10 * 5);
        }};
    }
}
