package com.ikerleon.birdwmod.client.model.europe;

import com.ikerleon.birdwmod.entity.europe.EntityRedNeckedNightjar;
import com.ikerleon.birdwmod.util.PosesUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.bookworm.client.animation.part.BookwormModelBase;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;

/**
 * ModelRedNeckedNightjar - ikerleon
 * Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelRedNeckedNightjar extends BookwormModelBase {
    public BookwormModelRenderer body;
    public BookwormModelRenderer leftwing;
    public BookwormModelRenderer rightwing;
    public BookwormModelRenderer body2;
    public BookwormModelRenderer necktop;
    public BookwormModelRenderer neckbottom;
    public BookwormModelRenderer leftwing2;
    public BookwormModelRenderer leftwing3;
    public BookwormModelRenderer rightwing2;
    public BookwormModelRenderer rightwing3;
    public BookwormModelRenderer body3;
    public BookwormModelRenderer tail;
    public BookwormModelRenderer tail2;
    public BookwormModelRenderer tail3;
    public BookwormModelRenderer head;
    public BookwormModelRenderer head2;
    public BookwormModelRenderer headneck;
    public BookwormModelRenderer beakbase;
    public BookwormModelRenderer beak;
    public BookwormModelRenderer beak2;
    public BookwormModelRenderer neckbottom2;

    public ModelRedNeckedNightjar() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.tail2 = new BookwormModelRenderer(this, 54, 45, "tail2");
        this.tail2.setRotationPoint(0.0F, 4.6F, -1.6F);
        this.tail2.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 15, 0.0F);
        this.setRotateAngle(tail2, 0.40142572795869574F, -0.05235987755982988F, 0.0F);
        this.rightwing = new BookwormModelRenderer(this, 90, 2, "rightwing");
        this.rightwing.setRotationPoint(-2.7F, 3.0F, 3.0F);
        this.rightwing.addBox(-1.0F, -3.0F, -2.0F, 1, 5, 7, 0.0F);
        this.body3 = new BookwormModelRenderer(this, 34, 54, "body3");
        this.body3.setRotationPoint(0.0F, 0.2F, 4.7F);
        this.body3.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(body3, -0.08726646259971647F, 0.0F, 0.0F);
        this.neckbottom = new BookwormModelRenderer(this, 34, 41, "neckbottom");
        this.neckbottom.setRotationPoint(0.0F, 4.9F, 2.1F);
        this.neckbottom.addBox(-2.5F, -5.0F, -2.0F, 5, 5, 2, 0.0F);
        this.setRotateAngle(neckbottom, 0.3839724354387525F, 0.0F, 0.0F);
        this.leftwing = new BookwormModelRenderer(this, 110, 2, "leftwing");
        this.leftwing.setRotationPoint(2.7F, 3.0F, 3.0F);
        this.leftwing.addBox(0.0F, -3.0F, -2.0F, 1, 5, 7, 0.0F);
        this.rightwing2 = new BookwormModelRenderer(this, 92, 16, "rightwing2");
        this.rightwing2.setRotationPoint(-0.2F, -2.1F, 4.7F);
        this.rightwing2.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 5, 0.0F);
        this.setRotateAngle(rightwing2, -0.03490658503988659F, 0.05235987755982988F, 0.03490658503988659F);
        this.body2 = new BookwormModelRenderer(this, 7, 52, "body2");
        this.body2.setRotationPoint(0.0F, -0.1F, 6.0F);
        this.body2.addBox(-2.4F, 0.0F, 0.0F, 5, 6, 5, 0.0F);
        this.setRotateAngle(body2, -0.2792526803190927F, 0.0F, 0.0F);
        this.necktop = new BookwormModelRenderer(this, 9, 25, "necktop");
        this.necktop.setRotationPoint(0.0F, 0.0F, 5.6F);
        this.necktop.addBox(-1.5F, 0.0F, -4.0F, 3, 4, 4, 0.0F);
        this.setRotateAngle(necktop, -0.8726646259971648F, 0.0F, 0.0F);
        this.beak2 = new BookwormModelRenderer(this, 71, 21, "beak2");
        this.beak2.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.beak2.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(beak2, 0.6373942428283291F, 0.0F, 0.0F);
        this.beakbase = new BookwormModelRenderer(this, 62, 17, "beakbase");
        this.beakbase.setRotationPoint(0.0F, 0.0F, -0.3F);
        this.beakbase.addBox(-1.0F, -4.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(beakbase, 0.5462880558742251F, 0.0F, 0.0F);
        this.headneck = new BookwormModelRenderer(this, 9, 16, "headneck");
        this.headneck.setRotationPoint(0.0F, 2.7F, 0.4F);
        this.headneck.addBox(-2.0F, -3.0F, -3.0F, 4, 4, 3, 0.0F);
        this.leftwing3 = new BookwormModelRenderer(this, 109, 27, "leftwing3");
        this.leftwing3.setRotationPoint(-0.7F, 1.7F, 4.5F);
        this.leftwing3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 8, 0.0F);
        this.setRotateAngle(leftwing3, 0.17453292519943295F, 0.0F, -0.03490658503988659F);
        this.tail3 = new BookwormModelRenderer(this, 54, 45, "tail3");
        this.tail3.setRotationPoint(0.0F, 4.6F, -1.6F);
        this.tail3.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 15, 0.0F);
        this.setRotateAngle(tail3, 0.40142572795869574F, 0.05235987755982988F, 0.0F);
        this.leftwing2 = new BookwormModelRenderer(this, 112, 16, "leftwing2");
        this.leftwing2.setRotationPoint(0.2F, -2.1F, 4.7F);
        this.leftwing2.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 5, 0.0F);
        this.setRotateAngle(leftwing2, -0.03490658503988659F, -0.05235987755982988F, -0.03490658503988659F);
        this.rightwing3 = new BookwormModelRenderer(this, 89, 27, "rightwing3");
        this.rightwing3.setRotationPoint(0.7F, 1.7F, 4.5F);
        this.rightwing3.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 8, 0.0F);
        this.setRotateAngle(rightwing3, 0.17453292519943295F, 0.0F, -0.03490658503988659F);
        this.head2 = new BookwormModelRenderer(this, 46, 17, "head2");
        this.head2.setRotationPoint(0.0F, 2.1F, -2.0F);
        this.head2.addBox(-2.0F, -3.0F, -3.0F, 4, 3, 3, 0.0F);
        this.setRotateAngle(head2, 0.17453292519943295F, 0.0F, 0.0F);
        this.beak = new BookwormModelRenderer(this, 71, 21, "beak");
        this.beak.setRotationPoint(0.0F, -3.8F, -1.0F);
        this.beak.addBox(-0.5F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(beak, -0.5918411493512771F, 0.0F, 0.0F);
        this.neckbottom2 = new BookwormModelRenderer(this, 34, 33, "neckbottom2");
        this.neckbottom2.setRotationPoint(0.0F, -3.5F, -0.5F);
        this.neckbottom2.addBox(-1.5F, -3.0F, -2.0F, 3, 3, 2, 0.0F);
        this.setRotateAngle(neckbottom2, -0.9075712110370513F, 0.0F, 0.0F);
        this.body = new BookwormModelRenderer(this, 3, 35, "body");
        this.body.setRotationPoint(0.0F, 18.9F, -6.0F);
        this.body.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 7, 0.0F);
        this.tail = new BookwormModelRenderer(this, 90, 44, "tail");
        this.tail.setRotationPoint(0.0F, 4.3F, -1.5F);
        this.tail.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 16, 0.0F);
        this.setRotateAngle(tail, 0.40142572795869574F, 0.0F, 0.0F);
        this.head = new BookwormModelRenderer(this, 25, 14, "head");
        this.head.setRotationPoint(0.0F, -0.5F, -3.5F);
        this.head.addBox(-2.5F, -1.0F, -5.0F, 5, 4, 5, 0.0F);
        this.setRotateAngle(head, 0.8726646259971648F, 0.0F, 0.0F);
        this.body3.addChild(this.tail2);
        this.body.addChild(this.rightwing);
        this.body2.addChild(this.body3);
        this.body.addChild(this.neckbottom);
        this.body.addChild(this.leftwing);
        this.rightwing.addChild(this.rightwing2);
        this.body.addChild(this.body2);
        this.body.addChild(this.necktop);
        this.beak.addChild(this.beak2);
        this.head2.addChild(this.beakbase);
        this.head.addChild(this.headneck);
        this.leftwing2.addChild(this.leftwing3);
        this.body3.addChild(this.tail3);
        this.leftwing.addChild(this.leftwing2);
        this.rightwing2.addChild(this.rightwing3);
        this.head.addChild(this.head2);
        this.beakbase.addChild(this.beak);
        this.neckbottom.addChild(this.neckbottom2);
        this.body3.addChild(this.tail);
        this.necktop.addChild(this.head);

        save();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if(this.isChild){
            float scaleFactor = 0.2F;

            GlStateManager.pushMatrix();
            GlStateManager.translate(0F, 1.5F - 1.5F * scaleFactor, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
            this.body.render(f5);
            GlStateManager.popMatrix();
        }
        else {
            float scaleFactor = 0.4F;

            GlStateManager.pushMatrix();
            GlStateManager.translate(0F, 1.5F - 1.5F * scaleFactor, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
            this.body.render(f5);
            GlStateManager.popMatrix();
        }
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        reset();
        if ((entityIn instanceof EntityRedNeckedNightjar)) {
            EntityRedNeckedNightjar nightjar = (EntityRedNeckedNightjar)entityIn;

            float globalSpeed = 1.5f;
            float globalDegree = 1.25F;

            this.body2.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
            this.head.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 1.7F * 0.5f;
            this.rightwing.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
            this.leftwing.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

            if (!nightjar.onGround && !nightjar.isInWater() && !nightjar.isChild()) {
                interpolateToPose(PosesUtil.RED_NECKED_NIGHTJAR_FLYING_POSE, nightjar.timer);

                this.rightwing.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                this.leftwing.rotateAngleX = MathHelper.cos(nightjar.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                this.rightwing.rotateAngleZ = MathHelper.cos(nightjar.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
                this.leftwing.rotateAngleZ = MathHelper.cos(nightjar.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                this.rightwing2.rotateAngleY = MathHelper.cos(nightjar.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                this.leftwing2.rotateAngleY = MathHelper.cos(nightjar.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
            }
        }
    }

    public void setRotateAngle(BookwormModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
