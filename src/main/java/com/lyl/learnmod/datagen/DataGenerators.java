package com.lyl.learnmod.datagen;

import com.lyl.learnmod.LearnMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 数据生成的总入口。
 *
 * <p>只有在跑 {@code gradlew runData} 时才会被调用，正常游戏里不会触发。</p>
 *
 * <p>生成结果全部写到 {@code src/generated/resources}，并且通过 build.gradle 里的
 * {@code sourceSets.main.resources { srcDir 'src/generated/resources' }} 打进 mod 里。</p>
 */
@Mod.EventBusSubscriber(modid = LearnMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // ---------- 服务端数据（data/ 目录，进世界时加载）----------
        generator.addProvider(event.includeServer(), new ModRecipeProvider(output));
        generator.addProvider(event.includeServer(), new ModLootTableProvider(output));
        generator.addProvider(event.includeServer(),
                new ModBlockTagsProvider(output, event.getLookupProvider(), existingFileHelper));

        // ---------- 客户端资源（assets/ 目录，渲染用）----------
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModLangProvider(output, "en_us"));
        generator.addProvider(event.includeClient(), new ModLangProvider(output, "zh_cn"));
    }
}
