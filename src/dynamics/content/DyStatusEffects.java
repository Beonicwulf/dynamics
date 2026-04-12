package dynamics.content;

import dynamics.graphics.DyPal;
import mindustry.content.Fx;
import mindustry.type.StatusEffect;

public class DyStatusEffects {
    public static StatusEffect shielding, corroding;
    public static void load() {
        shielding = new StatusEffect("shielding"){{color = DyPal.hotSpringWater;}};
        corroding = new StatusEffect("corroding"){{
            color = DyPal.steamSulfur;
            damage = 0.05f;
            effect = Fx.none;
            speedMultiplier = 0.8f;
            reloadMultiplier = 0.8f;
            init(() -> opposite(shielding));
        }};
    }
}
