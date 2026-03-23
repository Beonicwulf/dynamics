package dynamics.content.blocks;

import dynamics.content.DynamicsItems;
import dynamics.content.DynamicsLiquids;
import mindustry.content.Fx;
import mindustry.entities.effect.MultiEffect;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.production.BurstDrill;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class DynamicsProduction {
    public static Block
    clockworkDrill
    ;

    public static void load() {
        clockworkDrill = new BurstDrill("clockwork-drill") {{
            requirements(Category.production, with(DynamicsItems.zinc, 50, DynamicsItems.partBasic, 5));
            size = 3;
            drillTime = 60f * 18f;
            shake = 2f;
            drillEffect = new MultiEffect(Fx.mineImpact, Fx.drillSteam, Fx.mineImpactWave.wrap(Pal.redLight, 40f));
            consumeLiquid(DynamicsLiquids.steam, 12f / 60f);
            hasPower = false;
            tier = 2;
            drillMultipliers.put(DynamicsItems.zinc, 2f);
            arrows = 1;
        }};
    }
}
