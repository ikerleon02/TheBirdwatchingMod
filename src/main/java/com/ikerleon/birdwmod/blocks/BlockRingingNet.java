package com.ikerleon.birdwmod.blocks;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.init.BirdwmodBlocks;
import com.ikerleon.birdwmod.init.BirdwmodItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockRingingNet extends Block {

    public static final PropertyEnum<EnumBlockType> TYPE = PropertyEnum.<EnumBlockType>create("type", EnumBlockType.class);
    public static final PropertyEnum<EnumBlockDirection> DIRECTION = PropertyEnum.<EnumBlockDirection>create("direction", EnumBlockDirection.class);

    AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.4375D, 1.0D, 1.0D, 0.5625D);
    AxisAlignedBB AABB2 = new AxisAlignedBB(0.4375D, 0.0D, 0.0D, 0.5625D, 1.0D, 1.0D);

    public BlockRingingNet(Material materialIn, String name) {
        super(materialIn);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setHardness(0.5F);
        BirdwmodBlocks.BLOCKS.add(this);
        this.setCreativeTab(Main.BIRDWATCHINGMOD);

        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumBlockType.NORMAL).withProperty(DIRECTION, EnumBlockDirection.NORTH));

        BirdwmodItems.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {

        if(placer.getHorizontalFacing() == EnumFacing.NORTH || placer.getHorizontalFacing() == EnumFacing.SOUTH){
            worldIn.setBlockState(pos, state.withProperty(DIRECTION, EnumBlockDirection.NORTH));
        }
        else {
            worldIn.setBlockState(pos, state.withProperty(DIRECTION, EnumBlockDirection.EAST));
        }
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[]{TYPE, DIRECTION});
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if(state.getValue(DIRECTION) == EnumBlockDirection.NORTH) {
            return AABB;
        }
        else{
            return AABB2;
        }
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if(state.getValue(DIRECTION) == EnumBlockDirection.NORTH) {
            if (worldIn.getBlockState(pos.west()).getBlock() == BirdwmodBlocks.RINGING_NET && worldIn.getBlockState(pos.west()).getValue(DIRECTION) == EnumBlockDirection.NORTH && worldIn.getBlockState(pos.east()).getBlock() == BirdwmodBlocks.RINGING_NET && worldIn.getBlockState(pos.east()).getValue(DIRECTION) == EnumBlockDirection.NORTH) {
                worldIn.setBlockState(pos, state.withProperty(TYPE, EnumBlockType.NET));
            } else if (worldIn.getBlockState(pos.east()).getBlock() == BirdwmodBlocks.RINGING_NET && worldIn.getBlockState(pos.east()).getValue(DIRECTION) == EnumBlockDirection.NORTH) {
                worldIn.setBlockState(pos, state.withProperty(TYPE, EnumBlockType.RIGHT));
            } else if (worldIn.getBlockState(pos.west()).getBlock() == BirdwmodBlocks.RINGING_NET && worldIn.getBlockState(pos.west()).getValue(DIRECTION) == EnumBlockDirection.NORTH) {
                worldIn.setBlockState(pos, state.withProperty(TYPE, EnumBlockType.LEFT));
            } else {
                worldIn.setBlockState(pos, state.withProperty(TYPE, EnumBlockType.NORMAL));
            }
        }
        if(state.getValue(DIRECTION) == EnumBlockDirection.EAST) {
            if (worldIn.getBlockState(pos.south()).getBlock() == BirdwmodBlocks.RINGING_NET && worldIn.getBlockState(pos.south()).getValue(DIRECTION) == EnumBlockDirection.EAST && worldIn.getBlockState(pos.north()).getBlock() == BirdwmodBlocks.RINGING_NET && worldIn.getBlockState(pos.north()).getValue(DIRECTION) == EnumBlockDirection.EAST) {
                worldIn.setBlockState(pos, state.withProperty(TYPE, EnumBlockType.NET));
            } else if (worldIn.getBlockState(pos.north()).getBlock() == BirdwmodBlocks.RINGING_NET && worldIn.getBlockState(pos.north()).getValue(DIRECTION) == EnumBlockDirection.EAST) {
                worldIn.setBlockState(pos, state.withProperty(TYPE, EnumBlockType.LEFT));
            } else if (worldIn.getBlockState(pos.south()).getBlock() == BirdwmodBlocks.RINGING_NET && worldIn.getBlockState(pos.south()).getValue(DIRECTION) == EnumBlockDirection.EAST) {
                worldIn.setBlockState(pos, state.withProperty(TYPE, EnumBlockType.RIGHT));
            } else {
                worldIn.setBlockState(pos, state.withProperty(TYPE, EnumBlockType.NORMAL));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = this.getDefaultState();

        state = state.withProperty(DIRECTION, EnumBlockDirection.getFront(meta & 1));

        if((meta & 2) != 0 && (meta & 4) == 0){
            state = state.withProperty(TYPE, EnumBlockType.NET);
        }
        else if((meta & 2) == 0 && (meta & 4) == 0){
            state = state.withProperty(TYPE, EnumBlockType.NORMAL);
        }
        else if((meta & 2) != 0 && (meta & 4) != 0){
            state = state.withProperty(TYPE, EnumBlockType.LEFT);
        }
        else if((meta & 2) == 0 && (meta & 4) != 0){
            state = state.withProperty(TYPE, EnumBlockType.RIGHT);
        }

        return state;
    }

    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        i = i | (state.getValue(DIRECTION).getIndex());

        switch(state.getValue(TYPE)){
            case NORMAL:
                break;
            case NET:
                i = i | 2;
                break;
            case RIGHT:
                i = i | 4;
                break;
            case LEFT:
                i = i | 6;
                break;
        }
        return i;
    }

    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }

    public static enum EnumBlockType implements IStringSerializable
    {
        NORMAL(0),
        RIGHT(1),
        LEFT(2),
        NET(3);

        private final int index;

        EnumBlockType(int indexIn)
        {
            this.index = indexIn;
        }

        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            if(this == NORMAL){
                return "normal";
            }
            else if(this == RIGHT){
                return "right";
            }
            else if(this == LEFT){
                return "left";
            }
            else {
                return "net";
            }
        }

        public static EnumBlockType getFront(int index)
        {
            switch(index) {
            case 0:
                return EnumBlockType.NORMAL;
            case 1:
                return EnumBlockType.RIGHT;
            case 2:
                return EnumBlockType.LEFT;
            case 3:
                return EnumBlockType.NET;
            default:
                return EnumBlockType.NORMAL;
            }
        }

        public int getIndex()
        {
            return this.index;
        }
    }

    public static enum EnumBlockDirection implements IStringSerializable
    {
        NORTH(0),
        EAST(1);

        private final int index;

        EnumBlockDirection(int indexIn)
        {
            this.index = indexIn;
        }

        public String toString()
        {
            return this.getName();
        }

        public String getName()
        {
            return this == EnumBlockDirection.NORTH ? "north" : "east";
        }

        public static EnumBlockDirection getFront(int index)
        {
            return index == 0 ? EnumBlockDirection.NORTH : EnumBlockDirection.EAST;
        }

        public int getIndex()
        {
            return this.index;
        }
    }
}
