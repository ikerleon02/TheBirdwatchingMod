package com.ikerleon.birdwmod.client.render.release170;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.release170.SabinesGullEntity;
import net.minecraft.block.Material;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class SabinesGullRenderer extends BirdBaseRenderer<SabinesGullEntity> {

    public static final ModelCMF SABINES_GULL = new ModelCMF(new Identifier("birdwmod", "models/entity/sabines_gull/sabines_gull.bkm"));
    public static final ModelCMF SABINES_GULL_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/sabines_gull/sabines_gull_flying.bkm"));
    public static final ModelCMF SABINES_GULL_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/sabines_gull/sabines_gull_sleeping.bkm"));
    public static final ModelCMF SABINES_GULL_SWIMMING = new ModelCMF(new Identifier("birdwmod", "models/entity/sabines_gull/sabines_gull_swimming.bkm"));

    public static final Identifier TEXTURE = new Identifier("birdwmod" + ":textures/entity/release170/sabinesgull.png");
    public static final Identifier TEXTURE2 = new Identifier("birdwmod" + ":textures/entity/release170/sabinesgull2.png");
    public static final Identifier TEXTURE3 = new Identifier("birdwmod" + ":textures/entity/release170/sabinesgull3.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/release170/sabinesgull_sleeping.png");
    private final Identifier GULL_RING = new Identifier("birdwmod" + ":textures/entity/rings/gull_ring.png");

    public SabinesGullRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, SABINES_GULL, 0.2F);
        SABINES_GULL.setAnimator(SabinesGullAnimator::new);
    }

    @Override
    protected void scale(SabinesGullEntity entity, MatrixStack matrices, float tickDelta) {
        if(entity.isBaby()){
            float scaleFactor= 0.25F;

            matrices.translate(0, -0.015, 0);
            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.5F;

            matrices.translate(0, -0.025, 0);
            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(SabinesGullEntity entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(SabinesGullEntity entity) {
        return GULL_RING;
    }

    @Override
    public Identifier getTexture(SabinesGullEntity entity) {
        if(entity.isBaby()){
            return TEXTURE3;
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

    private class SabinesGullAnimator extends CMFAnimator {

        private final BookwormModelRenderer rightleg = this.getModel().getPartByName("RightLeg");
        private final BookwormModelRenderer leftleg = this.getModel().getPartByName("LeftLeg");
        private final BookwormModelRenderer body2 = this.getModel().getPartByName("Body2");
        private final BookwormModelRenderer necktop = this.getModel().getPartByName("NeckBottom2");
        private final BookwormModelRenderer head = this.getModel().getPartByName("Head");
        private final BookwormModelRenderer rightwing = this.getModel().getPartByName("RightWing");
        private final BookwormModelRenderer leftwing = this.getModel().getPartByName("LeftWing");
        private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("RightWing2");
        private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("LeftWing2");

        public SabinesGullAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();

            BlockPos pos = new BlockPos(entityIn.getX(), entityIn.getY() - 0.2, entityIn.getZ());

            if ((entityIn instanceof SabinesGullEntity)) {
                SabinesGullEntity gull = (SabinesGullEntity) entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;


                if(gull.isSleeping() && gull.isOnGround()){
                    this.getModel().interpolateToPose(SabinesGullRenderer.SABINES_GULL_SLEEPING, gull.timer);

                    this.body2.pitch = MathHelper.cos(gull.age * 0.17f) * 0.05F * 1 * 0.5f - 0.32498031F;
                    this.head.pitch = MathHelper.cos(gull.age * 0.2f) * 0.06F * 1 * 0.5f + 0.31869712F;
                    this.rightwing.pitch = MathHelper.cos(gull.age * 0.17f) * 0.03F * -1 * 0.5f + 0.0872665F;
                    this.leftwing.pitch = MathHelper.cos(gull.age * 0.17f) * 0.03F * -1 * 0.5f + 0.0872665F;
                }

                else {
                    this.rightleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 0.2181662F;
                    this.leftleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 0.2181662F;
                    this.necktop.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount - 0.8290314F;
                    this.body2.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0.32498031F;

                    this.body2.pitch = MathHelper.cos(gull.age * 0.17f) * 0.05F * 1 * 0.5f - 0.32498031F;
                    this.head.pitch = MathHelper.cos(gull.age * 0.2f) * 0.06F * 1 * 0.5f + 0.174533f;
                    this.rightwing.pitch = MathHelper.cos(gull.age * 0.17f) * 0.03F * -1 * 0.5f + 0.0872665F;
                    this.leftwing.pitch = MathHelper.cos(gull.age * 0.17f) * 0.03F * -1 * 0.5f + 0.0872665F;

                    if (!gull.isOnGround() && !gull.isTouchingWater() && !gull.isBaby()) {
                        this.getModel().interpolateToPose(SabinesGullRenderer.SABINES_GULL_FLYING, gull.timer);

                        this.rightwing.pitch = MathHelper.cos(gull.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 1.48353F;
                        this.leftwing.pitch = MathHelper.cos(gull.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 1.48353F;
                        this.rightwing.roll = MathHelper.cos(gull.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 1.48353F;
                        this.leftwing.roll = MathHelper.cos(gull.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 1.48353F;
                        this.rightwing2.yaw = MathHelper.cos(gull.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f;
                        this.leftwing2.yaw = MathHelper.cos(gull.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f;
                    }
                    else if (gull.isTouchingWater() || entityIn.world.getBlockState(pos).getMaterial() == Material.WATER) {
                        this.getModel().interpolateToPose(SabinesGullRenderer.SABINES_GULL_SWIMMING, gull.timer);

                        this.head.pitch = MathHelper.cos((gull.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.2F) * 0.5f * 0.5F + 0.174533F;
                        this.necktop.pitch = MathHelper.cos(2.0F + (gull.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.05F) * 0.5f * 0.5F - 0.8290314F;
                        this.rightwing.pitch = MathHelper.cos((gull.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.3F) * 0.5f * 0.5F + 0.0872665F;
                        this.leftwing.pitch = MathHelper.cos((gull.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.3F) * 0.5f * 0.5F + 0.0872665F;
                        this.body2.pitch = MathHelper.cos((gull.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * -0.2F) * 0.5f * 0.5F - 0.32498031F;
                    }
                }
            }
        }
    }
}
