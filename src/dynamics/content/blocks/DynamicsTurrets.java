package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsLiquids;
import dynamics.graphics.DynamicsPal;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.*;

import static mindustry.type.ItemStack.with;

public class DynamicsTurrets {
    public static Block
            withdraw
            ;

    public static void load(){
        Effect withdrawShootEffect = new MultiEffect(Fx.drillSteam, Fx.colorSparkBig);

        withdraw = new ItemTurret("withdraw") {{
            requirements(Category.turret, with(DynamicsItems.zinc, 100, DynamicsItems.partBasic, 10));
            targetAir = true;
            size = 3;
            hasPower = false;
            recoil = 2;
            reload = 35f;
            range = 180;
            ammoUseEffect = Fx.drillSteam;
            shootSound = Sounds.shootBreach;
            targetUnderBlocks = false;
            shootCone = 25;
            rotateSpeed = 3.8f;
            maxAmmo = 24;
            ammoPerShot = 1;
            shootY = 7;
            liquidCapacity = 50f;
            consumeLiquid(DynamicsLiquids.steam, 5f / 60f);

            ammo(
                    DynamicsItems.malachite, new BasicBulletType(2.5f, 15, "fb-dynamics-malachite-chunk-big") {{
                        hitColor = trailColor = DynamicsPal.malachite;
                        height = 11;
                        width = 9;
                        trailWidth = 1.3f;
                        trailLength = 9;
                        ammoMultiplier = 3;
                        lifetime = 60f;
                        spin = 2.5f;
                        //pierce = true;
                        //pierceBuilding = false;
                        //pierceCap = 1;
                        splashDamage = 20f;
                        splashDamageRadius = 10f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        shootEffect = withdrawShootEffect;
                        fragBullets = 4;
                        fragBullet = new BasicBulletType(2f, 30, "fb-dynamics-malachite-chunk") {{
                        hitColor = trailColor = DynamicsPal.malachite;
                        height = 7;
                        width = 5;
                        trailWidth = 0.9f;
                        trailLength = 5;
                        homingPower = 0.4f;
                        homingDelay = 4f;
                        homingRange = 50f;
                        spin = 3.5f;
                        sticky = true;
                        stickyExtraLifetime = 20f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        }};
                    }}
            );
            //thx nullevoy for sprite
        }};
    }
}
