package com.ikerleon.birdwmod.biome;

import com.ikerleon.birdwmod.feature.TBMConfiguredFeatures;
import com.ikerleon.birdwmod.surfacebuilder.InitSurfaceBuilders;
import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.DefaultFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class MountainOldBirchForestBiome {
    private static final BiomeTemplate OLD_BIRCH_FOREST_TEMPLATE = new BiomeTemplate(InitBiomes.BIOME_TEMPLATE.builder()
            .configureSurfaceBuilder(InitSurfaceBuilders.MOUNTAIN_OLD_BIRCH_FOREST, SurfaceBuilder.GRASS_CONFIG)
            .addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_GRASS, DefaultFeature.AMETHYST_GEODE, DefaultFeature.EMERALD_ORE, DefaultFeature.LARGE_FERNS, DefaultFeature.MINEABLES_GLOW_LICHEN)
            .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBMConfiguredFeatures.MOUNTAIN_OLD_BIRCH_TREES)
            .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBMConfiguredFeatures.PATCH_ERICA_BUSH)
            .category(Biome.Category.EXTREME_HILLS)
            .category(Biome.Category.FOREST)
            .addDefaultCreatureSpawnEntries()
            .addDefaultAmbientSpawnEntries()
            //.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4))
            .effects(InitBiomes.createDefaultBiomeEffects()
                    .grassColor(0x3dba42)
                    .foliageColor(0x629463)
                    .fogColor(0xebebeb)
                    .waterColor(0x6dbac9)
                    .waterFogColor(0x6dbac9)
            )
            .temperature(0.3F)
            .downfall(0.8F)
    );

    static final Biome MOUNTAIN_OLD_BIRCH_FOREST = OLD_BIRCH_FOREST_TEMPLATE.builder()
            .depth(2F)
            .scale(0.025F)
            .playerSpawnFriendly()
            .build();
}
