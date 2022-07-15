package com.ikerleon.birdwmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.world.World;

public class GreatGreyOwlEntity extends BirdEntity {

    public GreatGreyOwlEntity(EntityType<? extends AnimalEntity> type, World worldIn, Settings settings) {
        super(type, worldIn, settings);
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.2, true));
        //this.targetSelector.add(2, new MoveToTargetPosGoal(this, RabbitEntity.class, true));
    }

    public boolean tryAttack(Entity target) {
        if (!(target instanceof RabbitEntity)) {
            return false;
        } else {
            return !this.isBaby();
        }
    }

    public static DefaultAttributeContainer.Builder createBirdAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20D).add(EntityAttributes.GENERIC_FLYING_SPEED, 0.70D).add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D);
    }

}
