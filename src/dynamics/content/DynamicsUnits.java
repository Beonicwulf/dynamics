package dynamics.content;

import arc.struct.Seq;
import dynamics.graphics.DynamicsPal;
import mindustry.ai.UnitCommand;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class DynamicsUnits {
    public static Weapon
            augerBolt
            ;

    public static UnitType
            augerDrone
            ;

    private static void loadWeapon() {
        augerBolt = new Weapon("fb-dynamics-auger-bolt"){{
        top = false;
        reload = 30f;
        ejectEffect = Fx.none;
        recoil = 2f;
        velocityRnd = 0.5f;
        inaccuracy = 15f;
        alternate = true;

        bullet = new BasicBulletType(2f, 0, "fb-dynamics-malachite-chunk"){{
            keepVelocity = false;
            hitEffect = despawnEffect = Fx.hitLaser;
            hitColor = trailColor = DynamicsPal.malachite;
            shootEffect = Fx.drillSteam;

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

            healPercent = 5.5f;
            collidesTeam = true;
            reflectable = false;
            }};
        }};
    }

    public static void load() {
        loadWeapon();

        augerDrone = new UnitType("auger-drone"){{
            defaultCommand = UnitCommand.mineCommand;

            flying = true;
            drag = 0.06f;
            accel = 0.12f;
            speed = 1.5f;
            health = 100;
            engineSize = 1.8f;
            engineOffset = 5.7f;
            range = 50f;
            isEnemy = false;
            wreckSoundVolume = deathSoundVolume = 0.7f;

            mineTier = 1;
            mineSpeed = 2.5f;
            mineItems = Seq.with(DynamicsItems.zinc, DynamicsItems.malachite);

            lifetime = 60f * 40f;
            targetAir  = false;
            targetGround = false;

            weapons.add(augerBolt);
        }};
    }
}
