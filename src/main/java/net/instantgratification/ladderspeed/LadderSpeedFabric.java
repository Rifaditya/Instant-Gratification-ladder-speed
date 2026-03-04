package net.instantgratification.ladderspeed;

import net.fabricmc.api.ModInitializer;
import net.instantgratification.ladderspeed.reg.LadderSpeedRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LadderSpeedFabric implements ModInitializer {
    public static final String MOD_ID = "ladder-speed";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LadderSpeedRules.register();
        LOGGER.info("Instant Gratification: Ladder Speed Initialized");
    }
}
