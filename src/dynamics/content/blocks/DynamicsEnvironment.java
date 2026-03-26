package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import mindustry.content.Liquids;
import mindustry.graphics.CacheLayer;
import mindustry.world.Block;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.Attribute;

import static mindustry.content.Blocks.rhyolite;

public class DynamicsEnvironment {
    public static Block
            // ores
            oreZinc, oreMalachite,
            // metal
            phWall, phTile, phAutotile,
            // rhyolite
            rhyoliteWater, rhyoliteVentWater

            ;

    public static void load() {
        // ores
        oreZinc = new OreBlock("ore-zinc", DynamicsItems.zinc) {{
            variants = 4;
        }};
        oreMalachite = new OreBlock("ore-malachite", DynamicsItems.malachite) {{
            variants = 5;
        }};
        // metal
        phWall = new StaticWall("ph-wall");
        phTile = new Floor("ph-tile");
        phAutotile = new StaticWall("ph-autotile") {{
            autotile = true;
        }};
        // rhyolite
        rhyoliteWater = new Floor("rhyolite-water"){{
            variants = 3;
            shallow = true;
            liquidDrop = Liquids.water;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};
        rhyoliteVentWater = new SteamVent("rhyolite-vent-water"){{
            parent = blendGroup = rhyolite;
            attributes.set(Attribute.steam, 1f);
            variants = 2;
            shallow = true;
            liquidDrop = Liquids.water;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};
    }
}
