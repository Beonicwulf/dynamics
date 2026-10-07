package dynamics.content

import mindustry.entities.bullet.*
import dynamics.graphics.DyPal
import mindustry.content.Fx;

object DyBullets {
	lateinit var cargoBolt: MassDriverBolt
	lateinit var respireBolt: BasicBulletType

	fun load() {
		cargoBolt = MassDriverBolt().apply{
			collidesTiles = true
			width = 7f
			height = 7f
			spin = 6f
			backColor = DyPal.zinc
			frontColor = DyPal.zinc
			shrinkY = 0f
			speed = 0.3f
			damage = 50
			sprite = "dy-shell"
		}

		respireBolt = BasicBulletType(4f, 15, "dy-respire-bolt").apply{
			hitColor = DyPal.sodium
			trailColor = DyPal.sodium
			lifetime = 40f
			homingDelay = 15f
			height = 7f
            width = 7f
            shrinkY = 0f
            trailWidth = 0.9f
            trailLength = 5f
            homingPower = 0.3f
            homingDelay = 4f
            homingRange = 50f
            spin = 3.5f
            hitEffect = Fx.hitBulletColor
            despawnEffect = Fx.hitBulletColor
		}
	}
}
