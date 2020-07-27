package com.ikerleon.birdwmod.client.render;

import com.ikerleon.birdwmod.entity.BirdEntity;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.soggymustache.bookworm.client.model.ModelCMF;

public abstract class BirdBaseRenderer <T extends BirdEntity, F extends ModelCMF> extends MobEntityRenderer<T> {

    public BirdBaseRenderer(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn){
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
        addLayer(new LayerBlinkSleeping(this));
        addLayer(new LayerRing(this));
    }

    public Identifier getBlinkTexture(T entity)
    {
        return null;
    }

    public Identifier getRingTexture(T entity)
    {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public class LayerBlinkSleeping implements LayerRenderer<BirdEntity>
    {
        private final BirdBaseRenderer render;

        public LayerBlinkSleeping(BirdBaseRenderer re)
        {
            this.render = re;
        }

        public void doRenderLayer(BirdEntity e, float f, float f1, float f2, float f3, float f4, float f5, float f6)
        {
            if ((!e.isInvisible() && (e.getBlinking()) || e.isSleeping()) && e.onGround && this.render.getBlinkTexture(e) != null)  {
                GlStateManager.pushMatrix();
                this.render.bindTexture(this.render.getBlinkTexture(e));
                this.render.getMainModel().setModelAttributes(this.render.getMainModel());
                this.render.getMainModel().setRotationAngles(f, f1, f3, f4, f5, f6, e);
                this.render.getMainModel().render(e, f, f1, f2, f3, f4, f6);
                GlStateManager.popMatrix();
            }
            else if(e instanceof EntityGreatGreyOwl){
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

        public boolean shouldCombineTextures()
        {
            return true;
        }

        protected void setLightmap(BirdEntity entityLivingIn, float partialTicks) {
            int i = entityLivingIn.getBrightnessForRender();
            int j = i % 75536;
            int k = i / 75536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
        }
    }

    @SideOnly(Side.CLIENT)
    public class LayerRing implements LayerRenderer<BirdEntity>
    {
        private final BirdBaseRenderer birdRender;

        public LayerRing(BirdBaseRenderer birdRenderIn)
        {
            this.birdRender = birdRenderIn;
        }

        public void doRenderLayer(BirdEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
        {
            if (!entitylivingbaseIn.isInvisible() && entitylivingbaseIn.hasBeenRinged() && this.birdRender.getRingTexture(entitylivingbaseIn) != null)
            {
                this.birdRender.bindTexture(this.birdRender.getRingTexture(entitylivingbaseIn));
                this.birdRender.getMainModel().setModelAttributes(this.birdRender.getMainModel());
                if(entitylivingbaseIn.getRingColor() != null) {
                    float[] afloat = entitylivingbaseIn.getRingColor().getColorComponentValues();
                    GlStateManager.color(afloat[0], afloat[1], afloat[2]);
                }
                this.birdRender.getMainModel().setRotationAngles( limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entitylivingbaseIn);
                this.birdRender.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            }
        }

        public boolean shouldCombineTextures()
        {
            return true;
        }
    }
}