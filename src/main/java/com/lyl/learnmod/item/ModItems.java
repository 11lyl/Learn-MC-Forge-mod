package com.lyl.learnmod.item;

import com.lyl.learnmod.LearnMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS=
            DeferredRegister.create(ForgeRegistries.ITEMS, LearnMod.MOD_ID);

    public static final RegistryObject<Item> LEAD =
            ITEMS.register("lead",()-> new Item(new Item.Properties()));//铅
    public static final RegistryObject<Item> GRAPHITE =
            ITEMS.register("graphite",()-> new Item(new Item.Properties()));//石墨
    public static final RegistryObject<Item> META_GLASS =
            ITEMS.register("meta_glass",()-> new Item(new Item.Properties()));//钢化玻璃
    public static final RegistryObject<Item> PHASE_FABRIC =
            ITEMS.register("phase_fabric",()-> new Item(new Item.Properties()));//相织布
    public static final RegistryObject<Item> PLASTANIUM =
            ITEMS.register("plastanium",()-> new Item(new Item.Properties()));//塑钢
    /*public static final RegistryObject<Item> PYRATITE =
            ITEMS.register("pyratite",()-> new Item(new Item.Properties()));//硫
    public static final RegistryObject<Item> SAND =
            ITEMS.register("sand",()-> new Item(new Item.Properties()));//沙子
    public static final RegistryObject<Item> SCRAP =
            ITEMS.register("scrap",()-> new Item(new Item.Properties()));//废料*/

    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);
    }
}
