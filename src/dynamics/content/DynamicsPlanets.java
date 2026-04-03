package dynamics.content;

import dynamics.content.blocks.DynamicsEffectBlocks;
import dynamics.graphics.DynamicsPal;
import mindustry.content.Planets;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.type.Planet;

public class DynamicsPlanets {
    public static Planet
            erbius
            ;

    public static void load(){
        erbius = new Planet("erbius", Planets.sun, 1f, 2){{
            //generator = new ErekirPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 2, 1.21f, 0.14f, 6, DynamicsPal.steamLight.a(0.75f), 3, 0.3f, 1f, 0.6f),
                    new HexSkyMesh(this, 3, 0.891f, 0.15f, 6, DynamicsPal.steam.a(0.75f), 3, 0.5f, 1.1f, 0.6f)
            );
            alwaysUnlocked = true;
            landCloudColor = DynamicsPal.dread;
            atmosphereColor = DynamicsPal.dread;
            //defaultEnv = Env.scorching | Env.terrestrial;
            startSector = 34;
            atmosphereRadIn = 0f;
            atmosphereRadOut = 0.4f;
            //tidalLock = true;
            orbitSpacing = 1f;
            //totalRadius += 2.6f;
            lightSrcTo = 0.5f;
            lightDstFrom = 0.2f;
            clearSectorOnLose = true;
            defaultCore = DynamicsEffectBlocks.coreSurface;
            iconColor = DynamicsPal.dread;
            //enemyBuildSpeedMultiplier = 0.4f;
            allowLaunchToNumbered = false;
            //updateLighting = false;

            //defaultAttributes.set(Attribute.heat, 0.8f);

            ruleSetter = r -> {
                r.waveTeam = DynamicsTeams.dread;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.fog = true;
                r.staticFog = true;
                r.lighting = true;
                r.coreDestroyClear = true;
                r.onlyDepositCore = true;
            };
            campaignRuleDefaults.fog = true;
            campaignRuleDefaults.showSpawns = true;
            campaignRuleDefaults.rtsAI = true;

            unlockedOnLand.add(DynamicsEffectBlocks.coreSurface);
            unlockedOnLand.add(DynamicsEffectBlocks.augerPad);
        }};
    }
}
