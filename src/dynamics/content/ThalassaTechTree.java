package dynamics.content;

import arc.struct.ObjectFloatMap;
import mindustry.type.Item;

import static dynamics.content.DyUnitTypes.*;
import static dynamics.content.blocks.DyComponentBlocks.*;
import static dynamics.content.blocks.DyCrafting.*;
import static dynamics.content.blocks.DyDefense.*;
import static dynamics.content.blocks.DyEffectBlocks.*;
import static dynamics.content.blocks.DyDistribution.*;
import static dynamics.content.blocks.DyLiquidBlocks.*;
import static dynamics.content.blocks.DyPayloadBlocks.*;
import static dynamics.content.blocks.DynamicsProduction.*;
import static mindustry.Vars.content;
import static mindustry.content.TechTree.*;

public class ThalassaTechTree {
    public static void load() {
        float costBalance = 0.2f;
        var costMultipliers = new ObjectFloatMap<Item>();
        for(var item : content.items()) costMultipliers.put(item, costBalance);

        //these are hard to make
        costMultipliers.put(DyItems.partBasic, costBalance * 0.2f);

        DyPlanets.thalassa.techTree = nodeRoot("thalassa", coreSurface, true, () -> {
            context().researchCostMultipliers = costMultipliers;

            node(accelerator, () -> {
                node(zincSorter);
                node(zincMessage);
            });
            node(steamCollector, () -> node(clockworkDrill));
            node(pipe, () -> {
                node(pipeRouter, () -> node(pipeTunnel));
                node(pipeJunction, () -> node(pipeVent, () -> node(pipeController)));
                node(clockworkPump);
            });
            node(mechanicalPress);
            node(steamValve, () -> node(withdraw));
            node(augerPad, () -> node(augerDrone));
            nodeProduce(DyItems.zinc, () ->{
                nodeProduce(DyItems.malachite, () -> {
                    nodeProduce(DyItems.cinnabar, () -> {});
                    nodeProduce(DyItems.tantalum, () -> {});
                });
                nodeProduce(DyItems.partBasic, () -> {});
                nodeProduce(DyLiquids.steam, () -> nodeProduce(DyLiquids.hotSpringWater, () -> nodeProduce(DyLiquids.purifiedWater, () -> {})));
            });
            node(basicConstructor, () -> {
                node(zincConveyor, () -> node(basicDeconstructor));
                node(bUAK, () -> node(splitFrame, () -> node(splitAssembler)));
            });
        });
    }
}
