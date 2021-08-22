package com.ikerleon.birdwmod.biome;

import com.ikerleon.birdwmod.Main;
import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.TerraformBiomeBuilder;
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

import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.*;

public class InitBiomes{
    private static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    private static final Map<Identifier, Biome> BIOMES = new HashMap<>();

    static final BiomeTemplate BIOME_TEMPLATE = new BiomeTemplate(TerraformBiomeBuilder.create()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
            .addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DUNGEONS, MINEABLES, ORES, DISKS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER)
            .addStructureFeature(ConfiguredStructureFeatures.STRONGHOLD)
            .addStructureFeature(ConfiguredStructureFeatures.MINESHAFT)
            .precipitation(Biome.Precipitation.RAIN)
            .effects(createDefaultBiomeEffects()));

    public static BiomeEffects.Builder createDefaultBiomeEffects() {
        return new BiomeEffects.Builder()
                .skyColor(getSkyColor(0.2F));
    }

    protected static final RegistryKey<Biome> MOUNTAIN_OLD_BIRCH_FOREST = add("mountain_old_birch_forest", MountainOldBirchForestBiome.MOUNTAIN_OLD_BIRCH_FOREST);

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
