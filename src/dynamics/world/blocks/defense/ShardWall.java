package dynamics.world.blocks.defense;

import arc.math.Mathf;
import dynamics.content.DyBulletTypes;
import mindustry.entities.bullet.BulletType;
import mindustry.gen.Bullet;
import mindustry.world.blocks.defense.Wall;

public class ShardWall extends Wall {
    public float shardChance = -1f;
    public BulletType shard = DyBulletTypes.malachiteShards;
    public ShardWall(String name) {
        super(name);
    }

    public class ShardWallBuild extends WallBuild{
        @Override
        public boolean collision(Bullet bullet) {
            super.collision(bullet);
            //create shard if necessary
            if (shardChance > 0f) {
                if (Mathf.chance(shardChance)) {
                    shard.create(team.core(), x, y, Mathf.random(0f, 360f));
                }
            }
            return true;
        }

    }
}