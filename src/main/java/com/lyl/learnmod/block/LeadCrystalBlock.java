package com.lyl.learnmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * 铅晶簇：不是满方块，所以要自己给一个碰撞/选中形状，并关掉遮挡（noOcclusion）。
 * 渲染形状默认就是 MODEL，配合 blockstates 里的 forge:obj 模型即可。
 */
public class LeadCrystalBlock extends Block {
    private static final VoxelShape SHAPE = Shapes.box(1.0D / 16, 0.0D, 1.0D / 16, 15.0D / 16, 8.0D / 16, 15.0D / 16);

    public LeadCrystalBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
