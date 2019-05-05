package com.ikerleon.birdwmod.client.render.northamerica;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.model.northamerica.ModelEasternBluebird;
import com.ikerleon.birdwmod.client.model.northamerica.ModelEasternBluebirdFlying;
import com.ikerleon.birdwmod.entity.northamerica.EntityEasternBluebird;
import com.ikerleon.birdwmod.util.Util;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEasternBluebird extends RenderLiving<EntityEasternBluebird>{
	
	public static final ResourceLocation TEXTUREMALE = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/easternbluebirdmale.png");
	public static final ResourceLocation TEXTUREFEMALE = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/easternbluebirdfemale.png");
	public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/easternbluebird_chick.png");
	
	public RenderEasternBluebird(RenderManager manager) {
		super(manager, new ModelEasternBluebird(), 0.2F);
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
}