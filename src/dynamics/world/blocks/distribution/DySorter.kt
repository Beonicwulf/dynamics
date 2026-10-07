package dynamics.world.blocks.distribution

import arc.Core
import arc.graphics.g2d.Draw
import arc.graphics.g2d.TextureRegion
import arc.util.Eachable
import mindustry.entities.units.BuildPlan
import mindustry.world.Tile
import mindustry.world.blocks.distribution.Sorter
import dynamics.Dynamics

class DySorter(name: String): Sorter(name) {

	lateinit var baseRegion: TextureRegion
	lateinit var itemRegion: TextureRegion

    init {
        placeableLiquid = true
    }

    override fun load() {
        super.load()
        baseRegion = Core.atlas.find(name)
        itemRegion = Core.atlas.find(name + "-item")
    }

    override fun drawPlanRegion(plan: BuildPlan, list: Eachable<BuildPlan>) {
        Draw.rect(baseRegion, plan.drawx(), plan.drawy())
    }

    override fun minimapColor(Tile tile): Int {
        val build = tile.build as? DySorterBuild
        return if (build == null || build.sortItem == null) 0 else build.sortItem.color.rgba()
    }

    override fun icons() = arrayOf(region)

    inner class DySorterBuild: SorterBuild {
        override fun draw() {
            Draw.rect(baseRegion, x, y)
            if (sortItem != null) {
                Draw.color(sortItem.color)
                Draw.rect(itemRegion, x, y)
                Draw.color()
            }
        }
    }
}