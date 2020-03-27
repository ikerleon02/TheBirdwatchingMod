package com.ikerleon.birdwmod.entity.release160;

import com.google.common.base.Predicate;
import com.ikerleon.birdwmod.entity.EntityBirdNocturnal;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import com.ikerleon.birdwmod.util.handlers.SoundHandler;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityGreatGreyOwl extends EntityBirdNocturnal {

    private World world;

    public EntityGreatGreyOwl(World worldIn) {
        super(worldIn);
        this.setSize(0.3f, 0.5f);
        this.world=worldIn;
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityAnimal.class, 10, true, false, new Predicate<EntityAnimal>()
        {
            public boolean apply(@Nullable EntityAnimal p_apply_1_)
            {
                return p_apply_1_ instanceof EntityRabbit;
            }
        }));
    }

    @Override
    public int setBirdVariants() {
        return 1;
    }

    /*@Override
    protected SoundEvent getAmbientSound() {
        if(!world.isDaytime() && this.onGround  && !isSleeping()) {
            return SoundHandler.NIGHTJAR_SONG;
        }
        else{
            return null;
        }
    }*/

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
    }

    @Override
    public void onLivingUpdate() {
        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextFeather <= 0)
        {
            //this.dropItem(BirdwmodItems.REDNECKEDNIGHTJARFEATHER, 1);
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
        return new EntityGreatGreyOwl(this.world);
    }
}

