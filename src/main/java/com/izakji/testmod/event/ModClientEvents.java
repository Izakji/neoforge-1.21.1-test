package com.izakji.testmod.event;

import com.izakji.testmod.TestMod;
import com.izakji.testmod.item.ModItems;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

@EventBusSubscriber(modid = TestMod.MOD_ID, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onComputeFovModifierEvent(ComputeFovModifierEvent event) {
        if(event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == ModItems.KAUPEN_BOW.get()) {
            float fovModifier = 1f;
            int tickUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaTicks = (float) tickUsingItem / 20f;

            if(deltaTicks > 1f) {
                deltaTicks = 1f;
            } else {
                deltaTicks *= deltaTicks;
            }

            fovModifier *= 1f - deltaTicks * 0.15f;
            event.setNewFovModifier(fovModifier);
        }
    }
}
