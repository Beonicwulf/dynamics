package dynamics.content;

import arc.graphics.*;
import arc.struct.*;

import mindustry.type.*;

public class DynamicsItems {
    public static Item
            /* Resources */
            zinc, tantalum
            ;

    public static final Seq<Item> dynamicsItems = new Seq<>();

    public static void load() {
        zinc = new Item("zinc", Color.valueOf("#b09f74")) {{
            cost = 2;
            hardness = 1;
        }};
        tantalum = new Item("tantalum", Color.valueOf("#606d90")) {{
            cost = 3;
            hardness = 4;
        }};

        dynamicsItems.addAll(
                zinc, tantalum
        );
    }
}