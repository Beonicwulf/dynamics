package dynamics.content;

import dynamics.graphics.DynamicsPal;
import mindustry.type.Liquid;

public class DynamicsLiquids {
    public static Liquid steam;

    public static void load() {
        steam = new Liquid("steam", DynamicsPal.steam) {{
            temperature = 0.7f;
            gas = true;
            explosiveness = 0.5f;
        }};
    }
}
