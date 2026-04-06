package dynamics.world.blocks.defense;

import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.BuildVisibility;

public class ComponentBlock extends Wall {
    public ComponentBlock(String name) {
        super(name);
        buildVisibility = BuildVisibility.editorOnly;
        //researchCostMultiplier = 0f;
    }
}
