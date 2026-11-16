package com.lyl.learnmod.datagen;

import com.lyl.learnmod.LearnMod;
import com.lyl.learnmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

/**
 * 生成合成配方（data/learn_mod/recipes/*.json）。
 *
 * <p>每个配方都要写 {@code unlockedBy(...)}，否则配方书里不会解锁。</p>
 */
public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        // 铜墙：2x3 铜锭 → 1 个铜墙（和原版墙类配方一致）
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COPPER_WALL.get())
                .define('#', Items.COPPER_INGOT)
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(writer);

        // 铜墙 → 6 个铜锭（无序合成，反向拆解）
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_INGOT, 6)
                .requires(ModBlocks.COPPER_WALL.get())
                .unlockedBy("has_copper_wall", has(ModBlocks.COPPER_WALL.get()))
                // 显式给配方 id 加本模组的命名空间，否则默认会落到 minecraft: 下
                .save(writer, new ResourceLocation(LearnMod.MOD_ID, "copper_from_copper_wall"));
    }
}
