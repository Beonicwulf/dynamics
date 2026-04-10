package dynamics.content;

import arc.audio.Music;
import mindustry.Vars;

public class DynamicsMusics {
    // Yes, musics not music because that's how it is in the game source code, and who am I to argue.
    // I'm also using Omaloon as reference for this.

    public static Music
            reborne
            ;

    public static void load(){
        reborne = loadMusic("reborne");
    }

    /** Loads a music file from the game's asset tree. */
    private static Music loadMusic(String name){
        return Vars.tree.loadMusic(name);
    }
}

// Omaloon code used as reference: https://github.com/stabu-dev/Omaloon/blob/master/src/omaloon/content/OlMusics.java