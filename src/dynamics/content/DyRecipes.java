package dynamics.content;

import arc.struct.Seq;
import dynamics.world.blocks.crafting.Recipe;
import mindustry.type.ItemStack;

public class DyRecipes {
    public static Seq<Recipe> basicComponentRecipe, powerComponentRecipe;
    public static void load() {
        basicComponentRecipe = Seq.with(new Recipe(120f).consumeItems(ItemStack.with(DyItems.malachite, 5, DyItems.zinc, 10)).outputItem(DyItems.partBasic));
        powerComponentRecipe = Seq.with(new Recipe(210f).consumeItems(ItemStack.with(DyItems.montroydite, 10, DyItems.zinc, 30)).outputItem(DyItems.partPower, 3));
    }
}
