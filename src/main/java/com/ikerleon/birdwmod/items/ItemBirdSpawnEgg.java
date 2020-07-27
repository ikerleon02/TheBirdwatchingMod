package com.ikerleon.birdwmod.items;

import com.ikerleon.birdwmod.Main;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Objects;

public class ItemBirdSpawnEgg extends Item {

    public String ID;
    public EntityType<?> entityType;

    public ItemBirdSpawnEgg(EntityType<?> type) {
        super(new Item.Settings().group(Main.THE_BIRDWATCHING_MOD));
        this.entityType = type;
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            ItemStack itemStack = context.getStack();
            BlockPos blockPos = context.getBlockPos();
            Direction direction = context.getSide();
            BlockState blockState = world.getBlockState(blockPos);
            BlockPos blockPos3;

            if (blockState.getCollisionShape(world, blockPos).isEmpty()) {
                blockPos3 = blockPos;
            } else {
                blockPos3 = blockPos.offset(direction);
            }

            EntityType<?> entityType = this.entityType;
            if (entityType.spawnFromItemStack(world, itemStack, context.getPlayer(), blockPos3, SpawnReason.SPAWN_EGG, true, !Objects.equals(blockPos, blockPos3) && direction == Direction.UP) != null) {
                itemStack.decrement(1);
            }

            return ActionResult.CONSUME;
        }
    }
}
