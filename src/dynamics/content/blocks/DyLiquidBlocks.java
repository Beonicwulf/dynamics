package dynamics.content.blocks;

import dynamics.content.DyItems;
import dynamics.world.blocks.fluid.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.DirectionLiquidBridge;
import mindustry.world.blocks.liquid.*;

import static mindustry.type.ItemStack.*;

public class DyLiquidBlocks {
    public static Block
            pipe, pipeRouter, pipeTunnel,
            pipeJunction, pipeVent, pipeController;
    public static void load() {
        pipe = new ArmoredConduit("pipe") {{
            requirements(Category.liquid, with(DyItems.zinc, 2));
            researchCost = ItemStack.mult(requirements, 5);
            leaks = true;
            underBullets = true;
            placeableLiquid = true;
            //explosivenessScale = flammabilityScale = 20f/50f;
        }};
        pipeRouter = new LiquidRouter("pipe-router") {{
            requirements(Category.liquid, with(DyItems.zinc, 10, DyItems.partBasic, 1));
            researchCost = ItemStack.mult(requirements, 5);
            liquidCapacity = 40;
            size = 1;
            placeableLiquid = true;
            liquidPadding = 3f/4f;
            underBullets = true;
            solid = false;
            //explosivenessScale = flammabilityScale = 40f/150f;
        }};
        pipeJunction = new FluidValve("pipe-junction") {{
            requirements(Category.liquid, with(DyItems.zinc, 10, DyItems.partBasic, 1));
            researchCost = ItemStack.mult(requirements, 10);
            size = 1;
            solid = false;
            placeableLiquid = true;
            underBullets = true;
            ((Conduit)pipe).junctionReplacement = this;
        }};
        pipeTunnel = new DirectionLiquidBridge("pipe-tunnel") {{
            requirements(Category.liquid, with(DyItems.zinc, 20, DyItems.partBasic, 5));
            researchCost = ItemStack.mult(requirements, 10);
            solid = false;
            placeableLiquid = true;
            range = 8;
            hasPower = false;
            liquidCapacity = 60f;
            underBullets = true;
            //explosivenessScale = flammabilityScale = 20f/120f;
            ((Conduit)pipe).rotBridgeReplacement = this;
        }};
        pipeVent = new FluidVent("pipe-vent") {{
            requirements(Category.liquid, with(DyItems.zinc, 10));
            researchCost = ItemStack.mult(requirements, 50);
            size = 1;
            minPressure = -0.25f;
            ventRate = 0.5f;
            liquidCapacity = 100;
            solid = false;
            placeableLiquid = true;
        }};
        pipeController = new ValveController("pipe-controller") {{
            requirements(Category.liquid, with(DyItems.zinc, 10, DyItems.partBasic, 3));
            researchCost = ItemStack.mult(requirements, 50);
            size = 1;
            solid = false;
            placeableLiquid = true;
        }};
    }
}
