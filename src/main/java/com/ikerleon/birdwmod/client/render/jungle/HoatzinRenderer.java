package com.ikerleon.birdwmod.client.render.jungle;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.jungle.HoatzinEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class HoatzinRenderer extends BirdBaseRenderer<HoatzinEntity> {

    public static final ModelCMF HOATZIN = new ModelCMF(new Identifier("birdwmod", "models/entity/hoatzin/hoatzin.bkm"));
    public static final ModelCMF HOATZIN_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/hoatzin/hoatzin_flying.bkm"));
    public static final ModelCMF HOATZIN_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/hoatzin/hoatzin_sleeping.bkm"));

    public static final Identifier TEXTURE = new Identifier("birdwmod" + ":textures/entity/jungle/hoatzin.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/jungle/hoatzin_chick.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/jungle/hoatzin_sleeping.png");
    private final Identifier HOATZIN_RING = new Identifier("birdwmod" + ":textures/entity/rings/hoatzin_ring.png");

    public HoatzinRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, HOATZIN, 0.4F);
        HOATZIN.setAnimator(HoatzinAnimator::new);
    }

    @Override
    protected void scale(HoatzinEntity entity, MatrixStack matrices, float tickDelta) {
        if(entity.isBaby()){
            float scaleFactor= 0.3F;

            matrices.translate(0F, -0.075, 0F);
            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.5F;

            matrices.translate(0F, -0.075, 0F);
            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(HoatzinEntity entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(HoatzinEntity entity) {
        return HOATZIN_RING;
    }

    @Override
    public Identifier getTexture(HoatzinEntity entity) {
        if(entity.isBaby()){
            return TEXTURECHICK;
        }
        else {
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
            if ((entityIn instanceof HoatzinEntity)) {
                HoatzinEntity hoatzin = (HoatzinEntity) entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;


                if (hoatzin.isSleeping() && hoatzin.isOnGround()) {
                    this.getModel().interpolateToPose(HoatzinRenderer.HOATZIN_SLEEPING, hoatzin.timer);

                    this.body2.pitch = MathHelper.cos(hoatzin.age * 0.17f) * 0.05F * 1 * 0.5f - 0.174533f;
                    this.head.pitch = MathHelper.cos(hoatzin.age * 0.2f) * 0.06F * 1 * 0.5f + 0.2181662f;
                    this.rightwing.pitch = MathHelper.cos(hoatzin.age * 0.17f) * 0.03F * -1 * 0.5f - 1.48353f;
                    this.leftwing.pitch = MathHelper.cos(hoatzin.age * 0.17f) * 0.03F * -1 * 0.5f - 1.48353f;
                }
                else {

                    this.rightleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 0.75f * 0.5f - 0.872665f;
                    this.leftleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 0.75f * 0.5f - 0.872665f;
                    this.head.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + 0.2181662f;
                    this.body2.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount - 0.174533f;

                    this.body2.pitch = MathHelper.cos(hoatzin.age * 0.17f) * 0.05F * 1 * 0.5f - 0.174533f;
                    this.head.pitch = MathHelper.cos(hoatzin.age * 0.2f) * 0.06F * 1 * 0.5f + 0.2181662f;
                    this.rightwing.pitch = MathHelper.cos(hoatzin.age * 0.17f) * 0.03F * -1 * 0.5f - 1.48353f;
                    this.leftwing.pitch = MathHelper.cos(hoatzin.age * 0.17f) * 0.03F * -1 * 0.5f - 1.48353f;

                    if (!hoatzin.isOnGround() && !hoatzin.isTouchingWater() && !hoatzin.isBaby()) {
                        this.getModel().interpolateToPose(HoatzinRenderer.HOATZIN_FLYING, hoatzin.timer);

                        this.rightwing.pitch = MathHelper.cos(hoatzin.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - (float)Math.toRadians(165);
                        this.leftwing.pitch = MathHelper.cos(hoatzin.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f  - (float)Math.toRadians(165);
                        this.rightwing.yaw = MathHelper.cos(hoatzin.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + (float)Math.toRadians(85);
                        this.leftwing.yaw = MathHelper.cos(hoatzin.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - (float)Math.toRadians(85);
                        this.rightwing2.yaw = MathHelper.cos(hoatzin.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.leftwing2.yaw = MathHelper.cos(hoatzin.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;

                    }
                }
            }
        }
    }
}
