package com.ikerleon.birdwmod.client.render.europe;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.model.europe.ModelRedFlankedBluetail;
import com.ikerleon.birdwmod.client.model.europe.ModelRedFlankedBluetailFlying;
import com.ikerleon.birdwmod.entity.europe.EntityRedFlankedBluetail;
import com.ikerleon.birdwmod.util.Util;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderRedFlankedBluetail extends RenderLiving<EntityRedFlankedBluetail>{
	
	public static final ResourceLocation TEXTUREMALE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/redflankedbluetailmale.png");
	public static final ResourceLocation TEXTUREFEMALE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/redflankedbluetailfemale.png");
	public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/europe/redflankedbluetail_chick.png");
	
	public RenderRedFlankedBluetail(RenderManager manager) {
		super(manager, new ModelRedFlankedBluetail(), 0.15F);
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
}
