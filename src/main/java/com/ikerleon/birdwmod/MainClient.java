package com.ikerleon.birdwmod;

import com.ikerleon.birdwmod.blocks.InitBlocks;
import com.ikerleon.birdwmod.entity.InitEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class MainClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(InitBlocks.RINGING_NET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(InitBlocks.BIRD_FEEDER, RenderLayer.getCutout());
        InitEntities.registerRenderers();
    }
}
