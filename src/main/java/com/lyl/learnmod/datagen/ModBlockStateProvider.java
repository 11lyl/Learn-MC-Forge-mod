package com.lyl.learnmod.datagen;

import com.lyl.learnmod.LearnMod;
import com.lyl.learnmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * 生成方块状态文件（blockstates/*.json）和方块模型（models/block/*.json）。
 *
 * <p>普通六面方块用 {@code cubeAll} 一把梭；OBJ 模型方块（铅晶簇、三种墙）的
 * blockstate 和模型是手写在 src/main/resources 里的静态资源（模型里要引用
 * .obj/.mtl 文件和 {forge:obj} 加载器），这里不参与生成，否则会被覆盖成普通立方体。</p>
 */
public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LearnMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // 铅矿：六面同贴图
        simpleBlockWithItem(ModBlocks.LEAD_ORE.get(), cubeAll(ModBlocks.LEAD_ORE.get()));
        // 石墨矿：六面同贴图
        simpleBlockWithItem(ModBlocks.GRAPHITE_ORE.get(), cubeAll(ModBlocks.GRAPHITE_ORE.get()));
    }
}
