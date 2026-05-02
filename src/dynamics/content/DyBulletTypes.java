package dynamics.content;

import dynamics.graphics.DyPal;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WrapEffect;

public class DyBulletTypes {
    public static BulletType
            // malachite
            stickyShard, malachiteShards,
            // turrets
            malachiteFrag,
            // units
            healingShards, coreShards, tankShard,
            // Steam Valve
            steamBlast;
    public static void load() {

        // Sticky Cosmetic
        stickyShard = new BasicBulletType(4f, 0, "dy-malachite-chunk") {{
            height = 6;
            width = 6;
            homingPower = 1f;
            sticky = true;
            stickyExtraLifetime = 75f;
            lifetime = 1f;
            hitEffect = despawnEffect = Fx.none;
        }};
        // Homing Small
        malachiteShards = new BasicBulletType(2f, 15, "dy-malachite-chunk") {{
            hitColor = trailColor = DyPal.malachite;
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
        // Breathe
        coreShards = malachiteShards.copy();
        coreShards.homingDelay = 15f;
        coreShards.homingPower = 0.3f;
        coreShards.lifetime = 40;
        coreShards.speed = 4;
        // Split
        tankShard = coreShards.copy();
        tankShard.speed = 3;
        tankShard.lifetime = 60;
        tankShard.damage = coreShards.damage + 20;
        // Withdraw
        malachiteFrag = new BasicBulletType(2.5f, 20, "dy-malachite-chunk-big") {{
            hitColor = DyPal.malachite;
            trailColor = DyPal.flux;
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
            shootEffect = DyFX.withdrawShootEffect;
            fragBullets = 4;
            fragBullet = DyBulletTypes.malachiteShards;
        }};
        // Tusk
        healingShards = malachiteShards.copy();
        healingShards.hitEffect = healingShards.despawnEffect = Fx.hitLaser;
        healingShards.hitColor = healingShards.trailColor = DyPal.malachite;
        healingShards.collidesTeam = true;
        healingShards.healPercent = healingShards.homingPower = 5.5f;
        healingShards.reflectable = healingShards.keepVelocity = false;
        healingShards.damage = 0;
        // Steam Valve
        steamBlast = new BasicBulletType(1.2f, 10) {{
            targetBlocks = false;
            knockback = 12f;
            width = 25f;
            hitSize = 7f;
            height = 20f;
            shootEffect = Fx.shootBigColor;
            smokeEffect = Fx.shootSmokeSquareSparse;
            hitColor = backColor = trailColor = DyPal.flux;
            frontColor = DyPal.fluxLight;
            trailWidth = 6f;
            trailLength = 3;
            hitEffect = despawnEffect = Fx.hitSquaresColor;
            lifetime = 30f;
        }};
    }
}
