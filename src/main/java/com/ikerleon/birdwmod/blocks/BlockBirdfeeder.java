package com.ikerleon.birdwmod.blocks;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.init.BirdwmodBlocks;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockBirdfeeder extends Block {

    public static final PropertyBool FILLED = PropertyBool.create("filled");
    public static final PropertyEnum<BlockBirdfeeder.EnumBlockHalf> HALF = PropertyEnum.<BlockBirdfeeder.EnumBlockHalf>create("half", BlockBirdfeeder.EnumBlockHalf.class);

    Random random = new Random();

    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.0625 * 0, 0.0625 * 0, 0.0625 * 0, 0.0625 * 16, 0.0625 * 16, 0.0625 * 16);

    private static final AxisAlignedBB BASE_BOX = new AxisAlignedBB(0.0625 * 5, 0, 0.0625 * 5, 0.0625 * 11, 0.0625 * 1, 0.0625 * 11);
    private static final AxisAlignedBB STICK_BOX = new AxisAlignedBB(0.0625 * 6.5, 0.0625 * 1, 0.0625 * 6.5, 0.0625 * 11.5, 0.0625 * 13, 0.0625 * 11.5);
    private static final AxisAlignedBB PLATAFORM_BOX = new AxisAlignedBB(0.0625 * 6, 0.0625 * 13, 0.0625 * 6, 0.0625 * 10, 0.0625 * 14, 0.0625 * 10);
    private static final AxisAlignedBB PLATAFORM2_BOX = new AxisAlignedBB(0.0625 * 4, 0.0625 * 14, 0.0625 * 4, 0.0625 * 12, 0.0625 * 16, 0.0625 * 12);

    private static final AxisAlignedBB FEEDER_BASE_BOX = new AxisAlignedBB(0.0625 * 0, 0.0625 * 0, 0.0625 * 0, 0.0625 * 16, 0.0625 * 1, 0.0625 * 16);
    private static final AxisAlignedBB FEEDER_BACK_BOX = new AxisAlignedBB(0.0625 * 0, 0.0625 * 1, 0.0625 * 15, 0.0625 * 16, 0.0625 * 3, 0.0625 * 16);
    private static final AxisAlignedBB FEEDER_FRONT_BOX = new AxisAlignedBB(0.0625 * 0, 0.0625 * 0, 0.0625 * 0, 0.0625 * 16, 0.0625 * 2, 0.0625 * 1);
    private static final AxisAlignedBB FEEDER_LEFT_BOX = new AxisAlignedBB(0.0625 * 15, 0.0625 * 1, 0.0625 * 1, 0.0625 * 16, 0.0625 * 3, 0.0625 * 15);
    private static final AxisAlignedBB FEEDER_RIGHT_BOX = new AxisAlignedBB(0.0625 * 0, 0.0625 * 1, 0.0625 * 1, 0.0625 * 1, 0.0625 * 3, 0.0625 * 15);
    private static final AxisAlignedBB FEEDER_STICK_BOX = new AxisAlignedBB(0.0625 * 6.5, 0.0625 * 1, 0.0625 * 6.5, 0.0625 * 9.5, 0.0625 * 8, 0.0625 * 9.5);
    private static final AxisAlignedBB FEEDER_PLATAFORM_BOX = new AxisAlignedBB(0.0625 * 5.5, 0.0625 * 8, 0.0625 * 5.5, 0.0625 * 10.5, 0.0625 * 9, 0.0625 * 10.5);
    private static final AxisAlignedBB FEEDER_STICK2_BOX = new AxisAlignedBB(0.0625 * 6.5, 0.0625 * 9, 0.0625 * 6.5, 0.0625 * 9.5, 0.0625 * 15, 0.0625 * 9.5);
    private static final AxisAlignedBB FEEDER_TOP_BOX = new AxisAlignedBB(0.0625 * 7, 0.0625 * 15, 0.0625 * 7, 0.0625 * 9, 0.0625 * 16, 0.0625 * 9);

    protected static final Logger LOGGER = LogManager.getLogger();

    public BlockBirdfeeder(Material materialIn, String name) {
        super(materialIn);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setTickRandomly(true);
        this.setHardness(2.0F);
        BirdwmodBlocks.BLOCKS.add(this);
        this.setCreativeTab(Main.BIRDWATCHINGMOD);

        this.setDefaultState(this.blockState.getBaseState().withProperty(FILLED, false).withProperty(HALF, BlockBirdfeeder.EnumBlockHalf.LOWER));

        BirdwmodItems.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
    }

    public void placeAt(World worldIn, BlockPos lowerPos, int flags)
    {
        worldIn.setBlockState(lowerPos, this.getDefaultState().withProperty(HALF, BlockBirdfeeder.EnumBlockHalf.LOWER), flags);
        worldIn.setBlockState(lowerPos.up(), this.getDefaultState().withProperty(HALF, BlockBirdfeeder.EnumBlockHalf.UPPER), flags);
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos.up(), this.getDefaultState().withProperty(HALF, BlockBirdfeeder.EnumBlockHalf.UPPER), 2);
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) { return AABB; }

    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
        if(state.getValue(HALF) == BlockBirdfeeder.EnumBlockHalf.LOWER) {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, STICK_BOX);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, PLATAFORM_BOX);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, BASE_BOX);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, PLATAFORM2_BOX);
        }
        else if(state.getValue(HALF) == BlockBirdfeeder.EnumBlockHalf.UPPER){
            addCollisionBoxToList(pos, entityBox, collidingBoxes, FEEDER_BASE_BOX);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, FEEDER_BACK_BOX);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, FEEDER_FRONT_BOX);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, FEEDER_LEFT_BOX);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, FEEDER_RIGHT_BOX);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, FEEDER_STICK_BOX);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, FEEDER_PLATAFORM_BOX);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, FEEDER_STICK2_BOX);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, FEEDER_TOP_BOX);
        }

    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = playerIn.getHeldItem(hand);

        if (worldIn.getBlockState(pos).getValue(HALF)== EnumBlockHalf.UPPER && !worldIn.getBlockState(pos).getValue(FILLED)) {
            if (stack.getItem() == Items.WHEAT_SEEDS && stack.getCount() >= 20) {
                worldIn.setBlockState(pos, state.withProperty(FILLED, true));
                stack.shrink(20);
                return true;
            }
            else {
                return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
            }
        }
        else {
            return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
        }
    }

    public IBlockState getStateFromMeta(int meta) {
        return (meta & 8) > 0 ? this.getDefaultState().withProperty(HALF, BlockBirdfeeder.EnumBlockHalf.UPPER).withProperty(FILLED, Boolean.valueOf((meta & 2) > 0)) : this.getDefaultState().withProperty(HALF, EnumBlockHalf.LOWER).withProperty(FILLED, false);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | (state.getValue(FILLED) ? 2 : 0);
        i = i | (state.getValue(HALF) == BlockBirdfeeder.EnumBlockHalf.UPPER ? 8 : 0);
        return i;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[]{FILLED, HALF});
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    public static enum EnumBlockHalf implements IStringSerializable
    {
        UPPER,
        LOWER;

        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            return this == UPPER ? "upper" : "lower";
        }
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);

        if(random.nextInt(10)==1) {
            if (state.getValue(HALF) == EnumBlockHalf.UPPER) {
                if (state.getValue(FILLED)) {
                    worldIn.setBlockState(pos, state.withProperty(FILLED, false));
                }
            }
        }
    }

    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (state.getValue(HALF) == BlockBirdfeeder.EnumBlockHalf.UPPER)
        {
            BlockPos blockpos = pos.down();
            IBlockState iblockstate = worldIn.getBlockState(blockpos);

            if (iblockstate.getBlock() != this)
            {
                if(state.getValue(FILLED) && !worldIn.isRemote){
                    ItemStack seeds = new ItemStack(Items.WHEAT_SEEDS, this.random.nextInt(20));
                    spawnAsEntity(worldIn, pos, seeds);
                }
                worldIn.setBlockToAir(pos);
            }
            else if (blockIn != this)
            {
                iblockstate.neighborChanged(worldIn, blockpos, blockIn, fromPos);
            }
        }
        else {
            BlockPos blockpos1 = pos.up();
            IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

            if (iblockstate1.getBlock() != this) {
                worldIn.setBlockToAir(pos);
            }

            if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP)) {
                worldIn.setBlockToAir(pos);

                if (iblockstate1.getBlock() == this) {
                    worldIn.setBlockToAir(blockpos1);
                }
            }
        }
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockDestroyedByPlayer(worldIn, pos, state);
        if(state.getValue(HALF)== EnumBlockHalf.UPPER){
            if(state.getValue(FILLED) && !worldIn.isRemote){
                ItemStack seeds = new ItemStack(Items.WHEAT_SEEDS, this.random.nextInt(20));
                spawnAsEntity(worldIn, pos, seeds);
            }
        }
    }
}
