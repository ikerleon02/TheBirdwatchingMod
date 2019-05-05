package com.ikerleon.birdwmod.client.model.europe;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * ModelStellersEiderFlying - starcook
 * Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelStellersEiderFlying extends ModelStellersEider {

    public ModelStellersEiderFlying() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.head.setRotationPoint(0.0F, 0.4F, -3.1F);
        this.head.addBox(-2.0F, -1.6F, -1.6F, 4, 3, 4, 0.0F);
        this.setRotateAngle(head, 2.777342438698576F, 0.0F, 0.0F);
        this.neck.setRotationPoint(0.0F, 5.1F, 1.3F);
        this.neck.addBox(-2.0F, -1.7F, -1.5F, 4, 4, 5, 0.0F);
        this.setRotateAngle(neck, 2.5953045977155678F, 0.0F, 0.0F);
        this.toppart.setRotationPoint(0.0F, -1.8F, 0.3F);
        this.toppart.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.beaktop2.setRotationPoint(0.0F, 0.0F, 1.6F);
        this.beaktop2.addBox(-0.5F, -0.7F, -0.6F, 1, 1, 3, 0.0F);
        this.setRotateAngle(beaktop2, -0.17453292519943295F, 0.0F, 0.0F);
        this.belly2.setRotationPoint(0.0F, -2.7F, -1.4F);
        this.belly2.addBox(-1.5F, -4.0F, -3.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(belly2, 2.96705972839036F, 0.0F, 0.0F);
        this.body.mirror = true;
        this.body.setRotationPoint(0.0F, 18.8F, 0.5F);
        this.body.addBox(-2.5F, -3.7F, -1.3F, 5, 9, 5, 0.0F);
        this.setRotateAngle(body, 1.5707963267948966F, -3.141592653589793F, 0.0F);
        this.neckback.setRotationPoint(0.0F, 1.4F, -0.9F);
        this.neckback.addBox(-1.5F, -2.0F, -4.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(neckback, -0.5235987755982988F, 0.0F, 0.0F);
        this.leftfootfinger.setRotationPoint(0.0F, 2.7F, 0.0F);
        this.leftfootfinger.addBox(-0.5F, -0.2F, -1.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(leftfootfinger, -1.7453292519943295F, 0.0F, 0.0F);
        this.leftleg.setRotationPoint(-1.3F, -2.5F, -0.3F);
        this.leftleg.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(leftleg, -3.141592653589793F, 0.0F, 0.0F);
        this.rightfootfinger2.setRotationPoint(0.2F, 2.6F, -0.5F);
        this.rightfootfinger2.addBox(-0.5F, -0.2F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rightfootfinger2, -1.5707963267948966F, 0.0F, -0.3490658503988659F);
        this.belly.setRotationPoint(0.0F, 4.4F, -2.3F);
        this.belly.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(belly, 1.5707963267948966F, 0.0F, 0.0F);
        this.tailbottom.mirror = true;
        this.tailbottom.setRotationPoint(0.0F, -3.3F, -1.4F);
        this.tailbottom.addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(tailbottom, 2.276432943376204F, 0.0F, 0.0F);
        this.rightwing.setRotationPoint(2.3F, 3.7F, 1.6F);
        this.rightwing.addBox(-0.4F, -4.5F, -2.0F, 1, 5, 4, 0.0F);
        this.setRotateAngle(rightwing, 1.5707963267948966F, -1.48352986419518F, 0.0F);
        this.rightleg.setRotationPoint(1.3F, -2.5F, -0.3F);
        this.rightleg.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rightleg, -3.141592653589793F, 0.0F, 0.0F);
        this.rightwing2.setRotationPoint(-0.1F, -4.5F, 1.0F);
        this.rightwing2.addBox(-0.4F, -5.5F, -2.8F, 1, 6, 3, 0.0F);
        this.setRotateAngle(rightwing2, -0.08726646259971647F, 0.0F, -0.08726646259971647F);
        this.beaktop1.setRotationPoint(0.0F, -0.7F, 1.7F);
        this.beaktop1.addBox(-1.0F, -0.5F, -0.4F, 2, 2, 1, 0.0F);
        this.setRotateAngle(beaktop1, 1.0471975511965976F, 0.0F, 0.0F);
        this.leftwing.setRotationPoint(-2.3F, 3.7F, 1.6F);
        this.leftwing.addBox(-0.6F, -4.5F, -2.0F, 1, 5, 4, 0.0F);
        this.setRotateAngle(leftwing, 1.5707963267948966F, 1.48352986419518F, 0.0F);
        this.headback.setRotationPoint(0.0F, 0.1F, -1.8F);
        this.headback.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(headback, -0.3490658503988659F, 0.0F, 0.0F);
        this.rightfootfinger.setRotationPoint(0.0F, 2.7F, 0.0F);
        this.rightfootfinger.addBox(-0.5F, -0.2F, -1.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(rightfootfinger, -1.7453292519943295F, 0.0F, 0.0F);
        this.tail.mirror = true;
        this.tail.setRotationPoint(0.0F, -1.2F, -1.6F);
        this.tail.addBox(-1.0F, -4.7F, 0.0F, 2, 5, 1, 0.0F);
        this.setRotateAngle(tail, -0.2617993877991494F, 0.0F, 0.0F);
        this.beakmain.setRotationPoint(0.0F, 0.3F, 2.3F);
        this.beakmain.addBox(-1.0F, -0.5F, -0.4F, 2, 1, 3, 0.0F);
        this.crest.setRotationPoint(0.0F, -1.4F, -0.8F);
        this.crest.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(crest, 1.0471975511965976F, 0.0F, 0.0F);
        this.leftfootfinger2.setRotationPoint(-0.2F, 2.6F, -0.5F);
        this.leftfootfinger2.addBox(-0.5F, -0.2F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(leftfootfinger2, -1.5707963267948966F, 0.0F, 0.3490658503988659F);
        this.neckfront.setRotationPoint(0.0F, -0.3F, -1.7F);
        this.neckfront.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(neckfront, -0.8726646259971648F, 0.0F, 0.0F);
        this.leftwing2.setRotationPoint(-0.1F, -4.5F, 1.0F);
        this.leftwing2.addBox(-0.4F, -5.5F, -2.8F, 1, 6, 3, 0.0F);
        this.setRotateAngle(leftwing2, -0.08726646259971647F, 0.0F, 0.08726646259971647F);
        this.leftfootfinger3.setRotationPoint(0.2F, 2.6F, -0.5F);
        this.leftfootfinger3.addBox(-0.5F, -0.2F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(leftfootfinger3, -1.5707963267948966F, 0.0F, -0.3490658503988659F);
        this.body2.mirror = true;
        this.body2.setRotationPoint(0.1F, -3.1F, 3.5F);
        this.body2.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(body2, 0.3490658503988659F, 0.0F, 0.0F);
        this.rightfootfinger3.setRotationPoint(-0.2F, 2.6F, -0.5F);
        this.rightfootfinger3.addBox(-0.5F, -0.2F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rightfootfinger3, -1.5707963267948966F, 0.0F, 0.3490658503988659F);
    }
}
