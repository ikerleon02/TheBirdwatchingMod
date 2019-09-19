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

import java.lang.annotation.RetentionPolicy;
import java.util.List;

import static java.lang.annotation.ElementType.METHOD;

public class ItemBinocular extends Item{

	private float zoom;
	public boolean zoomed;

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

		if((entityIn instanceof EntityPlayer) ) {
			EntityPlayer playerIn = (EntityPlayer) entityIn;

			if(worldIn.isRemote) {
				if (Minecraft.getMinecraft().gameSettings.fovSetting >= 30) {
					stack.getTagCompound().setFloat("fov", Minecraft.getMinecraft().gameSettings.fovSetting);
				}

				if (!(((EntityPlayer) entityIn).getHeldItemMainhand().getItem() instanceof ItemBinocular)) {
					Minecraft.getMinecraft().gameSettings.fovSetting = stack.getTagCompound().getFloat("fov");
					Minecraft.getMinecraft().gameSettings.smoothCamera = false;
				}
			}
			else {
				if (zoomed) {
					List<Entity> Entitylist = worldIn.getLoadedEntityList();

					for (int i = 0; i < Entitylist.size(); i++) {
						Entity Ent = Entitylist.get(i);

						if (Ent instanceof EntityBird) {
							Vec3d vec3d = playerIn.getLookVec();
							Vec3d vec3d1 = new Vec3d(Ent.posX - playerIn.posX, Ent.getEntityBoundingBox().minY + (double) Ent.getEyeHeight() - (playerIn.posY + (double) playerIn.getEyeHeight()), Ent.posZ - playerIn.posZ);
							double d0 = vec3d1.lengthVector();
							vec3d1 = vec3d1.normalize();
							double d1 = vec3d.dotProduct(vec3d1);

							if (d1 > 1.0D - 0.025D / d0 ? playerIn.canEntityBeSeen(Ent) : false) {
								if (playerIn instanceof EntityPlayerMP) {
									System.out.println(d1);
									ModAdvancementTriggers.ORNITHOLOGY101.trigger((EntityPlayerMP) playerIn, 2);
								}
							}
						}
					}
				}
			}
		}

		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if(worldIn.isRemote) {
			Minecraft.getMinecraft().gameSettings.fovSetting = this.zoom;
			Minecraft.getMinecraft().gameSettings.smoothCamera = true;
		}
		zoomed = true;
		playerIn.setActiveHand(handIn);

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}

	@SuppressWarnings("java.lang.NoClassDefFoundError")
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if (entityLiving instanceof EntityPlayer) {
			zoomed = false;
			if (stack.getTagCompound().getFloat("fov") != 0) {
				Minecraft.getMinecraft().gameSettings.fovSetting = stack.getTagCompound().getFloat("fov");
			} else {
				Minecraft.getMinecraft().gameSettings.fovSetting = 70;
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