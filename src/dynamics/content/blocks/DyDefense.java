package dynamics.content.blocks;

import dynamics.content.DyBullets;
import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.graphics.DrawPress;
import dynamics.graphics.DyPal;
import dynamics.world.blocks.defense.ShardWall;
import mindustry.content.Fx;
import mindustry.entities.effect.WrapEffect;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.draw.*;
import mindustry.world.meta.BuildVisibility;

import static mindustry.type.ItemStack.with;

public class DyDefense {
    public static Block
            // defense
            steamValve,
            // walls
            malachiteWall, malachiteWallLarge, warFrame,
            // turrets
            withdraw;
    public static void load(){
        steamValve = new LiquidTurret("steam-valve") {{
            requirements(Category.defense, BuildVisibility.sandboxOnly, with(DyItems.zinc, 20, DyItems.malachite, 5));
            researchCost = ItemStack.mult(requirements, 50);
            size = 2;
            health = 1380; //should replace with scaledHealth? needs testing
            ammo(DyLiquids.flux, DyBullets.steamBlast);
            drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-base"), new DrawLiquidRegion(), new DrawRegion("-rotator", 2f), new DrawRegion("-top"), new DrawPress("-press"));
            shootEffect = Fx.drillSteam;
            recoil = 0f;
            reload = 60f;
            rotateSpeed = 0f;
            //heatRequirement = 3f; maxHeatEfficiency = 1f;
            liquidCapacity = 10f;
            shootCone = 360f;
            range = 32;
            shootY = 0;
            shoot = new ShootSpread(20, 18f);
        }};
        withdraw = new ItemTurret("withdraw") {{
            requirements(Category.turret, with(DyItems.zinc, 100, DyItems.partBasic, 10));
            researchCost = ItemStack.mult(requirements, 50);
            targetAir = true;
            size = 3;
            hasPower = false;
            recoil = 2;
            reload = 20f;
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
            ammo(DyItems.malachite, DyBullets.malachiteFrag);
            //thx nullevoy for sprite
        }};
        malachiteWall = new ShardWall("malachite-wall") {{
            requirements(Category.defense, with(DyItems.malachite, 10));
            researchCost = ItemStack.mult(requirements, 50);
            health = 345;
            shardChance = 0.05f;
        }};
        malachiteWallLarge = new ShardWall("malachite-wall-large") {{
            requirements(Category.defense, BuildVisibility.sandboxOnly, ItemStack.mult(malachiteWall.requirements, 4));
            researchCost = ItemStack.mult(requirements, 50);
            health = malachiteWall.health * 4;
            shardChance = 0.05f;
            size = 2;
        }};
        warFrame = new ShardWall("framed-malachite") {{
            requirements(Category.defense, with(DyItems.malachite, 60, DyItems.sodium, 10));
            researchCost = ItemStack.mult(requirements, 50);
            health = malachiteWall.health * 9 + 400;
            shardChance = 0.1f;
            size = 3;
        }};
    }
}
