package com.ikerleon.birdwmod.world.biome;

import com.ikerleon.birdwmod.Main;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import java.util.HashMap;
import java.util.Map;

public class InitBiomes{
    private static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    private static final Map<RegistryKey<Biome>, Biome> BIOMES = new HashMap<>();

    static final Biome.Builder BIOME_TEMPLATE = new Biome.Builder()
            .precipitation(Biome.Precipitation.RAIN)
            .effects(createDefaultBiomeEffects().build());

    static void addBasicFeatures(GenerationSettings.Builder generationSettings) {
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
    }

    public static SpawnSettings.Builder createDefaultSpawnSettings() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        addDefaultCreatureSpawnEntries(spawnSettings);
        addDefaultAmbientSpawnEntries(spawnSettings);
        addDefaultMonsterSpawnEntries(spawnSettings);
        return spawnSettings;
    }

    public static void addDefaultCreatureSpawnEntries(SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.COW, 8, 4, 4));
    }

    public static void addDefaultAmbientSpawnEntries(SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
    }

    public static void addDefaultMonsterSpawnEntries(SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1));
    }

    public static BiomeEffects.Builder createDefaultBiomeEffects() {
        return new BiomeEffects.Builder()
                .waterColor(0x3F76E4)
                .waterFogColor(0x50533)
                .skyColor(getSkyColor(0.2F))
                .fogColor(0xC0D8FF);
    }

    //public static final RegistryKey<Biome> MOUNTAIN_OLD_BIRCH_FOREST = add("mountain_old_birch_forest", MountainOldBirchForestBiome.MOUNTAIN_OLD_BIRCH_FOREST);

    static RegistryKey<Biome> add(String name, Biome biome) {
        RegistryKey<Biome> key = RegistryKey.of(Registry.BIOME_KEY, new Identifier(Main.ModID, name));
        BIOMES.put(key, biome);
        return key;
    }

    public static void register() {
        for (RegistryKey<Biome> key : BIOMES.keySet()) {
            BuiltinRegistries.add(BuiltinRegistries.BIOME, key, BIOMES.get(key));
        }
    }
}
