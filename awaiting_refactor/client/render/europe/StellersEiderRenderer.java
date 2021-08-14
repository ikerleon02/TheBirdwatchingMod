package com.ikerleon.birdwmod.client.render.europe;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.europe.EurasianBullfinchEntity;
import com.ikerleon.birdwmod.entity.europe.StellersEiderEntity;
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

public class StellersEiderRenderer extends BirdBaseRenderer<StellersEiderEntity> {

    public static final ModelCMF STELLERS_EIDER = new ModelCMF(new Identifier("birdwmod", "models/entity/stellers_eider/stellers_eider.bkm"));
    public static final ModelCMF STELLERS_EIDER_SWIMMING = new ModelCMF(new Identifier("birdwmod", "models/entity/stellers_eider/stellers_eider_swimming.bkm"));
    public static final ModelCMF STELLERS_EIDER_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/stellers_eider/stellers_eider_flying.bkm"));
    public static final ModelCMF STELLERS_EIDER_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/stellers_eider/stellers_eider_sleeping.bkm"));

    public static final Identifier TEXTUREMALE = new Identifier("birdwmod" + ":textures/entity/europe/stellerseidermale.png");
    public static final Identifier TEXTUREFEMALE = new Identifier("birdwmod" + ":textures/entity/europe/stellerseiderfemale.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/europe/stellerseider_chick.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/europe/stellerseider_sleeping.png");
    private final Identifier EIDER_RING = new Identifier("birdwmod" + ":textures/entity/rings/eider_ring.png");

    public StellersEiderRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, STELLERS_EIDER, 0.15F);
        STELLERS_EIDER.setAnimator(StellersEiderAnimator::new);
    }

    @Override
    protected void scale(StellersEiderEntity entity, MatrixStack matrices, float tickDelta) {
        if(entity.isBaby()){
            float scaleFactor= 0.3F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.6F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(StellersEiderEntity entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(StellersEiderEntity entity) {
        return EIDER_RING;
    }

    @Override
    public Identifier getTexture(StellersEiderEntity entity) {
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

    private class StellersEiderAnimator extends CMFAnimator {

        private final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
        private final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
        private final BookwormModelRenderer neck = this.getModel().getPartByName("neck");
        private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
        private final BookwormModelRenderer head = this.getModel().getPartByName("head");
        private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
        private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
        private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
        private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");


        public StellersEiderAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();

            BlockPos pos = new BlockPos(entityIn.getX(), entityIn.getY() - 0.2, entityIn.getZ());

            if ((entityIn instanceof StellersEiderEntity)) {
                StellersEiderEntity eider = (StellersEiderEntity)entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if(eider.isSleeping() && eider.isOnGround()){
                    this.getModel().interpolateToPose(StellersEiderRenderer.STELLERS_EIDER_SLEEPING, eider.timer);

                    this.body2.pitch = MathHelper.cos(eider.age * 0.17f) * 0.05F * 1 * 0.5f + 0.25F * 0.5f;
                    this.head.pitch = MathHelper.cos(eider.age * 0.2f) * 0.06F * 1 * 0.5f + 2.8F * 0.5f;
                    this.rightwing.pitch = MathHelper.cos(eider.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(eider.age * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {
                    this.rightleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount - 4f * 0.5f;
                    this.leftleg.pitch = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount - 4f * 0.5f;
                    this.neck.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + 5.25F * 0.5f;
                    this.body2.pitch = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

                    this.body2.pitch = MathHelper.cos(eider.age * 0.17f) * 0.05F * 1 * 0.5f + 0.25F * 0.5f;
                    this.head.pitch = MathHelper.cos(eider.age * 0.2f) * 0.06F * 1 * 0.5f + 2.8F * 0.5f;
                    this.rightwing.pitch = MathHelper.cos(eider.age * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.pitch = MathHelper.cos(eider.age * 0.17f) * 0.03F * -1 * 0.5f;

                    if ((!eider.isOnGround() && !eider.isTouchingWater() && !eider.isBaby()) && entityIn.world.getBlockState(pos).getMaterial() != Material.WATER) {
                        this.getModel().interpolateToPose(StellersEiderRenderer.STELLERS_EIDER_FLYING, eider.timer);

                        this.rightwing.pitch = MathHelper.cos(eider.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + 2.5F * 0.5f;
                        this.leftwing.pitch = MathHelper.cos(eider.age * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + 2.5F * 0.5f;
                        this.rightwing.yaw = MathHelper.cos(eider.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f - 3F * 0.5f;
                        this.leftwing.yaw = MathHelper.cos(eider.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 3F * 0.5f;
                        this.rightwing2.roll = MathHelper.cos(eider.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.leftwing2.roll = MathHelper.cos(eider.age * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                    }
                    else if (eider.isTouchingWater() || entityIn.world.getBlockState(pos).getMaterial() == Material.WATER) {
                        this.getModel().interpolateToPose(StellersEiderRenderer.STELLERS_EIDER_SWIMMING, eider.timer);

                        this.rightleg.pitch = MathHelper.cos(eider.age * 0.2f * globalSpeed + 0) * 0.5f * globalDegree * -1 * 0.5f - 4 * 0.5f;
                        this.leftleg.pitch = MathHelper.cos(eider.age * 0.2f * globalSpeed + 0) * 0.5f * globalDegree * 1 * 0.5f + -4 * 0.5f;
                    }
                }
            }
        }
    }
}
