package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.DirectionLiquidBridge;
import mindustry.world.blocks.liquid.*;

import static mindustry.type.ItemStack.*;

public class DynamicsLiquidBlocks {
    public static Block
            pipe, pipeRouter, pipeTunnel, pipeJunction
            ;

    public static void load() {
        pipe = new ArmoredConduit("pipe") {{
            requirements(Category.liquid, with(DynamicsItems.zinc, 2));
            leaks = true;
            underBullets = true;
            placeableLiquid = true;
            //explosivenessScale = flammabilityScale = 20f/50f;
        }};
        pipeRouter = new LiquidRouter("pipe-router") {{
            requirements(Category.liquid, with(DynamicsItems.zinc, 10, DynamicsItems.partBasic, 1));
            liquidCapacity = 40;
            size = 1;
            placeableLiquid = true;
            liquidPadding = 3f/4f;
            underBullets = true;
            solid = false;
            //explosivenessScale = flammabilityScale = 40f/150f;
        }};
        pipeJunction = new LiquidJunction("pipe-junction") {{
            requirements(Category.liquid, with(DynamicsItems.zinc, 10, DynamicsItems.partBasic, 1));
            size = 1;
            solid = false;
            placeableLiquid = true;
            underBullets = true;
        }};
        pipeTunnel = new DirectionLiquidBridge("pipe-tunnel") {{
            requirements(Category.liquid, with(DynamicsItems.zinc, 20, DynamicsItems.partBasic, 5));
            solid = false;
            range = 8;
            hasPower = false;
            liquidCapacity = 60f;
            underBullets = true;
            //explosivenessScale = flammabilityScale = 20f/120f;
            ((Conduit)pipe).rotBridgeReplacement = this;
        }};
    }
}
