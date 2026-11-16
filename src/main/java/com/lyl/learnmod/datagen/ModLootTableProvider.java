package com.lyl.learnmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

/**
 * 掉落表的调度器：把 {@link ModBlockLootTablesProvider} 注册成「方块掉落表」这一类的数据源。
 */
public class ModLootTableProvider extends LootTableProvider {

    public ModLootTableProvider(PackOutput output) {
        super(output,
                // 必须生成的表（留空即可，默认会检查全部）
                Set.of(),
                // 数据源 + 它的上下文类型
                List.of(new SubProviderEntry(ModBlockLootTablesProvider::new, LootContextParamSets.BLOCK)));
    }
}
