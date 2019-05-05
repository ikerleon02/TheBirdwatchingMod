package com.ikerleon.birdwmod.items;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import net.minecraft.item.Item;

public class ItemFeather extends Item {

    public ItemFeather(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        BirdwmodItems.ITEMS.add(this);
        this.setCreativeTab(Main.BIRDWATCHINGMOD);
    }
}
