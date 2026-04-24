package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.world.blocks.fluid.*;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.DirectionLiquidBridge;
import mindustry.world.blocks.liquid.*;

import static mindustry.type.ItemStack.*;

public class DyLiquidBlocks {
    public static Block
            pipe, pipeRouter, pipeTunnel,
            pipeJunction, pipeVent, pipeController,
            clockworkPump;
    public static void load() {
        pipe = new ArmoredConduit("pipe") {{
            requirements(Category.liquid, with(DyItems.zinc, 2));
            leaks = true;
            underBullets = true;
            placeableLiquid = true;
            //explosivenessScale = flammabilityScale = 20f/50f;
            researchCost = with(DyItems.zinc, 2 * 5 * 5);
        }};
        pipeRouter = new LiquidRouter("pipe-router") {{
            requirements(Category.liquid, with(DyItems.zinc, 10, DyItems.partBasic, 1));
            liquidCapacity = 40;
            size = 1;
            placeableLiquid = true;
            liquidPadding = 3f/4f;
            underBullets = true;
            solid = false;
            //explosivenessScale = flammabilityScale = 40f/150f;
            researchCost = with(DyItems.zinc, 10 * 10 * 5, DyItems.partBasic, 10 * 5);
        }};
        pipeJunction = new FluidValve("pipe-junction") {{
            requirements(Category.liquid, with(DyItems.zinc, 10, DyItems.partBasic, 1));
            size = 1;
            solid = false;
            placeableLiquid = true;
            underBullets = true;
            ((Conduit)pipe).junctionReplacement = this;
            researchCost = with(DyItems.zinc, 10 * 10 * 5, DyItems.partBasic, 10 * 5);
        }};
        pipeTunnel = new DirectionLiquidBridge("pipe-tunnel") {{
            requirements(Category.liquid, with(DyItems.zinc, 20, DyItems.partBasic, 5));
            solid = false;
            placeableLiquid = true;
            range = 8;
            hasPower = false;
            liquidCapacity = 60f;
            underBullets = true;
            //explosivenessScale = flammabilityScale = 20f/120f;
            ((Conduit)pipe).rotBridgeReplacement = this;
            researchCost = with(DyItems.zinc, 20 * 7  * 5, DyItems.partBasic, 5 * 7  * 5);
        }};
        pipeVent = new FluidVent("pipe-vent") {{
            requirements(Category.liquid, with(DyItems.zinc, 10));
            size = 1;
            minPressure = -0.25f;
            ventRate = 0.5f;
            liquidCapacity = 100;
            solid = false;
            placeableLiquid = true;
            researchCost = with(DyItems.zinc, 10 * 10 * 5);
        }};
        pipeController = new ValveController("pipe-controller") {{
            requirements(Category.liquid, with(DyItems.zinc, 10, DyItems.partBasic, 3));
            size = 1;
            solid = false;
            placeableLiquid = true;
            researchCost = with(DyItems.zinc, 10 * 10 * 5, DyItems.partBasic, 3 * 10 * 5);
        }};
    }
}
