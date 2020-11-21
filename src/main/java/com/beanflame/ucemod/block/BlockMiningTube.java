package com.beanflame.ucemod.block;

import java.util.Random;

import com.beanflame.ucemod.UCEmod;
import com.beanflame.ucemod.gui.UCECreativeTab;

import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * Creative by beanflame on 2020-01-15 16:23
 */

public class BlockMiningTube extends Block
{
	protected static final AxisAlignedBB MINING_TUBE_AABB = new AxisAlignedBB(4 /16D, 0 /16D, 4 /16D, 12 /16D, 16 /16D, 12 /16D);
	
	public BlockMiningTube()
    {
        super(Material.GLASS);
        setCreativeTab(UCECreativeTab.UCETAB);
        setTranslationKey("uce.mining_tube");
        setRegistryName(UCEmod.MODID, "mining_tube");
    }
	
	
	
	//Block Damage Event
	
 /*
	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state)
    {
		System.out.println("破坏方块！");
    }*/
	
	
	
	
	
	
	
	
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	//---------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		 return MINING_TUBE_AABB;
    }
	
	
	//---------------------------------------------------
	

	
	
	
	@Override
	public int quantityDropped(Random random)
    {
        return 0;
    }
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.AIR;
    }
	
	@Override
	public EnumPushReaction getPushReaction(IBlockState state)
    {
        return EnumPushReaction.BLOCK;
    }


	@Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
}
