package dynamics.content

import arc.struct.*

import dynamics.graphics.DyPal
import mindustry.type.*
import mindustry.content.Liquids.water
import dynamics.type.Gas

object DyResources {
    // Embark
    lateinit var zinc: Item
    lateinit var quartz: Item
    lateinit var cinnabar: Item
    lateinit var steam: Gas
    lateinit var amalgam: Item
    // Shallows
    lateinit var sodium: Item
    lateinit var chlorine: Gas
    // Cove
    lateinit var malachite: Item
    // Trench
    lateinit var tantalum: Item
    // Ichorites
    lateinit var ichor: Liquid
    lateinit var aether: Gas
    lateinit var pneuma: Gas

    val dynamicsItems = Seq<Item>()

    fun load() {
       // Embark
       zinc = Item("zinc", DyPal.zinc).apply{
         cost = 1f
         hardness = 1
         healthScaling = 0.1f
       }
       quartz = Item("quartz", DyPal.quartz).apply{
            hardness = 2
            lowPriority = true
        }
        cinnabar = Item("cinnabar", DyPal.cinnabar).apply{
            hardness = 1
            lowPriority = true
            buildable = false
        }
        steam = Gas("steam", DyPal.steam).apply{
            explosiveness = 0.6f
            pressure = 0.5f
        }
        amalgam = Item("amalgam", DyPal.amalgam)
        // Shallows
        sodium = Item("sodium", DyPal.sodium)
        chlorine = Gas("chlorine", DyPal.chlorine).apply{
            flammability = 1f
        }
        // Cove
        malachite = Item("malachite", DyPal.malachite).apply{
            cost = 1.2f
            hardness = 2
            charge = 0.3f
        }
        // Trench
        tantalum = Item("tantalum", DyPal.tantalum).apply{
            hardness = 3
            cost = 1.4f
            healthScaling = 1f
        }
        // Ichorites
        ichor = Liquid("ichor").apply{
            viscosity = 0.75f
            flammability = 0.9f
            explosiveness = 0.7f
            canStayOn.add(water)
        }
        aether = Gas("aether", DyPal.aether).apply{
            flammability = 1.2f
            explosiveness = 1.2f
        }
        pneuma = Gas("pneuma", DyPal.pneuma).apply{
            pressure = 0.8f
        }

        dynamicsItems.addAll(zinc, quartz, cinnabar, amalgam, sodium, malachite, tantalum)
    }
}
