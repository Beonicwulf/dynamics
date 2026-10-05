package dynamics.content

import mindustry.entities.bullet.*
import dynamics.graphics.DyPal

object DyBullets {
	lateinit var cargoBolt: MassDriverBolt

	fun load() {
		cargoBolt = MassDriverBolt().apply{
			collidesTiles = false;
			drawSize = 2.5f
			spin = 6f
			backColor = DyPal.zinc
			frontColor = DyPal.zinc
			speed = 0.3f
			damage = 50f
			backSprite = "shell"
			shrinkY = 0f
		}
	}
}
