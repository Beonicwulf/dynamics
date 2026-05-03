package dynamics.content;

import arc.math.geom.Rect;
import arc.struct.Seq;
import mindustry.ai.UnitCommand;
import mindustry.ai.types.AssemblerAI;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.entities.part.DrawPart;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class DyUnits {
    public static Weapon
            // core units
            augerBolt, breatheWeapon,
            // tank
            splitWeapon,
            // copter
            emberSideGuns
            ;
    public static UnitType
            // core units
            augerDrone, breathe,
            // tank
            split,
            // assembler
            augerAssembler,
            // copter
            ember
            ;
    public static void loadWeapons() {
        augerBolt = new Weapon("auger-bolt"){{
            top = false;
            reload = 30f;
            ejectEffect = Fx.none;
            recoil = 2f;
            velocityRnd = 0.5f;
            inaccuracy = 15f;
            alternate = true;
            bullet = DyBullets.healingShards;
        }};
        breatheWeapon = new Weapon("breathe-weapon"){{
            x = y = -2f;
            reload = 40;
            inaccuracy = 10;
            minWarmup = 0.15f;
            bullet = DyBullets.coreShards;
            shoot = new ShootPattern() {{
                shots = 3;
                shotDelay = 5;
            }};
        }};
        splitWeapon = new Weapon("dy-split-gun") {{
            layerOffset = 0.0001f;
            x = 3.25f;
            y = -2.75f;
            reload = 40;
            recoil = 1f;
            mirror = true;
            bullet = DyBullets.tankShard;
            rotate = true;
            rotateSpeed = 3;
        }};
        emberSideGuns = new Weapon("dy-ember-side-gun") {{
            x = y = 0;
            mirror = true;
            reload = 40;
            recoil = 2f;
            inaccuracy = 5;
            minWarmup = 0.35f;
            shoot = new ShootAlternate() {{
                shots = 2;
                shotDelay = 10;
            }};
            bullet = DyBullets.sodiumBullet;
            shootX = 4f;
        }};
    }
    public static void load() {
        float coreFleeRange = 500f;
        loadWeapons();
        augerDrone = new UnitType("auger-drone"){{
            defaultCommand = UnitCommand.repairCommand;
            constructor = BuildingTetherPayloadUnit::create;
            outlines = false;
            createWreck = useUnitCap = false;
            flying = true;
            drag = 0.06f;
            accel = 0.12f;
            speed = 1.5f;
            health = 100;
            engineSize = 1.8f;
            engineOffset = 5.2f;
            range = 50f;
            isEnemy = false;
            wreckSoundVolume = deathSoundVolume = 0.7f;

            mineTier = 1;
            mineSpeed = 2.5f;
            mineItems = Seq.with(DyItems.zinc, DyItems.malachite);

            lifetime = 60f * 40f;
            targetAir  = false;
            targetGround = false;

            weapons.add(augerBolt);
        }};
        // sprite by aerodynamic_attorney

        breathe = new UnitType("breathe") {{
            controller = u -> new BuilderAI(true, coreFleeRange);
            constructor = LegsUnit::create;
            coreUnitDock = true;
            isEnemy = false;
            outlines = false;
            hitSize = 9;
            speed = 1.3f;
            health = 300;
            lockLegBase = true;
            armor = mineTier = 1;
            mineWalls = mineFloor = true;
            mineSpeed = 6.5f;
            buildSpeed = 1.2f;
            rotateSpeed = 4;
            itemCapacity = 40;
            groundLayer = Layer.legUnit - 1f;
            flying = false;
            //mineItems = Seq.with(DyItems.zinc, DyItems.malachite);
            stepShake = 0.01f;
            legStraightness = 0.3f;
            legCount = 6;
            legLength = 11f;
            legContinuousMove = true;
            legExtension = -4f;
            legBaseOffset = 4f;
            legMaxLength = 1.1f;
            legMinLength = 0.3f;
            legLengthScl = 0.96f;
            legForwardScl = 0.9f;
            legGroupSize = 3;
            rippleScale = 0.2f;
            legMoveSpace = 1;
            allowLegStep = true;
            legPhysicsLayer = false;
            shadowElevation = 0.1f;
            weapons.add(breatheWeapon);
        }};
        // sprite by aerodynamic_attorney

        split = new UnitType("split") {{
            constructor = TankUnit::create;
            outlines = false;
            rotateMoveFirst = true;
            squareShape = true;
            faceTarget = omniMovement = false;
            rotateSpeed = 2;
            floorMultiplier = 1.5f;
            speed = 0.7f;
            hitSize = 10;
            health = 420;
            armor = 5;
            itemCapacity = 0;
            treadPullOffset = 3;
            treadRects = new Rect[] {new Rect(-13f, -21f, 26, 42)};
            weapons.add(splitWeapon);
            researchCostMultiplier = 0f;
        }};
        // sprite by aerodynamic_attorney

        augerAssembler = new UnitType("auger-assembler") {{
            constructor = BuildingTetherPayloadUnit::create;
            controller = u -> new AssemblerAI();

            flying = true;
            drag = 0.06f;
            accel = 0.11f;
            speed = 1.3f;
            health = 90;
            engineSize = 1.4f;
            engineOffset = 4.1f;
            payloadCapacity = 0f;
            targetable = bounded = isEnemy = useUnitCap = logicControllable = playerControllable = allowedInPayloads = createWreck = false;

            outlines = false;
            hidden = true;
        }};
        // sprite by aerodynamic_attorney

        ember = new UnitType("ember"){{
            constructor = UnitEntity::create;
            flying = true;
            engineSize = 0;
            outlines = false;
            weapons.add(emberSideGuns);
            targetGround = targetAir = true;
            drag = 0.06f;
            accel = 0.12f;
            speed = 2f;
            health = 420f;
            parts.addAll(
                    new RegionPart("-blade"){{
                        outline = false;
                        moveRot = 3600f;
                        progress = DrawPart.PartProgress.time.loop(360);
                    }},
                    new RegionPart("-blade"){{
                        outline = false;
                        moveRot = 3600f;
                        progress = DrawPart.PartProgress.time.loop(360);
                        rotation = -120f;
                    }},
                    new RegionPart("-blade"){{
                        outline = false;
                        moveRot = 3600f;
                        progress = DrawPart.PartProgress.time.loop(360);
                        rotation = -240f;
                    }},
                    new RegionPart("-top")
            );
        }};
        // thanks a lot uujuju for help with weapon parts,
        // and thanks, aerodynamic_attorney for the sprites
    }
}

/* REFERENCE
              "flying": UnitEntity::create
              "mech": MechUnit::create
              "legs": LegsUnit::create
              "naval": UnitWaterMove::create
              "payload": PayloadUnit::create
              "missile": TimedKillUnit::create
              "tank": TankUnit::create
              "hover": ElevationMoveUnit::create
              "tether": BuildingTetherPayloadUnit::create
              "crawl": CrawlUnit::create
*/