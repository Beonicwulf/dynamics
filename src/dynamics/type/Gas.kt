package dynamics.type

import arc.Core
import arc.graphics.Color
import mindustry.type.Liquid

class Gas: Liquid {
	constructor(String name, Color color): super(name, color) {
		gas = true
		localizedName = Core.bundle.get("gas." + name + ".name", name);
        description = Core.bundle.getOrNull("gas." + name + ".description");
        details = Core.bundle.getOrNull("gas." + name + ".details");
        credit = Core.bundle.getOrNull("gas." + name + ".credit");
	}
}