package com.ikerleon.birdwmod.entity;

import com.ikerleon.birdwmod.items.InitItems;
import com.ikerleon.birdwmod.util.SoundHandler;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.Arrays;

public class BirdSettings {
    // Describes the traits of all the birds
    public static final BirdEntity.Settings EURASIAN_BULLFINCH_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.SMALL).withDimensions(0.3f, 0.3f)
            .goesToFeeders().isGroupBird()
            .isDimorphic()
            .withPath("eurasian_bullfinch")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.BULLFINCH_CALL)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS)
            .withPrevalence(10).withSpawnGroupSize(1, 4)
            .withSpawnBiome(Biome.Category.FOREST, BirdEntity.Settings.BiomeTemperature.COLD).withSpawnBiome(Biome.Category.FOREST, BirdEntity.Settings.BiomeTemperature.TEMPERATE);

    public static final BirdEntity.Settings RED_NECKED_NIGHTJAR_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.4f, 0.2f)
            .goesToFeeders()
            .withPath("red_necked_nightjar")
            .withAwakeTime(BirdEntity.AwakeTime.NOCTURNAL)
            .withVariants(3)
            .withBirdAttributes(0.0D, 0.7D, 5.0D)
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.NIGHTJAR_SONG)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP)
            .withPrevalence(7).withSpawnGroupSize(1, 2)
            .withSpawnBiome(Biome.Category.MESA).withSpawnBiome(Biome.Category.SAVANNA);

    public static final BirdEntity.Settings RED_FLANKED_BLUETAIL_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.SMALL).withDimensions(0.3f, 0.3f)
            .goesToFeeders()
            .withPath("red_flanked_bluetail")
            .isDimorphic()
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.BLUETAIL_CALL)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS)
            .withPrevalence(7).withSpawnGroupSize(1, 2)
            .withSpawnBiome(Biome.Category.TAIGA, BirdEntity.Settings.BiomeTemperature.COLD);

    public static final BirdEntity.Settings STELLERS_EIDER_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.BIG).withDimensions(0.4f, 0.6f)
            .isGroupBird()
            .isWaterBird()
            .isDimorphic()
            .withBirdAttributes(0.2, 0.7, 10.0)
            .withPath("stellers_eider")
            .withCallType(BirdEntity.CallType.MALES_ONLY).withCall(SoundHandler.EIDER_CALL)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS)
            .withPrevalence(7).withSpawnGroupSize(1, 5)
            .withSpawnBiome(Biome.Category.BEACH, BirdEntity.Settings.BiomeTemperature.FROZEN)
            .withSpawnBiome(Biome.Category.OCEAN, BirdEntity.Settings.BiomeTemperature.FROZEN);

    public static final BirdEntity.Settings HOATZIN_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.4f, 0.4f)
            .withBirdAttributes(0.2, 0.7, 7.0)
            .withPath("hoatzin")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.HOATZIN_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP)
            .withSpawnGroupSize(1, 2).withPrevalence(7)
            .withSpawnBiome(Biome.Category.SWAMP).withSpawnBiome(Biome.Category.JUNGLE, BirdEntity.Settings.BiomeTemperature.ALL_WARMER_THAN_COLD);

    public static final BirdEntity.Settings KING_OF_SAXONY_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.3f, 0.3f)
            .withPath("king_of_saxony")
            .goesToFeeders()
            .isDimorphic()
            .withCallType(BirdEntity.CallType.GENDERED_CALLS).withCall(SoundHandler.KINGOFSAXONY_SONG, SoundHandler.KINGOFSAXONY_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP)
            .withSpawnGroupSize(1, 2).withPrevalence(10)
            .withSpawnBiome(Biome.Category.JUNGLE, BirdEntity.Settings.BiomeTemperature.ALL_WARMER_THAN_COLD);

    public static final BirdEntity.Settings MOTMOT_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.3f, 0.3f)
            .withVariants(3)
            .withBirdAttributes(0.2, 0.7, 6.0)
            .withPath("motmot")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.MOTMOT_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP)
            .withSpawnGroupSize(1, 5).withPrevalence(17)
            .withSpawnBiome(Biome.Category.JUNGLE, BirdEntity.Settings.BiomeTemperature.ALL_WARMER_THAN_COLD);

    public static final BirdEntity.Settings EASTERN_BLUEBIRD_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.SMALL).withDimensions(0.3f, 0.3f)
            .withPath("eastern_bluebird")
            .goesToFeeders().isGroupBird()
            .isDimorphic()
            .withCallType(BirdEntity.CallType.GENDERED_CALLS).withCall(SoundHandler.BLUEBIRD_SONG, SoundHandler.BLUEBIRD_CALL)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS)
            .withSpawnGroupSize(1, 4).withPrevalence(10)
            .withSpawnBiome(Biome.Category.PLAINS).withSpawnBiome(Biome.Category.FOREST, BirdEntity.Settings.BiomeTemperature.TEMPERATE);

    public static final BirdEntity.Settings GREEN_HERON_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.BIG).withDimensions(0.3f, 0.5f)
            .withVariants(3)
            .withPath("green_heron")
            .withBirdAttributes(0.2, 0.7, 10)
            .withCallType(BirdEntity.CallType.NO_CALL).withFlyingSound(SoundHandler.HERON_FLYING)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP)
            .withSpawnGroupSize(1, 2).withPrevalence(7)
            .withSpawnBiome(Biome.Category.SWAMP).withSpawnBiome(Biome.Category.RIVER, BirdEntity.Settings.BiomeTemperature.TEMPERATE);

    public static final BirdEntity.Settings KILLDEER_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.4f, 0.3f)
            .withVariants(3)
            .isGroupBird()
            .withPath("killdeer")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.KILLDEER_CALL).withFlyingSound(SoundHandler.KILLDEER_FLYING)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP)
            .withSpawnGroupSize(1, 4).withPrevalence(7)
            .withSpawnBiome(Biome.Category.PLAINS, BirdEntity.Settings.BiomeTemperature.TEMPERATE);

    public static final ArrayList<SoundEvent> MOCKINGBIRD_MIMICKABLE = new ArrayList(Arrays.asList(SoundHandler.KILLDEER_CALL,
            SoundHandler.BLUEBIRD_CALL, SoundHandler.BLUEBIRD_SONG, SoundHandler.BULLFINCH_CALL));

    public static final BirdEntity.Settings NORTHERN_MOCKINGBIRD_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.SMALL).withDimensions(0.3f, 0.3f)
            .withVariants(3)
            .goesToFeeders()
            .withPath("northern_mockingbird")
            // The mockingbird song setup is unique and draws from MOCKINGBIRD_MIMICKABLE
            .withCallType(BirdEntity.CallType.MOCKINGBIRD)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP)
            .withSpawnGroupSize(1, 4).withPrevalence(10)
            .withSpawnBiome(Biome.Category.PLAINS).withSpawnBiome(Biome.Category.FOREST, BirdEntity.Settings.BiomeTemperature.TEMPERATE);

    public static final BirdEntity.Settings BROWN_BOOBY_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.BIG).withDimensions(0.5f, 0.6f)
            .withVariants(4)
            .withBirdAttributes(0.2, 0.7, 10)
            .isWaterBird()
            .isGroupBird()
            .withPath("brown_booby")
            .withCallType(BirdEntity.CallType.MALES_ONLY).withCall(SoundHandler.BOOBY_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP)
            .withSpawnGroupSize(1, 5).withPrevalence(7)
            .withSpawnBiome(Biome.Category.BEACH, BirdEntity.Settings.BiomeTemperature.ALL_WARMER_THAN_COLD).withSpawnBiome(Biome.Category.OCEAN, BirdEntity.Settings.BiomeTemperature.ALL_WARMER_THAN_COLD);

    public static final BirdEntity.Settings GREAT_GREY_OWL_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.5f, 0.6f)
            .withVariants(3)
            .withAwakeTime(BirdEntity.AwakeTime.NOCTURNAL)
            .withPath("great_grey_owl")
            .withCallType(BirdEntity.CallType.MALES_ONLY).withCall(SoundHandler.GREATGREYOWL_SONG)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP)
            .withSpawnGroupSize(1, 2).withPrevalence(10)
            .withSpawnBiome(Biome.Category.FOREST).withSpawnBiome(Biome.Category.TAIGA, BirdEntity.Settings.BiomeTemperature.COLD);

    public static final BirdEntity.Settings HIMALAYAN_MONAL_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.BIG).withDimensions(0.4f, 0.6f)
            .withPath("himalayan_monal")
            .isDimorphic()
            .withBirdAttributes(0.2, 0.7, 10.0)
            .withCallType(BirdEntity.CallType.MALES_ONLY).withCall(SoundHandler.HIMALAYAN_MONAL_SONG)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS)
            .withSpawnGroupSize(1, 3).withPrevalence(10)
            .withSpawnBiome(Biome.Category.EXTREME_HILLS, BirdEntity.Settings.BiomeTemperature.COLD)
            .withSpawnBiome(Biome.Category.EXTREME_HILLS, BirdEntity.Settings.BiomeTemperature.FROZEN);

    public static final BirdEntity.Settings RAZORBILL_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.BIG).withDimensions(0.3f, 0.5f)
            .withPath("razorbill")
            .isGroupBird().isWaterBird()
            .withBirdAttributes(0.0, 0.7, 10.0)
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.RAZORBILL_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP)
            .withSpawnGroupSize(1, 5).withPrevalence(10)
            .withSpawnBiome(Biome.Category.BEACH, BirdEntity.Settings.BiomeTemperature.FROZEN).withSpawnBiome(Biome.Category.OCEAN);

    public static final BirdEntity.Settings SABINES_GULL_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.4f, 0.4f)
            .withPath("sabines_gull")
            .withVariants(3)
            .isGroupBird().isWaterBird()
            .withBirdAttributes(0.2, 0.7, 6.0)
            .withCallType(BirdEntity.CallType.NO_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP)
            .withSpawnGroupSize(1, 8).withPrevalence(7)
            .withSpawnBiome(Biome.Category.PLAINS, BirdEntity.Settings.BiomeTemperature.FROZEN).withSpawnBiome(Biome.Category.OCEAN);

    public static final ArrayList<BirdEntity.Settings> bookBirds = new ArrayList(Arrays.asList(EURASIAN_BULLFINCH_SETTINGS, RED_NECKED_NIGHTJAR_SETTINGS,
            RED_FLANKED_BLUETAIL_SETTINGS, STELLERS_EIDER_SETTINGS, HOATZIN_SETTINGS, KING_OF_SAXONY_SETTINGS, MOTMOT_SETTINGS, EASTERN_BLUEBIRD_SETTINGS,
            GREEN_HERON_SETTINGS, KILLDEER_SETTINGS, NORTHERN_MOCKINGBIRD_SETTINGS, BROWN_BOOBY_SETTINGS, GREAT_GREY_OWL_SETTINGS, HIMALAYAN_MONAL_SETTINGS,
            RAZORBILL_SETTINGS, SABINES_GULL_SETTINGS));
}
