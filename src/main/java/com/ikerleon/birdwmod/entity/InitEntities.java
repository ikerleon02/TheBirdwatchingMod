package com.ikerleon.birdwmod.entity;

/*import com.ikerleon.birdwmod.client.render.europe.RedFlankedBluetailRenderer;
import com.ikerleon.birdwmod.client.render.europe.RedNeckedNightjarRenderer;
import com.ikerleon.birdwmod.client.render.europe.StellersEiderRenderer;
import com.ikerleon.birdwmod.client.render.jungle.HoatzinRenderer;
import com.ikerleon.birdwmod.client.render.jungle.KingOfSaxonyRenderer;
import com.ikerleon.birdwmod.client.render.jungle.TurquoiseBrowedMotmotRenderer;
import com.ikerleon.birdwmod.client.render.northamerica.EasternBluebirdRenderer;
import com.ikerleon.birdwmod.client.render.northamerica.GreenHeronRenderer;
import com.ikerleon.birdwmod.client.render.northamerica.KilldeerRenderer;
import com.ikerleon.birdwmod.client.render.northamerica.NorthernMockingbirdRenderer;
import com.ikerleon.birdwmod.client.render.release160.BrownBoobyRenderer;
import com.ikerleon.birdwmod.client.render.release160.GreatGreyOwlRenderer;
import com.ikerleon.birdwmod.client.render.release170.HimalayanMonalRenderer;
import com.ikerleon.birdwmod.client.render.release170.RazorbillRenderer;
import com.ikerleon.birdwmod.client.render.release170.SabinesGullRenderer;*/
import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
/*import com.ikerleon.birdwmod.entity.europe.RedFlankedBluetailEntity;
import com.ikerleon.birdwmod.entity.europe.RedNeckedNightjarEntity;
import com.ikerleon.birdwmod.entity.europe.StellersEiderEntity;
import com.ikerleon.birdwmod.entity.jungle.HoatzinEntity;
import com.ikerleon.birdwmod.entity.jungle.KingOfSaxonyEntity;
import com.ikerleon.birdwmod.entity.jungle.TurquoiseBrowedMotmotEntity;
import com.ikerleon.birdwmod.entity.northamerica.EasternBluebirdEntity;
import com.ikerleon.birdwmod.entity.northamerica.GreenHeronEntity;
import com.ikerleon.birdwmod.entity.northamerica.KilldeerEntity;
import com.ikerleon.birdwmod.entity.northamerica.NorthernMockingbirdEntity;
import com.ikerleon.birdwmod.entity.release160.BrownBoobyEntity;
import com.ikerleon.birdwmod.entity.release160.GreatGreyOwlEntity;
import com.ikerleon.birdwmod.entity.release170.HimalayanMonalEntity;
import com.ikerleon.birdwmod.entity.release170.RazorbillEntity;
import com.ikerleon.birdwmod.entity.release170.SabinesGullEntity;*/
import com.ikerleon.birdwmod.items.InitItems;
import com.ikerleon.birdwmod.util.SoundHandler;
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

    /*public static final EntityType<KilldeerEntity> KILLDEER_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "killdeer"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, KilldeerEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.3f)).build()
    );
    public static final EntityType<EasternBluebirdEntity> EASTERN_BLUEBIRD_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "eastern_bluebird"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EasternBluebirdEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.3f)).build()
    );
    public static final EntityType<NorthernMockingbirdEntity> NORTHERN_MOCKINGBIRD_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "northern_mockingbird"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, NorthernMockingbirdEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.3f)).build()
    );
    public static final EntityType<GreenHeronEntity> GREEN_HERON_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "green_heron"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GreenHeronEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.5f)).build()
    );

    public static final EntityType<KingOfSaxonyEntity> KING_OF_SAXONY_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "kingofsaxony_bird_of_paradise"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, KingOfSaxonyEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.3f)).build()
    );
    public static final EntityType<TurquoiseBrowedMotmotEntity> TURQUOISE_BROWED_MOTMOT_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "turquoisebrowed_motmot"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TurquoiseBrowedMotmotEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.3f)).build()
    );

    public static final EntityType<GreatGreyOwlEntity> GREAT_GREY_OWL_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "great_grey_owl"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GreatGreyOwlEntity::new).dimensions(EntityDimensions.fixed(0.5f, 0.6f)).build()
    );
    public static final EntityType<BrownBoobyEntity> BROWN_BOOBY_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "brown_booby"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BrownBoobyEntity::new).dimensions(EntityDimensions.fixed(0.5f, 0.6f)).build()
    );

    public static final EntityType<RazorbillEntity> RAZORBILL_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "razorbill"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RazorbillEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.5f)).build()
    );
    public static final EntityType<HimalayanMonalEntity> HIMALAYAN_MONAL_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "himalayan_monal"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HimalayanMonalEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.6f)).build()
    );
    public static final EntityType<SabinesGullEntity> SABINES_GULL_ENTITY= Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("birdwmod", "sabines_gull"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SabinesGullEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.4f)).build()
    );*/


    public static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(EURASIAN_BULLFINCH_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(RED_NECKED_NIGHTJAR_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(RED_FLANKED_BLUETAIL_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(STELLERS_EIDER_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(HOATZIN_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(KING_OF_SAXONY_ENTITY, BirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(MOTMOT_ENTITY, BirdEntity.createBirdAttributes());

        /*FabricDefaultAttributeRegistry.register(RED_FLANKED_BLUETAIL_ENTITY, RedFlankedBluetailEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(STELLERS_EIDER_ENTITY, StellersEiderEntity.createBirdAttributes());

        FabricDefaultAttributeRegistry.register(KILLDEER_ENTITY, KilldeerEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(EASTERN_BLUEBIRD_ENTITY, EasternBluebirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(NORTHERN_MOCKINGBIRD_ENTITY, NorthernMockingbirdEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(GREEN_HERON_ENTITY, NorthernMockingbirdEntity.createBirdAttributes());

        FabricDefaultAttributeRegistry.register(HOATZIN_ENTITY, HoatzinEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(KING_OF_SAXONY_ENTITY, KingOfSaxonyEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(TURQUOISE_BROWED_MOTMOT_ENTITY, TurquoiseBrowedMotmotEntity.createBirdAttributes());

        FabricDefaultAttributeRegistry.register(GREAT_GREY_OWL_ENTITY, GreatGreyOwlEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(BROWN_BOOBY_ENTITY, BrownBoobyEntity.createBirdAttributes());

        FabricDefaultAttributeRegistry.register(RAZORBILL_ENTITY, RazorbillEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(HIMALAYAN_MONAL_ENTITY, HimalayanMonalEntity.createBirdAttributes());
        FabricDefaultAttributeRegistry.register(SABINES_GULL_ENTITY, SabinesGullEntity.createBirdAttributes());*/
    }

    public static void registerRenderers(){
        registerRenderer(EURASIAN_BULLFINCH_ENTITY, BirdSettings.EURASIAN_BULLFINCH_SETTINGS);
        registerRenderer(RED_NECKED_NIGHTJAR_ENTITY, BirdSettings.RED_NECKED_NIGHTJAR_SETTINGS);
        registerRenderer(RED_FLANKED_BLUETAIL_ENTITY, BirdSettings.RED_FLANKED_BLUETAIL_SETTINGS);
        registerRenderer(STELLERS_EIDER_ENTITY, BirdSettings.STELLERS_EIDER_SETTINGS);
        registerRenderer(HOATZIN_ENTITY, BirdSettings.HOATZIN_SETTINGS);
        registerRenderer(KING_OF_SAXONY_ENTITY, BirdSettings.KING_OF_SAXONY_SETTINGS);
        registerRenderer(MOTMOT_ENTITY, BirdSettings.MOTMOT_SETTINGS);

        /*EntityRendererRegistry.INSTANCE.register(InitEntities.RED_FLANKED_BLUETAIL_ENTITY, (dispatcher, context) -> {
            return new RedFlankedBluetailRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(InitEntities.STELLERS_EIDER_ENTITY, (dispatcher, context) -> {
            return new StellersEiderRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(InitEntities.KILLDEER_ENTITY, (dispatcher, context) -> {
            return new KilldeerRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(InitEntities.EASTERN_BLUEBIRD_ENTITY, (dispatcher, context) -> {
            return new EasternBluebirdRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(InitEntities.NORTHERN_MOCKINGBIRD_ENTITY, (dispatcher, context) -> {
            return new NorthernMockingbirdRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(InitEntities.GREEN_HERON_ENTITY, (dispatcher, context) -> {
            return new GreenHeronRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(InitEntities.HOATZIN_ENTITY, (dispatcher, context) -> {
            return new HoatzinRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(InitEntities.KING_OF_SAXONY_ENTITY, (dispatcher, context) -> {
            return new KingOfSaxonyRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(InitEntities.TURQUOISE_BROWED_MOTMOT_ENTITY, (dispatcher, context) -> {
            return new TurquoiseBrowedMotmotRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(InitEntities.GREAT_GREY_OWL_ENTITY, (dispatcher, context) -> {
            return new GreatGreyOwlRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(InitEntities.BROWN_BOOBY_ENTITY, (dispatcher, context) -> {
            return new BrownBoobyRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(InitEntities.RAZORBILL_ENTITY, (dispatcher, context) -> {
            return new RazorbillRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(InitEntities.HIMALAYAN_MONAL_ENTITY, (dispatcher, context) -> {
            return new HimalayanMonalRenderer(dispatcher);
        });
        EntityRendererRegistry.INSTANCE.register(InitEntities.SABINES_GULL_ENTITY, (dispatcher, context) -> {
            return new SabinesGullRenderer(dispatcher);
        });*/
    }
}
