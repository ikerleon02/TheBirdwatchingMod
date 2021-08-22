package com.ikerleon.birdwmod.generation;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.biome.InitBiomes;
import com.terraformersmc.terraform.config.BiomeConfig;
import com.terraformersmc.terraform.config.BiomeConfigNode;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.BiomeAccess;

public class InitGeneration extends InitBiomes {

    private static BiomeConfig config;

    public static void register() {
        config = Main.BIOME_CONFIG_HANDLER.getBiomeConfig();
        addContinentalBiome(MOUNTAIN_OLD_BIRCH_FOREST, OverworldClimate.TEMPERATE, 0.2);
        addContinentalBiome(MOUNTAIN_OLD_BIRCH_FOREST, OverworldClimate.COOL, 0.075);
        OverworldBiomes.addEdgeBiome(MOUNTAIN_OLD_BIRCH_FOREST, BiomeKeys.BIRCH_FOREST, 1.0);
        Main.BIOME_CONFIG_HANDLER.save();
    }

    private static void addContinentalBiome(RegistryKey<Biome> biome, OverworldClimate climate, double defaultWeight) {
        boolean enable = !config.isFrozen();

        BiomeConfigNode.Continental continental = config.continental(biome.getValue().getPath(), new BiomeConfigNode.Continental(enable, defaultWeight));
        enable = continental.isEnabled();

        double weight = continental.getWeight();
        if (enable && weight > 0.0) {
            OverworldBiomes.addContinentalBiome(biome, climate, weight);
        }
    }

}
