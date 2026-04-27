package dynamics.content.blocks;

import dynamics.content.DyBulletTypes;
import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.graphics.DyPal;
import mindustry.content.Fx;
import mindustry.entities.effect.WrapEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.*;

import static mindustry.type.ItemStack.with;

public class DyDefense {
    public static Block
            // turrets
            withdraw;
    public static void load(){
        withdraw = new ItemTurret("withdraw") {{
            requirements(Category.turret, with(DyItems.zinc, 100, DyItems.partBasic, 10));
            targetAir = true;
            size = 3;
            hasPower = false;
            recoil = 2;
            reload = 60f;
            range = 180;
            ammoUseEffect = new WrapEffect(Fx.drillSteam, DyPal.flux);
            shootSound = Sounds.shootBreach;
            targetUnderBlocks = false;
            shootCone = 25;
            rotateSpeed = 3.8f;
            maxAmmo = 24;
            ammoPerShot = 1;
            shootY = 7;
            //coolantMultiplier = 10f;
            liquidCapacity = 50f;
            coolant = consumeLiquid(DyLiquids.flux, 5f/60f);
            ammo(DyItems.malachite, DyBulletTypes.malachiteFrag);
            //thx nullevoy for sprite
            researchCost = with(DyItems.zinc, 100 * 5, DyItems.partBasic, 10 * 5);
        }};
    }
}
