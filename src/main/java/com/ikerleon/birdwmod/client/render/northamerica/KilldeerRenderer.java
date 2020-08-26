package com.ikerleon.birdwmod.client.render.northamerica;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.northamerica.KilldeerEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class KilldeerRenderer extends BirdBaseRenderer<KilldeerEntity> {

    public static final ModelCMF KILLDEER = new ModelCMF(new Identifier("birdwmod", "models/entity/killdeer/killdeer.bkm"));
    public static final ModelCMF KILLDEER_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/killdeer/killdeer_flying.bkm"));
    public static final ModelCMF KILLDEER_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/killdeer/killdeer_sleeping.bkm"));

    public static final Identifier TEXTURE = new Identifier("birdwmod" + ":textures/entity/northamerica/killdeer.png");
    public static final Identifier TEXTURE2 = new Identifier("birdwmod" + ":textures/entity/northamerica/killdeer2.png");
    public static final Identifier TEXTURE3 = new Identifier("birdwmod" + ":textures/entity/northamerica/killdeer3.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/northamerica/killdeer_chick.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/northamerica/killdeer_sleeping.png");
    private final Identifier KILLDEER_RING = new Identifier("birdwmod" + ":textures/entity/rings/killdeer_ring.png");

    public KilldeerRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, KILLDEER, 0.15F);
        KILLDEER.setAnimator(KilldeerAnimator::new);
    }

    @Override
    protected void scale(KilldeerEntity entity, MatrixStack matrices, float tickDelta) {
        if(entity.isBaby()){
            float scaleFactor= 0.2F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.35F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(KilldeerEntity entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(KilldeerEntity entity) {
        return KILLDEER_RING;
    }

    @Override
    public Identifier getTexture(KilldeerEntity entity) {
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

    private class KilldeerAnimator extends CMFAnimator {

        private final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
        private final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
        private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
        private final BookwormModelRenderer necktop = this.getModel().getPartByName("necktop");
        private final BookwormModelRenderer head = this.getModel().getPartByName("head");
        private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
        private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
        private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
        private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");


        public KilldeerAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();
            if ((entityIn instanceof KilldeerEntity)) {
                KilldeerEntity killdeer = (KilldeerEntity) entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if(killdeer.isSleeping() && killdeer.isOnGround()){
                    this.getModel().interpolateToPose(KilldeerRenderer.KILLDEER_SLEEPING, killdeer.timer);

                    this.body2.pitch = MathHelper.cos(killdeer.age * 0.17f) * 0.05F * 1 * 0.5f + 2.75F * 0.5f;
                    this.head.pitch = MathHelper.cos(killdeer.age * 0.2f) * 0.06F * 1 * 0.5f + 1F * 0.5f;
                    this.rightwing.pitch = MathHelper.cos(killdeer.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(killdeer.age * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {
                    this.rightleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 0.85f * 0.5f;
                    this.leftleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 0.85f * 0.5f;
                    this.necktop.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + 2.5F * 0.5f;
                    this.body2.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

                    this.body2.pitch = MathHelper.cos(killdeer.age * 0.17f) * 0.05F * 1 * 0.5f + 2.75F * 0.5f;
                    this.head.pitch = MathHelper.cos(killdeer.age * 0.2f) * 0.06F * 1 * 0.5f + 1F * 0.5f;
                    this.rightwing.pitch = MathHelper.cos(killdeer.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(killdeer.age * 0.17f) * 0.03F * -1 * 0.5f;

                    if (!killdeer.isOnGround() && !killdeer.isTouchingWater() && !killdeer.isBaby()) {
                        this.getModel().interpolateToPose(KilldeerRenderer.KILLDEER_FLYING, killdeer.timer);

                        this.rightwing.pitch = MathHelper.cos(killdeer.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.leftwing.pitch = MathHelper.cos(killdeer.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.rightwing.roll = MathHelper.cos(killdeer.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
                        this.leftwing.roll = MathHelper.cos(killdeer.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                        this.rightwing2.yaw = MathHelper.cos(killdeer.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.leftwing2.yaw = MathHelper.cos(killdeer.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                    }
                }
            }
        }
    }
}

