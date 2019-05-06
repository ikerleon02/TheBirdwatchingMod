package com.ikerleon.birdwmod.client.model.northamerica;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelEasternBluebird_Speaking2 - ikerleon02
 * Created using Tabula 7.0.0
 */
public class ModelEasternBluebird_Speaking2 extends ModelEasternBluebird {

    public ModelEasternBluebird_Speaking2() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.headfront.setRotationPoint(0.0F, -0.5F, -4.3F);
        this.headfront.addBox(-1.5F, -2.0F, 0.0F, 3, 2, 1, 0.0F);
        this.belly.setRotationPoint(0.0F, 4.9F, 0.0F);
        this.belly.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 3, 0.0F);
        this.setRotateAngle(belly, -2.443460952792061F, 0.0F, 0.0F);
        this.beak.setRotationPoint(0.0F, -1.4F, 1.5F);
        this.beak.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(beak, 0.12217304763960307F, 0.0F, 0.0F);
        this.tailmiddle.setRotationPoint(0.0F, 0.3F, 4.5F);
        this.tailmiddle.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
        this.setRotateAngle(tailmiddle, 0.08726646259971647F, 0.0F, 0.0F);
        this.headtop4.setRotationPoint(0.0F, -3.3F, -2.0F);
        this.headtop4.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.body2.setRotationPoint(0.0F, 1.1F, 5.3F);
        this.body2.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 5, 0.0F);
        this.setRotateAngle(body2, -0.17453292519943295F, 0.0F, 0.0F);
        this.tailleft.setRotationPoint(0.4F, 0.4F, 4.5F);
        this.tailleft.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
        this.setRotateAngle(tailleft, 0.08726646259971647F, 0.08726646259971647F, 0.17453292519943295F);
        this.rightwing2.setRotationPoint(-0.9F, -0.9F, 3.5F);
        this.rightwing2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(rightwing2, -0.08726646259971647F, 0.08726646259971647F, 0.0F);
        this.rightwing_1.setRotationPoint(2.0F, 2.9F, 3.1F);
        this.rightwing_1.addBox(0.0F, -1.5F, -1.5F, 1, 4, 6, 0.0F);
        this.neckfront.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.neckfront.addBox(-1.5F, -2.0F, -3.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(neckfront, 0.9599310885968813F, 0.0F, 0.0F);
        this.belly3.setRotationPoint(0.0F, 4.9F, 8.7F);
        this.belly3.addBox(-1.5F, 0.0F, -3.0F, 3, 5, 3, 0.0F);
        this.setRotateAngle(belly3, -1.0471975511965976F, 0.0F, 0.0F);
        this.leftfoot.setRotationPoint(0.0F, 4.4F, -0.6F);
        this.leftfoot.addBox(-1.0F, 0.0F, -2.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(leftfoot, 0.2617993877991494F, 0.0F, 0.0F);
        this.beakbase.setRotationPoint(0.0F, -0.6F, 1.7F);
        this.beakbase.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(beakbase, 0.2617993877991494F, 0.0F, 0.0F);
        this.rightfoot.setRotationPoint(0.0F, 4.4F, -0.6F);
        this.rightfoot.addBox(-1.0F, 0.0F, -2.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(rightfoot, 0.2617993877991494F, 0.0F, 0.0F);
        this.rightwing.setRotationPoint(-2.0F, 2.9F, 3.1F);
        this.rightwing.addBox(-1.0F, -1.5F, -1.5F, 1, 4, 6, 0.0F);
        this.head.setRotationPoint(0.0F, 1.2F, -6.3F);
        this.head.addBox(-2.0F, -3.0F, -4.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(head, 0.5235987755982988F, 0.0F, 0.0F);
        this.rightwing3.setRotationPoint(0.1F, 0.6F, 3.5F);
        this.rightwing3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(rightwing3, 0.08726646259971647F, 0.0F, 0.0F);
        this.rightwing3_1.setRotationPoint(-0.1F, 0.6F, 3.5F);
        this.rightwing3_1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(rightwing3_1, 0.08726646259971647F, 0.0F, 0.0F);
        this.leftleg.setRotationPoint(1.4F, 3.5F, 6.0F);
        this.leftleg.addBox(-0.5F, 0.0F, -1.0F, 1, 5, 1, 0.0F);
        this.belly2.setRotationPoint(0.0F, 5.0F, 0.1F);
        this.belly2.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 3, 0.0F);
        this.setRotateAngle(belly2, 1.0471975511965976F, 0.0F, 0.0F);
        this.shape13.setRotationPoint(0.0F, 1.7F, 8.2F);
        this.shape13.addBox(-1.5F, 0.0F, -8.0F, 3, 3, 8, 0.0F);
        this.setRotateAngle(shape13, -0.3490658503988659F, 0.0F, 0.0F);
        this.body.setRotationPoint(0.0F, 14.0F, -4.0F);
        this.body.addBox(-2.5F, 1.0F, 0.0F, 5, 4, 6, 0.0F);
        this.setRotateAngle(body, -0.2617993877991494F, 0.0F, 0.0F);
        this.rightleg.setRotationPoint(-1.4F, 3.5F, 6.0F);
        this.rightleg.addBox(-0.5F, 0.0F, -1.0F, 1, 5, 1, 0.0F);
        this.tailright.setRotationPoint(-0.4F, 0.4F, 4.5F);
        this.tailright.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
        this.setRotateAngle(tailright, 0.08726646259971647F, -0.08726646259971647F, -0.17453292519943295F);
        this.rightwing2_1.setRotationPoint(-0.1F, -0.9F, 3.5F);
        this.rightwing2_1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(rightwing2_1, -0.08726646259971647F, -0.08726646259971647F, 0.0F);
    }
}
