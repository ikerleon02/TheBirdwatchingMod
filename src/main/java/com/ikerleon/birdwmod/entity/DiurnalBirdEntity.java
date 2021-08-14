package com.ikerleon.birdwmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public abstract class DiurnalBirdEntity extends BirdEntity{

    public DiurnalBirdEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn, 1);
    }

    @Override
    public void tickMovement() {
        if(this.onGround) {
            setSleeping(world.getTimeOfDay() >= 12969 && world.getTimeOfDay() <= 23031);
        }
        super.tickMovement();
    }
}
