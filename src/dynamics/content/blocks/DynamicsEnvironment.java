package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsLiquids;
import mindustry.content.StatusEffects;
import mindustry.graphics.CacheLayer;
import mindustry.world.Block;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.Attribute;

public class DynamicsEnvironment {
    public static Block
            // ores
            oreZinc, oreMalachite,
            // liquids
            deepHotSpringWater,
            // travertine
            travertineFloor, smoothTravertine, brightTravertine,
            shallowTravertine, deepTravertine,
            travertineWall, travertineVent, travertineGeyser,
            // metal
            phWall, phTile, phAutotile,
            // props
            travertineBoulder, shallowTravertineBoulder
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
        // liquids
        deepHotSpringWater = new Floor("deep-hot-spring-water"){{
            speedMultiplier = 0.2f;
            variants = 0;
            liquidDrop = DynamicsLiquids.hotSpringWater;
            liquidMultiplier = 1.5f;
            isLiquid = true;
            status = StatusEffects.wet;
            statusDuration = 120f;
            drownTime = 200f;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};
        // travertine
        travertineFloor = new Floor("travertine-floor") {{
            variants = 6;
        }};
        smoothTravertine = new Floor("smooth-travertine") {{
            variants = 6;
        }};
        brightTravertine = new Floor("bright-travertine") {{
            variants = 6;
        }};
        travertineVent = new SteamVent("travertine-vent"){{
            parent = blendGroup = travertineFloor;
            attributes.set(Attribute.steam, 1f);
            variants = 2;
        }};
        shallowTravertine = new ShallowLiquid("shallow-travertine") {{
            speedMultiplier = 0.8f;
            statusDuration = 50f;
            albedo = 0.9f;
            supportsOverlay = true;
            liquidDrop = DynamicsLiquids.hotSpringWater;
            variants = 4;
        }};
        deepTravertine = new ShallowLiquid("deep-travertine") {{
            speedMultiplier = 0.5f;
            statusDuration = 120f;
            albedo = 0.9f;
            supportsOverlay = true;
            liquidDrop = DynamicsLiquids.hotSpringWater;
            variants = 4;
            drownTime = 200f;
            liquidMultiplier = 1.25f;
        }};
        travertineGeyser = new SteamVent("travertine-geyser") {{
            parent = blendGroup = shallowTravertine;
            attributes.set(Attribute.steam, 1f);
            variants = 2;
            shallow = true;
            liquidDrop = DynamicsLiquids.hotSpringWater;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
        }};
        travertineWall = new StaticWall("travertine-wall") {{
            travertineFloor.asFloor().wall = smoothTravertine.asFloor().wall = brightTravertine.asFloor().wall = shallowTravertine.asFloor().wall = deepTravertine.asFloor().wall = this;
        }};
        travertineBoulder = new Prop("travertine-boulder"){{
            variants = 3;
            travertineFloor.asFloor().decoration = smoothTravertine.asFloor().decoration = brightTravertine.asFloor().decoration = this;
        }};
        shallowTravertineBoulder = new Prop("shallow-travertine-boulder"){{
            variants = 3;
            shallowTravertine.asFloor().decoration = deepTravertine.asFloor().decoration = this;
        }};
    }
}
