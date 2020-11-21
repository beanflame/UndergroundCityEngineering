package com.douyan.ucemod.item;

import com.douyan.ucemod.gui.UCECreativeTab;
import com.douyan.ucemod.utils.MineLevel;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemExplorer extends Item {
    public int fuel;
    public MineLevel mine_level;
    public ItemExplorer(){
        setCreativeTab(UCECreativeTab.UCETAB)
                .setTranslationKey("uce.explorer")
                .setRegistryName("uce:explorer");
    }
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        ItemStack itemstack = player.getHeldItem(hand);

        if (player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            if (worldIn.isRemote)
            {
                return EnumActionResult.SUCCESS;
            }
            else
            {
                MachineExplorer ship = new MachineExplorer(worldIn);
                ship.setLocationAndAngles(player.posX,player.posY,player.posZ,player.rotationYaw,player.rotationPitch);
                worldIn.spawnEntity(ship);
                itemstack.shrink(1);
                return EnumActionResult.SUCCESS;
            }
        }
        else
        {
            return EnumActionResult.FAIL;
        }
    }

}
