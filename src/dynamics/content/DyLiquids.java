package dynamics.content;

import dynamics.graphics.DyPal;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class DyLiquids {
    public static Liquid steam, flux, hotSpringWater,purifiedWater;
    public static void load() {
        flux = new Liquid("flux", DyPal.flux) {{
            gas = true;
            lightColor = DyPal.fluxLight.a(0.2f);
            explosiveness = 0.5f;
        }};
        hotSpringWater = new Liquid("hot-spring-water", DyPal.hotSpringWater) {{
            heatCapacity = 0.3f;
            effect = StatusEffects.wet;
            boilPoint = 0.4f;
            gasColor = DyPal.steamSulfur;
        }};
        purifiedWater = new Liquid("purified-water", DyPal.purifiedWater) {{
            heatCapacity = 0.35f;
            effect = StatusEffects.wet;
            boilPoint = 0.45f;
            gasColor = DyPal.steamLight;
        }};
    }
}
