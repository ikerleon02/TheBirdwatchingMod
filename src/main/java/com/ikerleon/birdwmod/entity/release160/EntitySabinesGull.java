package com.ikerleon.birdwmod.entity.release160;

import com.ikerleon.birdwmod.entity.EntityBirdDiurnal;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntitySabinesGull extends EntityBirdDiurnal {

    public EntitySabinesGull(World worldIn) {
        super(worldIn);
        this.setSize(0.3f, 0.3f);
    }

    @Override
    public int setBirdVariants() {
        return 3;
    }

    /*@Override
    protected SoundEvent getAmbientSound() {
        if((this.onGround) && !isSleeping()) {
            if (this.getGender() == 0) {
                return SoundHandler.EIDER_CALL;
            } else {
                return SoundHandler.EIDER_FLYING;
            }
        }
        else{
            return null;
        }
    }*/

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
    }

    @Override
    public void onLivingUpdate() {
        if(this.inWater && !this.isChild()){
            this.motionY=0;
        }
        /*if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextFeather <= 0)
        {
            if(this.getGender()==0){
                this.dropItem(BirdwmodItems.STELLERSEIDERFEATHER_MALE, 1);
            }
            else{
                this.dropItem(BirdwmodItems.STELLERSEIDERFEATHER_FEMALE, 1);
            }
            this.timeUntilNextFeather = this.rand.nextInt(10000) + 10000;
        }*/
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
    public boolean goesToFeeders() {
        return false;
    }

    @Override
    public boolean isAquatic() {
        return true;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntitySabinesGull(this.world);
    }
}

