package com.ikerleon.birdwmod.init;

import java.util.ArrayList;
import java.util.List;

import com.ikerleon.birdwmod.items.ItemBinocular;
import com.ikerleon.birdwmod.items.ItemBirdGuide;

import com.ikerleon.birdwmod.items.ItemFeather;
import com.ikerleon.birdwmod.items.ItemMeat;
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

	//feathers
	public static final Item EASTERNBLUEBIRDFEATHER_FEMALE = new ItemFeather("feather_easternbluebirdfemale");
	public static final Item EASTERNBLUEBIRDFEATHER_MALE = new ItemFeather("feather_easternbluebirdmale");
	public static final Item EURASIANBULLFINCHDFEATHER_FEMALE = new ItemFeather("feather_eurasianbullfinchfemale");
	public static final Item EURASIANBULLFINCHDFEATHER_MALE = new ItemFeather("feather_eurasianbullfinchmale");
	public static final Item GREENHERONFEATHER = new ItemFeather("feather_greenheron");
	public static final Item KILLDEERFEATHER = new ItemFeather("feather_killdeer");
	public static final Item NORTHERNMOCKINGBIRDFEATHER = new ItemFeather("feather_northernmockingbird");
	public static final Item REDFLANCKEDBLUETAILFEATHER_FEMALE = new ItemFeather("feather_redflanckedbluetailfemale");
	public static final Item REDFLANCKEDBLUETAILFEATHER_MALE = new ItemFeather("feather_redflanckedbluetailmale");
	public static final Item REDNECKEDNIGHTJARFEATHER = new ItemFeather("feather_redneckednightjar");
	public static final Item STELLERSEIDERFEATHER_FEMALE = new ItemFeather("feather_stellerseiderfemale");
	public static final Item STELLERSEIDERFEATHER_MALE = new ItemFeather("feather_stellerseidermale");
	public static final Item KINGOFSAXONYFEATHER_MALE = new ItemFeather("feather_kingofsaxonymale");
	public static final Item KINGOFSAXONYFEATHER_FEMALE = new ItemFeather("feather_kingofsaxonyfemale");
	public static final Item MOTMOTFEATHER = new ItemFeather("feather_motmot");
	public static final Item HOATZINFEATHER = new ItemFeather("feather_hoatzin");

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
