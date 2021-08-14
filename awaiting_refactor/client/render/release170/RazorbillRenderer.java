package com.ikerleon.birdwmod.client.render.release170;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.release170.RazorbillEntity;
import net.minecraft.block.Material;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.soggymustache.bookworm.client.animation.part.BookwormModelRenderer;
import net.soggymustache.bookworm.client.model.CMFAnimator;
import net.soggymustache.bookworm.client.model.ModelCMF;

public class RazorbillRenderer extends BirdBaseRenderer<RazorbillEntity> {

    public static final ModelCMF RAZORBILL = new ModelCMF(new Identifier("birdwmod", "models/entity/razorbill/razorbill.bkm"));
    public static final ModelCMF RAZORBILL_SWIMMING = new ModelCMF(new Identifier("birdwmod", "models/entity/razorbill/razorbill_swimming.bkm"));
    public static final ModelCMF RAZORBILL_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/razorbill/razorbill_flying.bkm"));
    public static final ModelCMF RAZORBILL_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/razorbill/razorbill_sleeping.bkm"));

    public static final Identifier TEXTURESUMMER = new Identifier("birdwmod" + ":textures/entity/release170/razorbillsummer.png");
    public static final Identifier TEXTUREWINTER = new Identifier("birdwmod" + ":textures/entity/release170/razorbillwinter.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/release170/razorbillchick.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/release170/razorbill_sleeping.png");
    private final Identifier RAZORBILL_RING = new Identifier("birdwmod" + ":textures/entity/rings/razorbill_ring.png");

