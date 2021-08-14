package com.ikerleon.birdwmod.client.render.jungle;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.jungle.TurquoiseBrowedMotmotEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class TurquoiseBrowedMotmotRenderer extends BirdBaseRenderer<TurquoiseBrowedMotmotEntity> {

    public static final ModelCMF TURQUOISEBROWED_MOTMOT = new ModelCMF(new Identifier("birdwmod", "models/entity/motmot/motmot.bkm"));
    public static final ModelCMF TURQUOISEBROWED_MOTMOT_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/motmot/motmotflying.bkm"));
    public static final ModelCMF TURQUOISEBROWED_MOTMOT_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/motmot/motmotsleeping.bkm"));

    public static final Identifier TEXTURE = new Identifier("birdwmod" + ":textures/entity/jungle/motmot.png");
    public static final Identifier TEXTURE2 = new Identifier("birdwmod" + ":textures/entity/jungle/motmot2.png");
    public static final Identifier TEXTURE3 = new Identifier("birdwmod" + ":textures/entity/jungle/motmot3.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/jungle/motmot2.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/jungle/motmot_sleeping.png");
    private final Identifier MOTMOT_RING = new Identifier("birdwmod" + ":textures/entity/rings/motmot_ring.png");

    public TurquoiseBrowedMotmotRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, TURQUOISEBROWED_MOTMOT, 0.15F);
        TURQUOISEBROWED_MOTMOT.setAnimator(MotmotAnimator::new);
    }

    @Override
    protected void scale(TurquoiseBrowedMotmotEntity entity, MatrixStack matrices, float tickDelta) {
        if(entity.isBaby()){
            float scaleFactor= 0.25F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.45F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(TurquoiseBrowedMotmotEntity entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(TurquoiseBrowedMotmotEntity entity) {
        return MOTMOT_RING;
    }

    @Override
    public Identifier getTexture(TurquoiseBrowedMotmotEntity entity) {
        if(entity.isBaby()){
            return TEXTURECHICK;
        }
        else {
            return this.getTextureOfVar(entity.getVariant());
        }
    }

    public Identifier getTextureOfVar(int variant) {
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
            if ((entityIn instanceof TurquoiseBrowedMotmotEntity)) {
                TurquoiseBrowedMotmotEntity motmot = (TurquoiseBrowedMotmotEntity) entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;


                if(motmot.isSleeping() && motmot.isOnGround()){
                    this.getModel().interpolateToPose(TurquoiseBrowedMotmotRenderer.TURQUOISEBROWED_MOTMOT_SLEEPING, motmot.timer);

                    this.body2.pitch = MathHelper.cos(motmot.age * 0.17f) * 0.05F * 1 * 0.5f + (float)Math.toRadians(-2.5);
                    this.head.pitch = MathHelper.cos(motmot.age * 0.2f) * 0.06F * 1 * 0.5f + (float)Math.toRadians(40);
                    this.rightwing.pitch = MathHelper.cos(motmot.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(motmot.age * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {
                    this.rightleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + (float)Math.toRadians(10);
                    this.leftleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + (float)Math.toRadians(10);
                    this.necktop.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + (float)Math.toRadians(-15);
                    this.body2.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + (float)Math.toRadians(-2.5);

                    this.body2.pitch = MathHelper.cos(motmot.age * 0.17f) * 0.05F * 1 * 0.5f + (float)Math.toRadians(-2.5);
                    this.head.pitch = MathHelper.cos(motmot.age * 0.2f) * 0.06F * 1 * 0.5f + (float)Math.toRadians(40);
                    this.rightwing.pitch = MathHelper.cos(motmot.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(motmot.age * 0.17f) * 0.03F * -1 * 0.5f;

                    if (!motmot.isOnGround() && !motmot.isTouchingWater() && !motmot.isBaby()) {
                        this.getModel().interpolateToPose(TurquoiseBrowedMotmotRenderer.TURQUOISEBROWED_MOTMOT_FLYING, motmot.timer);

                        this.rightwing.pitch = MathHelper.cos(motmot.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + (float)Math.toRadians(-75);
                        this.leftwing.pitch = MathHelper.cos(motmot.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f+ (float)Math.toRadians(-75);
                        this.rightwing.roll = MathHelper.cos(motmot.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + (float)Math.toRadians(90);
                        this.leftwing.roll = MathHelper.cos(motmot.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + (float)Math.toRadians(-90);
                        this.rightwing2.yaw = MathHelper.cos(motmot.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + (float)Math.toRadians(5);
                        this.leftwing2.yaw = MathHelper.cos(motmot.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + (float)Math.toRadians(-5);
                    }
                }
            }
        }
    }
}
