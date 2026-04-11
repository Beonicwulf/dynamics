package dynamics.content;

import dynamics.graphics.DyPal;
import mindustry.content.StatusEffects;
import mindustry.gen.Sounds;
import mindustry.type.Weather;
import mindustry.type.weather.RainWeather;
import mindustry.world.meta.Attribute;

public class DyWeathers {
    public static Weather
            sulfurRain
            ;

    public static void load() {
        sulfurRain = new RainWeather("sulfur-rain") {{
            attrs.set(Attribute.light, -0.2f);
            status = StatusEffects.corroded;
            sound = Sounds.rain;
            soundVol = 0.25f;
            liquid = DyLiquids.hotSpringWater;
            color = DyPal.steamSulfur;
        }};
    }
}
