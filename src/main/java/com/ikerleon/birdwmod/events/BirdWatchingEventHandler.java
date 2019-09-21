package com.ikerleon.birdwmod.events;

import com.google.common.base.Predicate;
import com.ikerleon.birdwmod.Reference;
import com.ikerleon.birdwmod.advancements.ModAdvancementTriggers;
import com.ikerleon.birdwmod.entity.EntityBird;
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
import com.ikerleon.birdwmod.items.ItemBinocular;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.soggymustache.bookworm.util.BookwormUtils;

import javax.annotation.Nullable;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class BirdWatchingEventHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent e) {
        EntityPlayer player = (EntityPlayer) e.player;
        if (player.world.isRemote)
            return;

        Vec3d vec3 = player.getPositionEyes(1.0F);
        Vec3d vec3a = player.getLook(1.0F);
        int distance = 12;
        Vec3d vec3b = vec3.addVector(vec3a.x * distance, vec3a.y * distance, vec3a.z * distance);

        Entity ee = BookwormUtils.findEntityOnPath(player, 14.0F, vec3, vec3b, new Predicate() {
            @Override
            public boolean apply(@Nullable Object input) {
                return true;
            }
        });
        if(ee == null)
            return;
        if(ee instanceof EntityBird) {
            ItemStack itemstack = player.inventory.armorInventory.get(3);

            if (itemstack.getItem() == Item.getItemFromBlock(Blocks.PUMPKIN)) {
                ModAdvancementTriggers.BIRDBOX.trigger((EntityPlayerMP) player, 2);
            }
            if (player.getHeldItem(player.getActiveHand()).getItem() instanceof ItemBinocular) {
                ItemBinocular binos = (ItemBinocular) player.getHeldItem(player.getActiveHand()).getItem();

                if (binos.zoomed) {
                    ModAdvancementTriggers.ORNITHOLOGY101.trigger((EntityPlayerMP) player, 2);
                }
            }
        }
        if (ee instanceof EntityRedNeckedNightjar) {
            ModAdvancementTriggers.DOCUMENTBIRD.trigger((EntityPlayerMP) player, 1);
        }
        if (ee instanceof EntityEurasianBullfinch) {
            ModAdvancementTriggers.DOCUMENTBIRD.trigger((EntityPlayerMP) player, 2);
        }
        if (ee instanceof EntityRedFlankedBluetail) {
            ModAdvancementTriggers.DOCUMENTBIRD.trigger((EntityPlayerMP) player, 3);
        }
        if (ee instanceof EntityStellersEider) {
            ModAdvancementTriggers.DOCUMENTBIRD.trigger((EntityPlayerMP) player, 4);
        }
        if (ee instanceof EntityEasternBluebird) {
            ModAdvancementTriggers.DOCUMENTBIRD.trigger((EntityPlayerMP) player, 5);
        }
        if (ee instanceof EntityKilldeer) {
            ModAdvancementTriggers.DOCUMENTBIRD.trigger((EntityPlayerMP) player, 6);
        }
        if (ee instanceof EntityNorthernMockingbird) {
            ModAdvancementTriggers.DOCUMENTBIRD.trigger((EntityPlayerMP) player, 7);
        }
        if (ee instanceof EntityGreenHeron) {
            ModAdvancementTriggers.DOCUMENTBIRD.trigger((EntityPlayerMP) player, 8);
        }
        if (ee instanceof EntityHoatzin) {
            ModAdvancementTriggers.DOCUMENTBIRD.trigger((EntityPlayerMP) player, 9);
        }
        if (ee instanceof EntityKingofSaxony) {
            ModAdvancementTriggers.DOCUMENTBIRD.trigger((EntityPlayerMP) player, 10);
        }
        if (ee instanceof EntityTurquoiseBrowedMotmot) {
            ModAdvancementTriggers.DOCUMENTBIRD.trigger((EntityPlayerMP) player, 11);
        }
    }

}
