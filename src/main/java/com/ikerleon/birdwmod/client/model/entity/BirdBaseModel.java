package com.ikerleon.birdwmod.client.model.entity;

import com.ikerleon.birdwmod.Main;

import com.ikerleon.birdwmod.entity.BirdEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BirdBaseModel extends AnimatedGeoModel
{
    public BirdBaseModel(){ super();}

    private static String buildModelPath(String path){
        return "geo/"+path+".geo.json";
    }

    private static String buildTexturePath(String path){
        return "textures/entity/"+path+".png";
    }

    private static String buildAnimationPath(String path){
        return "animations/"+path+".animation.json";
    }

    @Override
    public Identifier getModelLocation(Object entity)
    {return new Identifier(Main.ModID, buildModelPath(((BirdEntity) entity).getPath()));}

    @Override
    public Identifier getTextureLocation(Object rawEntity) {
        BirdEntity entity = (BirdEntity) rawEntity;
        String path = entity.getPath() + "/" + entity.getPath();
        if (entity.isDimorphic() && entity.getGender() == 1 ){path += "_female";}
        if (entity.getVariant() >= 2) { path += ("_"+entity.getVariant()); }
        return new Identifier(Main.ModID, buildTexturePath(path));
    }

    @Override
    public Identifier getAnimationFileLocation(Object entity)
    {return new Identifier(Main.ModID, buildAnimationPath(((BirdEntity) entity).getPath()));}

}