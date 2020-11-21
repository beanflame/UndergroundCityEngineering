package com.beanflame.ucemod.block;

import com.beanflame.ucemod.UCEmod;
import com.beanflame.ucemod.block.tile.TileEntityCoreBlock;
import com.beanflame.ucemod.gui.UCECreativeTab;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Creative by beanflame on 2020-01-15 16:23
 */

public class BlockCoreBlock extends BlockDirectional
{
    public BlockCoreBlock()
    {
        super(Material.ROCK);
        setCreativeTab(UCECreativeTab.UCETAB);
       
        setTranslationKey("uce.core_block");
        setRegistryName(UCEmod.MODID, "core_block");
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityCoreBlock();
    }
	

}
