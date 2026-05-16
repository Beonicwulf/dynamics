package dynamics.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Interp;
import arc.math.Rand;
import arc.math.geom.Vec2;
import dynamics.graphics.DyPal;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WrapEffect;
import mindustry.graphics.Layer;

import static arc.math.Angles.randLenVectors;

public class DyFX {
    public static final Rand rand = new Rand();
    public static final Vec2 temp = new Vec2();
    public static Effect
            geyserFx = new Effect(180f, 64f, f -> {
                rand.setSeed(f.id);
                for(int i = 0; i < 12; i++){
                    f.scaled(f.lifetime * rand.random(0.8f, 1), e -> {
                        Draw.color(Color.white.cpy().a(0.5f), Color.white.cpy().a(0), e.fin());
                        randLenVectors(e.id, 3, 120 * rand.random(0.5f, 1.5f) * e.fin(), e.rotation + 72, rand.random(12), (x, y) -> Fill.circle(e.x + x, e.y + y, rand.random(5f, 8f) * e.fslope()));
                    });
                }
            }),
    // thanks, @Cirrus for the geyser effect
            withdrawShootEffect = new MultiEffect(new WrapEffect(Fx.drillSteam, DyPal.flux), Fx.colorSparkBig),
            groundCrack = new Effect(150f, 64f, e -> {
                rand.setSeed(e.id);
                Draw.color(e.color, Color.grays(0.2f), Interp.exp10Out.apply(e.fout()));
                for(int j = 0; j < 3; j++) {
                    Vec2 lastPos = new Vec2(e.x, e.y);
                    float lastRot = rand.random(360);

                    for(int i = 0; i < 6; i++) {
                        temp.trns(lastRot, 5).add(lastPos);
                        Lines.stroke((2f - 2f/6f * i) * Interp.exp5Out.apply(e.fout()));
                        Lines.line(lastPos.x, lastPos.y, temp.x, temp.y);
                        lastRot += rand.range(60);
                        lastPos.set(temp);
                    }
                }
            }).layer(Layer.block - 1),
    // thanks, uujuju for groundCrack
            blast = new MultiEffect(Fx.mineImpact, Fx.drillSteam, Fx.mineImpactWave.wrap(DyPal.fluxLight, 40f))
            ;
}
