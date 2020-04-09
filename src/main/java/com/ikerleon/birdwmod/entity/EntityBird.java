package com.ikerleon.birdwmod.entity;

import com.ikerleon.birdwmod.blocks.BlockRingingNet;
import com.ikerleon.birdwmod.entity.ai.EntityAIEatFromFeeders;
import com.ikerleon.birdwmod.entity.ai.EntityAIWanderAvoidWaterFlying;
import com.ikerleon.birdwmod.entity.move.EntityFlyHelper;
import com.ikerleon.birdwmod.init.BirdwmodBlocks;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityFlying;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.EnumHand;
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
    private static final DataParameter<Integer> RING_COLOR = EntityDataManager.createKey(EntityBird.class, DataSerializers.VARINT);
    private static final DataParameter<Boolean> RINGED = EntityDataManager.createKey(EntityBird.class, DataSerializers.BOOLEAN);

    public float timer;
    public int timeUntilNextFeather;
    protected boolean blink = false;
    private byte nextBlink = 0;
    private byte blinkTime = 0;
    private byte blinkSec = 0;
    private BookwormRandom rando = new BookwormRandom();

    protected EntityAIWanderAvoidWaterFlying WanderFlying;
    protected EntityAIWanderAvoidWater Wander;
    private EntityAIAvoidEntity<EntityPlayer> avoidEntity = new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 7.0F, 0.8D, 1.33D);

    //Entity constructor and stuff
	public EntityBird(World worldIn) {
        super(worldIn);
        this.setGender(this.getRNG().nextInt(2));
        this.setVariant(getRNG().nextInt(setBirdVariants()));
        this.timeUntilNextFeather = this.rand.nextInt(10000) + 10000;
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIEatFromFeeders(this));
        this.tasks.addTask(4, this.avoidEntity);
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        if(!(this.isAquatic())){
            this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 1.0D));
        }
        else{
            this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        }
    }

	@Override
	public float getEyeHeight() {
		return this.height-this.height*0.1f;
	}

    @Override
    protected void initEntityAI() {
	    this.Wander = new EntityAIWanderAvoidWater(this, 1.0D);
	    this.WanderFlying = new EntityAIWanderAvoidWaterFlying(this, 1.0D);

        super.initEntityAI();
        if(this.isChild()){
            this.moveHelper = new EntityMoveHelper(this);
            this.tasks.addTask(3, Wander);
        }
        else{
            this.moveHelper = new EntityFlyHelper(this);
            this.tasks.removeTask(Wander);
            this.tasks.addTask(3, WanderFlying);
        }
    }

    public void entityInit() {
        super.entityInit();
        this.dataManager.register(GENDER, Integer.valueOf(0));
        this.dataManager.register(VARIANT, Integer.valueOf(0));
        this.dataManager.register(SLEEPING, Boolean.valueOf(false));
        this.dataManager.register(RING_COLOR,Integer.valueOf(EnumDyeColor.GRAY.getDyeDamage()));
        this.dataManager.register(RINGED, Boolean.valueOf(false));
    }


    //NBT write and read methods
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setInteger("Gender", this.getGender());
        tagCompound.setInteger("Variant", this.getVariant());
        tagCompound.setBoolean("Sleeping", this.isSleeping());
        tagCompound.setByte("CollarColor", (byte)this.getRingColor().getDyeDamage());
        tagCompound.setBoolean("Ringed", this.hasBeenRinged());
    }

    public void readEntityFromNBT(NBTTagCompound tagCompound) {
        super.readEntityFromNBT(tagCompound);
        this.setGender(tagCompound.getInteger("Gender"));
        this.setVariant(tagCompound.getInteger("Variant"));
        this.setSleeping(tagCompound.getBoolean("Sleeping"));
        this.setRinged(tagCompound.getBoolean("Ringed"));
        if (tagCompound.hasKey("CollarColor", 99))
        {
            this.setRingColor(EnumDyeColor.byDyeDamage(tagCompound.getByte("CollarColor")));
        }
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

    @Override
    public void move(MoverType type, double x, double y, double z) {
	    if(this.isInNet()){
	        if(this.world.getBlockState(new BlockPos(posX, posY, posZ)).getValue(BlockRingingNet.DIRECTION) == BlockRingingNet.EnumBlockDirection.NORTH) {
                this.posZ = (posZ - posZ % 1) + 0.5;
            }
	        else{
                this.posX = (posX - posX % 1) + 0.5;
            }
            this.motionX = 0.0D;
            this.motionY = 0.0D;
            this.motionZ = 0.0D;
        }
	    else{
            super.move(type, x, y, z);
        }

    }

    //Entity stuff
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if(this.isInNet()){
            this.fallDistance = 0.0F;
            this.onGround = true;
        }

        if((!onGround && !isInWater()) || (this.isAquatic() && isInWater()) || (isSleeping())) {
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
        if(this.hasBeenRinged() && !this.isNoDespawnRequired()){
            this.enablePersistence();
        }
    }

    @Override
    protected void despawnEntity() {
        super.despawnEntity();
    }

    public abstract boolean goesToFeeders();
    public abstract boolean isAquatic();

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

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == BirdwmodItems.RING)
        {
            if(this.hasBeenRinged() == false){
                this.setRinged(true);
                player.experienceLevel = player.experienceLevel + 1;
                itemstack.shrink(1);
            }
            return true;

        }
        else if (itemstack.getItem() == Items.DYE && this.hasBeenRinged())
        {
            EnumDyeColor enumdyecolor = EnumDyeColor.byDyeDamage(itemstack.getMetadata());

            if (enumdyecolor != this.getRingColor())
            {
                this.setRingColor(enumdyecolor);

                if (!player.capabilities.isCreativeMode)
                {
                    itemstack.shrink(1);
                }

                return true;
            }
        }
        return super.processInteract(player, hand);
    }

    //Sleeping code
    public boolean isSleeping() {
        return this.dataManager.get(SLEEPING);
    }
    public void setSleeping(boolean value) {
        this.dataManager.set(SLEEPING, Boolean.valueOf(value));
    }

    public boolean isInNet(){
        Block block = this.world.getBlockState(new BlockPos(posX, posY, posZ)).getBlock();
        return block == BirdwmodBlocks.RINGING_NET;
    }

    @Override
    public boolean isMovementBlocked() {
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

    public EnumDyeColor getRingColor()
    {
        return EnumDyeColor.byDyeDamage(this.dataManager.get(RING_COLOR).intValue() & 15);
    }

    public void setRingColor(EnumDyeColor collarcolor)
    {
        this.dataManager.set(RING_COLOR, Integer.valueOf(collarcolor.getDyeDamage()));
    }

    public boolean hasBeenRinged() {
        return this.dataManager.get(RINGED);
    }

    public void setRinged(boolean value) {
        this.dataManager.set(RINGED, value);
    }

    //Variant setter
    public abstract int setBirdVariants();

}
