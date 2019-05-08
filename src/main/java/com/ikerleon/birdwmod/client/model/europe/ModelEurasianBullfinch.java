package com.ikerleon.birdwmod.client.model.europe;

import com.ikerleon.birdwmod.entity.europe.EntityEurasianBullfinch;
import com.ikerleon.birdwmod.util.PosesUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.bookworm.client.animation.part.BookwormModelBase;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;

/**
 * ModelEurasianBullfinch - ikerleon02
 * Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelEurasianBullfinch extends BookwormModelBase {
    public BookwormModelRenderer body;
    public BookwormModelRenderer leftleg;
    public BookwormModelRenderer rightleg;
    public BookwormModelRenderer belly2;
    public BookwormModelRenderer belly3;
    public BookwormModelRenderer belly;
    public BookwormModelRenderer body2;
    public BookwormModelRenderer shape13;
    public BookwormModelRenderer rightwing;
    public BookwormModelRenderer rightwing_1;
    public BookwormModelRenderer leftfoot;
    public BookwormModelRenderer rightfoot;
    public BookwormModelRenderer neckfront;
    public BookwormModelRenderer tailmiddle;
    public BookwormModelRenderer tailright;
    public BookwormModelRenderer tailleft;
    public BookwormModelRenderer head;
    public BookwormModelRenderer headtop4;
    public BookwormModelRenderer headfront;
    public BookwormModelRenderer beak;
    public BookwormModelRenderer beakbase;
    public BookwormModelRenderer rightwing2;
    public BookwormModelRenderer rightwing3;
    public BookwormModelRenderer rightwing2_1;
    public BookwormModelRenderer rightwing3_1;

    public ModelEurasianBullfinch() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.rightfoot = new BookwormModelRenderer(this, 116, 58, "rightfoot");
        this.rightfoot.setRotationPoint(0.0F, 4.4F, -0.6F);
        this.rightfoot.addBox(-1.0F, 0.0F, -2.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(rightfoot, 0.17453292519943295F, 0.0F, 0.0F);
        this.belly2 = new BookwormModelRenderer(this, 85, 37, "belly2");
        this.belly2.setRotationPoint(0.0F, 5.0F, 0.1F);
        this.belly2.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 3, 0.0F);
        this.setRotateAngle(belly2, 1.0471975511965976F, 0.0F, 0.0F);
        this.headtop4 = new BookwormModelRenderer(this, 33, 29, "headtop4");
        this.headtop4.setRotationPoint(0.0F, -3.3F, -2.0F);
        this.headtop4.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.body2 = new BookwormModelRenderer(this, 105, 24, "body2");
        this.body2.setRotationPoint(0.0F, 1.1F, 5.3F);
        this.body2.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 5, 0.0F);
        this.setRotateAngle(body2, -0.17453292519943295F, 0.0F, 0.0F);
        this.tailleft = new BookwormModelRenderer(this, 70, 15, "tailleft");
        this.tailleft.setRotationPoint(0.4F, 0.4F, 4.5F);
        this.tailleft.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
        this.setRotateAngle(tailleft, 0.08726646259971647F, 0.08726646259971647F, 0.17453292519943295F);
        this.body = new BookwormModelRenderer(this, 94, 2, "body");
        this.body.setRotationPoint(0.0F, 13.6F, -3.0F);
        this.body.addBox(-2.5F, 1.0F, 0.0F, 5, 4, 6, 0.0F);
        this.setRotateAngle(body, -0.5235987755982988F, 0.0F, 0.0F);
        this.rightwing = new BookwormModelRenderer(this, 8, 2, "rightwing");
        this.rightwing.setRotationPoint(-2.0F, 2.9F, 3.1F);
        this.rightwing.addBox(-1.0F, -1.5F, -1.5F, 1, 4, 6, 0.0F);
        this.neckfront = new BookwormModelRenderer(this, 50, 39, "neckfront");
        this.neckfront.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.neckfront.addBox(-1.5F, -2.0F, -3.0F, 3, 2, 3, 0.0F);
        this.setRotateAngle(neckfront, 0.8726646259971648F, 0.0F, 0.0F);
        this.tailmiddle = new BookwormModelRenderer(this, 92, 15, "tailmiddle");
        this.tailmiddle.setRotationPoint(0.0F, 0.3F, 4.5F);
        this.tailmiddle.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
        this.setRotateAngle(tailmiddle, 0.08726646259971647F, 0.0F, 0.0F);
        this.tailright = new BookwormModelRenderer(this, 112, 15, "tailright");
        this.tailright.setRotationPoint(-0.4F, 0.4F, 4.5F);
        this.tailright.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
        this.setRotateAngle(tailright, 0.08726646259971647F, -0.08726646259971647F, -0.17453292519943295F);
        this.rightwing2_1 = new BookwormModelRenderer(this, 26, 17, "rightwing2_1");
        this.rightwing2_1.setRotationPoint(-0.1F, -0.9F, 3.5F);
        this.rightwing2_1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(rightwing2_1, -0.08726646259971647F, -0.08726646259971647F, 0.0F);
        this.head = new BookwormModelRenderer(this, 31, 37, "head");
        this.head.setRotationPoint(0.0F, 1.2F, -6.3F);
        this.head.addBox(-2.0F, -3.0F, -4.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(head, 0.8726646259971648F, 0.0F, 0.0F);
        this.belly = new BookwormModelRenderer(this, 66, 39, "belly");
        this.belly.setRotationPoint(0.0F, 4.9F, 0.0F);
        this.belly.addBox(-2.0F, 0.0F, -3.0F, 4, 2, 3, 0.0F);
        this.setRotateAngle(belly, -2.443460952792061F, 0.0F, 0.0F);
        this.headfront = new BookwormModelRenderer(this, 20, 41, "headfront");
        this.headfront.setRotationPoint(0.0F, -0.5F, -4.3F);
        this.headfront.addBox(-1.5F, -2.0F, 0.0F, 3, 2, 1, 0.0F);
        this.leftleg = new BookwormModelRenderer(this, 105, 49, "leftleg");
        this.leftleg.setRotationPoint(1.4F, 2.7F, 5.7F);
        this.leftleg.addBox(-0.5F, 0.0F, -1.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(leftleg, 0.3490658503988659F, 0.0F, 0.0F);
        this.belly3 = new BookwormModelRenderer(this, 108, 37, "belly3");
        this.belly3.setRotationPoint(0.0F, 4.9F, 8.7F);
        this.belly3.addBox(-1.5F, 0.0F, -3.0F, 3, 5, 3, 0.0F);
        this.setRotateAngle(belly3, -1.0471975511965976F, 0.0F, 0.0F);
        this.rightwing3_1 = new BookwormModelRenderer(this, 41, 19, "rightwing3_1");
        this.rightwing3_1.setRotationPoint(-0.1F, 0.6F, 3.5F);
        this.rightwing3_1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(rightwing3_1, 0.08726646259971647F, 0.0F, 0.0F);
        this.rightwing2 = new BookwormModelRenderer(this, 26, 5, "rightwing2");
        this.rightwing2.setRotationPoint(-0.9F, -0.9F, 3.5F);
        this.rightwing2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(rightwing2, -0.08726646259971647F, 0.08726646259971647F, 0.0F);
        this.rightleg = new BookwormModelRenderer(this, 119, 49, "rightleg");
        this.rightleg.setRotationPoint(-1.4F, 2.7F, 5.7F);
        this.rightleg.addBox(-0.5F, 0.0F, -1.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(rightleg, 0.3490658503988659F, 0.0F, 0.0F);
        this.shape13 = new BookwormModelRenderer(this, 77, 20, "shape13");
        this.shape13.setRotationPoint(0.0F, 1.7F, 8.2F);
        this.shape13.addBox(-1.5F, 0.0F, -8.0F, 3, 3, 8, 0.0F);
        this.setRotateAngle(shape13, -0.3490658503988659F, 0.0F, 0.0F);
        this.rightwing3 = new BookwormModelRenderer(this, 41, 7, "rightwing3");
        this.rightwing3.setRotationPoint(0.1F, 0.6F, 3.5F);
        this.rightwing3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 3, 0.0F);
        this.setRotateAngle(rightwing3, 0.08726646259971647F, 0.0F, 0.0F);
        this.beakbase = new BookwormModelRenderer(this, 9, 41, "beakbase");
        this.beakbase.setRotationPoint(0.0F, -0.4F, -0.1F);
        this.beakbase.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(beakbase, -0.17453292519943295F, 0.0F, 0.0F);
        this.beak = new BookwormModelRenderer(this, 9, 41, "beak");
        this.beak.setRotationPoint(0.0F, -1.3F, 0.8F);
        this.beak.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(beak, 0.3490658503988659F, 0.0F, 0.0F);
        this.leftfoot = new BookwormModelRenderer(this, 102, 58, "leftfoot");
        this.leftfoot.setRotationPoint(0.0F, 4.4F, -0.6F);
        this.leftfoot.addBox(-1.0F, 0.0F, -2.5F, 2, 1, 3, 0.0F);
        this.setRotateAngle(leftfoot, 0.17453292519943295F, 0.0F, 0.0F);
        this.rightwing_1 = new BookwormModelRenderer(this, 8, 14, "rightwing_1");
        this.rightwing_1.setRotationPoint(2.0F, 2.9F, 3.1F);
        this.rightwing_1.addBox(0.0F, -1.5F, -1.5F, 1, 4, 6, 0.0F);
        this.rightleg.addChild(this.rightfoot);
        this.body.addChild(this.belly2);
        this.head.addChild(this.headtop4);
        this.body.addChild(this.body2);
        this.body2.addChild(this.tailleft);
        this.body.addChild(this.rightwing);
        this.belly.addChild(this.neckfront);
        this.body2.addChild(this.tailmiddle);
        this.body2.addChild(this.tailright);
        this.rightwing_1.addChild(this.rightwing2_1);
        this.shape13.addChild(this.head);
        this.body.addChild(this.belly);
        this.head.addChild(this.headfront);
        this.body.addChild(this.leftleg);
        this.body.addChild(this.belly3);
        this.rightwing2_1.addChild(this.rightwing3_1);
        this.rightwing.addChild(this.rightwing2);
        this.body.addChild(this.rightleg);
        this.body.addChild(this.shape13);
        this.rightwing2.addChild(this.rightwing3);
        this.headfront.addChild(this.beakbase);
        this.headfront.addChild(this.beak);
        this.leftleg.addChild(this.leftfoot);
        this.body.addChild(this.rightwing_1);

        save();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if(this.isChild){
            float scaleFactor= 0.25F;

            GlStateManager.pushMatrix();
            GlStateManager.translate(0F, 1.5F-1.5F*scaleFactor, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
            this.body.render(f5);
            GlStateManager.popMatrix();
        }
        else {
            float scaleFactor = 0.5F;

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
        if ((entityIn instanceof EntityEurasianBullfinch)) {
            EntityEurasianBullfinch bullfinch = (EntityEurasianBullfinch)entityIn;

            float globalSpeed = 1.5f;
            float globalDegree = 1.25F;

            this.rightleg.rotateAngleX += MathHelper.cos(limbSwing * 0.5f * globalSpeed + 0) * 0.5f * globalDegree * 1 * limbSwingAmount + 0.2f * limbSwingAmount;
            this.leftleg.rotateAngleX += MathHelper.cos(limbSwing * 0.5f * globalSpeed + 0) * 0.5f * globalDegree * -1 * limbSwingAmount + 0.2f * limbSwingAmount;
            this.head.rotateAngleX += MathHelper.cos(limbSwing * 0.8f * globalSpeed + 2.5F) * 0.05f * globalDegree * -1 * limbSwingAmount + 0 * limbSwingAmount;
            this.body2.rotateAngleX += MathHelper.cos(limbSwing * 0.8f * globalSpeed + 2.5F) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * limbSwingAmount;

            this.body2.rotateAngleX += MathHelper.cos(bullfinch.ticksExisted * 0.17f + 2.5F) * 0.05F * 1 * 0.5f + 0 * 0.5f;
            this.head.rotateAngleX += MathHelper.cos(bullfinch.ticksExisted * 0.2f + 2.5F) * 0.06F * 1 * 0.5f + 0 * 0.5f;
            this.rightwing.rotateAngleX += MathHelper.cos(bullfinch.ticksExisted * 0.17f + 2.5F) * 0.03F * -1 * 0.5f + 0 * 0.5f;
            this.rightwing_1.rotateAngleX += MathHelper.cos(bullfinch.ticksExisted * 0.17f + 2.5F) * 0.03F * -1 * 0.5f + 0 * 0.5f;

            if (!bullfinch.onGround && !bullfinch.isInWater() && !bullfinch.isChild()) {
                interpolateToPose(PosesUtil.EURASIAN_BULLFINCH_FLYING_POSE, bullfinch.timer);

                this.rightwing.rotateAngleX += MathHelper.cos(bullfinch.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                this.rightwing_1.rotateAngleX += MathHelper.cos(bullfinch.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                this.rightwing.rotateAngleZ += MathHelper.cos(bullfinch.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
                this.rightwing_1.rotateAngleZ += MathHelper.cos(bullfinch.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                this.rightwing2.rotateAngleY += MathHelper.cos(bullfinch.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                this.rightwing2_1.rotateAngleY += MathHelper.cos(bullfinch.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
            }
        }
    }

    public void setRotateAngle(BookwormModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
