package com.ikerleon.birdwmod.client.model.northamerica;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * ModelNorthernMockingbirdFlying - ikerleon
 * Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelNorthernMockingbirdFlying extends ModelNorthernMockingbird {

    public ModelNorthernMockingbirdFlying() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.leftleg.setRotationPoint(1.4F, 3.25F, 4.75F);
        this.leftleg.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(leftleg, 1.5707963267948966F, 0.0F, 0.0F);
        this.neckbottom_1.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.neckbottom_1.addBox(-1.5F, 0.0F, -0.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(neckbottom_1, 0.5462880558742251F, 0.0F, 0.0F);
        this.headback.setRotationPoint(0.0F, -0.7F, 0.1F);
        this.headback.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
        this.bellyback.setRotationPoint(0.0F, 1.2F, 9.6F);
        this.bellyback.addBox(-1.5F, -6.0F, -2.1F, 3, 6, 3, 0.0F);
        this.setRotateAngle(bellyback, 2.007128639793479F, 0.0F, 0.0F);
        this.headtop.setRotationPoint(0.0F, -2.5F, 1.3F);
        this.headtop.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
        this.leftfeet.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.leftfeet.addBox(-1.0F, 0.0F, -2.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(leftfeet, -1.5707963267948966F, 0.0F, 0.0F);
        this.rightleg.setRotationPoint(-1.4F, 3.25F, 4.75F);
        this.rightleg.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rightleg, 1.5707963267948966F, 0.0F, 0.0F);
        this.beak.setRotationPoint(0.0F, 1.9F, -0.6F);
        this.beak.addBox(-0.5F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(beak, -0.17453292519943295F, 0.0F, 0.0F);
        this.tail.setRotationPoint(0.0F, 3.0F, -0.7F);
        this.tail.addBox(-1.0F, 0.0F, -0.5F, 2, 10, 1, 0.0F);
        this.setRotateAngle(tail, -0.08726646259971647F, 0.0F, 0.0F);
        this.tailright.setRotationPoint(-0.7F, -0.2F, -0.5F);
        this.tailright.addBox(-1.0F, 0.0F, -0.5F, 2, 9, 1, 0.0F);
        this.setRotateAngle(tailright, 0.0F, -0.4363323129985824F, 0.0F);
        this.rightwing2_1.setRotationPoint(-0.5F, 0.1F, 3.5F);
        this.rightwing2_1.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(rightwing2_1, 0.0F, -0.08726646259971647F, -0.08726646259971647F);
        this.body.setRotationPoint(0.0F, 14.5F, -4.3F);
        this.body.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 8, 0.0F);
        this.rightwing2.setRotationPoint(0.5F, 0.1F, 3.5F);
        this.rightwing2.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(rightwing2, 0.0F, 0.08726646259971647F, 0.08726646259971647F);
        this.body2.setRotationPoint(0.0F, 0.5F, 6.6F);
        this.body2.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(body2, 1.7453292519943295F, 0.0F, 0.0F);
        this.head.setRotationPoint(0.0F, 2.0F, 2.2F);
        this.head.addBox(-2.0F, -3.0F, 0.0F, 4, 4, 3, 0.0F);
        this.rightwing3.setRotationPoint(0.2F, 0.5F, 3.0F);
        this.rightwing3.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(rightwing3, 0.17453292519943295F, 0.0F, 0.0F);
        this.rightfeet.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.rightfeet.addBox(-1.0F, 0.0F, -2.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(rightfeet, -1.5707963267948966F, 0.0F, 0.0F);
        this.rightwing.setRotationPoint(-2.5F, 2.0F, 2.5F);
        this.rightwing.addBox(-0.5F, -1.5F, -1.5F, 1, 5, 6, 0.0F);
        this.setRotateAngle(rightwing, -1.2217304763960306F, -0.05235987755982988F, 1.498016096986733F);
        this.beakbase.setRotationPoint(0.0F, -3.0F, 1.2F);
        this.beakbase.addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(beakbase, 0.05235987755982988F, 0.0F, 0.010297442586766544F);
        this.rightwing3_1.setRotationPoint(-0.2F, 0.5F, 3.0F);
        this.rightwing3_1.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(rightwing3_1, 0.17453292519943295F, 0.0F, 0.0F);
        this.neckbottom.setRotationPoint(0.0F, 3.8F, 0.1F);
        this.neckbottom.addBox(-2.0F, -3.0F, -0.0F, 4, 3, 3, 0.0F);
        this.setRotateAngle(neckbottom, 1.1383037381507017F, 0.0F, 0.0F);
        this.rightleg2.setRotationPoint(0.0F, 3.7F, 0.1F);
        this.rightleg2.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rightleg2, -0.08726646259971647F, 0.0F, 0.0F);
        this.tailleft.setRotationPoint(0.7F, -0.2F, -0.5F);
        this.tailleft.addBox(-1.0F, 0.0F, -0.5F, 2, 9, 1, 0.0F);
        this.setRotateAngle(tailleft, 0.0F, 0.4363323129985824F, 0.0F);
        this.leftleg2.setRotationPoint(0.0F, 3.7F, 0.1F);
        this.leftleg2.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(leftleg2, -0.08726646259971647F, 0.0F, 0.0F);
        this.belly.setRotationPoint(0.0F, 3.0F, 0.6F);
        this.belly.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 2, 0.0F);
        this.setRotateAngle(belly, 1.3962634015954636F, 0.0F, 0.0F);
        this.rightwing_1.setRotationPoint(2.5F, 2.0F, 2.5F);
        this.rightwing_1.addBox(-0.5F, -1.5F, -1.5F, 1, 5, 6, 0.0F);
        this.setRotateAngle(rightwing_1, -1.2217304763960306F, 0.05235987755982988F, -1.48352986419518F);
        this.necktop.setRotationPoint(0.0F, 0.8F, 5.0F);
        this.necktop.addBox(-1.0F, -5.0F, -3.0F, 2, 5, 3, 0.0F);
        this.setRotateAngle(necktop, 1.2747884856566583F, 0.0F, 0.0F);
    }
}
