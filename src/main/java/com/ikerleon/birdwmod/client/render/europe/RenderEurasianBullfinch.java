package com.ikerleon.birdwmod.client.render.europe;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.europe.EntityEurasianBullfinch;
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

public class RenderEurasianBullfinch extends RenderBirdBase<EntityEurasianBullfinch> {

    public static final ModelCMF EURASIAN_BULLFINCH = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/eurasian_bullfinch/eurasian_bullfinch.bkm"));
    public static final ModelCMF EURASIAN_BULLFINCH_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/eurasian_bullfinch/eurasian_bullfinch_flying.bkm"));
    public static final ModelCMF EURASIAN_BULLFINCH_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/eurasian_bullfinch/eurasian_bullfinch_sleeping.bkm"));

    public static final ResourceLocation TEXTUREMALE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/eurasianbullfinchmale.png");
    public static final ResourceLocation TEXTUREFEMALE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/eurasianbullfinchfemale.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/europe/eurasianbullfinch_chick.png");
    public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/europe/eurasianbullfinch_sleeping.png");
    private static final ResourceLocation PASSERINE_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/passerine_ring.png");

    public RenderEurasianBullfinch(RenderManager manager) {
        super(manager, EURASIAN_BULLFINCH, 0.15F);
        EURASIAN_BULLFINCH.setAnimator(EurasianBullfinchAnimator::new);
    }

    @Override
    protected void preRenderCallback(EntityEurasianBullfinch entitylivingbaseIn, float partialTickTime) {
        if(entitylivingbaseIn.isChild()){
            float scaleFactor= 0.15F;

            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.3F;

            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
    }

    @Override
    public ResourceLocation getBlinkTexture(EntityEurasianBullfinch entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public ResourceLocation getRingTexture(EntityEurasianBullfinch entity) {
        return PASSERINE_RING;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityEurasianBullfinch entity) {
        if(entity.isChild()){
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

    private class EurasianBullfinchAnimator extends CMFAnimator {

        private final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
        private final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
        private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
        private final BookwormModelRenderer head = this.getModel().getPartByName("head");
        private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
        private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
        private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
        private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");


        public EurasianBullfinchAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();

            if ((entityIn instanceof EntityEurasianBullfinch)) {
                EntityEurasianBullfinch bullfinch = (EntityEurasianBullfinch)entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if(bullfinch.isSleeping() && bullfinch.onGround){
                    this.getModel().interpolateToPose(RenderEurasianBullfinch.EURASIAN_BULLFINCH_SLEEPING, bullfinch.timer);

                    this.body2.rotateAngleX = MathHelper.cos(bullfinch.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.head.rotateAngleX = MathHelper.cos(bullfinch.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
                    this.rightwing.rotateAngleX = MathHelper.cos(bullfinch.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.rotateAngleX = MathHelper.cos(bullfinch.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {

                    this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 0.75f * 0.5f;
                    this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 0.75f * 0.5f;
                    this.head.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount - 0.65F * 0.5f;
                    this.body2.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

                    this.body2.rotateAngleX = MathHelper.cos(bullfinch.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
                    this.head.rotateAngleX = MathHelper.cos(bullfinch.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
                    this.rightwing.rotateAngleX = MathHelper.cos(bullfinch.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.rotateAngleX = MathHelper.cos(bullfinch.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

                    if (!bullfinch.onGround && !bullfinch.isInWater() && !bullfinch.isChild()) {
                        this.getModel().interpolateToPose(RenderEurasianBullfinch.EURASIAN_BULLFINCH_FLYING, bullfinch.timer);

                        this.rightwing.rotateAngleX = MathHelper.cos(bullfinch.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.leftwing.rotateAngleX = MathHelper.cos(bullfinch.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                        this.rightwing.rotateAngleZ = MathHelper.cos(bullfinch.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
                        this.leftwing.rotateAngleZ = MathHelper.cos(bullfinch.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                        this.rightwing2.rotateAngleY = MathHelper.cos(bullfinch.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.leftwing2.rotateAngleY = MathHelper.cos(bullfinch.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                    }
                }
            }
        }
    }
}
