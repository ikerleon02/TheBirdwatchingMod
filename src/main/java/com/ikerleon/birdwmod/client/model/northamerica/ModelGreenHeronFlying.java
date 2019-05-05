package com.ikerleon.birdwmod.client.model.northamerica;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * ModelGreenHeronFlying - ikerleon
 * Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelGreenHeronFlying extends ModelGreenHeron {

    public ModelGreenHeronFlying() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Beakjoint.setRotationPoint(0.0F, -2.8F, 1.4F);
        this.Beakjoint.addBox(-1.0F, -2.0F, -2.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(Beakjoint, 0.8651597102135892F, 0.0F, 0.0F);
        this.Head.setRotationPoint(0.0F, -0.1F, -0.9F);
        this.Head.addBox(-2.0F, -3.0F, -1.5F, 4, 4, 3, 0.0F);
        this.setRotateAngle(Head, 1.3962634015954636F, 0.0F, 0.0F);
        this.Wing2L.setRotationPoint(-0.1F, -0.5F, 0.0F);
        this.Wing2L.addBox(0.0F, -2.0F, 0.0F, 1, 5, 5, 0.0F);
        this.setRotateAngle(Wing2L, -0.05235987755982988F, 0.0F, 0.0F);
        this.Neck.setRotationPoint(0.0F, 1.9F, -2.8F);
        this.Neck.addBox(-2.0F, -2.5F, -4.0F, 4, 3, 5, 0.0F);
        this.setRotateAngle(Neck, -1.4114477660878142F, 0.0F, 0.0F);
        this.FootL_1.setRotationPoint(0.0F, 2.7F, 0.2F);
        this.FootL_1.addBox(-0.5F, -0.0F, -2.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(FootL_1, 1.2217304763960306F, -0.5235987755982988F, -0.15707963267948966F);
        this.Tailbottom.setRotationPoint(0.0F, 3.96F, 1.63F);
        this.Tailbottom.addBox(-1.5F, -1.5F, 0.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(Tailbottom, 0.8726646259971648F, 0.0F, 0.0F);
        this.belly2.setRotationPoint(0.0F, 5.1F, 0.0F);
        this.belly2.addBox(-1.5F, -2.0F, 0.0F, 3, 2, 6, 0.0F);
        this.setRotateAngle(belly2, 0.2617993877991494F, 0.0F, 0.0F);
        this.Throat.setRotationPoint(0.0F, 1.5F, 1.3F);
        this.Throat.addBox(-1.5F, -3.0F, -2.0F, 3, 3, 2, 0.0F);
        this.setRotateAngle(Throat, 0.2617993877991494F, -0.003490658503988659F, 0.0F);
        this.Wing4L.setRotationPoint(-0.1F, -0.2F, 3.3F);
        this.Wing4L.addBox(-0.5F, -1.0F, 0.0F, 1, 3, 3, 0.0F);
        this.setRotateAngle(Wing4L, 0.17453292519943295F, 0.0F, 0.0F);
        this.WingL.setRotationPoint(2.0F, 0.3F, 0.5F);
        this.WingL.addBox(0.0F, -2.0F, -2.0F, 1, 5, 5, 0.0F);
        this.setRotateAngle(WingL, -1.48352986419518F, 0.0F, -1.3962634015954636F);
        this.FootL_4.setRotationPoint(0.0F, 2.7F, 0.2F);
        this.FootL_4.addBox(-0.5F, -0.0F, -2.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(FootL_4, 1.2217304763960306F, -0.5235987755982988F, -0.15707963267948966F);
        this.Wing3R.setRotationPoint(-0.3F, 0.3F, 3.0F);
        this.Wing3R.addBox(-0.5F, -1.5F, 0.0F, 1, 4, 4, 0.0F);
        this.setRotateAngle(Wing3R, 0.08726646259971647F, 0.0F, 0.0F);
        this.Jaw.setRotationPoint(0.0F, -2.2F, -0.3F);
        this.Jaw.addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
        this.ThighL.setRotationPoint(1.7F, 2.0F, 2.8F);
        this.ThighL.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(ThighL, 1.48352986419518F, 0.0F, 0.0F);
        this.Tailmid.setRotationPoint(0.0F, 1.45F, 0.41F);
        this.Tailmid.addBox(-1.5F, -0.5F, 0.0F, 3, 1, 2, 0.0F);
        this.headtop.setRotationPoint(0.0F, -1.2F, 1.3F);
        this.headtop.addBox(-1.5F, -1.5F, -0.5F, 3, 3, 1, 0.0F);
        this.belly.setRotationPoint(0.0F, 3.4F, -4.3F);
        this.belly.addBox(-2.0F, -2.0F, 0.0F, 4, 2, 5, 0.0F);
        this.setRotateAngle(belly, -0.40980330836826856F, 0.0F, 0.0F);
        this.FootL_5.setRotationPoint(0.0F, 2.7F, 0.2F);
        this.FootL_5.addBox(-0.5F, -0.0F, -2.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(FootL_5, 1.2217304763960306F, 0.5235987755982988F, 0.15707963267948966F);
        this.Wing3L.setRotationPoint(0.3F, 0.3F, 3.0F);
        this.Wing3L.addBox(-0.5F, -1.5F, 0.0F, 1, 4, 4, 0.0F);
        this.setRotateAngle(Wing3L, 0.08726646259971647F, 0.0F, 0.0F);
        this.Wing2R.setRotationPoint(0.1F, -0.5F, 0.0F);
        this.Wing2R.addBox(-1.0F, -2.0F, 0.0F, 1, 5, 5, 0.0F);
        this.setRotateAngle(Wing2R, -0.05235987755982988F, 0.0F, 0.0F);
        this.CalfR.setRotationPoint(0.0F, 2.8F, 0.0F);
        this.CalfR.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(CalfR, -0.30543261909900765F, 0.0F, 0.0F);
        this.FootL_3.setRotationPoint(0.0F, 2.8F, 0.2F);
        this.FootL_3.addBox(-0.5F, -0.0F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(FootL_3, 1.2217304763960306F, 0.0F, 0.0F);
        this.Neck2.setRotationPoint(0.0F, 0.9F, -2.2F);
        this.Neck2.addBox(-1.5F, -1.5F, -1.0F, 3, 3, 2, 0.0F);
        this.setRotateAngle(Neck2, 1.7756979809790308F, 0.0F, 0.0F);
        this.Beaktop.setRotationPoint(0.0F, -2.7F, 0.0F);
        this.Beaktop.addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Beaktop, 0.06981317007977318F, 0.0F, 0.0F);
        this.Wing4R.setRotationPoint(0.1F, -0.2F, 3.3F);
        this.Wing4R.addBox(-0.5F, -1.0F, 0.0F, 1, 3, 3, 0.0F);
        this.setRotateAngle(Wing4R, 0.17453292519943295F, 0.0F, 0.0F);
        this.Body.setRotationPoint(0.0F, 14.2F, 0.6F);
        this.Body.addBox(-2.5F, -2.5F, -2.8F, 5, 6, 8, 0.0F);
        this.setRotateAngle(Body, -0.05235987755982988F, 0.0F, 0.0F);
        this.FootL_2.setRotationPoint(0.0F, 2.7F, 0.2F);
        this.FootL_2.addBox(-0.5F, -0.0F, -2.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(FootL_2, 1.2217304763960306F, 0.5235987755982988F, 0.15707963267948966F);
        this.CalfL.setRotationPoint(0.0F, 2.8F, 0.0F);
        this.CalfL.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(CalfL, -0.30543261909900765F, 0.0F, 0.0F);
        this.WingR.setRotationPoint(-2.0F, 0.3F, 0.5F);
        this.WingR.addBox(-1.0F, -2.0F, -2.0F, 1, 5, 5, 0.0F);
        this.setRotateAngle(WingR, -1.48352986419518F, 0.0F, 1.3962634015954636F);
        this.ThighR.setRotationPoint(-1.7F, 2.0F, 2.8F);
        this.ThighR.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(ThighR, 1.48352986419518F, 0.0F, 0.0F);
        this.FootL.setRotationPoint(0.0F, 2.8F, 0.2F);
        this.FootL.addBox(-0.5F, -0.0F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(FootL, 1.2217304763960306F, 0.0F, 0.0F);
        this.Tailtop.setRotationPoint(0.0F, -1.94F, 4.16F);
        this.Tailtop.addBox(-2.0F, -0.5F, 0.0F, 4, 2, 5, 0.0F);
        this.setRotateAngle(Tailtop, -0.3490658503988659F, 0.0F, 0.0F);
    }
}
