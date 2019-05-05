package com.ikerleon.birdwmod.client.render.northamerica;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.model.northamerica.ModelKilldeer;
import com.ikerleon.birdwmod.client.model.northamerica.ModelKilldeerFlying;
import com.ikerleon.birdwmod.entity.northamerica.EntityKilldeer;
import com.ikerleon.birdwmod.util.Util;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderKilldeer extends RenderLiving<EntityKilldeer>{

	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/killdeer.png");
	public static final ResourceLocation TEXTURE2 = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/killdeer2.png");
	public static final ResourceLocation TEXTURE3 = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/killdeer3.png");
	public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/killdeer_chick.png");
	
	public RenderKilldeer(RenderManager manager) {
		super(manager, new ModelKilldeer(), 0.3F);
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
	
	public static class RenderFactory implements IRenderFactory<EntityKilldeer> {
		  @Override
	      public Render<? super EntityKilldeer> createRenderFor(RenderManager manager) {
	            return new RenderKilldeer(manager);
	      }   
	}
}

