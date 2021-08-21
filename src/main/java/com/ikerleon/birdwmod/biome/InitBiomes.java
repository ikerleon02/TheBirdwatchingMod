package com.ikerleon.birdwmod.biome;

import com.ikerleon.birdwmod.Main;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import java.util.HashMap;
import java.util.Map;

public class InitBiomes {
    private static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    private static final Map<Identifier, Biome> BIOMES = new HashMap<>();

    /*static final Biome BIOME_TEMPLATE = new Biome(Biome.create()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
            .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DUNGEONS, MINEABLES, ORES, DISKS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER)
            .addStructureFeature(ConfiguredStructureFeatures.STRONGHOLD)
            .addStructureFeature(ConfiguredStructureFeatures.MINESHAFT)
            .precipitation(Biome.Precipitation.RAIN)
            .effects(createDefaultBiomeEffects()));*/

    public static BiomeEffects.Builder createDefaultBiomeEffects() {
        return new BiomeEffects.Builder()
                .waterColor(0x3F76E4)
                .waterFogColor(0x50533)
                .skyColor(getSkyColor(0.2F))
                .fogColor(0xC0D8FF);
    }

    //protected static final RegistryKey<Biome> ARID_HIGHLANDS = add("arid_highlands", AridHighlandsBiomes.ARID_HIGHLANDS);

    static RegistryKey<Biome> add(String name, Biome biome) {
        Identifier id = new Identifier(Main.ModID, name);
        BIOMES.put(id, biome);
        return RegistryKey.of(Registry.BIOME_KEY, id);
    }

    public static void register() {
        for (Identifier id : BIOMES.keySet()) {
            BuiltinRegistries.add(BuiltinRegistries.BIOME, id, BIOMES.get(id));
        }
    }
}
