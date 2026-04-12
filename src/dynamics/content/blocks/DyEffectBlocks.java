package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.content.DyUnitTypes;
import dynamics.graphics.DyPal;
import dynamics.world.blocks.effect.SummonPad;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.logic.MessageBlock;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class DyEffectBlocks {
    public static Block
            // Cores
            coreSurface, augerPad,
            // Logic
            zincMessage;
    public static void load() {
        coreSurface = new CoreBlock("core-surface") {{
            requirements(Category.effect, with(DyItems.zinc, 2000, DyItems.partBasic, 200));
            size = 4;
            unitType = DyUnitTypes.breathe;
            itemCapacity = 2000;
            health = 4000;
            armor = 4;
            alwaysUnlocked = true;
            isFirstTier = true;
            unitCapModifier = 15;
            requiresCoreZone = true;
            incinerateNonBuildable = true;
            //landMusic = DyMusics.reborne;
        }};
        augerPad = new SummonPad("auger-pad") {{
            requirements(Category.effect, BuildVisibility.sandboxOnly, with(DyItems.zinc, 2000, DyItems.partBasic, 200));
            hasPower = false;
            size = 2;
            consumeLiquid(DyLiquids.steam, 45f / 60f);
            unitType = DyUnitTypes.augerDrone;
            polyStroke = 1.8f;
            polyRadius = 10f;
            polySides = 3;
            polyRotateSpeed = 1f;
            unitBuildTime = 60f * 10f;
            polyColor = DyPal.malachite;
            drawTeamOverlay = true;
            alwaysUnlocked = true;
            health = 1410;
        }};
        zincMessage = new MessageBlock("zinc-message") {{
           requirements(Category.logic, with(DyItems.zinc, 10, DyItems.malachite, 5, DyItems.partBasic, 1));
           researchCost = with(DyItems.zinc, 10 * 10 * 5, DyItems.malachite, 5 * 10 * 5, DyItems.partBasic, 10 * 5);
        }};
    }
}
