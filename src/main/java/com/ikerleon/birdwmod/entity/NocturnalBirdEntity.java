package com.ikerleon.birdwmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public abstract class NocturnalBirdEntity extends BirdEntity{

    public NocturnalBirdEntity(EntityType<? extends BirdEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public void mobTick() {
        if(this.onGround) {
            setSleeping(world.getTime() <= 12000);
        }
        super.mobTick();
    }
}
