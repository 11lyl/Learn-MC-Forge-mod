package com.lyl.learnmod.block;

import com.lyl.learnmod.LearnMod;
import com.lyl.learnmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RailBlock;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block>BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, LearnMod.MOD_ID);

    public static final RegistryObject<Block> LEAD_ORE =
            registerBlocks("lead_ore",()->new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> PHASE_FABRIC_WALL =
            registerBlocks("phase_fabric_wall",()->new Block(BlockBehaviour.Properties.of().strength(1.5F,3.0F)));
    public static final RegistryObject<Block> PLASTANIUM_WALL =
            registerBlocks("plastanium_wall",()->new Block(BlockBehaviour.Properties.of().strength(1.5F,3.0F)));

    private static <T extends Block> void registerBlocksItems(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlocks(String name, Supplier<T> block){
        RegistryObject<T> blocks=BLOCKS.register(name, block);
        return blocks;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
