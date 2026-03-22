package dynamics.content;

import arc.struct.Seq;
import dynamics.world.blocks.crafting.Recipe;
import mindustry.type.ItemStack;

public class DynamicsRecipes {
    public static Seq<Recipe>
    basicComponentRecipe
            ;
    public static void load() {
        basicComponentRecipe = Seq.with(
                new Recipe(120f).consumeItems(ItemStack.with(DynamicsItems.malachite, 5, DynamicsItems.zinc, 10)).outputItem(DynamicsItems.component),
                //new Recipe(60f).consumeItems(ItemStack.with(DynamicsItems.tantalum, 5, DynamicsItems.zinc, 10)).outputItem(DynamicsItems.sublime)
        );
    }
}
