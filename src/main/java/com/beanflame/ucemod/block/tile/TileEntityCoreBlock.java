package com.beanflame.ucemod.block.tile;

import com.beanflame.ucemod.registry.UCEBlock;
import com.beanflame.ucemod.utils.InventoryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import java.util.List;

/**
 * Creative by GoldMain on 2020/1/14
 */

public class TileEntityCoreBlock extends TileEntity implements ITickable
{
    public boolean isRun = false;
    public BlockPos shoudDesBlock;
    public BlockPos initPos;
    public int progress = 0;
    public int speed = 1000;
    public boolean isInit = false;

    @Override
    public void update()
    {
        if(!isInit)
        {
            if(this.pos.getX()!=0&&this.pos.getY()!=0&&this.pos.getZ()!=0)
            {
                this.initPos = this.pos.add(-4,-1,-4);
                isInit = true;
            }else
                {
                return;
            }
        }

        BlockPos pos = this.pos.up();
        if(world.getTileEntity(pos)!=null&&world.getTileEntity(pos).hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN))
        {
            IItemHandler iItemHandler = world.getTileEntity(pos).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,EnumFacing.DOWN);
            isRun = true;
            isRun = !InventoryUtils.isFull(iItemHandler);
            AxisAlignedBB AABB2 = this.getRenderBoundingBox().grow(1);
            List<EntityItem> entityItemList = world.getEntitiesWithinAABB(EntityItem.class, AABB2);
            for (EntityItem entityItem : entityItemList)
            {
                if(InventoryUtils.canAddToSlot(iItemHandler,entityItem.getItem()))
                {
                    InventoryUtils.addItemToSlot(iItemHandler,entityItem.getItem());
                    entityItem.setDead();
                    isRun = true;
                }else
                    {
                    isRun = false;
                }
            }
            isRun = Check(world,this.pos);
            if(isRun)
            {
                AxisAlignedBB AABB = new AxisAlignedBB(initPos, new BlockPos(initPos.getX() + 9, 0, initPos.getZ() + 9));
                entityItemList = world.getEntitiesWithinAABB(EntityItem.class, AABB);

                for (EntityItem entityItem : entityItemList)
                {
                    double ex = this.pos.getX() - entityItem.posX + 0.5F;
                    double ey = this.pos.getY() - entityItem.posY + 0.5F;
                    double ez = this.pos.getZ() - entityItem.posZ + 0.5F;
                    while (ex > 0.5 || ex < -0.5 || ey > 0.5 || ey < -0.5 || ez > 0.5 || ez < -0.5)
                    {
                        ex = ex / 2;
                        ey = ey / 2;
                        ez = ez / 2;
                    }
                    entityItem.motionX = ex;
                    entityItem.motionY = ey;
                    entityItem.motionZ = ez;
                }
            }
        }else
            {
            isRun = false;
        }

        if(!world.isRemote&&isRun&&world.getTileEntity(pos)!=null&&world.getTileEntity(pos).hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN))
        {
            if(shoudDesBlock == null)
            {
                //shoudDesBlock = initPos;
                d:for(int y = 0;y+initPos.getY()>0;y--)
                {
                    for(int x = 0;x<=8;x++)
                    {
                        for(int z = 0;z<=8;z++)
                        {
                            BlockPos p = initPos.add(x,y,z);
                            Material material = world.getBlockState(p).getMaterial();
                            if(material!=Material.AIR&&material!=Material.LAVA&&material!=Material.WATER)
                            {
                                float hardness = world.getBlockState(p).getBlockHardness(world,p);
                                if(hardness!=-1)
                                {
                                    shoudDesBlock = p;
                                    break d;
                                }
                            }
                        }
                    }
                }

            }
            if(shoudDesBlock!=null&&isRun)
            {
                IBlockState state = world.getBlockState(shoudDesBlock);
                float hardness = state.getBlockHardness(world,shoudDesBlock);
                if(hardness==-1.0F)return;
                long target = (long) Math.floor(16 * 1_000_000L * ((hardness + 1) * 2) * 1);
                progress += getDesSpeed();
                if(progress>=target)
                {
                    progress=0;
                    //消除所有裂痕并破坏掉
                    //于BC的源码有变动
                    world.sendBlockBreakProgress(shoudDesBlock.hashCode(),shoudDesBlock,-1);
                    world.playEvent(2001, shoudDesBlock, Block.getStateId(world.getBlockState(shoudDesBlock)));
                    Block block1 = world.getBlockState(shoudDesBlock).getBlock();
                    List<ItemStack> itemStackList = block1.getDrops(world,shoudDesBlock,world.getBlockState(shoudDesBlock),0);
                    world.setBlockState(shoudDesBlock, Blocks.AIR.getDefaultState(),3);

                    for (ItemStack stack : itemStackList)
                    {
                        if(stack.getItem().getTranslationKey().indexOf("shulkerBox")==-1)
                        {
                            EntityItem entityItem = new EntityItem(world,shoudDesBlock.getX(),shoudDesBlock.getY(),shoudDesBlock.getZ(),stack);
                            entityItem.attackEntityFrom(DamageSource.LAVA, -Integer.MAX_VALUE + 10);
                            world.spawnEntity(entityItem);
                        }

                    }
                    //world.destroyBlock(shoudDesBlock,true);
                    shoudDesBlock = null;
                }else
                {
                    //修改方块的裂痕进程 最后一个参数范围0-9
                    world.sendBlockBreakProgress(shoudDesBlock.hashCode(),shoudDesBlock,(int)((progress*9)/target));
                }
            }

        }
        AxisAlignedBB AABB = new AxisAlignedBB(initPos, new BlockPos(initPos.getX() + 9, 0, initPos.getZ() + 9));
        List<EntityItem> entityItemList = world.getEntitiesWithinAABB(EntityItem.class,AABB);
        for (EntityItem entityItem : entityItemList)
        {
            //entityItem.setFire(0);
        }


    }
    public boolean Check(World world,BlockPos pos)
    {
        Block block1 = world.getBlockState(pos.add(-4,0,-4)).getBlock();
        Block block2 = world.getBlockState(pos.add(-4,0,4)).getBlock();
        Block block3 = world.getBlockState(pos.add(4,0,4)).getBlock();
        Block block4 = world.getBlockState(pos.add(4,0,-4)).getBlock();

        if(block1== UCEBlock.ELECTRIC_CIRCUIT_BLOCK&&block2== UCEBlock.ELECTRIC_CIRCUIT_BLOCK&&block3== UCEBlock.ELECTRIC_CIRCUIT_BLOCK&&block4== UCEBlock.ELECTRIC_CIRCUIT_BLOCK)
        {
            return true;
        }else
            {
            return false;
        }
    }
    public int getDesSpeed()
    {
        return 10000000;
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        return super.getRenderBoundingBox().grow(4,0,4);
    }
}
