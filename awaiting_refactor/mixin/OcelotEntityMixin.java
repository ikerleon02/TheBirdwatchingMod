package com.ikerleon.birdwmod.mixin;

import com.ikerleon.birdwmod.entity.BirdEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OcelotEntity.class)
public class OcelotEntityMixin extends MobEntity {

    protected OcelotEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("RETURN"), method = "initGoals()V", cancellable = true)
    private void attackBirdsAI(CallbackInfo info) {
        this.goalSelector.add(3, new MeleeAttackGoal((OcelotEntity) (Object) this, 0.7D, true));
        this.targetSelector.add(2, new FollowTargetGoal((OcelotEntity) (Object) this, BirdEntity.class, true));
    }
}
