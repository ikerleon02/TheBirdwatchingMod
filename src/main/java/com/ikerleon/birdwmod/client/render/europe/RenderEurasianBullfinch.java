package com.ikerleon.birdwmod.client.render.europe;

import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.client.model.europe.ModelEurasianBullfinch;
import com.ikerleon.birdwmod.entity.europe.EntityEurasianBullfinch;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEurasianBullfinch extends RenderLiving<EntityEurasianBullfinch> {

    public static final ResourceLocation TEXTUREMALE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/eurasianbullfinchmale.png");
    public static final ResourceLocation TEXTUREFEMALE = new ResourceLocation(Reference.MODID + ":textures/entity/europe/eurasianbullfinchfemale.png");
    public static final ResourceLocation TEXTURECHICK = new ResourceLocation(Reference.MODID + ":textures/entity/europe/eurasianbullfinch_chick.png");

    public RenderEurasianBullfinch(RenderManager manager) {
        super(manager, new ModelEurasianBullfinch(), 0.15F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityEurasianBullfinch entity) {
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

    public static class RenderFactory implements IRenderFactory<EntityEurasianBullfinch> {
        @Override
        public Render<? super EntityEurasianBullfinch> createRenderFor(RenderManager manager) {
            return new RenderEurasianBullfinch(manager);
        }
    }
}
