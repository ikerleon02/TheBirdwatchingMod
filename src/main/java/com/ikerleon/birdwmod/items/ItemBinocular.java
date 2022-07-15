package com.ikerleon.birdwmod.items;

import com.ikerleon.birdwmod.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ItemBinocular extends Item {

    public final float zoom;

    public ItemBinocular(float zoom) {
        super(new Item.Settings().group(Main.THE_BIRDWATCHING_MOD));
        this.zoom=zoom;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemstack = user.getStackInHand(hand);

        user.setCurrentHand(hand);

        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, itemstack);
    }

    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }
}
