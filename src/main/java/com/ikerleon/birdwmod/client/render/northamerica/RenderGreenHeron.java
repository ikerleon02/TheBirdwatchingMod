package com.ikerleon.birdwmod.client.render.northamerica;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.northamerica.EntityEasternBluebird;
import com.ikerleon.birdwmod.entity.northamerica.EntityGreenHeron;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RenderGreenHeron extends RenderBirdBase<EntityGreenHeron> {

    public static final ModelCMF GREEN_HERON = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/green_heron/green_heron.cmf"));
    public static final ModelCMF GREEN_HERON_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/green_heron/green_heron_flying.cmf"));
    public static final ModelCMF GREEN_HERON_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/green_heron/green_heron_sleeping.cmf"));

    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/greenheron.png");
    public static final ResourceLocation TEXTURE2 = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/greenheron2.png");
    public static final ResourceLocation TEXTURE3 = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/greenheron3.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/greenheron3.png");
    public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/greenheron_sleeping.png");

    public RenderGreenHeron(RenderManager manager) {
        super(manager, GREEN_HERON, 0.3F);
        GREEN_HERON.setAnimator(GreenHeronAnimator::new);
    }

    @Override
    protected void preRenderCallback(EntityGreenHeron entitylivingbaseIn, float partialTickTime) {
        if(entitylivingbaseIn.isChild()){
            float scaleFactor= 0.3F;

            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.55F;

            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
    }

    @Override
    public ResourceLocation getBlinkTexture(EntityGreenHeron entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGreenHeron entity) {
        if(entity.isChild()){
            return TEXTURECHICK;
        }
        else {
            return this.getTextureOfVar(entity.getVariant());
        }
    }

    public ResourceLocation getTextureOfVar(int variant) {
        switch (variant) {
            case 0:
            default:
                return TEXTURE;
            case 1:
                return TEXTURE2;
            case 2:
                return TEXTURE3;
        }
    }

    private class GreenHeronAnimator extends CMFAnimator {

        private final BookwormModelRenderer ThighR = this.getModel().getPartByName("ThighR");
        private final BookwormModelRenderer ThighL = this.getModel().getPartByName("ThighL");
        private final BookwormModelRenderer Tailtop = this.getModel().getPartByName("Tailtop");
        private final BookwormModelRenderer Neck = this.getModel().getPartByName("Neck");
        private final BookwormModelRenderer Head = this.getModel().getPartByName("Head");
        private final BookwormModelRenderer WingR = this.getModel().getPartByName("WingR");
        private final BookwormModelRenderer WingL = this.getModel().getPartByName("WingL");
        private final BookwormModelRenderer Wing2R = this.getModel().getPartByName("Wing2R");
        private final BookwormModelRenderer Wing2L = this.getModel().getPartByName("Wing2L");

        public GreenHeronAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();
            if ((entityIn instanceof EntityGreenHeron)) {
                EntityGreenHeron heron = (EntityGreenHeron) entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if(heron.isSleeping() && heron.onGround){
                    this.getModel().interpolateToPose(RenderGreenHeron.GREEN_HERON_SLEEPING, heron.timer);

                    this.Tailtop.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.Head.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 4.85F * 0.5f;
                    this.WingR.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                    this.WingL.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {
                    this.ThighR.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 1.85f * 0.5f;
                    this.ThighL.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 1.85f * 0.5f;
                    this.Neck.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount - 2.75F * 0.5f;
                    this.Tailtop.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

                    this.Tailtop.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.Head.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 4.85F * 0.5f;
                    this.WingR.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                    this.WingL.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

                    if (!heron.onGround && !heron.isInWater() && !heron.isChild()) {
                        this.getModel().interpolateToPose(RenderGreenHeron.GREEN_HERON_FLYING, heron.timer);

                        this.WingR.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.WingL.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.WingR.rotateAngleZ = MathHelper.cos(heron.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
                        this.WingL.rotateAngleZ = MathHelper.cos(heron.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                        this.Wing2R.rotateAngleY = MathHelper.cos(heron.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.Wing2L.rotateAngleY = MathHelper.cos(heron.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                    }
                }
            }
        }
    }
}