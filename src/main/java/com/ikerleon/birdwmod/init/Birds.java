package com.ikerleon.birdwmod.init;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.entity.europe.EntityEurasianBullfinch;
import com.ikerleon.birdwmod.entity.europe.EntityRedFlankedBluetail;
import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.entity.northamerica.EntityEasternBluebird;
import com.ikerleon.birdwmod.entity.northamerica.EntityGreenHeron;
import com.ikerleon.birdwmod.entity.northamerica.EntityKilldeer;

import com.ikerleon.birdwmod.entity.northamerica.EntityNorthernMockingbird;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class Birds {
	private static int id = 0;
	
	public static void init() {
		//EUROPE
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "rednecked_nightjar"),EntityRedNeckedNightjar.class, "rednecked_nightjar", id++, Main.instance, 1024, 1, true, 0xada088, 0xa38347);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "eurasian_bullfinch"), EntityEurasianBullfinch.class, "eurasian_bullfinch", id++, Main.instance, 1024, 1, true, 0xdd1f1f, 0x000000);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "redflanked_bluetail"),EntityRedFlankedBluetail.class, "redflanked_bluetail", id++, Main.instance, 1024, 1, true, 0x103b7f, 0xa3843e);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "stellers_eider"), EntityStellersEider.class, "stellers_eider", id++, Main.instance, 1024, 1, true, 0xf7f7f7, 0xfc9e3a);
		//AMERICA
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "killdeer"),EntityKilldeer.class, "killdeer", id++, Main.instance, 1024, 1, true, 0xa87500, 0xf2f2f2);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "eastern_bluebird"),EntityEasternBluebird.class, "eastern_bluebird", id++, Main.instance, 1024, 1, true, 0x2176ff, 0xdce5f4);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "northern_mockingbird"), EntityNorthernMockingbird.class, "northern_mockingbird", id++, Main.instance, 1024, 1, true, 0xa09d95, 0xe2e2e0);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, "green_heron"), EntityGreenHeron.class, "green_heron", id++, Main.instance, 1024, 1, true, 0x9b360d, 0x50656d);
	}
}
