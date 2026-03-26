package dynamics.world.blocks.distribution;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.util.Eachable;
import dynamics.Dynamics;
import mindustry.entities.units.BuildPlan;
import mindustry.world.Tile;
import mindustry.world.blocks.distribution.DuctRouter;

public class DirectionalSorter extends DuctRouter {
    public TextureRegion baseRegion, itemRegion;

    public DirectionalSorter(String name) {
        super(name);

        placeableLiquid = true;
        drawTeamOverlay = false;
    }

    @Override
    public void load() {
        super.load();
        baseRegion = Core.atlas.find(Dynamics.name("zinc-sorter"));
        itemRegion = Core.atlas.find(Dynamics.name("zinc-sorter-center"));
        topRegion = Core.atlas.find(name + "-top");
    }

    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list) {
        Draw.rect(baseRegion, plan.drawx(), plan.drawy());
        Draw.rect(topRegion, plan.drawx(), plan.drawy(), plan.rotation * 90);
    }

    @Override
    public int minimapColor(Tile tile){
        var build = (DirectionalSorterBuild)tile.build;
        return build == null || build.sortItem == null ? 0 : build.sortItem.color.rgba();
    }

    public TextureRegion[] icons() {
        return new TextureRegion[]{region};
    }

    public class DirectionalSorterBuild extends DuctRouterBuild {
        @Override
        public void draw() {
            Draw.rect(baseRegion, x, y);
            if (sortItem != null) {
                Draw.color(sortItem.color);
                Draw.rect(itemRegion, x, y);
                Draw.color();
            }else{
                Draw.rect(topRegion, x, y, rotdeg());
            }
        }
    }
}

// Taken from New Horizons mod & modified/fixed
// Source: https://github.com/Yuria-Shikibe/NewHorizonMod/blob/78266dbf908907e4316391152ac36d99f4ac52fa/src/newhorizon/expand/block/distribution/item/logistics/AdaptDirectionalRouter.java
