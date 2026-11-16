package com.lyl.learnmod.datagen;

import com.lyl.learnmod.LearnMod;
import com.lyl.learnmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * 生成方块标签（data/minecraft/tags/blocks/*.json）。
 *
 * <p>{@code mineable/pickaxe} 决定用镐子挖得动、挖得快；
 * {@code needs_iron_tool} 决定木镐挖了不掉东西（必须铁镐及以上）。</p>
 */
public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output,
                                CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LearnMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // 所有方块都能用镐子挖
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LEAD_ORE.get())
                .add(ModBlocks.GRAPHITE_ORE.get())
                .add(ModBlocks.PHASE_FABRIC_WALL.get())
                .add(ModBlocks.PLASTANIUM_WALL.get())
                .add(ModBlocks.COPPER_WALL.get())
                .add(ModBlocks.LEAD_CRYSTAL.get());

        // 两种矿石需要铁镐及以上才能掉落
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LEAD_ORE.get())
                .add(ModBlocks.GRAPHITE_ORE.get());
    }
}
