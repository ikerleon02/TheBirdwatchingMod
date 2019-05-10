package com.ikerleon.birdwmod.client.model.northamerica;

import com.ikerleon.birdwmod.entity.northamerica.EntityGreenHeron;
import com.ikerleon.birdwmod.util.PosesUtil;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.bookworm.client.animation.part.BookwormModelBase;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;

/**
 * ModelGreenHeron - Undefined
 * Created using Tabula 7.0.0
 */

@SideOnly(Side.CLIENT)
public class ModelGreenHeron extends BookwormModelBase {
    public BookwormModelRenderer Body;
    public BookwormModelRenderer Tailtop;
    public BookwormModelRenderer WingL;
    public BookwormModelRenderer WingR;
    public BookwormModelRenderer Neck;
    public BookwormModelRenderer ThighR;
    public BookwormModelRenderer ThighL;
    public BookwormModelRenderer belly;
    public BookwormModelRenderer belly2;
    public BookwormModelRenderer Tailmid;
    public BookwormModelRenderer Tailbottom;
    public BookwormModelRenderer Wing2L;
    public BookwormModelRenderer Wing3L;
    public BookwormModelRenderer Wing4L;
    public BookwormModelRenderer Wing2R;
    public BookwormModelRenderer Wing3R;
    public BookwormModelRenderer Wing4R;
    public BookwormModelRenderer Neck2;
    public BookwormModelRenderer Throat;
    public BookwormModelRenderer Head;
    public BookwormModelRenderer Beaktop;
    public BookwormModelRenderer Jaw;
    public BookwormModelRenderer headtop;
    public BookwormModelRenderer Beakjoint;
    public BookwormModelRenderer CalfR;
    public BookwormModelRenderer FootL;
    public BookwormModelRenderer FootL_1;
    public BookwormModelRenderer FootL_2;
    public BookwormModelRenderer CalfL;
    public BookwormModelRenderer FootL_3;
    public BookwormModelRenderer FootL_4;
    public BookwormModelRenderer FootL_5;

