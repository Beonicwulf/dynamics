package dynamics.content;

import arc.Core;
import mindustry.type.SectorPreset;

public class DySectorPresets {
    public static SectorPreset
            // testing
            testSector;
    public static void load() {
        testSector = new SectorPreset("test-sector", DyPlanets.thalassa, 35){{
            alwaysUnlocked = Core.settings.getBool("debug-access");
            difficulty = 1;
            captureWave = 15;
        }};
    }
}
