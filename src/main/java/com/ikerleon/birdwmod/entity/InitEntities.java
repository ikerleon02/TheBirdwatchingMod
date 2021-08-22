package com.ikerleon.birdwmod.entity;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.client.render.GUIBirdRenderer;
import com.ikerleon.birdwmod.util.SoundHandler;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;

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

    // GUI bird uses a set of defaults that gets overridden anyways
    public static final EntityType<BirdEntity> GUI_BIRD_ENTITY = Registry.register(
                Registry.ENTITY_TYPE, new Identifier(Main.ModID, "gui_display_bird"),
                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, (EntityType<BirdEntity> type, World worldIn) -> new BirdEntity(type, worldIn, BirdSettings.EURASIAN_BULLFINCH_SETTINGS)).dimensions(EntityDimensions.fixed(0.3F, 0.3F)).build());

    public static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(GUI_BIRD_ENTITY, BirdSettings.EURASIAN_BULLFINCH_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(EURASIAN_BULLFINCH_ENTITY, BirdSettings.EURASIAN_BULLFINCH_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(RED_NECKED_NIGHTJAR_ENTITY, BirdSettings.RED_NECKED_NIGHTJAR_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(RED_FLANKED_BLUETAIL_ENTITY, BirdSettings.RED_FLANKED_BLUETAIL_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(STELLERS_EIDER_ENTITY, BirdSettings.STELLERS_EIDER_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(HOATZIN_ENTITY, BirdSettings.HOATZIN_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(KING_OF_SAXONY_ENTITY, BirdSettings.KING_OF_SAXONY_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(MOTMOT_ENTITY, BirdSettings.MOTMOT_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(EASTERN_BLUEBIRD_ENTITY, BirdSettings.EASTERN_BLUEBIRD_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(GREEN_HERON_ENTITY, BirdSettings.GREEN_HERON_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(KILLDEER_ENTITY, BirdSettings.KILLDEER_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(NORTHERN_MOCKINGBIRD_ENTITY, BirdSettings.NORTHERN_MOCKINGBIRD_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(BROWN_BOOBY_ENTITY, BirdSettings.BROWN_BOOBY_SETTINGS.createBirdAttributes());
        // Note custom createBirdAttributes on owl. It has attributes that Settings doesn't cover (currently? BirdOfPreyEntity.Settings?)
        FabricDefaultAttributeRegistry.register(GREAT_GREY_OWL_ENTITY, GreatGreyOwlEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(SABINES_GULL_ENTITY, BirdSettings.SABINES_GULL_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(RAZORBILL_ENTITY, BirdSettings.RAZORBILL_SETTINGS.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(HIMALAYAN_MONAL_ENTITY, BirdSettings.HIMALAYAN_MONAL_SETTINGS.createBirdAttributes());
    }

    public static void registerRenderers(){
        EntityRendererRegistry.INSTANCE.register(GUI_BIRD_ENTITY, GUIBirdRenderer::new);
        registerRenderer(EURASIAN_BULLFINCH_ENTITY);
        registerRenderer(RED_NECKED_NIGHTJAR_ENTITY);
        registerRenderer(RED_FLANKED_BLUETAIL_ENTITY);
        registerRenderer(STELLERS_EIDER_ENTITY);
        registerRenderer(HOATZIN_ENTITY);
        registerRenderer(KING_OF_SAXONY_ENTITY);
        registerRenderer(MOTMOT_ENTITY);
        registerRenderer(EASTERN_BLUEBIRD_ENTITY);
        registerRenderer(GREEN_HERON_ENTITY);
        registerRenderer(KILLDEER_ENTITY);
        registerRenderer(NORTHERN_MOCKINGBIRD_ENTITY);
        registerRenderer(BROWN_BOOBY_ENTITY);
        registerRenderer(GREAT_GREY_OWL_ENTITY);
        registerRenderer(SABINES_GULL_ENTITY);
        registerRenderer(RAZORBILL_ENTITY);
        registerRenderer(HIMALAYAN_MONAL_ENTITY);
    }

    private static boolean biomeCompatibleWithSettings(BiomeSelectionContext context, BirdEntity.Settings settings){
        for(BirdEntity.Settings.BiomeDescriptor biomeDescriptor : settings.getSpawnBiomes()){
            if (context.getBiome().getCategory().equals(biomeDescriptor.getBiomeCategory())){
                double[] temperatureRange = biomeDescriptor.getTemperatureRange();
                if (context.getBiome().getTemperature() > temperatureRange[0] && context.getBiome().getTemperature() <= temperatureRange[1]){
                    return true;
                }
            }
        }
        return false;
    }

    public static EntityType<BirdEntity> registerBirdEntity(BirdEntity.Settings birdSettings) {
        EntityType<BirdEntity> bird = Registry.register(
                Registry.ENTITY_TYPE,
                new Identifier(Main.ModID, birdSettings.path),
                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, (EntityType<BirdEntity> type, World worldIn) -> new BirdEntity(type, worldIn, birdSettings)).dimensions(EntityDimensions.fixed(birdSettings.width, birdSettings.height)).build());
        BiomeModifications.addSpawn(context -> biomeCompatibleWithSettings(context, birdSettings), SpawnGroup.CREATURE, bird, birdSettings.prevalence, birdSettings.minGroupSize, birdSettings.maxGroupSize);
        return bird;
    }

    public static void registerRenderer(EntityType<BirdEntity> birdEntity){
        EntityRendererRegistry.INSTANCE.register(birdEntity, BirdBaseRenderer::new);
    }
}
