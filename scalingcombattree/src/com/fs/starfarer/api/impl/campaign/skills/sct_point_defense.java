package com.fs.starfarer.api.impl.campaign.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import scalingcombattree.AptitudeChange;

public class sct_point_defense {

    public static final String skillId = "sct_point_defense";
    static float bonusMultiplier = 1f;
    public static float FIGHTER_DAMAGE_BONUS = 100f;
    public static float MISSILE_DAMAGE_BONUS = 50f;
//	public static float FIGHTER_DAMAGE_BONUS = 75f;
//	public static float MISSILE_DAMAGE_BONUS = 75f;

    public static float PD_RANGE_BONUS_FLAT = 100f;



    public static class Level1 implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id, float level) {
            bonusMultiplier = AptitudeChange.getSkillBonusMultiplier(skillId);
            stats.getDamageToFighters().modifyFlat(id, FIGHTER_DAMAGE_BONUS * bonusMultiplier / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id) {
            stats.getDamageToFighters().unmodify(id);
            bonusMultiplier = 1f;
            AptitudeChange.unassignSkill(skillId);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(FIGHTER_DAMAGE_BONUS* bonusMultiplier) + "% damage to fighters";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level2 implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id, float level) {
            bonusMultiplier = AptitudeChange.getSkillBonusMultiplier(skillId);
            stats.getDamageToMissiles().modifyFlat(id, MISSILE_DAMAGE_BONUS * bonusMultiplier / 100f);
        }

        public void unapply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id) {
            stats.getDamageToMissiles().unmodify(id);
            bonusMultiplier = 1f;
            AptitudeChange.unassignSkill(skillId);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(MISSILE_DAMAGE_BONUS) + "% damage to missiles";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level3 implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id, float level) {
            bonusMultiplier = AptitudeChange.getSkillBonusMultiplier(skillId);
            stats.getNonBeamPDWeaponRangeBonus().modifyFlat(id, PD_RANGE_BONUS_FLAT * bonusMultiplier);
            stats.getBeamPDWeaponRangeBonus().modifyFlat(id, PD_RANGE_BONUS_FLAT * bonusMultiplier);
        }

        public void unapply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id) {
            stats.getNonBeamPDWeaponRangeBonus().unmodifyFlat(id);
            stats.getBeamPDWeaponRangeBonus().unmodifyFlat(id);
            bonusMultiplier = 1f;
            AptitudeChange.unassignSkill(skillId);
        }

        public String getEffectDescription(float level) {
            //return "+" + (int)(PD_RANGE_BONUS_FLAT) + " range ";
            return "Extends the range of point-defense weapons by " + (int)(PD_RANGE_BONUS_FLAT * bonusMultiplier) + "";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }
}