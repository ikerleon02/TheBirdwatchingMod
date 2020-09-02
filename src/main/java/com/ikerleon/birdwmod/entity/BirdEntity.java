package com.ikerleon.birdwmod.entity;

import com.ikerleon.birdwmod.blocks.InitBlocks;
import com.ikerleon.birdwmod.blocks.RingingNetBlock;
import com.ikerleon.birdwmod.entity.goal.EatFromFeedersGoal;
import com.ikerleon.birdwmod.entity.move.MoveControlFlying;
import com.ikerleon.birdwmod.items.InitItems;
import com.ikerleon.birdwmod.items.ItemBirdSpawnEgg;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Random;

public abstract class BirdEntity extends AnimalEntity{

    //Variables
    protected static final TrackedData<Integer> GENDER;
    protected static final TrackedData<Integer> VARIANT;
    protected static final TrackedData<Boolean> SLEEPING;
    private static final TrackedData<Integer> RING_COLOR;
    private static final TrackedData<Boolean> RINGED;

    public float timer;
    public int timeUntilNextFeather;
    protected boolean blink = false;
    private byte nextBlink = 0;
    private byte blinkTime = 0;
    private byte blinkSec = 0;
    private Random rando = new Random();

    //Entity constructor and stuff
    public BirdEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
        this.setGender(getRandom().nextInt(2));
        this.setVariant(getRandom().nextInt(setBirdVariants()));
        this.timeUntilNextFeather = this.rando.nextInt(10000) + 10000;
        this.moveControl = new MoveControlFlying(this, 30, false);
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0D));
        this.goalSelector.add(2, new FleeEntityGoal(this, OcelotEntity.class, 15.0F, 1.5D, 2D));
        this.goalSelector.add(2, new FleeEntityGoal(this, CatEntity.class, 15.0F, 1.5D, 2D));
        this.goalSelector.add(3, new EatFromFeedersGoal(this));
        this.goalSelector.add(4, new FleeEntityGoal(this, PlayerEntity.class, 15.0F, 1.0D, 1.2D));
        this.goalSelector.add(5, new FlyOntoTreeGoal(this, 1.0D));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));

    }

    static {
        GENDER = DataTracker.registerData(BirdEntity.class, TrackedDataHandlerRegistry.INTEGER);
        VARIANT = DataTracker.registerData(BirdEntity.class, TrackedDataHandlerRegistry.INTEGER);
        SLEEPING = DataTracker.registerData(BirdEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        RING_COLOR = DataTracker.registerData(BirdEntity.class, TrackedDataHandlerRegistry.INTEGER);
        RINGED = DataTracker.registerData(BirdEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return dimensions.height * 0.75F;
    }

    public void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(GENDER, Integer.valueOf(0));
        this.dataTracker.startTracking(VARIANT, Integer.valueOf(0));
        this.dataTracker.startTracking(SLEEPING, Boolean.valueOf(false));
        this.dataTracker.startTracking(RING_COLOR,Integer.valueOf(DyeColor.GRAY.getId()));
        this.dataTracker.startTracking(RINGED, Boolean.valueOf(false));
    }

    //NBT write and read methods
    public void writeCustomDataToTag(CompoundTag tagCompound) {
        super.writeCustomDataToTag(tagCompound);
        tagCompound.putInt("Gender", this.getGender());
        tagCompound.putInt("Variant", this.getVariant());
        tagCompound.putBoolean("Sleeping", this.isSleeping());
        tagCompound.putInt("CollarColor", (byte)this.getRingColor().getId());
        tagCompound.putBoolean("Ringed", this.hasBeenRinged());
    }

    public void readCustomDataFromTag(CompoundTag tagCompound) {
        super.readCustomDataFromTag(tagCompound);
        this.setGender(tagCompound.getInt("Gender"));
        this.setVariant(tagCompound.getInt("Variant"));
        this.setSleeping(tagCompound.getBoolean("Sleeping"));
        this.setRinged(tagCompound.getBoolean("Ringed"));
        if (tagCompound.contains("CollarColor", 99))
        {
            this.setRingColor(DyeColor.byId(tagCompound.getInt("CollarColor")));
        }
    }

    public static boolean canSpawnThere(EntityType<? extends HostileEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return canMobSpawn(type, world, spawnReason, pos, random);
    }

    @Override
    public boolean canSpawn(WorldView world) {
        if(this.isAquatic()){
            return world.intersectsEntities(this);
        }
        else {
            return super.canSpawn(world);
        }
    }

    //Flying code
    @Override
    protected EntityNavigation createNavigation(World world) {
        if (this.isBaby()) {
            return super.createNavigation(world);
        }
        BirdNavigation pathnavigateflying = new BirdNavigation(this, world);
        pathnavigateflying.setCanSwim(true);
        pathnavigateflying.setCanEnterOpenDoors(true);
        return pathnavigateflying;
    }

    @Override
    protected void fall(double heightDifference, boolean onGround, BlockState landedState, BlockPos landedPosition) { }

    @Override
    public void move(MovementType type, Vec3d movement) {
        if(this.isInNet() && (type == MovementType.SELF || type == MovementType.PLAYER)){

        }
        else{
            super.move(type, movement);
        }
    }

    //Entity stuff
    @Override
    public void tickMovement() {
        if(this.isInNet()){
            this.fallDistance = 0.0F;
            this.onGround = true;
        }

        if((!onGround && !isTouchingWater()) || (this.isAquatic() && isTouchingWater()) || (isSleeping())) {
            timer+=0.05F;
        }
        else{
            timer = 0.0F;
        }
        if(!this.isSleeping()) {
            if (this.random.nextInt(5) == 3) {
                this.blinkSec = ((byte) (this.rando.nextInt((byte) 50) + 30));
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
        if(this.hasBeenRinged()){
            this.setPersistent();
        }
        super.tickMovement();
    }

    @Override
    public boolean shouldRender(double distance) {
        double d0 = this.getBoundingBox().getAverageSideLength();

        if (Double.isNaN(d0))
        {
            d0 = 1.0D;
        }

        d0 = d0 * 64.0D * 4.0D;
        return distance < d0 * d0;
    }

    public abstract boolean goesToFeeders();

    public abstract boolean isAquatic();

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);

        if (itemstack.getItem() == InitItems.RING)
        {
            if(this.hasBeenRinged() == false){
                this.setRinged(true);
                player.experienceLevel = player.experienceLevel + 1;
                if (!player.isCreative())
                {
                    itemstack.decrement(1);
                }
            }
            return ActionResult.SUCCESS;

        }
        else if (itemstack.getItem() instanceof ItemBirdSpawnEgg)
        {
            ItemBirdSpawnEgg egg = (ItemBirdSpawnEgg)itemstack.getItem();

            if(egg.entityType == this.getType()){
                if (!this.world.isClient())
                {
                    Object mobEntity3;
                    mobEntity3 = ((PassiveEntity)this).createChild((PassiveEntity)this);
                    ((MobEntity)mobEntity3).setBaby(true);
                    ((MobEntity)mobEntity3).refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
                    world.spawnEntity((Entity)mobEntity3);
                    if (itemstack.hasCustomName()) {
                        ((MobEntity)mobEntity3).setCustomName(itemstack.getName());
                    }

                    if (!player.abilities.creativeMode) {
                        itemstack.decrement(1);
                    }
                }
            }
            return ActionResult.SUCCESS;

        }
        else if (itemstack.getItem() instanceof DyeItem && this.hasBeenRinged())
        {
            DyeItem dye = (DyeItem) itemstack.getItem();
            DyeColor enumdyecolor = dye.getColor();

            if (enumdyecolor != this.getRingColor())
            {
                this.setRingColor(enumdyecolor);

                if (!player.isCreative())
                {
                    itemstack.decrement(1);
                }

                return ActionResult.SUCCESS;
            }
        }
        return super.interactMob(player, hand);
    }

    //Sleeping code
    public boolean isSleeping() {
        return this.dataTracker.get(SLEEPING);
    }
    public void setSleeping(boolean value) {
        this.dataTracker.set(SLEEPING, Boolean.valueOf(value));
    }

    public boolean isInNet(){
        Block block = this.world.getBlockState(new BlockPos(this.getPos())).getBlock();
        return block == InitBlocks.RINGING_NET;
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }

    //Blinking code
    public boolean getBlinking()
    {
        return this.blink;
    }


    //NBT Tags getters and setters
    public int getGender() {
        return this.dataTracker.get(GENDER);
    }

    public void setGender(int value) {
        this.dataTracker.set(GENDER, Integer.valueOf(value));
    }

    public int getVariant() {
        return this.dataTracker.get(VARIANT);
    }

    public void setVariant(int value) {
        this.dataTracker.set(VARIANT, Integer.valueOf(value));
    }

    public DyeColor getRingColor()
    {
        return DyeColor.byId(this.dataTracker.get(RING_COLOR).intValue() & 15);
    }

    public void setRingColor(DyeColor collarcolor)
    {
        this.dataTracker.set(RING_COLOR, Integer.valueOf(collarcolor.getId()));
    }

    public boolean hasBeenRinged() {
        return this.dataTracker.get(RINGED);
    }

    public void setRinged(boolean value) {
        this.dataTracker.set(RINGED, value);
    }

    //Variant setter
    public abstract int setBirdVariants();

}

