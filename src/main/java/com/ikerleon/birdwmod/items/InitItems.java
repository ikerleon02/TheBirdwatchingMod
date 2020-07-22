package com.ikerleon.birdwmod.items;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InitItems {

    //birwatching utils
    public static final Item BINOCULAR_BASIC = new ItemBinocular(15);
    public static final Item BINOCULAR_MEDIUM = new ItemBinocular(10);
    public static final Item BINOCULAR_PROFFESIONAL = new ItemBinocular(5);

    public static final Item RING = new ItemBirdwmodBasic();

    //feathers
    public static final Item EASTERNBLUEBIRDFEATHER_FEMALE = new ItemBirdwmodBasic();
    public static final Item EASTERNBLUEBIRDFEATHER_MALE = new ItemBirdwmodBasic();
    public static final Item EURASIANBULLFINCHDFEATHER_FEMALE = new ItemBirdwmodBasic();
    public static final Item EURASIANBULLFINCHDFEATHER_MALE = new ItemBirdwmodBasic();
    public static final Item GREENHERONFEATHER = new ItemBirdwmodBasic();
    public static final Item KILLDEERFEATHER = new ItemBirdwmodBasic();
    public static final Item NORTHERNMOCKINGBIRDFEATHER = new ItemBirdwmodBasic();
    public static final Item REDFLANCKEDBLUETAILFEATHER_FEMALE = new ItemBirdwmodBasic();
    public static final Item REDFLANCKEDBLUETAILFEATHER_MALE = new ItemBirdwmodBasic();
    public static final Item REDNECKEDNIGHTJARFEATHER = new ItemBirdwmodBasic();
    public static final Item STELLERSEIDERFEATHER_FEMALE = new ItemBirdwmodBasic();
    public static final Item STELLERSEIDERFEATHER_MALE = new ItemBirdwmodBasic();
    public static final Item KINGOFSAXONYFEATHER_MALE = new ItemBirdwmodBasic();
    public static final Item KINGOFSAXONYFEATHER_FEMALE = new ItemBirdwmodBasic();
    public static final Item MOTMOTFEATHER = new ItemBirdwmodBasic();
    public static final Item HOATZINFEATHER = new ItemBirdwmodBasic();
    public static final Item GREATGREYOWLFEATHER = new ItemBirdwmodBasic();
    public static final Item BROWNBOOBYFEATHER = new ItemBirdwmodBasic();

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "binocular_basic"), BINOCULAR_BASIC);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "binocular_medium"), BINOCULAR_MEDIUM);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "binocular_pro"), BINOCULAR_PROFFESIONAL);

        Registry.register(Registry.ITEM, new Identifier("birdwmod", "ring"), RING);

        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_easternbluebirdfemale"), EASTERNBLUEBIRDFEATHER_FEMALE);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_easternbluebirdmale"), EASTERNBLUEBIRDFEATHER_MALE);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_eurasianbullfinchfemale"), EURASIANBULLFINCHDFEATHER_FEMALE);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_eurasianbullfinchmale"), EURASIANBULLFINCHDFEATHER_MALE);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_greenheron"), GREENHERONFEATHER);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_killdeer"), KILLDEERFEATHER);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_northernmockingbird"), NORTHERNMOCKINGBIRDFEATHER);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_redflanckedbluetailfemale"), REDFLANCKEDBLUETAILFEATHER_FEMALE);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_redflanckedbluetailmale"), REDFLANCKEDBLUETAILFEATHER_MALE);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_redneckednightjar"), REDNECKEDNIGHTJARFEATHER);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_stellerseiderfemale"), STELLERSEIDERFEATHER_FEMALE);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_stellerseidermale"), STELLERSEIDERFEATHER_MALE);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_kingofsaxonymale"), KINGOFSAXONYFEATHER_MALE);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_kingofsaxonyfemale"), KINGOFSAXONYFEATHER_FEMALE);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_motmot"), MOTMOTFEATHER);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_hoatzin"), HOATZINFEATHER);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_greatgreyowl"), GREATGREYOWLFEATHER);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_brownbooby"), BROWNBOOBYFEATHER);

    }
}
