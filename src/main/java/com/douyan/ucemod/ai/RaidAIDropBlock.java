package com.douyan.ucemod.ai;

import com.douyan.ucemod.entity.AbstractRobot;
import com.douyan.ucemod.utils.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIMoveToBlock;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class RaidAIDropBlock extends EntityAIBase {
    /** Controls task execution delay */
    protected int runDelay;
    private int timeoutCounter;
    /** Block to move to */
    protected BlockPos destinationBlock;
    AbstractRobot rabbit;
    private double movementSpeed=1;

    public RaidAIDropBlock(AbstractRobot rabbit){
        this.rabbit=rabbit;
        this.destinationBlock=rabbit.getHomePosition();
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.runDelay > 0)
        {
            --this.runDelay;
            return false;
        }
        else
        {
            this.runDelay = 200 + this.rabbit.getRNG().nextInt(200);
            return rabbit.isFull();
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
 /*   public boolean shouldContinueExecuting()
    {
        return this.timeoutCounter >= -this.maxStayTicks && this.timeoutCounter <= 1200 && this.shouldMoveTo(this.creature.world, this.destinationBlock);
    }
*/
    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.rabbit.getNavigator().tryMoveToXYZ((double)((float)this.destinationBlock.getX()) + 0.5D, (double)(this.destinationBlock.getY() + 1), (double)((float)this.destinationBlock.getZ()) + 0.5D, this.movementSpeed);
        this.timeoutCounter = 0;
    }

    /**
     * Keep ticking a continuous task that has already been started
     */
    public void updateTask()
    {
        if (this.rabbit.getDistanceSqToCenter(this.destinationBlock.up()) > 1.0D)
        {
            ++this.timeoutCounter;

            if (this.timeoutCounter % 40 == 0)
            {
                this.rabbit.getNavigator().tryMoveToXYZ((double)((float)this.destinationBlock.getX()) + 0.5D, (double)(this.destinationBlock.getY() + 1), (double)((float)this.destinationBlock.getZ()) + 0.5D, this.movementSpeed);
            }
        }
        else
        {
           rabbit.dropItems();
            --this.timeoutCounter;
        }
    }


}
