package dynamics.content;

import arc.struct.ObjectFloatMap;
import mindustry.type.Item;

import static dynamics.content.DynamicsUnitTypes.*;
import static dynamics.content.blocks.DynamicsCrafting.*;
import static dynamics.content.blocks.DynamicsDefense.*;
import static dynamics.content.blocks.DynamicsEffectBlocks.*;
import static dynamics.content.blocks.DynamicsDistribution.*;
import static dynamics.content.blocks.DynamicsLiquidBlocks.*;
import static dynamics.content.blocks.DynamicsProduction.*;
import static mindustry.Vars.content;
import static mindustry.content.TechTree.*;

public class ThalassaTechTree {
    public static void load() {
        var costMultipliers = new ObjectFloatMap<Item>();
        for(var item : content.items()) costMultipliers.put(item, 0.9f);

        //these are hard to make
        costMultipliers.put(DynamicsItems.partBasic, 0.2f);

        DynamicsPlanets.thalassa.techTree = nodeRoot("thalassa", coreSurface, true, () -> {
            context().researchCostMultipliers = costMultipliers;

            node(accelerator, () -> {
                node(zincSorter);
                node(zincMessage);
            });
            node(steamCollector, () -> node(clockworkDrill));
            node(pipe, () -> {
                node(pipeRouter, () -> node(pipeTunnel));
                node(pipeJunction, () -> node(pipeVent, () -> node(pipeController)));
            });
            node(mechanicalPress);
            node(steamValve, () -> node(withdraw));
            node(augerPad, () -> node(augerDrone));
            nodeProduce(DynamicsItems.zinc, () ->{
                nodeProduce(DynamicsItems.malachite, () -> {
                    nodeProduce(DynamicsItems.cinnabar, () -> {});
                    nodeProduce(DynamicsItems.tantalum, () -> {});
                });
                nodeProduce(DynamicsItems.partBasic, () -> {});
                nodeProduce(DynamicsLiquids.steam, () -> nodeProduce(DynamicsLiquids.hotSpringWater, () -> nodeProduce(DynamicsLiquids.purifiedWater, () -> {})));
            });
        });
    }
}
