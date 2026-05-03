package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.content.DyMusic;
import dynamics.content.DyUnits;
import dynamics.graphics.DyPal;
import dynamics.world.blocks.effect.UnitPad;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;

import static mindustry.type.ItemStack.with;

public class DyEffectBlocks {
    public static Block
            // Cores
            coreSurface, augerPad;
    public static void load() {
        coreSurface = new CoreBlock("core-surface") {{
            requirements(Category.effect, with(DyItems.zinc, 1000, DyItems.partBasic, 200));
            size = 4;
            unitType = DyUnits.breathe;
            itemCapacity = 1200;
            health = 4000;
            armor = 4;
            alwaysUnlocked = true;
            isFirstTier = true;
            unitCapModifier = 15;
            requiresCoreZone = true;
            incinerateNonBuildable = true;
            landMusic = DyMusic.reborne;
        }};
        augerPad = new UnitPad("auger-pad") {{
            requirements(Category.effect, with(DyItems.zinc, 900, DyItems.partBasic, 200));
            researchCost = ItemStack.mult(requirements, 50);
            hasPower = false;
            size = 2;
            consumeLiquid(DyLiquids.flux, 30f / 60f);
            unitType = DyUnits.augerDrone;
            polyStroke = 1.8f;
            polyRadius = 10f;
            polySides = 3;
            polyRotateSpeed = 1f;
            unitBuildTime = 60f * 10f;
            polyColor = DyPal.malachite;
            health = 1410;
            drawTeam = requiresCoreZone = true;
        }};
    }
}
