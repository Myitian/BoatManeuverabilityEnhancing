package net.myitian.boat_maneuverability_enhancing.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;
import net.myitian.boat_maneuverability_enhancing.BoatManeuverabilityEnhancing;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(BoatEntity.class)
abstract class BoatEntityMixin extends Entity {
    @Shadow
    private boolean pressingLeft;
    @Shadow
    private boolean pressingRight;
    @Shadow
    private float yawVelocity;

    private long lastPressedLR;

    BoatEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "updatePaddles", at = @At("HEAD"))
    private void updatePaddles(CallbackInfo ci) {
        if (this.hasPassengers()) {
            if (this.pressingRight == this.pressingLeft) {
                lastPressedLR++;
                this.yawVelocity *= 1 - BoatManeuverabilityEnhancing.CONFIG.factor / lastPressedLR;
            } else {
                lastPressedLR = 0;
            }
        }
    }
}