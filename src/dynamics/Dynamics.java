package dynamics;

import dynamics.content.*;
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
        DynamicsUnitTypes.load();
        DynamicsBlocks.load();

    }
}
