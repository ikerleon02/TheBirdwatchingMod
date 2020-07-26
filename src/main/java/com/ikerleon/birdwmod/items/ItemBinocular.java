package com.ikerleon.birdwmod.items;

import com.ikerleon.birdwmod.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.options.Option;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.*;
import net.minecraft.world.World;

import static net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry.register;

public class ItemBinocular extends Item {

    public final float zoom;

    public ItemBinocular(float zoom) {
        super(new Item.Settings().group(Main.THE_BIRDWATCHING_MOD));
        this.zoom=zoom;

        register(this, new Identifier("pulling"), (itemStack, clientWorld, livingEntity) -> {
            return livingEntity != null && MinecraftClient.getInstance().options.perspective == 0 && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
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
