package com.ikerleon.birdwmod.advancements;

import com.ikerleon.birdwmod.advancements.triggers.BirdboxTrigger;
import com.ikerleon.birdwmod.advancements.triggers.DocumentBirdTrigger;
import com.ikerleon.birdwmod.advancements.triggers.Ornithology101Trigger;
import net.minecraft.advancements.CriteriaTriggers;

public class ModAdvancementTriggers {

    public static Ornithology101Trigger ORNITHOLOGY101;
    public static BirdboxTrigger BIRDBOX;
    public static DocumentBirdTrigger DOCUMENTBIRD;

    private static void register(ModTrigger trigger) {
        CriteriaTriggers.register(trigger);
    }

    public static void init() {

        register(ORNITHOLOGY101 = new Ornithology101Trigger());
        register(BIRDBOX = new BirdboxTrigger());
        register(DOCUMENTBIRD = new DocumentBirdTrigger());
    }
}
