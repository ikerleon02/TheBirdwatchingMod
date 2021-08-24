package com.ikerleon.birdwmod.blocks;

import com.ikerleon.birdwmod.Main;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InitBlocks {

    public static final RingingNetBlock RINGING_NET = new RingingNetBlock();
    public static final BirdFeederBlock BIRD_FEEDER = new BirdFeederBlock();
    public static final LichenBlock LICHEN = new LichenBlock();

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier("birdwmod", "ringingnet"), RINGING_NET);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "ringingnet"), new BlockItem(RINGING_NET, new Item.Settings().group(Main.THE_BIRDWATCHING_MOD)));

        Registry.register(Registry.BLOCK, new Identifier("birdwmod", "birdfeeder"), BIRD_FEEDER);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "birdfeeder"), new BlockItem(BIRD_FEEDER, new Item.Settings().group(Main.THE_BIRDWATCHING_MOD)));

        Registry.register(Registry.BLOCK, new Identifier("birdwmod", "lichen"), LICHEN);
        Registry.register(Registry.ITEM, new Identifier("birdwmod", "lichen"), new BlockItem(LICHEN, new Item.Settings().group(Main.THE_BIRDWATCHING_MOD)));
    }
}
