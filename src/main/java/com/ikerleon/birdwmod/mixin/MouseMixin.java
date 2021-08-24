package com.ikerleon.birdwmod.mixin;

import com.ikerleon.birdwmod.items.ItemBinocular;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.render.*;
import net.minecraft.client.util.SmoothUtil;
import net.minecraft.client.util.math.MatrixStack;
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

    @Shadow
    private boolean cursorLocked;

    @Inject(at = @At("TAIL"), method = "updateMouse()V")
    public void SmoothMouse(CallbackInfo info) {
        /*if (this.cursorLocked && this.client.isWindowFocused()) {
            double f = this.client.options.mouseSensitivity * 0.6000000238418579D + 0.20000000298023224D;
            double g = f * f * f;
            double h = g * 8.0D;
            double o;
            double p ;
            if(client.player.getActiveHand() != null) {
                if (client.player.getStackInHand(client.player.getActiveHand()).getItem() instanceof ItemBinocular && client.player.isUsingItem() && this.client.options.getPerspective() == Perspective.FIRST_PERSON) {
                    this.cursorXSmoother.clear();
                    this.cursorYSmoother.clear();
                    o = this.cursorDeltaX * g;
                    p = this.cursorDeltaY * g;
                }
                else {
                    this.cursorXSmoother.clear();
                    this.cursorYSmoother.clear();
                    o = this.cursorDeltaX * h;
                    p = this.cursorDeltaY * h;
                }

                this.cursorDeltaX = 0.0D;
                this.cursorDeltaY = 0.0D;
                int q = 1;
                if (this.client.options.invertYMouse) {
                    q = -1;
                }

                this.client.getTutorialManager().onUpdateMouse(o, p);
                if (this.client.player != null) {
                    this.client.player.changeLookDirection(o, p * (double)q);
                }
            }
        }
        else {
            this.cursorDeltaX = 0.0D;
            this.cursorDeltaY = 0.0D;
        }*/
    }
}
