package net.instantgratification.ladderspeed.mixin;

import net.instantgratification.ladderspeed.logic.ClimbingLogic;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Verified against: LivingEntity.java (Snapshot 10)
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "handleOnClimbable(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;", at = @At("RETURN"), cancellable = true)
    private void ladderspeed$modifyClimbSpeed(Vec3 delta, CallbackInfoReturnable<Vec3> cir) {
        Vec3 original = cir.getReturnValue();
        Vec3 modified = ClimbingLogic.modifyClimbVelocity((LivingEntity) (Object) this, original);
        cir.setReturnValue(modified);
    }

    @Inject(method = "handleRelativeFrictionAndCalculateMovement", at = @At("RETURN"), cancellable = true)
    private void ladderspeed$modifyRelativeFriction(Vec3 input, float friction, CallbackInfoReturnable<Vec3> cir) {
        Vec3 result = cir.getReturnValue();
        LivingEntity entity = (LivingEntity) (Object) this;
        
        if (entity.onClimbable() && Math.abs(result.y - 0.2) < 1.0E-5) {
            float multiplier = ClimbingLogic.getUpwardBoostMultiplier(entity);
            if (multiplier != 1.0f) {
                cir.setReturnValue(new Vec3(result.x, 0.2 * multiplier, result.z));
            }
        }
    }
}
