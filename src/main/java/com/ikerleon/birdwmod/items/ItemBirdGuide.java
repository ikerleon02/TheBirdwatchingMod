package com.ikerleon.birdwmod.items;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.init.BirdwmodItems;

import com.ikerleon.birdwmod.proxy.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemBirdGuide extends Item{
	
	public ItemBirdGuide(String name) {
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		BirdwmodItems.ITEMS.add(this);
		this.setCreativeTab(Main.BIRDWATCHINGMOD);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		playerIn.openBook(itemstack, handIn);
		playerIn.addStat(StatList.getObjectUseStats(this));
		if (worldIn.isRemote) {
			playerIn.openGui(Main.instance, CommonProxy.GUI.BIRD_BOOK.id, worldIn, (int) Math.floor(playerIn.posX), (int) Math.floor(playerIn.posY), (int) Math.floor(playerIn.posZ));
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
}
