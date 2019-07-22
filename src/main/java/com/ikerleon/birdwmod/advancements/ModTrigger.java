package com.ikerleon.birdwmod.advancements;

import com.google.gson.JsonObject;
import com.ikerleon.birdwmod.Reference;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;

public abstract class ModTrigger<I extends ModCriterionInstance<O>, O> implements ICriterionTrigger<I>
{
    protected final ResourceLocation ID;
    protected final String condition;
    private final java.util.Map<PlayerAdvancements, ModListeners<I, O>>
            listenersMap = new java.util.HashMap<>();
    /**
     * Constructs a new custom advancement trigger
     *
     * @param trigger name of the custom trigger defined in the {@code json} file
     * @param condition name of the trigger condition entry defined in the {@code json} file
     */
    public ModTrigger(String trigger, String condition)
    {
        ID = new ResourceLocation(Reference.MODID, trigger);
        this.condition = condition;
    }

    @Override
    public ResourceLocation getId()
    {
        return ID;
    }

    @Override
    public void addListener(PlayerAdvancements advancements, Listener<I> listener)
    {
        ModListeners<I, O> listeners = listenersMap.get(advancements);
        if(listeners == null)
        {
            listeners = new ModListeners<>(advancements);
            listenersMap.put(advancements, listeners);
        }
        listeners.add(listener);
    }

    @Override
    public void removeListener(PlayerAdvancements advancements, Listener<I> listener)
    {
        ModListeners<I, O> listeners = listenersMap.get(advancements);
        if(listeners != null)
        {
            listeners.remove(listener);
            if(listeners.isEmpty())
                listenersMap.remove(advancements);
        }
    }

    @Override
    public void removeAllListeners(PlayerAdvancements advancements)
    {
        listenersMap.remove(advancements);
    }

    public void trigger(EntityPlayerMP player, O object)
    {
        ModListeners<I, O> listeners = listenersMap.get(player.getAdvancements());
        if(listeners != null)
            listeners.trigger(object);
    }

    /**
     * Retrieve value of defined trigger condition from {@code json} file
     * @param json entry to scan for our value
     * @return {@code null} if the condition is not defined in the {@code json} file
     */
    protected String getTriggerConditionFrom(JsonObject json)
    {
        String trigger = condition != null && json.has(condition) ? JsonUtils.getString(json, condition) : null;
        return trigger;
    }
}
