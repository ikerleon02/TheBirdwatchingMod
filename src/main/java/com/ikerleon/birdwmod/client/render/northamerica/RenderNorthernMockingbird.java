package com.ikerleon.birdwmod.client.render.northamerica;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.model.northamerica.ModelNorthernMockingbird;
import com.ikerleon.birdwmod.entity.northamerica.EntityNorthernMockingbird;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderNorthernMockingbird extends RenderLiving<EntityNorthernMockingbird> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/northernmockingbird.png");
    public static final ResourceLocation TEXTURE2 = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/northernmockingbird2.png");
    public static final ResourceLocation TEXTURE3 = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/northernmockingbird3.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/northamerica/northernmockingbird_chick.png");
    
    public RenderNorthernMockingbird(RenderManager manager) {
        super(manager, new ModelNorthernMockingbird(), 0.3F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityNorthernMockingbird entity) {
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

    public static class RenderFactory implements IRenderFactory<EntityNorthernMockingbird> {
        @Override
        public Render<? super EntityNorthernMockingbird> createRenderFor(RenderManager manager) {
            return new RenderNorthernMockingbird(manager);
        }
    }
}
