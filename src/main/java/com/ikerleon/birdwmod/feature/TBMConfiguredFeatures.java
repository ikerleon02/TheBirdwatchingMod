package com.ikerleon.birdwmod.feature;

import com.google.common.collect.ImmutableList;
import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.feature.placer.FallenTrunkPlacer;
import com.ikerleon.birdwmod.feature.placer.NoneFoliagePlacer;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.decorator.ConfiguredDecorator;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;

public class TBMConfiguredFeatures{

    public static final ConfiguredFeature<TreeFeatureConfig, ?> OLDBIRCH = register("oldbirch", Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()), new ForkingTrunkPlacer(4, 2, 2), new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()), new SimpleBlockStateProvider(Blocks.BIRCH_SAPLING.getDefaultState()), new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build()));
    public static final TreeFeatureConfig FALLEN_OAK_TREE_CONFIG = new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()), new FallenTrunkPlacer(2, 1, 0), new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()), new NoneFoliagePlacer(), new TwoLayersFeatureSize(0, 0, 0)).build();

    public static final ConfiguredDecorator<HeightmapDecoratorConfig> HEIGHTMAP = Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING));
    public static final ConfiguredDecorator<?> SQUARE_HEIGHTMAP =(ConfiguredDecorator)HEIGHTMAP.spreadHorizontally();

    public static final ConfiguredFeature<?, ?> MOUNTAIN_OLD_BIRCH_TREES = register("mountain_old_birch_trees", Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    ImmutableList.of(
                            OLDBIRCH.withChance(0.6F),
                            Feature.TREE.configure(TBMConfiguredFeatures.FALLEN_OAK_TREE_CONFIG).withChance(0.4F)
                    ), TBMConfiguredFeatures.OLDBIRCH))
            .decorate(TBMConfiguredFeatures.SQUARE_HEIGHTMAP)
            .decorate(Decorator.COUNT.configure(new CountConfig(20))));

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Main.ModID, id), feature);
    }
}