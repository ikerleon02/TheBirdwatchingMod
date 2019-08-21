package com.ikerleon.birdwmod.items;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.advancements.ModAdvancementTriggers;
import com.ikerleon.birdwmod.entity.EntityBird;
import com.ikerleon.birdwmod.init.BirdwmodItems;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.bookworm.util.BookwormUtils;

import java.util.List;

public class ItemBinocular extends Item{

	private final int ZOOM;

	public ItemBinocular(String name, int zoom) {
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		BirdwmodItems.ITEMS.add(this);
		this.setCreativeTab(Main.BIRDWATCHINGMOD);
		this.ZOOM = zoom;
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

		if (Minecraft.getMinecraft().gameSettings.fovSetting >= 30) {
			stack.getTagCompound().setFloat("fov", Minecraft.getMinecraft().gameSettings.fovSetting);
		}

		if(isSelected && !stack.getTagCompound().getBoolean("zoomed")){
			if(stack.getTagCompound().getFloat("fov") >=30){
				Minecraft.getMinecraft().gameSettings.fovSetting = stack.getTagCompound().getFloat("fov");
			}
			else{
				Minecraft.getMinecraft().gameSettings.fovSetting = 70;
			}
		}

		if (!(((EntityPlayer) entityIn).getHeldItemMainhand().getItem() instanceof ItemBinocular)) {
			Minecraft.getMinecraft().gameSettings.fovSetting = stack.getTagCompound().getFloat("fov");
			Minecraft.getMinecraft().gameSettings.smoothCamera = false;
		}

		if((entityIn instanceof EntityPlayer) ) {
			EntityPlayer playerIn = (EntityPlayer) entityIn;

			if (stack.getTagCompound().getBoolean("zoomed")) {
				Vec3d vec3 = playerIn.getPositionEyes(1.0F);
				Vec3d vec3a = playerIn.getLook(1.0F);
				int distance = 12;
				Vec3d vec3b = vec3.addVector(vec3a.x * distance, vec3a.y * distance, vec3a.z * distance);

				Entity ee = BookwormUtils.findEntityOnPath(playerIn, 14.0F, vec3, vec3b, new Predicate() {
					@Override
					public boolean apply(@Nullable Object input) {
						return input instanceof EntityBird;
					}
				});

				if(ee != null && !playerIn.world.isRemote){
					ModAdvancementTriggers.ORNITHOLOGY101.trigger((EntityPlayerMP) playerIn, 2);
				}
			}

		}
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		if(itemstack.getTagCompound().getFloat("fov") >=30) {
			playerIn.setActiveHand(handIn);
			Minecraft.getMinecraft().gameSettings.fovSetting = this.ZOOM;
			Minecraft.getMinecraft().gameSettings.smoothCamera = true;
			itemstack.getTagCompound().setBoolean("zoomed", true);
		}

        return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if(stack.getTagCompound().getFloat("fov") >=30){
			Minecraft.getMinecraft().gameSettings.fovSetting = stack.getTagCompound().getFloat("fov");
		}
		else{
			Minecraft.getMinecraft().gameSettings.fovSetting = 70;
		}
		stack.getTagCompound().setBoolean("zoomed", false);
		Minecraft.getMinecraft().gameSettings.smoothCamera = false;
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