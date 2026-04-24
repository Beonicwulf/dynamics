package dynamics.content;

import arc.struct.ObjectFloatMap;
import arc.struct.Seq;
import mindustry.game.Objectives;
import mindustry.type.Item;

import static dynamics.content.DyUnitTypes.*;
import static dynamics.content.blocks.DyCrafting.*;
import static dynamics.content.blocks.DyDefense.*;
import static dynamics.content.blocks.DyEffectBlocks.*;
import static dynamics.content.blocks.DyDistribution.*;
import static dynamics.content.blocks.DyLiquidBlocks.*;
import static dynamics.content.blocks.DyPayloadBlocks.*;
import static dynamics.content.blocks.DyProduction.*;
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
                node(zincSorter, () -> node(zincUnloader, Seq.with(new Objectives.OnSector(DySectorPresets.testSector)), () -> {}));
                node(zincMessage, () -> node(zincCanvas, Seq.with(new Objectives.OnSector(DySectorPresets.testSector)), () -> {}));
            });
            node(fluxCollector, () -> {
                node(clockworkDrill);
                node(fluxHeater, () -> node(grafter));
            });
            node(pipe, () -> {
                node(pipeRouter, () -> node(pipeTunnel));
                node(pipeJunction, () -> node(pipeVent, Seq.with(new Objectives.OnSector(DySectorPresets.testSector)), () -> node(pipeController)));
            });
            node(withdraw);
            node(augerPad, () -> node(augerDrone));
            nodeProduce(DyItems.zinc, () -> {
                nodeProduce(DyItems.malachite, () -> {});
                nodeProduce(DyItems.partBasic, () -> {});
                nodeProduce(DyLiquids.flux, () -> {});
            });
            node(basicConstructor, () -> {
                node(zincConveyor, () -> node(basicDeconstructor, Seq.with(new Objectives.Research(split), new Objectives.OnSector(DySectorPresets.testSector)), () -> {}));
            });
        });
    }
}
