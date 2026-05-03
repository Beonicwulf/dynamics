package dynamics.content.blocks;

import arc.graphics.Color;
import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.content.DyStatusEffects;
import dynamics.graphics.DyPal;
import mindustry.entities.bullet.ContinuousFlameBulletType;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ContinuousLiquidTurret;

import static mindustry.type.ItemStack.with;

public class DyDecorative {
    public static Block brazier;
    public static void load(){
        brazier = new ContinuousLiquidTurret("brazier") {{
            requirements(Category.effect, with(DyItems.zinc, 15, DyItems.malachite, 5));
            researchCost = ItemStack.mult(requirements, 100);
            liquidCapacity = 10f;
            liquidConsumed = 0.5f / 60f;
            alwaysShooting = true;
            rotateSpeed = 0f;
            loopSound = Sounds.shootSublimate;
            shootSound = Sounds.none;
            loopSoundVolume = 0.05f;
            shootY = -1f;
            recoil = 0f;
            ammo(
                    DyLiquids.flux, new ContinuousFlameBulletType(){{
                        damage = 1f;
                        length = 10;
                        knockback = 1f;
                        pierceCap = 2;
                        timescaleDamage = true;

                        colors = new Color[]{DyPal.copperBurnThree.a(0.55f), DyPal.copperBurnTwo.a(0.7f), DyPal.copperBurnOne.a(0.8f), Color.white};
                        lightColor = flareColor = DyPal.copperBurnTwo;
                        flareLength = 5;
                        lightStroke = length * length;
                    }},
                    DyLiquids.chlorine, new ContinuousFlameBulletType(){{
                        damage = 1f;
                        length = 15;
                        knockback = 1f;
                        pierceCap = 2;
                        timescaleDamage = true;
                        status = DyStatusEffects.corroding;

                        colors = new Color[]{DyPal.chlorine.a(0.55f), DyPal.flux.a(0.7f), DyPal.fluxLight.a(0.8f), Color.white};
                        lightColor = flareColor = DyPal.chlorine;
                        flareLength = 8;
                        lightStroke = length * length;
                    }}
            );
        }};
    }
}
