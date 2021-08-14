package com.ikerleon.birdwmod.client.render.northamerica;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.northamerica.GreenHeronEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class GreenHeronRenderer extends BirdBaseRenderer<GreenHeronEntity> {

    public static final ModelCMF GREEN_HERON = new ModelCMF(new Identifier("birdwmod", "models/entity/green_heron/green_heron.bkm"));
    public static final ModelCMF GREEN_HERON_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/green_heron/green_heron_flying.bkm"));
    public static final ModelCMF GREEN_HERON_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/green_heron/green_heron_sleeping.bkm"));

    public static final Identifier TEXTURE = new Identifier("birdwmod" + ":textures/entity/northamerica/greenheron.png");
    public static final Identifier TEXTURE2 = new Identifier("birdwmod" + ":textures/entity/northamerica/greenheron2.png");
    public static final Identifier TEXTURE3 = new Identifier("birdwmod" + ":textures/entity/northamerica/greenheron3.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/northamerica/greenheron3.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/northamerica/greenheron_sleeping.png");
    private final Identifier HERON_RING = new Identifier("birdwmod" + ":textures/entity/rings/heron_ring.png");

    public GreenHeronRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, GREEN_HERON, 0.15F);
        GREEN_HERON.setAnimator(GreenHeronAnimator::new);
    }

    @Override
    protected void scale(GreenHeronEntity entity, MatrixStack matrices, float tickDelta) {
        if(entity.isBaby()){
            float scaleFactor= 0.3F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.55F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(GreenHeronEntity entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(GreenHeronEntity entity) {
        return HERON_RING;
    }

    @Override
    public Identifier getTexture(GreenHeronEntity entity) {
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

    private class GreenHeronAnimator extends CMFAnimator {

        private final BookwormModelRenderer ThighR = this.getModel().getPartByName("ThighR");
        private final BookwormModelRenderer ThighL = this.getModel().getPartByName("ThighL");
        private final BookwormModelRenderer Tailtop = this.getModel().getPartByName("Tailtop");
        private final BookwormModelRenderer Neck = this.getModel().getPartByName("Neck");
        private final BookwormModelRenderer Head = this.getModel().getPartByName("Head");
        private final BookwormModelRenderer WingR = this.getModel().getPartByName("WingR");
        private final BookwormModelRenderer WingL = this.getModel().getPartByName("WingL");
        private final BookwormModelRenderer Wing2R = this.getModel().getPartByName("Wing2R");
        private final BookwormModelRenderer Wing2L = this.getModel().getPartByName("Wing2L");

        public GreenHeronAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();
            if ((entityIn instanceof GreenHeronEntity)) {
                GreenHeronEntity heron = (GreenHeronEntity) entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if(heron.isSleeping() && heron.isOnGround()){
                    this.getModel().interpolateToPose(GreenHeronRenderer.GREEN_HERON_SLEEPING, heron.timer);

                    this.Tailtop.pitch = MathHelper.cos(heron.age * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.Head.pitch = MathHelper.cos(heron.age * 0.2f) * 0.06F * 1 * 0.5f + 4.85F * 0.5f;
                    this.WingR.pitch = MathHelper.cos(heron.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.WingL.pitch = MathHelper.cos(heron.age * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {
                    this.ThighR.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 1.85f * 0.5f;
                    this.ThighL.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 1.85f * 0.5f;
                    this.Neck.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount - 2.75F * 0.5f;
                    this.Tailtop.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

                    this.Tailtop.pitch = MathHelper.cos(heron.age * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.Head.pitch = MathHelper.cos(heron.age * 0.2f) * 0.06F * 1 * 0.5f + 4.85F * 0.5f;
                    this.WingR.pitch = MathHelper.cos(heron.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.WingL.pitch = MathHelper.cos(heron.age * 0.17f) * 0.03F * -1 * 0.5f;

                    if (!heron.isOnGround() && !heron.isTouchingWater() && !heron.isBaby()) {
                        this.getModel().interpolateToPose(GreenHeronRenderer.GREEN_HERON_FLYING, heron.timer);

                        this.WingR.pitch = MathHelper.cos(heron.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.WingL.pitch = MathHelper.cos(heron.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.WingR.roll = MathHelper.cos(heron.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
                        this.WingL.roll = MathHelper.cos(heron.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                        this.Wing2R.yaw = MathHelper.cos(heron.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.Wing2L.yaw = MathHelper.cos(heron.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                    }
                }
            }
        }
    }
}