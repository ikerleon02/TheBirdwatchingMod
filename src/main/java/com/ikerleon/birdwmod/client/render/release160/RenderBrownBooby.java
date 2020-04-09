package com.ikerleon.birdwmod.client.render.release160;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.release160.EntityBrownBooby;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RenderBrownBooby extends RenderBirdBase<EntityBrownBooby> {

    public static final ModelCMF BROWN_BOOBY = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/brown_booby/brown_booby.bkm"));
    public static final ModelCMF BROWN_BOOBY_SWIMMING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/brown_booby/brown_booby_swimming.bkm"));
    public static final ModelCMF BROWN_BOOBY_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/brown_booby/brown_booby_flying.bkm"));
    public static final ModelCMF BROWN_BOOBY_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/brown_booby/brown_booby_sleeping.bkm"));

    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/release160/brownbooby.png");
    public static final ResourceLocation TEXTURE2 = new ResourceLocation(Reference.MODID + ":textures/entity/release160/brownbooby2.png");
    public static final ResourceLocation TEXTURE3 = new ResourceLocation(Reference.MODID + ":textures/entity/release160/brownbooby3.png");
    public static final ResourceLocation TEXTURE4 = new ResourceLocation(Reference.MODID + ":textures/entity/release160/brownbooby4.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/release160/brownboobychick.png");
    public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/release160/brownbooby_sleeping.png");
    private final ResourceLocation BOOBY_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/booby_ring.png");

    public RenderBrownBooby(RenderManager manager) {
        super(manager, BROWN_BOOBY, 0.15F);
        BROWN_BOOBY.setAnimator(BrownBoobyAnimator::new);
    }

    @Override
    protected void preRenderCallback(EntityBrownBooby entitylivingbaseIn, float partialTickTime) {
        if(entitylivingbaseIn.isChild()){
            float scaleFactor= 0.3F;
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        else {
            float scaleFactor = 0.6F;
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
        }
    }

    @Override
    public ResourceLocation getBlinkTexture(EntityBrownBooby entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public ResourceLocation getRingTexture(EntityBrownBooby entity) {
        return BOOBY_RING;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBrownBooby entity) {
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
            case 3:
                return TEXTURE4;
        }
    }

    private class BrownBoobyAnimator extends CMFAnimator {

        protected final BookwormModelRenderer neck = this.getModel().getPartByName("neck");
        protected final BookwormModelRenderer head = this.getModel().getPartByName("head");
        protected final BookwormModelRenderer belly2 = this.getModel().getPartByName("belly2");
        protected final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
        protected final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
        protected final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");
        protected final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
        protected final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
        protected final BookwormModelRenderer body = this.getModel().getPartByName("body");
        protected final BookwormModelRenderer leftfoot = this.getModel().getPartByName("leftfoot");
        protected final BookwormModelRenderer rightfoot = this.getModel().getPartByName("rightfoot");
        protected final BookwormModelRenderer neck2 = this.getModel().getPartByName("neck2");
        protected final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
        protected final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");

        public BrownBoobyAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
            super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            this.getModel().reset();

            BlockPos pos = new BlockPos(entity.posX, entity.posY - 0.2, entity.posZ);

            if ((entity instanceof EntityBrownBooby)) {
                EntityBrownBooby booby = (EntityBrownBooby)entity;

                if(booby.isSleeping() && booby.onGround){
                    this.getModel().interpolateToPose(BROWN_BOOBY_SLEEPING, booby.timer);

                    float speedsleeping = 1.0f;
                    float degreesleeping = 0.5f;

                    this.head.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedsleeping * 0.1F) + (float) Math.PI) * (degreesleeping * -0.2F) * 1 * 0.5F + 2.1F;
                    this.belly2.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedsleeping * 0.1F) + (float) Math.PI) * (degreesleeping * 0.2F) * 1 * 0.5F + 1.25F;
                    this.rightwing2.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedsleeping * 0.1F) + (float) Math.PI) * (degreesleeping * 0.2F) * 1 * 0.5F + 0.35F;
                    this.leftwing2.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedsleeping * 0.1F) + (float) Math.PI) * (degreesleeping * 0.2F) * 1 * 0.5F + 0.35F;
                }

                else {

                    float speedidle = 1.0f;
                    float degreeidle = 0.3f;
                    float degreewalk = 1.0f;

                    this.neck.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedidle * 0.1F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + 1.0F;
                    this.head.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedidle * 0.1F) + (float) Math.PI) * (degreeidle * -0.2F) * 1 * 0.5F + 1.85F;
                    this.belly2.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedidle * 0.1F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + 1.25F;
                    this.body2.rotateAngleX = MathHelper.cos(2.0F + (booby.ticksExisted * speedidle * 0.1F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + -0.2F;
                    this.rightwing2.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedidle * 0.1F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + 0.25F;
                    this.leftwing2.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedidle * 0.1F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + 0.25F;

                    this.body.rotateAngleZ = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * 0.3F) * f1 * 0.5F;
                    this.leftleg.rotateAngleX = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * 2.0F) * f1 * 0.5F + 0.35F;
                    this.leftleg.rotateAngleZ = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * -0.3F) * f1 * 0.5F;
                    this.rightleg.rotateAngleX = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * -2.0F) * f1 * 0.5F + 0.35F;
                    this.rightleg.rotateAngleZ = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * -0.3F) * f1 * 0.5F;
                    this.leftfoot.rotateAngleX = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * -2.0F) * f1 * 0.5F + 0.2F;
                    this.rightfoot.rotateAngleX = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * 2.0F) * f1 * 0.5F + 0.2F;
                    this.neck2.rotateAngleY = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * 0.2F) * f1 * 0.5F;
                    this.leftfoot.rotateAngleZ = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * 0.3F) * f1 * 0.5F;
                    this.rightfoot.rotateAngleZ = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * 0.3F) * f1 * 0.5F;

                    if ((!booby.onGround && !booby.isInWater() && !booby.isChild()) && entity.world.getBlockState(pos).getMaterial() != Material.WATER) {
                        this.getModel().interpolateToPose(BROWN_BOOBY_FLYING, booby.timer);

                        float speedflying = 1.6f;
                        float degreeflying = 0.6f;
                        this.body.offsetY = MathHelper.cos(2.0F + (f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.1F) * f1 * 0.5F;
                        this.rightwing.rotateAngleZ = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * -1.5F) * f1 * 0.5F + 1.5F;
                        this.leftwing.rotateAngleZ = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 1.5F) * f1 * 0.5F + -1.5F;
                        this.rightwing2.rotateAngleY = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 1.5F) * f1 * 0.5F;
                        this.leftwing2.rotateAngleY = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * -1.5F) * f1 * 0.5F;
                        this.body2.rotateAngleX = MathHelper.cos(2.0F + (f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.1F) * f1 * 0.5F + -0.3F;

                    }
                    else if (booby.isInWater() || entity.world.getBlockState(pos).getMaterial() == Material.WATER) {
                        this.getModel().interpolateToPose(BROWN_BOOBY_SWIMMING, booby.timer);

                        float speedswimming = 1.0f;
                        float degreeswimming = 0.5f;

                        this.neck.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedswimming * 0.1F) + (float) Math.PI) * (degreeswimming * 0.2F) * 1 * 0.5F + 0.85F;
                        this.head.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedswimming * 0.1F) + (float) Math.PI) * (degreeswimming * -0.2F) * 1 * 0.5F + 1.7F;
                        this.belly2.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedswimming * 0.1F) + (float) Math.PI) * (degreeswimming * 0.2F) * 1 * 0.5F + 1.25F;
                        this.body2.rotateAngleX = MathHelper.cos(2.0F + (booby.ticksExisted * speedswimming * 0.1F) + (float) Math.PI) * (degreeswimming * 0.2F) * 1 * 0.5F + -0.2F;
                        this.rightwing2.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedswimming * 0.1F) + (float) Math.PI) * (degreeswimming * 0.2F) * 1 * 0.5F + 0.1F;
                        this.leftwing2.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedswimming * 0.1F) + (float) Math.PI) * (degreeswimming * 0.2F) * 1 * 0.5F + 0.1F;
                        this.leftleg.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedswimming * 0.4F) + (float) Math.PI) * (degreeswimming * 1.5F) * 1 * 0.5F + 1.25F;
                        this.rightleg.rotateAngleX = MathHelper.cos((booby.ticksExisted * speedswimming * 0.4F) + (float) Math.PI) * (degreeswimming * -1.5F) * 1 * 0.5F + 1.25F;
                    }
                }
            }
        }
    }
}
