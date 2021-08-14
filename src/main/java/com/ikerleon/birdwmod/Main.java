package com.ikerleon.birdwmod;

import com.ikerleon.birdwmod.blocks.InitBlocks;
//import com.ikerleon.birdwmod.entity.EntityGeneration;
//import com.ikerleon.birdwmod.entity.InitEntities;
import com.ikerleon.birdwmod.items.InitItems;
import com.ikerleon.birdwmod.util.SoundHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {

	public static final ItemGroup THE_BIRDWATCHING_MOD = FabricItemGroupBuilder.build(new Identifier("birdwmod","birdwatchingmodtab"), () -> new ItemStack(InitItems.BINOCULAR_PROFFESIONAL));
	//public static final ItemGroup THE_BIRDWATCHING_MOD_SPAWN_EGGS = FabricItemGroupBuilder.build(new Identifier("birdwmod","birdwatchingmodspawneggstab"), () -> new ItemStack(InitItems.REDNECKEDNIGHTJAR_SPAWNEGG));

	@Override
	public void onInitialize() {
		SoundHandler.register();
		InitItems.registerItems();
		InitBlocks.registerBlocks();
		//InitEntities.registerAttributes();
		//EntityGeneration.init();
	}
}
