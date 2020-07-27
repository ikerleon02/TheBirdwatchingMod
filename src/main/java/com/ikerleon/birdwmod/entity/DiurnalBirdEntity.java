package com.ikerleon.birdwmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public abstract class DiurnalBirdEntity extends BirdEntity{

    public DiurnalBirdEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public void mobTick() {
        if(this.onGround) {
            setSleeping(world.getTime() >= 12000 && world.getTime() <= 23000);
        }
        super.mobTick();
    }
}
