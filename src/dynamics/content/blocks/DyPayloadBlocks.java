package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.content.DyUnitTypes;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.Constructor;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.payloads.PayloadDeconstructor;
import mindustry.world.blocks.units.UnitFactory;

public class DyPayloadBlocks {
    public static Block
            // Payload
            basicConstructor, zincConveyor, basicDeconstructor,
            // Unit Fabricators
            splitFabricator
            ;
    public static void load() {
        splitFabricator = new UnitFactory("split-fabricator"){{
            requirements(Category.units, ItemStack.with(DyItems.zinc, 120, DyItems.malachite, 60, DyItems.partBasic, 20));
            researchCost = ItemStack.mult(requirements, 10);
            size = 3;
            hasPower = configurable = false;
            consumeLiquid(DyLiquids.flux, 10f/60f);
            plans.add(new UnitPlan(DyUnitTypes.split, 900, ItemStack.with(DyItems.zinc, 60, DyItems.partBasic, 3)));
        }};
        basicConstructor = new Constructor("basic-constructor") {{
            requirements(Category.units, ItemStack.with(DyItems.zinc, 75, DyItems.partBasic, 10));
            researchCost = ItemStack.mult(requirements, 50);
            payloadSpeed = 0.75f;
            size = 3;
            buildSpeed = 4;
            hasPower = false;
            consumeLiquid(DyLiquids.flux, 5f/60f);
            //filter = Seq.with(DyComponentBlocks.bUAK, DyComponentBlocks.splitFrame);
        }};
        zincConveyor = new PayloadConveyor("zinc-conveyor") {{
            requirements(Category.units, ItemStack.with(DyItems.partBasic, 10));
            researchCost = ItemStack.mult(requirements, 50);
            size = 3;
            health = 450;
            moveTime = 20;
            placeableLiquid = true;
        }};
        basicDeconstructor = new PayloadDeconstructor("basic-deconstructor") {{
            requirements(Category.units, ItemStack.with(DyItems.zinc, 100, DyItems.partBasic, 10));
            researchCost = ItemStack.mult(requirements, 50);
            hasPower = false;
            size = 3;
            deconstructSpeed = 4;
        }};
    }
}
