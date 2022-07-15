package com.ikerleon.birdwmod.world.gen;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.world.biome.InitBiomes;
import com.terraformersmc.terraform.config.BiomeConfig;
import com.terraformersmc.terraform.config.BiomeConfigNode;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class InitGeneration extends InitBiomes {

    private static BiomeConfig config;
//TODO
    /*public static void register() {
        config = Main.BIOME_CONFIG_HANDLER.getBiomeConfig();
        addContinentalBiome(MOUNTAIN_OLD_BIRCH_FOREST, OverworldClimate.COOL, 0.0075);
        OverworldBiomes.addEdgeBiome(MOUNTAIN_OLD_BIRCH_FOREST, BiomeKeys.TALL_BIRCH_HILLS, 1.0);
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
    }*/

}
