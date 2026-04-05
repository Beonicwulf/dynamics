package dynamics.content;

import mindustry.type.SectorPreset;

public class DynamicsSectorPresets {
    public static SectorPreset
            testSector
            ;

    public static void load() {
        testSector = new SectorPreset("test-sector", DynamicsPlanets.thalassa, 34){{
            alwaysUnlocked = true;
            difficulty = 1;
            captureWave = 15;
        }};
    }
}
