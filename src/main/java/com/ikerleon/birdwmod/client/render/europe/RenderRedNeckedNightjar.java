package com.ikerleon.birdwmod.client.render.europe;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.model.europe.ModelRedNeckedNightjar;
import com.ikerleon.birdwmod.client.model.europe.ModelRedNeckedNightjarFlying;
import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;
import com.ikerleon.birdwmod.util.Util;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderRedNeckedNightjar extends RenderLiving<EntityRedNeckedNightjar>{

	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/rnnightjar.png");
	public static final ResourceLocation TEXTURE2 = new ResourceLocation(Reference.MODID + ":textures/entity/europe/rnnightjar2.png");
	public static final ResourceLocation TEXTURE3 = new ResourceLocation(Reference.MODID + ":textures/entity/europe/rnnightjar3.png");
	public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/europe/rnnightjar_chick.png");
	
	public RenderRedNeckedNightjar(RenderManager manager) {
		super(manager, new ModelRedNeckedNightjar(), 0.3F);
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
	
	public static class RenderFactory implements IRenderFactory<EntityRedNeckedNightjar> {
		  @Override
	      public Render<? super EntityRedNeckedNightjar> createRenderFor(RenderManager manager) {
	            return new RenderRedNeckedNightjar(manager);
	      }   
	}
}
