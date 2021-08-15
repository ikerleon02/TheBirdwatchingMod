package com.ikerleon.birdwmod.client.model.entity;

import com.ikerleon.birdwmod.Main;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BirdBaseModel extends AnimatedGeoModel
{
    private final String model;
    private final String texture;
    private final String animation;

    public BirdBaseModel(String model_location, String texture_location, String animation_location){
        super();
        model = model_location;
        texture  = texture_location;
        animation = animation_location;
    }
    @Override
    public Identifier getModelLocation(Object entity)
    {return new Identifier(Main.ModID, model);}

    @Override
    public Identifier getTextureLocation(Object entity)
    {return new Identifier(Main.ModID, texture);}

    @Override
    public Identifier getAnimationFileLocation(Object entity)
    {return new Identifier(Main.ModID, animation);}
}