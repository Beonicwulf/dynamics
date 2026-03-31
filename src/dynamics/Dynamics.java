package dynamics;

import dynamics.content.*;
import dynamics.content.DynamicsTeams;
import mindustry.mod.*;

public class Dynamics extends Mod{
    public static final String MOD_NAME = "fb-dynamics";

    public static String name(String name) {
        return MOD_NAME + "-" + name;
    }

    @Override
    public void loadContent() {
        DynamicsItems.load();
        DynamicsLiquids.load();
        DynamicsRecipes.load();
        DynamicsBulletTypes.load();
        DynamicsUnitTypes.load();
        DynamicsBlocks.load();

    }

    @Override
    public void init() {
        super.init();
        DynamicsTeams.load();
    }
}
