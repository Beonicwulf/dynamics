package dynamics.content;

import arc.graphics.*;
import arc.struct.*;

import mindustry.type.*;

public class DynamicsItems {
    public static Item
            // resources
            zinc, malachite, cinnabar, tantalum,
            // crafted
            partBasic, sublime
            ;

    public static final Seq<Item> dynamicsItems = new Seq<>();

    public static void load() {
        zinc = new Item("zinc", Color.valueOf("#aa996e")) {{
            cost = 1;
            hardness = 1;
            alwaysUnlocked = true;
            healthScaling = 0.1f;
        }};
        malachite = new Item("malachite", Color.valueOf("#356a46")) {{
            cost = 1.2f;
            hardness = 1;
            charge = 0.3f;
        }};
        cinnabar = new Item("cinnabar", Color.valueOf("784132")) {{
            hardness = 2;
            buildable = false;
        }};
        tantalum = new Item("tantalum", Color.valueOf("#606d90")) {{
            cost = 1.5f;
            hardness = 4;
            healthScaling = 0.6f;
        }};
        partBasic = new Item("part-basic", Color.valueOf("#aa996e")) {{
            cost = 5;
            healthScaling = 3.5f;
        }};
        sublime = new Item("sublime", Color.valueOf("#b7cbd0")) {{
            cost = 2;
            flammability = 0.4f;
            explosiveness = 0.4f;
        }};

        dynamicsItems.addAll(
                zinc, tantalum, partBasic, sublime, malachite, cinnabar
        );
    }
}