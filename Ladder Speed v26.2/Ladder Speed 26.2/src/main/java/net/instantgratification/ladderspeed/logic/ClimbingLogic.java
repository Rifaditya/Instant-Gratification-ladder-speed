package net.instantgratification.ladderspeed.logic;

import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.instantgratification.ladderspeed.reg.LadderSpeedRules;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class ClimbingLogic {

    public static float getUpwardBoostMultiplier(LivingEntity entity) {
        if (!entity.onClimbable()) {
            return 1.0f;
        }
        int climbRule = DynamicGameRuleManager.getInt(entity.level(), LadderSpeedRules.CLIMB_SPEED);
        if (climbRule <= 0) climbRule = 100; // Mitigation for client-side unregistered rule returning 0
        float multiplier = climbRule / 100.0f;
        
        if (entity.isSprinting()) {
            int sprintRule = DynamicGameRuleManager.getInt(entity.level(), LadderSpeedRules.SPRINT_MULTIPLIER);
            if (sprintRule <= 0) sprintRule = 150;
            multiplier *= sprintRule / 100.0f;
        }
        return multiplier;
    }

    public static Vec3 modifyClimbVelocity(LivingEntity entity, Vec3 originalDelta) {
        if (!entity.onClimbable()) {
            return originalDelta;
        }

        double xd = originalDelta.x;
        double yd = originalDelta.y;
        double zd = originalDelta.z;
        
        // Ascending
        if (yd > 0.0) {
            float climbSpeedMultiplier = getUpwardBoostMultiplier(entity);
            yd *= climbSpeedMultiplier;
        } 
        // Descending
        else if (yd < 0.0) {
            boolean snapDescend = DynamicGameRuleManager.getBoolean(entity.level(), LadderSpeedRules.SNAP_DESCEND);
            
            // Snap descend triggers if looking down sharply (> 45 pitch) and not sneaking (suppressing slide)
            if (snapDescend && entity.getXRot() > 45.0f && !entity.isSuppressingSlidingDownLadder()) {
                yd = -0.4; // Force slide down significantly faster
            } else {
                int descendRule = DynamicGameRuleManager.getInt(entity.level(), LadderSpeedRules.DESCEND_SPEED);
                if (descendRule <= 0) descendRule = 100;
                float descendSpeedMultiplier = descendRule / 100.0f;
                yd *= descendSpeedMultiplier;
            }
        }

        return new Vec3(xd, yd, zd);
    }
}
