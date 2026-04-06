package dynamics.content;

import dynamics.graphics.DynamicsPal;
import mindustry.content.StatusEffects;
import mindustry.gen.Sounds;
import mindustry.type.Weather;
import mindustry.type.weather.RainWeather;
import mindustry.world.meta.Attribute;

public class DynamicsWeathers {
    public static Weather
            sulfurRain
            ;

    public static void load() {
        sulfurRain = new RainWeather("sulfur-rain") {{
            attrs.set(Attribute.light, -0.2f);
            status = StatusEffects.corroded;
            sound = Sounds.rain;
            soundVol = 0.25f;
            liquid = DynamicsLiquids.hotSpringWater;
            color = DynamicsPal.steamSulfur;
        }};
    }
}
