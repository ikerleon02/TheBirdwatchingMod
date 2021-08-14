package com.ikerleon.birdwmod.client.render.jungle;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.jungle.KingOfSaxonyEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class KingOfSaxonyRenderer extends BirdBaseRenderer<KingOfSaxonyEntity> {

    public static final ModelCMF KING_OF_SAXONY = new ModelCMF(new Identifier("birdwmod", "models/entity/king_of_saxony/kingofsaxony.bkm"));
    public static final ModelCMF KING_OF_SAXONY_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/king_of_saxony/kingofsaxonyflying.bkm"));
    public static final ModelCMF KING_OF_SAXONY_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/king_of_saxony/kingofsaxonysleeping.bkm"));

    public static final Identifier TEXTUREMALE = new Identifier("birdwmod" + ":textures/entity/jungle/kingofsaxonymale.png");
    public static final Identifier TEXTUREFEMALE = new Identifier("birdwmod" + ":textures/entity/jungle/kingofsaxonyfemale.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/jungle/kingofsaxonyfemale.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/jungle/kingofsaxony_sleeping.png");
    private static final Identifier PASSERINE_RING = new Identifier("birdwmod" + ":textures/entity/rings/passerine_ring.png");

    public KingOfSaxonyRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, KING_OF_SAXONY, 0.15F);
        KING_OF_SAXONY.setAnimator(KingOfSaxonyAnimator::new);
    }

    @Override
    protected void scale(KingOfSaxonyEntity entity, MatrixStack matrices, float tickDelta) {
        if(entity.isBaby()){
            float scaleFactor= 0.2F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.4F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(KingOfSaxonyEntity entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(KingOfSaxonyEntity entity) {
        return PASSERINE_RING;
    }

    @Override
    public Identifier getTexture(KingOfSaxonyEntity entity) {
        if(entity.isBaby()){
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

    private class KingOfSaxonyAnimator extends CMFAnimator {

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


        public KingOfSaxonyAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();

            if ((entityIn instanceof KingOfSaxonyEntity)) {
                KingOfSaxonyEntity kingofSaxony = (KingOfSaxonyEntity)entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if(kingofSaxony.isSleeping() && kingofSaxony.isOnGround()){
                    this.getModel().interpolateToPose(KingOfSaxonyRenderer.KING_OF_SAXONY_SLEEPING, kingofSaxony.timer);

                    this.body2.pitch = MathHelper.cos(kingofSaxony.age * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.head.pitch = MathHelper.cos(kingofSaxony.age * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
                    this.rightwing.pitch = MathHelper.cos(kingofSaxony.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(kingofSaxony.age * 0.17f) * 0.03F * -1 * 0.5f;

                    this.headfeatherright.pitch = (MathHelper.cos(kingofSaxony.age * 0.1f) * 0.05f * -1F * 0.5F) + (float) Math.toRadians(-35);
                    this.headfeatherright2.pitch = (MathHelper.cos(kingofSaxony.age * 0.15f) * 0.1f * 1F * 0.5F) + (float) Math.toRadians(10);
                    this.headfeatherright3.pitch = (MathHelper.cos(kingofSaxony.age * 0.15f) * 0.15f * 1F * 0.5F) + (float) Math.toRadians(5);
                    this.headfeatherright5.pitch = (MathHelper.cos(kingofSaxony.age * 0.15f) * 0.20f * 1F * 0.5F);
                    this.headfeatherleft.pitch = (MathHelper.cos(kingofSaxony.age * 0.1f) * 0.05f * -1F * 0.5F) + (float) Math.toRadians(-35);
                    this.headfeatherleft2.pitch = (MathHelper.cos(kingofSaxony.age * 0.15f) * 0.1f * 1F * 0.5F) + (float) Math.toRadians(10);
                    this.headfeatherleft3.pitch = (MathHelper.cos(kingofSaxony.age * 0.15f) * 0.15f * 1F * 0.5F) + (float) Math.toRadians(5);
                    this.headfeatherleft5.pitch = (MathHelper.cos(kingofSaxony.age * 0.15f) * 0.2f * 1F * 0.5F);
                }
                else {
                    this.rightleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 0.5f * 0.5f;
                    this.leftleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 0.5f * 0.5f;
                    this.head.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount - 0.65F * 0.5f;
                    this.body2.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

                    this.body2.pitch = MathHelper.cos(kingofSaxony.age * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.head.pitch = MathHelper.cos(kingofSaxony.age * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
                    this.rightwing.pitch = MathHelper.cos(kingofSaxony.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(kingofSaxony.age * 0.17f) * 0.03F * -1 * 0.5f;

                    this.headfeatherright.pitch = (MathHelper.cos(kingofSaxony.age * 0.1f) * 0.1f * -1F * 0.5F) + (float) Math.toRadians(-35);
                    this.headfeatherright2.pitch = (MathHelper.cos(kingofSaxony.age * 0.15f) * 0.15f * 1F * 0.5F) + (float) Math.toRadians(10);
                    this.headfeatherright3.pitch = (MathHelper.cos(kingofSaxony.age * 0.15f) * 0.25f * 1F * 0.5F) + (float) Math.toRadians(5);
                    this.headfeatherright5.pitch = (MathHelper.cos(kingofSaxony.age * 0.15f) * 0.3f * 1F * 0.5F);
                    this.headfeatherleft.pitch = (MathHelper.cos(kingofSaxony.age * 0.1f) * 0.1f * 1F * 0.5F) + (float) Math.toRadians(-35);
                    this.headfeatherleft2.pitch = (MathHelper.cos(kingofSaxony.age * 0.15f) * 0.15f * -1F * 0.5F) + (float) Math.toRadians(10);
                    this.headfeatherleft3.pitch = (MathHelper.cos(kingofSaxony.age * 0.15f) * 0.25f * -1F * 0.5F) + (float) Math.toRadians(5);
                    this.headfeatherleft5.pitch = (MathHelper.cos(kingofSaxony.age * 0.15f) * 0.3f * -1F * 0.5F);

                    if (!kingofSaxony.isOnGround() && !kingofSaxony.isTouchingWater() && !kingofSaxony.isBaby()) {
                        this.getModel().interpolateToPose(KingOfSaxonyRenderer.KING_OF_SAXONY_FLYING, kingofSaxony.timer);

                        this.rightwing.pitch = MathHelper.cos(kingofSaxony.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.leftwing.pitch = MathHelper.cos(kingofSaxony.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.rightwing.roll = MathHelper.cos(kingofSaxony.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
                        this.leftwing.roll = MathHelper.cos(kingofSaxony.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                        this.rightwing2.yaw = MathHelper.cos(kingofSaxony.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.leftwing2.yaw = MathHelper.cos(kingofSaxony.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;

                        this.headfeatherright.yaw = (MathHelper.cos(kingofSaxony.age * 0.3f) * 0.1f * -1F * 0.5F) + (float) Math.toRadians(10);
                        this.headfeatherright2.yaw = (MathHelper.cos(kingofSaxony.age * 0.35f) * 0.15f * 1F * 0.5F) + (float) Math.toRadians(-7.5);
                        this.headfeatherright3.yaw = (MathHelper.cos(kingofSaxony.age * 0.35f) * 0.25f * 1F * 0.5F);
                        this.headfeatherright5.yaw = (MathHelper.cos(kingofSaxony.age * 0.35f) * 0.3f * 1F * 0.5F);
                        this.headfeatherleft.yaw = (MathHelper.cos(kingofSaxony.age * 0.3f) * 0.1f * 1F * 0.5F) + (float) Math.toRadians(10);
                        this.headfeatherleft2.yaw = (MathHelper.cos(kingofSaxony.age * 0.35f) * 0.15f * -1F * 0.5F) + (float) Math.toRadians(-7.5);
                        this.headfeatherleft3.yaw = (MathHelper.cos(kingofSaxony.age * 0.35f) * 0.25f * -1F * 0.5F);
                        this.headfeatherleft5.yaw = (MathHelper.cos(kingofSaxony.age * 0.35f) * 0.3f * -1F * 0.5F);
                    }
                }
            }
        }
    }
}
