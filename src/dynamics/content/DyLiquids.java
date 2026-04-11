package dynamics.content;

import dynamics.graphics.DyPal;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class DyLiquids {
    public static Liquid
            steam, hotSpringWater, purifiedWater
            ;

    public static void load() {
        steam = new Liquid("steam", DyPal.steam) {{
            temperature = 0.7f;
            gas = true;
            explosiveness = 0.5f;
        }};
        hotSpringWater = new Liquid("hot-spring-water", DyPal.hotSpringWater) {{
            heatCapacity = 0.3f;
            effect = StatusEffects.wet;
            boilPoint = 0.4f;
            gasColor = DyPal.steamSulfur;
        }};
        purifiedWater = new Liquid("purified-water", DyPal.purifiedWater) {{
            heatCapacity = 0.4f;
            effect = StatusEffects.wet;
            boilPoint = 0.5f;
            gasColor = DyPal.steamLight;
        }};
    }
}
