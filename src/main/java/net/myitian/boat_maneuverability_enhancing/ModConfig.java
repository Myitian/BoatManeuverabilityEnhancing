package net.myitian.boat_maneuverability_enhancing;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Config(name = BoatManeuverabilityEnhancing.MODID)
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip()
    @ConfigEntry.Gui.PrefixText()
    @Comment("Boat maneuverability enhancing factor, 0 (won't stop yawing) ~ 1 (stop yawing immediately)")
    public double factor = 0.75;

    @Override
    public void validatePostLoad() throws ValidationException {
        if (factor < 0.0 || 1.0 < factor) {
            throw new ValidationException("factor should be between 0.0 and 1.0");
        }
    }
}
