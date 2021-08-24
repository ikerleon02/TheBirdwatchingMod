package com.ikerleon.birdwmod.world.feature.placer;

import com.terraformersmc.terraform.tree.placer.PlacerTypes;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class TBMPlacerTypes {
    public static final FoliagePlacerType<NoneFoliagePlacer> NONE_FOLIAGE_PLACER = PlacerTypes.registerFoliagePlacer("birdwmod:none", NoneFoliagePlacer.CODEC);
    public static final TrunkPlacerType<FallenTrunkPlacer> FALLEN_TRUNK_PLACER = PlacerTypes.registerTrunkPlacer("traverse:fallen", FallenTrunkPlacer.CODEC);
}
