package com.ikerleon.birdwmod.proxy;

import com.ikerleon.birdwmod.Main;
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

	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		MinecraftForge.EVENT_BUS.register(new EventBinocularRim());
	}
}
