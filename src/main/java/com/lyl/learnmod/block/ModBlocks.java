package com.lyl.learnmod.block;

import com.lyl.learnmod.LearnMod;
import com.lyl.learnmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // 所有方块的注册表
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LearnMod.MOD_ID);

    //                       ore

    // 铅矿：直接复制原版石头的属性（硬度、抗爆、需要镐子）
    public static final RegistryObject<Block> LEAD_ORE =
            registerBlock("lead_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    // 石墨矿石
    public static final RegistryObject<Block> GRAPHITE_ORE =
            registerBlock("graphite_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    //                       wall

    // 相织布墙
    public static final RegistryObject<Block> PHASE_FABRIC_WALL =
            registerBlock("phase_fabric_wall", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F, 3.0F)));
    // 塑钢墙
    public static final RegistryObject<Block> PLASTANIUM_WALL =
            registerBlock("plastanium_wall", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F, 3.0F)));
    // 铜墙
    public static final RegistryObject<Block> COPPER_WALL =
            registerBlock("copper_wall", () -> new Block(BlockBehaviour.Properties.of().strength(1.5F, 3.0F)));

    //                      crystal

    // 铅晶簇：OBJ 模型方块，非满方块
    public static final RegistryObject<Block> LEAD_CRYSTAL =
            registerBlock("lead_crystal", () -> new LeadCrystalBlock(BlockBehaviour.Properties.of()
                    .strength(0.6F, 1.0F)
                    .sound(SoundType.AMETHYST)
                    .noOcclusion()));

    // 注册方块，同时把它对应的 BlockItem 注册进 ITEMS
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // 方块物品：让方块能以物品形式出现在背包和创造模式物品栏里
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
