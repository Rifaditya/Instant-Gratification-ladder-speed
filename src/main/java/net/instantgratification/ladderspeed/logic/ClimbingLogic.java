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
        float multiplier = DynamicGameRuleManager.getInt(entity.level(), LadderSpeedRules.CLIMB_SPEED) / 100.0f;
        if (entity.isSprinting()) {
            multiplier *= DynamicGameRuleManager.getInt(entity.level(), LadderSpeedRules.SPRINT_MULTIPLIER) / 100.0f;
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
                float descendSpeedMultiplier = DynamicGameRuleManager.getInt(entity.level(), LadderSpeedRules.DESCEND_SPEED) / 100.0f;
                yd *= descendSpeedMultiplier;
            }
        }

        return new Vec3(xd, yd, zd);
    }
}
