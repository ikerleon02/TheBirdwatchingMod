package com.ikerleon.birdwmod.client.render.europe;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.europe.EurasianBullfinchEntity;
import com.ikerleon.birdwmod.entity.europe.RedFlankedBluetailEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RedFlankedBluetailRenderer extends BirdBaseRenderer<RedFlankedBluetailEntity> {

    public static final ModelCMF RED_FLANKED_BLUETAIL = new ModelCMF(new Identifier("birdwmod", "models/entity/red_flanked_bluetail/red_flanked_bluetail.bkm"));
    public static final ModelCMF RED_FLANKED_BLUETAIL_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/red_flanked_bluetail/red_flanked_bluetail_flying.bkm"));
    public static final ModelCMF RED_FLANKED_BLUETAIL_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/red_flanked_bluetail/red_flanked_bluetail_sleeping.bkm"));

    public static final Identifier TEXTUREMALE = new Identifier("birdwmod" + ":textures/entity/europe/redflankedbluetailmale.png");
    public static final Identifier TEXTUREFEMALE = new Identifier("birdwmod" + ":textures/entity/europe/redflankedbluetailfemale.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/europe/redflankedbluetail_chick.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/europe/redflankedbluetail_sleeping.png");
    private static final Identifier PASSERINE_RING = new Identifier("birdwmod" + ":textures/entity/rings/passerine_ring.png");

    public RedFlankedBluetailRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, RED_FLANKED_BLUETAIL, 0.15F);
        RED_FLANKED_BLUETAIL.setAnimator(RedFlankedBluetailRenderer.RedFlankedBluetailAnimator::new);
    }

    @Override
    protected void scale(RedFlankedBluetailEntity entity, MatrixStack matrices, float tickDelta) {
        if(entity.isBaby()){
            float scaleFactor= 0.15F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.3F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(RedFlankedBluetailEntity entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(RedFlankedBluetailEntity entity) {
        return PASSERINE_RING;
    }

    @Override
    public Identifier getTexture(RedFlankedBluetailEntity entity) {
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

    private class RedFlankedBluetailAnimator extends CMFAnimator {

        private final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
        private final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
        private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
        private final BookwormModelRenderer head = this.getModel().getPartByName("head");
        private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
        private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
        private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
        private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");


        public RedFlankedBluetailAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();

            if ((entityIn instanceof RedFlankedBluetailEntity)) {
                RedFlankedBluetailEntity bluetail = (RedFlankedBluetailEntity)entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if(bluetail.isSleeping() && bluetail.isOnGround()){
                    this.getModel().interpolateToPose(RedFlankedBluetailRenderer.RED_FLANKED_BLUETAIL_SLEEPING, bluetail.timer);

                    this.body2.pitch = MathHelper.cos(bluetail.age * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.head.pitch = MathHelper.cos(bluetail.age * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
                    this.rightwing.pitch = MathHelper.cos(bluetail.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(bluetail.age * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {
                    this.rightleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount;
                    this.leftleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount;
                    this.head.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount - 0.65F * 0.5f;
                    this.body2.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

                    this.body2.pitch = MathHelper.cos(bluetail.age * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.head.pitch = MathHelper.cos(bluetail.age * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
                    this.rightwing.pitch = MathHelper.cos(bluetail.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(bluetail.age * 0.17f) * 0.03F * -1 * 0.5f;

                    if (!bluetail.isOnGround() && !bluetail.isTouchingWater() && !bluetail.isBaby()) {
                        this.getModel().interpolateToPose(RedFlankedBluetailRenderer.RED_FLANKED_BLUETAIL_FLYING, bluetail.timer);

                        this.rightwing.pitch = MathHelper.cos(bluetail.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.leftwing.pitch = MathHelper.cos(bluetail.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.rightwing.roll = MathHelper.cos(bluetail.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
                        this.leftwing.roll = MathHelper.cos(bluetail.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                        this.rightwing2.yaw = MathHelper.cos(bluetail.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.leftwing2.yaw = MathHelper.cos(bluetail.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                    }
                }
            }
        }
    }
}

