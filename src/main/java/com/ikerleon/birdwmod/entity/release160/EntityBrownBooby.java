package com.ikerleon.birdwmod.entity.release160;

import com.ikerleon.birdwmod.entity.EntityBirdDiurnal;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import com.ikerleon.birdwmod.util.handlers.SoundHandler;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityBrownBooby extends EntityBirdDiurnal {

    public EntityBrownBooby(World worldIn) {
        super(worldIn);
        this.setSize(0.5f, 0.6f);
    }

    @Override
    public int setBirdVariants() {
        return 4;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if((this.onGround) && !isSleeping()) {
            if (this.getGender() == 0) {
                return SoundHandler.BOOBY_CALL;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
    }

    @Override
    public void onLivingUpdate() {
        if(this.inWater && !this.isChild()){
            this.motionY=0;
        }
        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextFeather <= 0)
        {
            this.dropItem(BirdwmodItems.STELLERSEIDERFEATHER_MALE, 1);
            this.timeUntilNextFeather = this.rand.nextInt(10000) + 10000;
        }
        super.onLivingUpdate();
    }

    @Override
    public void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if(this.isBurning())
            this.dropItem(BirdwmodItems.DUCKCOOCKEDMEAT, 1);
        else
            this.dropItem(BirdwmodItems.DUCKRAWMEAT, 1);
    }

    @Override
    public boolean goesToFeeders() {
        return false;
    }

    @Override
    public boolean isAquatic() {
        return true;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityBrownBooby(this.world);
    }
}

