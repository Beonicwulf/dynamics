package dynamics.content

import arc.math.geom.Rect
import arc.struct.Seq
import dynamics.type.DyUnitType
import mindustry.ai.UnitCommand
import mindustry.ai.types.*
import mindustry.content.Fx
import mindustry.entities.pattern.*
import mindustry.gen.*
import mindustry.graphics.*
import mindustry.type.UnitType
import mindustry.type.Weapon

import dynamics.content.DyBullets

object DyUnits {
	lateinit var respireWeapon: Weapon

	lateinit var respire: UnitType

	fun loadWeapons(){
		respireWeapon = Weapon("respire-weapon").apply{
			x = -2f
			y = -2f
			reload = 40
			inaccuracy = 10
			minWarmup = 0.25f
			bullet = DyBullets.respireBolt
			shoot = ShootPattern().apply{
				shots = 3
				shotDelay = 5
			}
		}
	}

	fun load(){
		var coreFleeRange = 500f
		loadWeapons()
		respire = DyUnitType("respire").apply{
			controller = u -> new BuilderAI(true, coreFleeRange)
			constructor = LegsUnit::create
		}
	}
}