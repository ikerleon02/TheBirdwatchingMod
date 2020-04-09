package com.ikerleon.birdwmod.entity.release160;

import com.ikerleon.birdwmod.entity.EntityBirdNocturnal;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import com.ikerleon.birdwmod.util.handlers.SoundHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGreatGreyOwl extends EntityBirdNocturnal {

    private World world;

    public EntityGreatGreyOwl(World worldIn) {
        super(worldIn);
        this.setSize(0.3f, 0.5f);
        this.world=worldIn;

        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.2, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<EntityRabbit>(this, EntityRabbit.class, true, false));
    }

    @Override
    public int setBirdVariants() {
        return 3;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if(!world.isDaytime() && this.onGround  && !isSleeping() && this.getGender() == 0) {
            return SoundHandler.GREATGREYOWL_SONG;
        }
        else{
            return null;
        }
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

        if (flag)
        {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    @Override
    public void onLivingUpdate() {
        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextFeather <= 0)
        {
            this.dropItem(BirdwmodItems.GREATGREYOWLFEATHER, 1);
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
    public boolean isAquatic() {
        return false;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityGreatGreyOwl(this.world);
    }
}

