package com.ikerleon.birdwmod.client.render.jungle;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.jungle.EntityKingofSaxony;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RenderKingofSaxony extends RenderBirdBase<EntityKingofSaxony> {

    public static final ModelCMF KING_OF_SAXONY = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/king_of_saxony/kingofsaxony.bkm"));
    public static final ModelCMF KING_OF_SAXONY_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/king_of_saxony/kingofsaxonyflying.bkm"));
    public static final ModelCMF KING_OF_SAXONY_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/king_of_saxony/kingofsaxonysleeping.bkm"));

    public static final ResourceLocation TEXTUREMALE = new ResourceLocation(Reference.MODID + ":textures/entity/jungle/kingofsaxonymale.png");
    public static final ResourceLocation TEXTUREFEMALE = new ResourceLocation(Reference.MODID + ":textures/entity/jungle/kingofsaxonyfemale.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/jungle/kingofsaxonyfemale.png");
    public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/jungle/kingofsaxony_sleeping.png");
    private static final ResourceLocation PASSERINE_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/passerine_ring.png");

    public RenderKingofSaxony(RenderManager manager) {
        super(manager, KING_OF_SAXONY, 0.15F);
        KING_OF_SAXONY.setAnimator(KingofSaxonyAnimator::new);
    }

    @Override
    protected void preRenderCallback(EntityKingofSaxony entitylivingbaseIn, float partialTickTime) {
        if(entitylivingbaseIn.isChild()){
            float scaleFactor= 0.2F;

            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.4F;

            GlStateManager.translate(0, -0.01, 0);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
    }

    @Override
    public ResourceLocation getBlinkTexture(EntityKingofSaxony entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public ResourceLocation getRingTexture(EntityKingofSaxony entity) {
        return PASSERINE_RING;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityKingofSaxony entity) {
        if(entity.isChild()){
            return TEXTURECHICK;
        }
        else {
            if (entity.getGender() == 0) {
                return TEXTUREMALE;
            } else {
                return TEXTUREFEMALE;
            }
        }
    }

    private class KingofSaxonyAnimator extends CMFAnimator {

        private final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
        private final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
        private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
        private final BookwormModelRenderer head = this.getModel().getPartByName("head");
        private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
        private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
        private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
        private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");

        private final BookwormModelRenderer headfeatherright = this.getModel().getPartByName("headfeatherright");
        private final BookwormModelRenderer headfeatherright2 = this.getModel().getPartByName("headfeatherright2");
        private final BookwormModelRenderer headfeatherright3 = this.getModel().getPartByName("headfeatherright3");
        private final BookwormModelRenderer headfeatherright5 = this.getModel().getPartByName("headfeatherright5");
        private final BookwormModelRenderer headfeatherleft = this.getModel().getPartByName("headfeatherleft");
        private final BookwormModelRenderer headfeatherleft2 = this.getModel().getPartByName("headfeatherleft2");
        private final BookwormModelRenderer headfeatherleft3 = this.getModel().getPartByName("headfeatherleft3");
        private final BookwormModelRenderer headfeatherleft5 = this.getModel().getPartByName("headfeatherleft5");


        public KingofSaxonyAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();

            if ((entityIn instanceof EntityKingofSaxony)) {
                EntityKingofSaxony kingofSaxony = (EntityKingofSaxony)entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if(kingofSaxony.isSleeping() && kingofSaxony.onGround){
                    this.getModel().interpolateToPose(RenderKingofSaxony.KING_OF_SAXONY_SLEEPING, kingofSaxony.timer);

                    this.body2.rotateAngleX = MathHelper.cos(kingofSaxony.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.head.rotateAngleX = MathHelper.cos(kingofSaxony.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
                    this.rightwing.rotateAngleX = MathHelper.cos(kingofSaxony.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.rotateAngleX = MathHelper.cos(kingofSaxony.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

                    this.headfeatherright.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.1f) * 0.05f * -1F * 0.5F) + (float) Math.toRadians(-35);
                    this.headfeatherright2.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.15f) * 0.1f * 1F * 0.5F) + (float) Math.toRadians(10);
                    this.headfeatherright3.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.15f) * 0.15f * 1F * 0.5F) + (float) Math.toRadians(5);
                    this.headfeatherright5.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.15f) * 0.20f * 1F * 0.5F);
                    this.headfeatherleft.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.1f) * 0.05f * -1F * 0.5F) + (float) Math.toRadians(-35);
                    this.headfeatherleft2.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.15f) * 0.1f * 1F * 0.5F) + (float) Math.toRadians(10);
                    this.headfeatherleft3.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.15f) * 0.15f * 1F * 0.5F) + (float) Math.toRadians(5);
                    this.headfeatherleft5.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.15f) * 0.2f * 1F * 0.5F);
                }

                else {

                    this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 0.5f * 0.5f;
                    this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 0.5f * 0.5f;
                    this.head.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount - 0.65F * 0.5f;
                    this.body2.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

                    this.body2.rotateAngleX = MathHelper.cos(kingofSaxony.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.head.rotateAngleX = MathHelper.cos(kingofSaxony.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
                    this.rightwing.rotateAngleX = MathHelper.cos(kingofSaxony.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.rotateAngleX = MathHelper.cos(kingofSaxony.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

                    this.headfeatherright.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.1f) * 0.1f * -1F * 0.5F) + (float) Math.toRadians(-35);
                    this.headfeatherright2.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.15f) * 0.15f * 1F * 0.5F) + (float) Math.toRadians(10);
                    this.headfeatherright3.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.15f) * 0.25f * 1F * 0.5F) + (float) Math.toRadians(5);
                    this.headfeatherright5.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.15f) * 0.3f * 1F * 0.5F);
                    this.headfeatherleft.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.1f) * 0.1f * 1F * 0.5F) + (float) Math.toRadians(-35);
                    this.headfeatherleft2.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.15f) * 0.15f * -1F * 0.5F) + (float) Math.toRadians(10);
                    this.headfeatherleft3.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.15f) * 0.25f * -1F * 0.5F) + (float) Math.toRadians(5);
                    this.headfeatherleft5.rotateAngleX = (MathHelper.cos(kingofSaxony.ticksExisted * 0.15f) * 0.3f * -1F * 0.5F);

                    if (!kingofSaxony.onGround && !kingofSaxony.isInWater() && !kingofSaxony.isChild()) {
                        this.getModel().interpolateToPose(RenderKingofSaxony.KING_OF_SAXONY_FLYING, kingofSaxony.timer);

                        this.rightwing.rotateAngleX = MathHelper.cos(kingofSaxony.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.leftwing.rotateAngleX = MathHelper.cos(kingofSaxony.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.rightwing.rotateAngleZ = MathHelper.cos(kingofSaxony.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
                        this.leftwing.rotateAngleZ = MathHelper.cos(kingofSaxony.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                        this.rightwing2.rotateAngleY = MathHelper.cos(kingofSaxony.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.leftwing2.rotateAngleY = MathHelper.cos(kingofSaxony.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;

                        this.headfeatherright.rotateAngleY = (MathHelper.cos(kingofSaxony.ticksExisted * 0.3f) * 0.1f * -1F * 0.5F) + (float) Math.toRadians(10);
                        this.headfeatherright2.rotateAngleY = (MathHelper.cos(kingofSaxony.ticksExisted * 0.35f) * 0.15f * 1F * 0.5F) + (float) Math.toRadians(-7.5);
                        this.headfeatherright3.rotateAngleY = (MathHelper.cos(kingofSaxony.ticksExisted * 0.35f) * 0.25f * 1F * 0.5F);
                        this.headfeatherright5.rotateAngleY = (MathHelper.cos(kingofSaxony.ticksExisted * 0.35f) * 0.3f * 1F * 0.5F);
                        this.headfeatherleft.rotateAngleY = (MathHelper.cos(kingofSaxony.ticksExisted * 0.3f) * 0.1f * 1F * 0.5F) + (float) Math.toRadians(10);
                        this.headfeatherleft2.rotateAngleY = (MathHelper.cos(kingofSaxony.ticksExisted * 0.35f) * 0.15f * -1F * 0.5F) + (float) Math.toRadians(-7.5);
                        this.headfeatherleft3.rotateAngleY = (MathHelper.cos(kingofSaxony.ticksExisted * 0.35f) * 0.25f * -1F * 0.5F);
                        this.headfeatherleft5.rotateAngleY = (MathHelper.cos(kingofSaxony.ticksExisted * 0.35f) * 0.3f * -1F * 0.5F);
                    }
                }
            }
        }
    }
}

