package dynamics.core;

import arc.*;
import arc.graphics.*;
import arc.scene.style.*;
import arc.scene.ui.layout.*;
import arc.struct.*;
import arc.util.*;
import dynamics.ui.DyHints;
import mindustry.*;
import mindustry.content.TechTree;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Saves;
import mindustry.gen.*;
import mindustry.ui.*;
import mindustry.ui.dialogs.*;
import mindustry.ui.dialogs.SettingsMenuDialog.*;
import dynamics.*;
import dynamics.content.*;

import static arc.Core.bundle;
import static mindustry.Vars.*;

public class ModSettings {
    public static BaseDialog game, gameData;

    private static Table settings;
    public static Seq<SettingsTable> categories = new Seq<>();

    public static void buildSettings() {
        // game
        categories.add(new SettingsTable() {{
            checkPref("debug-access", false);
            checkPref("menu-reborne", true);
        }});
    }

    public static void load() {
        game = new BaseDialog("@settings.game") {{
            cont.pane(settings = new Table()).grow().top();
            addCloseButton();
        }};
        gameData = new BaseDialog("@settings.dy-mod-data") {{
            addCloseButton();
            cont.table(Tex.button, cat -> {
                cat.button(bundle.get("setting.dy-clear-tech-tree"), Icon.trash, Styles.flatt, iconMed, () -> ui.showConfirm("@confirm", bundle.get("setting.dy-clear-tech-tree.confirm"), () -> {
                    DyPlanets.thalassa.techTree.reset();
                    for (TechTree.TechNode node : DyPlanets.thalassa.techTree.children) {
                        node.reset();
                    }
                    content.each(c -> {
                        if (c instanceof UnlockableContent u && c.minfo != null && c.minfo.mod != null && c.minfo.mod.name.equals("dy")) {
                            u.clearUnlock();
                        }
                    });
                    Core.settings.remove("unlocks");
                })).growX().marginLeft(8).height(50).row();
                cat.button(bundle.get("setting.dy-clear-campaign"), Icon.trash, Styles.flatt, iconMed, () -> ui.showConfirm("@confirm", bundle.get("setting.dy-clear-campaign.confirm"), () -> {
                    Seq<Saves.SaveSlot> toDelete = Seq.with();
                    control.saves.getSaveSlots().each(s -> {
                        if (s.getSector() == null) return;
                        if (s.getSector().planet == DyPlanets.thalassa) {
                            toDelete.add(s);
                            Log.info("Deleted Dynamics sector: " + s.getSector().id + (s.getSector().preset != null ? " " + s.getSector().preset.localizedName : ""));
                        }
                    });
                    toDelete.each(Saves.SaveSlot::delete);
                    ui.showInfoOnHidden(bundle.get("setting.dy-clear-campaign-close.confirm"), () -> Core.app.exit());
                })).growX().marginLeft(8).height(50).row();
                cat.button(bundle.get("setting.dy-reset-hints"), Icon.trash, Styles.flatt, Vars.iconMed, () -> Vars.ui.showConfirm(bundle.get("setting.dy-reset-hints.confirm"),
                        DyHints::reset
                )).growX().marginLeft(8).height(50).row();
            }).width(400f).row();
        }};
        Vars.ui.settings.addCategory(Core.bundle.get("dy-settings"), Icon.planet, table -> table.table(Tex.button, t -> {
            t.button(
                    "@settings.game",
                    Icon.settings,
                    Styles.flatt,
                    iconMed,
                    () -> show(0)
            ).growX().minWidth(300f).marginLeft(8f).height(50f).row();
            t.button(
                    "@settings.dy-mod-data",
                    Icon.save,
                    Styles.flatt,
                    iconMed,
                    () -> gameData.show()
            ).growX().minWidth(300f).marginLeft(8f).height(50f).row();
        }));
        buildSettings();
    }

    public static void show(int cat) {
        if (cat < 0 || cat >= categories.size) {
            Log.err("Category out of Bounds");
            return;
        }
        settings.clearChildren();
        settings.add(categories.get(cat));
        categories.get(cat).rebuild();
        game.show();
    }
}

// Thanks, uujuju1
// Source: https://github.com/uujuju1/Steam-Works/blob/9a85ed1712f6c1e1c67093c49ea0454287d111ad/src/sw/core/ModSettings.java#L85