package dynamics.content;

import arc.struct.Seq;
import dynamics.world.blocks.crafting.Recipe;
import mindustry.type.ItemStack;

public class DynamicsRecipes {
    public static Seq<Recipe>
    basicComponentRecipe, powerComponentRecipe
            ;
    public static void load() {
        basicComponentRecipe = Seq.with(
                new Recipe(120f).consumeItems(ItemStack.with(DynamicsItems.malachite, 5, DynamicsItems.zinc, 10)).outputItem(DynamicsItems.partBasic)
        );
        powerComponentRecipe = Seq.with(
                new Recipe(180f).consumeItems(ItemStack.with(DynamicsItems.electrum, 5, DynamicsItems.malachite, 10, DynamicsItems.zinc, 10)).outputItem(DynamicsItems.partPower)
        );
    }
}
