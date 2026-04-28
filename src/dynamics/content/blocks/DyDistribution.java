package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.world.blocks.distribution.DirectionalSorter;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.DirectionalUnloader;
import mindustry.world.blocks.distribution.MassDriver;

import static mindustry.type.ItemStack.with;

public class DyDistribution {
    public static Block accelerator, zincSorter, zincUnloader;
    public static void load() {
        accelerator = new MassDriver("accelerator"){{
            requirements(Category.distribution, with(DyItems.zinc, 5, DyItems.malachite, 5));
            researchCost = ItemStack.mult(requirements, 5);
            size = 1;
            itemCapacity = 10;
            hasPower = false;
            range = 60;
            rotateSpeed = 10;
            reload = 5;
            shake = 0.6f;
            knockback = 2;
            shootSoundVolume = 0.1f;
        }};
        zincSorter = new DirectionalSorter("zinc-sorter") {{
            requirements(Category.distribution, with(DyItems.zinc, 10, DyItems.partBasic, 4));
            researchCost = ItemStack.mult(requirements, 50);
            regionRotated1 = 1;
            solid = false;
            placeableLiquid = true;
        }};
        zincUnloader = new DirectionalUnloader("zinc-unloader") {{
            requirements(Category.distribution, with(DyItems.zinc, 30, DyItems.partBasic, 10));
            researchCost = ItemStack.mult(requirements, 50);
            size = 2;
            solid = true;
            placeableLiquid = false;
            speed = 4f;
            underBullets = true;
            regionRotated1 = 1;
        }};
    }
}
