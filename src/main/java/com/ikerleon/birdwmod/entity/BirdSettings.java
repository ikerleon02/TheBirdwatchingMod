package com.ikerleon.birdwmod.entity;

import com.ikerleon.birdwmod.items.InitItems;
import com.ikerleon.birdwmod.util.SoundHandler;

public class BirdSettings {
    // Describes the behaviors of all the birds
    public static final BirdEntity.Settings EURASIAN_BULLFINCH_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.SMALL).withDimensions(0.3f, 0.3f)
            .goesToFeeders().isGroupBird()
            .withPath("eurasian_bullfinch")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withSound(SoundHandler.BULLFINCH_CALL, null)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS).withFeather(InitItems.EURASIANBULLFINCHDFEATHER_MALE, InitItems.EURASIANBULLFINCHDFEATHER_FEMALE);

    public static final BirdEntity.Settings RED_NECKED_NIGHTJAR_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.4f, 0.2f)
            .goesToFeeders()
            .withPath("red_necked_nightjar")
            .withAwakeTime(BirdEntity.AwakeTime.NOCTURNAL)
            .withVariants(3)
            .withBirdAttributes(0.0D, 0.7D, 5.0D)
            .withCallType(BirdEntity.CallType.BOTH_CALL).withSound(SoundHandler.NIGHTJAR_SONG, null)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.EURASIANBULLFINCHDFEATHER_FEMALE, null);

    public static final BirdEntity.Settings RED_FLANKED_BLUETAIL_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.SMALL).withDimensions(0.3f, 0.3f)
            .goesToFeeders()
            .withPath("red_flanked_bluetail")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withSound(SoundHandler.BLUETAIL_CALL, null)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS).withFeather(InitItems.REDFLANCKEDBLUETAILFEATHER_MALE, InitItems.REDFLANCKEDBLUETAILFEATHER_FEMALE);

    public static final BirdEntity.Settings STELLERS_EIDER_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.BIG).withDimensions(0.4f, 0.6f)
            .isGroupBird()
            .goesInWater()
            .withBirdAttributes(0.2, 0.7, 10.0)
            .withPath("stellers_eider")
            .withCallType(BirdEntity.CallType.MALES_ONLY).withSound(SoundHandler.EIDER_CALL, null)
            .withFeatherType(BirdEntity.FeatherType.GENDERED_DROPS).withFeather(InitItems.STELLERSEIDERFEATHER_MALE, InitItems.STELLERSEIDERFEATHER_FEMALE);

    public static final BirdEntity.Settings HOATZIN_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.4f, 0.4f)
            .withBirdAttributes(0.2, 0.7, 7.0)
            .withPath("hoatzin")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withSound(SoundHandler.EIDER_CALL, null)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.HOATZINFEATHER, null);

    public static final BirdEntity.Settings KING_OF_SAXONY_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.3f, 0.3f)
            .withPath("king_of_saxony")
            .goesToFeeders()
            .withCallType(BirdEntity.CallType.GENDERED_CALLS).withSound(SoundHandler.KINGOFSAXONY_SONG, SoundHandler.KINGOFSAXONY_CALL)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.KINGOFSAXONYFEATHER_MALE, InitItems.KINGOFSAXONYFEATHER_FEMALE);

    public static final BirdEntity.Settings MOTMOT_SETTINGS = new BirdEntity.Settings()
            .withMeatSize(BirdEntity.MeatSize.MEDIUM).withDimensions(0.3f, 0.3f)
            .withVariants(3)
            .withBirdAttributes(0.2, 0.7, 6.0)
            .withPath("motmot")
            .withCallType(BirdEntity.CallType.BOTH_CALL).withSound(SoundHandler.MOTMOT_CALL, null)
            .withFeatherType(BirdEntity.FeatherType.BOTH_DROP).withFeather(InitItems.MOTMOTFEATHER, null);

}
