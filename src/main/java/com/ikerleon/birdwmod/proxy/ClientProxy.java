package com.ikerleon.birdwmod.proxy;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.client.render.europe.RenderEurasianBullfinch;
import com.ikerleon.birdwmod.client.render.europe.RenderRedFlankedBluetail;
import com.ikerleon.birdwmod.client.render.europe.RenderRedNeckedNightjar;
import com.ikerleon.birdwmod.client.render.europe.RenderStellersEider;
import com.ikerleon.birdwmod.client.render.jungle.RenderHoatzin;
import com.ikerleon.birdwmod.client.render.northamerica.RenderEasternBluebird;
import com.ikerleon.birdwmod.client.render.northamerica.RenderGreenHeron;
import com.ikerleon.birdwmod.client.render.northamerica.RenderKilldeer;
import com.ikerleon.birdwmod.client.render.northamerica.RenderNorthernMockingbird;
import com.ikerleon.birdwmod.entity.europe.EntityEurasianBullfinch;
import com.ikerleon.birdwmod.entity.europe.EntityRedFlankedBluetail;
import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;
import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.entity.jungle.EntityHoatzin;
import com.ikerleon.birdwmod.entity.northamerica.EntityEasternBluebird;
import com.ikerleon.birdwmod.entity.northamerica.EntityGreenHeron;
import com.ikerleon.birdwmod.entity.northamerica.EntityKilldeer;
import com.ikerleon.birdwmod.entity.northamerica.EntityNorthernMockingbird;
import com.ikerleon.birdwmod.events.EventBinocularRim;
import com.ikerleon.birdwmod.init.BirdwmodBlocks;
import com.ikerleon.birdwmod.init.BirdwmodItems;

import com.ikerleon.birdwmod.util.handlers.GuiHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenders(){
		BirdwmodItems.registerItemRenders();
		BirdwmodBlocks.registerRenders();
		//EUROPE
		RenderingRegistry.registerEntityRenderingHandler(EntityRedNeckedNightjar.class, RenderRedNeckedNightjar::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityEurasianBullfinch.class, RenderEurasianBullfinch::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityRedFlankedBluetail.class,RenderRedFlankedBluetail::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityStellersEider.class, RenderStellersEider::new);
		//AMERICA
		RenderingRegistry.registerEntityRenderingHandler(EntityKilldeer.class, RenderKilldeer::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityEasternBluebird.class, RenderEasternBluebird::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityNorthernMockingbird.class, RenderNorthernMockingbird::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenHeron.class, RenderGreenHeron::new);
		//JUNGLE
		RenderingRegistry.registerEntityRenderingHandler(EntityHoatzin.class, RenderHoatzin::new);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(new EventBinocularRim());
	}
}
