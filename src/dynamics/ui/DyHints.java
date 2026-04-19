package dynamics.ui;

import arc.*;
import arc.func.*;
import arc.struct.*;
import arc.util.*;
import dynamics.content.blocks.DyDefense;
import dynamics.content.blocks.DyProduction;
import mindustry.*;
import mindustry.game.EventType;
import mindustry.ui.fragments.HintsFragment.*;

public enum DyHints implements Hint {
    reborne(
            () -> false,
            () -> !Core.settings.getBool("menu-reborne")
    ),
    collector(
            () -> false,
            () -> Vars.control.input.block == DyProduction.steamCollector
    ),
    valve(
            () -> false,
            () -> Vars.control.input.block == DyDefense.steamValve
    );

    final Boolp complete;
    Boolp shown = () -> true;
    DyHints[] requirements;

    int visibility = visibleAll;
    boolean cached, finished;

    static final String prefix = "dy-";

    public static void addHints(){
        Vars.ui.hints.hints.add(Seq.with(DyHints.values()).removeAll(
                hint -> Core.settings.getBool(prefix + hint.name() + "-hint-done", false)
        ));
    }

    DyHints(Boolp complete){
        this.complete = complete;
    }

    DyHints(Boolp complete, Boolp shown){
        this(complete);
        this.shown = shown;
    }

    DyHints(Boolp complete, Boolp shown, DyHints... requirements){
        this(complete, shown);
        this.requirements = requirements;
    }

    public static void preInit() {
        Events.on(EventType.ClientLoadEvent.class, e -> init());
    }

    public static void init() {
        Vars.ui.hints.hints.add(Seq.with(values()).removeAll(hint -> Core.settings.getBool(prefix + hint.name() + "-hint-done", false)));
    }

    @Override
    public boolean complete(){
        return complete.get();
    }

    @Override
    public void finish(){
        Core.settings.put(prefix + name() + "-hint-done", finished = true);
    }

    @Override
    public boolean finished(){
        if(!cached){
            cached = true;
            finished = Core.settings.getBool(prefix + name() + "-hint-done", false);
        }
        return finished;
    }

    @Override
    public int order(){
        return ordinal();
    }

    public static void reset(){
        for(DyHints hint : values()){
            Core.settings.put(prefix + hint.name() + "-hint-done", hint.finished = false);
        }
        addHints();
    }

    @Override
    public boolean show(){
        return shown.get() && (requirements == null || (requirements.length == 0 || !Structs.contains(requirements, d -> !d.finished())));
    }

    @Override
    public String text(){
        return Core.bundle.get("hint." + prefix + name(), "Missing bundle for hint: hint." + prefix + name());
    }

    @Override
    public boolean valid(){
        return (Vars.mobile && (visibility & visibleMobile) != 0) || (!Vars.mobile && (visibility & visibleDesktop) != 0);
    }
}

// Thanks uujuju1
// Source: https://github.com/uujuju1/Steam-Works/blob/9a85ed1712f6c1e1c67093c49ea0454287d111ad/src/sw/ui/EventHints.java