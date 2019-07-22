package com.ikerleon.birdwmod.advancements.triggers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.ikerleon.birdwmod.advancements.ModCriterionInstance;
import com.ikerleon.birdwmod.advancements.ModTrigger;
import net.minecraft.util.ResourceLocation;

public class DocumentBirdTrigger extends ModTrigger<DocumentBirdTrigger.Instance, Integer>
{
    public DocumentBirdTrigger()
    {
        super("documentbird", "entity");
    }

    @Override
    public Instance deserializeInstance(JsonObject json, JsonDeserializationContext context)
    {
        String string = getTriggerConditionFrom(json);
        if(string != null)
        {
            try
            {
                return new Instance(ID, Integer.valueOf(string));
            }
            catch(NumberFormatException e)
            {
            }
        }
        return new Instance(ID, Integer.MAX_VALUE);
    }

    /**
     *  Instance of our advancement critrion that holds
     *  values loaded from advancement JSON file.
     */
    public static class Instance extends ModCriterionInstance<Integer>
    {
        private final Integer threshold;

        public Instance(ResourceLocation id, Integer object)
        {
            super(id, object);
            threshold = object;
        }

        @Override
        public boolean test(Integer object)
        {
            return object != null && object >= threshold;
        }
    }
}