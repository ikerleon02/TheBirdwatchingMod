package com.ikerleon.birdwmod.entity.northamerica;

import com.ikerleon.birdwmod.entity.EntityBirdDiurnal;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import com.ikerleon.birdwmod.util.handlers.SoundHandler;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.Random;

public class EntityNorthernMockingbird extends EntityBirdDiurnal {

    Random random = new Random();

    public EntityNorthernMockingbird(World worldIn) {
        super(worldIn);
        this.setSize(0.3f, 0.3f);
    }

    @Override
    public int setBirdVariants() {
        return 3;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        int mimic = this.random.nextInt(10) + 1;
        if(!isSleeping()) {
            if (mimic <= 5) {
                if (this.getGender() == 0) {
                    return SoundHandler.MOCKINGBIRD_SONG;
                } else {
                    return SoundHandler.MOCKINGBIRD_CALL;
                }
            } else {
                if (mimic <= 7) {
                    return SoundHandler.BLUEBIRD_CALL;
                } else {
                    return SoundHandler.KILLDEER_CALL;
                }
            }
        }
        else{
            return null;
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
            this.dropItem(BirdwmodItems.NORTHERNMOCKINGBIRDFEATHER, 1);
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
        return true;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityNorthernMockingbird(this.world);
    }
}
