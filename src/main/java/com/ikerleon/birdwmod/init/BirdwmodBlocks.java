package com.ikerleon.birdwmod.init;

import com.ikerleon.birdwmod.blocks.BlockBirdfeeder;
import com.ikerleon.birdwmod.blocks.BlockRingingNet;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class BirdwmodBlocks {

    public static final List<Block> BLOCKS = new ArrayList();

    public static final Block BIRD_FEEDER = new BlockBirdfeeder(Material.WOOD, "birdfeeder");
    public static final Block RINGING_NET = new BlockRingingNet(Material.WEB, "ringingnet");

    public static void registerBlocks() {
        ForgeRegistries.BLOCKS.registerAll(BirdwmodBlocks.BLOCKS.toArray(new Block[BirdwmodBlocks.BLOCKS.size()]));
    }

    public static void registerRenders(){
        for(Block block : BirdwmodBlocks.BLOCKS) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
    }
}
