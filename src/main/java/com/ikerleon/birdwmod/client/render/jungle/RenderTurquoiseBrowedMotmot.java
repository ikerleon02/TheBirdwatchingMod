package com.ikerleon.birdwmod.client.render.jungle;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.jungle.EntityTurquoiseBrowedMotmot;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RenderTurquoiseBrowedMotmot extends RenderBirdBase<EntityTurquoiseBrowedMotmot> {

    public static final ModelCMF TURQUOISEBROWED_MOTMOT = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/motmot/motmot.cmf"));
    public static final ModelCMF TURQUOISEBROWED_MOTMOT_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/motmot/motmotflying.cmf"));
    public static final ModelCMF TURQUOISEBROWED_MOTMOT_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/motmot/motmotsleeping.cmf"));

    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/jungle/motmot.png");
    public static final ResourceLocation TEXTURE2 = new ResourceLocation(Reference.MODID + ":textures/entity/jungle/motmot2.png");
    public static final ResourceLocation TEXTURE3 = new ResourceLocation(Reference.MODID + ":textures/entity/jungle/motmot3.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/jungle/motmot2.png");
    public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/jungle/motmot_sleeping.png");

    public RenderTurquoiseBrowedMotmot(RenderManager manager) {
        super(manager, TURQUOISEBROWED_MOTMOT, 0.3F);
        TURQUOISEBROWED_MOTMOT.setAnimator(new RenderTurquoiseBrowedMotmot.MotmotAnimator(TURQUOISEBROWED_MOTMOT));
    }

    @Override
    protected void preRenderCallback(EntityTurquoiseBrowedMotmot entitylivingbaseIn, float partialTickTime) {
        if(entitylivingbaseIn.isChild()){
            float scaleFactor= 0.25F;

            GlStateManager.translate(0F, -0.01, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.45F;

            GlStateManager.translate(0F, -0.01, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
    }

    @Override
    public ResourceLocation getBlinkTexture(EntityTurquoiseBrowedMotmot entity) {
        return TEXTUREBLINK;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTurquoiseBrowedMotmot entity) {
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

    private class MotmotAnimator extends CMFAnimator {

        private final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
        private final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
        private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
        private final BookwormModelRenderer necktop = this.getModel().getPartByName("shape13");
        private final BookwormModelRenderer head = this.getModel().getPartByName("head");
        private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
        private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
        private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
        private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");


        public MotmotAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();
            if ((entityIn instanceof EntityTurquoiseBrowedMotmot)) {
                EntityTurquoiseBrowedMotmot motmot = (EntityTurquoiseBrowedMotmot) entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;


                if(motmot.isSleeping()){
                    this.getModel().interpolateToPose(RenderTurquoiseBrowedMotmot.TURQUOISEBROWED_MOTMOT_SLEEPING, motmot.timer);

                    this.body2.rotateAngleX = MathHelper.cos(motmot.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + (float)Math.toRadians(-2.5);
                    this.head.rotateAngleX = MathHelper.cos(motmot.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + (float)Math.toRadians(40);
                    this.rightwing.rotateAngleX = MathHelper.cos(motmot.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.rotateAngleX = MathHelper.cos(motmot.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {
                    this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + (float)Math.toRadians(10);
                    this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + (float)Math.toRadians(10);
                    this.necktop.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + (float)Math.toRadians(-15);
                    this.body2.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + (float)Math.toRadians(-2.5);

                    this.body2.rotateAngleX = MathHelper.cos(motmot.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + (float)Math.toRadians(-2.5);
                    this.head.rotateAngleX = MathHelper.cos(motmot.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + (float)Math.toRadians(40);
                    this.rightwing.rotateAngleX = MathHelper.cos(motmot.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.rotateAngleX = MathHelper.cos(motmot.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

                    if (!motmot.onGround && !motmot.isInWater() && !motmot.isChild()) {
                        this.getModel().interpolateToPose(RenderTurquoiseBrowedMotmot.TURQUOISEBROWED_MOTMOT_FLYING, motmot.timer);

                        this.rightwing.rotateAngleX = MathHelper.cos(motmot.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + (float)Math.toRadians(-75);
                        this.leftwing.rotateAngleX = MathHelper.cos(motmot.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f+ (float)Math.toRadians(-75);
                        this.rightwing.rotateAngleZ = MathHelper.cos(motmot.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + (float)Math.toRadians(90);
                        this.leftwing.rotateAngleZ = MathHelper.cos(motmot.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + (float)Math.toRadians(-90);
                        this.rightwing2.rotateAngleY = MathHelper.cos(motmot.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + (float)Math.toRadians(5);
                        this.leftwing2.rotateAngleY = MathHelper.cos(motmot.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + (float)Math.toRadians(-5);
                    }
                }
            }
        }
    }
}
