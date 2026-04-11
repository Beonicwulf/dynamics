package dynamics;

import dynamics.content.*;
import dynamics.content.DyTeams;
import dynamics.ui.DySettings;
import mindustry.mod.*;

public class Dynamics extends Mod{
    public static final String MOD_NAME = "fb-dynamics";

    public static String name(String name) {
        return MOD_NAME + "-" + name;
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
        DySettings.loadSettings();
        DyMusics.load();
    }
}
