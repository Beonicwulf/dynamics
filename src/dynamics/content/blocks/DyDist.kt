package dynamics.content.blocks

import dynamics.content.DyResources
import mindustry.type.Category
import mindustry.type.ItemStack
import mindustry.world.Block
import mindustry.world.blocks.distribution.MassDriver

import mindustry.type.ItemStack.with
import dynamics.content.DyBullets

object DyDist {
	lateinit var cargoCannon: Block

	fun load() {
		cargoCannon = MassDriver("cargo-cannon").apply{
			requirements(Category.distribution, with(DyResources.zinc, 5))
			researchCost = ItemStack.mult(requirements, 5f)
			size = 1
			itemCapacity = 10
			hasPower = false
			range = 60f
			rotateSpeed = 10f
			reload = 15f
			shake = 0.4f
			knockback = 2f
			shootSoundVolume = 0.1f
			bullet = DyBullets.cargoBolt
		}
	}
}