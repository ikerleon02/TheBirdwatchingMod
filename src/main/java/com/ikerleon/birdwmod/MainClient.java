package com.ikerleon.birdwmod;

import com.ikerleon.birdwmod.blocks.InitBlocks;
import com.ikerleon.birdwmod.entity.InitEntities;
import com.ikerleon.birdwmod.items.InitItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class MainClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(InitBlocks.RINGING_NET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(InitBlocks.BIRD_FEEDER, RenderLayer.getCutout());
        FabricModelPredicateProviderRegistry.register(InitItems.BINOCULAR_BASIC, new Identifier("pulling"), (itemStack, clientWorld, livingEntity) -> {
            return livingEntity != null && MinecraftClient.getInstance().options.perspective == 0 && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
        FabricModelPredicateProviderRegistry.register(InitItems.BINOCULAR_MEDIUM, new Identifier("pulling"), (itemStack, clientWorld, livingEntity) -> {
            return livingEntity != null && MinecraftClient.getInstance().options.perspective == 0 && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
        FabricModelPredicateProviderRegistry.register(InitItems.BINOCULAR_PROFFESIONAL, new Identifier("pulling"), (itemStack, clientWorld, livingEntity) -> {
            return livingEntity != null && MinecraftClient.getInstance().options.perspective == 0 && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
        InitEntities.registerRenderers();
    }
}
