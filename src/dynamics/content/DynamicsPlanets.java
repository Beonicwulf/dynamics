package dynamics.content;

import arc.graphics.Color;
import dynamics.content.blocks.DynamicsEffectBlocks;
import dynamics.graphics.DynamicsPal;
import dynamics.maps.planets.KhioneGenerator;
import dynamics.maps.planets.ThalassaGenerator;
import mindustry.content.Planets;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.NoiseMesh;
import mindustry.type.Planet;

public class DynamicsPlanets {
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
            minZoom = 0.8f;
            bloom = false;
            hasAtmosphere = true;
            atmosphereColor = DynamicsPal.steam;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.4f;

            startSector = 34;
            sectorSeed = 14513;
            allowLaunchToNumbered = allowLaunchSchematics = allowLaunchLoadout = allowSectorInvasion = false;
            defaultCore = DynamicsEffectBlocks.coreSurface;
            allowWaves = clearSectorOnLose = true;

            ruleSetter = r -> {
                r.waveTeam = DynamicsTeams.dread;
                r.placeRangeCheck = false;
                r.showSpawns = true;
            };
            campaignRuleDefaults.fog = true;
            campaignRuleDefaults.showSpawns = true;
            campaignRuleDefaults.rtsAI = true;

            unlockedOnLand.add(DynamicsEffectBlocks.coreSurface);
            unlockedOnLand.add(DynamicsEffectBlocks.augerPad);

            meshLoader = () -> new MultiMesh(
                    new NoiseMesh(this, 7,
                            5, 1.229f, 4, 5, 1, 0.5f,
                            Color.valueOf("#515151"), Color.valueOf("#3c3838"),
                            1, 0.5f, 1, 0.5f),
                    new NoiseMesh(this, 94,
                            5, 1.22f, 4, 0.6f, 1, 0.5f,
                            Color.valueOf("#bcc4cb"), Color.valueOf("#879d9b"),
                            1, 0.5f, 1, 0.5f),
                    new NoiseMesh(this, 101,
                            6, 1.2441f, 5, 0.8f, 1, 0.5f,
                            Color.valueOf("#ce735e"), Color.valueOf("#af4753"),
                            1, 0.5f, 1, 0.5f),
                    new NoiseMesh(this, 69,
                            5, 1.212f, 4, 1, 0.75f, 0.5f,
                            Color.valueOf("#5867ac"), Color.valueOf("#4d5ca4"),
                            1, 0.5f, 1, 0.5f),
                    new NoiseMesh(this, 101,
                            5, 1.247f, 4, 1.1f, 1, 0.5f,
                            Color.valueOf("#e9ebff"), Color.valueOf("#c2bffb"),
                            1, 0.5f, 1, 0.5f),
                    new NoiseMesh(this, 61,
                            6, 1.248f, 4, 1.1f, 1, 0.5f,
                            Color.valueOf("#80b963"), Color.valueOf("#6aa95e"),
                            1, 0.5f, 1, 0.5f),
                    new NoiseMesh(this, 17,
                            6, 1.2514f, 6, 0.9f, 1, 0.5f,
                            Color.valueOf("#3c4448"), Color.valueOf("#282b34"),
                            1, 0.5f, 1, 0.5f)
            );
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 1,
                            1.21f, 0.1f, 6, Color.valueOf("c6ace8").a(0.49f), 3, 0.3f, 1, 0.6f),
                    new HexSkyMesh(this, 1,
                    1.01f, 0.11f, 6, Color.valueOf("d1e4ff").a(0.49f), 3, 0.4f, 0.9f, 0.6f),
                    new HexSkyMesh(this, 1,
                            0.891f, 0.091f, 6, Color.valueOf("#97a5f7").a(0.49f), 3, 0.5f, 1.1f, 0.6f)
            );
        }};
        khione = new Planet("khione", thalassa, 0.6f, 2) {{
            iconColor = DynamicsPal.tantalum;
            generator = new KhioneGenerator();
            visible = accessible = drawOrbit = updateLighting = alwaysUnlocked = true;

            orbitRadius = 4;
            orbitSpacing = 12;
            minZoom = 0.8f;
            bloom = false;
            hasAtmosphere = false;
            atmosphereColor = DynamicsPal.steamLight;
            atmosphereRadIn = 0;
            atmosphereRadOut = 0.08f;

            startSector = 45;
            sectorSeed = 678;
            allowLaunchToNumbered = allowLaunchSchematics = allowLaunchLoadout = allowSectorInvasion = false;
            defaultCore = DynamicsEffectBlocks.coreSurface;
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
