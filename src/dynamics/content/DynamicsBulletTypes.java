package dynamics.content;

import dynamics.graphics.DynamicsPal;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.effect.MultiEffect;

public class DynamicsBulletTypes {
    public static BulletType
            malachiteShards, malachiteFrag, healingShards, coreShards
            ;

    public static void load() {
        Effect withdrawShootEffect = new MultiEffect(Fx.drillSteam, Fx.colorSparkBig);

        malachiteShards = new BasicBulletType(2f, 30, "fb-dynamics-malachite-chunk") {{
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

        coreShards = malachiteShards.copy();
        coreShards.homingDelay = 15f;
        coreShards.homingPower = 0.3f;
        coreShards.lifetime = 40;
        coreShards.speed = 4;
        coreShards.damage = 40;

        malachiteFrag = new BasicBulletType(2.5f, 15, "fb-dynamics-malachite-chunk-big") {{
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
            fragBullet = DynamicsBulletTypes.malachiteShards;
        }};

        healingShards = malachiteShards.copy();
        healingShards.keepVelocity = false;
        healingShards.hitEffect = healingShards.despawnEffect = Fx.hitLaser;
        healingShards.hitColor = healingShards.trailColor = DynamicsPal.malachite;
        healingShards.healPercent = 5.5f;
        healingShards.collidesTeam = true;
        healingShards.reflectable = false;
    }
}
