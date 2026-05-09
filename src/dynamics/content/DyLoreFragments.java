package dynamics.content;

import dynamics.graphics.DyPal;
import dynamics.type.LoreFragment;

public class DyLoreFragments {
    public static LoreFragment spear;
    public static void load(){
        spear = new LoreFragment("spear-and-shield", DyPal.steamLight, "aldheim");
    }
}
