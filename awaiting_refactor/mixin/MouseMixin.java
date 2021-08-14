package com.ikerleon.birdwmod.mixin;

import com.ikerleon.birdwmod.items.ItemBinocular;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.render.Camera;
import net.minecraft.client.util.SmoothUtil;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Mouse.class)
public class MouseMixin {
    @Final
    @Shadow
    private MinecraftClient client;

    @Shadow
    private final SmoothUtil cursorXSmoother = new SmoothUtil();

    @Shadow
    private final SmoothUtil cursorYSmoother = new SmoothUtil();

    @Shadow
    private double cursorDeltaX;

    @Shadow
    private double cursorDeltaY;

    private double extractedE;

    private final SmoothUtil cursorXZoomSmoother = new SmoothUtil();
    private final SmoothUtil cursorYZoomSmoother = new SmoothUtil();

    private double adjustedG;

    //This mixin handles the "Reduce Sensitivity" option.
    @ModifyVariable(at = @At(value = "FIELD", target = "Lnet/minecraft/client/Mouse;client:Lnet/minecraft/client/MinecraftClient;", ordinal = 2), method = "updateMouse()V", ordinal = 2)
    private double applyReduceSensitivity(double g) {
        double modifiedMouseSensitivity = this.client.options.mouseSensitivity;
        double appliedMouseSensitivity = modifiedMouseSensitivity * 0.6 + 0.2;
        g = appliedMouseSensitivity * appliedMouseSensitivity * appliedMouseSensitivity * 8.0;
        this.adjustedG = g;
        return g;
    }

    @Inject(at = @At(value = "INVOKE", target = "net/minecraft/client/Mouse.isCursorLocked()Z"), method = "updateMouse()V", locals = LocalCapture.CAPTURE_FAILHARD)
    private void obtainCinematicCameraValues(CallbackInfo info, double d, double e) {
        this.extractedE = e;
    }

    @ModifyVariable(at = @At(value = "FIELD", target = "Lnet/minecraft/client/Mouse;cursorDeltaX:D", ordinal = 3, shift = At.Shift.BEFORE), method = "updateMouse()V", ordinal = 1)
    private double applyCinematicModeX(double l) {
        if (client.player.getActiveHand() != null && client.player.getStackInHand(client.player.getActiveHand()).getItem() instanceof ItemBinocular && client.player.isUsingItem()) {
            if (this.client.options.smoothCameraEnabled) {
                l = this.cursorXSmoother.smooth(this.cursorDeltaX * this.adjustedG, (this.extractedE * this.adjustedG));
                this.cursorXZoomSmoother.clear();
            } else {
                l = this.cursorXZoomSmoother.smooth(this.cursorDeltaX * this.adjustedG, (this.extractedE * this.adjustedG));
            }
        } else {
            this.cursorXZoomSmoother.clear();
        }

        return l;
    }

    @ModifyVariable(at = @At(value = "FIELD", target = "Lnet/minecraft/client/Mouse;cursorDeltaY:D", ordinal = 3, shift = At.Shift.BEFORE), method = "updateMouse()V", ordinal = 2)
    private double applyCinematicModeY(double m) {
        if (client.player.getActiveHand() != null && client.player.getStackInHand(client.player.getActiveHand()).getItem() instanceof ItemBinocular && client.player.isUsingItem()) {
            if (this.client.options.smoothCameraEnabled) {
                m = this.cursorYSmoother.smooth(this.cursorDeltaY * this.adjustedG, (this.extractedE * this.adjustedG));
                this.cursorYZoomSmoother.clear();
            } else {
                m = this.cursorYZoomSmoother.smooth(this.cursorDeltaY * this.adjustedG, (this.extractedE * this.adjustedG));
            }
        } else {
            this.cursorYZoomSmoother.clear();
        }

        return m;
    }
}
