package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsLiquids;
import dynamics.content.DynamicsUnitTypes;
import dynamics.graphics.DynamicsPal;
import dynamics.world.blocks.effect.SummonPad;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class DynamicsEffectBlocks {
    public static Block
            coreSurface, augerPad
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
            size = 3;
            consumeLiquid(DynamicsLiquids.steam, 45f / 60f);
            unitType = DynamicsUnitTypes.augerDrone;
            polyStroke = 1.8f;
            polyRadius = 12f;
            polySides = 5;
            polyRotateSpeed = 1f;
            unitBuildTime = 60f * 10f;
            polyColor = DynamicsPal.malachite;
        }};
    }
}
