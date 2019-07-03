package com.ikerleon.birdwmod.client.render;

import com.ikerleon.birdwmod.entity.EntityBird;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class RenderBirdBase <T extends EntityBird> extends RenderLivingBase<T> {

    public RenderBirdBase(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn){
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
        addLayer(new LayerBlinkSleeping(this));
    }

    public ResourceLocation getBlinkTexture(T entity)
    {
        return null;
    }

    @Override
    protected boolean canRenderName(T entity)
    {
        return (super.canRenderName(entity)) && ((entity.getAlwaysRenderNameTagForRender()) || ((entity.hasCustomName()) && (entity == this.renderManager.pointedEntity)));
    }

    @SideOnly(Side.CLIENT)
    public class LayerBlinkSleeping implements LayerRenderer<EntityBird>
    {
        private final RenderBirdBase render;

        public LayerBlinkSleeping(RenderBirdBase re)
        {
            this.render = re;
        }

        public void doRenderLayer(EntityBird e, float f, float f1, float f2, float f3, float f4, float f5, float f6)
        {
            if ((!e.isInvisible() && (e.getBlinking()) || e.isSleeping()) && this.render.getBlinkTexture(e) != null)  {
                GlStateManager.pushMatrix();
                this.render.bindTexture(this.render.getBlinkTexture(e));
                this.render.getMainModel().setModelAttributes(this.render.getMainModel());
                this.render.getMainModel().setRotationAngles(f, f1, f3, f4, f5, f6, e);
                this.render.getMainModel().render(e, f, f1, f2, f3, f4, f6);
                GlStateManager.popMatrix();
            }
        }

        public boolean shouldCombineTextures()
        {
            return true;
        }
    }
}


