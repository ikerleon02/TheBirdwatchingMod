package com.ikerleon.birdwmod.init;

import java.util.ArrayList;
import java.util.List;

import com.ikerleon.birdwmod.items.*;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BirdwmodItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	//birwatching utils
	public static final Item BINOCULAR_BASIC = new ItemBinocular("binocular_basic", 15);
	public static final Item BINOCULAR_MEDIUM = new ItemBinocular("binocular_medium", 10);
	public static final Item BINOCULAR_PROFFESIONAL = new ItemBinocular("binocular_pro", 5);

	public static final Item BIRD_GUIDE = new ItemBirdGuide("bird_guide");

	public static final Item RING = new ItemBasic("ring");

	//Spawn eggs
	public static final Item REDNECKEDNIGHTJAR_SPAWNEGG = new ItemBirdSpawnEgg("rednecked_nightjar");
	public static final Item EURASIANBULLFINCH_SPAWNEGG = new ItemBirdSpawnEgg("eurasian_bullfinch");
	public static final Item REDFLANKEDBLUETAIL_SPAWNEGG = new ItemBirdSpawnEgg("redflanked_bluetail");
	public static final Item STELLERSEIDER_SPAWNEGG = new ItemBirdSpawnEgg("stellers_eider");

	public static final Item KILLDEER_SPAWNEGG = new ItemBirdSpawnEgg("killdeer");
	public static final Item EASTERNBLUEBIRD_SPAWNEGG = new ItemBirdSpawnEgg("eastern_bluebird");
	public static final Item NORTHERNMOCKINGBIRD_SPAWNEGG = new ItemBirdSpawnEgg("northern_mockingbird");
	public static final Item GREENHERON_SPAWNEGG = new ItemBirdSpawnEgg("green_heron");

	public static final Item HOATZIN_SPAWNEGG = new ItemBirdSpawnEgg("hoatzin");
	public static final Item TURQUOISEBROWEDMOTMOT_SPAWNEGG = new ItemBirdSpawnEgg("turquoisebrowed_motmot");
	public static final Item KINGOFSAXONY_SPAWNEGG = new ItemBirdSpawnEgg("kingofsaxony_bird_of_paradise");

	public static final Item GREATGREYOWL_SPAWNEGG = new ItemBirdSpawnEgg("great_grey_owl");
	public static final Item BROWNBOOBY_SPAWNEGG = new ItemBirdSpawnEgg("brown_booby");

	//feathers
	public static final Item EASTERNBLUEBIRDFEATHER_FEMALE = new ItemBasic("feather_easternbluebirdfemale");
	public static final Item EASTERNBLUEBIRDFEATHER_MALE = new ItemBasic("feather_easternbluebirdmale");
	public static final Item EURASIANBULLFINCHDFEATHER_FEMALE = new ItemBasic("feather_eurasianbullfinchfemale");
	public static final Item EURASIANBULLFINCHDFEATHER_MALE = new ItemBasic("feather_eurasianbullfinchmale");
	public static final Item GREENHERONFEATHER = new ItemBasic("feather_greenheron");
	public static final Item KILLDEERFEATHER = new ItemBasic("feather_killdeer");
	public static final Item NORTHERNMOCKINGBIRDFEATHER = new ItemBasic("feather_northernmockingbird");
	public static final Item REDFLANCKEDBLUETAILFEATHER_FEMALE = new ItemBasic("feather_redflanckedbluetailfemale");
	public static final Item REDFLANCKEDBLUETAILFEATHER_MALE = new ItemBasic("feather_redflanckedbluetailmale");
	public static final Item REDNECKEDNIGHTJARFEATHER = new ItemBasic("feather_redneckednightjar");
	public static final Item STELLERSEIDERFEATHER_FEMALE = new ItemBasic("feather_stellerseiderfemale");
	public static final Item STELLERSEIDERFEATHER_MALE = new ItemBasic("feather_stellerseidermale");
	public static final Item KINGOFSAXONYFEATHER_MALE = new ItemBasic("feather_kingofsaxonymale");
	public static final Item KINGOFSAXONYFEATHER_FEMALE = new ItemBasic("feather_kingofsaxonyfemale");
	public static final Item MOTMOTFEATHER = new ItemBasic("feather_motmot");
	public static final Item HOATZINFEATHER = new ItemBasic("feather_hoatzin");
	public static final Item GREATGREYOWLFEATHER = new ItemBasic("feather_greatgreyowl");
	public static final Item BROWNBOOBYFEATHER = new ItemBasic("feather_brownbooby");

	//meats
	public static final Item DUCKRAWMEAT = new ItemMeat("meatraw_duck", 3, true);
	public static final Item HERONRAWMEAT = new ItemMeat("meatraw_heron", 3, true);
	public static final Item NIGHTJARRAWMEAT = new ItemMeat("meatraw_nightjar", 2, true);
	public static final Item PASSERINERAWMEAT = new ItemMeat("meatraw_passerine", 1, true);
	public static final Item WADERRAWMEAT = new ItemMeat("meatraw_wader", 2, true);

	public static final Item DUCKCOOCKEDMEAT = new ItemMeat("meatcooked_duck", 8, true);
	public static final Item HERONCOOCKEDMEAT = new ItemMeat("meatcooked_heron", 8, true);
	public static final Item NIGHTJARCOOCKEDMEAT = new ItemMeat("meatcooked_nightjar", 4, true);
	public static final Item PASSERINECOOCKEDMEAT = new ItemMeat("meatcooked_passerine", 3, true);
	public static final Item WADERCOOCKEDMEAT = new ItemMeat("meatcooked_wader", 4, true);

	public static void registerItems() {
		ForgeRegistries.ITEMS.registerAll(BirdwmodItems.ITEMS.toArray(new Item[BirdwmodItems.ITEMS.size()]));
	}
	
	public static void registerItemRenders(){
		for(Item item : BirdwmodItems.ITEMS) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
}
