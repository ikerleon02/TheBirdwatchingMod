package com.ikerleon.birdwmod.events;

import com.ikerleon.birdwmod.client.overlay.OverlayBinocularRim;
import com.ikerleon.birdwmod.items.ItemBinocular;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;

public class EventHandler {
    private static final OverlayBinocularRim overlay = new OverlayBinocularRim();

    public static void ListenToEvents(){
        UseItemCallback.EVENT.register((player, world, hand) -> {

            ItemStack stack = player.getMainHandStack();
            if(stack.getItem() instanceof ItemBinocular){
                if(((ItemBinocular)stack.getItem()).zoomed) {
                    overlay.drawScreen();
                    return ActionResult.SUCCESS;
                }
                else{
                    return ActionResult.PASS;
                }
            }
            else{
                overlay.updateScreen();
                return ActionResult.PASS;
            }
        });
    }
}
