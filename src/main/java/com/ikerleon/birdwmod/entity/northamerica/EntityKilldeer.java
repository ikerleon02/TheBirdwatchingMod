package com.ikerleon.birdwmod.entity.northamerica;

import com.ikerleon.birdwmod.entity.EntityBirdDiurnal;

import com.ikerleon.birdwmod.init.BirdwmodItems;
import com.ikerleon.birdwmod.util.handlers.SoundHandler;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityKilldeer extends EntityBirdDiurnal{

	public EntityKilldeer(World worldIn) {
		super(worldIn);
		this.setSize(0.4f, 0.3f);
	}

	@Override
	public int setBirdVariants() {
		return 3;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		if(this.onGround){
			return SoundHandler.KILLDEER_CALL;
		}
		else{
			return SoundHandler.KILLDEER_FLYING;
		}
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
	}

	@Override
	public void onLivingUpdate() {
		if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextFeather <= 0)
		{
			this.dropItem(BirdwmodItems.KILLDEERFEATHER, 1);
			this.timeUntilNextFeather = this.rand.nextInt(10000) + 10000;
		}
		super.onLivingUpdate();
	}

	@Override
	public void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		if(this.isBurning())
			this.dropItem(BirdwmodItems.WADERCOOCKEDMEAT, 1);
		else
			this.dropItem(BirdwmodItems.WADERRAWMEAT, 1);
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return new EntityKilldeer(this.world);
	}
}
