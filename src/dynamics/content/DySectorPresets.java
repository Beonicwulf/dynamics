package dynamics.content;

import arc.Core;
import mindustry.type.SectorPreset;

public class DySectorPresets {
    public static SectorPreset
            // testing
            testSector,
            //campaign
            embark;
    public static void load() {
        testSector = new SectorPreset("test-sector", DyPlanets.thalassa, 35){{
            alwaysUnlocked = Core.settings.getBool("debug-access");
            difficulty = 1;
            captureWave = 15;
        }};
        embark = new SectorPreset("embark", DyPlanets.thalassa, 34){{
            alwaysUnlocked = true;
            difficulty = 1;
        }};
    }
}
