package com.ikerleon.birdwmod;

import com.ikerleon.birdwmod.blocks.InitBlocks;
import com.ikerleon.birdwmod.entity.InitEntities;
import com.ikerleon.birdwmod.events.EventHandler;
import com.ikerleon.birdwmod.items.InitItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {

	public static final ItemGroup THE_BIRDWATCHING_MOD = FabricItemGroupBuilder.build(new Identifier("birdwmod","birdwatchingmodtab"), () -> new ItemStack(InitItems.BINOCULAR_PROFFESIONAL));

	@Override
	public void onInitialize() {
		InitItems.registerItems();
		InitBlocks.registerBlocks();
		InitEntities.registerAttributes();
		EventHandler.registerEvents();
	}
}
