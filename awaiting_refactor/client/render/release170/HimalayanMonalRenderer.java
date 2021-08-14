package com.ikerleon.birdwmod.client.render.release170;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.client.render.europe.EurasianBullfinchRenderer;
import com.ikerleon.birdwmod.entity.release170.HimalayanMonalEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class HimalayanMonalRenderer extends BirdBaseRenderer<HimalayanMonalEntity> {

    public static final ModelCMF HIMALAYAN_MONAL = new ModelCMF(new Identifier("birdwmod", "models/entity/himalayan_monal/himalayan_monal.bkm"));
    public static final ModelCMF HIMALAYAN_MONAL_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/himalayan_monal/himalayan_monal_flying.bkm"));
    public static final ModelCMF HIMALAYAN_MONAL_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/himalayan_monal/himalayan_monal_sleeping.bkm"));

    public static final Identifier TEXTUREMALE = new Identifier("birdwmod" + ":textures/entity/release170/himalayanmonalmale.png");
    public static final Identifier TEXTUREFEMALE = new Identifier("birdwmod" + ":textures/entity/release170/himalayanmonalfemale.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/release170/himalayanmonalchick.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/release170/himalayanmonal_sleeping.png");
    private static final Identifier MONAL_RING = new Identifier("birdwmod" + ":textures/entity/rings/monal_ring.png");

    public HimalayanMonalRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, HIMALAYAN_MONAL, 0.15F);
        HIMALAYAN_MONAL.setAnimator(HimalayanMonalRenderer.HimalayanMonalAnimator::new);
    }

    @Override
    protected void scale(HimalayanMonalEntity entity, MatrixStack matrices, float tickDelta) {
        if(entity.isBaby()){
            float scaleFactor= 0.15F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.45F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(HimalayanMonalEntity entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(HimalayanMonalEntity entity) {
        return MONAL_RING;
    }

    @Override
    public Identifier getTexture(HimalayanMonalEntity entity) {
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

    private class HimalayanMonalAnimator extends CMFAnimator {

        private final BookwormModelRenderer rightleg = this.getModel().getPartByName("RightThigh");
        private final BookwormModelRenderer leftleg = this.getModel().getPartByName("LeftThigh");
        private final BookwormModelRenderer body2 = this.getModel().getPartByName("TailBase");
        private final BookwormModelRenderer head = this.getModel().getPartByName("Head");
        private final BookwormModelRenderer rightwing = this.getModel().getPartByName("RightWingBase");
        private final BookwormModelRenderer leftwing = this.getModel().getPartByName("LeftWingBase");
        private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("RightWingMiddle");
        private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("LeftWingMiddle");

        public HimalayanMonalAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();

            if ((entityIn instanceof HimalayanMonalEntity)) {
                HimalayanMonalEntity bullfinch = (HimalayanMonalEntity)entityIn;

                float globalSpeed = 1.25f;
                float globalDegree = 1.25F;

                if(bullfinch.isSleeping() && bullfinch.isOnGround()){
                    this.getModel().interpolateToPose(HimalayanMonalRenderer.HIMALAYAN_MONAL_SLEEPING, bullfinch.timer);

                    this.body2.pitch = MathHelper.cos(bullfinch.age * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.head.pitch = MathHelper.cos(bullfinch.age * 0.2f) * 0.06F * 1 * 0.5f - 0.09110619f;
                    this.rightwing.pitch = MathHelper.cos(bullfinch.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(bullfinch.age * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {

                    if (!bullfinch.isOnGround() && !bullfinch.isTouchingWater() && !bullfinch.isBaby()) {
                        this.getModel().interpolateToPose(HimalayanMonalRenderer.HIMALAYAN_MONAL_FLYING, bullfinch.timer);

                        this.rightwing.pitch = MathHelper.cos(bullfinch.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 1.48353f;
                        this.leftwing.pitch = MathHelper.cos(bullfinch.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 1.48353f;
                        this.rightwing.roll = MathHelper.cos(bullfinch.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 1.48353f;
                        this.leftwing.roll = MathHelper.cos(bullfinch.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                        this.rightwing2.yaw = MathHelper.cos(bullfinch.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f;
                        this.leftwing2.yaw = MathHelper.cos(bullfinch.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f;
                    }
                    else{
                        this.rightleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 0.4553564f;
                        this.leftleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 0.4553564f;
                        this.head.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + 0.01710423f;
                        this.body2.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0.1298525f;

                        this.body2.pitch = MathHelper.cos(bullfinch.age * 0.17f) * 0.05F * 1 * 0.5f + 0.1298525f;
                        this.head.pitch = MathHelper.cos(bullfinch.age * 0.2f) * 0.06F * 1 * 0.5f + 0.01710423f;
                        this.rightwing.pitch = MathHelper.cos(bullfinch.age * 0.17f) * 0.03F * -1 * 0.5f;
                        this.leftwing.pitch = MathHelper.cos(bullfinch.age * 0.17f) * 0.03F * -1 * 0.5f;
                    }
                }
            }
        }
    }
}


