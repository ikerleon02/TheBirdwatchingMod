package com.ikerleon.birdwmod;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

import com.ikerleon.birdwmod.init.BirdwmodItems;
import com.ikerleon.birdwmod.proxy.CommonProxy;
import com.ikerleon.birdwmod.tabs.BirdwmodTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, dependencies="required-before:bookworm@[1.12.2-2.2.0,);")
public class Main {
	@Instance
	public static Main instance;

	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	public static final CreativeTabs BIRDWATCHINGMOD = new BirdwmodTab("birdwatchingmodtab");

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		BirdwmodItems.registerItems();
		proxy.preInit(event);
		proxy.registerRenders();
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@SideOnly(Side.CLIENT)
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}