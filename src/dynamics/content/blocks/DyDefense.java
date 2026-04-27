package dynamics.content.blocks;

import dynamics.content.DyBulletTypes;
import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.graphics.DrawPress;
import dynamics.graphics.DyPal;
import mindustry.content.Fx;
import mindustry.entities.effect.WrapEffect;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class DyDefense {
    public static Block
            // defense
            steamValve,
            // turrets
            withdraw;
    public static void load(){
        steamValve = new LiquidTurret("steam-valve") {{
            requirements(Category.defense, with(DyItems.zinc, 20, DyItems.malachite, 5));
            size = 2;
            health = 1380; //should replace with scaledHealth? needs testing
            ammo(DyLiquids.flux, DyBulletTypes.steamBlast);
            drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-base"), new DrawLiquidRegion(), new DrawRegion("-rotator", 2f), new DrawRegion("-top"), new DrawPress("-press"));
            shootEffect = Fx.drillSteam;
            recoil = 0f;
            reload = 180f;
            rotateSpeed = 0f;
            heatRequirement = 3f;
            maxHeatEfficiency = 1f;
            liquidCapacity = 10f;
            shootCone = 360f;
            range = 32;
            shootY = 0;
            shoot = new ShootSpread(20, 18f);
            researchCost = with(DyItems.zinc, 20 * 5, DyItems.malachite, 5 * 5);
        }};
        withdraw = new ItemTurret("withdraw") {{
            requirements(Category.turret, with(DyItems.zinc, 100, DyItems.partBasic, 10));
            targetAir = true;
            size = 3;
            hasPower = false;
            recoil = 2;
            reload = 120f;
            range = 180;
            ammoUseEffect = new WrapEffect(Fx.drillSteam, DyPal.flux);
            shootSound = Sounds.shootBreach;
            targetUnderBlocks = false;
            shootCone = 25;
            rotateSpeed = 3.8f;
            maxAmmo = 24;
            ammoPerShot = 1;
            shootY = 7;
            heatRequirement = 4f;
            maxHeatEfficiency = 1f;
            ammo(DyItems.malachite, DyBulletTypes.malachiteFrag);
            //thx nullevoy for sprite
            researchCost = with(DyItems.zinc, 100 * 5, DyItems.partBasic, 10 * 5);
        }};
    }
}
