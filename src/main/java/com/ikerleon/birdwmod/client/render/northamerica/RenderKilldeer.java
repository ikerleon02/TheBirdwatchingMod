package com.ikerleon.birdwmod.client.render.northamerica;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.render.RenderBirdBase;
import com.ikerleon.birdwmod.entity.northamerica.EntityGreenHeron;
import com.ikerleon.birdwmod.entity.northamerica.EntityKilldeer;

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

public class RenderKilldeer extends RenderBirdBase<EntityKilldeer> {

	public static final ModelCMF KILLDEER = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/killdeer/killdeer.cmf"));
	public static final ModelCMF KILLDEER_FLYING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/killdeer/killdeer_flying.cmf"));
	public static final ModelCMF KILLDEER_SLEEPING = new ModelCMF(new ResourceLocation(Reference.MODID, "models/entity/killdeer/killdeer_sleeping.cmf"));

	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/killdeer.png");
	public static final ResourceLocation TEXTURE2 = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/killdeer2.png");
	public static final ResourceLocation TEXTURE3 = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/killdeer3.png");
	public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/killdeer_chick.png");
	public static final ResourceLocation TEXTUREBLINK = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/killdeer_sleeping.png");

	public RenderKilldeer(RenderManager manager) {
		super(manager, KILLDEER, 0.3F);
		KILLDEER.setAnimator(new RenderKilldeer.KilldeerAnimator(KILLDEER));
	}

	@Override
	protected void preRenderCallback(EntityKilldeer entitylivingbaseIn, float partialTickTime) {
		if(entitylivingbaseIn.isChild()){
			float scaleFactor= 0.2F;

			GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
		}
		else {
			float scaleFactor = 0.35F;

			GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
		}
	}

	@Override
	public ResourceLocation getBlinkTexture(EntityKilldeer entity)
	{
		return TEXTUREBLINK;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityKilldeer entity) {
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

	private class KilldeerAnimator extends CMFAnimator {

		private final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
		private final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
		private final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
		private final BookwormModelRenderer necktop = this.getModel().getPartByName("necktop");
		private final BookwormModelRenderer head = this.getModel().getPartByName("head");
		private final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
		private final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");
		private final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
		private final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");


		public KilldeerAnimator(ModelCMF model) {
			super(model);
		}

		@Override
		public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
			super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
			this.getModel().reset();
			if ((entityIn instanceof EntityKilldeer)) {
				EntityKilldeer killdeer = (EntityKilldeer) entityIn;

				float globalSpeed = 1.5f;
				float globalDegree = 1.25F;

				if(killdeer.isSleeping()){
					this.getModel().interpolateToPose(RenderKilldeer.KILLDEER_SLEEPING, killdeer.timer);

					this.body2.rotateAngleX = MathHelper.cos(killdeer.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + 2.75F * 0.5f;
					this.head.rotateAngleX = MathHelper.cos(killdeer.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1F * 0.5f;
					this.rightwing.rotateAngleX = MathHelper.cos(killdeer.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
					this.leftwing.rotateAngleX = MathHelper.cos(killdeer.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
				}

				else {
					this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 0.85f * 0.5f;
					this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 0.85f * 0.5f;
					this.necktop.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + 2.5F * 0.5f;
					this.body2.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

					this.body2.rotateAngleX = MathHelper.cos(killdeer.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + 2.75F * 0.5f;
					this.head.rotateAngleX = MathHelper.cos(killdeer.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1F * 0.5f;
					this.rightwing.rotateAngleX = MathHelper.cos(killdeer.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
					this.leftwing.rotateAngleX = MathHelper.cos(killdeer.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

					if (!killdeer.onGround && !killdeer.isInWater() && !killdeer.isChild()) {
						this.getModel().interpolateToPose(RenderKilldeer.KILLDEER_FLYING, killdeer.timer);

						this.rightwing.rotateAngleX = MathHelper.cos(killdeer.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
						this.leftwing.rotateAngleX = MathHelper.cos(killdeer.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
						this.rightwing.rotateAngleZ = MathHelper.cos(killdeer.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
						this.leftwing.rotateAngleZ = MathHelper.cos(killdeer.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
						this.rightwing2.rotateAngleY = MathHelper.cos(killdeer.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
						this.leftwing2.rotateAngleY = MathHelper.cos(killdeer.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
					}
				}
			}
		}
	}
}

