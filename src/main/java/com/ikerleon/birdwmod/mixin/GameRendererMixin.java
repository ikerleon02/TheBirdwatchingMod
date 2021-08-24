package com.ikerleon.birdwmod.mixin;

import com.ikerleon.birdwmod.items.InitItems;
import com.ikerleon.birdwmod.items.ItemBinocular;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Final
    @Shadow
    private MinecraftClient client;

    @Inject(at = @At("RETURN"), method = "getFov(Lnet/minecraft/client/render/Camera;FZ)D", cancellable = true)
    private double getZoomedFov(Camera camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> info) {
        double fov = info.getReturnValue();
        if(client.player.getActiveHand() != null) {
            if (client.player.getStackInHand(client.player.getActiveHand()).getItem() instanceof ItemBinocular) {
                if (client.player.isUsingItem() && this.client.options.getPerspective() == Perspective.FIRST_PERSON) {
                    ItemBinocular binocular = (ItemBinocular) client.player.getStackInHand(client.player.getActiveHand()).getItem();
                    info.setReturnValue((double) binocular.zoom);
                    if (changingFov) {
                        this.client.worldRenderer.scheduleTerrainUpdate();
                    }
                }
            }
        }

        return fov;
    }
}
