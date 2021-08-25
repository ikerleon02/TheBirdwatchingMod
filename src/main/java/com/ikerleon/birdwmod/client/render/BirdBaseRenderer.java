package com.ikerleon.birdwmod.client.render;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.client.model.entity.BirdBaseModel;
import com.ikerleon.birdwmod.entity.BirdEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.provider.GeoModelProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;

public class BirdBaseRenderer extends GeoEntityRenderer< BirdEntity> {

    public BirdBaseRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new BirdBaseModel());
        this.layerRenderers.add(new BlinkSleepingFeature(this));
        this.layerRenderers.add( new RingFeature(this));
    }

    public Identifier getBlinkTexture(BirdEntity entity)
    {
        return new Identifier(Main.ModID, "textures/entity/"+entity.getPath()+"/" + entity.getPath() + "_sleeping.png");
    }

    public Identifier getRingTexture(BirdEntity entity)
    {
        return new Identifier(Main.ModID, "textures/entity/rings/"+entity.getPath()+"_ring.png");
    }

    @Override
    public void render(BirdEntity entity, float entityYaw, float partialTicks, MatrixStack stack, VertexConsumerProvider bufferIn, int packedLightIn) {
        stack.scale(entity.getScaleFactor(),entity.getScaleFactor(),entity.getScaleFactor());
        if(entity.isBaby()){
            stack.scale(0.5F,0.5F,0.5F);
        }
        super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
    }

    @Environment(EnvType.CLIENT)
    public class BlinkSleepingFeature extends GeoLayerRenderer<BirdEntity> {
        private final BirdBaseRenderer render;

        public BlinkSleepingFeature(BirdBaseRenderer ctx) {
            super(ctx);
            this.render = ctx;
        }

        @Override
        public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, BirdEntity birdEntity, float limbAngle, float limbDistance, float tickDelta, float animationProgres, float headYaw, float headPitch) {
            if ((!birdEntity.isInvisible() && (birdEntity.getBlinking()) || birdEntity.isSleeping()) && birdEntity.isOnGround() && this.render.getBlinkTexture(birdEntity) != null)  {
                renderModel(render.getGeoModelProvider(), getBlinkTexture(birdEntity), matrixStack, vertexConsumerProvider, i, birdEntity, LivingEntityRenderer.getOverlay(birdEntity, 0.0F), 1, 1, 1);
                }
        }
    }

    @Environment(EnvType.CLIENT)
    public class RingFeature extends GeoLayerRenderer<BirdEntity>{

        private final BirdBaseRenderer birdRender;

        public RingFeature(BirdBaseRenderer ctx) {
            super(ctx);
            this.birdRender = ctx;
        }

        @Override
        public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, BirdEntity birdEntity, float limbAngle, float limbDistance, float tickDelta, float animationProgres, float headYaw, float headPitch) {
            if (!birdEntity.isInvisible() && birdEntity.hasBeenRinged() && birdRender.getRingTexture(birdEntity) != null)
            {
                float[] fs = birdEntity.getRingColor().getColorComponents();
                renderModel(birdRender.getGeoModelProvider(), getRingTexture(birdEntity), matrixStack, vertexConsumerProvider, i, birdEntity, 1, fs[0], fs[1], fs[2]);
            }
        }
    }
}