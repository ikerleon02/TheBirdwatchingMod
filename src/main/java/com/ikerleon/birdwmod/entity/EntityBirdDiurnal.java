package com.ikerleon.birdwmod.entity;

import net.minecraft.world.World;

public abstract class EntityBirdDiurnal extends EntityBird{

	public EntityBirdDiurnal(World worldIn) {
		super(worldIn);
	}

	@Override
	public void onLivingUpdate() {
		if(this.onGround) {
			if (world.isDaytime()) {
				this.sleeping = false;
			}
			else {
				this.sleeping = true;
			}
		}
		super.onLivingUpdate();
	}
}
