package com.lyl.learnmod.datagen;

import com.lyl.learnmod.block.ModBlocks;
import com.lyl.learnmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {
    protected ModBlockLootTablesProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        dropSelf(ModBlocks.COPPER_WALL.get());
        dropSelf(ModBlocks.PLASTANIUM_WALL.get());
        dropSelf(ModBlocks.PHASE_FABRIC_WALL.get());
        dropSelf(ModBlocks.LEAD_CRYSTAL.get());
        //            ore
        add(ModBlocks.LEAD_ORE.get(),block -> createModOreDrops(ModBlocks.LEAD_ORE.get(), ModItems.LEAD.get()));
        add(ModBlocks.GRAPHITE_ORE.get(),block -> createModOreDrops(ModBlocks.GRAPHITE_ORE.get(), ModItems.GRAPHITE.get()));
    }

    protected LootTable.Builder createModOreDrops(Block pBlock,Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
