package com.ikerleon.birdwmod.client.render.jungle;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.jungle.EntityHoatzin;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RenderHoatzin extends RenderBirdBase<EntityHoatzin> {

    public static final ModelCMF HOATZIN = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/hoatzin/hoatzin.cmf"));
    public static final ModelCMF HOATZIN_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/hoatzin/hoatzin_flying.cmf"));
    public static final ModelCMF HOATZIN_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/hoatzin/hoatzin_sleeping.cmf"));

    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/jungle/hoatzin.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/jungle/hoatzin_chick.png");
    public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/jungle/hoatzin_sleeping.png");

    public RenderHoatzin(RenderManager manager) {
        super(manager, HOATZIN, 0.3F);
        HOATZIN.setAnimator(HoatzinAnimator::new);
    }

    @Override
    protected void preRenderCallback(EntityHoatzin entitylivingbaseIn, float partialTickTime) {
        if(entitylivingbaseIn.isChild()){
            float scaleFactor= 0.3F;

            GlStateManager.translate(0F, -0.075, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.5F;

            GlStateManager.translate(0F, -0.075, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
    }

    @Override
    public ResourceLocation getBlinkTexture(EntityHoatzin entity) {
        return TEXTUREBLINK;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityHoatzin entity) {
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

    private class HoatzinAnimator extends CMFAnimator {

        private final BookwormModelRenderer rightleg = this.getModel().getPartByName("RlegBase");
        private final BookwormModelRenderer leftleg = this.getModel().getPartByName("LLeftBase");
        private final BookwormModelRenderer body2 = this.getModel().getPartByName("TailBase");
        private final BookwormModelRenderer necktop = this.getModel().getPartByName("Neck2");
        private final BookwormModelRenderer head = this.getModel().getPartByName("Head");
        private final BookwormModelRenderer rightwing = this.getModel().getPartByName("RWing1");
        private final BookwormModelRenderer leftwing = this.getModel().getPartByName("LWing1");
        private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("RWing2");
        private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("LWing2");


        public HoatzinAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();
            if ((entityIn instanceof EntityHoatzin)) {
                EntityHoatzin hoatzin = (EntityHoatzin) entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;


                if (hoatzin.isSleeping() && hoatzin.onGround) {
                    this.getModel().interpolateToPose(RenderHoatzin.HOATZIN_SLEEPING, hoatzin.timer);

                    this.body2.rotateAngleX = MathHelper.cos(hoatzin.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.174533f;
                    this.head.rotateAngleX = MathHelper.cos(hoatzin.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 0.2181662f;
                    this.rightwing.rotateAngleX = MathHelper.cos(hoatzin.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f - 1.48353f;
                    this.leftwing.rotateAngleX = MathHelper.cos(hoatzin.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f - 1.48353f;
                }
                else {

                    this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 0.75f * 0.5f - 0.872665f;
                    this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 0.75f * 0.5f - 0.872665f;
                    this.head.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + 0.2181662f;
                    this.body2.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount - 0.174533f;

                    this.body2.rotateAngleX = MathHelper.cos(hoatzin.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.174533f;
                    this.head.rotateAngleX = MathHelper.cos(hoatzin.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 0.2181662f;
                    this.rightwing.rotateAngleX = MathHelper.cos(hoatzin.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f - 1.48353f;
                    this.leftwing.rotateAngleX = MathHelper.cos(hoatzin.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f - 1.48353f;

                    if (!hoatzin.onGround && !hoatzin.isInWater() && !hoatzin.isChild()) {
                        this.getModel().interpolateToPose(RenderHoatzin.HOATZIN_FLYING, hoatzin.timer);

                        this.rightwing.rotateAngleX = MathHelper.cos(hoatzin.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - (float)Math.toRadians(165);
                        this.leftwing.rotateAngleX = MathHelper.cos(hoatzin.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f  - (float)Math.toRadians(165);
                        this.rightwing.rotateAngleY = MathHelper.cos(hoatzin.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + (float)Math.toRadians(85);
                        this.leftwing.rotateAngleY = MathHelper.cos(hoatzin.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - (float)Math.toRadians(85);
                        this.rightwing2.rotateAngleY = MathHelper.cos(hoatzin.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.leftwing2.rotateAngleY = MathHelper.cos(hoatzin.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;

                    }
                }
            }
        }
    }
}

