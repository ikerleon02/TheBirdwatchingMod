package com.ikerleon.birdwmod.entity.jungle;

import com.ikerleon.birdwmod.entity.EntityBirdDiurnal;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityHoatzin extends EntityBirdDiurnal {

    public EntityHoatzin(World worldIn) {
        super(worldIn);
        this.setSize(0.4f, 0.4f);
    }

    @Override
    public int setBirdVariants() {
        return 3;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if(!isSleeping()) {
            return null;
        }
        else{
            return null;
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(7.0D);
    }

    @Override
    public void onLivingUpdate() {
        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextFeather <= 0)
        {
            this.dropItem(BirdwmodItems.HOATZINFEATHER, 1);
            this.timeUntilNextFeather = this.rand.nextInt(10000) + 10000;
        }
        super.onLivingUpdate();
    }

    @Override
    public void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if(this.isBurning())
            this.dropItem(BirdwmodItems.PASSERINECOOCKEDMEAT, 1);
        else
            this.dropItem(BirdwmodItems.PASSERINERAWMEAT, 1);
    }

    @Override
    public boolean goesToFeeders() {
        return false;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityHoatzin(this.world);
    }
}

