package com.ikerleon.birdwmod.items;

import com.ikerleon.birdwmod.Main;
import net.minecraft.item.Item;

public class ItemBirdwmodBasic extends Item {
    public ItemBirdwmodBasic() {
        super(new Item.Settings().group(Main.THE_BIRDWATCHING_MOD));
    }

    public ItemBirdwmodBasic(Item.Settings settings) {
        super(settings.group(Main.THE_BIRDWATCHING_MOD));
    }
}
