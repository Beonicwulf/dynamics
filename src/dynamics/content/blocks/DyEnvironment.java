package dynamics.content.blocks;

import dynamics.content.DyAttributes;
import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.graphics.DyPal;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.effect.MultiEffect;
import mindustry.graphics.CacheLayer;
import mindustry.world.Block;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.Attribute;

public class DyEnvironment {
    public static Block
            // ores
            oreZinc, oreMalachite,
            // liquids
            deepHotSpringWater,
            // travertine
            travertineFloor, smoothTravertine, brightTravertine,
            shallowTravertine, deepTravertine,
            travertineWall, travertineVent, travertineGeyser,
            // chalcocite
            chalcociteFloor, gildedChalcocite,
            chalcociteWall, gildedChalcociteWall,
            shallowChalcocite,
            // metal
            phWall, phTile, phConnect,
            // props
            travertineBoulder, shallowTravertineBoulder, azuriteBoulder;
    public static void load() {
        // ores
        oreZinc = new OreBlock("ore-zinc", DyItems.zinc) {{variants = 4;}};
        oreMalachite = new OreBlock("ore-malachite", DyItems.malachite) {{variants = 5;}};
        // metal
        phWall = new StaticWall("ph-wall");
        phTile = new Floor("ph-tile");
        phConnect = new StaticWall("ph-connect"){{autotile = true;}};
        // liquids
        deepHotSpringWater = new Floor("deep-hot-spring-water"){{
            speedMultiplier = 0.2f;
            variants = 0;
            liquidDrop = DyLiquids.hotSpringWater;
            liquidMultiplier = 1.5f;
            isLiquid = true;
            status = StatusEffects.wet;
            statusDuration = 120f;
            drownTime = 200f;
            cacheLayer = CacheLayer.water;
            supportsOverlay = true;
        }};
        // travertine
        // Thank you, amongus2824 for all the Travertine Environment sprites!!!
        travertineFloor = new Floor("travertine-floor") {{variants = 6;}};
        smoothTravertine = new Floor("smooth-travertine") {{variants = 6;}};
        brightTravertine = new Floor("bright-travertine") {{variants = 6;}};
        travertineVent = new SteamVent("travertine-vent"){{
            parent = blendGroup = travertineFloor;
            attributes.set(Attribute.steam, 1f);
            variants = 2;
            effectColor = DyPal.steamSulfur;
        }};
        shallowTravertine = new ShallowLiquid("shallow-travertine") {{
            speedMultiplier = 0.8f;
            statusDuration = 50f;
            liquidDrop = DyLiquids.hotSpringWater;
            isLiquid = true;
            variants = 4;
            cacheLayer = CacheLayer.water;
            supportsOverlay = true;
            albedo = 0.9f;
        }};
        deepTravertine = new ShallowLiquid("deep-travertine") {{
            speedMultiplier = 0.5f;
            statusDuration = 120f;
            liquidDrop = DyLiquids.hotSpringWater;
            isLiquid = true;
            variants = 4;
            drownTime = 200f;
            liquidMultiplier = 1.25f;
            cacheLayer = CacheLayer.water;
            supportsOverlay = true;
            albedo = 0.9f;
            drownTime = 660;
        }};
        travertineGeyser = new SteamVent("travertine-geyser") {{
            parent = blendGroup = shallowTravertine;
            attributes.set(Attribute.steam, 1f);
            variants = 2;
            shallow = true;
            liquidDrop = DyLiquids.hotSpringWater;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.9f;
            supportsOverlay = true;
            effectSpacing = 720;
            effectColor = DyPal.steamSulfur;
            effect = new MultiEffect(Fx.drillSteam, Fx.steam, Fx.vapor, Fx.smokeCloud);
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
            placeableLiquid = true;
        }};
        chalcociteFloor = new Floor("chalcocite-floor") {{variants = 5;}};
        gildedChalcocite = new Floor("gilded-chalcocite") {{
            variants = 5;
            attributes.set(DyAttributes.azurite, 1);
        }};
        chalcociteWall = new StaticWall("chalcocite-wall") {{
            chalcociteFloor.asFloor().wall = shallowChalcocite.asFloor().wall =  this;
        }};
        gildedChalcociteWall = new StaticWall("gilded-chalcocite-wall") {{
            gildedChalcocite.asFloor().wall = this;
            attributes.set(DyAttributes.azurite, 1);
        }};
        shallowChalcocite = new ShallowLiquid("shallow-chalcocite") {{
            speedMultiplier = 0.8f;
            statusDuration = 50f;
            liquidDrop = DyLiquids.hotSpringWater;
            isLiquid = true;
            variants = 2;
            cacheLayer = CacheLayer.water;
            supportsOverlay = true;
            albedo = 0.9f;
        }};
        azuriteBoulder = new Prop("azurite-boulder"){{
            variants = 6;
            chalcociteFloor.asFloor().decoration = gildedChalcocite.asFloor().decoration = shallowChalcocite.asFloor().decoration = this;
        }};
    }
}
