package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.world.blocks.distribution.DirectionalSorter;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.MassDriver;

import static mindustry.type.ItemStack.with;

public class DyDistribution {
    public static Block
            accelerator, zincSorter
            ;

    public static void load() {
        accelerator = new MassDriver("accelerator"){{
            requirements(Category.distribution, with(DyItems.zinc, 10, DyItems.malachite, 5));
            size = 1;
            itemCapacity = 10;
            hasPower = false;
            range = 60;
            rotateSpeed = 10;
            reload = 5;
            shake = 0.6f;
            knockback = 2;
            shootSoundVolume = 0.1f;
            researchCost = with(DyItems.zinc, 10 * 5, DyItems.malachite, 5 * 5);
        }};
        zincSorter = new DirectionalSorter("zinc-sorter") {{
            requirements(Category.distribution, with(DyItems.zinc, 10, DyItems.partBasic, 4));
            regionRotated1 = 1;
            solid = false;
            placeableLiquid = true;
            researchCost = with(DyItems.zinc, 10 * 10 * 5, DyItems.partBasic, 4 * 10 * 5);
        }};
    }
}
