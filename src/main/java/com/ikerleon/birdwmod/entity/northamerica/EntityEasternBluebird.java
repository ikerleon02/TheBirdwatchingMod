package com.ikerleon.birdwmod.entity.northamerica;

import com.ikerleon.birdwmod.entity.EntityBirdDiurnal;

import com.ikerleon.birdwmod.init.BirdwmodItems;
import com.ikerleon.birdwmod.util.PosesUtil;
import com.ikerleon.birdwmod.util.handlers.SoundHandler;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.soggymustache.bookworm.client.animation.lerp.Animation;
import net.soggymustache.bookworm.client.animation.lerp.AnimationHandler;

public class EntityEasternBluebird extends EntityBirdDiurnal{

	public static final int SPEAKMALE = 0;
	public static final int SPEAKFEMALE = 0;
	public AnimationHandler animator = new AnimationHandler();

	public EntityEasternBluebird(World worldIn) {
		super(worldIn);
		this.setSize(0.3f, 0.3f);

		if(this.world.isRemote) {
			Animation speakmale = new Animation(PosesUtil.EASTERN_BLUEBIRD_POSE, PosesUtil.EASTERN_BLUEBIRD_SPEAKING_POSE_1, PosesUtil.EASTERN_BLUEBIRD_SPEAKING_POSE_2, PosesUtil.EASTERN_BLUEBIRD_POSE);
			speakmale.speed = 0.4F;
			Animation speakfemale = new Animation(PosesUtil.EASTERN_BLUEBIRD_POSE, PosesUtil.EASTERN_BLUEBIRD_SPEAKING_POSE_1, PosesUtil.EASTERN_BLUEBIRD_SPEAKING_POSE_2, PosesUtil.EASTERN_BLUEBIRD_POSE);
			speakfemale.speed = 0.4F;
			animator.abruptStopping = false;
			animator.addAnimation(SPEAKMALE, speakmale);
			animator.addAnimation(SPEAKFEMALE, speakfemale);
		}
	}

	@Override
	public int setBirdVariants() {
		return 1;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
	}

	@Override
	public void onLivingUpdate() {
		if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextFeather <= 0)
		{
			if(this.getGender()==0){
				this.dropItem(BirdwmodItems.EASTERNBLUEBIRDFEATHER_MALE, 1);
			}
			else{
				this.dropItem(BirdwmodItems.EASTERNBLUEBIRDFEATHER_FEMALE, 1);
			}
			this.timeUntilNextFeather = this.rand.nextInt(10000) + 10000;
		}

		if(this.rand.nextInt(250)==0 && this.onGround){
			if(this.getGender()==0) {
				if(this.world.isRemote){
					this.animator.play(SPEAKMALE);
				}
				this.playSound(SoundHandler.BLUEBIRD_SONG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			}
			else{
				if(this.world.isRemote){
					this.animator.play(SPEAKFEMALE);
				}
				this.playSound(SoundHandler.BLUEBIRD_CALL, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			}
		}

		super.onLivingUpdate();
	}

	@Override
	public void onUpdate() {
		if(this.world.isRemote)
			animator.onEntityUpdate(this);

		super.onUpdate();
	}

	@Override
	public void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		if(this.isBurning())
			this.dropItem(BirdwmodItems.PASSERINECOOCKEDMEAT, 1);
		else
			this.dropItem(BirdwmodItems.PASSERINERAWMEAT, 1);
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return new EntityEasternBluebird(this.world);
	}
}
