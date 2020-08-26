package com.ikerleon.birdwmod.client.render.northamerica;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.northamerica.NorthernMockingbirdEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class NorthernMockingbirdRenderer extends BirdBaseRenderer<NorthernMockingbirdEntity> {

    public static final ModelCMF NORTHERN_MOCKINGBIRD = new ModelCMF(new Identifier("birdwmod", "models/entity/northern_mockingbird/northern_mockingbird.bkm"));
    public static final ModelCMF NORTHERN_MOCKINGBIRD_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/northern_mockingbird/northern_mockingbird_flying.bkm"));
    public static final ModelCMF NORTHERN_MOCKINGBIRD_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/northern_mockingbird/northern_mockingbird_sleeping.bkm"));

    public static final Identifier TEXTURE = new Identifier("birdwmod" + ":textures/entity/northamerica/northernmockingbird.png");
    public static final Identifier TEXTURE2 = new Identifier("birdwmod" + ":textures/entity/northamerica/northernmockingbird2.png");
    public static final Identifier TEXTURE3 = new Identifier("birdwmod" + ":textures/entity/northamerica/northernmockingbird3.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/northamerica/northernmockingbird_chick.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/northamerica/northernmockingbird_sleeping.png");
    private final Identifier MOCKINGBIRD_RING = new Identifier("birdwmod" + ":textures/entity/rings/mockingbird_ring.png");

    public NorthernMockingbirdRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, NORTHERN_MOCKINGBIRD, 0.2F);
        NORTHERN_MOCKINGBIRD.setAnimator(NorthernMockingbirdAnimator::new);
    }

    @Override
    protected void scale(NorthernMockingbirdEntity entity, MatrixStack matrices, float tickDelta) {
        if(entity.isBaby()){
            float scaleFactor= 0.15F;

            matrices.translate(0, -0.015, 0);
            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.3F;

            matrices.translate(0, -0.025, 0);
            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(NorthernMockingbirdEntity entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(NorthernMockingbirdEntity entity) {
        return MOCKINGBIRD_RING;
    }

    @Override
    public Identifier getTexture(NorthernMockingbirdEntity entity) {
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

    private class NorthernMockingbirdAnimator extends CMFAnimator {

        private final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
        private final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
        private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
        private final BookwormModelRenderer necktop = this.getModel().getPartByName("necktop");
        private final BookwormModelRenderer head = this.getModel().getPartByName("head");
        private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
        private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
        private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
        private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");


        public NorthernMockingbirdAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();
            if ((entityIn instanceof NorthernMockingbirdEntity)) {
                NorthernMockingbirdEntity mockingbird = (NorthernMockingbirdEntity) entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;


                if(mockingbird.isSleeping() && mockingbird.isOnGround()){
                    this.getModel().interpolateToPose(NorthernMockingbirdRenderer.NORTHERN_MOCKINGBIRD_SLEEPING, mockingbird.timer);

                    this.body2.pitch = MathHelper.cos(mockingbird.age * 0.17f) * 0.05F * 1 * 0.5f + 3.25F * 0.5f;
                    this.head.pitch = MathHelper.cos(mockingbird.age * 0.2f) * 0.06F * 1 * 0.5f + 0.5F * 0.5f;
                    this.rightwing.pitch = MathHelper.cos(mockingbird.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(mockingbird.age * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {
                    this.rightleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 1f * 0.5f;
                    this.leftleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 1f * 0.5f;
                    this.necktop.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + 1.75F * 0.5f;
                    this.body2.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

                    this.body2.pitch = MathHelper.cos(mockingbird.age * 0.17f) * 0.05F * 1 * 0.5f + 3.25F * 0.5f;
                    this.head.pitch = MathHelper.cos(mockingbird.age * 0.2f) * 0.06F * 1 * 0.5f + 0.5F * 0.5f;
                    this.rightwing.pitch = MathHelper.cos(mockingbird.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(mockingbird.age * 0.17f) * 0.03F * -1 * 0.5f;

                    if (!mockingbird.isOnGround() && !mockingbird.isTouchingWater() && !mockingbird.isBaby()) {
                        this.getModel().interpolateToPose(NorthernMockingbirdRenderer.NORTHERN_MOCKINGBIRD_FLYING, mockingbird.timer);

                        this.rightwing.pitch = MathHelper.cos(mockingbird.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.leftwing.pitch = MathHelper.cos(mockingbird.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.rightwing.roll = MathHelper.cos(mockingbird.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
                        this.leftwing.roll = MathHelper.cos(mockingbird.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                        this.rightwing2.yaw = MathHelper.cos(mockingbird.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.leftwing2.yaw = MathHelper.cos(mockingbird.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                    }
                }
            }
        }
    }
}