package dynamics.world.draw;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.util.Eachable;
import mindustry.entities.units.BuildPlan;
import mindustry.gen.Building;
import mindustry.world.Block;

public class DrawPlanetaryGearR extends DrawGearR {
    public float length, armRotateSpeed;
    public TextureRegion armRegion;
    public String armSuffix = "-arm";
    public boolean mirror = false;
    public DrawPlanetaryGearR(float rotateSpeed, float length, float armRotateSpeed) {
        super(rotateSpeed);
        this.length = length; this.armRotateSpeed = armRotateSpeed;
    }
    public DrawPlanetaryGearR(float rotateSpeed, int toothCount, float length, float armRotateSpeed) {
        super(rotateSpeed, toothCount);
        this.length = length; this.armRotateSpeed = armRotateSpeed;
    }

    @Override
    public void draw(Building build){
        float z = Draw.z();
        if(layer > 0) Draw.z(layer);
        Draw.rect(armRegion, build.x + x, build.y + y, build.totalProgress() * armRotateSpeed + rotation);
        for (int i = 0; i < toothCount; i++) {
            Draw.rect(gearToothRegion, build.x + x + Mathf.cosDeg(build.totalProgress() * armRotateSpeed + rotation) * length, build.y + y + Mathf.sinDeg(build.totalProgress() * armRotateSpeed + rotation) * length, build.totalProgress() * (armRotateSpeed + rotateSpeed) + rotation + 360f/toothCount * i);
        }
        Draw.rect(gearTopRegion, build.x + x + Mathf.cosDeg(build.totalProgress() * armRotateSpeed + rotation) * length, build.y + y + Mathf.sinDeg(build.totalProgress() * armRotateSpeed + rotation) * length, build.totalProgress() * (armRotateSpeed + rotateSpeed) + rotation);
        Draw.z(z);
    }

    @Override
    public void load(Block block){
        super.load(block);
        gearToothRegion = Core.atlas.find(name != null ? name : block.name + gearSuffix + gearToothSuffix);
        gearTopRegion = Core.atlas.find(name != null ? name : block.name + gearSuffix + gearTopSuffix);
        armRegion = Core.atlas.find(name != null ? name : block.name + armSuffix);
    }
}
