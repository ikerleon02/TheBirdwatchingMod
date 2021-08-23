package com.ikerleon.birdwmod.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class TrunkLichenDecorator extends TreeDecorator {

    public static final net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator INSTANCE = new net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator();

    public static final Codec<net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator> CODEC = Codec.unit(() -> {
        return INSTANCE;
    });

    protected TreeDecoratorType<?> getType() {
        return TreeDecoratorType.TRUNK_VINE;
    }

    public void generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, List<BlockPos> logPositions, List<BlockPos> leavesPositions) {
        logPositions.forEach((pos) -> {
            BlockPos blockPos4;
            if (random.nextInt(3) > 0) {
                blockPos4 = pos.west();
                if (Feature.isAir(world, blockPos4)) {
                    placeLichen(replacer, blockPos4, VineBlock.EAST);
                }
            }

            if (random.nextInt(3) > 0) {
                blockPos4 = pos.east();
                if (Feature.isAir(world, blockPos4)) {
                    placeLichen(replacer, blockPos4, VineBlock.WEST);
                }
            }

            if (random.nextInt(3) > 0) {
                blockPos4 = pos.north();
                if (Feature.isAir(world, blockPos4)) {
                    placeLichen(replacer, blockPos4, VineBlock.SOUTH);
                }
            }

            if (random.nextInt(3) > 0) {
                blockPos4 = pos.south();
                if (Feature.isAir(world, blockPos4)) {
                    placeLichen(replacer, blockPos4, VineBlock.NORTH);
                }
            }

        });
    }

    protected static void placeLichen(BiConsumer<BlockPos, BlockState> replacer, BlockPos pos, BooleanProperty facing) {
        replacer.accept(pos, (BlockState) Blocks.VINE.getDefaultState().with(facing, true));
    }
}
