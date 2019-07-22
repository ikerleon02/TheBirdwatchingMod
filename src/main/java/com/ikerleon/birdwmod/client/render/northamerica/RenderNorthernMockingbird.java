package com.ikerleon.birdwmod.client.render.northamerica;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.northamerica.EntityNorthernMockingbird;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RenderNorthernMockingbird extends RenderBirdBase<EntityNorthernMockingbird> {

    public static final ModelCMF NORTHERN_MOCKINGBIRD = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/northern_mockingbird/northern_mockingbird.cmf"));
   public static final ModelCMF NORTHERN_MOCKINGBIRD_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/northern_mockingbird/northern_mockingbird_flying.cmf"));
    public static final ModelCMF NORTHERN_MOCKINGBIRD_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/northern_mockingbird/northern_mockingbird_sleeping.cmf"));

    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/northernmockingbird.png");
    public static final ResourceLocation TEXTURE2 = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/northernmockingbird2.png");
    public static final ResourceLocation TEXTURE3 = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/northernmockingbird3.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/northernmockingbird_chick.png");
    public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/northernmockingbird_sleeping.png");

    public RenderNorthernMockingbird(RenderManager manager) {
        super(manager, NORTHERN_MOCKINGBIRD, 0.3F);
        NORTHERN_MOCKINGBIRD.setAnimator(new RenderNorthernMockingbird.NorthernMockingbirdAnimator(NORTHERN_MOCKINGBIRD));
    }

    @Override
    protected void preRenderCallback(EntityNorthernMockingbird entitylivingbaseIn, float partialTickTime) {
        if(entitylivingbaseIn.isChild()){
            float scaleFactor= 0.15F;

            GlStateManager.translate(0F, -0.05, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.3F;

            GlStateManager.translate(0F, -0.05, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
    }

    @Override
    public ResourceLocation getBlinkTexture(EntityNorthernMockingbird entity) {
        return TEXTUREBLINK;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityNorthernMockingbird entity) {
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

    public static class RenderFactory implements IRenderFactory<EntityNorthernMockingbird> {
        @Override
        public Render<? super EntityNorthernMockingbird> createRenderFor(RenderManager manager) {
            return new RenderNorthernMockingbird(manager);
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
            if ((entityIn instanceof EntityNorthernMockingbird)) {
                EntityNorthernMockingbird mockingbird = (EntityNorthernMockingbird) entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;


                if(mockingbird.isSleeping()){
                    this.getModel().interpolateToPose(RenderNorthernMockingbird.NORTHERN_MOCKINGBIRD_SLEEPING, mockingbird.timer);

                    this.body2.rotateAngleX = MathHelper.cos(mockingbird.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + 3.25F * 0.5f;
                    this.head.rotateAngleX = MathHelper.cos(mockingbird.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 0.5F * 0.5f;
                    this.rightwing.rotateAngleX = MathHelper.cos(mockingbird.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.rotateAngleX = MathHelper.cos(mockingbird.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {
                    this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 1f * 0.5f;
                    this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 1f * 0.5f;
                    this.necktop.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + 1.75F * 0.5f;
                    this.body2.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

                    this.body2.rotateAngleX = MathHelper.cos(mockingbird.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + 3.25F * 0.5f;
                    this.head.rotateAngleX = MathHelper.cos(mockingbird.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 0.5F * 0.5f;
                    this.rightwing.rotateAngleX = MathHelper.cos(mockingbird.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.rotateAngleX = MathHelper.cos(mockingbird.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

                    if (!mockingbird.onGround && !mockingbird.isInWater() && !mockingbird.isChild()) {
                        this.getModel().interpolateToPose(RenderNorthernMockingbird.NORTHERN_MOCKINGBIRD_FLYING, mockingbird.timer);

                        this.rightwing.rotateAngleX = MathHelper.cos(mockingbird.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.leftwing.rotateAngleX = MathHelper.cos(mockingbird.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.rightwing.rotateAngleZ = MathHelper.cos(mockingbird.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
                        this.leftwing.rotateAngleZ = MathHelper.cos(mockingbird.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                        this.rightwing2.rotateAngleY = MathHelper.cos(mockingbird.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.leftwing2.rotateAngleY = MathHelper.cos(mockingbird.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                    }
                }
            }
        }
    }
}
