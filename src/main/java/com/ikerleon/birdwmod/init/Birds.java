package com.ikerleon.birdwmod.init;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.entity.europe.EntityEurasianBullfinch;
import com.ikerleon.birdwmod.entity.europe.EntityRedFlankedBluetail;
import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.entity.jungle.EntityHoatzin;
import com.ikerleon.birdwmod.entity.jungle.EntityKingofSaxony;
import com.ikerleon.birdwmod.entity.jungle.EntityTurquoiseBrowedMotmot;
import com.ikerleon.birdwmod.entity.northamerica.EntityEasternBluebird;
import com.ikerleon.birdwmod.entity.northamerica.EntityGreenHeron;
import com.ikerleon.birdwmod.entity.northamerica.EntityKilldeer;

import com.ikerleon.birdwmod.entity.northamerica.EntityNorthernMockingbird;
import com.ikerleon.birdwmod.entity.release160.EntityBrownBooby;
import com.ikerleon.birdwmod.entity.release160.EntityGreatGreyOwl;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class Birds {
	private static int id = 0;
	
	public static void init() {
		//EUROPE
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "rednecked_nightjar"),EntityRedNeckedNightjar.class, "rednecked_nightjar", id++, Main.instance, 1024, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "eurasian_bullfinch"), EntityEurasianBullfinch.class, "eurasian_bullfinch", id++, Main.instance, 1024, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "redflanked_bluetail"),EntityRedFlankedBluetail.class, "redflanked_bluetail", id++, Main.instance, 1024, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "stellers_eider"), EntityStellersEider.class, "stellers_eider", id++, Main.instance, 1024, 1, true);
		//AMERICA
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "killdeer"),EntityKilldeer.class, "killdeer", id++, Main.instance, 1024, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "eastern_bluebird"),EntityEasternBluebird.class, "eastern_bluebird", id++, Main.instance, 1024, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "northern_mockingbird"), EntityNorthernMockingbird.class, "northern_mockingbird", id++, Main.instance, 1024, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "green_heron"), EntityGreenHeron.class, "green_heron", id++, Main.instance, 1024, 1, true);
		//JUNGLE
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "hoatzin"), EntityHoatzin.class, "hoatzin", id++, Main.instance, 1024, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "turquoisebrowed_motmot"), EntityTurquoiseBrowedMotmot.class, "turquoisebrowed_motmot", id++, Main.instance, 1024, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "kingofsaxony_bird_of_paradise"), EntityKingofSaxony.class, "kingofsaxony_bird_of_paradise", id++, Main.instance, 1024, 1, true);
		//1.6.0
		//EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "sabines_gull"), EntitySabinesGull.class, "sabines_gull", id++, Main.instance, 1024, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "great_grey_owl"), EntityGreatGreyOwl.class, "great_grey_owl", id++, Main.instance, 1024, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "brown_booby"), EntityBrownBooby.class, "brown_booby", id++, Main.instance, 1024, 1, true);
	}
}
