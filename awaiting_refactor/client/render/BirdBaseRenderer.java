package com.ikerleon.birdwmod.client.render;

import com.ikerleon.birdwmod.entity.BirdEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.soggymustache.bookworm.client.animation.part.BookwormModelBase;
import net.soggymustache.bookworm.client.render.BookwormEntityRenderer;
import net.soggymustache.bookworm.client.render.BookwormFeatureRenderer;
import net.soggymustache.bookworm.client.render.BookwormFeatureRendererContext;

public abstract class BirdBaseRenderer <T extends BirdEntity> extends BookwormEntityRenderer<T> {

    public BirdBaseRenderer(EntityRenderDispatcher renderManager, BookwormModelBase model, float f) {
        super(renderManager, model, f);
        this.features.add((BookwormFeatureRenderer<T>) new BlinkSleepingFeature(this));
        this.features.add((BookwormFeatureRenderer<T>) new RingFeature(this));
    }

    public Identifier getBlinkTexture(T entity)
    {
        return null;
    }

    public Identifier getRingTexture(T entity)
    {
        return null;
    }

    @Environment(EnvType.CLIENT)
    public class BlinkSleepingFeature extends BookwormFeatureRenderer<BirdEntity> {
        private final BirdBaseRenderer render;

        public BlinkSleepingFeature(BookwormFeatureRendererContext ctx) {
            super(ctx);
            this.render = (BirdBaseRenderer) ctx;
        }

        @Override
        public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, BirdEntity birdEntity, float limbAngle, float limbDistance, float tickDelta, float animationProgres, float headYaw, float headPitch) {
            if ((!birdEntity.isInvisible() && (birdEntity.getBlinking()) || birdEntity.isSleeping()) && birdEntity.isOnGround() && this.render.getBlinkTexture(birdEntity) != null)  {
                this.render.model.animateModel(birdEntity, limbAngle, limbDistance, tickDelta, headYaw, headPitch);
                this.render.model.render(matrixStack, vertexConsumerProvider.getBuffer(RenderLayer.getEntityTranslucent(this.render.getBlinkTexture(birdEntity))), i, LivingEntityRenderer.getOverlay(birdEntity, 0.0F), 1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public class RingFeature extends BookwormFeatureRenderer<BirdEntity>{

        private final BirdBaseRenderer birdRender;

        public RingFeature(BookwormFeatureRendererContext ctx) {
            super(ctx);
            this.birdRender = (BirdBaseRenderer)ctx;
        }

        @Override
        public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, BirdEntity birdEntity, float limbAngle, float limbDistance, float tickDelta, float animationProgres, float headYaw, float headPitch) {
            if (!birdEntity.isInvisible() && birdEntity.hasBeenRinged() && birdRender.getRingTexture(birdEntity) != null)
            {
                float[] fs = birdEntity.getRingColor().getColorComponents();
                this.birdRender.model.animateModel(birdEntity, limbAngle, limbDistance, tickDelta, headYaw, headPitch);

                this.birdRender.model.render(matrixStack, vertexConsumerProvider.getBuffer(RenderLayer.getEntityTranslucent(this.birdRender.getRingTexture(birdEntity))), i, LivingEntityRenderer.getOverlay(birdEntity, 0.0F), fs[0], fs[1], fs[2], 1.0F);
            }
        }
    }
}