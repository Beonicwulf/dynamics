package dynamics.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class DynamicsLiquids {
    public static Liquid steam;

    public static void load() {
        steam = new Liquid("steam", Color.valueOf("#d6eaf3")) {{
            temperature = 0.7f;
            gas = true;
        }};
    }
}
