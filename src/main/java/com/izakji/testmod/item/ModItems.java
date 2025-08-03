package com.izakji.testmod.item;

import com.izakji.testmod.TestMod;
import com.izakji.testmod.item.custom.ChainsawItem;
import com.izakji.testmod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MOD_ID);

    // Register your items here
    public static final DeferredItem<Item> BLACK_OPAL = ITEMS.registerSimpleItem("black_opal");

    public static final DeferredItem<Item> RAW_BLACK_OPAL = ITEMS.registerItem("raw_black_opal", Item::new, new Item.Properties());

    public static final DeferredItem<Item> CHAINSAW = ITEMS.registerItem("chainsaw", ChainsawItem::new, new Item.Properties().durability(32));

    public static final DeferredItem<Item> TOMATO = ITEMS.registerItem("tomato", properties -> new Item(properties) {
        @Override
        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
            tooltipComponents.add(Component.translatable("tooltip.testmod.tomato.tooltip.1"));
            super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        }
    }, new Item.Properties().food(ModFoodProperties.TOMATO));

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.registerItem("frostfire_ice", properties -> new FuelItem(properties, 800), new Item.Properties());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}