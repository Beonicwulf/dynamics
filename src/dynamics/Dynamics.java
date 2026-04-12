package dynamics;

import dynamics.content.*;
import dynamics.content.DyTeams;
import dynamics.core.ModSettings;
import dynamics.ui.DyHints;
import mindustry.Vars;
import mindustry.mod.*;

public class Dynamics extends Mod{
    public static final String MOD_NAME = "dy";

    public static String name(String name) {
        return MOD_NAME + "-" + name;
    }

    public Dynamics () {
        DyMusics.preload();
        DyHints.preInit();
    }

    @Override
    public void loadContent() {
        DyItems.load();
        DyLiquids.load();
        DyRecipes.load();
        DyBulletTypes.load();
        DyUnitTypes.load();
        DyBlocks.load();
        DyWeathers.load();
        DyPlanets.load();
        DySectorPresets.load();
        ThalassaTechTree.load();
    }

    @Override
    public void init() {
        super.init();
        DyTeams.load();
        //DySettings.loadSettings();
        if (!Vars.headless) {
            ModSettings.load();}
    }
}
