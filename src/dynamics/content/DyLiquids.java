package dynamics.content;

import dynamics.graphics.DynamicsPal;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class DyLiquids {
    public static Liquid
            steam, hotSpringWater, purifiedWater
            ;

    public static void load() {
        steam = new Liquid("steam", DynamicsPal.steam) {{
            temperature = 0.7f;
            gas = true;
            explosiveness = 0.5f;
        }};
        hotSpringWater = new Liquid("hot-spring-water", DynamicsPal.hotSpringWater) {{
            heatCapacity = 0.3f;
            effect = StatusEffects.wet;
            boilPoint = 0.4f;
            gasColor = DynamicsPal.steamSulfur;
        }};
        purifiedWater = new Liquid("purified-water", DynamicsPal.purifiedWater) {{
            heatCapacity = 0.4f;
            effect = StatusEffects.wet;
            boilPoint = 0.5f;
            gasColor = DynamicsPal.steamLight;
        }};
    }
}
