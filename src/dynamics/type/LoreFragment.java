package dynamics.type;

import arc.Core;
import arc.graphics.Color;
import mindustry.type.Item;

public class LoreFragment extends Item {
    public LoreFragment(String name, Color color, String tag){
        super(name);
        databaseCategory = "lore-fragment";
        this.color = color;
        this.databaseTag = tag;
        this.localizedName = Core.bundle.get("lore." + this.name + ".name", this.name);
        this.description = Core.bundle.getOrNull("lore." + this.name + ".description");
        this.details = Core.bundle.getOrNull("lore." + this.name + ".details");
        this.credit = Core.bundle.getOrNull("lore." + this.name + ".credit");
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
