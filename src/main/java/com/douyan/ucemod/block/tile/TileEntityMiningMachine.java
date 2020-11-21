/**
 * Creative by DouYan on 2020-01-15 16:23
 */
package com.douyan.ucemod.block.tile;

import com.douyan.ucemod.Debug;
import com.douyan.ucemod.registry.UCEBlock;
import com.douyan.ucemod.utils.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import java.util.List;

public class TileEntityMiningMachine extends TileEntity implements ITickable
{
    //当前是否运转
    private boolean isRun = true;
    
    public int progress = 0;
    //深度
    private int depth = 0;
    //private long microJoules = 0;
    
	//清除采矿管
    public void DeleteMiningTube()
    {
    	/*
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(getPos());
        for (int depth = getPos().getY() - 1; depth > 0; depth--)
        {
        	pos.setY(depth);
        	if (getWorld().getBlockState(pos).getBlock() != UCEBlock.MINING_TUBE)
                break;
            getWorld().setBlockToAir(pos);
        }
        
        
        */
    	//BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(getPos());
    	
    	BlockPos pos = this.pos.down();
    	
    	while(pos.getY() >= 0)
    	{
	    	if(getWorld().getBlockState(pos).getBlock() == UCEBlock.MINING_TUBE)
	        {
	    		getWorld().setBlockState(new BlockPos(getPos().getX(), pos.getY(), getPos().getZ()), Blocks.AIR.getDefaultState());
	        }else
            {
                pos = pos.down();
            }
	    	//  break;
    	}
    }
    
    
    
    
    
    @Override
    public void update()
    {
    	
    	if(world==null||this.world.isRemote||!isRun)return;
    	Block db = world.getBlockState(this.pos.up()).getBlock();
    	
    	
    
    	
    	
    	
    	
    	
    	
    	
        if
        (
    		!(db instanceof BlockShulkerBox) &&
    		db != Blocks.CHEST &&
    		db != Blocks.TRAPPED_CHEST
    		)return;

        BlockPos pos = this.pos.down();
        while(pos.getY()>=0)
        {
            IBlockState block = world.getBlockState(pos);
            

	    	if(block.getMaterial() == Material.AIR)
	        {
	    		getWorld().setBlockState(new BlockPos(getPos().getX(), pos.getY(), getPos().getZ()), UCEBlock.MINING_TUBE.getDefaultState());
	        }
	    	
	    	
	    	if(block.getMaterial() != Material.AIR && block.getBlock() != UCEBlock.MINING_TUBE)
	        	
	            
	    		// if(block.getBlock() != Blocks.AIR && block.getBlock() != UCEBlock.MINING_TUBE)
	    		
	    		//if(block.getMaterial()!= Material.AIR)
            {
            	//  if(player.interactionManager==null)return;
            	IBlockState state = world.getBlockState(pos);

            	//获取方块的硬度，求出需要破坏的时间
            	float hardness = state.getBlockHardness(world,pos);
            	if(hardness==-1.0F)return;
            	//求出破坏总耗时
            	long target = (long) Math.floor(16 * 1_000_000L * ((hardness + 1) * 2) * 1);
            	//当前破坏进度
            	progress += extractPower(0,target-progress);
            	//当前进度大于总耗时时破坏掉方块
            	if(progress>=target)
            	{
            	    //延长采矿管道
                
                Debug.info("Current Depth"+depth);
            		progress=0;
            		//消除所有裂痕并破坏掉
            		//于BC的源码有变动
            		world.sendBlockBreakProgress(pos.hashCode(),pos,-1);

            		Block block1 = world.getBlockState(pos).getBlock();
            		TileEntity tileEntity = world.getTileEntity(this.pos.up());
            		if(tileEntity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP))
            		{
                        IItemHandler items = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,EnumFacing.UP);
                        List<ItemStack> itemStackList = block1.getDrops(world,pos,world.getBlockState(pos),0);
                        for (ItemStack stack : itemStackList)
                        {
                            if(stack.getItem().getTranslationKey().indexOf("shulkerBox")==-1)
                            {
                                int nu = InventoryUtils.addItemToSlot(items, stack);
                                world.spawnEntity(new EntityItem(world, this.pos.getX(), this.pos.getY(), this.pos.getZ(), new ItemStack(stack.getItem(), nu, stack.getMetadata())));
                            }
                        }
                        world.playEvent(2001, pos, Block.getStateId(world.getBlockState(pos)));
                        world.setBlockState(pos,Blocks.AIR.getDefaultState(),3);
                    }
            	}else
            	{
                        //修改方块的裂痕进程 最后一个参数范围0-9
                        world.sendBlockBreakProgress(pos.hashCode(),pos,(int)((progress*9)/target));
            	}
                    break;
                }else
                {
                    pos = pos.down();
                }
        }


    }

    
    
    public int getDepth(){
        return this.depth;
    }

    /*
    @Override
    public AxisAlignedBB getRenderBoundingBox(){
        return  new net.minecraft.util.math.AxisAlignedBB(pos, pos.add(0, -depth, 0));
    }
        */
    //加物品进去

    public long extractPower(long min, long max)
    {
    	/*
		    于BC的源码有变动
		    这里可以调数
		    返回的值越大，效率越高
        if (microJoules < min) return 0;
        long extracting = Math.min(microJoules, max);
        microJoules -= extracting;
        */
    	
        return 1000000;
    }
    
   
    
    
    public boolean Check(World world,BlockPos pos)
    {
        Block block1 = world.getBlockState(pos.add(-4,0,-4)).getBlock();
        Block block2 = world.getBlockState(pos.add(-4,0,4)).getBlock();
        Block block3 = world.getBlockState(pos.add(4,0,4)).getBlock();
        Block block4 = world.getBlockState(pos.add(4,0,-4)).getBlock();

        if(block1== UCEBlock.PART_BLOCK&&block2== UCEBlock.PART_BLOCK&&block3== UCEBlock.PART_BLOCK&&block4== UCEBlock.PART_BLOCK)
        {
            return true;
        }else
            {
            return false;
        }
    }
}
