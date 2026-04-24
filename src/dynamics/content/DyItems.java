package dynamics.content;

import arc.struct.*;

import dynamics.graphics.DyPal;
import mindustry.type.*;

public class DyItems {
    public static Item
            // resources
            zinc, malachite,
            // components
            partBasic;
    public static final Seq<Item> dynamicsItems = new Seq<>();
    public static void load() {
        zinc = new Item("zinc", DyPal.zinc) {{
            cost = 1;
            hardness = 1;
            alwaysUnlocked = true;
            healthScaling = 0.1f;
        }};
        malachite = new Item("malachite", DyPal.malachite) {{
            cost = 1.2f;
            hardness = 1;
            charge = 0.3f;
        }};
        partBasic = new Item("part-basic", DyPal.component) {{
            cost = 5;
            healthScaling = 3f;
        }};
        dynamicsItems.addAll(
                zinc, malachite, partBasic
        );
    }
}