    public ModelGreenHeron() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.WingR = new BookwormModelRenderer(this, 28, 1, "WingR");
        this.WingR.setRotationPoint(-2.0F, 0.3F, 0.5F);
        this.WingR.addBox(-1.0F, -2.0F, -2.0F, 1, 5, 5, 0.0F);
        this.headtop = new BookwormModelRenderer(this, 61, 43, "headtop");
        this.headtop.setRotationPoint(0.0F, -1.2F, 1.3F);
        this.headtop.addBox(-1.5F, -1.5F, -0.5F, 3, 3, 1, 0.0F);
        this.Wing4R = new BookwormModelRenderer(this, 30, 32, "Wing4R");
        this.Wing4R.setRotationPoint(0.1F, -0.2F, 3.3F);
        this.Wing4R.addBox(-0.5F, -1.0F, 0.0F, 1, 3, 3, 0.0F);
        this.setRotateAngle(Wing4R, -0.17453292519943295F, 0.0F, 0.0F);
        this.Beakjoint = new BookwormModelRenderer(this, 48, 52, "Beakjoint");
        this.Beakjoint.setRotationPoint(0.0F, -2.8F, 1.4F);
        this.Beakjoint.addBox(-1.0F, -2.0F, -2.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(Beakjoint, 0.8651597102135892F, 0.0F, 0.0F);
        this.FootL_5 = new BookwormModelRenderer(this, 95, 55, "FootL_5");
        this.FootL_5.setRotationPoint(0.0F, 2.7F, 0.2F);
        this.FootL_5.addBox(-0.5F, -0.0F, -2.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(FootL_5, 0.2617993877991494F, 0.5235987755982988F, 0.15707963267948966F);
        this.Body = new BookwormModelRenderer(this, 52, 10, "Body");
        this.Body.setRotationPoint(0.0F, 14.2F, 0.6F);
        this.Body.addBox(-2.5F, -2.5F, -2.8F, 5, 6, 8, 0.0F);
        this.setRotateAngle(Body, -0.8290313946973066F, 0.0F, 0.0F);
        this.ThighR = new BookwormModelRenderer(this, 113, 39, "ThighR");
        this.ThighR.setRotationPoint(-1.7F, 2.0F, 2.8F);
        this.ThighR.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(ThighR, 0.9599310885968813F, 0.0F, 0.0F);
        this.FootL = new BookwormModelRenderer(this, 111, 54, "FootL");
        this.FootL.setRotationPoint(0.0F, 2.8F, 0.2F);
        this.FootL.addBox(-0.5F, -0.0F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(FootL, 0.17453292519943295F, 0.0F, 0.0F);
        this.belly = new BookwormModelRenderer(this, 7, 40, "belly");
        this.belly.setRotationPoint(0.0F, 3.4F, -4.3F);
        this.belly.addBox(-2.0F, -2.0F, 0.0F, 4, 2, 5, 0.0F);
        this.setRotateAngle(belly, -0.4553564018453205F, 0.0F, 0.0F);
        this.Wing4L = new BookwormModelRenderer(this, 9, 32, "Wing4L");
        this.Wing4L.setRotationPoint(-0.1F, -0.2F, 3.3F);
        this.Wing4L.addBox(-0.5F, -1.0F, 0.0F, 1, 3, 3, 0.0F);
        this.setRotateAngle(Wing4L, -0.17453292519943295F, 0.0F, 0.0F);
        this.WingL = new BookwormModelRenderer(this, 7, 1, "WingL");
        this.WingL.setRotationPoint(2.0F, 0.3F, 0.5F);
        this.WingL.addBox(0.0F, -2.0F, -2.0F, 1, 5, 5, 0.0F);
        this.Tailmid = new BookwormModelRenderer(this, 97, 23, "Tailmid");
        this.Tailmid.setRotationPoint(0.0F, 1.45F, 0.41F);
        this.Tailmid.addBox(-1.5F, -0.5F, 0.0F, 3, 1, 2, 0.0F);
        this.FootL_4 = new BookwormModelRenderer(this, 77, 55, "FootL_4");
        this.FootL_4.setRotationPoint(0.0F, 2.7F, 0.2F);
        this.FootL_4.addBox(-0.5F, -0.0F, -2.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(FootL_4, 0.2617993877991494F, -0.5235987755982988F, -0.15707963267948966F);
        this.ThighL = new BookwormModelRenderer(this, 87, 39, "ThighL");
        this.ThighL.setRotationPoint(1.7F, 2.0F, 2.8F);
        this.ThighL.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(ThighL, 0.9599310885968813F, 0.0F, 0.0F);
        this.Tailtop = new BookwormModelRenderer(this, 93, 10, "Tailtop");
        this.Tailtop.setRotationPoint(0.0F, -1.94F, 4.16F);
        this.Tailtop.addBox(-2.0F, -0.5F, 0.0F, 4, 2, 5, 0.0F);
        this.setRotateAngle(Tailtop, -0.4363323129985824F, 0.0F, 0.0F);
        this.Throat = new BookwormModelRenderer(this, 28, 41, "Throat");
        this.Throat.setRotationPoint(0.0F, 1.5F, 1.3F);
        this.Throat.addBox(-1.5F, -3.0F, -2.0F, 3, 3, 2, 0.0F);
        this.setRotateAngle(Throat, 0.2617993877991494F, -0.003490658503988659F, 0.0F);
        this.belly2 = new BookwormModelRenderer(this, 7, 50, "belly2");
        this.belly2.setRotationPoint(0.0F, 5.1F, 0.0F);
        this.belly2.addBox(-1.5F, -2.0F, 0.0F, 3, 2, 6, 0.0F);
        this.setRotateAngle(belly2, 0.22689280275926282F, 0.0F, 0.0F);
        this.FootL_3 = new BookwormModelRenderer(this, 85, 54, "FootL_3");
        this.FootL_3.setRotationPoint(0.0F, 2.8F, 0.2F);
        this.FootL_3.addBox(-0.5F, -0.0F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(FootL_3, 0.17453292519943295F, 0.0F, 0.0F);
        this.Head = new BookwormModelRenderer(this, 58, 49, "Head");
        this.Head.setRotationPoint(0.0F, -0.1F, -0.9F);
        this.Head.addBox(-2.0F, -3.0F, -1.5F, 4, 4, 3, 0.0F);
        this.setRotateAngle(Head, 2.443460952792061F, 0.0F, 0.0F);
        this.Wing2R = new BookwormModelRenderer(this, 28, 12, "Wing2R");
        this.Wing2R.setRotationPoint(0.1F, -0.5F, 0.0F);
        this.Wing2R.addBox(-1.0F, -2.0F, 0.0F, 1, 5, 5, 0.0F);
        this.setRotateAngle(Wing2R, 0.03490658503988659F, 0.0F, 0.0F);
        this.Neck = new BookwormModelRenderer(this, 56, 26, "Neck");
        this.Neck.setRotationPoint(0.0F, 1.9F, -2.8F);
        this.Neck.addBox(-2.0F, -2.5F, -4.0F, 4, 3, 5, 0.0F);
        this.setRotateAngle(Neck, -1.3962634015954636F, 0.0F, 0.0F);
        this.Tailbottom = new BookwormModelRenderer(this, 95, 30, "Tailbottom");
        this.Tailbottom.setRotationPoint(0.0F, 3.96F, 1.63F);
        this.Tailbottom.addBox(-1.5F, -1.5F, 0.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(Tailbottom, 0.7853981633974483F, 0.0F, 0.0F);
        this.Jaw = new BookwormModelRenderer(this, 42, 52, "Jaw");
        this.Jaw.setRotationPoint(0.0F, -2.2F, -0.3F);
        this.Jaw.addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
        this.CalfR = new BookwormModelRenderer(this, 113, 45, "CalfR");
        this.CalfR.setRotationPoint(0.0F, 2.8F, 0.0F);
        this.CalfR.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(CalfR, -0.30543261909900765F, 0.0F, 0.0F);
        this.FootL_2 = new BookwormModelRenderer(this, 121, 55, "FootL_2");
        this.FootL_2.setRotationPoint(0.0F, 2.7F, 0.2F);
        this.FootL_2.addBox(-0.5F, -0.0F, -2.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(FootL_2, 0.2617993877991494F, 0.5235987755982988F, 0.15707963267948966F);
        this.FootL_1 = new BookwormModelRenderer(this, 103, 55, "FootL_1");
        this.FootL_1.setRotationPoint(0.0F, 2.7F, 0.2F);
        this.FootL_1.addBox(-0.5F, -0.0F, -2.5F, 1, 1, 2, 0.0F);
        this.setRotateAngle(FootL_1, 0.2617993877991494F, -0.5235987755982988F, -0.15707963267948966F);
        this.Beaktop = new BookwormModelRenderer(this, 42, 45, "Beaktop");
        this.Beaktop.setRotationPoint(0.0F, -2.7F, 0.0F);
        this.Beaktop.addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
        this.setRotateAngle(Beaktop, 0.06981317007977318F, 0.0F, 0.0F);
        this.Wing2L = new BookwormModelRenderer(this, 7, 12, "Wing2L");
        this.Wing2L.setRotationPoint(-0.1F, -0.5F, 0.0F);
        this.Wing2L.addBox(0.0F, -2.0F, 0.0F, 1, 5, 5, 0.0F);
        this.setRotateAngle(Wing2L, 0.03490658503988659F, 0.0F, 0.0F);
        this.CalfL = new BookwormModelRenderer(this, 87, 45, "CalfL");
        this.CalfL.setRotationPoint(0.0F, 2.8F, 0.0F);
        this.CalfL.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(CalfL, -0.30543261909900765F, 0.0F, 0.0F);
        this.Wing3R = new BookwormModelRenderer(this, 29, 23, "Wing3R");
        this.Wing3R.setRotationPoint(-0.3F, 0.3F, 3.0F);
        this.Wing3R.addBox(-0.5F, -1.5F, 0.0F, 1, 4, 4, 0.0F);
        this.setRotateAngle(Wing3R, 0.08726646259971647F, 0.0F, 0.0F);
        this.Wing3L = new BookwormModelRenderer(this, 8, 23, "Wing3L");
        this.Wing3L.setRotationPoint(0.3F, 0.3F, 3.0F);
        this.Wing3L.addBox(-0.5F, -1.5F, 0.0F, 1, 4, 4, 0.0F);
        this.setRotateAngle(Wing3L, 0.08726646259971647F, 0.0F, 0.0F);
        this.Neck2 = new BookwormModelRenderer(this, 60, 36, "Neck2");
        this.Neck2.setRotationPoint(0.0F, 0.9F, -2.2F);
        this.Neck2.addBox(-1.5F, -1.5F, -1.0F, 3, 3, 2, 0.0F);
        this.setRotateAngle(Neck2, 1.3962634015954636F, 0.0F, 0.0F);
        this.Body.addChild(this.WingR);
        this.Head.addChild(this.headtop);
        this.Wing3R.addChild(this.Wing4R);
        this.Head.addChild(this.Beakjoint);
        this.CalfL.addChild(this.FootL_5);
        this.Body.addChild(this.ThighR);
        this.CalfR.addChild(this.FootL);
        this.Body.addChild(this.belly);
        this.Wing3L.addChild(this.Wing4L);
        this.Body.addChild(this.WingL);
        this.Tailtop.addChild(this.Tailmid);
        this.CalfL.addChild(this.FootL_4);
        this.Body.addChild(this.ThighL);
        this.Body.addChild(this.Tailtop);
        this.Neck.addChild(this.Throat);
        this.Body.addChild(this.belly2);
        this.CalfL.addChild(this.FootL_3);
        this.Neck2.addChild(this.Head);
        this.WingR.addChild(this.Wing2R);
        this.Body.addChild(this.Neck);
        this.Tailtop.addChild(this.Tailbottom);
        this.Head.addChild(this.Jaw);
        this.ThighR.addChild(this.CalfR);
        this.CalfR.addChild(this.FootL_2);
        this.CalfR.addChild(this.FootL_1);
        this.Head.addChild(this.Beaktop);
        this.WingL.addChild(this.Wing2L);
        this.ThighL.addChild(this.CalfL);
        this.Wing2R.addChild(this.Wing3R);
        this.Wing2L.addChild(this.Wing3L);
        this.Neck.addChild(this.Neck2);

        save();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if(this.isChild){
            float scaleFactor= 0.35F;

            GlStateManager.pushMatrix();
            GlStateManager.translate(0F, 1.5F-1.5F*scaleFactor, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
            this.Body.render(f5);
            GlStateManager.popMatrix();
        }
        else {
            float scaleFactor = 0.7F;

            GlStateManager.pushMatrix();
            GlStateManager.translate(0F, 1.5F - 1.5F * scaleFactor, 0F);
            GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
            this.Body.render(f5);
            GlStateManager.popMatrix();
        }
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        reset();
        if ((entityIn instanceof EntityGreenHeron)) {
            EntityGreenHeron heron = (EntityGreenHeron)entityIn;

            float globalSpeed = 1.5f;
            float globalDegree = 1.25F;

            this.ThighR.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount + 1.85f * 0.5f;
            this.ThighL.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount + 1.85f * 0.5f;
            this.Neck.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount - 2.75F * 0.5f;
            this.Tailtop.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

            this.Tailtop.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f - 0.25F * 0.5f;
            this.Head.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 4.85F * 0.5f;
            this.WingR.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
            this.WingL.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

            if (!heron.onGround && !heron.isInWater() && !heron.isChild()) {
                interpolateToPose(PosesUtil.HERON_FLYING_POSE, heron.timer);

                this.WingR.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                this.WingL.rotateAngleX = MathHelper.cos(heron.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f - 2.5F * 0.5f;
                this.WingR.rotateAngleZ = MathHelper.cos(heron.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 3F * 0.5f;
                this.WingL.rotateAngleZ = MathHelper.cos(heron.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f - 3F * 0.5f;
                this.Wing2R.rotateAngleY = MathHelper.cos(heron.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                this.Wing2L.rotateAngleY = MathHelper.cos(heron.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
            }
            heron.animator.updateModel(this);
        }
    }

    public void setRotateAngle(BookwormModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
