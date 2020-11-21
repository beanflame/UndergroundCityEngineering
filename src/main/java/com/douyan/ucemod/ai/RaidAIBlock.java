package com.douyan.ucemod.ai;

import com.douyan.ucemod.entity.AbstractRobot;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIMoveToBlock;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class RaidAIBlock extends EntityAIMoveToBlock{
        ArrayList<Block> blocks=new ArrayList<>();
    AbstractRobot rabbit;

    public RaidAIBlock(AbstractRobot creature, double speedIn, int length) {
        super(creature, speedIn, length);
        rabbit=creature;
        blocks.add(Blocks.STONE);
        blocks.add(Blocks.COAL_ORE);
    }

    @Override
    public boolean shouldExecute() {
        return super.shouldExecute()&&!this.rabbit.isFull();
    }

    public boolean shouldContinueExecuting()
        {
            return true;
        }

        private boolean canBreak(Block block){
        return blocks.contains(block)&&rabbit.hasFuel();
        }

        public void updateTask()
        {
            super.updateTask();
            if (this.getIsAboveDestination())
            {
                World world = this.rabbit.world;
                BlockPos blockpos = this.destinationBlock.up();
                IBlockState iblockstate = world.getBlockState(blockpos);
                Block block = iblockstate.getBlock();

                if (canBreak(block))
                {
                        world.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 2);
                        world.destroyBlock(blockpos, true);
                }
            }
        }

        /**
         * Return true to set given position as destination
         */
        protected boolean shouldMoveTo(World worldIn, BlockPos pos)
        {
            Block block = worldIn.getBlockState(pos).getBlock();
            return canBreak(block);
        }


}
