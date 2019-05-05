package com.ikerleon.birdwmod.util.handlers;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.gui.GUIBirdGuide;
import com.ikerleon.birdwmod.proxy.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {

    public static void init()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
    }

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == CommonProxy.GUI.BIRD_BOOK.id) {
            return new GUIBirdGuide();
        }
        return null;
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == CommonProxy.GUI.BIRD_BOOK.id) {
            return new GUIBirdGuide();
        }
        return null;
    }
}
