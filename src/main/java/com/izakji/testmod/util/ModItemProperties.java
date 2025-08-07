package com.izakji.testmod.util;

import com.izakji.testmod.TestMod;
import com.izakji.testmod.component.ModDataComponentTypes;
import com.izakji.testmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.DATA_TABLET.get(), ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, "on"),
                ((stack, level, entity, seed) -> stack.get(ModDataComponentTypes.FOUND_BLOCK) != null ? 1f : 0f));
    }
}
