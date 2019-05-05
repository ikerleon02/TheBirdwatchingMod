package com.ikerleon.birdwmod.client.model.northamerica;

import com.ikerleon.birdwmod.entity.northamerica.EntityNorthernMockingbird;
import com.ikerleon.birdwmod.util.PosesUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.bookworm.client.animation.part.BookwormModelBase;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;


/**
 * ModelNorthernMockingbird - ikerleon
 * Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelNorthernMockingbird extends BookwormModelBase {
    public BookwormModelRenderer body;
    public BookwormModelRenderer rightleg;
    public BookwormModelRenderer leftleg;
    public BookwormModelRenderer belly;
    public BookwormModelRenderer bellyback;
    public BookwormModelRenderer neckbottom;
    public BookwormModelRenderer necktop;
    public BookwormModelRenderer body2;
    public BookwormModelRenderer rightwing;
    public BookwormModelRenderer rightwing_1;
    public BookwormModelRenderer rightleg2;
    public BookwormModelRenderer rightfeet;
    public BookwormModelRenderer leftleg2;
    public BookwormModelRenderer leftfeet;
    public BookwormModelRenderer neckbottom_1;
    public BookwormModelRenderer head;
    public BookwormModelRenderer beakbase;
    public BookwormModelRenderer headback;
    public BookwormModelRenderer headtop;
    public BookwormModelRenderer beak;
    public BookwormModelRenderer tail;
    public BookwormModelRenderer tailright;
    public BookwormModelRenderer tailleft;
    public BookwormModelRenderer rightwing2;
    public BookwormModelRenderer rightwing3;
    public BookwormModelRenderer rightwing2_1;
    public BookwormModelRenderer rightwing3_1;

    public ModelNorthernMockingbird() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.rightwing2_1 = new BookwormModelRenderer(this, 32, 9, "rightwing2_1");
        this.rightwing2_1.setRotationPoint(-0.5F, 0.1F, 3.5F);
        this.rightwing2_1.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(rightwing2_1, 0.17453292519943295F, -0.08726646259971647F, -0.08726646259971647F);
        this.rightwing3 = new BookwormModelRenderer(this, 98, 1, "rightwing3");
        this.rightwing3.setRotationPoint(0.2F, 0.5F, 3.0F);
        this.rightwing3.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(rightwing3, -0.12217304763960307F, 0.0F, 0.0F);
        this.leftleg2 = new BookwormModelRenderer(this, 101, 48, "leftleg2");
        this.leftleg2.setRotationPoint(0.0F, 3.7F, 0.1F);
        this.leftleg2.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(leftleg2, -0.3490658503988659F, 0.0F, 0.0F);
        this.rightwing2 = new BookwormModelRenderer(this, 88, 9, "rightwing2");
        this.rightwing2.setRotationPoint(0.5F, 0.1F, 3.5F);
        this.rightwing2.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(rightwing2, 0.17453292519943295F, 0.08726646259971647F, 0.08726646259971647F);
        this.rightfeet = new BookwormModelRenderer(this, 114, 57, "rightfeet");
        this.rightfeet.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.rightfeet.addBox(-1.0F, 0.0F, -2.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(rightfeet, 0.08726646259971647F, 0.0F, 0.0F);
        this.headback = new BookwormModelRenderer(this, 24, 41, "headback");
        this.headback.setRotationPoint(0.0F, -0.7F, 0.1F);
        this.headback.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
        this.bellyback = new BookwormModelRenderer(this, 105, 30, "bellyback");
        this.bellyback.setRotationPoint(0.0F, 1.2F, 9.6F);
        this.bellyback.addBox(-1.5F, -6.0F, -2.1F, 3, 6, 3, 0.0F);
        this.setRotateAngle(bellyback, 2.2165681500327987F, 0.0F, 0.0F);
        this.tail = new BookwormModelRenderer(this, 108, 19, "tail");
        this.tail.setRotationPoint(0.0F, 3.0F, -0.7F);
        this.tail.addBox(-1.0F, 0.0F, -0.5F, 2, 10, 1, 0.0F);
        this.setRotateAngle(tail, 0.17453292519943295F, 0.0F, 0.0F);
        this.body2 = new BookwormModelRenderer(this, 82, 30, "body2");
        this.body2.setRotationPoint(0.0F, 0.5F, 6.6F);
        this.body2.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(body2, 1.7453292519943295F, 0.0F, 0.0F);
        this.necktop = new BookwormModelRenderer(this, 36, 30, "necktop");
        this.necktop.setRotationPoint(0.0F, 0.8F, 5.0F);
        this.necktop.addBox(-1.0F, -5.0F, -3.0F, 2, 5, 3, 0.0F);
        this.setRotateAngle(necktop, 0.8726646259971648F, 0.0F, 0.0F);
        this.leftleg = new BookwormModelRenderer(this, 101, 41, "leftleg");
        this.leftleg.setRotationPoint(1.4F, 3.25F, 4.75F);
        this.leftleg.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(leftleg, 0.4363323129985824F, 0.0F, 0.0F);
        this.neckbottom_1 = new BookwormModelRenderer(this, 39, 51, "neckbottom_1");
        this.neckbottom_1.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.neckbottom_1.addBox(-1.5F, 0.0F, -0.0F, 3, 3, 3, 0.0F);
        this.setRotateAngle(neckbottom_1, 1.1344640137963142F, 0.0F, 0.0F);
        this.tailright = new BookwormModelRenderer(this, 116, 19, "tailright");
        this.tailright.setRotationPoint(-0.7F, -0.2F, -0.5F);
        this.tailright.addBox(-1.0F, 0.0F, -0.5F, 2, 9, 1, 0.0F);
        this.setRotateAngle(tailright, 0.0F, -0.4363323129985824F, 0.0F);
        this.headtop = new BookwormModelRenderer(this, 24, 57, "headtop");
        this.headtop.setRotationPoint(0.0F, -2.5F, 1.3F);
        this.headtop.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
        this.beakbase = new BookwormModelRenderer(this, 12, 51, "beakbase");
        this.beakbase.setRotationPoint(0.0F, -3.0F, 1.2F);
        this.beakbase.addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(beakbase, 0.05235987755982988F, 0.0F, 0.010297442586766544F);
        this.rightwing_1 = new BookwormModelRenderer(this, 44, 13, "rightwing_1");
        this.rightwing_1.setRotationPoint(2.5F, 2.0F, 2.5F);
        this.rightwing_1.addBox(-0.5F, -1.5F, -1.5F, 1, 5, 6, 0.0F);
        this.setRotateAngle(rightwing_1, 0.0F, 0.05235987755982988F, 0.0F);
        this.body = new BookwormModelRenderer(this, 52, 28, "body");
        this.body.setRotationPoint(0.0F, 14.5F, -4.3F);
        this.body.addBox(-2.5F, 0.0F, 0.0F, 5, 5, 8, 0.0F);
        this.setRotateAngle(body, -0.18203784098300857F, 0.0F, 0.0F);
        this.rightleg = new BookwormModelRenderer(this, 117, 41, "rightleg");
        this.rightleg.setRotationPoint(-1.4F, 3.25F, 4.75F);
        this.rightleg.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(rightleg, 0.4363323129985824F, 0.0F, 0.0F);
        this.rightleg2 = new BookwormModelRenderer(this, 117, 48, "rightleg2");
        this.rightleg2.setRotationPoint(0.0F, 3.7F, 0.1F);
        this.rightleg2.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rightleg2, -0.3490658503988659F, 0.0F, 0.0F);
        this.rightwing3_1 = new BookwormModelRenderer(this, 18, 1, "rightwing3_1");
        this.rightwing3_1.setRotationPoint(-0.2F, 0.5F, 3.0F);
        this.rightwing3_1.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 4, 0.0F);
        this.setRotateAngle(rightwing3_1, -0.12217304763960307F, 0.0F, 0.0F);
        this.beak = new BookwormModelRenderer(this, 4, 51, "beak");
        this.beak.setRotationPoint(0.0F, 1.9F, -0.6F);
        this.beak.addBox(-0.5F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(beak, -0.17453292519943295F, 0.0F, 0.0F);
        this.neckbottom = new BookwormModelRenderer(this, 54, 50, "neckbottom");
        this.neckbottom.setRotationPoint(0.0F, 3.8F, 0.1F);
        this.neckbottom.addBox(-2.0F, -3.0F, -0.0F, 4, 3, 3, 0.0F);
        this.setRotateAngle(neckbottom, 0.3490658503988659F, 0.0F, 0.0F);
        this.tailleft = new BookwormModelRenderer(this, 100, 19, "tailleft");
        this.tailleft.setRotationPoint(0.7F, -0.2F, -0.5F);
        this.tailleft.addBox(-1.0F, 0.0F, -0.5F, 2, 9, 1, 0.0F);
        this.setRotateAngle(tailleft, 0.0F, 0.4363323129985824F, 0.0F);
        this.belly = new BookwormModelRenderer(this, 74, 49, "belly");
        this.belly.setRotationPoint(0.0F, 3.0F, 0.6F);
        this.belly.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 2, 0.0F);
        this.setRotateAngle(belly, 1.3089969389957472F, 0.0F, 0.0F);
        this.leftfeet = new BookwormModelRenderer(this, 98, 57, "leftfeet");
        this.leftfeet.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.leftfeet.addBox(-1.0F, 0.0F, -2.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(leftfeet, 0.08726646259971647F, 0.0F, 0.0F);
        this.head = new BookwormModelRenderer(this, 22, 48, "head");
        this.head.setRotationPoint(0.0F, 2.0F, 2.2F);
        this.head.addBox(-2.0F, -3.0F, 0.0F, 4, 4, 3, 0.0F);
        this.setRotateAngle(head, 0.2617993877991494F, 0.0F, 0.0F);
        this.rightwing = new BookwormModelRenderer(this, 72, 13, "rightwing");
        this.rightwing.setRotationPoint(-2.5F, 2.0F, 2.5F);
        this.rightwing.addBox(-0.5F, -1.5F, -1.5F, 1, 5, 6, 0.0F);
        this.setRotateAngle(rightwing, 0.0F, -0.05235987755982988F, 0.0F);
        this.rightwing_1.addChild(this.rightwing2_1);
        this.rightwing2.addChild(this.rightwing3);
        this.leftleg.addChild(this.leftleg2);
        this.rightwing.addChild(this.rightwing2);
        this.rightleg2.addChild(this.rightfeet);
        this.head.addChild(this.headback);
        this.body.addChild(this.bellyback);
        this.body2.addChild(this.tail);
        this.body.addChild(this.body2);
        this.body.addChild(this.necktop);
        this.body.addChild(this.leftleg);
        this.neckbottom.addChild(this.neckbottom_1);
        this.tail.addChild(this.tailright);
        this.head.addChild(this.headtop);
        this.head.addChild(this.beakbase);
        this.body.addChild(this.rightwing_1);
        this.body.addChild(this.rightleg);
        this.rightleg.addChild(this.rightleg2);
        this.rightwing2_1.addChild(this.rightwing3_1);
        this.beakbase.addChild(this.beak);
        this.body.addChild(this.neckbottom);
        this.tail.addChild(this.tailleft);
        this.body.addChild(this.belly);
        this.leftleg2.addChild(this.leftfeet);
        this.neckbottom_1.addChild(this.head);
        this.body.addChild(this.rightwing);

        save();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if(this.isChild){
            float scaleFactor= 0.25F;

            GlStateManager.pushMatrix();
            GlStateManager.translate(0F, 1.475F-1.475F*scaleFactor, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
            this.body.render(f5);
            GlStateManager.popMatrix();
        }
        else {
            float scaleFactor = 0.5F;

            GlStateManager.pushMatrix();
            GlStateManager.translate(0F, 1.45F - 1.45F * scaleFactor, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
            this.body.render(f5);
            GlStateManager.popMatrix();
        }
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        reset();
        if ((entityIn instanceof EntityNorthernMockingbird)) {
            EntityNorthernMockingbird mockingbird = (EntityNorthernMockingbird)entityIn;

            float globalSpeed = 1.5f;
            float globalDegree = 1.25F;

            this.rightleg.rotateAngleX += MathHelper.cos(limbSwing * 0.5f * globalSpeed + 0) * 0.5f * globalDegree * 1 * limbSwingAmount + 0.2f * limbSwingAmount;
            this.leftleg.rotateAngleX += MathHelper.cos(limbSwing * 0.5f * globalSpeed + 0) * 0.5f * globalDegree * -1 * limbSwingAmount + 0.2f * limbSwingAmount;
            this.necktop.rotateAngleX += MathHelper.cos(limbSwing * 0.8f * globalSpeed + 2.5F) * 0.05f * globalDegree * -1 * limbSwingAmount + 0 * limbSwingAmount;
            this.body2.rotateAngleX += MathHelper.cos(limbSwing * 0.8f * globalSpeed + 2.5F) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * limbSwingAmount;

            this.body2.rotateAngleX += MathHelper.cos(mockingbird.ticksExisted * 0.17f + 2.5F) * 0.05F * 1 * 0.5f + 0 * 0.5f;
            this.head.rotateAngleX += MathHelper.cos(mockingbird.ticksExisted * 0.2f + 2.5F) * 0.06F * 1 * 0.5f + 0 * 0.5f;
            this.rightwing.rotateAngleX += MathHelper.cos(mockingbird.ticksExisted * 0.17f + 2.5F) * 0.03F * -1 * 0.5f + 0 * 0.5f;
            this.rightwing_1.rotateAngleX += MathHelper.cos(mockingbird.ticksExisted * 0.17f + 2.5F) * 0.03F * -1 * 0.5f + 0 * 0.5f;

            if (!mockingbird.onGround && !mockingbird.isInWater() && !mockingbird.isChild()) {
                interpolateToPose(PosesUtil.NORTHERN_MOCKINGBIRD_FLYING_POSE, mockingbird.timer);

                this.rightwing.rotateAngleX += MathHelper.cos(mockingbird.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                this.rightwing_1.rotateAngleX += MathHelper.cos(mockingbird.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                this.rightwing.rotateAngleZ += MathHelper.cos(mockingbird.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                this.rightwing_1.rotateAngleZ += MathHelper.cos(mockingbird.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                this.rightwing2.rotateAngleY += MathHelper.cos(mockingbird.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                this.rightwing2_1.rotateAngleY += MathHelper.cos(mockingbird.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
            }
        }
    }

    public void setRotateAngle(BookwormModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
