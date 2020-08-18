package com.ikerleon.birdwmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public abstract class NocturnalBirdEntity extends BirdEntity{

    public NocturnalBirdEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public void tickMovement() {
        if(this.onGround) {
            setSleeping(world.getTimeOfDay() <= 12969);
        }
        super.tickMovement();
    }
}
