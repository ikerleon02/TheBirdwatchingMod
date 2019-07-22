package com.ikerleon.birdwmod.client.render.northamerica;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.entity.northamerica.EntityEasternBluebird;

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

public class RenderEasternBluebird extends RenderBirdBase<EntityEasternBluebird> {

	public static final ModelCMF EASTERN_BLUEBIRD = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/eastern_bluebird/eastern_bluebird.cmf"));
	public static final ModelCMF EASTERN_BLUEBIRD_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/eastern_bluebird/eastern_bluebird_flying.cmf"));
	public static final ModelCMF EASTERN_BLUEBIRD_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/eastern_bluebird/eastern_bluebird_sleeping.cmf"));

	public static final ResourceLocation TEXTUREMALE = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/easternbluebirdmale.png");
	public static final ResourceLocation TEXTUREFEMALE = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/easternbluebirdfemale.png");
	public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/easternbluebird_chick.png");
	public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/easternbluebird_sleeping.png");

	public RenderEasternBluebird(RenderManager manager) {
		super(manager, EASTERN_BLUEBIRD, 0.2F);
		EASTERN_BLUEBIRD.setAnimator(new RenderEasternBluebird.EasternBluebirdAnimator(EASTERN_BLUEBIRD));
	}

	@Override
	protected void preRenderCallback(EntityEasternBluebird entitylivingbaseIn, float partialTickTime) {
		if(entitylivingbaseIn.isChild()){
			float scaleFactor= 0.175F;

			GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
		}
		else {
			float scaleFactor = 0.35F;

			GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
		}
	}

	@Override
	public ResourceLocation getBlinkTexture(EntityEasternBluebird entity)
	{
		return TEXTUREBLINK;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityEasternBluebird entity) {
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
	
	public static class RenderFactory implements IRenderFactory<EntityEasternBluebird> {
		  @Override
	      public Render<? super EntityEasternBluebird> createRenderFor(RenderManager manager) {
	            return new RenderEasternBluebird(manager);
	      }   
	}

	private class EasternBluebirdAnimator extends CMFAnimator {

		private final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
		private final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
		private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
		private final BookwormModelRenderer shape13 = this.getModel().getPartByName("shape13");
		private final BookwormModelRenderer head = this.getModel().getPartByName("head");
		private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
		private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
		private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
		private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");


		public EasternBluebirdAnimator(ModelCMF model) {
			super(model);
		}

		@Override
		public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
			super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
			this.getModel().reset();
			if ((entityIn instanceof EntityEasternBluebird)) {
				EntityEasternBluebird bluebird = (EntityEasternBluebird) entityIn;

				float globalSpeed = 1.5f;
				float globalDegree = 1.25F;

				if (bluebird.isSleeping()) {
					this.getModel().interpolateToPose(RenderEasternBluebird.EASTERN_BLUEBIRD_SLEEPING, bluebird.timer);

					this.body2.rotateAngleX = MathHelper.cos(bluebird.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
					this.head.rotateAngleX = MathHelper.cos(bluebird.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1.25F * 0.5f;
					this.rightwing.rotateAngleX = MathHelper.cos(bluebird.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
					this.leftwing.rotateAngleX = MathHelper.cos(bluebird.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
				}
				else {

					this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 0f * 0.5f;
					this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 0f * 0.5f;
					this.shape13.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount - 0.7F * 0.5f;
					this.body2.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

					this.body2.rotateAngleX = MathHelper.cos(bluebird.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
					this.head.rotateAngleX = MathHelper.cos(bluebird.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1.25F * 0.5f;
					this.rightwing.rotateAngleX = MathHelper.cos(bluebird.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
					this.leftwing.rotateAngleX = MathHelper.cos(bluebird.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

					if (!bluebird.onGround && !bluebird.isInWater() && !bluebird.isChild()) {
						this.getModel().interpolateToPose(RenderEasternBluebird.EASTERN_BLUEBIRD_FLYING, bluebird.timer);

						this.rightwing.rotateAngleX = MathHelper.cos(bluebird.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
						this.leftwing.rotateAngleX = MathHelper.cos(bluebird.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
						this.rightwing.rotateAngleZ = MathHelper.cos(bluebird.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
						this.leftwing.rotateAngleZ = MathHelper.cos(bluebird.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
						this.rightwing2.rotateAngleY = MathHelper.cos(bluebird.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
						this.leftwing2.rotateAngleY = MathHelper.cos(bluebird.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
					}
				}
			}
		}
	}
}