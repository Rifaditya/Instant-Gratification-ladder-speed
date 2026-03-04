package net.instantgratification.ladderspeed.reg;

import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRule;

public class LadderSpeedRules {
    public static final GameRuleCategory CATEGORY = DynamicGameRuleManager.registerCategory(Identifier.fromNamespaceAndPath("ladderspeed", "category"));

    public static final GameRule<Integer> CLIMB_SPEED = DynamicGameRuleManager.integerRule("ladderspeed.climbSpeed", CATEGORY, 100)
            .name("Ladder Climb Speed")
            .description("Percentage multiplier for vertical climb speed on ladders. (100 = 1.0x)")
            .min(10)
            .max(1000)
            .register();

    public static final GameRule<Integer> SPRINT_MULTIPLIER = DynamicGameRuleManager.integerRule("ladderspeed.sprintMultiplier", CATEGORY, 150)
            .name("Ladder Sprint Multiplier")
            .description("Percentage multiplier for ladder climb speed while sprinting. (150 = 1.5x)")
            .min(10)
            .max(1000)
            .register();

    public static final GameRule<Integer> DESCEND_SPEED = DynamicGameRuleManager.integerRule("ladderspeed.descendSpeed", CATEGORY, 100)
            .name("Ladder Descend Speed")
            .description("Percentage multiplier for sliding down ladders. (100 = 1.0x)")
            .min(10)
            .max(1000)
            .register();

    public static final GameRule<Boolean> SNAP_DESCEND = DynamicGameRuleManager.booleanRule("ladderspeed.snapDescend", CATEGORY, true)
            .name("Ladder Snap Descend")
            .description("When enabled, looking down while on a ladder will significantly speed up descent.")
            .register();

    public static void register() {
        // Class loading initializes fields
    }
}
