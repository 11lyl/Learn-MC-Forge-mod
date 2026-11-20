package com.lyl.learnmod.datagen;

import com.lyl.learnmod.LearnMod;
import com.lyl.learnmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * 生成纯物品的模型（models/item/*.json）。
 *
 * <p>{@code basicItem} 会输出 {@code parent: item/generated} + {@code layer0: learn_mod:item/<名字>}，
 * 也就是「拿一张 16x16 / 32x32 的贴图当图标」的标准写法。</p>
 *
 * <p>方块的物品模型由 {@link ModBlockStateProvider#simpleBlockWithItem} 一起生成；
 * OBJ 方块（铅晶簇、三种墙）的物品模型手写在 src/main/resources 里，因为带自定义 display 变换。</p>
 */
public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LearnMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.LEAD.get());
        basicItem(ModItems.GRAPHITE.get());
        basicItem(ModItems.META_GLASS.get());
        basicItem(ModItems.PHASE_FABRIC.get());
        basicItem(ModItems.PLASTANIUM.get());
        basicItem(ModItems.STRAWBERRY.get());
        basicItem(ModItems.CHEESE.get());
        basicItem(ModItems.CORN.get());
        basicItem(ModItems.ANTHRACITE.get());
        basicItem(ModItems.PROSPECTOR.get());
    }
}
