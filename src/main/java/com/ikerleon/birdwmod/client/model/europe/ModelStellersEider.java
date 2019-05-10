package com.ikerleon.birdwmod.client.model.europe;

import com.ikerleon.birdwmod.entity.europe.EntityStellersEider;
import com.ikerleon.birdwmod.util.PosesUtil;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.soggymustache.bookworm.client.animation.part.BookwormModelBase;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;

/**
 * ModelStellersEider - starcook
 * Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelStellersEider extends BookwormModelBase {
    public BookwormModelRenderer body;
    public BookwormModelRenderer neck;
    public BookwormModelRenderer tailbottom;
    public BookwormModelRenderer leftwing;
    public BookwormModelRenderer rightwing;
    public BookwormModelRenderer rightleg;
    public BookwormModelRenderer leftleg;
    public BookwormModelRenderer belly;
    public BookwormModelRenderer body2;
    public BookwormModelRenderer belly2;
    public BookwormModelRenderer neckfront;
    public BookwormModelRenderer neckback;
    public BookwormModelRenderer head;
    public BookwormModelRenderer beakmain;
    public BookwormModelRenderer beaktop2;
    public BookwormModelRenderer beaktop1;
    public BookwormModelRenderer headback;
    public BookwormModelRenderer crest;
    public BookwormModelRenderer toppart;
    public BookwormModelRenderer leftwing2;
    public BookwormModelRenderer rightwing2;
    public BookwormModelRenderer rightfootfinger;
    public BookwormModelRenderer rightfootfinger3;
    public BookwormModelRenderer rightfootfinger2;
    public BookwormModelRenderer leftfootfinger;
    public BookwormModelRenderer leftfootfinger3;
    public BookwormModelRenderer leftfootfinger2;
    public BookwormModelRenderer tail;

    public ModelStellersEider() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.neckfront = new BookwormModelRenderer(this, 18, 33, "neckfront");
        this.neckfront.setRotationPoint(0.0F, -0.3F, -1.7F);
        this.neckfront.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 4, 0.0F);
        this.rightfootfinger2 = new BookwormModelRenderer(this, 118, 52, "rightfootfinger2");
        this.rightfootfinger2.setRotationPoint(0.2F, 2.6F, -0.5F);
        this.rightfootfinger2.addBox(-0.5F, -0.2F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rightfootfinger2, -0.24434609527920614F, 0.3490658503988659F, 0.0F);
        this.rightfootfinger3 = new BookwormModelRenderer(this, 98, 52, "rightfootfinger3");
        this.rightfootfinger3.setRotationPoint(-0.2F, 2.6F, -0.5F);
        this.rightfootfinger3.addBox(-0.5F, -0.2F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(rightfootfinger3, -0.24434609527920614F, -0.3490658503988659F, 0.0F);
        this.leftfootfinger3 = new BookwormModelRenderer(this, 87, 52, "leftfootfinger3");
        this.leftfootfinger3.setRotationPoint(0.2F, 2.6F, -0.5F);
        this.leftfootfinger3.addBox(-0.5F, -0.2F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(leftfootfinger3, -0.24434609527920614F, 0.3490658503988659F, 0.0F);
        this.body = new BookwormModelRenderer(this, 86, 28, "body");
        this.body.mirror = true;
        this.body.setRotationPoint(0.0F, 18.8F, 0.5F);
        this.body.addBox(-2.5F, -3.7F, -1.3F, 5, 9, 5, 0.0F);
        this.setRotateAngle(body, 2.2689280275926285F, -3.141592653589793F, 0.0F);
        this.toppart = new BookwormModelRenderer(this, 20, 42, "toppart");
        this.toppart.setRotationPoint(0.0F, -1.8F, 0.3F);
        this.toppart.addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
        this.crest = new BookwormModelRenderer(this, 37, 45, "crest");
        this.crest.setRotationPoint(0.0F, -1.4F, -0.8F);
        this.crest.addBox(-1.0F, -1.0F, -1.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(crest, 1.0471975511965976F, 0.0F, 0.0F);
        this.neckback = new BookwormModelRenderer(this, 2, 33, "neckback");
        this.neckback.setRotationPoint(0.0F, 1.4F, -0.9F);
        this.neckback.addBox(-1.5F, -2.0F, -4.0F, 3, 2, 4, 0.0F);
        this.beakmain = new BookwormModelRenderer(this, 3, 54, "beakmain");
        this.beakmain.setRotationPoint(0.0F, 0.3F, 2.3F);
        this.beakmain.addBox(-1.0F, -0.5F, -0.4F, 2, 1, 3, 0.0F);
        this.head = new BookwormModelRenderer(this, 18, 48, "head");
        this.head.setRotationPoint(0.0F, 0.4F, -3.1F);
        this.head.addBox(-2.0F, -1.6F, -1.6F, 4, 3, 4, 0.0F);
        this.setRotateAngle(head, 1.4032447186034411F, 0.0F, 0.0F);
        this.tailbottom = new BookwormModelRenderer(this, 71, 14, "tailbottom");
        this.tailbottom.mirror = true;
        this.tailbottom.setRotationPoint(0.0F, -3.3F, -1.4F);
        this.tailbottom.addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(tailbottom, 2.276432943376204F, 0.0F, 0.0F);
        this.tail = new BookwormModelRenderer(this, 93, 6, "tail");
        this.tail.mirror = true;
        this.tail.setRotationPoint(0.0F, -1.2F, -1.6F);
        this.tail.addBox(-1.0F, -4.7F, 0.0F, 2, 5, 1, 0.0F);
        this.setRotateAngle(tail, -0.08726646259971647F, 0.0F, 0.0F);
        this.neck = new BookwormModelRenderer(this, 32, 31, "neck");
        this.neck.setRotationPoint(0.0F, 5.1F, 1.3F);
        this.neck.addBox(-2.0F, -1.7F, -1.5F, 4, 4, 5, 0.0F);
        this.setRotateAngle(neck, 2.5953045977155678F, 0.0F, 0.0F);
        this.leftwing2 = new BookwormModelRenderer(this, 23, 13, "leftwing2");
        this.leftwing2.setRotationPoint(-0.1F, -4.5F, 1.0F);
        this.leftwing2.addBox(-0.4F, -5.5F, -2.8F, 1, 6, 3, 0.0F);
        this.setRotateAngle(leftwing2, 0.03490658503988659F, 0.0F, 0.08726646259971647F);
        this.leftleg = new BookwormModelRenderer(this, 79, 45, "leftleg");
        this.leftleg.setRotationPoint(-1.3F, -2.5F, -0.3F);
        this.leftleg.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(leftleg, -2.007128639793479F, 0.0F, 0.0F);
        this.leftfootfinger2 = new BookwormModelRenderer(this, 67, 52, "leftfootfinger2");
        this.leftfootfinger2.setRotationPoint(-0.2F, 2.6F, -0.5F);
        this.leftfootfinger2.addBox(-0.5F, -0.2F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(leftfootfinger2, -0.24434609527920614F, -0.3490658503988659F, 0.0F);
        this.leftwing = new BookwormModelRenderer(this, 22, 2, "leftwing");
        this.leftwing.setRotationPoint(-2.3F, 3.7F, 1.6F);
        this.leftwing.addBox(-0.6F, -4.5F, -2.0F, 1, 5, 4, 0.0F);
        this.setRotateAngle(leftwing, -0.08726646259971647F, 0.0F, 0.0F);
        this.rightwing = new BookwormModelRenderer(this, 44, 2, "rightwing");
        this.rightwing.setRotationPoint(2.3F, 3.7F, 1.6F);
        this.rightwing.addBox(-0.4F, -4.5F, -2.0F, 1, 5, 4, 0.0F);
        this.setRotateAngle(rightwing, -0.08726646259971647F, 0.0F, 0.0F);
        this.beaktop2 = new BookwormModelRenderer(this, 1, 48, "beaktop2");
        this.beaktop2.setRotationPoint(0.0F, 0.0F, 1.6F);
        this.beaktop2.addBox(-0.5F, -0.7F, -0.6F, 1, 1, 3, 0.0F);
        this.setRotateAngle(beaktop2, -0.17453292519943295F, 0.0F, 0.0F);
        this.rightleg = new BookwormModelRenderer(this, 110, 45, "rightleg");
        this.rightleg.setRotationPoint(1.3F, -2.5F, -0.3F);
        this.rightleg.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        this.setRotateAngle(rightleg, -2.007128639793479F, 0.0F, 0.0F);
        this.rightfootfinger = new BookwormModelRenderer(this, 107, 51, "rightfootfinger");
        this.rightfootfinger.setRotationPoint(0.0F, 2.7F, 0.0F);
        this.rightfootfinger.addBox(-0.5F, -0.2F, -1.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(rightfootfinger, -0.24434609527920614F, 0.0F, 0.0F);
        this.headback = new BookwormModelRenderer(this, 37, 51, "headback");
        this.headback.setRotationPoint(0.0F, 0.1F, -1.8F);
        this.headback.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 1, 0.0F);
        this.leftfootfinger = new BookwormModelRenderer(this, 76, 51, "leftfootfinger");
        this.leftfootfinger.setRotationPoint(0.0F, 2.7F, 0.0F);
        this.leftfootfinger.addBox(-0.5F, -0.2F, -1.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(leftfootfinger, -0.24434609527920614F, 0.0F, 0.0F);
        this.body2 = new BookwormModelRenderer(this, 90, 16, "body2");
        this.body2.mirror = true;
        this.body2.setRotationPoint(0.1F, -3.1F, 3.5F);
        this.body2.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 2, 0.0F);
        this.setRotateAngle(body2, 0.091106186954104F, 0.0F, 0.0F);
        this.belly = new BookwormModelRenderer(this, 52, 33, "belly");
        this.belly.setRotationPoint(0.0F, 4.4F, -2.3F);
        this.belly.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(belly, 1.9123572614101867F, 0.0F, 0.0F);
        this.belly2 = new BookwormModelRenderer(this, 70, 34, "belly2");
        this.belly2.setRotationPoint(0.0F, -2.7F, -1.4F);
        this.belly2.addBox(-1.5F, -4.0F, -3.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(belly2, 2.5497515042385164F, 0.0F, 0.0F);
        this.beaktop1 = new BookwormModelRenderer(this, 10, 49, "beaktop1");
        this.beaktop1.setRotationPoint(0.0F, -0.7F, 1.7F);
        this.beaktop1.addBox(-1.0F, -0.5F, -0.4F, 2, 2, 1, 0.0F);
        this.setRotateAngle(beaktop1, 1.0471975511965976F, 0.0F, 0.0F);
        this.rightwing2 = new BookwormModelRenderer(this, 45, 13, "rightwing2");
        this.rightwing2.setRotationPoint(-0.1F, -4.5F, 1.0F);
        this.rightwing2.addBox(-0.4F, -5.5F, -2.8F, 1, 6, 3, 0.0F);
        this.setRotateAngle(rightwing2, 0.03490658503988659F, 0.0F, -0.08726646259971647F);
        this.neck.addChild(this.neckfront);
        this.rightleg.addChild(this.rightfootfinger2);
        this.rightleg.addChild(this.rightfootfinger3);
        this.leftleg.addChild(this.leftfootfinger3);
        this.head.addChild(this.toppart);
        this.head.addChild(this.crest);
        this.neck.addChild(this.neckback);
        this.head.addChild(this.beakmain);
        this.neckfront.addChild(this.head);
        this.body.addChild(this.tailbottom);
        this.body2.addChild(this.tail);
        this.body.addChild(this.neck);
        this.leftwing.addChild(this.leftwing2);
        this.body.addChild(this.leftleg);
        this.leftleg.addChild(this.leftfootfinger2);
        this.body.addChild(this.leftwing);
        this.body.addChild(this.rightwing);
        this.head.addChild(this.beaktop2);
        this.body.addChild(this.rightleg);
        this.rightleg.addChild(this.rightfootfinger);
        this.head.addChild(this.headback);
        this.leftleg.addChild(this.leftfootfinger);
        this.body.addChild(this.body2);
        this.body.addChild(this.belly);
        this.body.addChild(this.belly2);
        this.head.addChild(this.beaktop1);
        this.rightwing.addChild(this.rightwing2);

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
            this.body.render(f5);
            GlStateManager.popMatrix();
        }
        else {
            float scaleFactor = 0.7F;

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

        BlockPos pos = new BlockPos(entityIn.posX, entityIn.posY - 0.2, entityIn.posZ);

        if ((entityIn instanceof EntityStellersEider)) {
            EntityStellersEider eider = (EntityStellersEider)entityIn;

            float globalSpeed = 1.5f;
            float globalDegree = 1.25F;

            this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * 1 * limbSwingAmount - 4f * 0.5f;
            this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.5f * globalSpeed) * 0.5f * globalDegree * -1 * limbSwingAmount - 4f * 0.5f;
            this.neck.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.05f * globalDegree * -1 * limbSwingAmount + 5.25F * 0.5f;
            this.body2.rotateAngleX = MathHelper.cos(limbSwing * 0.8f * globalSpeed) * 0.1f * globalDegree * -1 * limbSwingAmount + 0 * 0.5f;

            this.body2.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.17f) * 0.05F * 1 * 0.5f + 0.25F * 0.5f;
            this.head.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.2f) * 0.06F * 1 * 0.5f + 2.8F * 0.5f;
            this.rightwing.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;
            this.leftwing.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.17f) * 0.03F * -1 * 0.5f;

            if ((!eider.onGround && !eider.isInWater() && !eider.isChild()) && entityIn.world.getBlockState(pos).getMaterial() != Material.WATER) {
                interpolateToPose(PosesUtil.STELLERS_EIDER_FLYING_POSE, eider.timer);

                this.rightwing.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + 2.5F * 0.5f;
                this.leftwing.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.6f * globalSpeed + 0) * 0.2f * globalDegree * -1 * 0.5f + 2.5F * 0.5f;
                this.rightwing.rotateAngleY = MathHelper.cos(eider.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f - 3F * 0.5f;
                this.leftwing.rotateAngleY = MathHelper.cos(eider.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 3F * 0.5f;
                this.rightwing2.rotateAngleZ = MathHelper.cos(eider.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * 1 * 0.5f + 0 * 0.5f;
                this.leftwing2.rotateAngleZ = MathHelper.cos(eider.ticksExisted * 0.3f * globalSpeed + 0) * 0.4f * globalDegree * -1 * 0.5f + 0 * 0.5f;
            }
            else if(eider.isInWater() || entityIn.world.getBlockState(pos).getMaterial() == Material.WATER){
                interpolateToPose(PosesUtil.STELLERS_EIDER_SWIMMING_POSE, eider.timer);

                this.rightleg.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.2f * globalSpeed + 0) * 0.5f * globalDegree * -1 * 0.5f - 4 * 0.5f;
                this.leftleg.rotateAngleX = MathHelper.cos(eider.ticksExisted * 0.2f * globalSpeed + 0) * 0.5f * globalDegree * 1 * 0.5f + - 4 * 0.5f;
            }
        }
    }

    public void setRotateAngle(BookwormModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}