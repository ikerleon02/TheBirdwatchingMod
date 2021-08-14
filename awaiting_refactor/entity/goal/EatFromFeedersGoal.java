package com.ikerleon.birdwmod.entity.goal;

import com.ikerleon.birdwmod.blocks.BirdFeederBlock;
import com.ikerleon.birdwmod.entity.BirdEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.TargetFinder;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.mob.MobEntityWithAi;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import java.util.Iterator;
import javax.annotation.Nullable;

public class EatFromFeedersGoal extends WanderAroundFarGoal {

    BirdEntity bird;

    public EatFromFeedersGoal(BirdEntity mobEntityWithAi) {
        super(mobEntityWithAi, 1);
        bird=mobEntityWithAi;
    }

    @Nullable
    protected Vec3d getWanderTarget() {
        Vec3d vec3d = null;
        if (this.mob.isTouchingWater()) {
            vec3d = TargetFinder.findGroundTarget(this.mob, 15, 15);
        }

        if (this.mob.getRandom().nextFloat() >= this.probability && this.bird.goesToFeeders()) {
            vec3d = this.getFeederTarget();
        }

        return vec3d == null ? super.getWanderTarget() : vec3d;
    }

    @Nullable
    private Vec3d getFeederTarget() {
        BlockPos blockPos = this.mob.getBlockPos();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        BlockPos.Mutable mutable2 = new BlockPos.Mutable();
        Iterable<BlockPos> iterable = BlockPos.iterate(MathHelper.floor(this.mob.getX() - 6.0D), MathHelper.floor(this.mob.getY() - 6.0D), MathHelper.floor(this.mob.getZ() - 6.0D), MathHelper.floor(this.mob.getX() + 6.0D), MathHelper.floor(this.mob.getY() + 6.0D), MathHelper.floor(this.mob.getZ() + 6.0D));
        Iterator var5 = iterable.iterator();

        BlockPos blockPos2;
        boolean bl;
        boolean filled = false;
        do {
            do {
                if (!var5.hasNext()) {
                    return null;
                }

                blockPos2 = (BlockPos)var5.next();
            } while(blockPos.equals(blockPos2));

            Block block = this.mob.world.getBlockState(mutable2.set(blockPos2, Direction.DOWN)).getBlock();
            bl = block instanceof BirdFeederBlock;
            if(bl){
                if(this.mob.world.getBlockState(blockPos2).contains(BirdFeederBlock.FILLED)){
                    filled = this.mob.world.getBlockState(blockPos2).get(BirdFeederBlock.FILLED);
                }
            }
        }

        while(!bl || !filled || !this.mob.world.isAir(blockPos2) || !this.mob.world.isAir(mutable.set(blockPos2, Direction.UP)));

        return Vec3d.ofBottomCenter(blockPos2);
    }
}