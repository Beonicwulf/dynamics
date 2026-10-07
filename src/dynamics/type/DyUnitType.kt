package dynamics.type

import mindustry.entities.part.RegionPart
import mindustry.type.UnitType

class DyUnitType(name: String): UnitType(name) {
	var bladeSpeed: Float = 10f
	var bladeTime: Float = 360f
	var blades: Int = 0

	fun drawBlades(bladeCount: Int = this.blades) {
		if (bladeCount <= 0) return
		for (i in 0 until bladeCount) {
			val blade = i
			parts.add(object : RegionPart("-blade") {
				init {
					outline = false
					moveRot = bladeTime * bladeSpeed
					progress = PartProgress.time.loop(bladeTime)
					rotation = 360f / bladeCount * blade
				}
			})
		}
		parts.add(RegionPart("-top"))
	}
}
