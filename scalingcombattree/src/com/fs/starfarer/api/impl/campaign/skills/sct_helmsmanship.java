package com.fs.starfarer.api.impl.campaign.skills;

import com.fs.starfarer.api.characters.ShipSkillEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import scalingcombattree.AptitudeChange;

public class sct_helmsmanship {

    public static final String skillId = "sct_helmsmanship";
    public static final float MANEUVERABILITY_BONUS = 50;
    //public static final float DAMAGE_TO_MODULES_REDUCTION = 50;
    public static float SPEED_BONUS = 10f;
    static float bonusMultiplier;

    //public static float ZERO_FLUX_LEVEL = 1f;

    //public static float DAMAGE_BONUS = 100f;


    public static class Level1 implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            bonusMultiplier = AptitudeChange.getSkillBonusMultiplier(skillId) + 1f;
            stats.getAcceleration().modifyPercent(id, MANEUVERABILITY_BONUS * bonusMultiplier);
            stats.getDeceleration().modifyPercent(id, MANEUVERABILITY_BONUS * bonusMultiplier);
            stats.getTurnAcceleration().modifyPercent(id, MANEUVERABILITY_BONUS * 2f * bonusMultiplier);
            stats.getMaxTurnRate().modifyPercent(id, MANEUVERABILITY_BONUS * bonusMultiplier);

//			stats.getBallisticWeaponDamageMult().modifyPercent(id, DAMAGE_BONUS);
//			stats.getEnergyWeaponDamageMult().modifyPercent(id, DAMAGE_BONUS);
//			stats.getMissileWeaponDamageMult().modifyPercent(id, DAMAGE_BONUS);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getAcceleration().unmodify(id);
            stats.getDeceleration().unmodify(id);
            stats.getTurnAcceleration().unmodify(id);
            stats.getMaxTurnRate().unmodify(id);
            AptitudeChange.unassignSkill(skillId);
            bonusMultiplier = 1f;

//			stats.getBallisticWeaponDamageMult().unmodify(id);
//			stats.getEnergyWeaponDamageMult().unmodify(id);
//			stats.getMissileWeaponDamageMult().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(MANEUVERABILITY_BONUS * bonusMultiplier) + "% maneuverability";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

    public static class Level2 implements ShipSkillEffect {
        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            bonusMultiplier = AptitudeChange.getSkillBonusMultiplier(skillId);
            stats.getMaxSpeed().modifyPercent(id, SPEED_BONUS * bonusMultiplier);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getMaxSpeed().unmodify(id);
        }

        public String getEffectDescription(float level) {
            return "+" + (int)(SPEED_BONUS * bonusMultiplier) + "% top speed";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

//	public static class Level3 implements ShipSkillEffect {
//
//		public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
//			stats.getZeroFluxMinimumFluxLevel().modifyFlat(id, ZERO_FLUX_LEVEL * 0.01f);
//		}
//
//		public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
//			stats.getZeroFluxMinimumFluxLevel().unmodify(id);
//		}
//
//		public String getEffectDescription(float level) {
//			return "The 0-flux speed boost is activated at up to " + (int)(ZERO_FLUX_LEVEL) + "% flux";
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

    public static class Level3 implements ShipSkillEffect {

        public void apply(MutableShipStatsAPI stats, HullSize hullSize, String id, float level) {
            stats.getAllowZeroFluxAtAnyLevel().modifyFlat(id, 1f);
        }

        public void unapply(MutableShipStatsAPI stats, HullSize hullSize, String id) {
            stats.getAllowZeroFluxAtAnyLevel().unmodifyFlat(id);
        }

        public String getEffectDescription(float level) {
            return "The 0-flux speed boost is activated at any flux level, as long as the ship is not generating flux";
        }

        public String getEffectPerLevelDescription() {
            return null;
        }

        public ScopeDescription getScopeDescription() {
            return ScopeDescription.PILOTED_SHIP;
        }
    }

}
