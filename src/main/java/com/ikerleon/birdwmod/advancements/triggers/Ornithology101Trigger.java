package com.ikerleon.birdwmod.advancements.triggers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.ikerleon.birdwmod.advancements.ModCriterionInstance;
import com.ikerleon.birdwmod.advancements.ModTrigger;
import net.minecraft.util.ResourceLocation;

public class Ornithology101Trigger extends ModTrigger<Ornithology101Trigger.Instance, Integer>
{
    public Ornithology101Trigger()
    {
        super("ornithology101", "entity");
    }

    @Override
    public Ornithology101Trigger.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context)
    {
        String string = getTriggerConditionFrom(json);
        if(string != null)
        {
            try
            {
                return new Ornithology101Trigger.Instance(ID, Integer.valueOf(string));
            }
            catch(NumberFormatException e)
            {
            }
        }
        return new Ornithology101Trigger.Instance(ID, Integer.MAX_VALUE);
    }

    /**
     *  Instance of our advancement critrion that holds
     *  values loaded from advancement JSON file.
     */
    public static class Instance extends ModCriterionInstance<Integer>
    {
        private final Integer object;

        public Instance(ResourceLocation id, Integer object)
        {
            super(id, object);
            this.object = object;
        }

        @Override
        public boolean test(Integer object)
        {
            return object != null && object < this.object;
        }
    }
}