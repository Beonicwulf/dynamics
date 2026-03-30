package dynamics.content;

import arc.struct.Seq;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class DynamicsUnitTypes {
    public static Weapon
            augerBolt, breatheWeapon
            ;

    public static UnitType
            // core units
            augerDrone, breathe
            ;

    public static void load() {
        float coreFleeRange = 500f;

        augerBolt = new Weapon("auger-bolt"){{
            top = false;
            reload = 30f;
            ejectEffect = Fx.none;
            recoil = 2f;
            velocityRnd = 0.5f;
            inaccuracy = 15f;
            alternate = true;

            bullet = DynamicsBulletTypes.healingShards;
        }};

        breatheWeapon = new Weapon("breathe-weapon"){{
            mirror = false;
            x = y = 0;
            reload = 15;
            inaccuracy = 10;
            minWarmup = 0.05f;
            bullet = DynamicsBulletTypes.coreShards;
        }};

        augerDrone = new UnitType("auger-drone"){{
            defaultCommand = UnitCommand.mineCommand;
            constructor = UnitEntity::create;
            outlines = false;

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
        // sprite by aerodynamic_attorney

        breathe = new UnitType("breathe") {{
            controller = u -> new BuilderAI(true, coreFleeRange);
            constructor = UnitEntity::create;
            coreUnitDock = true;
            isEnemy = false;
            outlines = false;
            hitSize = 9;
            speed = 1.3f;
            health = 300;
            lockLegBase = true;
            armor = mineTier = 1;
            mineWalls = mineFloor = true;
            mineSpeed = 8;
            buildSpeed = 3;
            rotateSpeed = 4;
            itemCapacity = 40;
            groundLayer = 75;
            flying = false;
            //mineItems = Seq.with(DynamicsItems.zinc, DynamicsItems.malachite);
            stepShake = 0.01f;
            legStraightness = 0.3f;
            legCount = 6;
            legLength = 10;
            legContinuousMove = true;
            legExtension = 0f;
            legBaseOffset = 1;
            legMaxLength = 1.1f;
            legMinLength = 0.3f;
            legLengthScl = 0.96f;
            legForwardScl = 1.2f;
            legGroupSize = 3;
            rippleScale = 0.2f;
            legMoveSpace = 1;
            allowLegStep = true;
            legPhysicsLayer = false;
            shadowElevation = 0.1f;
            weapons.add(breatheWeapon);
        }};
        // sprite by aerodynamic_attorney
    }
}
