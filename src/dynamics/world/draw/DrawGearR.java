package dynamics.world.draw;

import arc.Core;
import arc.graphics.g2d.*;
import arc.util.Eachable;
import mindustry.entities.units.BuildPlan;
import mindustry.gen.Building;
import mindustry.world.Block;
import mindustry.world.draw.DrawRegion;

public class DrawGearR extends DrawRegion {
    public TextureRegion gearToothRegion, gearTopRegion;
    public String gearSuffix = "-gear";
    public String gearToothSuffix = "-tooth";
    public String gearTopSuffix = "-top";
    public int toothCount = 6;
    public float rotateSpeed, x, y, rotation;
    //Any number <=0 disables layer changes.
    public float layer = -1;

    public DrawGearR(float rotateSpeed){
        this.rotateSpeed = rotateSpeed;
    }

    public DrawGearR(float rotateSpeed, int toothCount){
        this.rotateSpeed = rotateSpeed;
        this.toothCount = toothCount;
    }

    @Override
    public void draw(Building build){
        float z = Draw.z();
        if(layer > 0) Draw.z(layer);
        for (int i = 0; i < toothCount; i++) {
            Draw.rect(gearToothRegion, build.x + x, build.y + y, build.totalProgress() * rotateSpeed + rotation + 360f/toothCount * i);
        }
        Draw.rect(gearTopRegion, build.x + x, build.y + y, build.totalProgress() * rotateSpeed + rotation);
        Draw.z(z);
    }

    @Override
    public void load(Block block){
        super.load(block);
        gearToothRegion = Core.atlas.find(name != null ? name : block.name + gearSuffix + gearToothSuffix);
        gearTopRegion = Core.atlas.find(name != null ? name : block.name + gearSuffix + gearTopSuffix);
    }
}
