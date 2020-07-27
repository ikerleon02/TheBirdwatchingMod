package com.ikerleon.birdwmod.client.render;

import com.ikerleon.birdwmod.entity.BirdEntity;
import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
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
        private final BookwormFeatureRendererContext ctx;

        public BlinkSleepingFeature(BookwormFeatureRendererContext ctx) {
            super(ctx);
            this.ctx = ctx;
        }

        @Override
        public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, BirdEntity birdEntity, float v, float v1, float v2, float v3, float v4, float v5) {
            if ((!birdEntity.isInvisible() && (birdEntity.getBlinking()) || birdEntity.isSleeping()) && birdEntity.isOnGround() && this.render.getBlinkTexture(birdEntity) != null)  {
                GlStateManager.pushMatrix();
                this.render.bindTexture(this.render.getBlinkTexture(birdEntity));
                this.render.getMainModel().setModelAttributes(this.render.getMainModel());
                this.render.getMainModel().setRotationAngles(f, f1, f3, f4, f5, f6, birdEntity);
                this.render.getMainModel().render(e, f, f1, f2, f3, f4, f6);
                GlStateManager.popMatrix();
            }
            else if(birdEntity instanceof EntityGreatGreyOwl){
                this.render.bindTexture(RenderGreatGreyOwl.TEXTUREYES);
                ModelBase mainModel = this.render.getMainModel();

                float alpha = 1.0F;

                GlStateManager.enableBlend();
                GlStateManager.enableAlpha();
                GlStateManager.depthMask(!e.isInvisible());
                GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
                GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);

                mainModel.setLivingAnimations(e, f1, f3, f2);
                mainModel.setRotationAngles(f, f1, f3, f4, f5, f6, e);
                mainModel.render(e, f, f1, f2, f3, f5, f6);

                GlStateManager.color(alpha, alpha, alpha, alpha);
                GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
                int i = 616800;
                int j = i % 75536;
                int k = i / 75536;
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
                GlStateManager.enableLighting();

                mainModel.setLivingAnimations(e, f1, f3, f2);
                mainModel.setRotationAngles(f, f1, f3, f4, f5, f6, e);
                mainModel.render(e, f, f1, f2, f3, f5, f6);

                this.setLightmap(e, f2);
                GlStateManager.depthMask(true);
                GlStateManager.disableBlend();
            }
        }

        protected void setLightmap(BirdEntity entityLivingIn, float partialTicks) {
            float i = entityLivingIn.getBrightnessAtEyes();
            float j = i % 75536;
            float k = i / 75536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
        }
    }

    @Environment(EnvType.CLIENT)
    public class RingFeature extends BookwormFeatureRenderer<BirdEntity>{

        private final BookwormFeatureRendererContext ctx;

        public RingFeature(BookwormFeatureRendererContext ctx) {
            super(ctx);
            this.ctx = ctx;
        }

        @Override
        public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, BirdEntity birdEntity, float v, float v1, float v2, float v3, float v4, float v5) {
            if (!birdEntity.isInvisible() && birdEntity.hasBeenRinged() && ctx.getRingTexture(birdEntity) != null)
            {
                this.birdRender.bindTexture(this.birdRender.getRingTexture(entitylivingbaseIn));
                this.birdRender.getMainModel().setModelAttributes(this.birdRender.getMainModel());
                if(birdEntity.getRingColor() != null) {
                    float[] afloat = birdEntity.getRingColor().getColorComponents();
                    GlStateManager.color4f(afloat[0], afloat[1], afloat[2], afloat[3]);
                }
                this.birdRender.getMainModel().setRotationAngles( limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entitylivingbaseIn);
                this.birdRender.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            }
        }
    }
}