package dynamics.content;

import dynamics.graphics.DynamicsPal;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.effect.MultiEffect;

public class DyBulletTypes {
    public static BulletType
            malachiteShards, malachiteFrag, healingShards, coreShards, stickyShard, tankShard,
            steamBlast
            ;

    public static void load() {
        Effect withdrawShootEffect = new MultiEffect(Fx.drillSteam, Fx.colorSparkBig);

        stickyShard = new BasicBulletType(4f, 0, "fb-dynamics-malachite-chunk") {{
            height = 6;
            width = 6;
            homingPower = 1f;
            sticky = true;
            stickyExtraLifetime = 75f;
            lifetime = 1f;
            hitEffect = despawnEffect = Fx.none;
        }};

        malachiteShards = new BasicBulletType(2f, 10, "fb-dynamics-malachite-chunk") {{
            hitColor = trailColor = DynamicsPal.malachite;
            height = 7;
            width = 5;
            trailWidth = 0.9f;
            trailLength = 5;
            homingPower = 0.4f;
            homingDelay = 4f;
            homingRange = 50f;
            spin = 3.5f;
            hitEffect = despawnEffect = Fx.hitBulletColor;
            fragBullets = 1;
            fragBullet = DyBulletTypes.stickyShard;
        }};

        coreShards = malachiteShards.copy();
        coreShards.homingDelay = 15f;
        coreShards.homingPower = 0.3f;
        coreShards.lifetime = 40;
        coreShards.speed = 4;

        tankShard = coreShards.copy();
        tankShard.speed = 3;
        tankShard.lifetime = 60;
        tankShard.damage = 30;

        malachiteFrag = new BasicBulletType(2.5f, 20, "fb-dynamics-malachite-chunk-big") {{
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
            fragBullet = DyBulletTypes.malachiteShards;
        }};

        healingShards = malachiteShards.copy();
        healingShards.hitEffect = healingShards.despawnEffect = Fx.hitLaser;
        healingShards.hitColor = healingShards.trailColor = DynamicsPal.malachite;
        healingShards.collidesTeam = true;
        healingShards.healPercent = healingShards.homingPower = 5.5f;
        healingShards.reflectable = healingShards.keepVelocity = false;
        healingShards.damage = 0;

        steamBlast = new BasicBulletType(1.2f, 10) {{
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
            lifetime = 30f;
        }};
    }
}
