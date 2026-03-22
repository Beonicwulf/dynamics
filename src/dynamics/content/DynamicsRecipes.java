package dynamics.content;

import arc.struct.Seq;
import dynamics.world.blocks.crafting.Recipe;
import mindustry.type.ItemStack;

import static mindustry.content.Liquids.ozone;

public class DynamicsRecipes {
    public static Seq<Recipe>
    basicComponentRecipe
            ;
    public static void load() {
        basicComponentRecipe = Seq.with(
                new Recipe(120f).consumeItems(ItemStack.with(DynamicsItems.zinc, 10, DynamicsItems.malachite, 5)).outputItem(DynamicsItems.component)
        );
    }
}
