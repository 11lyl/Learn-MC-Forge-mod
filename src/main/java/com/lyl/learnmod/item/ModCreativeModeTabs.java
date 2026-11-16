package com.lyl.learnmod.item;

import com.lyl.learnmod.LearnMod;
import com.lyl.learnmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LearnMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MINDUSTRY_TAB =
            CREATIVE_MODE_TABS.register("mindustry_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.GRAPHITE.get()))
                    .title(Component.translatable("itemGroup.mindustry_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.LEAD.get());
                        pOutput.accept(ModItems.META_GLASS.get());
                        pOutput.accept(ModItems.PHASE_FABRIC.get());
                        pOutput.accept(ModItems.PLASTANIUM.get());
                        pOutput.accept(ModItems.GRAPHITE.get());
                        pOutput.accept(ModBlocks.LEAD_ORE.get());
                        pOutput.accept(ModBlocks.GRAPHITE_ORE.get());
                        pOutput.accept(ModBlocks.PHASE_FABRIC_WALL.get());
                        pOutput.accept(ModBlocks.PLASTANIUM_WALL.get());
                        pOutput.accept(ModBlocks.COPPER_WALL.get());
                        pOutput.accept(ModBlocks.LEAD_CRYSTAL.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> LEARNMOD_TAB =
            CREATIVE_MODE_TABS.register("learnmod_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.GRAPHITE.get()))
                    .title(Component.translatable("itemGroup.mindustry_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CHEESE.get());
                        pOutput.accept(ModItems.CORN.get());
                        pOutput.accept(ModItems.STRAWBERRY.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
