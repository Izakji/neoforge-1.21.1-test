package com.izakji.testmod.item;

import com.izakji.testmod.TestMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TestModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TEST_MOD_CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB =
            TEST_MOD_CREATIVE_TABS.register("bismuth_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.testmod.bismuth_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB =
            TEST_MOD_CREATIVE_TABS.register("bismuth_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.testmod.bismuth_blocks_tab"))
                    .icon(() -> new ItemStack(ModItems.RAW_BISMUTH.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, "bismuth_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Blocks.AMETHYST_BLOCK);
                        output.accept(Blocks.DIAMOND_BLOCK);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        TEST_MOD_CREATIVE_TABS.register(eventBus);
    }
}
