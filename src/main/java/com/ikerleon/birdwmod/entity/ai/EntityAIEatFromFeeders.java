package com.ikerleon.birdwmod.entity.ai;

import com.ikerleon.birdwmod.blocks.BlockBirdfeeder;
import com.ikerleon.birdwmod.entity.EntityBird;
import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.entity.northamerica.EntityGreenHeron;
import com.ikerleon.birdwmod.entity.northamerica.EntityNorthernMockingbird;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EntityAIEatFromFeeders extends EntityAIBase {

    private static final int RADIUS = 8;

    private BlockPos targetBlock = null;
    private final EntityBird entity;
    private final BlockSorter targetSorter;
    private int feedingTicks;

    public EntityAIEatFromFeeders(EntityBird entity) {
        super();
        this.entity = entity;
        this.targetSorter = new BlockSorter(entity);
        this.setMutexBits(0);
    }

    @Override
    public boolean shouldExecute() {
        if(!entity.isSleeping()) {
            return entity.goesToFeeders();
        }
        else{
            return false;
        }
    }

    private void resetTarget() {
        this.targetBlock = null;
        List<BlockPos> allBlocks = new ArrayList<>();
        for (BlockPos pos : BlockPos.getAllInBox(this.entity.getPosition().add(-RADIUS, -RADIUS, -RADIUS), this.entity.getPosition().add(RADIUS, RADIUS, RADIUS))) {
            Block block = this.entity.world.getBlockState(pos).getBlock();
            if (block instanceof BlockBirdfeeder) {
                BlockBirdfeeder feeder = (BlockBirdfeeder) block;
                if (this.entity.world.getBlockState(pos).getValue(BlockBirdfeeder.FILLED)) {
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
    public boolean shouldContinueExecuting() {
        return !this.entity.isMovementBlocked() && targetBlock != null && this.entity.world.getBlockState(targetBlock).getBlock() instanceof BlockBirdfeeder;
    }

    public void resetTask(){
        targetBlock = null;
        resetTarget();
    }

    @Override
    public void updateTask() {
        if (this.targetBlock != null) {
            Block entity = this.entity.world.getBlockState(this.targetBlock).getBlock();
            this.entity.getNavigator().tryMoveToXYZ(this.targetBlock.getX(), this.targetBlock.getY() + 1, this.targetBlock.getZ(), 1.0D);
            if (entity instanceof BlockBirdfeeder) {
                BlockBirdfeeder feeder = (BlockBirdfeeder) entity;
                double distance = this.entity.getDistance(this.targetBlock.getX(), this.targetBlock.getY(), this.targetBlock.getZ());
                if (distance < Math.max(this.entity.getEntityBoundingBox().getAverageEdgeLength() * 2.5, 2.5F)) {
                    if (this.feedingTicks < 30 && this.entity.world.getBlockState(targetBlock).getValue(BlockBirdfeeder.FILLED)) {
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
            double deltaX = this.entity.posX - (pos.getX() + 0.5);
            double deltaY = this.entity.posY + this.entity.getEyeHeight() - (pos.getY() + 0.5);
            double deltaZ = this.entity.posZ - (pos.getZ() + 0.5);
            return deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ;
        }
    }
}
