package com.ikerleon.birdwmod.client.model.northamerica;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelGreenHeronFlying - ikerleon
 * Created using Tabula 7.0.0
 */
public class ModelGreenHeronFlying_Speaking extends ModelGreenHeronFlying {

    public ModelGreenHeronFlying_Speaking() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Jaw.setRotationPoint(0.0F, -2.2F, -0.3F);
        this.Jaw.addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Jaw, 0.3490658503988659F, 0.0F, 0.0F);
        this.Beaktop.setRotationPoint(0.0F, -2.7F, 0.0F);
        this.Beaktop.addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Beaktop, 0.017453292519943295F, 0.0F, 0.0F);
    }
}
