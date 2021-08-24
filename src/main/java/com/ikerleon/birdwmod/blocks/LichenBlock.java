package com.ikerleon.birdwmod.blocks;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class LichenBlock extends Block {
    public static final BooleanProperty UP;
    public static final BooleanProperty NORTH;
    public static final BooleanProperty EAST;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty WEST;
    public static final Map<Direction, BooleanProperty> FACING_PROPERTIES;
    protected static final float field_31275 = 1.0F;
    private static final VoxelShape UP_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape WEST_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape NORTH_SHAPE;
    private final Map<BlockState, VoxelShape> shapesByState;


    public LichenBlock() {
        super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().ticksRandomly().strength(0.2F).sounds(BlockSoundGroup.GLOW_LICHEN).nonOpaque().luminance(7));
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(UP, false)).with(NORTH, false)).with(EAST, false)).with(SOUTH, false)).with(WEST, false));
        this.shapesByState = ImmutableMap.copyOf((Map)this.stateManager.getStates().stream().collect(Collectors.toMap(Function.identity(), LichenBlock::getShapeForState)));
    }

    private static VoxelShape getShapeForState(BlockState state) {
        VoxelShape voxelShape = VoxelShapes.empty();
        if ((Boolean)state.get(UP)) {
            voxelShape = UP_SHAPE;
        }

        if ((Boolean)state.get(NORTH)) {
            voxelShape = VoxelShapes.union(voxelShape, SOUTH_SHAPE);
        }

        if ((Boolean)state.get(SOUTH)) {
            voxelShape = VoxelShapes.union(voxelShape, NORTH_SHAPE);
        }

        if ((Boolean)state.get(EAST)) {
            voxelShape = VoxelShapes.union(voxelShape, WEST_SHAPE);
        }

        if ((Boolean)state.get(WEST)) {
            voxelShape = VoxelShapes.union(voxelShape, EAST_SHAPE);
        }

        return voxelShape.isEmpty() ? VoxelShapes.fullCube() : voxelShape;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return (VoxelShape)this.shapesByState.get(state);
    }

    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return this.hasAdjacentBlocks(this.getPlacementShape(state, world, pos));
    }

    private boolean hasAdjacentBlocks(BlockState state) {
        return this.getAdjacentBlockCount(state) > 0;
    }

    private int getAdjacentBlockCount(BlockState state) {
        int i = 0;
        Iterator var3 = FACING_PROPERTIES.values().iterator();

        while(var3.hasNext()) {
            BooleanProperty booleanProperty = (BooleanProperty)var3.next();
            if ((Boolean)state.get(booleanProperty)) {
                ++i;
            }
        }

        return i;
    }

    private boolean shouldHaveSide(BlockView world, BlockPos pos, Direction side) {
        if (side == Direction.DOWN) {
            return false;
        } else {
            BlockPos blockPos = pos.offset(side);
            if (shouldConnectTo(world, blockPos, side)) {
                return true;
            } else if (side.getAxis() == Direction.Axis.Y) {
                return false;
            } else {
                BooleanProperty booleanProperty = (BooleanProperty)FACING_PROPERTIES.get(side);
                BlockState blockState = world.getBlockState(pos.up());
                return blockState.isOf(this) && (Boolean)blockState.get(booleanProperty);
            }
        }
    }

    public static boolean shouldConnectTo(BlockView world, BlockPos pos, Direction direction) {
        BlockState blockState = world.getBlockState(pos);
        return Block.isFaceFullSquare(blockState.getCollisionShape(world, pos), direction.getOpposite());
    }

    private BlockState getPlacementShape(BlockState state, BlockView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        if ((Boolean)state.get(UP)) {
            state = (BlockState)state.with(UP, shouldConnectTo(world, blockPos, Direction.DOWN));
        }

        BlockState blockState = null;
        Iterator var6 = Direction.Type.HORIZONTAL.iterator();

        while(true) {
            Direction direction;
            BooleanProperty booleanProperty;
            do {
                if (!var6.hasNext()) {
                    return state;
                }

                direction = (Direction)var6.next();
                booleanProperty = getFacingProperty(direction);
            } while(!(Boolean)state.get(booleanProperty));

            boolean bl = this.shouldHaveSide(world, pos, direction);
            if (!bl) {
                if (blockState == null) {
                    blockState = world.getBlockState(blockPos);
                }

                bl = blockState.isOf(this) && (Boolean)blockState.get(booleanProperty);
            }

            state = (BlockState)state.with(booleanProperty, bl);
        }
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.DOWN) {
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        } else {
            BlockState blockState = this.getPlacementShape(state, world, pos);
            return !this.hasAdjacentBlocks(blockState) ? Blocks.AIR.getDefaultState() : blockState;
        }
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(4) == 0) {
            Direction direction = Direction.random(random);
            BlockPos blockPos = pos.up();
            BlockPos blockPos2;
            BlockState blockState3;
            Direction direction5;
            if (direction.getAxis().isHorizontal() && !(Boolean)state.get(getFacingProperty(direction))) {
                if (this.canGrowAt(world, pos)) {
                    blockPos2 = pos.offset(direction);
                    blockState3 = world.getBlockState(blockPos2);
                    if (blockState3.isAir()) {
                        direction5 = direction.rotateYClockwise();
                        Direction direction3 = direction.rotateYCounterclockwise();
                        boolean bl = (Boolean)state.get(getFacingProperty(direction5));
                        boolean bl2 = (Boolean)state.get(getFacingProperty(direction3));
                        BlockPos blockPos3 = blockPos2.offset(direction5);
                        BlockPos blockPos4 = blockPos2.offset(direction3);
                        if (bl && shouldConnectTo(world, blockPos3, direction5)) {
                            world.setBlockState(blockPos2, (BlockState)this.getDefaultState().with(getFacingProperty(direction5), true), Block.NOTIFY_LISTENERS);
                        } else if (bl2 && shouldConnectTo(world, blockPos4, direction3)) {
                            world.setBlockState(blockPos2, (BlockState)this.getDefaultState().with(getFacingProperty(direction3), true), Block.NOTIFY_LISTENERS);
                        } else {
                            Direction direction4 = direction.getOpposite();
                            if (bl && world.isAir(blockPos3) && shouldConnectTo(world, pos.offset(direction5), direction4)) {
                                world.setBlockState(blockPos3, (BlockState)this.getDefaultState().with(getFacingProperty(direction4), true), Block.NOTIFY_LISTENERS);
                            } else if (bl2 && world.isAir(blockPos4) && shouldConnectTo(world, pos.offset(direction3), direction4)) {
                                world.setBlockState(blockPos4, (BlockState)this.getDefaultState().with(getFacingProperty(direction4), true), Block.NOTIFY_LISTENERS);
                            } else if ((double)random.nextFloat() < 0.05D && shouldConnectTo(world, blockPos2.up(), Direction.UP)) {
                                world.setBlockState(blockPos2, (BlockState)this.getDefaultState().with(UP, true), Block.NOTIFY_LISTENERS);
                            }
                        }
                    } else if (shouldConnectTo(world, blockPos2, direction)) {
                        world.setBlockState(pos, (BlockState)state.with(getFacingProperty(direction), true), Block.NOTIFY_LISTENERS);
                    }

                }
            } else {
                if (direction == Direction.UP && pos.getY() < world.getTopY() - 1) {
                    if (this.shouldHaveSide(world, pos, direction)) {
                        world.setBlockState(pos, (BlockState)state.with(UP, true), Block.NOTIFY_LISTENERS);
                        return;
                    }

                    if (world.isAir(blockPos)) {
                        if (!this.canGrowAt(world, pos)) {
                            return;
                        }

                        BlockState blockState2 = state;
                        Iterator var17 = Direction.Type.HORIZONTAL.iterator();

                        while(true) {
                            do {
                                if (!var17.hasNext()) {
                                    if (this.hasHorizontalSide(blockState2)) {
                                        world.setBlockState(blockPos, blockState2, Block.NOTIFY_LISTENERS);
                                    }

                                    return;
                                }

                                direction5 = (Direction)var17.next();
                            } while(!random.nextBoolean() && shouldConnectTo(world, blockPos.offset(direction5), direction5));

                            blockState2 = (BlockState)blockState2.with(getFacingProperty(direction5), false);
                        }
                    }
                }

                if (pos.getY() > world.getBottomY()) {
                    blockPos2 = pos.down();
                    blockState3 = world.getBlockState(blockPos2);
                    if (blockState3.isAir() || blockState3.isOf(this)) {
                        BlockState blockState4 = blockState3.isAir() ? this.getDefaultState() : blockState3;
                        BlockState blockState5 = this.getGrownState(state, blockState4, random);
                        if (blockState4 != blockState5 && this.hasHorizontalSide(blockState5)) {
                            world.setBlockState(blockPos2, blockState5, Block.NOTIFY_LISTENERS);
                        }
                    }
                }

            }
        }
    }

    private BlockState getGrownState(BlockState above, BlockState state, Random random) {
        Iterator var4 = Direction.Type.HORIZONTAL.iterator();

        while(var4.hasNext()) {
            Direction direction = (Direction)var4.next();
            if (random.nextBoolean()) {
                BooleanProperty booleanProperty = getFacingProperty(direction);
                if ((Boolean)above.get(booleanProperty)) {
                    state = (BlockState)state.with(booleanProperty, true);
                }
            }
        }

        return state;
    }

    private boolean hasHorizontalSide(BlockState state) {
        return (Boolean)state.get(NORTH) || (Boolean)state.get(EAST) || (Boolean)state.get(SOUTH) || (Boolean)state.get(WEST);
    }

    private boolean canGrowAt(BlockView world, BlockPos pos) {
        boolean i = true;
        Iterable<BlockPos> iterable = BlockPos.iterate(pos.getX() - 4, pos.getY() - 1, pos.getZ() - 4, pos.getX() + 4, pos.getY() + 1, pos.getZ() + 4);
        int j = 5;
        Iterator var6 = iterable.iterator();

        while(var6.hasNext()) {
            BlockPos blockPos = (BlockPos)var6.next();
            if (world.getBlockState(blockPos).isOf(this)) {
                --j;
                if (j <= 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        BlockState blockState = context.getWorld().getBlockState(context.getBlockPos());
        if (blockState.isOf(this)) {
            return this.getAdjacentBlockCount(blockState) < FACING_PROPERTIES.size();
        } else {
            return super.canReplace(state, context);
        }
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        boolean bl = blockState.isOf(this);
        BlockState blockState2 = bl ? blockState : this.getDefaultState();
        Direction[] var5 = ctx.getPlacementDirections();
        int var6 = var5.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Direction direction = var5[var7];
            if (direction != Direction.DOWN) {
                BooleanProperty booleanProperty = getFacingProperty(direction);
                boolean bl2 = bl && (Boolean)blockState.get(booleanProperty);
                if (!bl2 && this.shouldHaveSide(ctx.getWorld(), ctx.getBlockPos(), direction)) {
                    return (BlockState)blockState2.with(booleanProperty, true);
                }
            }
        }

        return bl ? blockState2 : null;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(UP, NORTH, EAST, SOUTH, WEST);
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        switch(rotation) {
            case CLOCKWISE_180:
                return (BlockState)((BlockState)((BlockState)((BlockState)state.with(NORTH, (Boolean)state.get(SOUTH))).with(EAST, (Boolean)state.get(WEST))).with(SOUTH, (Boolean)state.get(NORTH))).with(WEST, (Boolean)state.get(EAST));
            case COUNTERCLOCKWISE_90:
                return (BlockState)((BlockState)((BlockState)((BlockState)state.with(NORTH, (Boolean)state.get(EAST))).with(EAST, (Boolean)state.get(SOUTH))).with(SOUTH, (Boolean)state.get(WEST))).with(WEST, (Boolean)state.get(NORTH));
            case CLOCKWISE_90:
                return (BlockState)((BlockState)((BlockState)((BlockState)state.with(NORTH, (Boolean)state.get(WEST))).with(EAST, (Boolean)state.get(NORTH))).with(SOUTH, (Boolean)state.get(EAST))).with(WEST, (Boolean)state.get(SOUTH));
            default:
                return state;
        }
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        switch(mirror) {
            case LEFT_RIGHT:
                return (BlockState)((BlockState)state.with(NORTH, (Boolean)state.get(SOUTH))).with(SOUTH, (Boolean)state.get(NORTH));
            case FRONT_BACK:
                return (BlockState)((BlockState)state.with(EAST, (Boolean)state.get(WEST))).with(WEST, (Boolean)state.get(EAST));
            default:
                return super.mirror(state, mirror);
        }
    }

    public static BooleanProperty getFacingProperty(Direction direction) {
        return (BooleanProperty)FACING_PROPERTIES.get(direction);
    }

    static {
        UP = ConnectingBlock.UP;
        NORTH = ConnectingBlock.NORTH;
        EAST = ConnectingBlock.EAST;
        SOUTH = ConnectingBlock.SOUTH;
        WEST = ConnectingBlock.WEST;
        FACING_PROPERTIES = (Map)ConnectingBlock.FACING_PROPERTIES.entrySet().stream().filter((entry) -> {
            return entry.getKey() != Direction.DOWN;
        }).collect(Util.toMap());
        UP_SHAPE = Block.createCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
        EAST_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
        WEST_SHAPE = Block.createCuboidShape(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
        SOUTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
        NORTH_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
    }
}
