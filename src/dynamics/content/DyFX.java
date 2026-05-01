package dynamics.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.math.Rand;
import dynamics.graphics.DyPal;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WrapEffect;

import static arc.math.Angles.randLenVectors;

public class DyFX {
    public static final Rand rand = new Rand();
    public static Effect
            geyserFx = new Effect(180f, f -> {
                rand.setSeed(f.id);
                for(int i = 0; i < 12; i++){
                    f.scaled(f.lifetime * rand.random(0.8f, 1), e -> {
                        Draw.color(Color.white.cpy().a(0.5f), Color.white.cpy().a(0), e.fin());
                        randLenVectors(e.id, 3, 120 * rand.random(0.5f, 1.5f) * e.fin(), e.rotation + 72, rand.random(12), (x, y) -> Fill.circle(e.x + x, e.y + y, rand.random(5f, 8f) * e.fslope()));
                    });
                }
            }),
            withdrawShootEffect = new MultiEffect(new WrapEffect(Fx.drillSteam, DyPal.flux), Fx.colorSparkBig);
}
