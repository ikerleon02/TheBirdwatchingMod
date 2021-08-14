package com.ikerleon.birdwmod.client.render.release160;

import com.ikerleon.birdwmod.client.render.BirdBaseRenderer;
import com.ikerleon.birdwmod.entity.release160.BrownBoobyEntity;
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

public class BrownBoobyRenderer extends BirdBaseRenderer<BrownBoobyEntity> {

    public static final ModelCMF BROWN_BOOBY = new ModelCMF(new Identifier("birdwmod", "models/entity/brown_booby/brown_booby.bkm"));
    public static final ModelCMF BROWN_BOOBY_SWIMMING = new ModelCMF(new Identifier("birdwmod", "models/entity/brown_booby/brown_booby_swimming.bkm"));
    public static final ModelCMF BROWN_BOOBY_FLYING = new ModelCMF(new Identifier("birdwmod", "models/entity/brown_booby/brown_booby_flying.bkm"));
    public static final ModelCMF BROWN_BOOBY_SLEEPING = new ModelCMF(new Identifier("birdwmod", "models/entity/brown_booby/brown_booby_sleeping.bkm"));

    public static final Identifier TEXTURE = new Identifier("birdwmod" + ":textures/entity/release160/brownbooby.png");
    public static final Identifier TEXTURE2 = new Identifier("birdwmod" + ":textures/entity/release160/brownbooby2.png");
    public static final Identifier TEXTURE3 = new Identifier("birdwmod" + ":textures/entity/release160/brownbooby3.png");
    public static final Identifier TEXTURE4 = new Identifier("birdwmod" + ":textures/entity/release160/brownbooby4.png");
    public static final Identifier TEXTURECHICK = new Identifier("birdwmod" + ":textures/entity/release160/brownboobychick.png");
    public static final Identifier TEXTUREBLINK = new Identifier("birdwmod" + ":textures/entity/release160/brownbooby_sleeping.png");
    private final Identifier BOOBY_RING = new Identifier("birdwmod" + ":textures/entity/rings/booby_ring.png");

