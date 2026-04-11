package dynamics.content.blocks;

import arc.struct.Seq;
import dynamics.content.DyItems;
import dynamics.content.DyLiquids;
import dynamics.content.DyUnitTypes;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.PayloadStack;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.Constructor;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.payloads.PayloadDeconstructor;
import mindustry.world.blocks.units.UnitAssembler;

public class DyPayloadBlocks {
    public static Block
            splitAssembler,
            basicConstructor, zincConveyor, basicDeconstructor
            ;

    public static void load() {
        splitAssembler = new UnitAssembler("split-assembler") {{
            requirements(Category.units, ItemStack.with(DyItems.zinc, 150, DyItems.partBasic, 10));
            researchCost = ItemStack.with(DyItems.zinc, 150 * 3 * 5, DyItems.partBasic, 10 * 3 * 5);
            size = 3;
            areaSize = 5;
            droneType = DyUnitTypes.augerAssembler;
            //dronesCreated = 1;
            consumeLiquid(DyLiquids.steam, 10f/60f);
            plans.add(
                    new AssemblerUnitPlan(DyUnitTypes.split, 35f * 60f, PayloadStack.list(DyComponentBlocks.bUAK, 1, DyComponentBlocks.splitFrame, 1))
            );
        }};
        basicConstructor = new Constructor("basic-constructor") {{
            requirements(Category.units, ItemStack.with(DyItems.zinc, 75, DyItems.partBasic, 10));
            payloadSpeed = 0.75f;
            size = 3;
            buildSpeed = 4;
            hasPower = false;
            consumeLiquid(DyLiquids.steam, 5f/60f);
            researchCost = ItemStack.with(DyItems.zinc, 75 * 10 * 5, DyItems.partBasic, 10 * 10 * 5);
            filter = Seq.with(DyComponentBlocks.bUAK, DyComponentBlocks.splitFrame);
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
