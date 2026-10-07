package dynamics.content

import dynamics.type.DyUnitType
import mindustry.ai.types.*
import mindustry.entities.pattern.*
import mindustry.gen.*
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
			reload = 40f
			inaccuracy = 10f
			minWarmup = 0.25f
			bullet = DyBullets.respireBolt
			shoot = ShootPattern().apply{
				shots = 3
				shotDelay = 5f
			}
		}
	}

	fun load(){
		val coreFleeRange = 500f
		loadWeapons()
		respire = DyUnitType("respire").apply{
			controller = { u -> BuilderAI(true, coreFleeRange) }
			constructor = { LegsUnit.create() } 
		}
	}
}
