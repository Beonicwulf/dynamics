package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.MassDriver;

import static mindustry.type.ItemStack.with;

public class DynamicsDistribution {
    public static Block
            accelerator
            ;

    public static void load() {
        accelerator = new MassDriver("accelerator"){{
            requirements(Category.distribution, with(DynamicsItems.zinc, 10, DynamicsItems.component, 1));
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
    }
}
