package com.ikerleon.birdwmod.world.feature.placer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.Random;
import java.util.function.BiConsumer;

public class NoneFoliagePlacer extends FoliagePlacer {
    public static final Codec<NoneFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> fillFoliagePlacerFields(instance).apply(instance, (uniformIntDistribution, uniformIntDistribution2) -> new NoneFoliagePlacer()));

    public NoneFoliagePlacer() {
        super(ConstantIntProvider.create(0), ConstantIntProvider.create(0));
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return TBMPlacerTypes.NONE_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, net.minecraft.util.math.random.Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {

    }

    @Override
    public int getRandomHeight(net.minecraft.util.math.random.Random random, int trunkHeight, TreeFeatureConfig config) {
        return 0;
    }

    @Override
    protected boolean isInvalidForLeaves(net.minecraft.util.math.random.Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
