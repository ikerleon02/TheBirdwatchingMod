package com.ikerleon.birdwmod.events;

import com.ikerleon.birdwmod.client.render.overlay.OverlayBinocularRim;

import com.ikerleon.birdwmod.items.ItemBinocular;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EventBinocularRim {
    private OverlayBinocularRim overlay;

    public EventBinocularRim() {
        overlay=new OverlayBinocularRim();
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public void eventHandler(RenderGameOverlayEvent.Pre event) {
        Item item= Minecraft.getMinecraft().player.getHeldItemMainhand().getItem();

        if(item instanceof ItemBinocular) {
            if(ItemBinocular.zoomed) {
                if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
                    overlay.drawScreen();
                }
            }
        }
    }
}