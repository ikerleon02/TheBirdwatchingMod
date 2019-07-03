package com.ikerleon.birdwmod.client.render.europe;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.europe.EntityEurasianBullfinch;
import com.ikerleon.birdwmod.entity.europe.EntityRedFlankedBluetail;

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

public class RenderRedFlankedBluetail extends RenderBirdBase<EntityRedFlankedBluetail> {

	public static final ModelCMF RED_FLANKED_BLUETAIL = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/red_flanked_bluetail/red_flanked_bluetail.cmf"));
	public static final ModelCMF RED_FLANKED_BLUETAIL_DEFAULT = RED_FLANKED_BLUETAIL;
	public static final ModelCMF RED_FLANKED_BLUETAIL_SPEAKING1 = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/red_flanked_bluetail/red_flanked_bluetail_speaking1.cmf"));
	public static final ModelCMF RED_FLANKED_BLUETAIL_SPEAKING2 = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/red_flanked_bluetail/red_flanked_bluetail_speaking2.cmf"));
	public static final ModelCMF RED_FLANKED_BLUETAIL_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/red_flanked_bluetail/red_flanked_bluetail_flying.cmf"));
	public static final ModelCMF RED_FLANKED_BLUETAIL_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/red_flanked_bluetail/red_flanked_bluetail_sleeping.cmf"));

	public static final ResourceLocation TEXTUREMALE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/redflankedbluetailmale.png");
	public static final ResourceLocation TEXTUREFEMALE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/redflankedbluetailfemale.png");
	public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/europe/redflankedbluetail_chick.png");
	public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/europe/redflankedbluetail_sleeping.png");

	public RenderRedFlankedBluetail(RenderManager manager) {
		super(manager, RED_FLANKED_BLUETAIL, 0.15F);
		RED_FLANKED_BLUETAIL.setAnimator(new RenderRedFlankedBluetail.RedFlankedBluetailAnimator(RED_FLANKED_BLUETAIL));
	}

	@Override
	protected void preRenderCallback(EntityRedFlankedBluetail entitylivingbaseIn, float partialTickTime) {
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
	public ResourceLocation getBlinkTexture(EntityRedFlankedBluetail entity)
	{
		return TEXTUREBLINK;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityRedFlankedBluetail entity) {
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
	
	public static class RenderFactory implements IRenderFactory<EntityRedFlankedBluetail> {
		  @Override
	      public Render<? super EntityRedFlankedBluetail> createRenderFor(RenderManager manager) {
	            return new RenderRedFlankedBluetail(manager);
	      }   
	}

	private class RedFlankedBluetailAnimator extends CMFAnimator {

		private final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
		private final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
		private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
		private final BookwormModelRenderer head = this.getModel().getPartByName("head");
		private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
		private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
		private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
		private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");


		public RedFlankedBluetailAnimator(ModelCMF model) {
			super(model);
		}

		@Override
		public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
			super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
			this.getModel().reset();

			if ((entityIn instanceof EntityRedFlankedBluetail)) {
				EntityRedFlankedBluetail bluetail = (EntityRedFlankedBluetail)entityIn;

				float globalSpeed = 1.5f;
				float globalDegree = 1.25F;

				if(bluetail.isSleeping()){
					this.getModel().interpolateToPose(RenderRedFlankedBluetail.RED_FLANKED_BLUETAIL_SLEEPING, bluetail.timer);

					this.body2.rotateAngleX = MathHelper.cos(bluetail.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
					this.head.rotateAngleX = MathHelper.cos(bluetail.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
					this.rightwing.rotateAngleX = MathHelper.cos(bluetail.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
					this.leftwing.rotateAngleX = MathHelper.cos(bluetail.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
				}

				else {
					this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 0.75f * 0.5f;
					this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 0.75f * 0.5f;
					this.head.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount - 0.65F * 0.5f;
					this.body2.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

					this.body2.rotateAngleX = MathHelper.cos(bluetail.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
					this.head.rotateAngleX = MathHelper.cos(bluetail.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
					this.rightwing.rotateAngleX = MathHelper.cos(bluetail.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
					this.leftwing.rotateAngleX = MathHelper.cos(bluetail.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

					if (!bluetail.onGround && !bluetail.isInWater() && !bluetail.isChild()) {
						this.getModel().interpolateToPose(RenderRedFlankedBluetail.RED_FLANKED_BLUETAIL_FLYING, bluetail.timer);

						this.rightwing.rotateAngleX = MathHelper.cos(bluetail.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
						this.leftwing.rotateAngleX = MathHelper.cos(bluetail.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
						this.rightwing.rotateAngleZ = MathHelper.cos(bluetail.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
						this.leftwing.rotateAngleZ = MathHelper.cos(bluetail.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
						this.rightwing2.rotateAngleY = MathHelper.cos(bluetail.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
						this.leftwing2.rotateAngleY = MathHelper.cos(bluetail.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
					}
				}
			}
		}
	}
}
