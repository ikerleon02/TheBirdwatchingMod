package com.ikerleon.birdwmod.biome;

import com.ikerleon.birdwmod.feature.TBMConfiguredFeatures;
import com.ikerleon.birdwmod.surfacebuilder.InitSurfaceBuilders;
import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.DefaultFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class MountainOldBirchForestBiome {
    private static final BiomeTemplate OLD_BIRCH_FOREST_TEMPLATE = new BiomeTemplate(InitBiomes.BIOME_TEMPLATE.builder()
            .configureSurfaceBuilder(InitSurfaceBuilders.MOUNTAIN_OLD_BIRCH_FOREST, SurfaceBuilder.GRASS_CONFIG)
            .addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_GRASS, DefaultFeature.AMETHYST_GEODE)
            .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBMConfiguredFeatures.MOUNTAIN_OLD_BIRCH_TREES)
            .category(Biome.Category.FOREST)
            .addDefaultSpawnEntries()
            //.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4))
            .effects(InitBiomes.createDefaultBiomeEffects()
                    .grassColor(0x3dba42)
                    .foliageColor(0x629463)
                    .fogColor(0xebebeb)
                    .waterColor(0x6dbac9)
                    .waterFogColor(0x6dbac9)
            )
            .temperature(0.6F)
            .downfall(0.9F)
    );

    static final Biome MOUNTAIN_OLD_BIRCH_FOREST = OLD_BIRCH_FOREST_TEMPLATE.builder()
            .depth(1.8F)
            .scale(0.5F)
            .temperature(0.3F)
            .playerSpawnFriendly()
            .build();
}
