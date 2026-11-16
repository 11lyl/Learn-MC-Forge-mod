package com.lyl.learnmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ModFoods {


    public static final FoodProperties CORN = new FoodProperties.Builder().nutrition(3).saturationMod(0.7f).build();
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(1).saturationMod(0.2f)
            .effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED,200),0.2f).build();

    public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(4).saturationMod(0.8f)
            .effect(()->new MobEffectInstance(MobEffects.JUMP,200),0.2f)
            .effect(()->new MobEffectInstance(MobEffects.FIRE_RESISTANCE,200),0.2f).build();


}