    public RazorbillRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, RAZORBILL, 0.15F);
        RAZORBILL.setAnimator(RazorbillAnimator::new);
    }

    @Override
    protected void scale(RazorbillEntity entity, MatrixStack matrices, float tickDelta) {
        if (entity.isBaby()) {
            float scaleFactor = 0.3F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        } else {
            float scaleFactor;

            if (entity.getGender() == 0) {
                scaleFactor = 0.6F;
            } else {
                scaleFactor = 0.55F;
            }

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(RazorbillEntity entity) {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(RazorbillEntity entity) {
        return RAZORBILL_RING;
    }

    @Override
    public Identifier getTexture(RazorbillEntity entity) {
        if (entity.isBaby()) {
            return TEXTURECHICK;
        } else {
            try {
                if (entity.biome.getTemperature() < 0.15) {
                    return TEXTUREWINTER;
                } else {
                    return TEXTURESUMMER;
                }
            } catch (NullPointerException e) {
                return TEXTURESUMMER;
            }
        }
    }

    private class RazorbillAnimator extends CMFAnimator {

        protected final BookwormModelRenderer head = this.getModel().getPartByName("head");
        protected final BookwormModelRenderer Torso = this.getModel().getPartByName("Torso");
        protected final BookwormModelRenderer WingR = this.getModel().getPartByName("WingR");
        protected final BookwormModelRenderer WingL = this.getModel().getPartByName("WingL");
        protected final BookwormModelRenderer Tail = this.getModel().getPartByName("Tail");
        protected final BookwormModelRenderer Wing2R = this.getModel().getPartByName("Wing2R");
        protected final BookwormModelRenderer Wing2L = this.getModel().getPartByName("Wing2L");
        protected final BookwormModelRenderer Shoulders = this.getModel().getPartByName("Shoulders");
        protected final BookwormModelRenderer Hip = this.getModel().getPartByName("Hip");
        protected final BookwormModelRenderer LegR = this.getModel().getPartByName("LegR");
        protected final BookwormModelRenderer LegL = this.getModel().getPartByName("LegL");

        public RazorbillAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
            this.getModel().reset();

            BlockPos pos = new BlockPos(entityIn.getX(), entityIn.getY() - 0.2, entityIn.getZ());

            if ((entityIn instanceof RazorbillEntity)) {
                RazorbillEntity razorbill = (RazorbillEntity) entityIn;

                float globalSpeed = 1.5f;
                float globalDegree = 1.25F;

                if (razorbill.isSleeping() && razorbill.isOnGround()) {
                    this.getModel().interpolateToPose(RazorbillRenderer.RAZORBILL_SLEEPING, razorbill.timer);

                    this.head.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.2F) * 0.5f * 0.5F + -0.2F;
                    this.Torso.pitch = MathHelper.cos(2.0F + (razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.05F) * 0.5f * 0.5F + -0.05F;
                    this.WingR.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.3F) * 0.5f * 0.5F + -1.5F;
                    this.WingL.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.3F) * 0.5f * 0.5F + -1.5F;
                    this.Tail.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * -0.2F) * 0.5f * 0.5F + -1.1F;
                }
                else {
                    this.head.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.2F) * 0.5f * 0.5F + -0.37F;
                    this.Torso.pitch = MathHelper.cos(2.0F + (razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.05F) * 0.5f * 0.5F + -0.05F;
                    this.WingR.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.3F) * 0.5f * 0.5F + -1.5F;
                    this.WingL.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.3F) * 0.5f * 0.5F + -1.5F;
                    this.Tail.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * -0.2F) * 0.5f * 0.5F + -1.1F;

                    if ((!razorbill.isOnGround() && !razorbill.isTouchingWater() && !razorbill.isBaby()) && entityIn.world.getBlockState(pos).getMaterial() != Material.WATER) {
                        this.getModel().interpolateToPose(RazorbillRenderer.RAZORBILL_FLYING, razorbill.timer);

                        this.WingR.yaw = MathHelper.cos((limbSwing * globalSpeed * 0.4F) + (float) Math.PI) * (globalDegree * 0.9F) * limbSwingAmount * 0.5F + 1.5F;
                        this.Wing2R.yaw = MathHelper.cos((limbSwing * globalSpeed * 0.4F) + (float) Math.PI) * (globalDegree * -1.0F) * limbSwingAmount * 0.5F;
                        this.WingL.yaw = MathHelper.cos((limbSwing * globalSpeed * 0.4F) + (float) Math.PI) * (globalDegree * -0.9F) * limbSwingAmount * 0.5F + -1.5F;
                        this.Wing2L.yaw = MathHelper.cos((limbSwing * globalSpeed * 0.4F) + (float) Math.PI) * (globalDegree * 1.0F) * limbSwingAmount * 0.5F;
                        this.Shoulders.pitch = MathHelper.cos((limbSwing * globalSpeed * 0.2F) + (float) Math.PI) * (globalDegree * 0.1F) * limbSwingAmount * 0.5F + 0.1F;
                        this.head.pitch = MathHelper.cos(2.0F + (limbSwing * globalSpeed * 0.2F) + (float) Math.PI) * (globalDegree * 0.3F) * limbSwingAmount * 0.5F + -1.4F;
                        this.Hip.offsetY = MathHelper.cos(2.0F + (limbSwing * globalSpeed * 0.2F) + (float) Math.PI) * (globalDegree * 0.1F) * limbSwingAmount * 0.5F;
                        this.Tail.pitch = MathHelper.cos((limbSwing * globalSpeed * 0.2F) + (float) Math.PI) * (globalDegree * 0.2F) * limbSwingAmount * 0.5F + -1.45F;

                    }
                    else if (razorbill.isTouchingWater() || entityIn.world.getBlockState(pos).getMaterial() == Material.WATER) {
                        this.getModel().interpolateToPose(RazorbillRenderer.RAZORBILL_SWIMMING, razorbill.timer);

                        this.head.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.2F) * 0.5f * 0.5F + -1.3F;
                        this.Torso.pitch = MathHelper.cos(2.0F + (razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.05F) * 0.5f * 0.5F;
                        this.WingR.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.3F) * 0.5f * 0.5F + -1.65F;
                        this.WingL.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * 0.3F) * 0.5f * 0.5F + -1.65F;
                        this.Tail.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.1F) + (float) Math.PI) * (globalDegree * -0.2F) * 0.5f * 0.5F + -1.85F;
                        this.LegR.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.2F) + (float) Math.PI) * (globalDegree * 1.8F) * 0.5f * 0.5F + 1.3F;
                        this.LegL.pitch = MathHelper.cos((razorbill.age * globalSpeed * 0.2F) + (float) Math.PI) * (globalDegree * -1.8F) * 0.5f * 0.5F + 1.3F;
                    }
                }
            }
        }
    }
}
