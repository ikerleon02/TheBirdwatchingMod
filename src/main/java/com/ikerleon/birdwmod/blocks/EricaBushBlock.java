package com.ikerleon.birdwmod.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;


public class EricaBushBlock extends PlantBlock {
    public EricaBushBlock() {
        super(FabricBlockSettings.of(Material.PLANT).noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH));
    }
}
