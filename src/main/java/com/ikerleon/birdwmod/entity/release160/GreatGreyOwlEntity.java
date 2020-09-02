package com.ikerleon.birdwmod.entity.release160;

import com.ikerleon.birdwmod.entity.DiurnalBirdEntity;
import com.ikerleon.birdwmod.entity.NocturnalBirdEntity;
import com.ikerleon.birdwmod.items.InitItems;
import com.ikerleon.birdwmod.util.SoundHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Hoglin;
import net.minecraft.entity.mob.HoglinBrain;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class GreatGreyOwlEntity extends NocturnalBirdEntity {

    public GreatGreyOwlEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);

        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2, true));
        this.targetSelector.add(2, new FollowTargetGoal(this, RabbitEntity.class, true));
    }

    public boolean tryAttack(Entity target) {
        if (!(target instanceof RabbitEntity)) {
            return false;
        } else {
            this.world.sendEntityStatus(this, (byte)4);
            return Hoglin.tryAttack(this, (LivingEntity)target) && !this.isBaby();
        }
    }

    public boolean damage(DamageSource source, float amount) {
        return !this.isBaby();
    }

    @Override
    public int setBirdVariants() {
        return 3;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if(!world.isDay() && this.onGround  && !isSleeping() && this.getGender() == 0) {
            return SoundHandler.GREATGREYOWL_SONG;
        }
        else{
            return null;
        }
    }

    public static DefaultAttributeContainer.Builder createBirdAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D).add(EntityAttributes.GENERIC_FLYING_SPEED, 0.70D).add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D);
    }

    @Override
    public void mobTick() {
        if (!this.world.isClient() && !this.isBaby() && --this.timeUntilNextFeather <= 0)
        {
            this.dropItem(InitItems.GREATGREYOWLFEATHER, 1);
            this.timeUntilNextFeather = this.random.nextInt(10000) + 10000;
        }
        super.mobTick();
    }

    @Override
    protected void dropLoot(DamageSource source, boolean causedByPlayer) {
        if(this.isOnFire())
            this.dropItem(InitItems.MEDIUMCOOCKEDMEAT, 1);
        else
            this.dropItem(InitItems.MEDIUMRAWMEAT, 1);
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
    public PassiveEntity createChild(PassiveEntity mate) {
        return (GreatGreyOwlEntity)this.getType().create(this.world);
    }
}
