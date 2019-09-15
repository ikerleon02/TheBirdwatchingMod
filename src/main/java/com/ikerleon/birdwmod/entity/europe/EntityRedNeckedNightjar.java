package com.ikerleon.birdwmod.entity.europe;

import com.ikerleon.birdwmod.entity.EntityBirdNocturnal;

import com.ikerleon.birdwmod.init.BirdwmodItems;
import com.ikerleon.birdwmod.util.handlers.SoundHandler;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityRedNeckedNightjar extends EntityBirdNocturnal{
	
	private World world;

	public EntityRedNeckedNightjar(World worldIn) {
		super(worldIn);
		this.setSize(0.4f, 0.2f);
		this.world=worldIn;
	}

	@Override
	public int setBirdVariants() {
		return 3;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		if(!world.isDaytime() && this.onGround  && !isSleeping()) {
			return SoundHandler.NIGHTJAR_SONG;
		}
		else{
			return null;
		}
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
	}

	@Override
	public boolean isMovementBlocked() {
		if(this.rand.nextInt(100)>80) {
			return super.isMovementBlocked();
		}
		else{
			return super.isMovementBlocked() || this.onGround;
		}

	}

	@Override
	public void onLivingUpdate() {
		if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextFeather <= 0)
		{
			this.dropItem(BirdwmodItems.REDNECKEDNIGHTJARFEATHER, 1);
			this.timeUntilNextFeather = this.rand.nextInt(10000) + 10000;
		}
		super.onLivingUpdate();
	}

	@Override
	public void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		if(this.isBurning())
			this.dropItem(BirdwmodItems.NIGHTJARCOOCKEDMEAT, 1);
		else
			this.dropItem(BirdwmodItems.NIGHTJARRAWMEAT, 1);
	}

	@Override
	public boolean goesToFeeders() {
		return false;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return new EntityRedNeckedNightjar(this.world);
	}
}
