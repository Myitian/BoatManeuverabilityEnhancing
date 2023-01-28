package net.myitian.boat_maneuverability_enhancing;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class BoatManeuverabilityEnhancing implements ClientModInitializer {
    public static final String MODID = "boat-maneuverability-enhancing";
    public static final ModConfig CONFIG = AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new).getConfig();

    @Override
    public void onInitializeClient() {
    }
}
