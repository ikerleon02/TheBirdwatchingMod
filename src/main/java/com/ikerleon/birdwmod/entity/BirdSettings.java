package com.ikerleon.birdwmod.entity;

import com.ikerleon.birdwmod.items.InitItems;
import com.ikerleon.birdwmod.util.SoundHandler;

public class BirdSettings {
    // Describes the behaviors of all the birds
    public static final BirdEntity.Settings EURASIAN_BULLFINCH_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.SMALL).withDimensions(0.3f, 0.3f)
            .goesToFeeders().isGroupBird()
            .withPath("eurasian_bullfinch")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.BULLFINCH_CALL)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS).withFeather(InitItems.EURASIANBULLFINCHDFEATHER_MALE, InitItems.EURASIANBULLFINCHDFEATHER_FEMALE);

    public static final BirdEntity.Settings RED_NECKED_NIGHTJAR_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.4f, 0.2f)
            .goesToFeeders()
            .withPath("red_necked_nightjar")
            .withAwakeTime(BirdEntity.AwakeTime.NOCTURNAL)
            .withVariants(3)
            .withBirdAttributes(0.0D, 0.7D, 5.0D)
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.NIGHTJAR_SONG)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.EURASIANBULLFINCHDFEATHER_FEMALE);

    public static final BirdEntity.Settings RED_FLANKED_BLUETAIL_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.SMALL).withDimensions(0.3f, 0.3f)
            .goesToFeeders()
            .withPath("red_flanked_bluetail")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.BLUETAIL_CALL)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS).withFeather(InitItems.REDFLANCKEDBLUETAILFEATHER_MALE, InitItems.REDFLANCKEDBLUETAILFEATHER_FEMALE);

    public static final BirdEntity.Settings STELLERS_EIDER_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.BIG).withDimensions(0.4f, 0.6f)
            .isGroupBird()
            .isWaterBird()
            .withBirdAttributes(0.2, 0.7, 10.0)
            .withPath("stellers_eider")
            .withCallType(BirdEntity.CallType.MALES_ONLY).withCall(SoundHandler.EIDER_CALL)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS).withFeather(InitItems.STELLERSEIDERFEATHER_MALE, InitItems.STELLERSEIDERFEATHER_FEMALE);

    public static final BirdEntity.Settings HOATZIN_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.4f, 0.4f)
            .withBirdAttributes(0.2, 0.7, 7.0)
            .withPath("hoatzin")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.EIDER_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.HOATZINFEATHER);

    public static final BirdEntity.Settings KING_OF_SAXONY_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.3f, 0.3f)
            .withPath("king_of_saxony")
            .goesToFeeders()
            .withCallType(BirdEntity.CallType.GENDERED_CALLS).withCall(SoundHandler.KINGOFSAXONY_SONG, SoundHandler.KINGOFSAXONY_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.KINGOFSAXONYFEATHER_MALE, InitItems.KINGOFSAXONYFEATHER_FEMALE);

    public static final BirdEntity.Settings MOTMOT_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.3f, 0.3f)
            .withVariants(3)
            .withBirdAttributes(0.2, 0.7, 6.0)
            .withPath("motmot")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.MOTMOT_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.MOTMOTFEATHER);

    public static final BirdEntity.Settings EASTERN_BLUEBIRD_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.SMALL).withDimensions(0.3f, 0.3f)
            .withPath("eastern_bluebird")
            .goesToFeeders().isGroupBird()
            .withCallType(BirdEntity.CallType.GENDERED_CALLS).withCall(SoundHandler.BLUEBIRD_SONG, SoundHandler.BLUEBIRD_CALL)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS).withFeather(InitItems.EASTERNBLUEBIRDFEATHER_MALE, InitItems.EASTERNBLUEBIRDFEATHER_FEMALE);

    public static final BirdEntity.Settings GREEN_HERON_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.BIG).withDimensions(0.3f, 0.5f)
            .withVariants(3)
            .withPath("green_heron")
            .withBirdAttributes(0.2, 0.7, 10)
            .withCallType(BirdEntity.CallType.NO_CALL).withFlyingSound(SoundHandler.HERON_FLYING)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.GREENHERONFEATHER);

    public static final BirdEntity.Settings KILLDEER_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.4f, 0.3f)
            .withVariants(3)
            .isGroupBird()
            .withPath("killdeer")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.KILLDEER_CALL).withFlyingSound(SoundHandler.KILLDEER_FLYING)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.KILLDEERFEATHER);

    public static final BirdEntity.Settings NORTHERN_MOCKINGBIRD_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.SMALL).withDimensions(0.3f, 0.3f)
            .withVariants(3)
            .goesToFeeders()
            .withPath("northern_mockingbird")
            // The mockingbird song setup is totally unique and hardcoded.
            .withCallType(BirdEntity.CallType.MOCKINGBIRD)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.NORTHERNMOCKINGBIRDFEATHER);

    public static final BirdEntity.Settings BROWN_BOOBY_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.BIG).withDimensions(0.5f, 0.6f)
            .withVariants(4)
            .withBirdAttributes(0.2, 0.7, 10)
            .isWaterBird()
            .isGroupBird()
            .withPath("brown_booby")
            .withCallType(BirdEntity.CallType.MALES_ONLY).withCall(SoundHandler.BOOBY_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.BROWNBOOBYFEATHER);

    public static final BirdEntity.Settings GREAT_GREY_OWL_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.5f, 0.6f)
            .withVariants(3)
            .withAwakeTime(BirdEntity.AwakeTime.NOCTURNAL)
            .withPath("great_grey_owl")
            .withCallType(BirdEntity.CallType.MALES_ONLY).withCall(SoundHandler.GREATGREYOWL_SONG)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.BROWNBOOBYFEATHER);

    public static final BirdEntity.Settings HIMALAYAN_MONAL_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.BIG).withDimensions(0.4f, 0.6f)
            .withPath("himalayan_monal")
            .withBirdAttributes(0.2, 0.7, 10.0)
            .withCallType(BirdEntity.CallType.MALES_ONLY).withCall(SoundHandler.HIMALAYAN_MONAL_SONG)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS).withFeather(InitItems.HIMALAYANMONALMALEFEATHER, InitItems.HIMALAYANMONALFEMALEFEATHER);

    public static final BirdEntity.Settings RAZORBILL_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.BIG).withDimensions(0.3f, 0.5f)
            .withPath("razorbill")
            .isGroupBird().isWaterBird()
            .withBirdAttributes(0.0, 0.7, 10.0)
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.RAZORBILL_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.RAZORBILLFEATHER);

    public static final BirdEntity.Settings SABINES_GULL_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.4f, 0.4f)
            .withPath("sabines_gull")
            .withVariants(3)
            .isGroupBird().isWaterBird()
            .withBirdAttributes(0.2, 0.7, 6.0)
            .withCallType(BirdEntity.CallType.BOTH_CALL).withCall(SoundHandler.SABINES_GULL_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.SABINESGULLFEATHER);

}
