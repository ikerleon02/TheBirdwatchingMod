package com.ikerleon.birdwmod.entity.move;

import com.ikerleon.birdwmod.entity.BirdEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;

public class MoveControlFlying extends MoveControl
{
    public MoveControlFlying(MobEntity p_i47418_1_)
    {
        super(p_i47418_1_);
    }

    public void tick()
    {
        if(this.entity instanceof BirdEntity){
            if (this.state == MoveControl.State.MOVE_TO) {
                if (this.entity.isBaby()) {
                    this.state = MoveControl.State.WAIT;
                    double d0 = this.targetX - this.entity.getX();
                    double d1 = this.targetZ - this.entity.getZ();
                    double d2 = this.targetY - this.entity.getY();
                    double d3 = d0 * d0 + d2 * d2 + d1 * d1;

                    if (d3 < 2.500000277905201E-7D) {
                        this.entity.setForwardSpeed(0.0F);
                        return;
                    }

                    float f9 = (float) (MathHelper.atan2(d1, d0) * (180D / Math.PI)) - 90.0F;
                    this.entity.yaw = this.changeAngle(this.entity.yaw, f9, 90.0F);
                    this.entity.setMovementSpeed((float) (this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)));

                    if (d2 > (double) this.entity.stepHeight && d0 * d0 + d1 * d1 < (double) Math.max(1.0F, this.entity.getWidth())) {
                        this.entity.getJumpControl().setActive();
                        this.state = MoveControl.State.JUMPING;
                    }
                } else {
                    this.state = MoveControl.State.WAIT;
                    this.entity.setNoGravity(true);
                    double d0 = this.targetX - this.entity.getX();
                    double d1 = this.targetY - this.entity.getY();
                    double d2 = this.targetZ - this.entity.getZ();
                    double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                    if (d3 < 2.500000277905201E-7D) {
                        this.entity.setUpwardSpeed(0.0F);
                        this.entity.setForwardSpeed(0.0F);
                        return;
                    }
                    float f = (float) (MathHelper.atan2(d2, d0) * 57.29577951308232D) - 90.0F;
                    this.entity.yaw = changeAngle(this.entity.yaw, f, 10.0F);
                    float f1;
                    if (this.entity.isOnGround()) {
                        f1 = (float) (this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
                    } else {
                        f1 = (float) (this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_FLYING_SPEED));
                    }
                    this.entity.setMovementSpeed(f1);
                    double d4 = MathHelper.sqrt(d0 * d0 + d2 * d2);
                    float f2 = (float) -(MathHelper.atan2(d1, d4) * 57.29577951308232D);
                    this.entity.pitch = changeAngle(this.entity.pitch, f2, 10.0F);
                    this.entity.setUpwardSpeed(d1 > 0.0D ? f1 : -f1);
                    if (d1 > 0.0D) {
                        this.entity.forwardSpeed = (MathHelper.sin(-this.entity.yaw * 0.017453292F) * 0.2F);
                        this.entity.sidewaysSpeed = (MathHelper.cos(this.entity.yaw * 0.017453292F) * 0.2F);
                    }
                }
            } else {
                this.entity.setNoGravity(false);
                this.entity.setUpwardSpeed(0.0F);
                this.entity.setForwardSpeed(0.0F);
            }
        }
    }
}
