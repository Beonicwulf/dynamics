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
                    DynamicsItems.malachite, new BasicBulletType(3f, 30, "malachite-chunk-big") {{
                        hitColor = trailColor = DynamicsPal.malachite;
                        trailWidth = 0.4f;
                        trailLength = 4;
                        ammoMultiplier = 3;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        shootEffect = withdrawShootEffect;
                        fragBullets = 4;
                        fragBullet = new BasicBulletType(3f, 20, "malachite-chunk") {{
                        hitColor = trailColor = DynamicsPal.malachite;
                        trailWidth = 0.2f;
                        trailLength = 2;
                        homingPower = 0.4f;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        }};
                    }}
            );
            //thx nullevoy for sprite
        }};
    }
}
