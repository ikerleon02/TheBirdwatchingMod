package com.ikerleon.birdwmod.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.treedecorator.*;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class TBMTreeDecoratorType<P extends TreeDecorator> {
    public static final TreeDecoratorType<TrunkLichenDecorator> TRUNK_LICHEN;
    private final Codec<P> codec;

    private TBMTreeDecoratorType(Codec<P> codec) {
        this.codec = codec;
    }

    public Codec<P> getCodec() {
        return this.codec;
    }

    static {
        TRUNK_LICHEN = TreeDecoratorType.register("trunk_lichen", TrunkLichenDecorator.CODEC);
    }
}

