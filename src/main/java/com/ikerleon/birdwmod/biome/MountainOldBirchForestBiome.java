package com.ikerleon.birdwmod.biome;

import com.ikerleon.birdwmod.feature.TBMConfiguredFeatures;
import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.DefaultFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;

public class MountainOldBirchForestBiome {
    private static final BiomeTemplate OLD_BIRCH_FOREST_TEMPLATE = new BiomeTemplate(InitBiomes.BIOME_TEMPLATE.builder()
            .addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_FLOWERS, DefaultFeature.FOREST_GRASS)
            .addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TBMConfiguredFeatures.MOUNTAIN_OLD_BIRCH_TREES)
            .addStructureFeature(ConfiguredStructureFeatures.PILLAGER_OUTPOST)
            .addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL)
            .category(Biome.Category.FOREST)
            .addDefaultSpawnEntries()
            //.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4))
            .effects(InitBiomes.createDefaultBiomeEffects()
                    .grassColor(0x338235)
                    .foliageColor(0x338235)
            )
            .temperature(0.6F)
            .downfall(0.9F)
    );

    static final Biome MOUNTAIN_OLD_BIRCH_FOREST = OLD_BIRCH_FOREST_TEMPLATE.builder()
            .depth(1.6F)
            .scale(0.4F)
            .temperature(0.3F)
            .build();
}
