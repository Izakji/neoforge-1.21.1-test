package com.izakji.testmod.item;

import com.izakji.testmod.TestMod;
import com.izakji.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TestModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TESTMOD_CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TABS =
            TESTMOD_CREATIVE_MODE_TABS.register( "black_opal_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.testmod.black_opal_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BLACK_OPAL);
                        output.accept(ModItems.RAW_BLACK_OPAL);
                        output.accept(ModItems.CHAINSAW);
                        output.accept(ModItems.TOMATO);
                        output.accept(ModItems.FROSTFIRE_ICE);
                    }).build());

    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TABS =
            TESTMOD_CREATIVE_MODE_TABS.register( "black_opal_blocks_tabs", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.testmod.black_opal_blocks_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BLACK_OPAL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, "black_opal_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BLACK_OPAL_BLOCK);
                        output.accept(ModBlocks.RAW_BLACK_OPAL_BLOCK);
                        output.accept(ModBlocks.BLACK_OPAL_ORE);
                        output.accept(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE);
                        output.accept(ModBlocks.BLACK_OPAL_END_ORE);
                        output.accept(ModBlocks.BLACK_OPAL_NETHER_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                    }).build());



    public static void register(IEventBus eventBus) {
        TESTMOD_CREATIVE_MODE_TABS.register(eventBus);
    }
}
