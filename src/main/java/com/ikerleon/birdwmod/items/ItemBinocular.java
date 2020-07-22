package com.ikerleon.birdwmod.items;

import com.ikerleon.birdwmod.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.options.Option;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.*;
import net.minecraft.world.World;

import static net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry.register;

public class ItemBinocular extends Item {

    private float zoom;
    public boolean zoomed;

    public ItemBinocular(float zoom) {
        super(new Item.Settings().group(Main.THE_BIRDWATCHING_MOD));
        this.zoom=zoom;

        register(this, new Identifier("pulling"), (itemStack, clientWorld, livingEntity) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        stack.setTag(stack.getTag() == null ? new CompoundTag() : stack.getTag());

        if((user instanceof PlayerEntity) ) {
            PlayerEntity playerIn = (PlayerEntity) user;

            if(world.isClient()) {
                if (MinecraftClient.getInstance().options.fov >= 30) {
                    stack.getTag().putDouble("fov", MinecraftClient.getInstance().options.fov);
                }

                if (!(playerIn.getActiveItem().getItem() instanceof ItemBinocular)) {
                    MinecraftClient.getInstance().options.fov = stack.getTag().getDouble("fov");
                    MinecraftClient.getInstance().options.smoothCameraEnabled = false;
                }
            }
        }

        super.usageTick(world, user, stack, remainingUseTicks);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemstack = user.getStackInHand(hand);
        if(world.isClient()) {
            MinecraftClient.getInstance().options.fov = this.zoom;
            MinecraftClient.getInstance().options.smoothCameraEnabled = true;
        }
        zoomed = true;
        user.setCurrentHand(hand);

        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, itemstack);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity) {
            zoomed = false;
            if(world.isClient()) {
                if (stack.getTag().getDouble("fov") != 0) {
                    MinecraftClient.getInstance().options.fov = stack.getTag().getDouble("fov");
                }
                else {
                    MinecraftClient.getInstance().options.fov = 70;
                }
                MinecraftClient.getInstance().options.smoothCameraEnabled = false;
            }
        }

        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }
}
