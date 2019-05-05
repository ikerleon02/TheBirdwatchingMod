package com.ikerleon.birdwmod.client.render.europe;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.model.europe.ModelStellersEider;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderStellersEider extends RenderLiving<EntityStellersEider> {

    public static final ResourceLocation TEXTUREMALE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/stellerseidermale.png");
    public static final ResourceLocation TEXTUREFEMALE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/stellerseiderfemale.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/europe/stellerseider_chick.png");

    public RenderStellersEider(RenderManager manager) {
        super(manager, new ModelStellersEider(), 0.15F);
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

    public static class RenderFactory implements IRenderFactory<EntityStellersEider> {
        @Override
        public Render<? super EntityStellersEider> createRenderFor(RenderManager manager) {
            return new RenderStellersEider(manager);
        }
    }
}
