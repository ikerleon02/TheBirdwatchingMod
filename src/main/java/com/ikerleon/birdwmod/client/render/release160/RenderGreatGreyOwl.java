package com.ikerleon.birdwmod.client.render.release160;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.release160.EntityGreatGreyOwl;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RenderGreatGreyOwl extends RenderBirdBase<EntityGreatGreyOwl> {

    public static final ModelCMF GREAT_GREY_OWL = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/great_grey_owl/great_grey_owl.cmf"));
    public static final ModelCMF GREAT_GREY_OWL_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/great_grey_owl/great_grey_owl_flying.cmf"));
    public static final ModelCMF GREAT_GREY_OWL_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/great_grey_owl/great_grey_owl_sleeping.cmf"));

    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/release160/greatgreyowl.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/release160/greatgreyowl.png");
    public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/release160/greatgreyowl_sleeping.png");

    public RenderGreatGreyOwl(RenderManager manager) {
        super(manager, GREAT_GREY_OWL, 0.3F);
        GREAT_GREY_OWL.setAnimator(GreatGreyOwlAnimator::new);
    }

    @Override
    protected void preRenderCallback(EntityGreatGreyOwl entitylivingbaseIn, float partialTickTime) {
        if(entitylivingbaseIn.isChild()){
            float scaleFactor= 0.4F;

            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.8F;

            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
    }

    @Override
    public ResourceLocation getBlinkTexture(EntityGreatGreyOwl entity) {
        return TEXTUREBLINK;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGreatGreyOwl entity) {
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
        }
    }

    private class GreatGreyOwlAnimator extends CMFAnimator {

        private final BookwormModelRenderer ThighR = this.getModel().getPartByName("ThighR");
        private final BookwormModelRenderer ThighL = this.getModel().getPartByName("ThighL");
        private final BookwormModelRenderer Tailtop = this.getModel().getPartByName("Tailtop");
        private final BookwormModelRenderer Neck = this.getModel().getPartByName("Neck");
        private final BookwormModelRenderer Head = this.getModel().getPartByName("Head");
        private final BookwormModelRenderer WingR = this.getModel().getPartByName("WingR");
        private final BookwormModelRenderer WingL = this.getModel().getPartByName("WingL");
        private final BookwormModelRenderer Wing2R = this.getModel().getPartByName("Wing2R");
        private final BookwormModelRenderer Wing2L = this.getModel().getPartByName("Wing2L");

        public GreatGreyOwlAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();
            if ((entityIn instanceof EntityGreatGreyOwl)) {
                EntityGreatGreyOwl owl = (EntityGreatGreyOwl) entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if(owl.isSleeping() && owl.onGround){
                    this.getModel().interpolateToPose(GREAT_GREY_OWL_SLEEPING, owl.timer);

                    this.Tailtop.rotateAngleX = MathHelper.cos(owl.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + Tailtop.defaultOffsetX;
                    this.Head.rotateAngleX = MathHelper.cos(owl.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + Head.defaultOffsetX;
                    this.WingR.rotateAngleX = MathHelper.cos(owl.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f + WingR.defaultOffsetX;
                    this.WingL.rotateAngleX = MathHelper.cos(owl.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f + WingL.defaultOffsetX;
                }

                else {
                    this.ThighR.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + ThighR.defaultOffsetX;
                    this.ThighL.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + ThighL.defaultOffsetX;
                    this.Neck.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + Neck.defaultOffsetX;
                    this.Tailtop.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + Tailtop.defaultOffsetX;

                    this.Tailtop.rotateAngleX = MathHelper.cos(owl.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + Tailtop.defaultOffsetX;
                    this.Head.rotateAngleX = MathHelper.cos(owl.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + Head.defaultOffsetX;
                    this.WingR.rotateAngleX = MathHelper.cos(owl.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f + WingR.defaultOffsetX;
                    this.WingL.rotateAngleX = MathHelper.cos(owl.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f + WingL.defaultOffsetX;

                    if (!owl.onGround && !owl.isInWater() && !owl.isChild()) {
                        this.getModel().interpolateToPose(GREAT_GREY_OWL_FLYING, owl.timer);

                        this.WingR.rotateAngleX = MathHelper.cos(owl.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + WingR.defaultOffsetX;
                        this.WingL.rotateAngleX = MathHelper.cos(owl.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + WingL.defaultOffsetX;
                        this.WingR.rotateAngleZ = MathHelper.cos(owl.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + WingR.defaultOffsetZ;
                        this.WingL.rotateAngleZ = MathHelper.cos(owl.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + WingL.defaultOffsetZ;
                        this.Wing2R.rotateAngleY = MathHelper.cos(owl.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + Wing2R.defaultOffsetY;
                        this.Wing2L.rotateAngleY = MathHelper.cos(owl.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + Wing2L.defaultOffsetY;
                    }
                }
            }
        }
    }
}
