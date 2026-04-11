package dynamics.content;

import arc.Events;
import arc.audio.Music;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.gen.Musics;

public class DyMusics {
    public static Music reborne;

    public static void preload(){
        Events.on(EventType.MusicRegisterEvent.class, e -> load());
    }

    public static void load(){
        reborne = Vars.tree.loadMusic("reborne");
        Musics.menu = reborne;
    }
}
