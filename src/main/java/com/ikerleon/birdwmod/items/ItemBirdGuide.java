package com.ikerleon.birdwmod.items;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.client.gui.GUIBirdGuide;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ItemBirdGuide extends Item {
    public ItemBirdGuide(){
        super(new Item.Settings().group(Main.THE_BIRDWATCHING_MOD).maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemstack = user.getStackInHand(hand);

        if (world.isClient()) {
            MinecraftClient.getInstance().setScreen(new GUIBirdGuide());
        }
        return new TypedActionResult<ItemStack>(ActionResult.PASS, itemstack);
    }
}
