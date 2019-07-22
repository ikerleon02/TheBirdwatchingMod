package com.ikerleon.birdwmod.advancements;

import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import net.minecraft.util.ResourceLocation;

public abstract class ModCriterionInstance<T> extends AbstractCriterionInstance
{
    protected final T object;

    public ModCriterionInstance(ResourceLocation id, T object)
    {
        super(id);
        this.object = object;
    }

    public abstract boolean test(T object);
}
