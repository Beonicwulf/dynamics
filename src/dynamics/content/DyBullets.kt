package dynamics.content

import mindustry.entities.bullet.*
import dynamics.graphics.DyPal

object DyBullets {
	lateinit var cargoBolt: MassDriverBolt

	fun load() {
		cargoBolt = MassDriverBolt().apply{
			collidesTiles = false;
			drawSize = 7f
			spin = 6f
			backColor = DyPal.zinc
			frontColor = DyPal.zinc
			speed = 0.3f
			damage = 50f
		}
	}
}
