package dynamics.content;

import arc.struct.Seq;
import dynamics.world.blocks.crafting.Recipe;
import mindustry.type.ItemStack;

import static mindustry.content.Liquids.ozone;

public class DynamicsRecipes {
    public static Seq<Recipe>
    basicComponentRecipe, testRecipe
            ;
    public static void load() {
        basicComponentRecipe = Seq.with(
                new Recipe(120f).consumeItems(ItemStack.with(DynamicsItems.zinc, 10, DynamicsItems.malachite, 5)).consumeLiquid(DynamicsLiquids.steam, 12f/60f).outputItem(DynamicsItems.component)
        );
        testRecipe = Seq.with(
                new Recipe(120f).consumeItems(ItemStack.with(DynamicsItems.zinc, 10, DynamicsItems.malachite, 5)).consumeLiquid(DynamicsLiquids.steam, 12f/60f).outputItem(DynamicsItems.component),
                new Recipe(60f).consumeItems(ItemStack.with(DynamicsItems.zinc, 5)).consumeLiquid(ozone, 10f/60f).outputItem(DynamicsItems.sublime, 2)
        );
    }
}
