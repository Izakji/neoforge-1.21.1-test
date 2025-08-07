package com.izakji.testmod.util;

import com.izakji.testmod.TestMod;
import com.izakji.testmod.component.ModDataComponentTypes;
import com.izakji.testmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.DATA_TABLET.get(), ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, "on"),
                ((stack, level, entity, seed) -> stack.get(ModDataComponentTypes.FOUND_BLOCK) != null ? 1f : 0f));

        makeCustomBow(ModItems.KAUPEN_BOW.get());
    }

    private static void makeCustomBow(Item item) {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (stack, level, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration(livingEntity) - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });

        ItemProperties.register(
                item,
                ResourceLocation.withDefaultNamespace("pulling"),
                (stack, level, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F
        );
    }
}
