package dynamics.graphics;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.draw.DrawRegion;

public class DrawGear extends DrawRegion {
    public TextureRegion gearRegion, turnRegion;
    public String gearSuffix = "-gear";
    public float rotateSpeed, x, y, rotation;
    /** Any number <=0 disables layer changes. */
    public float layer = -1;

    public DrawGear(float rotateSpeed){
        this.rotateSpeed = rotateSpeed;
    }

    public DrawGear(float rotateSpeed, float x, float y){
        this.rotateSpeed = rotateSpeed;
        this.x = x; this.y = y;
    }

    @Override
    public void draw(Building build){
        float z = Draw.z();
        if(layer > 0) Draw.z(layer);
        Drawf.spinSprite(gearRegion, build.x + x, build.y + y, build.totalProgress() * rotateSpeed + rotation);
        Drawf.spinSprite(turnRegion, build.x + x, build.y + y, build.totalProgress() * rotateSpeed + rotation + 45);
        Draw.z(z);
    }

    @Override
    public void load(Block block){
        super.load(block);
        gearRegion = Core.atlas.find(name != null ? name : block.name + gearSuffix);
        turnRegion = Core.atlas.find(name != null ? name : block.name + gearSuffix + "-turn");
    }
}
