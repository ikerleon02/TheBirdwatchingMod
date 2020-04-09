package com.ikerleon.birdwmod.util.handlers;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundHandler {
    private static int size=0;

    public static SoundEvent NIGHTJAR_SONG;
    public static SoundEvent BLUETAIL_CALL;
    public static SoundEvent BULLFINCH_CALL;
    public static SoundEvent EIDER_CALL;
    public static SoundEvent EIDER_FLYING;

    public static SoundEvent KILLDEER_FLYING;
    public static SoundEvent KILLDEER_CALL;
    public static SoundEvent BLUEBIRD_SONG;
    public static SoundEvent BLUEBIRD_CALL;
    public static SoundEvent MOCKINGBIRD_SONG;
    public static SoundEvent MOCKINGBIRD_CALL;
    public static SoundEvent HERON_FLYING;

    public static SoundEvent HOATZIN_CALL;
    public static SoundEvent KINGOFSAXONY_CALL;
    public static SoundEvent KINGOFSAXONY_SONG;
    public static SoundEvent MOTMOT_CALL;

    public static SoundEvent GREATGREYOWL_SONG;
    public static SoundEvent BOOBY_CALL;

    public static void registerSounds() {
        size=SoundEvent.REGISTRY.getKeys().size();

        NIGHTJAR_SONG = registerSound("entity.rnnightjar_song");
        BLUETAIL_CALL = registerSound("entity.bluetail_call");
        BULLFINCH_CALL = registerSound("entity.bullfinch_call");
        EIDER_CALL = registerSound("entity.seider_call");
        EIDER_FLYING = registerSound("entity.seider_flying");

        KILLDEER_FLYING = registerSound("entity.killdeer_flying");
        KILLDEER_CALL = registerSound("entity.killdeer_call");
        BLUEBIRD_SONG = registerSound("entity.ebluebird_song");
        BLUEBIRD_CALL = registerSound("entity.ebluebird_call");
        MOCKINGBIRD_SONG = registerSound("entity.nmockingbird_song");
        MOCKINGBIRD_CALL = registerSound("entity.nmockingbird_call");
        HERON_FLYING = registerSound("entity.gheron_flying");

        HOATZIN_CALL = registerSound("entity.hoatzin_call");
        KINGOFSAXONY_CALL = registerSound("entity.kingofsaxony_call");
        KINGOFSAXONY_SONG = registerSound("entity.kingofsaxony_song");
        MOTMOT_CALL = registerSound("entity.motmot_call");

        GREATGREYOWL_SONG = registerSound("entity.greatgreyowl_song");
        GREATGREYOWL_SONG = registerSound("entity.booby_call");
    }

    private static SoundEvent registerSound(String s) { ResourceLocation l = new ResourceLocation("birdwmod:" + s);
        SoundEvent event = new SoundEvent(l);
        event.setRegistryName(s);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
