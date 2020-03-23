package com.ikerleon.birdwmod;

import com.ikerleon.birdwmod.advancements.ModAdvancementTriggers;
import com.ikerleon.birdwmod.client.render.europe.RenderEurasianBullfinch;
import com.ikerleon.birdwmod.client.render.europe.RenderRedFlankedBluetail;
import com.ikerleon.birdwmod.client.render.europe.RenderRedNeckedNightjar;
import com.ikerleon.birdwmod.client.render.europe.RenderStellersEider;
import com.ikerleon.birdwmod.client.render.jungle.RenderHoatzin;
import com.ikerleon.birdwmod.client.render.jungle.RenderKingofSaxony;
import com.ikerleon.birdwmod.client.render.jungle.RenderTurquoiseBrowedMotmot;
import com.ikerleon.birdwmod.client.render.northamerica.RenderEasternBluebird;
import com.ikerleon.birdwmod.client.render.northamerica.RenderGreenHeron;
import com.ikerleon.birdwmod.client.render.northamerica.RenderKilldeer;
import com.ikerleon.birdwmod.client.render.northamerica.RenderNorthernMockingbird;
import com.ikerleon.birdwmod.entity.europe.EntityEurasianBullfinch;
import com.ikerleon.birdwmod.entity.europe.EntityRedFlankedBluetail;
import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.entity.jungle.EntityHoatzin;
import com.ikerleon.birdwmod.entity.jungle.EntityKingofSaxony;
import com.ikerleon.birdwmod.entity.jungle.EntityTurquoiseBrowedMotmot;
import com.ikerleon.birdwmod.entity.northamerica.EntityEasternBluebird;
import com.ikerleon.birdwmod.entity.northamerica.EntityGreenHeron;
import com.ikerleon.birdwmod.entity.northamerica.EntityKilldeer;
import com.ikerleon.birdwmod.entity.northamerica.EntityNorthernMockingbird;
import com.ikerleon.birdwmod.init.BirdwmodBlocks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, dependencies="required-before:bookworm@[1.12.2-2.3.0,);")
public class Main {
	@Instance
	public static Main instance;

	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	public static final CreativeTabs BIRDWATCHINGMOD = new BirdwmodTab("birdwatchingmodtab");

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		BirdwmodBlocks.registerBlocks();
		BirdwmodItems.registerItems();
		proxy.preInit(event);
		proxy.registerRenders();
		ModAdvancementTriggers.init();
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

	@Mod.EventBusSubscriber(modid = Reference.MODID)
	public static class Handlers {

		@SideOnly(Side.CLIENT)
		@SubscribeEvent
		public static void registerRenders(ModelRegistryEvent e) {
			BirdwmodItems.registerItemRenders();
			BirdwmodBlocks.registerRenders();
			//EUROPE
			RenderingRegistry.registerEntityRenderingHandler(EntityRedNeckedNightjar.class, RenderRedNeckedNightjar::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityEurasianBullfinch.class, RenderEurasianBullfinch::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityRedFlankedBluetail.class, RenderRedFlankedBluetail::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityStellersEider.class, RenderStellersEider::new);
			//AMERICA
			RenderingRegistry.registerEntityRenderingHandler(EntityKilldeer.class, RenderKilldeer::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityEasternBluebird.class, RenderEasternBluebird::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityNorthernMockingbird.class, RenderNorthernMockingbird::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityGreenHeron.class, RenderGreenHeron::new);
			//JUNGLE
			RenderingRegistry.registerEntityRenderingHandler(EntityHoatzin.class, RenderHoatzin::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityKingofSaxony.class, RenderKingofSaxony::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityTurquoiseBrowedMotmot.class, RenderTurquoiseBrowedMotmot::new);
		}
	}
}