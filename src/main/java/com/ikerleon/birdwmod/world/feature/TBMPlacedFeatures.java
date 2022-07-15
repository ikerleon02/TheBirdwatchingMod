package com.ikerleon.birdwmod.world.feature;

import com.google.common.collect.ImmutableList;
import com.ikerleon.birdwmod.Main;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.ArrayList;
import java.util.List;

import static com.ikerleon.birdwmod.world.feature.TBMConfiguredFeatures.register;

public class TBMPlacedFeatures {

    private static final RegistryEntry<PlacedFeature> OLDBIRCH = createPlacedFeatureWithoutBiomeFilter("oldbirch", TBMConfiguredFeatures.OLDBIRCH);

    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> MOUNTAIN_OLD_BIRCH_TREES_CONFIGURED = register("mountain_old_birch_trees", Feature.RANDOM_SELECTOR,
            new RandomFeatureConfig(
                    ImmutableList.of(
                            new RandomFeatureEntry(OLDBIRCH,0.6F),
                            new RandomFeatureEntry(createPlacedFeatureWithoutBiomeFilter("fallen_oak_tree", register("fallen_aok_tree", Feature.TREE, TBMConfiguredFeatures.FALLEN_OAK_TREE_CONFIG)), 0.4F)

                    ),
                    TBMPlacedFeatures.OLDBIRCH
            )
    );

    public static final RegistryEntry<PlacedFeature> MOUNTAIN_OLD_BIRCH_TREES = createPlacedFeature("woodlands_trees", MOUNTAIN_OLD_BIRCH_TREES_CONFIGURED, CountPlacementModifier.of(7), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT)));

    public static final RegistryEntry<PlacedFeature> ERICA_BUSH = createPlacedFeature("erica_bush", TBMConfiguredFeatures.ERICA_BUSH, PlacedFeatures.createCountExtraModifier(0, 0.5f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP);


    public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeature(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
        List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
        list.add(BiomePlacementModifier.of());
        return createPlacedFeature(id, feature, list);
    }

    public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeatureWithoutBiomeFilter(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
        List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
        return createPlacedFeature(id, feature, list);
    }

    public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeature(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
        Identifier realID = new Identifier(Main.ModID, id);
        if (BuiltinRegistries.PLACED_FEATURE.getIds().contains(realID))
            throw new IllegalStateException("Placed Feature ID: \"" + realID.toString() + "\" already exists in the Placed Features registry!");

        return BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, realID, new PlacedFeature(RegistryEntry.upcast(feature), List.copyOf(placementModifiers)));
    }
}
