package com.ikerleon.birdwmod.events;

import com.ikerleon.birdwmod.client.render.overlay.OverlayBinocularRim;

import com.ikerleon.birdwmod.items.ItemBinocular;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EventBinocularRim {
    private static final OverlayBinocularRim overlay = new OverlayBinocularRim();

    @SubscribeEvent(priority = EventPriority.LOW)
    public void eventHandler(RenderGameOverlayEvent.Pre event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.HELMET)
            return;

        ItemStack stack = Minecraft.getMinecraft().player.getHeldItemMainhand();
        if(stack.getItem() instanceof ItemBinocular){
            if(((ItemBinocular)stack.getItem()).zoomed) {
                overlay.drawScreen();
            }
        }
    }
}