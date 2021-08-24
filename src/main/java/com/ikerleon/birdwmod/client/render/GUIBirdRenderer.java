package com.ikerleon.birdwmod.client.render;

import com.ikerleon.birdwmod.client.model.entity.GUIBirdModel;
import com.ikerleon.birdwmod.entity.BirdEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GUIBirdRenderer extends GeoEntityRenderer<BirdEntity> {
    public GUIBirdRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new GUIBirdModel());
    }
}