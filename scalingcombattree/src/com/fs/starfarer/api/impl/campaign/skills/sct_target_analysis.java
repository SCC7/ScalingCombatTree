package com.fs.starfarer.api.impl.campaign.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import scalingcombattree.AptitudeChange;

public class sct_target_analysis {

    public static final String skillId = "sct_target_analysis";
    static float bonusMultiplier = 1f;

    public static final float DAMAGE_TO_MODULES_BONUS = 100;
//	public static final float DAMAGE_TO_SHIELDS_BONUS = 15;
//	public static final float HIT_STRENGTH_BONUS = 50;

    public static final float DAMAGE_TO_DESTROYERS = 10;
    public static final float DAMAGE_TO_CRUISERS = 15;
    public static final float DAMAGE_TO_CAPITALS = 20;


    public static class Level1 implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id, float level) {
            bonusMultiplier = AptitudeChange.getSkillBonusMultiplier(skillId);
            stats.getDamageToDestroyers().modifyPercent(id, DAMAGE_TO_DESTROYERS * bonusMultiplier);
        }

        public void unapply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id) {
            stats.getDamageToDestroyers().unmodifyPercent(id);
            bonusMultiplier = 1f;
            AptitudeChange.unassignSkill(skillId);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(DAMAGE_TO_DESTROYERS * bonusMultiplier) + "% damage to destroyers";
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
            stats.getDamageToCruisers().modifyPercent(id, DAMAGE_TO_CRUISERS * bonusMultiplier);
        }

        public void unapply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id) {
            stats.getDamageToCruisers().unmodifyPercent(id);
            bonusMultiplier = 1f;
            AptitudeChange.unassignSkill(skillId);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(DAMAGE_TO_CRUISERS * bonusMultiplier) + "% damage to cruisers";
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
            stats.getDamageToCapital().modifyPercent(id, DAMAGE_TO_CAPITALS * bonusMultiplier);
        }

        public void unapply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id) {
            stats.getDamageToCapital().unmodifyPercent(id);
            bonusMultiplier = 1f;
            AptitudeChange.unassignSkill(skillId);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(DAMAGE_TO_CAPITALS * bonusMultiplier) + "% damage to capital ships";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }




    public static class Level4 implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id, float level) {
            bonusMultiplier = AptitudeChange.getSkillBonusMultiplier(skillId);
            stats.getDamageToTargetEnginesMult().modifyPercent(id, DAMAGE_TO_MODULES_BONUS * bonusMultiplier);
            stats.getDamageToTargetWeaponsMult().modifyPercent(id, DAMAGE_TO_MODULES_BONUS * bonusMultiplier);
        }

        public void unapply(MutableShipStatsAPI stats, ShipAPI.HullSize hullSize, String id) {
            stats.getDamageToTargetEnginesMult().unmodify(id);
            stats.getDamageToTargetWeaponsMult().unmodify(id);
            bonusMultiplier = 1f;
            AptitudeChange.unassignSkill(skillId);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(DAMAGE_TO_MODULES_BONUS * bonusMultiplier) + "% damage to weapons and engines";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

//	public static class Level2 implements ShipSkillEffect {
//
//		public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
//			stats.getDamageToTargetShieldsMult().modifyPercent(id, DAMAGE_TO_SHIELDS_BONUS);
//		}
//
//		public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
//			stats.getDamageToTargetShieldsMult().unmodify(id);
//		}
//
//		public String getEffectDescription(float level) {
//			return "+" + (int)(DAMAGE_TO_SHIELDS_BONUS) + "% damage to shields";
//		}
//
//		public String getEffectPerLevelDescription() {
//			return null;
//		}
//
//		public ScopeDescription getScopeDescription() {
//			return ScopeDescription.PILOTED_SHIP;
//		}
//
//	}
//
//	public static class Level3 implements ShipSkillEffect {
//
//		public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
//			stats.getHitStrengthBonus().modifyPercent(id, HIT_STRENGTH_BONUS);
//		}
//
//		public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
//			stats.getHitStrengthBonus().unmodify(id);
//		}
//
//		public String getEffectDescription(float level) {
//			return "+" + (int)(HIT_STRENGTH_BONUS) + "% hit strength for armor damage reduction calculation only";
//		}
//
//		public String getEffectPerLevelDescription() {
//			return null;
//		}
//
//		public ScopeDescription getScopeDescription() {
//			return ScopeDescription.PILOTED_SHIP;
//		}
//	}

}
