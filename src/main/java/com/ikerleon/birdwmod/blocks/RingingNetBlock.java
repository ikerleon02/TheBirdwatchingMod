package com.ikerleon.birdwmod.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class RingingNetBlock extends Block {

    public static final EnumProperty<EnumBlockType> TYPE = EnumProperty.of("type", EnumBlockType.class);
    public static final EnumProperty<EnumBlockDirection> DIRECTION = EnumProperty.of("direction", EnumBlockDirection.class);

    public RingingNetBlock() {
        super(FabricBlockSettings.of(Material.COBWEB).nonOpaque());

        setDefaultState(getStateManager().getDefaultState().with(TYPE, EnumBlockType.NORMAL).with(DIRECTION, EnumBlockDirection.NORTH));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if(state.get(DIRECTION) == EnumBlockDirection.NORTH) {
            if(state.get(TYPE) == EnumBlockType.NORMAL) {
                return VoxelShapes.union(VoxelShapes.cuboid(0.0D, 0.0D, 0.4375D, 0.125D, 1.0D, 0.5625D), VoxelShapes.cuboid(0.875D, 0.0D, 0.4375D, 1.0D, 1.0D, 0.5625D));
            }
            else if(state.get(TYPE) == EnumBlockType.LEFT) {
                return VoxelShapes.cuboid(0.875D, 0.0D, 0.4375D, 1.0D, 1.0D, 0.5625D);
            }
            else if(state.get(TYPE) == EnumBlockType.RIGHT) {
                return VoxelShapes.cuboid(0.0D, 0.0D, 0.4375D, 0.125D, 1.0D, 0.5625D);
            }
            else {
                return VoxelShapes.empty();
            }
        }
        else{
            if(state.get(TYPE) == EnumBlockType.NORMAL) {
                return VoxelShapes.union(VoxelShapes.cuboid(0.4375D, 0.0D, 0.0D, 0.5625D, 1.0D, 0.125D), VoxelShapes.cuboid(0.4375D, 0.0D, 0.875D, 0.5625D, 1.0D, 1.0D));
            }
            else if(state.get(TYPE) == EnumBlockType.LEFT) {
                return VoxelShapes.cuboid(0.4375D, 0.0D, 0.875D, 0.5625D, 1.0D, 1.0D);
            }
            else if(state.get(TYPE) == EnumBlockType.RIGHT) {
                return VoxelShapes.cuboid(0.4375D, 0.0D, 0.0D, 0.5625D, 1.0D, 0.125D);
            }
            else {
                return VoxelShapes.empty();
            }
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if(state.get(DIRECTION) == EnumBlockDirection.NORTH) {
            return VoxelShapes.cuboid(0.0D, 0.0D, 0.4375D, 1.0D, 1.0D, 0.5625D);
        }
        else{
            return VoxelShapes.cuboid(0.4375D, 0.0D, 0.0D, 0.5625D, 1.0D, 1.0D);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE).add(DIRECTION);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if(ctx.getPlayerFacing() == Direction.NORTH || ctx.getPlayerFacing() == Direction.SOUTH){
            return this.getDefaultState().with(DIRECTION, EnumBlockDirection.NORTH);
        }
        else {
            return this.getDefaultState().with(DIRECTION, EnumBlockDirection.EAST);
        }
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void neighborUpdate(BlockState state, World worldIn, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if(state.get(DIRECTION) == EnumBlockDirection.NORTH) {
            if (worldIn.getBlockState(pos.west()).getBlock() == InitBlocks.RINGING_NET && worldIn.getBlockState(pos.west()).get(DIRECTION) == EnumBlockDirection.NORTH && worldIn.getBlockState(pos.east()).getBlock() == InitBlocks.RINGING_NET && worldIn.getBlockState(pos.east()).get(DIRECTION) == EnumBlockDirection.NORTH) {
                worldIn.setBlockState(pos, state.with(TYPE, EnumBlockType.NET));
            } else if (worldIn.getBlockState(pos.east()).getBlock() == InitBlocks.RINGING_NET && worldIn.getBlockState(pos.east()).get(DIRECTION) == EnumBlockDirection.NORTH) {
                worldIn.setBlockState(pos, state.with(TYPE, EnumBlockType.RIGHT));
            } else if (worldIn.getBlockState(pos.west()).getBlock() == InitBlocks.RINGING_NET && worldIn.getBlockState(pos.west()).get(DIRECTION) == EnumBlockDirection.NORTH) {
                worldIn.setBlockState(pos, state.with(TYPE, EnumBlockType.LEFT));
            } else {
                worldIn.setBlockState(pos, state.with(TYPE, EnumBlockType.NORMAL));
            }
        }
        if(state.get(DIRECTION) == EnumBlockDirection.EAST) {
            if (worldIn.getBlockState(pos.south()).getBlock() == InitBlocks.RINGING_NET && worldIn.getBlockState(pos.south()).get(DIRECTION) == EnumBlockDirection.EAST && worldIn.getBlockState(pos.north()).getBlock() == InitBlocks.RINGING_NET && worldIn.getBlockState(pos.north()).get(DIRECTION) == EnumBlockDirection.EAST) {
                worldIn.setBlockState(pos, state.with(TYPE, EnumBlockType.NET));
            } else if (worldIn.getBlockState(pos.north()).getBlock() == InitBlocks.RINGING_NET && worldIn.getBlockState(pos.north()).get(DIRECTION) == EnumBlockDirection.EAST) {
                worldIn.setBlockState(pos, state.with(TYPE, EnumBlockType.LEFT));
            } else if (worldIn.getBlockState(pos.south()).getBlock() == InitBlocks.RINGING_NET && worldIn.getBlockState(pos.south()).get(DIRECTION) == EnumBlockDirection.EAST) {
                worldIn.setBlockState(pos, state.with(TYPE, EnumBlockType.RIGHT));
            } else {
                worldIn.setBlockState(pos, state.with(TYPE, EnumBlockType.NORMAL));
            }
        }
    }

    public enum EnumBlockType implements StringIdentifiable
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

        @Override
        public String asString() {
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
    }

    public enum EnumBlockDirection implements StringIdentifiable
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

        @Override
        public String asString() {
            return this == EnumBlockDirection.NORTH ? "north" : "east";
        }
    }
}

