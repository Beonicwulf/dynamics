package dynamics.world.draw;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import mindustry.gen.Building;
import mindustry.world.Block;

public class DrawOrbitingGears extends DrawPlanetaryGear {
    public int iterations;
    public int toothInterval = 0;
    public float speedInterval = 0f;
    public float lengthInterval = 1f;

    public boolean iterateSprites = false;
    public boolean iterateArmSprites = true;
    public TextureRegion[] gearToothRegions, gearTopRegions, armRegions;

    public DrawOrbitingGears(int iterations, float rotateSpeed, float length, float armRotateSpeed) {
        super(rotateSpeed, length, armRotateSpeed);
        this.iterations = iterations;
    }

    public DrawOrbitingGears(int iterations, float rotateSpeed, float length, float armRotateSpeed, int toothCount) {
        super(rotateSpeed, length, armRotateSpeed, toothCount);
        this.iterations = iterations;
    }

    @Override
    public void draw(Building build){
        float z = Draw.z();
        if(layer > 0) Draw.z(layer);
        OrbitingGears(build, false);
        if (mirror){
            OrbitingGears(build, true);
        }
        Draw.z(z);
    }

    private void OrbitingGears(Building build, boolean mirrored) {
        for (int iteration = 0; iteration < iterations; iteration++) {
            float iteratedLength = length * Mathf.pow(iteration + 1, lengthInterval);
            float iteratedOffset = iteration * 360f / iterations;
            float iteratedAngle = build.totalProgress() * armRotateSpeed * Mathf.pow(iteration + 1, speedInterval) + rotation + iteratedOffset;
            if (mirrored){iteratedAngle += 180;}
            int iteratedToothCount = toothCount + toothInterval * iteration;
            if (iterateSprites || iterateArmSprites){
                Draw.rect(armRegions[iteration], build.x + x, build.y + y, iteratedAngle);
            } else {
                Draw.rect(armRegion, build.x + x, build.y + y, iteratedAngle);
            }
            if (iterateSprites){
                for (int i = 0; i < iteratedToothCount; i++) {
                    Draw.rect(gearToothRegions[iteration], build.x + x + Mathf.cosDeg(iteratedAngle) * (iteratedLength), build.y + y + Mathf.sinDeg(iteratedAngle) * (iteratedLength), build.totalProgress() * (armRotateSpeed + rotateSpeed) + rotation + 360f/iteratedToothCount * i);
                }
                Draw.rect(gearTopRegions[iteration], build.x + x + Mathf.cosDeg(iteratedAngle) * (iteratedLength), build.y + y + Mathf.sinDeg(iteratedAngle) * (iteratedLength), build.totalProgress() * (armRotateSpeed + rotateSpeed) + rotation);
            } else {
                for (int i = 0; i < iteratedToothCount; i++) {
                    Draw.rect(gearToothRegion, build.x + x + Mathf.cosDeg(iteratedAngle) * (iteratedLength), build.y + y + Mathf.sinDeg(iteratedAngle) * (iteratedLength), build.totalProgress() * (armRotateSpeed + rotateSpeed) + rotation + 360f/iteratedToothCount * i);
                }
                Draw.rect(gearTopRegion, build.x + x + Mathf.cosDeg(iteratedAngle) * (iteratedLength), build.y + y + Mathf.sinDeg(iteratedAngle) * (iteratedLength), build.totalProgress() * (armRotateSpeed + rotateSpeed) + rotation);
            }
        }
    }

    @Override
    public void load(Block block){
        super.load(block);
        if (iterateSprites || iterateArmSprites){
            for (int i = 0; i < iterations; i++) {
                String iter = Integer.toString(i);
                armRegions[i] = Core.atlas.find(name != null ? name : block.name + armSuffix + iter);
            }
        }
        if (iterateSprites) {
            for (int i = 0; i < iterations; i++) {
                String iter = Integer.toString(i);
                gearToothRegions[i] = Core.atlas.find(name != null ? name : block.name + gearSuffix + gearToothSuffix + iter);
                gearTopRegions[i] = Core.atlas.find(name != null ? name : block.name + gearSuffix + gearTopSuffix + iter);
            }
        }
    }
}
