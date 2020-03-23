package com.ikerleon.birdwmod.client.render;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.entity.EntityBird;
import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.entity.jungle.EntityHoatzin;
import com.ikerleon.birdwmod.entity.jungle.EntityTurquoiseBrowedMotmot;
import com.ikerleon.birdwmod.entity.northamerica.EntityGreenHeron;
import com.ikerleon.birdwmod.entity.northamerica.EntityKilldeer;
import com.ikerleon.birdwmod.entity.northamerica.EntityNorthernMockingbird;
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
        }

        public boolean shouldCombineTextures()
        {
            return true;
        }
    }

    @SideOnly(Side.CLIENT)
    public class LayerRing implements LayerRenderer<EntityBird>
    {
        private final ResourceLocation EIDER_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/eider_ring.png");
        private final ResourceLocation GULL_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/gull_ring.png");
        private final ResourceLocation HERON_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/heron_ring.png");
        private final ResourceLocation HOATZIN_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/hoatzin_ring.png");
        private final ResourceLocation KILLDEER_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/killdeer_ring.png");
        private final ResourceLocation MOCKINGBIRD_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/mockingbird_ring.png");
        private final ResourceLocation MOTMOT_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/motmot_ring.png");
        private final ResourceLocation NIGHTJAR_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/nightjar_ring.png");
        private final ResourceLocation PASSERINE_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/passerine_ring.png");

        private final RenderBirdBase birdRender;

        public LayerRing(RenderBirdBase birdRenderIn)
        {
            this.birdRender = birdRenderIn;
        }

        public void doRenderLayer(EntityBird entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
        {
            if (!entitylivingbaseIn.isInvisible() && entitylivingbaseIn.hasBeenRinged())
            {
                if(entitylivingbaseIn instanceof EntityStellersEider){
                    this.birdRender.bindTexture(EIDER_RING);
                }
                else if(entitylivingbaseIn instanceof EntityGreenHeron){
                    this.birdRender.bindTexture(HERON_RING);
                }
                else if(entitylivingbaseIn instanceof EntityHoatzin){
                    this.birdRender.bindTexture(HOATZIN_RING);
                }
                else if(entitylivingbaseIn instanceof EntityKilldeer){
                    this.birdRender.bindTexture(KILLDEER_RING);
                }
                else if(entitylivingbaseIn instanceof EntityNorthernMockingbird){
                    this.birdRender.bindTexture(MOCKINGBIRD_RING);
                }
                else if(entitylivingbaseIn instanceof EntityTurquoiseBrowedMotmot){
                    this.birdRender.bindTexture(MOTMOT_RING);
                }
                else if(entitylivingbaseIn instanceof EntityRedNeckedNightjar){
                    this.birdRender.bindTexture(NIGHTJAR_RING);
                }
                else{
                    this.birdRender.bindTexture(PASSERINE_RING);
                }
                if(entitylivingbaseIn.getRingColor() != null) {
                    float[] afloat = entitylivingbaseIn.getRingColor().getColorComponentValues();
                    GlStateManager.color(afloat[0], afloat[1], afloat[2]);
                }
                this.birdRender.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            }
        }

        public boolean shouldCombineTextures()
        {
            return true;
        }
    }
}


