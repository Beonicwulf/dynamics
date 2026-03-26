package dynamics;

import dynamics.content.DynamicsBlocks;
import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsLiquids;
import dynamics.content.DynamicsRecipes;
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
        DynamicsBlocks.load();

    }
}
