package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsLiquids;
import dynamics.graphics.*;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class DynamicsTurrets {
    public static Block
            withdraw, steamValve
            ;

    public static void load(){
        Effect withdrawShootEffect = new MultiEffect(Fx.drillSteam, Fx.colorSparkBig);

        steamValve = new LiquidTurret("steam-valve") {{
            requirements(Category.defense, with(DynamicsItems.zinc, 24, DynamicsItems.partBasic, 1));
            size = 2;
            health = 1380; //should replace with scaledHealth? needs testing
            ammo(
                    DynamicsLiquids.steam, new BasicBulletType(0.6f, 10) {{
                        targetBlocks = false;
                        knockback = 12f;
                        width = 25f;
                        hitSize = 7f;
                        height = 20f;
                        shootEffect = Fx.shootBigColor;
                        smokeEffect = Fx.shootSmokeSquareSparse;
                        hitColor = backColor = trailColor = DynamicsPal.steam;
                        frontColor = DynamicsPal.steamLight;
                        trailWidth = 6f;
                        trailLength = 3;
                        hitEffect = despawnEffect = Fx.hitSquaresColor;

                    }}
            );
            drawer = new DrawMulti(
                    new DrawDefault(), new DrawRegion("-base"), new DrawLiquidRegion(), new DrawRegion("-rotator", 2f), new DrawRegion("-top"), new DrawPress("-press")
            );
            shootEffect = Fx.drillSteam;
            recoil = 0f;
            reload = 90f;
            liquidCapacity = 10f;
            shootCone = 360f;
            range = 32;
            shootY = 0;
            shoot = new ShootSpread(30, 12f);
        }};

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
                        hitColor = DynamicsPal.malachite;
                        trailColor = DynamicsPal.steam;
                        height = 11;
                        width = 9;
                        trailWidth = 1.3f;
                        trailLength = 9;
                        ammoMultiplier = 3;
                        lifetime = 60f;
                        spin = 2.5f;
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
