package com.ikerleon.birdwmod.mixin;

import com.ikerleon.birdwmod.items.ItemBinocular;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Final
    @Shadow
    private MinecraftClient client;
    @Final
    @Shadow
    private int scaledWidth;
    @Final
    @Shadow
    private int scaledHeight;

    private static final Identifier RIM = new Identifier("birdwmod:textures/gui/binocularrim.png");

    @Inject(at = @At("TAIL"), method = "render(Lnet/minecraft/client/util/math/MatrixStack;F)V")
    public void renderBinocularOverlay(MatrixStack matrixStack, float f, CallbackInfo info) {
        if(client.player.getActiveHand() != null) {
            if (client.player.getStackInHand(client.player.getActiveHand()).getItem() instanceof ItemBinocular) {
                ItemBinocular binocular = (ItemBinocular)client.player.getStackInHand(client.player.getActiveHand()).getItem();
                if(client.player.isUsingItem() && this.client.options.perspective == 0) {
                    RenderSystem.disableDepthTest();
                    RenderSystem.depthMask(false);
                    RenderSystem.defaultBlendFunc();
                    RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
                    RenderSystem.disableAlphaTest();
                    this.client.getTextureManager().bindTexture(RIM);
                    Tessellator tessellator = Tessellator.getInstance();
                    BufferBuilder bufferBuilder = tessellator.getBuffer();
                    bufferBuilder.begin(7, VertexFormats.POSITION_TEXTURE);
                    bufferBuilder.vertex(0.0D, this.scaledHeight, -90.0D).texture(0.0F, 1.0F).next();
                    bufferBuilder.vertex(this.scaledWidth, this.scaledHeight, -90.0D).texture(1.0F, 1.0F).next();
                    bufferBuilder.vertex(this.scaledWidth, 0.0D, -90.0D).texture(1.0F, 0.0F).next();
                    bufferBuilder.vertex(0.0D, 0.0D, -90.0D).texture(0.0F, 0.0F).next();
                    tessellator.draw();
                    RenderSystem.depthMask(true);
                    RenderSystem.enableDepthTest();
                    RenderSystem.enableAlphaTest();
                    RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
                }
            }
        }
    }
}
