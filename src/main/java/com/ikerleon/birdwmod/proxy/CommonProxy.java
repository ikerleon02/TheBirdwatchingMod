package com.ikerleon.birdwmod.proxy;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.entity.europe.EntityEurasianBullfinch;
import com.ikerleon.birdwmod.entity.europe.EntityRedFlankedBluetail;
import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.entity.northamerica.EntityEasternBluebird;
import com.ikerleon.birdwmod.entity.northamerica.EntityGreenHeron;
import com.ikerleon.birdwmod.entity.northamerica.EntityKilldeer;
import com.ikerleon.birdwmod.entity.northamerica.EntityNorthernMockingbird;
import com.ikerleon.birdwmod.init.Birds;
import com.ikerleon.birdwmod.init.BirdwmodCrafting;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import com.ikerleon.birdwmod.util.BiomeDictionaryUtil;

import com.ikerleon.birdwmod.util.handlers.GuiHandler;
import com.ikerleon.birdwmod.util.handlers.SoundHandler;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy {

	protected int GlobalSpawnProb = 3/4;

	public enum GUI
	{
		BIRD_BOOK;

		public final int id;

		GUI()
		{
			this.id = getNextId();
		}

		static int idCounter = 0;

		private static int getNextId()
		{
			return idCounter++;
		}
	}

	public void preInit(FMLPreInitializationEvent e) {
		SoundHandler.registerSounds();
		Birds.init();
	}
	
	public void init(FMLInitializationEvent event) {

		OreDictionary.registerOre("feather", BirdwmodItems.EASTERNBLUEBIRDFEATHER_FEMALE);
		OreDictionary.registerOre("feather", BirdwmodItems.EASTERNBLUEBIRDFEATHER_MALE);
		OreDictionary.registerOre("feather", BirdwmodItems.EURASIANBULLFINCHDFEATHER_FEMALE);
		OreDictionary.registerOre("feather", BirdwmodItems.EURASIANBULLFINCHDFEATHER_MALE);
		OreDictionary.registerOre("feather", BirdwmodItems.GREENHERONFEATHER);
		OreDictionary.registerOre("feather", BirdwmodItems.KILLDEERFEATHER);
		OreDictionary.registerOre("feather", BirdwmodItems.NORTHERNMOCKINGBIRDFEATHER);
		OreDictionary.registerOre("feather", BirdwmodItems.REDFLANCKEDBLUETAILFEATHER_FEMALE);
		OreDictionary.registerOre("feather", BirdwmodItems.REDFLANCKEDBLUETAILFEATHER_MALE);
		OreDictionary.registerOre("feather", BirdwmodItems.REDNECKEDNIGHTJARFEATHER);
		OreDictionary.registerOre("feather", BirdwmodItems.STELLERSEIDERFEATHER_FEMALE);
		OreDictionary.registerOre("feather", BirdwmodItems.STELLERSEIDERFEATHER_MALE);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());

		//EUROPE
		EntityRegistry.addSpawn(EntityRedNeckedNightjar.class, 15 * GlobalSpawnProb, 1, 2, EnumCreatureType.CREATURE, BiomeDictionaryUtil.FusionBiomes(BiomeDictionaryUtil.getBiomesFromTypes(BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.HOT), BiomeDictionaryUtil.getBiomesFromType(BiomeDictionary.Type.MESA)));
		EntityRegistry.addSpawn(EntityEurasianBullfinch.class, 20 * GlobalSpawnProb, 1, 4, EnumCreatureType.CREATURE, BiomeDictionaryUtil.getBiomesFromType(BiomeDictionary.Type.FOREST));
		EntityRegistry.addSpawn(EntityRedFlankedBluetail.class, 20 * GlobalSpawnProb, 1, 2, EnumCreatureType.CREATURE, BiomeDictionaryUtil.getBiomesFromType(BiomeDictionary.Type.CONIFEROUS));
		EntityRegistry.addSpawn(EntityStellersEider.class, 15 * GlobalSpawnProb, 1, 5, EnumCreatureType.CREATURE, BiomeDictionaryUtil.FusionBiomes(BiomeDictionaryUtil.getBiomesFromTypes(BiomeDictionary.Type.BEACH, BiomeDictionary.Type.SNOWY), BiomeDictionaryUtil.getBiomesFromTypes(BiomeDictionary.Type.WATER, BiomeDictionary.Type.SNOWY)));
		//NORTH AMERICA
		EntityRegistry.addSpawn(EntityEasternBluebird.class, 20 * GlobalSpawnProb, 1, 4, EnumCreatureType.CREATURE, BiomeDictionaryUtil.FusionBiomes(BiomeDictionaryUtil.getBiomesFromType(BiomeDictionary.Type.PLAINS), new Biome[] {Biomes.FOREST}));
		EntityRegistry.addSpawn(EntityKilldeer.class, 15 * GlobalSpawnProb, 1, 4, EnumCreatureType.CREATURE, BiomeDictionaryUtil.getBiomesFromType(BiomeDictionary.Type.PLAINS));
		EntityRegistry.addSpawn(EntityNorthernMockingbird.class, 20 * GlobalSpawnProb, 1, 2, EnumCreatureType.CREATURE, BiomeDictionaryUtil.FusionBiomes(BiomeDictionaryUtil.getBiomesFromType(BiomeDictionary.Type.PLAINS), new Biome[] {Biomes.FOREST, Biomes.BIRCH_FOREST}));
		EntityRegistry.addSpawn(EntityGreenHeron.class, 15 * GlobalSpawnProb, 1, 2, EnumCreatureType.CREATURE, BiomeDictionaryUtil.FusionBiomes(BiomeDictionaryUtil.getBiomesFromTypes(BiomeDictionary.Type.RIVER, BiomeDictionary.Type.HOT), new Biome[] {Biomes.RIVER, Biomes.SWAMPLAND}));

		BirdwmodCrafting.init(event);
	}

	public void postInit(FMLPostInitializationEvent e) {}
	
	public void registerRenders(){}
}
