package com.ikerleon.birdwmod.client.render.europe;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.europe.EurasianBullfinchEntity;
import com.ikerleon.birdwmod.entity.europe.RedNeckedNightjarEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RedNeckedNightjarRenderer extends BirdBaseRenderer<RedNeckedNightjarEntity> {

    public static final ModelCMF RED_NECKED_NIGHTJAR = new ModelCMF(new Identifier("birdwmod", "models/entity/red_necked_nightjar/red_necked_nightjar.bkm"));
    public static final ModelCMF RED_NECKED_NIGHTJAR_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/red_necked_nightjar/red_necked_nightjar_flying.bkm"));
    public static final ModelCMF RED_NECKED_NIGHTJAR_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/red_necked_nightjar/red_necked_nightjar_sleeping.bkm"));

    public static final Identifier TEXTURE = new Identifier("birdwmod" + ":textures/entity/europe/rnnightjar.png");
    public static final Identifier TEXTURE2 = new Identifier("birdwmod" + ":textures/entity/europe/rnnightjar2.png");
    public static final Identifier TEXTURE3 = new Identifier("birdwmod" + ":textures/entity/europe/rnnightjar3.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/europe/rnnightjar_chick.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/europe/rnnightjar_sleeping.png");
    private final Identifier NIGHTJAR_RING = new Identifier("birdwmod" + ":textures/entity/rings/nightjar_ring.png");

    public RedNeckedNightjarRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, RED_NECKED_NIGHTJAR, 0.3F);
        RED_NECKED_NIGHTJAR.setAnimator(RedNeckedNightjarRenderer.RedNeckedNightjarAnimator::new);
    }

    @Override
    protected void scale(RedNeckedNightjarEntity entity, MatrixStack matrices, float tickDelta) {
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
    public Identifier getBlinkTexture(RedNeckedNightjarEntity entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(RedNeckedNightjarEntity entity) {
        return NIGHTJAR_RING;
    }

    @Override
    public Identifier getTexture(RedNeckedNightjarEntity entity) {
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

    private class RedNeckedNightjarAnimator extends CMFAnimator {

        private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
        private final BookwormModelRenderer head = this.getModel().getPartByName("head");
        private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
        private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
        private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
        private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");


        public RedNeckedNightjarAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();

            if ((entityIn instanceof RedNeckedNightjarEntity)) {
                RedNeckedNightjarEntity nightjar = (RedNeckedNightjarEntity)entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if(nightjar.isSleeping() && nightjar.isOnGround()){
                    this.getModel().interpolateToPose(RedNeckedNightjarRenderer.RED_NECKED_NIGHTJAR_SLEEPING, nightjar.timer);

                    this.body2.pitch = MathHelper.cos(nightjar.age * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.head.pitch = MathHelper.cos(nightjar.age * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
                    this.rightwing.pitch = MathHelper.cos(nightjar.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(nightjar.age * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {
                    this.body2.pitch = MathHelper.cos(nightjar.age * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.head.pitch = MathHelper.cos(nightjar.age * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
                    this.rightwing.pitch = MathHelper.cos(nightjar.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(nightjar.age * 0.17f) * 0.03F * -1 * 0.5f;

                    if (!nightjar.isOnGround() && !nightjar.isTouchingWater() && !nightjar.isBaby()) {
                        this.getModel().interpolateToPose(RedNeckedNightjarRenderer.RED_NECKED_NIGHTJAR_FLYING, nightjar.timer);

                        this.rightwing.pitch = MathHelper.cos(nightjar.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.leftwing.pitch = MathHelper.cos(nightjar.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.rightwing.roll = MathHelper.cos(nightjar.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
                        this.leftwing.roll = MathHelper.cos(nightjar.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                        this.rightwing2.yaw = MathHelper.cos(nightjar.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.leftwing2.yaw = MathHelper.cos(nightjar.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                    }
                }
            }
        }
    }
}
