package com.ikerleon.birdwmod.entity;

import com.ikerleon.birdwmod.client.render.europe.EurasianBullfinchRenderer;
import com.ikerleon.birdwmod.client.render.europe.RedFlankedBluetailRenderer;
import com.ikerleon.birdwmod.client.render.europe.RedNeckedNightjarRenderer;
import com.ikerleon.birdwmod.client.render.europe.StellersEiderRenderer;
import com.ikerleon.birdwmod.entity.europe.EurasianBullfinchEntity;
import com.ikerleon.birdwmod.entity.europe.RedFlankedBluetailEntity;
import com.ikerleon.birdwmod.entity.europe.RedNeckedNightjarEntity;
import com.ikerleon.birdwmod.entity.europe.StellersEiderEntity;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
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
    public static final EntityType<RedNeckedNightjarEntity> RED_NECKED_NIGHTJAR_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "rednecked_nightjar"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedNeckedNightjarEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.2f)).build()
    );
    public static final EntityType<RedFlankedBluetailEntity> RED_FLANKED_BLUETAIL_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "redflanked_bluetail"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RedFlankedBluetailEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.3f)).build()
    );
    public static final EntityType<StellersEiderEntity> STELLERS_EIDER_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "stellers_eider"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, StellersEiderEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.6f)).build()
    );


    public static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(EURASIAN_BULLFINCH_ENTITY, EurasianBullfinchEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(RED_NECKED_NIGHTJAR_ENTITY, RedNeckedNightjarEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(RED_FLANKED_BLUETAIL_ENTITY, RedFlankedBluetailEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(STELLERS_EIDER_ENTITY, StellersEiderEntity.createBirdAttributes());
    }

    public static void registerRenderers(){
        EntityRendererRegistry.INSTANCE.register(InitEntities.EURASIAN_BULLFINCH_ENTITY, (dispatcher, context) -> {
            return new EurasianBullfinchRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(InitEntities.RED_NECKED_NIGHTJAR_ENTITY, (dispatcher, context) -> {
            return new RedNeckedNightjarRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(InitEntities.RED_FLANKED_BLUETAIL_ENTITY, (dispatcher, context) -> {
            return new RedFlankedBluetailRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(InitEntities.STELLERS_EIDER_ENTITY, (dispatcher, context) -> {
            return new StellersEiderRenderer(dispatcher);
        });
    }
}
