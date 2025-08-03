package com.izakji.testmod.item;

import com.izakji.testmod.TestMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Moditems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MOD_ID);

    // Register your items here
    public static final DeferredItem<Item> BLACK_OPAL = ITEMS.registerSimpleItem("black_opal");

    public static final DeferredItem<Item> RAW_BLACK_OPAL = ITEMS.registerItem("raw_black_opal", Item::new, new Item.Properties());




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}