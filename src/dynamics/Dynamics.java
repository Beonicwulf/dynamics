package dynamics;

import arc.Core;
import arc.struct.Seq;
import arc.util.Log;
import dynamics.content.*;
import dynamics.content.DynamicsTeams;
import dynamics.ui.ButtonPref;
import mindustry.content.TechTree;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Saves;
import mindustry.gen.Icon;
import mindustry.mod.*;

import static arc.Core.bundle;
import static arc.Core.settings;
import static mindustry.Vars.*;

public class Dynamics extends Mod{
    public static final String MOD_NAME = "fb-dynamics";

    public static String name(String name) {
        return MOD_NAME + "-" + name;
    }

    @Override
    public void loadContent() {
        DynamicsItems.load();
        DynamicsLiquids.load();
        DynamicsRecipes.load();
        DynamicsBulletTypes.load();
        DynamicsUnitTypes.load();
        DynamicsBlocks.load();
        DynamicsPlanets.load();
        DynamicsSectorPresets.load();
        ThalassaTechTree.load();
    }

    @Override
    public void init() {
        super.init();
        DynamicsTeams.load();
        loadSettings();
    }

    public static void loadSettings() {
        ui.settings.addCategory(bundle.get("setting.fb-dynamics-category"), Icon.settings, t -> {
            t.pref(new ButtonPref(bundle.get("setting.fb-dynamics-clear-tech-tree"), Icon.trash, () -> ui.showConfirm("@confirm", bundle.get("setting.fb-dynamics-clear-tech-tree.confirm"), () -> {
                DynamicsPlanets.thalassa.techTree.reset();
                for (TechTree.TechNode node : DynamicsPlanets.thalassa.techTree.children) {
                    node.reset();
                }
                content.each(c -> {
                    if (c instanceof UnlockableContent u && c.minfo != null && c.minfo.mod != null && c.minfo.mod.name.equals("fb-dynamics")) {
                        u.clearUnlock();
                    }
                });
                settings.remove("unlocks");
            })));
            t.pref(new ButtonPref(bundle.get("setting.fb-dynamics-clear-campaign"), Icon.trash, () -> ui.showConfirm("@confirm", bundle.get("setting.fb-dynamics-clear-campaign.confirm"), () -> {
                Seq<Saves.SaveSlot> toDelete = Seq.with();
                control.saves.getSaveSlots().each(s -> {
                    if (s.getSector() == null) return;
                    if (s.getSector().planet == DynamicsPlanets.thalassa) {
                        toDelete.add(s);
                        Log.info("Deleted Dynamics sector: " + s.getSector().id + (s.getSector().preset != null ? " " + s.getSector().preset.localizedName : ""));
                    }
                });
                toDelete.each(Saves.SaveSlot::delete);
                ui.showInfoOnHidden(bundle.get("setting.fb-dynamics-clear-campaign-close.confirm"), () -> Core.app.exit());
            })));
        });
    }
}
