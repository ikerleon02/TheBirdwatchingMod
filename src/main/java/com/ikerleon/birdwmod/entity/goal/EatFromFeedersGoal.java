package com.ikerleon.birdwmod.entity.goal;

import com.ikerleon.birdwmod.blocks.BirdFeederBlock;
import com.ikerleon.birdwmod.entity.BirdEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EatFromFeedersGoal extends Goal {

    private static final int RADIUS = 8;

    private BlockPos targetBlock = null;
    private final BirdEntity entity;
    private final BlockSorter targetSorter;
    private int feedingTicks;

    public EatFromFeedersGoal(BirdEntity entity) {
        this.entity = entity;
        this.targetSorter = new BlockSorter(entity);
    }

    private void resetTarget() {
        this.targetBlock = null;
        List<BlockPos> allBlocks = new ArrayList<>();
        for (BlockPos pos : BlockPos.iterate(new BlockPos(this.entity.getPos().add(-RADIUS, -RADIUS, -RADIUS)), new BlockPos(this.entity.getPos().add(RADIUS, RADIUS, RADIUS)))) {
            Block block = this.entity.world.getBlockState(pos).getBlock();
            if (block instanceof BirdFeederBlock) {
                BirdFeederBlock feeder = (BirdFeederBlock) block;
                if (this.entity.world.getBlockState(pos).get(BirdFeederBlock.FILLED)) {
                    allBlocks.add(pos);
                }
            }
        }
        if (!allBlocks.isEmpty()) {
            allBlocks.sort(this.targetSorter);
            this.targetBlock = allBlocks.get(0);
        }
    }

    @Override
    public boolean shouldContinue() {
        if (entity.isSleeping()) {
            return false;
        } else {
            return !this.entity.canMoveVoluntarily() && targetBlock != null && this.entity.world.getBlockState(targetBlock).getBlock() instanceof BirdFeederBlock;
        }
    }

    public void resetTask(){
        targetBlock = null;
        resetTarget();
    }

    @Override
    public void tick() {
        if (this.targetBlock != null) {
            Block entity = this.entity.world.getBlockState(this.targetBlock).getBlock();
            this.entity.getNavigation().startMovingTo(this.targetBlock.getX(), this.targetBlock.getY() + 1, this.targetBlock.getZ(), 0.75D);
            if (entity instanceof BirdFeederBlock) {
                BirdFeederBlock feeder = (BirdFeederBlock) entity;
                double distance = this.entity.squaredDistanceTo(this.targetBlock.getX(), this.targetBlock.getY(), this.targetBlock.getZ());
                if (distance < Math.max(this.entity.getBoundingBox().getAverageSideLength() * 2.5, 2.5F)) {
                    if (this.feedingTicks < 30 && this.entity.world.getBlockState(targetBlock).get(BirdFeederBlock.FILLED)) {
                        this.feedingTicks++;
                        this.entity.setHealth(Math.min(this.entity.getMaxHealth(), (int) (this.entity.getHealth() + this.feedingTicks / 4)));
                    } else {
                        this.feedingTicks = 0;
                        this.targetBlock = null;
                        this.resetTask();
                        return;
                    }
                } else {
                    this.feedingTicks = 0;
                    this.targetBlock = null;
                    this.resetTask();
                    return;
                }
            }
        }
        else{
            this.resetTask();
        }
    }

    @Override
    public boolean canStart() {
        if(!entity.isSleeping()) {
            return entity.goesToFeeders() && !entity.isBaby();
        }
        else{
            return false;
        }
    }

    public class BlockSorter implements Comparator<BlockPos> {
        private final Entity entity;

        public BlockSorter(Entity entity) {
            this.entity = entity;
        }

        @Override
        public int compare(BlockPos pos1, BlockPos pos2) {
            double distance1 = this.getDistance(pos1);
            double distance2 = this.getDistance(pos2);
            return Double.compare(distance1, distance2);
        }

        private double getDistance(BlockPos pos) {
            double deltaX = this.entity.trackedX - (pos.getX() + 0.5);
            double deltaY = this.entity.trackedY + this.entity.getEyeHeight(EntityPose.STANDING) - (pos.getY() + 0.5);
            double deltaZ = this.entity.trackedZ - (pos.getZ() + 0.5);
            return deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ;
        }
    }
}

