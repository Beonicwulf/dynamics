package dynamics.content

import mindustry.entities.bullet.*
import dynamics.graphics.DyPal

object DyBullets {
	lateinit var cargoBolt: BulletType

	fun load() {
		cargoBolt = MassDriverBolt().apply{
			collidesTiles = false;
			width = 7f
			height = 7f
			shrinkY = 0f
			spin = 3f
			backColor = DyPal.zinc
			frontColor = DyPal.zinc
		}
	}
}
