package dynamics.content;

import mindustry.type.SectorPreset;

public class DySectorPresets {
    public static SectorPreset
            testSector
            ;

    public static void load() {
        testSector = new SectorPreset("test-sector", DyPlanets.thalassa, 34){{
            alwaysUnlocked = true;
            difficulty = 1;
            captureWave = 15;
        }};
    }
}
