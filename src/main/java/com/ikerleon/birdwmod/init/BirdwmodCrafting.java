package com.ikerleon.birdwmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BirdwmodCrafting {

    public static void init(FMLInitializationEvent event) {
        GameRegistry.addSmelting(new ItemStack(BirdwmodItems.DUCKRAWMEAT, 1), new ItemStack(BirdwmodItems.DUCKCOOCKEDMEAT, 1), 4.0F);
        GameRegistry.addSmelting(new ItemStack(BirdwmodItems.HERONRAWMEAT, 1), new ItemStack(BirdwmodItems.HERONCOOCKEDMEAT, 1), 4.0F);
        GameRegistry.addSmelting(new ItemStack(BirdwmodItems.NIGHTJARRAWMEAT, 1), new ItemStack(BirdwmodItems.NIGHTJARCOOCKEDMEAT, 1), 3.0F);
        GameRegistry.addSmelting(new ItemStack(BirdwmodItems.PASSERINERAWMEAT, 1), new ItemStack(BirdwmodItems.PASSERINECOOCKEDMEAT, 1), 2.0F);
        GameRegistry.addSmelting(new ItemStack(BirdwmodItems.WADERRAWMEAT, 1), new ItemStack(BirdwmodItems.WADERCOOCKEDMEAT, 1), 3.0F);
    }
}