    public BrownBoobyRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, BROWN_BOOBY, 0.15F);
        BROWN_BOOBY.setAnimator(BrownBoobyAnimator::new);
    }

    @Override
    protected void scale(BrownBoobyEntity entity, MatrixStack matrices, float tickDelta) {
        if (entity.isBaby()) {
            float scaleFactor = 0.3F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        } else {
            float scaleFactor = 0.6F;

            matrices.scale(scaleFactor, scaleFactor, scaleFactor);
        }
        super.scale(entity, matrices, tickDelta);
    }

    @Override
    public Identifier getBlinkTexture(BrownBoobyEntity entity) {
        return TEXTUREBLINK;
    }

    @Override
    public Identifier getRingTexture(BrownBoobyEntity entity) {
        return BOOBY_RING;
    }

    @Override
    public Identifier getTexture(BrownBoobyEntity entity) {
        if(entity.isBaby()){
            return TEXTURECHICK;
        }
        else {
            return this.getTextureOfVar(entity.getVariant());
        }
    }

    public Identifier getTextureOfVar(int variant) {
        switch (variant) {
            case 0:
            default:
                return TEXTURE;
            case 1:
                return TEXTURE2;
            case 2:
                return TEXTURE3;
            case 3:
                return TEXTURE4;
        }
    }

    private class BrownBoobyAnimator extends CMFAnimator {

        protected final BookwormModelRenderer neck = this.getModel().getPartByName("neck");
        protected final BookwormModelRenderer head = this.getModel().getPartByName("head");
        protected final BookwormModelRenderer belly2 = this.getModel().getPartByName("belly2");
        protected final BookwormModelRenderer body2 = this.getModel().getPartByName("body2");
        protected final BookwormModelRenderer rightwing2 = this.getModel().getPartByName("rightwing2");
        protected final BookwormModelRenderer leftwing2 = this.getModel().getPartByName("leftwing2");
        protected final BookwormModelRenderer leftleg = this.getModel().getPartByName("leftleg");
        protected final BookwormModelRenderer rightleg = this.getModel().getPartByName("rightleg");
        protected final BookwormModelRenderer body = this.getModel().getPartByName("body");
        protected final BookwormModelRenderer leftfoot = this.getModel().getPartByName("leftfoot");
        protected final BookwormModelRenderer rightfoot = this.getModel().getPartByName("rightfoot");
        protected final BookwormModelRenderer neck2 = this.getModel().getPartByName("neck2");
        protected final BookwormModelRenderer rightwing = this.getModel().getPartByName("rightwing");
        protected final BookwormModelRenderer leftwing = this.getModel().getPartByName("leftwing");

        public BrownBoobyAnimator(ModelCMF model) {
            super(model);
        }

        @Override
        public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
            super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            this.getModel().reset();

            BlockPos pos = new BlockPos(entity.getX(), entity.getY() - 0.2, entity.getZ());

            if ((entity instanceof BrownBoobyEntity)) {
                BrownBoobyEntity booby = (BrownBoobyEntity)entity;

                if(booby.isSleeping() && booby.isOnGround()){
                    this.getModel().interpolateToPose(BROWN_BOOBY_SLEEPING, booby.timer);

                    float speedsleeping = 1.0f;
                    float degreesleeping = 0.5f;

                    this.head.pitch = MathHelper.cos((booby.age * speedsleeping * 0.1F) + (float) Math.PI) * (degreesleeping * -0.2F) * 1 * 0.5F + 2.1F;
                    this.belly2.pitch = MathHelper.cos((booby.age * speedsleeping * 0.1F) + (float) Math.PI) * (degreesleeping * 0.2F) * 1 * 0.5F + 1.25F;
                    this.rightwing2.pitch = MathHelper.cos((booby.age * speedsleeping * 0.1F) + (float) Math.PI) * (degreesleeping * 0.2F) * 1 * 0.5F + 0.35F;
                    this.leftwing2.pitch = MathHelper.cos((booby.age * speedsleeping * 0.1F) + (float) Math.PI) * (degreesleeping * 0.2F) * 1 * 0.5F + 0.35F;
                }

                else {

                    float speedidle = 1.0f;
                    float degreeidle = 0.3f;
                    float degreewalk = 1.0f;

                    this.neck.pitch = MathHelper.cos((booby.age * speedidle * 0.1F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + 1.0F;
                    this.head.pitch = MathHelper.cos((booby.age * speedidle * 0.1F) + (float) Math.PI) * (degreeidle * -0.2F) * 1 * 0.5F + 1.85F;
                    this.belly2.pitch = MathHelper.cos((booby.age * speedidle * 0.1F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + 1.25F;
                    this.body2.pitch = MathHelper.cos(2.0F + (booby.age * speedidle * 0.1F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + -0.2F;
                    this.rightwing2.pitch = MathHelper.cos((booby.age * speedidle * 0.1F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + 0.25F;
                    this.leftwing2.pitch = MathHelper.cos((booby.age * speedidle * 0.1F) + (float) Math.PI) * (degreeidle * 0.2F) * 1 * 0.5F + 0.25F;

                    this.body.roll = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * 0.3F) * f1 * 0.5F;
                    this.leftleg.pitch = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * 2.0F) * f1 * 0.5F + 0.35F;
                    this.leftleg.roll = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * -0.3F) * f1 * 0.5F;
                    this.rightleg.pitch = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * -2.0F) * f1 * 0.5F + 0.35F;
                    this.rightleg.roll = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * -0.3F) * f1 * 0.5F;
                    this.leftfoot.pitch = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * -2.0F) * f1 * 0.5F + 0.2F;
                    this.rightfoot.pitch = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * 2.0F) * f1 * 0.5F + 0.2F;
                    this.neck2.yaw = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * 0.2F) * f1 * 0.5F;
                    this.leftfoot.roll = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * 0.3F) * f1 * 0.5F;
                    this.rightfoot.roll = MathHelper.cos((f * speedidle * 0.3F) + (float) Math.PI) * (degreewalk * 0.3F) * f1 * 0.5F;

                    if ((!booby.isOnGround() && !booby.isTouchingWater() && !booby.isBaby()) && entity.world.getBlockState(pos).getMaterial() != Material.WATER) {
                        this.getModel().interpolateToPose(BROWN_BOOBY_FLYING, booby.timer);

                        float speedflying = 1.6f;
                        float degreeflying = 0.6f;
                        this.body.offsetY = MathHelper.cos(2.0F + (f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.1F) * f1 * 0.5F;
                        this.rightwing.roll = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * -1.5F) * f1 * 0.5F + 1.5F;
                        this.leftwing.roll = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 1.5F) * f1 * 0.5F + -1.5F;
                        this.rightwing2.yaw = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 1.5F) * f1 * 0.5F;
                        this.leftwing2.yaw = MathHelper.cos((f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * -1.5F) * f1 * 0.5F;
                        this.body2.pitch = MathHelper.cos(2.0F + (f * speedflying * 0.3F) + (float) Math.PI) * (degreeflying * 0.1F) * f1 * 0.5F + -0.3F;

                    }
                    else if (booby.isTouchingWater() || entity.world.getBlockState(pos).getMaterial() == Material.WATER) {
                        this.getModel().interpolateToPose(BROWN_BOOBY_SWIMMING, booby.timer);

                        float speedswimming = 1.0f;
                        float degreeswimming = 0.5f;

                        this.neck.pitch = MathHelper.cos((booby.age * speedswimming * 0.1F) + (float) Math.PI) * (degreeswimming * 0.2F) * 1 * 0.5F + 0.85F;
                        this.head.pitch = MathHelper.cos((booby.age * speedswimming * 0.1F) + (float) Math.PI) * (degreeswimming * -0.2F) * 1 * 0.5F + 1.7F;
                        this.belly2.pitch = MathHelper.cos((booby.age * speedswimming * 0.1F) + (float) Math.PI) * (degreeswimming * 0.2F) * 1 * 0.5F + 1.25F;
                        this.body2.pitch = MathHelper.cos(2.0F + (booby.age * speedswimming * 0.1F) + (float) Math.PI) * (degreeswimming * 0.2F) * 1 * 0.5F + -0.2F;
                        this.rightwing2.pitch = MathHelper.cos((booby.age * speedswimming * 0.1F) + (float) Math.PI) * (degreeswimming * 0.2F) * 1 * 0.5F + 0.1F;
                        this.leftwing2.pitch = MathHelper.cos((booby.age * speedswimming * 0.1F) + (float) Math.PI) * (degreeswimming * 0.2F) * 1 * 0.5F + 0.1F;
                        this.leftleg.pitch = MathHelper.cos((booby.age * speedswimming * 0.4F) + (float) Math.PI) * (degreeswimming * 1.5F) * 1 * 0.5F + 1.25F;
                        this.rightleg.pitch = MathHelper.cos((booby.age * speedswimming * 0.4F) + (float) Math.PI) * (degreeswimming * -1.5F) * 1 * 0.5F + 1.25F;
                    }
                }
            }
        }
    }
}

