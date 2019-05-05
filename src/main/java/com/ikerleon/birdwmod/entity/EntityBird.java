package com.ikerleon.birdwmod.entity;

import java.util.Set;

import com.google.common.collect.Sets;

import com.ikerleon.birdwmod.entity.ai.EntityAIWanderAvoidWaterFlying;
import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.entity.move.EntityFlyHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityFlying;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public abstract class EntityBird extends EntityAnimal implements EntityFlying {
	
	protected static final DataParameter<Integer> GENDER = EntityDataManager.createKey(EntityBird.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(EntityBird.class, DataSerializers.VARINT);

    public float timer;
    public int timeUntilNextFeather;

    protected EntityFlyHelper MoveHelper = new EntityFlyHelper(this);
    protected EntityAIWanderAvoidWaterFlying WanderFlying = new EntityAIWanderAvoidWaterFlying(this, 1.0D);

	public EntityBird(World worldIn) {
        super(worldIn);
        this.setGender(this.getRNG().nextInt(2));
        this.setVariant(getRNG().nextInt(setBirdVariants()));
        this.timeUntilNextFeather = this.rand.nextInt(10000) + 10000;
        this.moveHelper = MoveHelper;
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityPlayer.class, 5.0F, 2D, 2D));
        this.tasks.addTask(4, new EntityAIFollowParent(this,1.D));
        this.tasks.addTask(3, WanderFlying);
        if(!(this instanceof EntityStellersEider)){
            this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 1.0D));
        }
    }

	@Override
	public float getEyeHeight() {
		return this.height-0.005f;
	}

    public void entityInit() {
        super.entityInit();
        this.dataManager.register(GENDER, Integer.valueOf(0));
        this.dataManager.register(VARIANT, Integer.valueOf(0));
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("Gender", this.getGender());
        tagCompound.setInteger("Variant", this.getVariant());
    }

    public void readEntityFromNBT(NBTTagCompound tagCompound) {
        super.readEntityFromNBT(tagCompound);
        this.setGender(tagCompound.getInteger("Gender"));
        this.setVariant(tagCompound.getInteger("Variant"));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.25D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.19D);
    }

    protected PathNavigate createNavigator(World worldIn)
    {
        if (isChild()) {
            return super.createNavigator(worldIn);
        }
        PathNavigateFlying pathnavigateflying = new PathNavigateFlying(this, worldIn);
        pathnavigateflying.setCanOpenDoors(false);
        pathnavigateflying.setCanFloat(true);
        pathnavigateflying.setCanEnterDoors(true);
        return pathnavigateflying;
    }

    public void fall(float distance, float damageMultiplier) {}

    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {}

    public boolean canBePushed()
    {
        return true;
    }

    protected void collideWithEntity(Entity entityIn)
    {
        if (!(entityIn instanceof EntityPlayer)) {
            super.collideWithEntity(entityIn);
        }
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if(!onGround && !isInWater()) {
            timer+=0.05F;
        }
        else if(this instanceof EntityStellersEider && isInWater()){
            timer+=0.05F;
        }
        else{
            timer = 0.0F;
        }
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(double distance)
    {
        double d0 = this.getEntityBoundingBox().getAverageEdgeLength();

        if (Double.isNaN(d0))
        {
            d0 = 1.0D;
        }

        d0 = d0 * 64.0D * 4.0D;
        return distance < d0 * d0;
    }

    public int getGender() {
        return this.dataManager.get(GENDER);
    }

    public void setGender(int value) {
        this.dataManager.set(GENDER, Integer.valueOf(value));
    }
    
    public int getVariant() {
    	return this.dataManager.get(VARIANT);
    }

    public void setVariant(int value) {
    	this.dataManager.set(VARIANT, Integer.valueOf(value));
    }
    
    public abstract int setBirdVariants();

    public enum Gender {
        MALE(0), FEMALE(1);
        
        EntityBird entity;

        Gender(int valueln){
            valueln = entity.getGender();
        }
    }
}
