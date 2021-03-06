package com.ikerleon.birdwmod.client.render.europe;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RenderStellersEider extends RenderBirdBase<EntityStellersEider> {

    public static final ModelCMF STELLERS_EIDER = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/stellers_eider/stellers_eider.bkm"));
    public static final ModelCMF STELLERS_EIDER_SWIMMING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/stellers_eider/stellers_eider_swimming.bkm"));
    public static final ModelCMF STELLERS_EIDER_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/stellers_eider/stellers_eider_flying.bkm"));
    public static final ModelCMF STELLERS_EIDER_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/stellers_eider/stellers_eider_sleeping.bkm"));

    public static final ResourceLocation TEXTUREMALE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/stellerseidermale.png");
    public static final ResourceLocation TEXTUREFEMALE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/stellerseiderfemale.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/europe/stellerseider_chick.png");
    public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/europe/stellerseider_sleeping.png");
    private final ResourceLocation EIDER_RING = new ResourceLocation(Reference.MODID + ":textures/entity/rings/eider_ring.png");

    public RenderStellersEider(RenderManager manager) {
        super(manager, STELLERS_EIDER, 0.15F);
        STELLERS_EIDER.setAnimator(StellersEiderAnimator::new);
    }

    @Override
    protected void preRenderCallback(EntityStellersEider entitylivingbaseIn, float partialTickTime) {
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
    public ResourceLocation getBlinkTexture(EntityStellersEider entity)
    {
        return TEXTUREBLINK;
    }

    @Override
    public ResourceLocation getRingTexture(EntityStellersEider entity) {
        return EIDER_RING;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityStellersEider entity) {
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

            BlockPos pos = new BlockPos(entityIn.posX, entityIn.posY - 0.2, entityIn.posZ);

            if ((entityIn instanceof EntityStellersEider)) {
                EntityStellersEider eider = (EntityStellersEider)entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if(eider.isSleeping() && eider.onGround){
                    this.getModel().interpolateToPose(RenderStellersEider.STELLERS_EIDER_SLEEPING, eider.timer);

                    this.body2.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + 0.25F * 0.5f;
                    this.head.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 2.8F * 0.5f;
                    this.rightwing.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                }

                else {
                    this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount - 4f * 0.5f;
                    this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount - 4f * 0.5f;
                    this.neck.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + 5.25F * 0.5f;
                    this.body2.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

                    this.body2.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + 0.25F * 0.5f;
                    this.head.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 2.8F * 0.5f;
                    this.rightwing.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
                    this.leftwing.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

                    if ((!eider.onGround && !eider.isInWater() && !eider.isChild()) && entityIn.world.getBlockState(pos).getMaterial() != Material.WATER) {
                        this.getModel().interpolateToPose(RenderStellersEider.STELLERS_EIDER_FLYING, eider.timer);

                        this.rightwing.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + 2.5F * 0.5f;
                        this.leftwing.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + 2.5F * 0.5f;
                        this.rightwing.rotateAngleY = MathHelper.cos(eider.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f - 3F * 0.5f;
                        this.leftwing.rotateAngleY = MathHelper.cos(eider.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 3F * 0.5f;
                        this.rightwing2.rotateAngleZ = MathHelper.cos(eider.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                        this.leftwing2.rotateAngleZ = MathHelper.cos(eider.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                    } else if (eider.isInWater() || entityIn.world.getBlockState(pos).getMaterial() == Material.WATER) {
                        this.getModel().interpolateToPose(RenderStellersEider.STELLERS_EIDER_SWIMMING, eider.timer);

                        this.rightleg.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.2f * globalSpeed + 0) * 0.5f * globalDegree * -1 * 0.5f - 4 * 0.5f;
                        this.leftleg.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.2f * globalSpeed + 0) * 0.5f * globalDegree * 1 * 0.5f + -4 * 0.5f;
                    }
                }
            }
        }
    }
}
