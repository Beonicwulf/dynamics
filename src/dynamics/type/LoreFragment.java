package dynamics.type;

import arc.Core;
import arc.graphics.Color;
import mindustry.type.Item;

public class LoreFragment extends Item {
    public LoreFragment(String name, Color color, String tag){
        super(name);
        databaseCategory = "lore-fragment";
        color = color;
        databaseTag = tag;
        localizedName = Core.bundle.get("lore." + name + ".name", name);
        description = Core.bundle.getOrNull("lore." name + ".description");
        details = Core.bundle.getOrNull("lore." + name + ".details");
        credit = Core.bundle.getOrNull("lore." + name + ".credit");
    }
    public LoreFragment(String name, Color color){
        this(name, color, "test");
    }
    public LoreFragment(String name){
        this(name, new Color(Color.black));
    }

    @Override
    public void setStats(){}
}
