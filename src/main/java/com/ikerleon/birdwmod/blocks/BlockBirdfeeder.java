package com.ikerleon.birdwmod.blocks;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.entity.EntityBird;
import com.ikerleon.birdwmod.init.BirdwmodBlocks;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
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
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.List;

public class BlockBirdfeeder extends BlockContainer {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final PropertyInteger FILLED = PropertyInteger.create("filled", 0,1);
    private static final AxisAlignedBB BASE_BOX = new AxisAlignedBB(0, 0, 0, 1, 0.0625 * 2, 1);
    private static final AxisAlignedBB STICK_BOX = new AxisAlignedBB(0.0625 * 7, 0.0625 * 1, 0.0625 * 7, 0.0625 * 9, 0.0625 * 8, 0.0625 * 9);
    private static final AxisAlignedBB FEEDER_BOX = new AxisAlignedBB(0.0625 * 5, 0.0625 * 8, 0.0625 * 5, 0.0625 * 11, 0.0625 * 14, 0.0625 * 11);
    protected static final Logger LOGGER = LogManager.getLogger();

    private static boolean filled = false;
    private static int seedsremain = 0;

    public BlockBirdfeeder(Material materialIn, String name) {
        super(materialIn);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        BirdwmodBlocks.BLOCKS.add(this);
        this.setCreativeTab(Main.BIRDWATCHINGMOD);

        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(FILLED, Integer.valueOf(0)));

        BirdwmodItems.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
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
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BASE_BOX;
    }

    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
        addCollisionBoxToList(pos, entityBox, collidingBoxes, STICK_BOX);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, FEEDER_BOX);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, BASE_BOX);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = playerIn.getHeldItem(hand);

        if (stack != null && (stack.getItem() == Items.SPAWN_EGG)) {
            return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
        }
        else {
            if (!this.isFilled()) {
                if (stack.getItem() == Items.WHEAT && stack.getCount() >= 20) {

                    stack.shrink(20);
                    filled = true;
                    worldIn.setBlockState(pos, state.withProperty(FILLED, Integer.valueOf(1)), 4);
                    this.seedsremain=20;
                    return true;
                }
                else {
                    filled = false;
                    worldIn.setBlockState(pos, state.withProperty(FILLED, Integer.valueOf(0)), 4);
                    return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
                }
            }
            else {
                return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
            }
        }
    }

    public static boolean isFilled() {
        return filled;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if(this.isFilled() && entityIn instanceof EntityBird){
            seedsremain=seedsremain - 1;
        }

    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        EnumFacing enumfacing = placer.getHorizontalFacing().rotateY();

        try
        {
            return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, enumfacing).withProperty(FILLED, Integer.valueOf(meta >> 1));
        }
        catch (IllegalArgumentException var11)
        {
            if (!worldIn.isRemote)
            {
                LOGGER.warn(String.format("Invalid damage property for feeder at %s. Found %d, must be in [0, 1]", pos, meta >> 1));

                if (placer instanceof EntityPlayer)
                {
                    placer.sendMessage(new TextComponentTranslation("Invalid filled property. Please pick in [0, 1]", new Object[0]));
                }
            }

            return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, 0, placer).withProperty(FACING, enumfacing).withProperty(FILLED, Integer.valueOf(0));
        }
    }

    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        items.add(new ItemStack(this));
        items.add(new ItemStack(this, 1, 1));
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3)).withProperty(FILLED, Integer.valueOf((meta & 15) >> 1));
    }

    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
        i = i | ((Integer)state.getValue(FILLED)).intValue() << 1;
        return i;
    }

    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.getBlock() != this ? state : state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, FILLED});
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }
}
