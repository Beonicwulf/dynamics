package dynamics.type;

import mindustry.entities.part.RegionPart;
import mindustry.type.UnitType;

public class DyUnitType extends UnitType {
    public float bladeSpeed = 10f;
    public float bladeTime = 360f;
    public int blades;

    public DyUnitType(String name) {
        super(name);
    }

    public void drawBlades(int blades){
        for (int i = 0; i < blades; i++) {
            int blade = i;
            parts.add(new RegionPart("-blade"){{
                outline = false;
                moveRot = bladeTime * bladeSpeed;
                progress = PartProgress.time.loop(bladeTime);
                rotation = 360f/blades * blade;
            }});
        }
        parts.add(new RegionPart("-top"));
    }

    public void drawBlades(){
        if (blades > 0){drawBlades(blades);}
    }
}
