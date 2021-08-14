package com.ikerleon.birdwmod.entity.goal;

import com.ikerleon.birdwmod.entity.BirdEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.List;
import java.util.function.Predicate;

public class FollowLeaderGoal extends Goal {
    private final BirdEntity bird;
    private int moveDelay;
    private int checkSurroundingDelay;

    public FollowLeaderGoal(BirdEntity bird) {
        this.bird = bird;
        this.checkSurroundingDelay = this.getSurroundingSearchDelay(bird);
    }

    protected int getSurroundingSearchDelay(BirdEntity bird) {
        return 200 + bird.getRandom().nextInt(200) % 20;
    }

    public boolean canStart() {
        if(bird.isGroupBird()){
            if (this.bird.hasOtherBirdInGroup()) {
                return false;
            } else if (this.bird.hasLeader()) {
                return true;
            } else if (this.checkSurroundingDelay > 0) {
                --this.checkSurroundingDelay;
                return false;
            } else {
                this.checkSurroundingDelay = this.getSurroundingSearchDelay(this.bird);
                Predicate<BirdEntity> predicate = (schoolingBirdEntityx) -> {
                    return schoolingBirdEntityx.canHaveMoreBirdInGroup() || !schoolingBirdEntityx.hasLeader();
                };
                List<BirdEntity> list = this.bird.world.getEntities(this.bird.getClass(), this.bird.getBoundingBox().expand(8.0D, 8.0D, 8.0D), predicate);
                BirdEntity birdEntity = (BirdEntity)list.stream().filter(BirdEntity::canHaveMoreBirdInGroup).findAny().orElse(this.bird);
                birdEntity.pullInOtherBird(list.stream().filter((schoolingFishEntityx) -> {
                    return !schoolingFishEntityx.hasLeader();
                }));
                return this.bird.hasLeader();
            }
        }
        else{
            return false;
        }
    }

    public boolean shouldContinue() {
        return this.bird.hasLeader() && this.bird.isCloseEnoughToLeader();
    }

    public void start() {
        this.moveDelay = 0;
    }

    public void stop() {
        this.bird.leaveGroup();
    }

    public void tick() {
        if (--this.moveDelay <= 0) {
            this.moveDelay = 10;
            this.bird.moveTowardLeader();
        }
    }
}
