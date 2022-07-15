package com.ikerleon.birdwmod.client.model.entity;

import com.ikerleon.birdwmod.Main;
import com.ikerleon.birdwmod.entity.BirdEntity;
import net.minecraft.util.Identifier;

public class GUIBirdModel extends BirdBaseModel
{
    private static final int ticksTilShift = 50;

    public GUIBirdModel(){ super();}

    public static int getVariantAtAge(long worldTime, int numVariants){
        if(numVariants == 1){return 1;}
        return (int)(worldTime % ((numVariants) * ticksTilShift))/ticksTilShift;
    }

    @Override
    public Identifier getTextureResource(Object rawEntity) {

        BirdEntity entity = (BirdEntity) rawEntity;
        String path = entity.getPath() + "/" + entity.getPath();
        int variant;
        if (entity.isDimorphic() && entity.getGender() == 1){
            path += "_female";
            variant = getVariantAtAge(entity.world.getTime(), entity.getBirdVariantsFemaleSpecific());
        } else {
            variant = getVariantAtAge(entity.world.getTime(), entity.getBirdVariants());
        }
        if(variant > 1){
            path += "_" + variant;
        }
        return new Identifier(Main.ModID, buildTexturePath(path));
    }
}