package dynamics.content

import arc.struct.*

import dynamics.graphics.DyPal
import mindustry.type.*

object DyResources {
	// Embark
	lateinit var zinc: Item
	lateinit var quartz: Item
	lateinit var cinnabar: Item
	lateinit var steam: Liquid
	lateinit var amalgam: Item
	// Shallows
	lateinit var sodium: Item
	lateinit var chlorine: Liquid
	// Cove
	lateinit var malachite: Item
	// Trench
	lateinit var tantalum: Item
	// Ichorites
	lateinit var ichor: Liquid
	lateinit var aether: Liquid
	lateinit var pneuma: Liquid

	val dynamicsItems = Seq<Item>()

	fun load() {
		// Embark
		zinc = object: Item("zinc", DyPal.zinc) {init{
			cost = 1f
			hardness = 1f
			healthScaling = 0.1f
		}}
		quartz = object: Item("quartz", DyPal.quartz) {init{
            hardness = 2f
            lowPriority = true
        }}
        cinnabar = object: Item("cinnabar", DyPal.cinnabar) {init{
            hardness = 1f
            lowPriority = true
            buildable = false
        }}
        steam = object: Liquid("steam", DyPal.steam){init{
        	gas = true
            explosiveness = 0.6f
        }}
        amalgam = object: Item("amalgam", DyPal.amalgam)
        // Shallows
        sodium = object: Item("sodium", DyPal.sodium)
        chlorine = object: :Liquid("chlorine", DyPal.chlorine){init{
        	gas = true
            flammability = 1f
        }}
        // Cove
        malachite = object: Item("malachite", DyPal.malachite) {init{
            cost = 1.2f
            hardness = 2f
            charge = 0.3f
        }}
        // Trench
        tantalum = object: Item("tantalum", DyPal.tantalum) {init{
            hardness = 3f
            cost = 1.4f
            healthScaling = 1f
        }}
        // Ichorites
        ichor = new Liquid("ichor"){init{
            viscosity = 0.75f
            flammability = 0.9f
            explosiveness = 0.7f
            canStayOn.add(water)
        }}
        aether = object: Liquid("aether", DyPal.aether){init{
        	gas = true
            flammability = 1.2f
            explosiveness = 1.2f
        }}
        pneuma = object: Liquid("pneuma", DyPal.pneuma){init{
        	gas = true
        }}

        dynamicsItems.addAll(zinc, quartz, cinnabar, amalgam, sodium, malachite, tantalum)
	}
}