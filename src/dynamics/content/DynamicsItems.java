package dynamics.content;

import arc.graphics.*;
import arc.struct.*;

import mindustry.type.*;

public class DynamicsItems {
    public static Item
            // Resources
            zinc, tantalum, component
            ;

    public static final Seq<Item> dynamicsItems = new Seq<>();

    public static void load() {
        zinc = new Item("zinc", Color.valueOf("#b09f74")) {{
            cost = 1;
            hardness = 1;
            alwaysUnlocked = true;
            healthScaling = 0.1f;
        }};
        tantalum = new Item("tantalum", Color.valueOf("#606d90")) {{
            cost = 1.5f;
            hardness = 4;
            healthScaling = 0.6f;
        }};
        component = new Item("component", Color.valueOf("#b09f74")) {{
            cost = 2;
        }};

        dynamicsItems.addAll(
                zinc, tantalum, component
        );
    }
}