package dynamics.ui;

import arc.Core;
import arc.struct.Seq;
import arc.util.Log;
import dynamics.content.DyPlanets;
import mindustry.content.TechTree;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Saves;
import mindustry.gen.Icon;
import mindustry.ui.Styles;

import static arc.Core.bundle;
import static arc.Core.settings;
import static mindustry.Vars.*;

public class DySettings {
    public static void loadSettings(){
        ui.settings.addCategory(bundle.get("setting.fb-dynamics-category"), Icon.planet, t -> {
            t.defaults().size(280f, 60f).left();
            t.checkPref("debug-access", false);
            t.row();
            t.checkPref("menu-reborne", true);
            t.row();
            t.button(bundle.get("setting.fb-dynamics-clear-tech-tree"), Icon.trash, Styles.flatt, () -> ui.showConfirm("@confirm", bundle.get("setting.fb-dynamics-clear-tech-tree.confirm"), () -> {
                DyPlanets.thalassa.techTree.reset();
                for (TechTree.TechNode node : DyPlanets.thalassa.techTree.children) {
                    node.reset();
                }
                content.each(c -> {
                    if (c instanceof UnlockableContent u && c.minfo != null && c.minfo.mod != null && c.minfo.mod.name.equals("fb-dynamics")) {
                        u.clearUnlock();
                    }
                });
                settings.remove("unlocks");
            })).marginLeft(4);
            t.row();
            t.button(bundle.get("setting.fb-dynamics-clear-campaign"), Icon.trash, Styles.flatt, () -> ui.showConfirm("@confirm", bundle.get("setting.fb-dynamics-clear-campaign.confirm"), () -> {
                Seq<Saves.SaveSlot> toDelete = Seq.with();
                control.saves.getSaveSlots().each(s -> {
                    if (s.getSector() == null) return;
                    if (s.getSector().planet == DyPlanets.thalassa) {
                        toDelete.add(s);
                        Log.info("Deleted Dynamics sector: " + s.getSector().id + (s.getSector().preset != null ? " " + s.getSector().preset.localizedName : ""));
                    }
                });
                toDelete.each(Saves.SaveSlot::delete);
                ui.showInfoOnHidden(bundle.get("setting.fb-dynamics-clear-campaign-close.confirm"), () -> Core.app.exit());
            })).marginLeft(4);
        });
    }
}
