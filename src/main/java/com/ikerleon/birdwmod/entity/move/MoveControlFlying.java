package com.ikerleon.birdwmod.entity.move;

import com.ikerleon.birdwmod.entity.BirdEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;

import java.util.Random;

public class MoveControlFlying extends MoveControl
{
    private final int maxPitchChange;
    private final boolean noGravity;

    public MoveControlFlying(MobEntity entity, int maxPitchChange, boolean noGravity) {
        super(entity);
        this.maxPitchChange = maxPitchChange;
        this.noGravity = noGravity;
    }

    public void tick() {
        if(this.entity instanceof BirdEntity) {
            BirdEntity bird = (BirdEntity) entity;
            Random random = new Random();
            if(!bird.isSleeping()) {
                if (this.state == MoveControl.State.MOVE_TO) {
                    if (this.entity.isBaby()) {
                        float q;
                        this.state = MoveControl.State.WAIT;
                        double d = this.targetX - this.entity.getX();
                        double e = this.targetZ - this.entity.getZ();
                        double o = this.targetY - this.entity.getY();
                        double p = d * d + o * o + e * e;
                        if (p < 2.500000277905201E-7D) {
                            this.entity.setForwardSpeed(0.0F);
                            return;
                        }

                        q = (float) (MathHelper.atan2(e, d) * 57.2957763671875D) - 90.0F;
                        this.entity.setYaw(this.wrapDegrees(this.entity.getYaw(), q, 90.0F));
                        this.entity.setMovementSpeed((float) (this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)));
                        BlockPos blockPos = this.entity.getBlockPos();
                        BlockState blockState = this.entity.world.getBlockState(blockPos);
                        Block block = blockState.getBlock();
                        VoxelShape voxelShape = blockState.getCollisionShape(this.entity.world, blockPos);
                        if (o > (double) this.entity.stepHeight && d * d + e * e < (double) Math.max(1.0F, this.entity.getWidth()) || !voxelShape.isEmpty() && this.entity.getY() < voxelShape.getMax(Direction.Axis.Y) + (double) blockPos.getY() && !blockState.isIn(BlockTags.DOORS) && !blockState.isIn(BlockTags.FENCES)) {
                            this.entity.getJumpControl().setActive();
                            this.state = MoveControl.State.JUMPING;
                        }
                    }
                    else {
                        this.state = MoveControl.State.WAIT;
                        this.entity.setNoGravity(true);
                        float d = (float)(this.targetX - this.entity.getX());
                        float e = (float)(this.targetY - this.entity.getY());
                        float f = (float)(this.targetZ - this.entity.getZ());
                        float g = d * d + e * e + f * f;
                        if (g < 2.500000277905201E-7D) {
                            this.entity.setUpwardSpeed(0.0F);
                            this.entity.setForwardSpeed(0.0F);
                            return;
                        }

                        float h = (float) (MathHelper.atan2(f, d) * 57.2957763671875D) - 90.0F;
                        this.entity.setYaw(this.wrapDegrees(this.entity.getYaw(), h, 90.0F));
                        float j;
                        if (this.entity.isOnGround()) {
                            j = (float) (this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
                        } else {
                            j = (float) (this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_FLYING_SPEED));
                        }

                        this.entity.setMovementSpeed(j);
                        double k = MathHelper.sqrt(d * d + f * f);
                        float l = (float) (-(MathHelper.atan2(e, k) * 57.2957763671875D));
                        this.entity.setPitch(this.wrapDegrees(this.entity.getPitch(), l, (float) this.maxPitchChange));
                        this.entity.setUpwardSpeed(e > 0.0D ? j : -j);
                    }
                }
                else {
                    if (!this.noGravity) {
                        this.entity.setNoGravity(false);
                    }

                    this.entity.setUpwardSpeed(0.0F);
                    this.entity.setForwardSpeed(0.0F);
                }
            }
        }
    }
}