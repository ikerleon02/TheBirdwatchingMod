package com.ikerleon.birdwmod.items;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import net.minecraft.item.ItemFood;

public class ItemMeat extends ItemFood {

    public ItemMeat(String name, int amount, boolean isWolfFood) {
        super(amount, 0.6F, isWolfFood);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        BirdwmodItems.ITEMS.add(this);
        this.setCreativeTab(Main.BIRDWATCHINGMOD);
    }
}
