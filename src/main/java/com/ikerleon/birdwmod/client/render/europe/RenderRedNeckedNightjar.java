package com.ikerleon.birdwmod.client.render.europe;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RenderRedNeckedNightjar extends RenderBirdBase<EntityRedNeckedNightjar> {

	public static final ModelCMF RED_NECKED_NIGHTJAR = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/red_necked_nightjar/red_necked_nightjar.cmf"));
	public static final ModelCMF RED_NECKED_NIGHTJAR_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/red_necked_nightjar/red_necked_nightjar_flying.cmf"));
	public static final ModelCMF RED_NECKED_NIGHTJAR_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/red_necked_nightjar/red_necked_nightjar_sleeping.cmf"));


	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/rnnightjar.png");
	public static final ResourceLocation TEXTURE2 = new ResourceLocation(Reference.MODID + ":textures/entity/europe/rnnightjar2.png");
	public static final ResourceLocation TEXTURE3 = new ResourceLocation(Reference.MODID + ":textures/entity/europe/rnnightjar3.png");
	public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/europe/rnnightjar_chick.png");
	public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/europe/rnnightjar_sleeping.png");

	public RenderRedNeckedNightjar(RenderManager manager) {
		super(manager, RED_NECKED_NIGHTJAR, 0.3F);
		RED_NECKED_NIGHTJAR.setAnimator(RedNeckedNightjarAnimator::new);
	}

	@Override
	protected void preRenderCallback(EntityRedNeckedNightjar entitylivingbaseIn, float partialTickTime) {
		if(entitylivingbaseIn.isChild()){
			float scaleFactor= 0.2F;

			GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
		}
		else {
			float scaleFactor = 0.4F;

			GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
		}
	}

	@Override
	public ResourceLocation getBlinkTexture(EntityRedNeckedNightjar entity)
	{
		return TEXTUREBLINK;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityRedNeckedNightjar entity) {
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

	private class RedNeckedNightjarAnimator extends CMFAnimator {

		private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
		private final BookwormModelRenderer head = this.getModel().getPartByName("head");
		private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
		private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
		private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
		private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");


		public RedNeckedNightjarAnimator(ModelCMF model) {
			super(model);
		}

		@Override
		public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
			super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
			this.getModel().reset();

			if ((entityIn instanceof EntityRedNeckedNightjar)) {
				EntityRedNeckedNightjar nightjar = (EntityRedNeckedNightjar)entityIn;

				float globalSpeed = 1.5f;
				float globalDegree = 1.25F;

				if(nightjar.isSleeping() && nightjar.onGround){
					this.getModel().interpolateToPose(RenderRedNeckedNightjar.RED_NECKED_NIGHTJAR_SLEEPING, nightjar.timer);

					this.body2.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
					this.head.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
					this.rightwing.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
					this.leftwing.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
				}

				else {
					this.body2.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
					this.head.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
					this.rightwing.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
					this.leftwing.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

					if (!nightjar.onGround && !nightjar.isInWater() && !nightjar.isChild()) {
						this.getModel().interpolateToPose(RenderRedNeckedNightjar.RED_NECKED_NIGHTJAR_FLYING, nightjar.timer);

						this.rightwing.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
						this.leftwing.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
						this.rightwing.rotateAngleZ = MathHelper.cos(nightjar.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
						this.leftwing.rotateAngleZ = MathHelper.cos(nightjar.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
						this.rightwing2.rotateAngleY = MathHelper.cos(nightjar.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
						this.leftwing2.rotateAngleY = MathHelper.cos(nightjar.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
					}
				}
			}
		}
	}
}
