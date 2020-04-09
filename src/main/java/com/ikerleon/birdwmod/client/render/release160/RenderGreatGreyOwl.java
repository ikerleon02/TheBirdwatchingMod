package com.ikerleon.birdwmod.client.render.release160;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.release160.EntityGreatGreyOwl;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RenderGreatGreyOwl extends RenderBirdBase<EntityGreatGreyOwl> {

    public static final ModelCMF GREAT_GREY_OWL = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/great_grey_owl/great_grey_owl.bkm"));
    public static final ModelCMF GREAT_GREY_OWL_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/great_grey_owl/great_grey_owl_flying.bkm"));
    public static final ModelCMF GREAT_GREY_OWL_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/great_grey_owl/great_grey_owl_sleeping.bkm"));

    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/release160/greatgreyowl.png");
    public static final ResourceLocation TEXTURE2 = new ResourceLocation(Reference.MODID + ":textures/entity/release160/greatgreyowl2.png");
    public static final ResourceLocation TEXTURE3 = new ResourceLocation(Reference.MODID + ":textures/entity/release160/greatgreyowl3.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/release160/greatgreyowlchick.png");
    public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/release160/greatgreyowl_sleeping.png");
    public static final ResourceLocation TEXTUREYES = new ResourceLocation(Reference.MODID + ":textures/entity/release160/greatgreyowl_eyes.png");
    private final ResourceLocation OWL_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/owl_ring.png");

    public RenderGreatGreyOwl(RenderManager manager) {
        super(manager, GREAT_GREY_OWL, 0.3F);
        GREAT_GREY_OWL.setAnimator(GreatGreyOwlAnimator::new);
    }

    @Override
    protected void preRenderCallback(EntityGreatGreyOwl entitylivingbaseIn, float partialTickTime) {
        if(entitylivingbaseIn.isChild()){
            float scaleFactor= 0.4F;

            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.8F;

            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGreatGreyOwl entity) {
        if(entity.isChild()){
            return TEXTURECHICK;
        }
        else {
            return this.getTextureOfVar(entity.getVariant());
        }
    }

    @Override
    public ResourceLocation getRingTexture(EntityGreatGreyOwl entity) {
        return OWL_RING;
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

    @Override
    public ResourceLocation getBlinkTexture(EntityGreatGreyOwl entity) {
        return TEXTUREBLINK;
    }

    private class GreatGreyOwlAnimator extends CMFAnimator {

        protected final BookwormModelRenderer Head = this.getModel().getPartByName("Head");
        protected final BookwormModelRenderer belly = this.getModel().getPartByName("belly");
        protected final BookwormModelRenderer Wing2L = this.getModel().getPartByName("Wing2L");
        protected final BookwormModelRenderer Wing2R = this.getModel().getPartByName("Wing2R");
        protected final BookwormModelRenderer Wing3L = this.getModel().getPartByName("Wing3L");
        protected final BookwormModelRenderer Wing3R = this.getModel().getPartByName("Wing3R");
        protected final BookwormModelRenderer Tailtop = this.getModel().getPartByName("Tailtop");
        protected final BookwormModelRenderer Body = this.getModel().getPartByName("Body");
        protected final BookwormModelRenderer WingL = this.getModel().getPartByName("WingL");
        protected final BookwormModelRenderer WingR = this.getModel().getPartByName("WingR");
        protected final BookwormModelRenderer Neck = this.getModel().getPartByName("Neck");
        protected final BookwormModelRenderer ThighR = this.getModel().getPartByName("ThighR");
        protected final BookwormModelRenderer ThighL = this.getModel().getPartByName("ThighL");
        protected final BookwormModelRenderer finger1 = this.getModel().getPartByName("finger1");
        protected final BookwormModelRenderer finger2 = this.getModel().getPartByName("finger2");
        protected final BookwormModelRenderer finger3 = this.getModel().getPartByName("finger3");
        protected final BookwormModelRenderer finger4 = this.getModel().getPartByName("finger4");

        public GreatGreyOwlAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entityIn) {
            super.setRotationAngles(f, f1, f2, f3, f4, f5, entityIn);
            this.getModel().reset();
            if ((entityIn instanceof EntityGreatGreyOwl)) {
                EntityGreatGreyOwl owl = (EntityGreatGreyOwl) entityIn;


                if(owl.isSleeping() && owl.onGround){
                    this.getModel().interpolateToPose(GREAT_GREY_OWL_SLEEPING, owl.timer);

                    float speedsleeping = 1.0f;
                    float degreesleeping = 0.6f;

                    this.Head.rotateAngleX = MathHelper.cos((owl.ticksExisted * speedsleeping * 0.15F) + (float) Math.PI) * (degreesleeping * 0.2F) * 1 * 0.5F + -0.6F;
                    this.belly.rotateAngleX = MathHelper.cos(2.0F + (owl.ticksExisted * speedsleeping * 0.2F) + (float) Math.PI) * (degreesleeping * 0.1F) * 1 * 0.5F + -0.5F;
                    this.Wing2L.rotateAngleX = MathHelper.cos(1.0F + (owl.ticksExisted * speedsleeping * 0.2F) + (float) Math.PI) * (degreesleeping * 0.1F) * 1 * 0.5F;
                    this.Wing2R.rotateAngleX = MathHelper.cos(1.0F + (owl.ticksExisted * speedsleeping * 0.2F) + (float) Math.PI) * (degreesleeping * 0.1F) * 1 * 0.5F;
                    this.Wing3L.rotateAngleX = MathHelper.cos((owl.ticksExisted * speedsleeping * 0.2F) + (float) Math.PI) * (degreesleeping * 0.2F) * 1 * 0.5F + 0.35F;
                    this.Wing3R.rotateAngleX = MathHelper.cos((owl.ticksExisted * speedsleeping * 0.2F) + (float) Math.PI) * (degreesleeping * 0.2F) * 1 * 0.5F + 0.35F;
                    this.Tailtop.rotateAngleX = MathHelper.cos((owl.ticksExisted * speedsleeping * 0.2F) + (float) Math.PI) * (degreesleeping * 0.3F) * 1 * 0.5F + -0.2F;
                }

                else {

                    float speedidle = 1f;
                    float degreeidle = 0.3f;

                    this.Head.rotateAngleX = MathHelper.cos((owl.ticksExisted * speedidle * 0.15F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + -0.6F;
                    this.belly.rotateAngleX = MathHelper.cos(2.0F + (owl.ticksExisted * speedidle * 0.2F) + (float) Math.PI) * (degreeidle * 0.1F) * 1 * 0.5F + -0.5F;
                    this.Wing2L.rotateAngleX = MathHelper.cos(1.0F + (owl.ticksExisted * speedidle * 0.2F) + (float) Math.PI) * (degreeidle * 0.1F) * 1 * 0.5F;
                    this.Wing2R.rotateAngleX = MathHelper.cos(1.0F + (owl.ticksExisted * speedidle * 0.2F) + (float) Math.PI) * (degreeidle * 0.1F) * 1 * 0.5F;
                    this.Wing3L.rotateAngleX = MathHelper.cos((owl.ticksExisted * speedidle * 0.2F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + 0.35F;
                    this.Wing3R.rotateAngleX = MathHelper.cos((owl.ticksExisted * speedidle * 0.2F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + 0.35F;
                    this.Tailtop.rotateAngleX = MathHelper.cos((owl.ticksExisted * speedidle * 0.2F) + (float) Math.PI) * (degreeidle * 0.3F) * 1 * 0.5F + -0.2F;

                    this.Body.offsetY = MathHelper.cos((f * speedidle * 0.6F) + (float) Math.PI) * (degreeidle * 0.05F) * f1 * 0.5F;
                    this.ThighR.rotateAngleX = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreeidle * 2.5F) * f1 * 0.5F + 1.0F;
                    this.ThighL.rotateAngleX = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreeidle * -2.5F) * f1 * 0.5F + 1.0F;
                    this.finger1.rotateAngleX = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreeidle * -2.5F) * f1 * 0.5F;
                    this.finger2.rotateAngleX = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreeidle * -2.5F) * f1 * 0.5F;
                    this.finger3.rotateAngleX = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreeidle * 2.5F) * f1 * 0.5F;
                    this.finger4.rotateAngleX = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreeidle * 2.5F) * f1 * 0.5F;

                    if (!owl.onGround && !owl.isInWater() && !owl.isChild()) {
                        this.getModel().interpolateToPose(GREAT_GREY_OWL_FLYING, owl.timer);

                        float speedflying = 1.3f;
                        float degreeflying = 1.0f;

                        this.Body.offsetY = MathHelper.cos(2.0F + (f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.1F) * f1 * 0.5F;
                        this.WingL.rotateAngleX = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.5F) * f1 * 0.5F + -1.4F;
                        this.WingR.rotateAngleX = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.5F) * f1 * 0.5F + -1.4F;
                        this.WingL.rotateAngleZ = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 2.0F) * f1 * 0.5F + -1.37F;
                        this.WingR.rotateAngleZ = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * -2.0F) * f1 * 0.5F + 1.37F;
                        this.Wing3L.rotateAngleY = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * -1.0F) * f1 * 0.5F;
                        this.Wing3R.rotateAngleY = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 1.0F) * f1 * 0.5F;
                        this.Neck.offsetY = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.05F) * f1 * 0.5F;
                        this.ThighR.rotateAngleX = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.5F) * f1 * 0.5F + 1.3F;
                        this.ThighL.rotateAngleX = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.5F) * f1 * 0.5F + 1.3F;
                        this.Tailtop.rotateAngleX = MathHelper.cos(3.0F + (f * speedflying * 0.4F) + (float) Math.PI) * (degreeflying * 0.3F) * f1 * 0.5F + -0.3F;

                    }
                }
            }
        }
    }
}
