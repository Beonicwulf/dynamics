package dynamics;

import dynamics.content.DynamicsBlocks;
import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsLiquids;
import dynamics.content.DynamicsRecipes;
import mindustry.mod.*;

public class Dynamics extends Mod{

    @Override
    public void loadContent() {
        DynamicsItems.load();
        DynamicsLiquids.load();
        DynamicsRecipes.load();
        DynamicsBlocks.load();

    }
}
