package dynamics.content;

import arc.Core;
import arc.graphics.Color;
import dynamics.content.blocks.DyEffectBlocks;
import dynamics.graphics.DyPal;
import dynamics.maps.planets.KhioneGenerator;
import dynamics.maps.planets.ThalassaGenerator;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.NoiseMesh;
import mindustry.graphics.g3d.SunMesh;
import mindustry.type.Planet;

public class DyPlanets {
    public static Planet
            // star
            aurora,
            // campaign
            thalassa, khione,
            // Scrapped TBS solar system
            vulcan, seraph, gaia, thor, aureostrom, juno, heranthir, artemis
            ;

    public static void load() {
        // star
        aurora = new Planet("aurora", null, 11f){{
            bloom = true;
            accessible = alwaysUnlocked = Core.settings.getBool("debug-access");
            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("#dbd7e0"),
                    Color.valueOf("#ddc5c0"),
                    Color.valueOf("#ddbfa1"),
                    Color.valueOf("#e0c887"),
                    Color.valueOf("#e2e2c6"),
                    Color.valueOf("#e3e3dd")
            );
        }};
        // planets
        seraph = new Planet("seraph", aurora, 0.4f, 1) {{
            iconColor = DyPal.steamLight;
            generator = new ThalassaGenerator();
            accessible = alwaysUnlocked = Core.settings.getBool("debug-access");
            visible = drawOrbit = true;

            orbitRadius = 18;
            orbitSpacing = 1;
            minZoom = 0.5f;
            maxZoom = 2.4f;
            bloom = false;
            hasAtmosphere = true;
            atmosphereColor = DyPal.steamLight;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.1f;

            meshLoader = () -> new MultiMesh(
                    //steamy colors
                    new NoiseMesh(this, 61,
                            4, this.radius + 0.048f, 4, 1.1f, 0.5f, 0.425f,
                            DyPal.steam, DyPal.steamSulfur,
                            1, 0.5f, 1, 0.5f),
                    //lavender
                    new NoiseMesh(this, 17,
                            4, this.radius + 0.0514f, 6, 1.1f, 1, 0.55f,
                            Color.valueOf("#cbbadb"), Color.valueOf("#c8badc"),
                            1, 0.5f, 1, 0.5f),
                    //light clouds
                    new NoiseMesh(this, 69,
                            3, this.radius + 0.012f, 6, 1.1f, 0.75f, 0.5f,
                            Color.valueOf("#dfe0fe"), Color.valueOf("#c2c3e2"),
                            1, 0.5f, 1, 0.5f)
            );
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 1,
                            1.21f, 0.1f, 3, DyPal.steamLight.a(0.78f), 3, 0.5f, 1, 0.6f),
                    new HexSkyMesh(this, 1,
                            1.01f, 0.11f, 3, Color.valueOf("dbbcb3").a(0.83f), 3, 0.6f, 0.9f, 0.6f),
                    new HexSkyMesh(this, 1,
                            0.891f, 0.091f, 3, Color.valueOf("#dadbf9").a(0.88f), 3, 0.7f, 1.1f, 0.6f)
            );
        }};
        vulcan = new Planet("vulcan", aurora, 0.7f, 1) {{
            iconColor = DyPal.steamSulfur;
            generator = new ThalassaGenerator();
            accessible = alwaysUnlocked = Core.settings.getBool("debug-access");
            visible = drawOrbit = true;

            orbitRadius = 24;
            orbitSpacing = 1;
            minZoom = 0.5f;
            maxZoom = 2.4f;
            bloom = false;
            hasAtmosphere = true;
            atmosphereColor = DyPal.steamSulfur;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.1f;

            meshLoader = () -> new MultiMesh(
                    //darker
                    new NoiseMesh(this, 101,
                            5, this.radius + 0.0441f, 5, 0.9f, 1, 0.5f,
                            Color.valueOf("#884006"), Color.valueOf("#501c04"),
                            1, 0.5f, 1, 0.5f),
                    //dark
                    new NoiseMesh(this, 101,
                            4, this.radius + 0.047f, 4, 1.1f, 1, 0.5f,
                            Color.valueOf("#ac8357"), Color.valueOf("#ba7436"),
                            1, 0.5f, 1, 0.5f),
                    //mid
                    new NoiseMesh(this, 61,
                            5, this.radius + 0.048f, 4, 1.1f, 0.5f, 0.425f,
                            Color.valueOf("#e0bc5b"), Color.valueOf("#d0bd71"),
                            1, 0.5f, 1, 0.5f),
                    //light
                    new NoiseMesh(this, 17,
                            5, this.radius + 0.0514f, 6, 1.1f, 1, 0.55f,
                            Color.valueOf("#eedf8c"), Color.valueOf("#ffe8be"),
                            1, 0.5f, 1, 0.5f),
                    //lighter
                    new NoiseMesh(this, 69,
                            4, this.radius + 0.012f, 6, 1.1f, 0.75f, 0.5f,
                            Color.valueOf("#e3cca0"), Color.valueOf("#f8f0cc"),
                            1, 0.5f, 1, 0.5f)
            );
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 1,
                            1.21f, 0.1f, 4, DyPal.steam.a(0.49f), 3, 0.5f, 1, 0.6f),
                    new HexSkyMesh(this, 1,
                            1.01f, 0.11f, 4, Color.valueOf("dbbcb3").a(0.49f), 3, 0.6f, 0.9f, 0.6f),
                    new HexSkyMesh(this, 1,
                            0.891f, 0.091f, 4, DyPal.steamSulfur.a(0.49f), 3, 0.7f, 1.1f, 0.6f)
            );
        }};
        thalassa = new Planet("thalassa", aurora, 1.2f, 2) {{
            iconColor = DyPal.purifiedWater;
            generator = new ThalassaGenerator();
            visible = accessible = drawOrbit = updateLighting = alwaysUnlocked = true;

            orbitRadius = 48;
            orbitSpacing = 1;
            minZoom = 0.5f;
            maxZoom = 2.4f;
            bloom = false;
            hasAtmosphere = true;
            atmosphereColor = DyPal.steam;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.1f;

            startSector = 34;
            sectorSeed = 14513;
            allowLaunchToNumbered = allowLaunchSchematics = allowLaunchLoadout = allowSectorInvasion = false;
            defaultCore = DyEffectBlocks.coreSurface;
            allowWaves = clearSectorOnLose = allowCampaignRules = true;

            ruleSetter = r -> {
                r.waveTeam = DyTeams.dread;
                r.placeRangeCheck = false;
                r.showSpawns = true;
            };
            campaignRuleDefaults.fog = true;
            campaignRuleDefaults.showSpawns = true;
            campaignRuleDefaults.rtsAI = true;

            unlockedOnLand.add(DyEffectBlocks.coreSurface);
            unlockedOnLand.add(DyEffectBlocks.augerPad);

            meshLoader = () -> new MultiMesh(
                    //dark sand
                    new NoiseMesh(this, 7,
                            5, 1.229f, 4, 5, 1, 0.5f,
                            Color.valueOf("#515151"), Color.valueOf("#3c3838"),
                            1, 0.5f, 1, 0.5f),
                    //scoria
                    new NoiseMesh(this, 101,
                            6, 1.2441f, 5, 0.9f, 1, 0.5f,
                            Color.valueOf("#ce735e"), Color.valueOf("#af4753"),
                            1, 0.5f, 1, 0.5f),
                    //travertine
                    new NoiseMesh(this, 101,
                            5, 1.247f, 4, 1.1f, 1, 0.5f,
                            DyPal.travertineLightTone, DyPal.travertineMidTone,
                            1, 0.5f, 1, 0.5f),
                    //grass
                    new NoiseMesh(this, 61,
                            6, 1.248f, 4, 1.1f, 0.5f, 0.425f,
                            Color.valueOf("#80b963"), Color.valueOf("#6aa95e"),
                            1, 0.5f, 1, 0.5f),
                    //ocean water
                    new NoiseMesh(this, 17,
                            6, 1.2514f, 6, 1f, 1, 0.55f,
                            DyPal.waterDarkTone, DyPal.waterDarkerTone,
                            1, 0.5f, 1, 0.5f),
                    //lighter water
                    new NoiseMesh(this, 69,
                            5, 1.212f, 4, 1.1f, 0.75f, 0.5f,
                            DyPal.hotSpringWater, DyPal.purifiedWater,
                            1, 0.5f, 1, 0.5f)
            );
            cloudMeshLoader = () -> new MultiMesh(
                    //bright lavender
                    new HexSkyMesh(this, 1,
                            1.21f, 0.1f, 6, Color.valueOf("c6ace8").a(0.76f), 3, 0.3f, 1, 0.6f),
                    new HexSkyMesh(this, 1,
                            1.01f, 0.11f, 6, DyPal.steamLight.a(0.66f), 3, 0.4f, 0.9f, 0.6f),
                    new HexSkyMesh(this, 1,
                            0.891f, 0.091f, 6, DyPal.steam.a(0.56f), 3, 0.5f, 1.1f, 0.6f)
            );


        }};
        // moons
        khione = new Planet("khione", thalassa, 0.5f, 1) {{
            iconColor = DyPal.dread;
            generator = new KhioneGenerator();
            accessible = alwaysUnlocked = Core.settings.getBool("debug-access");
            visible =  drawOrbit = updateLighting = true;

            orbitRadius = 4;
            orbitSpacing = 12;
            minZoom = 0.5f;
            maxZoom = 3f;
            bloom = false;
            hasAtmosphere = false;
            atmosphereColor = DyPal.steamLight;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.08f;

            startSector = 45;
            sectorSeed = 678;
            allowLaunchToNumbered = allowLaunchSchematics = allowLaunchLoadout = allowSectorInvasion = false;
            defaultCore = DyEffectBlocks.coreSurface;
            allowWaves = clearSectorOnLose = true;

            meshLoader = () -> new NoiseMesh(this, 69,
                    2, 0.5f, 3, 0.8f, 0.15f, 1.5f,
                    Color.valueOf("#606d90"), Color.valueOf("#394462"),
                    1, 0.5f, 1, 0.5f);
            cloudMeshLoader = () -> new HexSkyMesh(this, 96,
                    0.4f, 0.05f, 1, Color.valueOf("96a0be").a(0.49f), 3, 0.7f, 0.15f, 0.4f);
        }};
        gaia = new Planet("gaia", aurora, 1.0f, 2) {{
            iconColor = DyPal.malachite;
            generator = new ThalassaGenerator();
            accessible = alwaysUnlocked = Core.settings.getBool("debug-access");
            visible = drawOrbit = true;

            orbitRadius = 56;
            orbitSpacing = 1;
            minZoom = 0.5f;
            maxZoom = 2.4f;
            hasAtmosphere = true;
            atmosphereColor = DyPal.steam;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.1f;

            meshLoader = () -> new MultiMesh(
                    //dark sand
                    new NoiseMesh(this, 7,
                            5, this.radius + 0.029f, 4, 5, 1, 0.5f,
                            Color.valueOf("#515151"), Color.valueOf("#3c3838"),
                            1, 0.5f, 1, 0.5f),
                    //sand
                    new NoiseMesh(this, 101,
                            5, this.radius + 0.0441f, 5, 0.9f, 1, 0.5f,
                            Color.valueOf("#e2a45b"), Color.valueOf("#e4c27b"),
                            1, 0.5f, 1, 0.5f),
                    //mountains
                    new NoiseMesh(this, 101,
                            4, this.radius + 0.047f, 4, 1.1f, 1, 0.5f,
                            Color.valueOf("#3a391d"), Color.valueOf("#2a2d22"),
                            1, 0.5f, 1, 0.5f),
                    //grass
                    new NoiseMesh(this, 61,
                            5, this.radius + 0.048f, 4, 1.1f, 0.5f, 0.425f,
                            Color.valueOf("#80b963"), Color.valueOf("#6aa95e"),
                            1, 0.5f, 1, 0.5f),
                    //ocean water
                    new NoiseMesh(this, 17,
                            5, this.radius + 0.0514f, 4, 1.05f, 1, 0.50f,
                            DyPal.waterDarkTone, DyPal.waterDarkerTone,
                            1, 0.5f, 1, 0.5f),
                    //lighter water
                    new NoiseMesh(this, 69,
                            5, this.radius + 0.012f, 4, 1.2f, 0.85f, 0.5f,
                            DyPal.hotSpringWater, DyPal.purifiedWater,
                            1, 0.5f, 1, 0.5f)
            );
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 1,
                            1.21f, 0.1f, 6, Color.valueOf("ffffff").a(0.65f), 3, 0.3f, 1, 0.6f),
                    new HexSkyMesh(this, 1,
                            1.01f, 0.11f, 6, DyPal.steamLight.a(0.57f), 3, 0.4f, 0.9f, 0.6f),
                    new HexSkyMesh(this, 1,
                            0.891f, 0.091f, 6, DyPal.steam.a(0.49f), 3, 0.5f, 1.1f, 0.6f)
            );
        }};
        thor = new Planet("thor", aurora, 0.85f, 2) {{
            iconColor = DyPal.tantalum;
            generator = new ThalassaGenerator();
            accessible = alwaysUnlocked = Core.settings.getBool("debug-access");
            visible = drawOrbit = true;

            orbitRadius = 64;
            orbitSpacing = 1;
            minZoom = 0.5f;
            maxZoom = 2.4f;
            hasAtmosphere = true;
            atmosphereColor = DyPal.steamLight;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.1f;

            meshLoader = () -> new MultiMesh(
                    //snow
                    new NoiseMesh(this, 101,
                            5, this.radius + 0.0441f, 6, 0.9f, 1, 0.5f,
                            Color.valueOf("#c8e3f8"), Color.valueOf("#ddedfd"),
                            1, 0.5f, 1, 0.5f),
                    //ice
                    new NoiseMesh(this, 101,
                            4, this.radius + 0.047f, 4, 1.1f, 1, 0.5f,
                            Color.valueOf("#78a9ca"), Color.valueOf("#6597bc"),
                            1, 0.5f, 1, 0.5f),
                    //snow
                    new NoiseMesh(this, 61,
                            5, this.radius + 0.048f, 4, 1.15f, 0.5f, 0.425f,
                            Color.valueOf("#dcf2ff"), Color.valueOf("#daebfb"),
                            1, 0.5f, 1, 0.5f),
                    //ocean water
                    new NoiseMesh(this, 17,
                            5, this.radius + 0.0514f, 4, 1f, 1, 0.50f,
                            DyPal.waterDarkTone, DyPal.waterDarkerTone,
                            1, 0.5f, 1, 0.5f),
                    //water
                    new NoiseMesh(this, 69,
                            5, this.radius + 0.012f, 4, 1.2f, 0.85f, 0.5f,
                            DyPal.waterDarkTone, DyPal.purifiedWater,
                            1, 0.5f, 1, 0.5f)
            );
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 1,
                            1.21f, 0.1f, 5, Color.valueOf("edffff").a(0.57f), 4, 0.4f, 1, 0.6f),
                    new HexSkyMesh(this, 1,
                            1.01f, 0.11f, 5, DyPal.steamLight.a(0.85f), 3, 0.4f, 0.9f, 0.6f),
                    new HexSkyMesh(this, 1,
                            0.891f, 0.091f, 5, DyPal.steam.a(0.73f), 3, 0.5f, 1.1f, 0.6f)
            );
        }};
        aureostrom = new Planet("aureostrom", aurora, 1.34f, 2) {{
            iconColor = DyPal.component;
            generator = new ThalassaGenerator();
            accessible = alwaysUnlocked = Core.settings.getBool("debug-access");
            visible = drawOrbit = true;

            orbitRadius = 76;
            orbitSpacing = 1;
            minZoom = 0.5f;
            maxZoom = 2.4f;
            hasAtmosphere = true;
            atmosphereColor = DyPal.steamLight;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.1f;

            meshLoader = () -> new MultiMesh(
                    //yellow
                    new NoiseMesh(this, 101,
                            5, this.radius + 0.047f, 4, 1.1f, 1, 0.5f,
                            Color.valueOf("#caa77f"), DyPal.zinc,
                            1, 0.5f, 1, 0.5f),
                    //gold
                    new NoiseMesh(this, 61,
                            6, this.radius + 0.048f, 4, 1.15f, 0.5f, 0.425f,
                            DyPal.component, Color.valueOf("#846823"),
                            1, 0.5f, 1, 0.5f),
                    //cloudy
                    new NoiseMesh(this, 69,
                            6, this.radius + 0.012f, 4, 1.2f, 0.85f, 0.5f,
                            Color.valueOf("#e2d5c5"), Color.valueOf("#fbdda9"),
                            1, 0.5f, 1, 0.5f)
            );
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 1,
                            1.21f, 0.17f, 6, DyPal.zinc.a(0.81f), 4, 0.55f, 1.2f, 0.6f),
                    new HexSkyMesh(this, 1,
                            1.01f, 0.156f, 6, Color.valueOf("faf6db").a(0.89f), 3, 0.65f, 1.1f, 0.6f),
                    new HexSkyMesh(this, 1,
                            0.891f, 0.141f, 6, DyPal.component.a(0.73f), 3, 0.6f, 1.15f, 0.6f)
            );
        }};
    }
}
