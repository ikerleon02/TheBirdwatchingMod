package com.ikerleon.birdwmod.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.soggymustache.bookworm.util.SpawnData;

public class BiomeDictionaryUtil {
	
	public static Biome[] getBiomesFromTypes(Type type1, Type type2) {
		
		Biome[] biomesArray = SpawnData.getBiomesOfType(type1);
		List<Biome> biomesList = new ArrayList<Biome>();

		for(int i = 0; i < biomesArray.length; i++)
		{
		    if(BiomeDictionary.hasType(biomesArray[i], type2))
		    {
			    biomesList.add(biomesArray[i]);
		    }
		}
		
        Biome[] biomesOutput = new Biome[biomesList.size()];
		biomesOutput=biomesList.toArray(biomesOutput);
		
		return biomesOutput;
	 }

    public static Biome[] getBiomesFromType(Type type) {
		
		Biome[] biomesArray = SpawnData.getBiomesOfType(type);
		List<Biome> biomesList = new ArrayList<Biome>();

		for(int i = 0; i < biomesArray.length; i++)
		{
			biomesList.add(biomesArray[i]);
		}
		
        Biome[] biomesOutput = new Biome[biomesList.size()];
		biomesOutput=biomesList.toArray(biomesOutput);
		
		return biomesOutput;
	}
    
	public static Biome[] FusionBiomes(Biome[] Biomes1, Biome[] Biomes2) {
		List<Biome> biomesList = new ArrayList<Biome>();
		
		for(int i = 0; i < Biomes2.length; i++)
		{
			 biomesList.add(Biomes2[i]);
		}
		
		for(int i = 0; i < Biomes1.length; i++)
		{
			 biomesList.add(Biomes1[i]);
		}
		
        Biome[] biomesOutput = new Biome[biomesList.size()];
		biomesOutput=biomesList.toArray(biomesOutput);
		
		return biomesOutput;
	 }
}
