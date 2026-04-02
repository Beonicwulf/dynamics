package dynamics.content;

import arc.graphics.*;
import arc.struct.*;

import dynamics.graphics.DynamicsPal;
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
        zinc = new Item("zinc", DynamicsPal.zinc) {{
            cost = 1;
            hardness = 1;
            alwaysUnlocked = true;
            healthScaling = 0.1f;
        }};
        malachite = new Item("malachite", DynamicsPal.malachite) {{
            cost = 1.2f;
            hardness = 1;
            charge = 0.3f;
        }};
        cinnabar = new Item("cinnabar", DynamicsPal.cinnabar) {{
            hardness = 2;
            buildable = false;
        }};
        tantalum = new Item("tantalum", DynamicsPal.tantalum) {{
            cost = 1.5f;
            hardness = 4;
            healthScaling = 0.6f;
        }};
        partBasic = new Item("part-basic", DynamicsPal.component) {{
            cost = 5;
            healthScaling = 3f;
        }};
        sublime = new Item("sublime", DynamicsPal.sublime) {{
            cost = 2;
            flammability = 0.4f;
            explosiveness = 0.4f;
        }};

        dynamicsItems.addAll(
                zinc, tantalum, partBasic, sublime, malachite, cinnabar
        );
    }
}