package dynamics.world.blocks.effect;

import dynamics.content.DyUnits;
import dynamics.graphics.DyPal;
import mindustry.entities.Units;
import mindustry.game.Team;
import mindustry.world.Tile;
import mindustry.world.blocks.units.UnitCargoLoader;

public class UnitPad extends UnitCargoLoader {
    public boolean requiresCoreZone = false;
    public boolean drawTeam;

    public UnitPad(String name) {
        super(name);
        unitType = DyUnits.augerDrone;
        unitBuildTime = 60f * 8f;
        polyColor = DyPal.malachite;
        itemCapacity = 0;
    }

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation){
        //if(!requiresCoreZone) return super.canPlaceOn(tile, team, rotation) && Units.canCreate(team, unitType);

        //special floor upon which cores can be placed
        tile.getLinkedTilesAs(this, tempTiles);
        if(!tempTiles.contains(o -> !o.floor().allowCorePlacement)){
            return true;
        }
        return (!requiresCoreZone || tempTiles.allMatch(o -> o.floor().allowCorePlacement)) && super.canPlaceOn(tile, team, rotation) && Units.canCreate(team, unitType);
    }

    public class UnitPadBuild extends UnitCargoLoader.UnitTransportSourceBuild {

        @Override
        public boolean shouldConsume(){
            return true;
        }

        @Override
        public void updateTile(){
            super.updateTile();
            if(efficiency < 1 && unit != null){unit.destroy();}
        }

        @Override
        public void draw(){
            super.draw();
            if (drawTeam) drawTeamTop();
        }
    }
}


