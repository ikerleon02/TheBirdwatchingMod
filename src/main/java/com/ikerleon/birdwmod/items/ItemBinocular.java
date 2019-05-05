package com.ikerleon.birdwmod.items;

import javax.annotation.Nullable;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.init.BirdwmodItems;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBinocular extends Item{
	
	private float zoom;
	public static boolean zoomed;

	public ItemBinocular(String name, float zoom) {
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		BirdwmodItems.ITEMS.add(this);
		this.setCreativeTab(Main.BIRDWATCHINGMOD);
		this.zoom=zoom;

        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		stack.setTagCompound(stack.getTagCompound() == null ? new NBTTagCompound() : stack.getTagCompound());

		if((entityIn instanceof EntityPlayer) && worldIn.isRemote) {

			if (Minecraft.getMinecraft().gameSettings.fovSetting >= 30) {
					stack.getTagCompound().setFloat("fov", Minecraft.getMinecraft().gameSettings.fovSetting);
			}

			if (!(((EntityPlayer) entityIn).getHeldItemMainhand().getItem() instanceof ItemBinocular)) {
				Minecraft.getMinecraft().gameSettings.fovSetting = stack.getTagCompound().getFloat("fov");
				Minecraft.getMinecraft().gameSettings.smoothCamera = false;
			}
		}

		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		Minecraft.getMinecraft().gameSettings.fovSetting = this.zoom;
		Minecraft.getMinecraft().gameSettings.smoothCamera = true;
		zoomed = true;
		playerIn.setActiveHand(handIn);


        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if (entityLiving instanceof EntityPlayer) {
			zoomed = false;
			if (stack.getTagCompound().getFloat("fov") != 0) {
				Minecraft.getMinecraft().gameSettings.fovSetting = stack.getTagCompound().getFloat("fov");
			} else {
				Minecraft.getMinecraft().gameSettings.fovSetting = 70;
				System.out.println("[TheBirdwatchingMod] Binocular error happened (FOV not restored. Setting FOV to normal)");
			}
			Minecraft.getMinecraft().gameSettings.smoothCamera = false;
		}
	}

	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
    
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }
}