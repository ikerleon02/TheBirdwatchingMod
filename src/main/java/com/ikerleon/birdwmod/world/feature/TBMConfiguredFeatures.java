package com.ikerleon.birdwmod.world.feature;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.blocks.InitBlocks;
import com.ikerleon.birdwmod.world.feature.placer.FallenTrunkPlacer;
import com.ikerleon.birdwmod.world.feature.placer.NoneFoliagePlacer;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;

import java.util.List;

public class TBMConfiguredFeatures{

    public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> OLDBIRCH = register("oldbirch", Feature.TREE,
            new TreeFeatureConfig.Builder(
            BlockStateProvider.of(Blocks.BIRCH_LOG.getDefaultState()),
            new ForkingTrunkPlacer(4, 2, 2),
            BlockStateProvider.of(Blocks.BIRCH_LEAVES.getDefaultState()),
            new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)),
            new TwoLayersFeatureSize(0, 0, 0)
    ).decorators(ImmutableList.of(TrunkLichenDecorator.INSTANCE)).ignoreVines().build());

    public static final TreeFeatureConfig FALLEN_OAK_TREE_CONFIG = new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG.getDefaultState()), new FallenTrunkPlacer(3, 2, 0), BlockStateProvider.of(Blocks.OAK_LEAVES.getDefaultState()), new NoneFoliagePlacer(), new TwoLayersFeatureSize(0, 0, 0)).build();

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ERICA_BUSH = register("erica_bush", Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(InitBlocks.ERICA_BUSH)), List.of(), 32));;


    static  <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<FC, ?>> register(String id, F feature, FC config) {
        return register(id, new ConfiguredFeature<>(feature, config));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<FC, ?>> register(String id, ConfiguredFeature<FC, F> cf) {
        Identifier realId = new Identifier(Main.ModID, id);
        Preconditions.checkState(!BuiltinRegistries.CONFIGURED_FEATURE.getIds().contains(realId), "Duplicate ID: %s", id);
        return BuiltinRegistries.addCasted(BuiltinRegistries.CONFIGURED_FEATURE, realId.toString(), cf);
    }
}