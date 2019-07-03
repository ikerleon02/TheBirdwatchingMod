package com.ikerleon.birdwmod.entity;

import net.minecraft.world.World;

public abstract class EntityBirdDiurnal extends EntityBird{

	public EntityBirdDiurnal(World worldIn) {
		super(worldIn);
	}

	@Override
	public void onLivingUpdate() {
		if(this.onGround) {
            setSleeping(world.getWorldTime() >= 12516.6);
		}
		super.onLivingUpdate();
	}
}
