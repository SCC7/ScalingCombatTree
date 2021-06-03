package scalingcombattree;

import com.fs.starfarer.api.EveryFrameScript;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CoreUITabId;
import com.fs.starfarer.api.characters.MutableCharacterStatsAPI;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AptitudeChange implements EveryFrameScript {
    //boolean isInSkillScreen;

    static ArrayList<String> skillOrder = new ArrayList<String>();

    public static Logger log = Global.getLogger(AptitudeChange.class);
    private boolean isDone = false;
    float timer = 0;

    public AptitudeChange() {
        Global.getSector().addScript(this);
    }

    @Override
    public boolean isDone() {
        return isDone;
    }

    @Override
    public boolean runWhilePaused() {
        return true;
    }

    @Override
    public void advance(float amount) {
        //timer += amount;
        //if(timer<1f) return;
        /*if(Global.getSector().getCampaignUI().getCurrentCoreTab() == CoreUITabId.CHARACTER) {
            log.info("YEAH");
            isDone = true;
        }*/
        /*timer += amount;
        if(timer<100f);*/
        //log.info("The number of skill points spent in combat tree is "+getSkillpointsInCombat());
    }
    public static float getSkillBonusMultiplier(String skillId) {
        if (skillOrder.contains(skillId)) return skillOrder.indexOf(skillId);
        skillOrder.add(skillId);
        return skillOrder.indexOf(skillId) + 1f;
    }
    public static void unassignSkill(String skillId) {
        skillOrder.remove(skillId);
    }
}
