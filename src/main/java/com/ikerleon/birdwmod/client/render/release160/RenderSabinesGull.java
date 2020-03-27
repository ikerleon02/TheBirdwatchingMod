package com.ikerleon.birdwmod.client.render.release160;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.release160.EntitySabinesGull;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RenderSabinesGull extends RenderBirdBase<EntitySabinesGull> {

    public static final ModelCMF SABINES_GULL = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/sabines_gull/sabines_gull.bkm"));
    public static final ModelCMF SABINES_GULL_SWIMMING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/sabines_gull/sabines_gull_swimming.bkm"));
    public static final ModelCMF SABINES_GULL_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/sabines_gull/sabines_gull_flying.bkm"));
    public static final ModelCMF SABINES_GULL_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/sabines_gull/sabines_gull_sleeping.bkm"));

    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/release160/sabinesgull.png");
    public static final ResourceLocation TEXTURE2 = new ResourceLocation(Reference.MODID + ":textures/entity/release160/sabinesgull2.png");
    public static final ResourceLocation TEXTURE3 = new ResourceLocation(Reference.MODID + ":textures/entity/release160/sabinesgull3.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/release160/sabinesgull.png");
    public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/release160/sabinesgull_sleeping.png");

    public RenderSabinesGull(RenderManager manager) {
        super(manager, SABINES_GULL, 0.15F);
        SABINES_GULL.setAnimator(SabinesGullAnimator::new);
    }

    @Override
    protected void preRenderCallback(EntitySabinesGull entitylivingbaseIn, float partialTickTime) {
        if(entitylivingbaseIn.isChild()){
            float scaleFactor= 0.2F;
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.4F;
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
            GlStateManager.translate(0,-0.1,0);
        }
    }

    @Override
    public ResourceLocation getBlinkTexture(EntitySabinesGull entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySabinesGull entity) {
        if(entity.isChild()){
            return TEXTURECHICK;
        }
        else {
            return this.getTextureOfVar(entity.getVariant());
        }
    }

    public ResourceLocation getTextureOfVar(int variant) {
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

        private final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
        private final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
        private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
        private final BookwormModelRenderer neck = this.getModel().getPartByName("neckbottom");
        private final BookwormModelRenderer head = this.getModel().getPartByName("head");
        private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
        private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
        private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
        private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");


        public SabinesGullAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();

            BlockPos pos = new BlockPos(entityIn.posX, entityIn.posY - 0.1, entityIn.posZ);

            if ((entityIn instanceof EntitySabinesGull)) {
                EntitySabinesGull gull = (EntitySabinesGull)entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if(gull.isSleeping() && gull.onGround){
                    this.getModel().interpolateToPose(SABINES_GULL_SLEEPING, gull.timer);

                    /*this.body2.rotateAngleX = MathHelper.cos(gull.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + body2.defaultOffsetX;
                    this.head.rotateAngleX = MathHelper.cos(gull.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + head.defaultOffsetX;
                    this.rightwing.rotateAngleX = MathHelper.cos(gull.ticksExisted * 0.17f) * 0.03F * 0 * 0.5F + rightwing.defaultOffsetX;
                    this.leftwing.rotateAngleX = MathHelper.cos(gull.ticksExisted * 0.17f) * 0.03F * 0 * 0.5f + leftwing.defaultOffsetX;*/
                }

                else {
                    /*this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + rightleg.defaultOffsetX;
                    this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + leftleg.defaultOffsetX;
                    this.neck.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + neck.defaultOffsetX;
                    this.body2.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + body2.defaultOffsetX;

                    this.body2.rotateAngleX = MathHelper.cos(gull.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + body2.defaultOffsetX;
                    this.head.rotateAngleX = MathHelper.cos(gull.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + head.defaultOffsetX;
                    this.rightwing.rotateAngleX = MathHelper.cos(gull.ticksExisted * 0.17f) * 0.03F * -1 * 0f + rightwing.defaultOffsetX;
                    this.leftwing.rotateAngleX = MathHelper.cos(gull.ticksExisted * 0.17f) * 0.03F * -1 * 0f + leftwing.defaultOffsetX;*/


                    if ((!gull.onGround && !gull.isInWater() && !gull.isChild()) && entityIn.world.getBlockState(pos).getMaterial() != Material.WATER) {
                        this.getModel().interpolateToPose(SABINES_GULL_FLYING, gull.timer);

                        /*this.rightwing.rotateAngleX = MathHelper.cos(gull.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + rightwing.defaultOffsetX;
                        this.leftwing.rotateAngleX = MathHelper.cos(gull.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + leftwing.defaultOffsetX;
                        this.rightwing.rotateAngleZ = MathHelper.cos(gull.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + rightwing.defaultOffsetZ;
                        this.leftwing.rotateAngleZ = MathHelper.cos(gull.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + leftwing.defaultOffsetZ;
                        this.rightwing2.rotateAngleY = MathHelper.cos(gull.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + rightwing2.defaultOffsetY;
                        this.leftwing2.rotateAngleY = MathHelper.cos(gull.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + leftwing2.defaultOffsetY;*/
                    }
                    else if (gull.isInWater() || entityIn.world.getBlockState(pos).getMaterial() == Material.WATER) {
                        this.getModel().interpolateToPose(SABINES_GULL_SWIMMING, gull.timer);
                    }
                }
            }
        }
    }
}

