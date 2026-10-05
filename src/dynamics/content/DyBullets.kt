package dynamics.content

import mindustry.entities.bullet.*
import dynamics.graphics.DyPal

object DyBullets {
	lateinit var cargoBolt: MassDriverBolt

	fun load() {
		cargoBolt = MassDriverBolt().apply{
			collidesTiles = true
			width = 7f
			height = 7f
			spin = 6f
			backColor = DyPal.zinc
			frontColor = DyPal.zinc
			speed = 0.3f
			damage = 50f
			shrinkY = 0f
			sprite = "dy-shell"
		}
	}
}
