package dynamics.content.blocks;

import dynamics.content.DynamicsBulletTypes;
import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsLiquids;
import dynamics.graphics.*;
import mindustry.content.Fx;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class DynamicsDefense {
    public static Block
            withdraw, steamValve
            ;

    public static void load(){

        steamValve = new LiquidTurret("steam-valve") {{
            requirements(Category.defense, with(DynamicsItems.zinc, 24, DynamicsItems.partBasic, 1));
            size = 2;
            health = 1380; //should replace with scaledHealth? needs testing
            ammo(
                    DynamicsLiquids.steam, DynamicsBulletTypes.steamBlast
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
            researchCost = with(DynamicsItems.zinc, 24 * 5, DynamicsItems.partBasic, 5);
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
                    DynamicsItems.malachite, DynamicsBulletTypes.malachiteFrag
            );
            //thx nullevoy for sprite
            researchCost = with(DynamicsItems.zinc, 100 * 5, DynamicsItems.partBasic, 10 * 5);
        }};
    }
}
