package com.ikerleon.birdwmod.entity;

import com.ikerleon.birdwmod.entity.europe.EurasianBullfinchEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InitEntities {

    public static final EntityType<EurasianBullfinchEntity> EURASIAN_BULLFINCH_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "eurasian_bullfinch"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EurasianBullfinchEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.3f)).build()
    );

    public static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(EURASIAN_BULLFINCH_ENTITY, EurasianBullfinchEntity.createBirdAttributes());
    }
}
