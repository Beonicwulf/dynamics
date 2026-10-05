package dynamics.type

import arc.Core
import arc.graphics.Color
import mindustry.type.Liquid
import dynamics.world.meta.DyStat

class Gas: Liquid {
	var pressure = 0.3f

	constructor(name: String, color: Color): super(name, color) {
		gas = true
		localizedName = Core.bundle.get("gas.$name.name", name)
        description = Core.bundle.getOrNull("gas.$name.description")
        details = Core.bundle.getOrNull("gas.$name.details")
        credit = Core.bundle.getOrNull("gas.$name.credit")
	}

	override fun setStats(){
		super.setStats()
		stats.addPercent(DyStat.pressure, pressure);
	}
}