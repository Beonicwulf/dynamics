package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;

public class DynamicsEnvironment {
    public static Block
            // ores
            oreZinc, oreMalachite
            ;

    public static void load() {
        // ores
        oreZinc = new OreBlock("ore-zinc", DynamicsItems.zinc) {{
            variants = 4;
        }};
        oreMalachite = new OreBlock("ore-malachite", DynamicsItems.malachite) {{
            variants = 5;
        }};
    }
}
