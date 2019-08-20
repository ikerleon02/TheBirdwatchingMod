package com.ikerleon.birdwmod.entity;

import com.ikerleon.birdwmod.entity.ai.EntityAIWanderAvoidWaterFlying;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.entity.move.EntityFlyHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityFlying;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.bookworm.util.BookwormRandom;

public abstract class EntityBird extends EntityAnimal implements EntityFlying {

    //Variables
	protected static final DataParameter<Integer> GENDER = EntityDataManager.createKey(EntityBird.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(EntityBird.class, DataSerializers.VARINT);
    protected static final DataParameter<Boolean> SLEEPING = EntityDataManager.createKey(EntityBird.class, DataSerializers.BOOLEAN);

    public float timer;
    public int timeUntilNextFeather;
    protected boolean blink = false;
    private byte nextBlink = 0;
    private byte blinkTime = 0;
    private byte blinkSec = 0;
    private BookwormRandom rando = new BookwormRandom();

    protected EntityFlyHelper MoveHelper = new EntityFlyHelper(this);
    protected EntityAIWanderAvoidWaterFlying WanderFlying = new EntityAIWanderAvoidWaterFlying(this, 1.0D);


    //Entity constructor and stuff
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
        this.dataManager.register(SLEEPING, Boolean.valueOf(false));
    }


    //NBT write and read methods
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("Gender", this.getGender());
        tagCompound.setInteger("Variant", this.getVariant());
        tagCompound.setBoolean("Sleeping", this.isSleeping());
    }

    public void readEntityFromNBT(NBTTagCompound tagCompound) {
        super.readEntityFromNBT(tagCompound);
        this.setGender(tagCompound.getInteger("Gender"));
        this.setVariant(tagCompound.getInteger("Variant"));
        this.setSleeping(tagCompound.getBoolean("Sleeping"));
    }


    //Entity stuff
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.25D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.19D);
    }


    //Flying code
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


    //Entity stuff
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if((!onGround && !isInWater()) || (this instanceof EntityStellersEider && isInWater()) || (isSleeping())) {
            timer+=0.05F;
        }
        else{
            timer = 0.0F;
        }
        if(!this.isSleeping()) {
            if (this.rand.nextInt(5) == 3) {
                this.blinkSec = ((byte) (this.rando.nextByte((byte) 50) + 30));
            }
            if (!this.blink) {
                this.nextBlink = ((byte) (this.nextBlink + 1));
            }
            if (this.nextBlink >= this.blinkSec) {
                this.blink = true;
                this.nextBlink = 0;
            }
            if (this.blink) {
                this.blinkTime = ((byte) (this.blinkTime + 1));
            }
            if (this.blinkTime >= 3) {
                this.blink = false;
                this.blinkTime = 0;
            }
        }

/*        if(!this.isSleeping()){
            if(rand.nextInt(100)==1) {
                if(!(this instanceof EntityStellersEider || this instanceof EntityGreenHeron || this instanceof EntityRedNeckedNightjar || this instanceof EntityNorthernMockingbird)) {
                    this.searchFeeder();
                }
            }
        }*/
    }

    public void searchFeeder(){
	    return;
/*	    BlockPos pos = new BlockPos(this);
	    int distance = 80;
	    for (int i = -distance; i < distance; i++) {
	        for (int j = -distance; j < distance; j++) {
	            for (int k = -distance; k < distance; k++) {
	                BlockPos b = pos.add(i, j, k);
	                if ((this.world.getBlockState(b).getBlock() instanceof BlockBirdfeeder)) {
	                    if(this.world.getBlockState(b).getValue(FILLED)) {
                            getNavigator().tryMoveToXYZ(b.getX(), b.getY() + 1, b.getZ(), 1.26D);
                        }
	                }
	            }
	        }
	    }*/
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


    //Sleeping code
    public boolean isSleeping() {
        return this.dataManager.get(SLEEPING);
    }
    public void setSleeping(boolean value) {
        this.dataManager.set(SLEEPING, Boolean.valueOf(value));
    }

    @Override
    protected boolean isMovementBlocked() {
	    if(this.onGround) {
            return super.isMovementBlocked() || isSleeping();
        }
	    else{
            return super.isMovementBlocked();
        }
    }


    //Blinking code
    public boolean getBlinking()
    {
        return this.blink;
    }


    //NBT Tags getters and setters
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


    //Variant setter
    public abstract int setBirdVariants();

}
