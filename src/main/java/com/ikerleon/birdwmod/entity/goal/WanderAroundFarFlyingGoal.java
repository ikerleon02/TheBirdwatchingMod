package com.ikerleon.birdwmod.entity.goal;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.ai.TargetFinder;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.mob.MobEntityWithAi;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.Iterator;

public class WanderAroundFarFlyingGoal extends WanderAroundFarGoal
{
    public WanderAroundFarFlyingGoal(MobEntityWithAi p_i47413_1_, double p_i47413_2_)
    {
        super(p_i47413_1_, p_i47413_2_);
    }

    protected Vec3d getWanderTarget()
    {
        Vec3d vec3d = null;
        if ((this.mob.isTouchingWater())) {
            vec3d = TargetFinder.findGroundTarget(this.mob, 15, 15);
        }
        if (this.mob.getRandom().nextFloat() >= this.probability) {
            vec3d = getTreePos();
        }
        return vec3d == null ? super.getWanderTarget() : vec3d;
    }

    private Vec3d getTreePos()
    {
        BlockPos blockpos = new BlockPos(this.mob.getPos());
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
        BlockPos.Mutable blockpos$mutableblockpos1 = new BlockPos.Mutable();
        Iterable<BlockPos> iterable = BlockPos.Mutable.iterate(MathHelper.floor(this.mob.getX() - 3.0D), MathHelper.floor(this.mob.getY() - 6.0D), MathHelper.floor(this.mob.getZ() - 3.0D), MathHelper.floor(this.mob.getX() + 3.0D), MathHelper.floor(this.mob.getY() + 6.0D), MathHelper.floor(this.mob.getZ() + 3.0D));
        Iterator iterator = iterable.iterator();
        BlockPos blockpos1;
        for (;;)
        {
            if (!iterator.hasNext()) {
                return null;
            }
            blockpos1 = (BlockPos)iterator.next();
            if (!blockpos.equals(blockpos1))
            {
                Block block = this.mob.world.getBlockState(blockpos$mutableblockpos1.set(blockpos1).move(Direction.DOWN)).getBlock();
                boolean flag = ((block instanceof LeavesBlock) || (BlockTags.LOGS.contains(block)));
                if ((flag) && (this.mob.world.isAir(blockpos1)) && (this.mob.world.isAir(blockpos$mutableblockpos.set(blockpos1).move(Direction.UP)))) {
                    break;
                }
            }
        }
        return new Vec3d(blockpos1.getX(), blockpos1.getY(), blockpos1.getZ());
    }
}
