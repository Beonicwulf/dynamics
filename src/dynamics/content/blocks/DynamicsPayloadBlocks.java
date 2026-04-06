package dynamics.content.blocks;

import arc.struct.Seq;
import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsLiquids;
import dynamics.content.DynamicsUnitTypes;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.PayloadStack;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.Constructor;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.blocks.payloads.PayloadDeconstructor;
import mindustry.world.blocks.units.UnitAssembler;

public class DynamicsPayloadBlocks {
    public static Block
            splitAssembler,
            basicConstructor, zincConveyor, basicDeconstructor
            ;

    public static void load() {
        splitAssembler = new UnitAssembler("split-assembler") {{
            requirements(Category.units, ItemStack.with(DynamicsItems.zinc, 150, DynamicsItems.partBasic, 10));
            researchCost = ItemStack.with(DynamicsItems.zinc, 150 * 3 * 5, DynamicsItems.partBasic, 10 * 3 * 5);
            size = 3;
            areaSize = 5;
            droneType = DynamicsUnitTypes.augerAssembler;
            //dronesCreated = 1;
            consumeLiquid(DynamicsLiquids.steam, 10f/60f);
            plans.add(
                    new AssemblerUnitPlan(DynamicsUnitTypes.split, 35f * 60f, PayloadStack.list(DynamicsComponentBlocks.bUAK, 1, DynamicsComponentBlocks.splitFrame, 1))
            );
        }};
        basicConstructor = new Constructor("basic-constructor") {{
            requirements(Category.units, ItemStack.with(DynamicsItems.zinc, 75, DynamicsItems.partBasic, 10));
            payloadSpeed = 0.75f;
            size = 3;
            buildSpeed = 4;
            hasPower = false;
            consumeLiquid(DynamicsLiquids.steam, 5f/60f);
            researchCost = ItemStack.with(DynamicsItems.zinc, 75 * 10 * 5, DynamicsItems.partBasic, 10 * 10 * 5);
            filter = Seq.with(DynamicsComponentBlocks.bUAK, DynamicsComponentBlocks.splitFrame);
        }};
        zincConveyor = new PayloadConveyor("zinc-conveyor") {{
            requirements(Category.units, ItemStack.with(DynamicsItems.partBasic, 10));
            size = 3;
            health = 450;
            moveTime = 20;
            placeableLiquid = true;
            researchCost = ItemStack.with(DynamicsItems.partBasic, 10 * 10 * 5);
        }};
        basicDeconstructor = new PayloadDeconstructor("basic-deconstructor") {{
            requirements(Category.units, ItemStack.with(DynamicsItems.zinc, 100, DynamicsItems.partBasic, 10));
            hasPower = false;
            size = 3;
            deconstructSpeed = 4;
            researchCost = ItemStack.with(DynamicsItems.zinc, 100 * 10 * 5, DynamicsItems.partBasic, 10 * 10 * 5);
        }};
    }
}
