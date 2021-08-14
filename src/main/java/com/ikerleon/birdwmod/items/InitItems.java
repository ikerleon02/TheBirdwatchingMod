package com.ikerleon.birdwmod.items;

//import com.ikerleon.birdwmod.entity.InitEntities;
import com.ikerleon.birdwmod.entity.InitEntities;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InitItems {

    //birwatching utils
    public static final Item BINOCULAR_BASIC = new ItemBinocular(15);
    public static final Item BINOCULAR_MEDIUM = new ItemBinocular(10);
    public static final Item BINOCULAR_PROFFESIONAL = new ItemBinocular(5);

    public static final Item RING = new ItemBirdwmodBasic();

    public static final Item BIRD_GUIDE = new ItemBirdGuide();

    //Spawn eggs
    public static final Item EURASIANBULLFINCH_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.EURASIAN_BULLFINCH_ENTITY);
    /*public static final Item REDNECKEDNIGHTJAR_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.RED_NECKED_NIGHTJAR_ENTITY);
    public static final Item REDFLANKEDBLUETAIL_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.RED_FLANKED_BLUETAIL_ENTITY);
    public static final Item STELLERSEIDER_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.STELLERS_EIDER_ENTITY);

    public static final Item KILLDEER_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.KILLDEER_ENTITY);
    public static final Item EASTERNBLUEBIRD_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.EASTERN_BLUEBIRD_ENTITY);
    public static final Item NORTHERNMOCKINGBIRD_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.NORTHERN_MOCKINGBIRD_ENTITY);
    public static final Item GREENHERON_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.GREEN_HERON_ENTITY);

    public static final Item HOATZIN_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.HOATZIN_ENTITY);
    public static final Item TURQUOISEBROWEDMOTMOT_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.TURQUOISE_BROWED_MOTMOT_ENTITY);
    public static final Item KINGOFSAXONY_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.KING_OF_SAXONY_ENTITY);

    public static final Item GREATGREYOWL_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.GREAT_GREY_OWL_ENTITY);
    public static final Item BROWNBOOBY_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.BROWN_BOOBY_ENTITY);

    public static final Item RAZORBILL_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.RAZORBILL_ENTITY);
    public static final Item HIMALAYANMONAL_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.HIMALAYAN_MONAL_ENTITY);
    public static final Item SABINESGULL_SPAWNEGG = new ItemBirdSpawnEgg(InitEntities.SABINES_GULL_ENTITY);*/

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
    public static final Item RAZORBILLFEATHER = new ItemBirdwmodBasic();
    public static final Item HIMALAYANMONALMALEFEATHER = new ItemBirdwmodBasic();
    public static final Item HIMALAYANMONALFEMALEFEATHER = new ItemBirdwmodBasic();
    public static final Item SABINESGULLFEATHER = new ItemBirdwmodBasic();

    //meats
    public static final Item BIGRAWMEAT = new ItemBirdwmodBasic(new Item.Settings().food(new FoodComponent.Builder().hunger(3).alwaysEdible().meat().build()));
    public static final Item SMALLRAWMEAT = new ItemBirdwmodBasic(new Item.Settings().food(new FoodComponent.Builder().hunger(1).alwaysEdible().meat().build()));
    public static final Item MEDIUMRAWMEAT = new ItemBirdwmodBasic(new Item.Settings().food(new FoodComponent.Builder().hunger(2).alwaysEdible().meat().build()));

    public static final Item BIGCOOCKEDMEAT = new ItemBirdwmodBasic(new Item.Settings().food(new FoodComponent.Builder().hunger(8).alwaysEdible().meat().build()));
    public static final Item SMALLCOOCKEDMEAT = new ItemBirdwmodBasic(new Item.Settings().food(new FoodComponent.Builder().hunger(3).alwaysEdible().meat().build()));
    public static final Item MEDIUMCOOCKEDMEAT = new ItemBirdwmodBasic(new Item.Settings().food(new FoodComponent.Builder().hunger(4).alwaysEdible().meat().build()));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "binocular_basic"), BINOCULAR_BASIC);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "binocular_medium"), BINOCULAR_MEDIUM);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "binocular_pro"), BINOCULAR_PROFFESIONAL);

        Registry.register(Registry.ITEM, new Identifier("birdwmod", "ring"), RING);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "bird_guide"), BIRD_GUIDE);

        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_eurasian_bullfinch"), EURASIANBULLFINCH_SPAWNEGG);
        /**Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_rednecked_nightjar"), REDNECKEDNIGHTJAR_SPAWNEGG);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_redflanked_bluetail"), REDFLANKEDBLUETAIL_SPAWNEGG);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_stellers_eider"), STELLERSEIDER_SPAWNEGG);

        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_killdeer"), KILLDEER_SPAWNEGG);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_eastern_bluebird"), EASTERNBLUEBIRD_SPAWNEGG);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_northern_mockingbird"), NORTHERNMOCKINGBIRD_SPAWNEGG);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_green_heron"), GREENHERON_SPAWNEGG);

        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_hoatzin"), HOATZIN_SPAWNEGG);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_turquoisebrowed_motmot"), TURQUOISEBROWEDMOTMOT_SPAWNEGG);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_kingofsaxony_bird_of_paradise"), KINGOFSAXONY_SPAWNEGG);

        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_great_grey_owl"), GREATGREYOWL_SPAWNEGG);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_brown_booby"), BROWNBOOBY_SPAWNEGG);

        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_razorbill"), RAZORBILL_SPAWNEGG);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_himalayan_monal"), HIMALAYANMONAL_SPAWNEGG);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "spawnegg_sabines_gull"), SABINESGULL_SPAWNEGG);**/

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
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_razorbill"), RAZORBILLFEATHER);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_himalayanmonalmale"), HIMALAYANMONALMALEFEATHER);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_himalayanmonalfemale"), HIMALAYANMONALFEMALEFEATHER);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "feather_sabinesgull"), SABINESGULLFEATHER);

        Registry.register(Registry.ITEM, new Identifier("birdwmod", "meatraw_big"), BIGRAWMEAT);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "meatraw_small"), SMALLRAWMEAT);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "meatraw_medium"), MEDIUMRAWMEAT);

        Registry.register(Registry.ITEM, new Identifier("birdwmod", "meatcooked_big"), BIGCOOCKEDMEAT);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "meatcooked_small"), SMALLCOOCKEDMEAT);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "meatcooked_medium"), MEDIUMCOOCKEDMEAT);

    }
}
