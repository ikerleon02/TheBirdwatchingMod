package com.ikerleon.birdwmod.util;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoundHandler {

    public static SoundEvent NIGHTJAR_SONG = register("entity.rnnightjar_song");
    public static SoundEvent BLUETAIL_CALL = register("entity.bluetail_call");
    public static SoundEvent BULLFINCH_CALL = register("entity.bullfinch_call");
    public static SoundEvent EIDER_CALL = register("entity.seider_call");
    public static SoundEvent EIDER_FLYING = register("entity.seider_flying");

    public static SoundEvent KILLDEER_FLYING = register("entity.killdeer_flying");
    public static SoundEvent KILLDEER_CALL = register("entity.killdeer_call");
    public static SoundEvent BLUEBIRD_SONG = register("entity.ebluebird_song");
    public static SoundEvent BLUEBIRD_CALL = register("entity.ebluebird_call");
    public static SoundEvent MOCKINGBIRD_SONG = register("entity.nmockingbird_song");
    public static SoundEvent MOCKINGBIRD_CALL = register("entity.nmockingbird_call");
    public static SoundEvent HERON_FLYING = register("entity.gheron_flying");

    public static SoundEvent HOATZIN_CALL = register("entity.hoatzin_call");
    public static SoundEvent KINGOFSAXONY_CALL = register("entity.kingofsaxony_call");
    public static SoundEvent KINGOFSAXONY_SONG = register("entity.kingofsaxony_song");
    public static SoundEvent MOTMOT_CALL = register("entity.motmot_call");

    public static SoundEvent GREATGREYOWL_SONG = register("entity.greatgreyowl_song");
    public static SoundEvent BOOBY_CALL = register("entity.booby_call");

    public static SoundEvent RAZORBILL_CALL = register("entity.razorbill_call");

    private static SoundEvent register(String id)
    {
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(new Identifier("birdwmod", id)));
    }

    public static void register() {}
}
