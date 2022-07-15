package com.ikerleon.birdwmod.world.surfacebuilder;

import com.ikerleon.birdwmod.Main;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class InitSurfaceBuilders {
    //TODO
    /*private static final Map<Identifier, SurfaceBuilder<? extends SurfaceConfig>> SURFACE_BUILDERS = new HashMap<>();

    public static final SurfaceBuilder<TernarySurfaceConfig> MOUNTAIN_OLD_BIRCH_FOREST = add("mountain_old_birch_forest", new MossSurfaceBuilder(TernarySurfaceConfig.CODEC));

    private static <S extends SurfaceBuilder<? extends SurfaceConfig>> S add(String name, S feature) {
        SURFACE_BUILDERS.put(new Identifier(Main.ModID, name), feature);
        return feature;
    }

    public static void register() {
        for (Identifier id : SURFACE_BUILDERS.keySet()) {
            Registry.register(Registry.SURFACE_BUILDER, id, SURFACE_BUILDERS.get(id));
        }
    }*/
}
