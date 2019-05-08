package com.ikerleon.birdwmod.client.model.europe;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * ModelRedNeckedNightjar_Speaking2 - ikerleon
 * Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelRedNeckedNightjar_Speaking2 extends ModelRedNeckedNightjar {

    public ModelRedNeckedNightjar_Speaking2() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.neckbottom2.setRotationPoint(0.0F, -3.5F, -0.5F);
        this.neckbottom2.addBox(-1.5F, -3.0F, -2.0F, 3, 3, 2, 0.0F);
        this.setRotateAngle(neckbottom2, -0.9075712110370513F, 0.0F, 0.0F);
        this.body3.setRotationPoint(0.0F, 0.2F, 4.7F);
        this.body3.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(body3, -0.08726646259971647F, 0.0F, 0.0F);
        this.rightwing3.setRotationPoint(0.7F, 1.7F, 4.5F);
        this.rightwing3.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 8, 0.0F);
        this.setRotateAngle(rightwing3, 0.17453292519943295F, 0.0F, -0.03490658503988659F);
        this.leftwing.setRotationPoint(2.7F, 3.0F, 3.0F);
        this.leftwing.addBox(0.0F, -3.0F, -2.0F, 1, 5, 7, 0.0F);
        this.leftwing2.setRotationPoint(0.2F, -2.1F, 4.7F);
        this.leftwing2.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 5, 0.0F);
        this.setRotateAngle(leftwing2, -0.03490658503988659F, -0.05235987755982988F, -0.03490658503988659F);
        this.rightwing2.setRotationPoint(-0.2F, -2.1F, 4.7F);
        this.rightwing2.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 5, 0.0F);
        this.setRotateAngle(rightwing2, -0.03490658503988659F, 0.05235987755982988F, 0.03490658503988659F);
        this.tail3.setRotationPoint(0.0F, 4.6F, -1.6F);
        this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 15, 0.0F);
        this.setRotateAngle(tail3, 0.40142572795869574F, 0.05235987755982988F, 0.0F);
        this.beak2.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.beak2.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(beak2, 0.6373942428283291F, 0.0F, 0.0F);
        this.necktop.setRotationPoint(0.0F, 0.0F, 5.6F);
        this.necktop.addBox(-1.5F, 0.0F, -4.0F, 3, 4, 4, 0.0F);
        this.setRotateAngle(necktop, -0.8726646259971648F, 0.0F, 0.0F);
        this.tail.setRotationPoint(0.0F, 4.3F, -1.5F);
        this.tail.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 16, 0.0F);
        this.setRotateAngle(tail, 0.40142572795869574F, 0.0F, 0.0F);
        this.tail2.setRotationPoint(0.0F, 4.6F, -1.6F);
        this.tail2.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 15, 0.0F);
        this.setRotateAngle(tail2, 0.40142572795869574F, -0.05235987755982988F, 0.0F);
        this.beak.setRotationPoint(0.0F, -3.8F, -1.0F);
        this.beak.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(beak, -0.5918411493512771F, 0.0F, 0.0F);
        this.neckbottom.setRotationPoint(0.0F, 4.9F, 2.1F);
        this.neckbottom.addBox(-2.5F, -5.0F, -2.0F, 5, 5, 2, 0.0F);
        this.setRotateAngle(neckbottom, 0.3839724354387525F, 0.0F, 0.0F);
        this.rightwing.setRotationPoint(-2.7F, 3.0F, 3.0F);
        this.rightwing.addBox(-1.0F, -3.0F, -2.0F, 1, 5, 7, 0.0F);
        this.headneck.setRotationPoint(0.0F, 2.7F, 0.4F);
        this.headneck.addBox(-2.0F, -3.0F, -3.0F, 4, 4, 3, 0.0F);
        this.head2.setRotationPoint(0.0F, 2.1F, -2.0F);
        this.head2.addBox(-2.0F, -3.0F, -3.0F, 4, 3, 3, 0.0F);
        this.setRotateAngle(head2, 0.17453292519943295F, 0.0F, 0.0F);
        this.head.setRotationPoint(0.0F, -0.5F, -3.5F);
        this.head.addBox(-2.5F, -1.0F, -5.0F, 5, 4, 5, 0.0F);
        this.setRotateAngle(head, 0.6373942428283291F, 0.0F, 0.0F);
        this.body2.setRotationPoint(0.0F, -0.1F, 6.0F);
        this.body2.addBox(-2.4F, 0.0F, 0.0F, 5, 6, 5, 0.0F);
        this.setRotateAngle(body2, -0.2792526803190927F, 0.0F, 0.0F);
        this.body.setRotationPoint(0.0F, 18.9F, -6.0F);
        this.body.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 7, 0.0F);
        this.leftwing3.setRotationPoint(-0.7F, 1.7F, 4.5F);
        this.leftwing3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 8, 0.0F);
        this.setRotateAngle(leftwing3, 0.17453292519943295F, 0.0F, -0.03490658503988659F);
        this.beakbase.setRotationPoint(0.0F, 0.0F, -0.3F);
        this.beakbase.addBox(-1.0F, -4.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(beakbase, 0.6981317007977318F, 0.0F, 0.0F);
    }
}
