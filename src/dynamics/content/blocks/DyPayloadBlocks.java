package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.Constructor;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.payloads.PayloadDeconstructor;

public class DyPayloadBlocks {
    public static Block
            // Payload
            basicConstructor, zincConveyor, basicDeconstructor;
    public static void load() {
        basicConstructor = new Constructor("basic-constructor") {{
            requirements(Category.units, ItemStack.with(DyItems.zinc, 75, DyItems.partBasic, 10));
            payloadSpeed = 0.75f;
            size = 3;
            buildSpeed = 4;
            hasPower = false;
            consumeLiquid(DyLiquids.flux, 5f/60f);
            researchCost = ItemStack.with(DyItems.zinc, 75 * 10 * 5, DyItems.partBasic, 10 * 10 * 5);
            //filter = Seq.with(DyComponentBlocks.bUAK, DyComponentBlocks.splitFrame);
        }};
        zincConveyor = new PayloadConveyor("zinc-conveyor") {{
            requirements(Category.units, ItemStack.with(DyItems.partBasic, 10));
            size = 3;
            health = 450;
            moveTime = 20;
            placeableLiquid = true;
            researchCost = ItemStack.with(DyItems.partBasic, 10 * 10 * 5);
        }};
        basicDeconstructor = new PayloadDeconstructor("basic-deconstructor") {{
            requirements(Category.units, ItemStack.with(DyItems.zinc, 100, DyItems.partBasic, 10));
            hasPower = false;
            size = 3;
            deconstructSpeed = 4;
            researchCost = ItemStack.with(DyItems.zinc, 100 * 10 * 5, DyItems.partBasic, 10 * 10 * 5);
        }};
    }
}
