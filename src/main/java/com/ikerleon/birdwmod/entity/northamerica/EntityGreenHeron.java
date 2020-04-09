package com.ikerleon.birdwmod.entity.northamerica;

import com.ikerleon.birdwmod.entity.EntityBirdDiurnal;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import com.ikerleon.birdwmod.util.handlers.SoundHandler;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.soggymustache.bookworm.client.animation.lerp.AnimationHandler;

import javax.annotation.Nullable;

public class EntityGreenHeron extends EntityBirdDiurnal {

    public static final int SPEAK = 0;
    public AnimationHandler animator = new AnimationHandler();

    public EntityGreenHeron(World worldIn) {
        super(worldIn);
        this.setSize(0.3f, 0.5f);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        if(!isSleeping() && !onGround){
            return SoundHandler.HERON_FLYING;
        }
        else{
            return null;
        }
    }

    @Override
    public int setBirdVariants() {
        return 3;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
    }

    @Override
    public void onEntityUpdate() {
        if(this.world.isRemote) {
            animator.onEntityUpdate(this);
        }

        super.onEntityUpdate();
    }

    @Override
    public void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        if(this.isBurning())
            this.dropItem(BirdwmodItems.HERONCOOCKEDMEAT, 1);
        else
            this.dropItem(BirdwmodItems.HERONRAWMEAT, 1);
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
        return new EntityGreenHeron(this.world);
    }
}
