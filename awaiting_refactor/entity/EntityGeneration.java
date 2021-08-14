package com.ikerleon.birdwmod.entity;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

import java.util.List;

public class EntityGeneration {

    public static void init() {
        for (Biome biome : Registry.BIOME) {
            List<Biome.SpawnEntry> spawnList = biome.getEntitySpawnList(SpawnGroup.CREATURE);

            //EUROPE
            if (biome.getCategory().equals(Biome.Category.SAVANNA) || biome.getCategory().equals(Biome.Category.MESA)) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.RED_NECKED_NIGHTJAR_ENTITY, 15, 1, 2));
            }
            if (biome.getCategory().equals(Biome.Category.FOREST) && biome.getTemperature() <= 0.6) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.EURASIAN_BULLFINCH_ENTITY, 20, 1, 4));
            }
            if (biome.getCategory().equals(Biome.Category.TAIGA) && biome.getTemperature() <= 0.4) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.RED_FLANKED_BLUETAIL_ENTITY, 15, 1, 2));
            }
            if ((biome.getCategory().equals(Biome.Category.BEACH) && biome.getTemperature() <= 0.1) || (biome.getCategory().equals(Biome.Category.OCEAN) && biome.getTemperature() <= 0.1)) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.STELLERS_EIDER_ENTITY, 15, 1, 5));
            }

            //NORTH AMERICA
            if (biome.getCategory().equals(Biome.Category.PLAINS) || biome.getCategory().equals(Biome.Category.FOREST) && biome.getTemperature() >= 0.4) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.EASTERN_BLUEBIRD_ENTITY, 20, 1, 4));
            }
            if (biome.getCategory().equals(Biome.Category.PLAINS) && biome.getTemperature() >= 0.4) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.KILLDEER_ENTITY, 15, 1, 4));
            }
            if (biome.getCategory().equals(Biome.Category.PLAINS) || biome.getCategory().equals(Biome.Category.FOREST) && biome.getTemperature() >= 0.4) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.NORTHERN_MOCKINGBIRD_ENTITY, 20, 1, 4));
            }
            if (biome.getCategory().equals(Biome.Category.SWAMP) || biome.getCategory().equals(Biome.Category.RIVER) && biome.getTemperature() >= 0.4) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.GREEN_HERON_ENTITY, 15, 1, 2));
            }

            //JUNGLE
            if (biome.getCategory().equals(Biome.Category.SWAMP) || biome.getCategory().equals(Biome.Category.JUNGLE) && biome.getTemperature() >= 0.4) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.HOATZIN_ENTITY, 15, 1, 2));
            }
            if (biome.getCategory().equals(Biome.Category.JUNGLE) && biome.getTemperature() >= 0.4) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.TURQUOISE_BROWED_MOTMOT_ENTITY, 25, 1, 5));
            }
            if (biome.getCategory().equals(Biome.Category.JUNGLE) && biome.getTemperature() >= 0.4) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.KING_OF_SAXONY_ENTITY, 20, 1, 2));
            }

            //1.6.0
            if (biome.getCategory().equals(Biome.Category.FOREST) || biome.getCategory().equals(Biome.Category.TAIGA) && biome.getTemperature() <= 0.3) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.GREAT_GREY_OWL_ENTITY, 20, 1, 2));
            }
            if ((biome.getCategory().equals(Biome.Category.BEACH) && biome.getTemperature() >= 0.3) || (biome.getCategory().equals(Biome.Category.OCEAN) && biome.getTemperature() >= 0.3)) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.BROWN_BOOBY_ENTITY, 15, 1, 5));
            }

            //1.7.0
            if ((biome.getCategory().equals(Biome.Category.BEACH) && biome.getTemperature() <= 0.1) || (biome.getCategory().equals(Biome.Category.OCEAN))) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.RAZORBILL_ENTITY, 20, 1, 5));
            }
            if ((biome.getCategory().equals(Biome.Category.PLAINS) && biome.getTemperature() <= 0.1) || (biome.getCategory().equals(Biome.Category.OCEAN))) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.SABINES_GULL_ENTITY, 15, 1, 8));
            }
            if (biome.getCategory().equals(Biome.Category.EXTREME_HILLS) && biome.getTemperature() <= 0.4) {
                spawnList.add(new Biome.SpawnEntry(InitEntities.KING_OF_SAXONY_ENTITY, 20, 1, 3));
            }
        }
    }
}
