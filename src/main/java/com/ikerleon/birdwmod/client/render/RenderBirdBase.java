package com.ikerleon.birdwmod.client.render;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.release160.RenderGreatGreyOwl;
import com.ikerleon.birdwmod.entity.EntityBird;
import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.entity.jungle.EntityHoatzin;
import com.ikerleon.birdwmod.entity.jungle.EntityTurquoiseBrowedMotmot;
import com.ikerleon.birdwmod.entity.northamerica.EntityGreenHeron;
import com.ikerleon.birdwmod.entity.northamerica.EntityKilldeer;
import com.ikerleon.birdwmod.entity.northamerica.EntityNorthernMockingbird;
import com.ikerleon.birdwmod.entity.release160.EntityGreatGreyOwl;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class RenderBirdBase <T extends EntityBird> extends RenderLivingBase<T> {

    public RenderBirdBase(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn){
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
        addLayer(new LayerBlinkSleeping(this));
        addLayer(new LayerRing(this));
    }

    public ResourceLocation getBlinkTexture(T entity)
    {
        return null;
    }

    public ResourceLocation getRingTexture(T entity)
    {
        return null;
    }

    @Override
    protected boolean canRenderName(T entity)
    {
        return (super.canRenderName(entity)) && ((entity.getAlwaysRenderNameTagForRender()) || ((entity.hasCustomName()) && (entity == this.renderManager.pointedEntity)));
    }

    @SideOnly(Side.CLIENT)
    public class LayerBlinkSleeping implements LayerRenderer<EntityBird>
    {
        private final RenderBirdBase render;

        public LayerBlinkSleeping(RenderBirdBase re)
        {
            this.render = re;
        }

        public void doRenderLayer(EntityBird e, float f, float f1, float f2, float f3, float f4, float f5, float f6)
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

        protected void setLightmap(EntityBird entityLivingIn, float partialTicks) {
            int i = entityLivingIn.getBrightnessForRender();
            int j = i % 75536;
            int k = i / 75536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
        }
    }

    @SideOnly(Side.CLIENT)
    public class LayerRing implements LayerRenderer<EntityBird>
    {
        private final RenderBirdBase birdRender;

        public LayerRing(RenderBirdBase birdRenderIn)
        {
            this.birdRender = birdRenderIn;
        }

        public void doRenderLayer(EntityBird entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
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


