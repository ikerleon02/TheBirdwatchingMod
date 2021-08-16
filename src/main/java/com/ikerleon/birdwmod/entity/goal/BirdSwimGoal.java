package com.ikerleon.birdwmod.entity.goal;

import com.ikerleon.birdwmod.entity.BirdEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.tag.FluidTags;

import java.util.EnumSet;

public class BirdSwimGoal extends Goal {
    private final BirdEntity mob;

    public BirdSwimGoal(BirdEntity mob) {
        this.mob = mob;
        this.setControls(EnumSet.of(Goal.Control.JUMP));
        mob.getNavigation().setCanSwim(true);
    }

    public boolean canStart() {
        return this.mob.isTouchingWater() && this.mob.getFluidHeight(FluidTags.WATER) > this.mob.getEyeHeight(this.mob.getPose()) || this.mob.isInLava();
    }

    public void tick() {
        if(!mob.isBaby()) {
            if (this.mob.getRandom().nextFloat() < 0.8F ) {
                this.mob.getJumpControl().setActive();
            }
            else{

            }
        }
        else{
            if (this.mob.getRandom().nextFloat() < 0.8F) {
                this.mob.getJumpControl().setActive();
            }
        }
    }
}