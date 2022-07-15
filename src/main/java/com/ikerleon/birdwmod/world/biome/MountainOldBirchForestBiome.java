package com.ikerleon.birdwmod.world.biome;

import com.ikerleon.birdwmod.world.feature.TBMPlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import static com.ikerleon.birdwmod.world.biome.InitBiomes.addBasicFeatures;

public class MountainOldBirchForestBiome {
    static final Biome MOUNTAIN_OLD_BIRCH_FOREST = InitBiomes.BIOME_TEMPLATE
            //TODO
            //.configureSurfaceBuilder(InitSurfaceBuilders.MOUNTAIN_OLD_BIRCH_FOREST, SurfaceBuilder.GRASS_CONFIG)
            //.category(Biome.Category.EXTREME_HILLS)
            //.category(Biome.Category.FOREST)

            .generationSettings(generationSettings())
            .temperature(0.3F)
            .downfall(0.8F)
            .spawnSettings(spawnSettings())
            .effects(InitBiomes.createDefaultBiomeEffects()
                    .grassColor(0x3dba42)
                    .foliageColor(0x629463)
                    .fogColor(0xebebeb)
                    .waterColor(0x6dbac9)
                    .waterFogColor(0x6dbac9)
                    .build()
            )
            .build();

    private static GenerationSettings generationSettings(){
        GenerationSettings.Builder builder = new GenerationSettings.Builder();
        addBasicFeatures(builder);
        DefaultBiomeFeatures.addDefaultOres(builder);
        DefaultBiomeFeatures.addEmeraldOre(builder);
        DefaultBiomeFeatures.addDefaultDisks(builder);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TBMPlacedFeatures.MOUNTAIN_OLD_BIRCH_TREES);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TBMPlacedFeatures.ERICA_BUSH);
        DefaultBiomeFeatures.addForestFlowers(builder);
        DefaultBiomeFeatures.addForestGrass(builder);
        DefaultBiomeFeatures.addLargeFerns(builder);
        DefaultBiomeFeatures.addLushCavesDecoration(builder);
        DefaultBiomeFeatures.addDefaultMushrooms(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addWaterBiomeOakTrees(builder);
        DefaultBiomeFeatures.addDefaultVegetation(builder);
        return builder.build();
    }

    private static SpawnSettings spawnSettings(){
        SpawnSettings.Builder builder = InitBiomes.createDefaultSpawnSettings();
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
        return builder.build();
    }
}
