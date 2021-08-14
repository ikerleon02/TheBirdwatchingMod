package com.ikerleon.birdwmod.client.render.release160;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.release160.GreatGreyOwlEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class GreatGreyOwlRenderer extends BirdBaseRenderer<GreatGreyOwlEntity> {

    public static final ModelCMF GREAT_GREY_OWL = new ModelCMF(new Identifier("birdwmod", "models/entity/great_grey_owl/great_grey_owl.bkm"));
    public static final ModelCMF GREAT_GREY_OWL_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/great_grey_owl/great_grey_owl_flying.bkm"));
    public static final ModelCMF GREAT_GREY_OWL_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/great_grey_owl/great_grey_owl_sleeping.bkm"));

    public static final Identifier TEXTURE = new Identifier("birdwmod" + ":textures/entity/release160/greatgreyowl.png");
    public static final Identifier TEXTURE2 = new Identifier("birdwmod" + ":textures/entity/release160/greatgreyowl2.png");
    public static final Identifier TEXTURE3 = new Identifier("birdwmod" + ":textures/entity/release160/greatgreyowl3.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/release160/greatgreyowlchick.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/release160/greatgreyowl_sleeping.png");
    public static final Identifier TEXTUREYES = new Identifier("birdwmod" + ":textures/entity/release160/greatgreyowl_eyes.png");
    private final Identifier OWL_RING = new Identifier("birdwmod" + ":textures/entity/rings/owl_ring.png");
    
    public GreatGreyOwlRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, GREAT_GREY_OWL, 0.3F);
        GREAT_GREY_OWL.setAnimator(GreatGreyOwlAnimator::new);
    }

    @Override
    protected void scale(GreatGreyOwlEntity entity, MatrixStack matrices, float tickDelta) {
        if(entity.isBaby()){
            float scaleFactor= 0.4F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.8F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(GreatGreyOwlEntity entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(GreatGreyOwlEntity entity) {
        return OWL_RING;
    }

    @Override
    public Identifier getTexture(GreatGreyOwlEntity entity) {
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
            if ((entityIn instanceof GreatGreyOwlEntity)) {
                GreatGreyOwlEntity owl = (GreatGreyOwlEntity) entityIn;


                if(owl.isSleeping() && owl.isOnGround()){
                    this.getModel().interpolateToPose(GREAT_GREY_OWL_SLEEPING, owl.timer);

                    float speedsleeping = 1.0f;
                    float degreesleeping = 0.6f;

                    this.Head.pitch = MathHelper.cos((owl.age * speedsleeping * 0.15F) + (float) Math.PI) * (degreesleeping * 0.2F) * 1 * 0.5F + -0.6F;
                    this.belly.pitch = MathHelper.cos(2.0F + (owl.age * speedsleeping * 0.2F) + (float) Math.PI) * (degreesleeping * 0.1F) * 1 * 0.5F + -0.5F;
                    this.Wing2L.pitch = MathHelper.cos(1.0F + (owl.age * speedsleeping * 0.2F) + (float) Math.PI) * (degreesleeping * 0.1F) * 1 * 0.5F;
                    this.Wing2R.pitch = MathHelper.cos(1.0F + (owl.age * speedsleeping * 0.2F) + (float) Math.PI) * (degreesleeping * 0.1F) * 1 * 0.5F;
                    this.Wing3L.pitch = MathHelper.cos((owl.age * speedsleeping * 0.2F) + (float) Math.PI) * (degreesleeping * 0.2F) * 1 * 0.5F + 0.35F;
                    this.Wing3R.pitch = MathHelper.cos((owl.age * speedsleeping * 0.2F) + (float) Math.PI) * (degreesleeping * 0.2F) * 1 * 0.5F + 0.35F;
                    this.Tailtop.pitch = MathHelper.cos((owl.age * speedsleeping * 0.2F) + (float) Math.PI) * (degreesleeping * 0.3F) * 1 * 0.5F + -0.2F;
                }

                else {

                    float speedidle = 1f;
                    float degreeidle = 0.3f;

                    this.Head.pitch = MathHelper.cos((owl.age * speedidle * 0.15F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + -0.6F;
                    this.belly.pitch = MathHelper.cos(2.0F + (owl.age * speedidle * 0.2F) + (float) Math.PI) * (degreeidle * 0.1F) * 1 * 0.5F + -0.5F;
                    this.Wing2L.pitch = MathHelper.cos(1.0F + (owl.age * speedidle * 0.2F) + (float) Math.PI) * (degreeidle * 0.1F) * 1 * 0.5F;
                    this.Wing2R.pitch = MathHelper.cos(1.0F + (owl.age * speedidle * 0.2F) + (float) Math.PI) * (degreeidle * 0.1F) * 1 * 0.5F;
                    this.Wing3L.pitch = MathHelper.cos((owl.age * speedidle * 0.2F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + 0.35F;
                    this.Wing3R.pitch = MathHelper.cos((owl.age * speedidle * 0.2F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + 0.35F;
                    this.Tailtop.pitch = MathHelper.cos((owl.age * speedidle * 0.2F) + (float) Math.PI) * (degreeidle * 0.3F) * 1 * 0.5F + -0.2F;

                    this.Body.offsetY = MathHelper.cos((f * speedidle * 0.6F) + (float) Math.PI) * (degreeidle * 0.05F) * f1 * 0.5F;
                    this.ThighR.pitch = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreeidle * 2.5F) * f1 * 0.5F + 1.0F;
                    this.ThighL.pitch = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreeidle * -2.5F) * f1 * 0.5F + 1.0F;
                    this.finger1.pitch = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreeidle * -2.5F) * f1 * 0.5F;
                    this.finger2.pitch = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreeidle * -2.5F) * f1 * 0.5F;
                    this.finger3.pitch = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreeidle * 2.5F) * f1 * 0.5F;
                    this.finger4.pitch = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreeidle * 2.5F) * f1 * 0.5F;

                    if (!owl.isOnGround() && !owl.isTouchingWater() && !owl.isBaby()) {
                        this.getModel().interpolateToPose(GREAT_GREY_OWL_FLYING, owl.timer);

                        float speedflying = 1.3f;
                        float degreeflying = 1.0f;

                        this.Body.offsetY = MathHelper.cos(2.0F + (f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.1F) * f1 * 0.5F;
                        this.WingL.pitch = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.5F) * f1 * 0.5F + -1.4F;
                        this.WingR.pitch = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.5F) * f1 * 0.5F + -1.4F;
                        this.WingL.roll = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 2.0F) * f1 * 0.5F + -1.37F;
                        this.WingR.roll = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * -2.0F) * f1 * 0.5F + 1.37F;
                        this.Wing3L.yaw = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * -1.0F) * f1 * 0.5F;
                        this.Wing3R.yaw = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 1.0F) * f1 * 0.5F;
                        this.Neck.offsetY = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.05F) * f1 * 0.5F;
                        this.ThighR.pitch = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.5F) * f1 * 0.5F + 1.3F;
                        this.ThighL.pitch = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.5F) * f1 * 0.5F + 1.3F;
                        this.Tailtop.pitch = MathHelper.cos(3.0F + (f * speedflying * 0.4F) + (float) Math.PI) * (degreeflying * 0.3F) * f1 * 0.5F + -0.3F;

                    }
                }
            }
        }
    }
}

