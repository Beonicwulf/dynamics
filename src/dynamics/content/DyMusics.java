package dynamics.content;

import arc.*;
import arc.audio.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import dynamics.content.blocks.DyEffectBlocks;

/**
 * Manages music, including vanilla and custom tracks.
 * @author stabu_
 */
public class DyMusics {
    public static Music
            // Vanilla
            launch, land,
            // Reborne
            reborne
            ;

    public static void load(){
        launch = Musics.launch;
        land = Musics.land;
        reborne = Vars.tree.loadMusic("reborne");

        setupEventHandlers();
    }

    /** Sets up event handlers for updating music based on game events. */
    private static void setupEventHandlers(){
        Events.run(EventType.Trigger.update, DyMusics::updateLaunchMusic);
        Events.on(WorldLoadEvent.class, e -> updateLandMusic());
    }

    /** Updates launch music based on current planet. */
    private static void updateLaunchMusic(){
        Musics.launch = (Vars.ui.planet.state.planet == DyPlanets.thalassa || Vars.ui.planet.state.planet == DyPlanets.khione)
                ? reborne
                : launch;
    }

    /** Updates landing music based on core block type. */
    private static void updateLandMusic(){
        Vars.state.rules.defaultTeam.cores().each(core ->
                Musics.land = (core.block == DyEffectBlocks.coreSurface)
                        ? reborne
                        : land);
    }
}

// Thanks, Stabu_
// Source: https://github.com/stabu-dev/Omaloon/blob/master/src/omaloon/content/OlMusics.java
// HEAVILY modified and cut down