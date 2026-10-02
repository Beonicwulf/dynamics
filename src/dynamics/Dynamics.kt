package dynamics

import arc.*
import arc.util.*
import mindustry.mod.*
import dynamics.content.*

class Dynamics : Mod() {
    override fun loadContent() {
        DyResources.load()
        DyBlocks.load()
    }
}
