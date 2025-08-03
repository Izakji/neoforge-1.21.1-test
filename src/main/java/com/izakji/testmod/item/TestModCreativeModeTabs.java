package com.izakji.testmod.item;

import com.izakji.testmod.TestMod;
import com.izakji.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TestModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TESTMOD_CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TABS =
            TESTMOD_CREATIVE_MODE_TABS.register( "black_opal_items_tabs", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.black_opal_items_tabs"))
                    .icon(() -> new ItemStack(Moditems.BLACK_OPAL.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Moditems.BLACK_OPAL);
                        output.accept(Moditems.RAW_BLACK_OPAL);

                    }).build());

    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TABS =
            TESTMOD_CREATIVE_MODE_TABS.register( "black_opal_blocks_tabs", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.black_opal_blocks_tabs"))
                    .icon(() -> new ItemStack(Moditems.RAW_BLACK_OPAL   .get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, "black_opal_items_tabs"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BLACK_OPAL_BLOCK);
                        output.accept(ModBlocks.RAW_BLACK_OPAL_BLOCK);
                        
                    }).build());



    public static void register(IEventBus eventBus) {
        TESTMOD_CREATIVE_MODE_TABS.register(eventBus);
    }
}
