package dynamics.content

import mindustry.entities.bullet.*
import dynamics.graphics.DyPal

object DyBullets {
	lateinit var cargoBolt: BulletType

	fun load() {
		cargoBolt = MassDriverBolt().apply{
			collidesTiles = false;
			width = height = 7
			shrinkY = 0f
			spin = 3
			backColor = frontColor = DyPal.zinc
		}
	}
}
