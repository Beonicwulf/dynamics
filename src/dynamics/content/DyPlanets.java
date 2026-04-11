package dynamics.content;

import arc.graphics.Color;
import dynamics.content.blocks.DyEffectBlocks;
import dynamics.graphics.DynamicsPal;
import dynamics.maps.planets.KhioneGenerator;
import dynamics.maps.planets.ThalassaGenerator;
import mindustry.content.Planets;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.NoiseMesh;
import mindustry.type.Planet;

public class DyPlanets {
    public static Planet
            thalassa, khione
            ;

    public static void load() {
        thalassa = new Planet("thalassa", Planets.sun, 1.2f, 2) {{
            iconColor = DynamicsPal.dread;
            generator = new ThalassaGenerator();
            visible = accessible = drawOrbit = updateLighting = alwaysUnlocked = true;

            orbitRadius = 24;
            orbitSpacing = 1;
            minZoom = 0.5f;
            maxZoom = 2.4f;
            bloom = false;
            hasAtmosphere = true;
            atmosphereColor = DynamicsPal.steam;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.1f;

            startSector = 34;
            sectorSeed = 14513;
            allowLaunchToNumbered = allowLaunchSchematics = allowLaunchLoadout = allowSectorInvasion = false;
            defaultCore = DyEffectBlocks.coreSurface;
            allowWaves = clearSectorOnLose = true;

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
                            DynamicsPal.travertineLightTone, DynamicsPal.travertineMidTone,
                            1, 0.5f, 1, 0.5f),
                    //grass
                    new NoiseMesh(this, 61,
                            6, 1.248f, 4, 1.1f, 0.5f, 0.425f,
                            Color.valueOf("#80b963"), Color.valueOf("#6aa95e"),
                            1, 0.5f, 1, 0.5f),
                    //ocean water
                    new NoiseMesh(this, 17,
                            6, 1.2514f, 6, 1f, 1, 0.55f,
                            DynamicsPal.waterDarkTone, DynamicsPal.waterDarkerTone,
                            1, 0.5f, 1, 0.5f),
                    //lighter water
                    new NoiseMesh(this, 69,
                            5, 1.212f, 4, 1.1f, 0.75f, 0.5f,
                            DynamicsPal.hotSpringWater, DynamicsPal.purifiedWater,
                            1, 0.5f, 1, 0.5f)
            );
            cloudMeshLoader = () -> new MultiMesh(
                    //bright lavender
                    new HexSkyMesh(this, 1,
                            1.21f, 0.1f, 6, Color.valueOf("c6ace8").a(0.49f), 3, 0.3f, 1, 0.6f),
                    new HexSkyMesh(this, 1,
                            1.01f, 0.11f, 6, DynamicsPal.steamLight.a(0.49f), 3, 0.4f, 0.9f, 0.6f),
                    new HexSkyMesh(this, 1,
                            0.891f, 0.091f, 6, DynamicsPal.steam.a(0.49f), 3, 0.5f, 1.1f, 0.6f)
            );


        }};
        khione = new Planet("khione", thalassa, 0.6f, 2) {{
            iconColor = DynamicsPal.tantalum;
            generator = new KhioneGenerator();
            visible = accessible = drawOrbit = updateLighting = alwaysUnlocked = true;

            orbitRadius = 4;
            orbitSpacing = 12;
            minZoom = 0.5f;
            maxZoom = 3f;
            bloom = false;
            hasAtmosphere = false;
            atmosphereColor = DynamicsPal.steamLight;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.08f;

            startSector = 45;
            sectorSeed = 678;
            allowLaunchToNumbered = allowLaunchSchematics = allowLaunchLoadout = allowSectorInvasion = false;
            defaultCore = DyEffectBlocks.coreSurface;
            allowWaves = clearSectorOnLose = true;

            meshLoader = () -> new NoiseMesh(this, 69,
                    2, 0.6f, 3, 0.8f, 0.15f, 1.5f,
                    Color.valueOf("#606d90"), Color.valueOf("#394462"),
                    1, 0.5f, 1, 0.5f);
            cloudMeshLoader = () -> new HexSkyMesh(this, 96,
                    0.4f, 0.05f, 1, Color.valueOf("96a0be").a(0.49f), 3, 0.7f, 0.15f, 0.4f);
        }};
    }
}
