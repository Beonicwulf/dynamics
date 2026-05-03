package dynamics.content;

import arc.Core;
import arc.Events;
import arc.audio.Music;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.gen.Musics;

public class DyMusic {
    public static Music reborne;
    // preload check
    public static void preload(){
        Events.on(EventType.MusicRegisterEvent.class, e -> load());
    }
    // loads the music
    public static void load(){
        reborne = Vars.tree.loadMusic("reborne");
        // replaces main menu theme if the option is enabled
        if (Core.settings.getBool("menu-reborne")) {Musics.menu = reborne;}
    }
}
