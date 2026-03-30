package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsUnitTypes;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;

public class DynamicsEffectBlocks {
    public static Block
            coreSurface
            ;

    public static void load() {
        coreSurface = new CoreBlock("core-surface") {{
            requirements(Category.effect, ItemStack.with(DynamicsItems.zinc, 2000, DynamicsItems.partBasic, 200));
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
    }
}
