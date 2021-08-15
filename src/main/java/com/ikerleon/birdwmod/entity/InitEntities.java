package com.ikerleon.birdwmod.entity;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class InitEntities {

    public static final EntityType<BirdEntity> EURASIAN_BULLFINCH_ENTITY = registerBirdEntity(BirdSettings.EURASIAN_BULLFINCH_SETTINGS);
    public static final EntityType<BirdEntity> RED_NECKED_NIGHTJAR_ENTITY = registerBirdEntity(BirdSettings.RED_NECKED_NIGHTJAR_SETTINGS);
    public static final EntityType<BirdEntity> RED_FLANKED_BLUETAIL_ENTITY = registerBirdEntity(BirdSettings.RED_FLANKED_BLUETAIL_SETTINGS);
    public static final EntityType<BirdEntity> STELLERS_EIDER_ENTITY = registerBirdEntity(BirdSettings.STELLERS_EIDER_SETTINGS);
    public static final EntityType<BirdEntity> HOATZIN_ENTITY = registerBirdEntity(BirdSettings.HOATZIN_SETTINGS);
    public static final EntityType<BirdEntity> KING_OF_SAXONY_ENTITY = registerBirdEntity(BirdSettings.KING_OF_SAXONY_SETTINGS);
    public static final EntityType<BirdEntity> MOTMOT_ENTITY = registerBirdEntity(BirdSettings.MOTMOT_SETTINGS);
    public static final EntityType<BirdEntity> EASTERN_BLUEBIRD_ENTITY = registerBirdEntity(BirdSettings.EASTERN_BLUEBIRD_SETTINGS);
    public static final EntityType<BirdEntity> GREEN_HERON_ENTITY = registerBirdEntity(BirdSettings.GREEN_HERON_SETTINGS);
    public static final EntityType<BirdEntity> KILLDEER_ENTITY = registerBirdEntity(BirdSettings.KILLDEER_SETTINGS);
    public static final EntityType<BirdEntity> NORTHERN_MOCKINGBIRD_ENTITY = registerBirdEntity(BirdSettings.NORTHERN_MOCKINGBIRD_SETTINGS);
    public static final EntityType<BirdEntity> BROWN_BOOBY_ENTITY = registerBirdEntity(BirdSettings.BROWN_BOOBY_SETTINGS);
    public static final EntityType<BirdEntity> GREAT_GREY_OWL_ENTITY = registerBirdEntity(BirdSettings.GREAT_GREY_OWL_SETTINGS);
    public static final EntityType<BirdEntity> SABINES_GULL_ENTITY = registerBirdEntity(BirdSettings.SABINES_GULL_SETTINGS);
    public static final EntityType<BirdEntity> RAZORBILL_ENTITY = registerBirdEntity(BirdSettings.RAZORBILL_SETTINGS);
    public static final EntityType<BirdEntity> HIMALAYAN_MONAL_ENTITY = registerBirdEntity(BirdSettings.HIMALAYAN_MONAL_SETTINGS);


    public static EntityType<BirdEntity> registerBirdEntity(BirdEntity.Settings birdSettings) {
        return Registry.register(
                Registry.ENTITY_TYPE,
                new Identifier(Main.ModID, birdSettings.path),
                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, (EntityType<BirdEntity> type, World worldIn) -> new BirdEntity(type, worldIn, birdSettings)).dimensions(EntityDimensions.fixed(birdSettings.width, birdSettings.height)).build());
    }

    public static void registerRenderer(EntityType<BirdEntity> birdEntity, BirdEntity.Settings settings){
        EntityRendererRegistry.INSTANCE.register(birdEntity,
                (context) -> new BirdBaseRenderer(context, "geo/"+settings.path+".geo.json", "textures/entity/"+settings.path+".png", "animations/"+settings.path+".animation.json"));
    }


    public static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(EURASIAN_BULLFINCH_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(RED_NECKED_NIGHTJAR_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(RED_FLANKED_BLUETAIL_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(STELLERS_EIDER_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(HOATZIN_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(KING_OF_SAXONY_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(MOTMOT_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(EASTERN_BLUEBIRD_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(GREEN_HERON_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(KILLDEER_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(NORTHERN_MOCKINGBIRD_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(BROWN_BOOBY_ENTITY, BirdEntity.createBirdAttributes());
        // Note custom createBirdAttributes on owl
        FabricDefaultAttributeRegistry.register(GREAT_GREY_OWL_ENTITY, GreatGreyOwlEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(SABINES_GULL_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(RAZORBILL_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(HIMALAYAN_MONAL_ENTITY, BirdEntity.createBirdAttributes());
    }

    public static void registerRenderers(){
        registerRenderer(EURASIAN_BULLFINCH_ENTITY, BirdSettings.EURASIAN_BULLFINCH_SETTINGS);
        registerRenderer(RED_NECKED_NIGHTJAR_ENTITY, BirdSettings.RED_NECKED_NIGHTJAR_SETTINGS);
        registerRenderer(RED_FLANKED_BLUETAIL_ENTITY, BirdSettings.RED_FLANKED_BLUETAIL_SETTINGS);
        registerRenderer(STELLERS_EIDER_ENTITY, BirdSettings.STELLERS_EIDER_SETTINGS);
        registerRenderer(HOATZIN_ENTITY, BirdSettings.HOATZIN_SETTINGS);
        registerRenderer(KING_OF_SAXONY_ENTITY, BirdSettings.KING_OF_SAXONY_SETTINGS);
        registerRenderer(MOTMOT_ENTITY, BirdSettings.MOTMOT_SETTINGS);
        registerRenderer(EASTERN_BLUEBIRD_ENTITY, BirdSettings.EASTERN_BLUEBIRD_SETTINGS);
        registerRenderer(GREEN_HERON_ENTITY, BirdSettings.GREEN_HERON_SETTINGS);
        registerRenderer(KILLDEER_ENTITY, BirdSettings.KILLDEER_SETTINGS);
        registerRenderer(NORTHERN_MOCKINGBIRD_ENTITY, BirdSettings.NORTHERN_MOCKINGBIRD_SETTINGS);
        registerRenderer(BROWN_BOOBY_ENTITY, BirdSettings.BROWN_BOOBY_SETTINGS);
        registerRenderer(GREAT_GREY_OWL_ENTITY, BirdSettings.GREAT_GREY_OWL_SETTINGS);
        registerRenderer(SABINES_GULL_ENTITY, BirdSettings.SABINES_GULL_SETTINGS);
        registerRenderer(RAZORBILL_ENTITY, BirdSettings.RAZORBILL_SETTINGS);
        registerRenderer(HIMALAYAN_MONAL_ENTITY, BirdSettings.HIMALAYAN_MONAL_SETTINGS);
    }
}
