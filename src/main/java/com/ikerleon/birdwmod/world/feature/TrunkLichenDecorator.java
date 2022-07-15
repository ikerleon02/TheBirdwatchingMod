package com.ikerleon.birdwmod.world.feature;

import com.ikerleon.birdwmod.blocks.InitBlocks;
import com.ikerleon.birdwmod.blocks.LichenBlock;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
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

    public static final TrunkLichenDecorator INSTANCE = new TrunkLichenDecorator();

    public static final Codec<TrunkLichenDecorator> CODEC = Codec.unit(() -> {
        return INSTANCE;
    });

    protected TreeDecoratorType<?> getType() {
        //TODO
        return null;//TBMTreeDecoratorType.TRUNK_LICHEN;
    }

    @Override
    public void generate(Generator generator) {
        /*generator.getLogPositions().forEach((pos) -> {
            BlockPos blockPos4;
            if (generator.getRandom().nextInt(3) > 0) {
                blockPos4 = pos.west();
                if (Feature.isExposedToAir(world, blockPos4)) {
                    placeLichen(replacer, blockPos4, LichenBlock.EAST);
                }
            }

            if (random.nextInt(3) > 0) {
                blockPos4 = pos.east();
                if (Feature.isAir(world, blockPos4)) {
                    placeLichen(replacer, blockPos4, LichenBlock.WEST);
                }
            }

            if (random.nextInt(3) > 0) {
                blockPos4 = pos.north();
                if (Feature.isAir(world, blockPos4)) {
                    placeLichen(replacer, blockPos4, LichenBlock.SOUTH);
                }
            }

            if (random.nextInt(3) > 0) {
                blockPos4 = pos.south();
                if (Feature.isAir(world, blockPos4)) {
                    placeLichen(replacer, blockPos4, LichenBlock.NORTH);
                }
            }

        });*/
    }

    protected static void placeLichen(BiConsumer<BlockPos, BlockState> replacer, BlockPos pos, BooleanProperty facing) {
        replacer.accept(pos, (BlockState) InitBlocks.LICHEN.getDefaultState().with(facing, true));
    }
}
