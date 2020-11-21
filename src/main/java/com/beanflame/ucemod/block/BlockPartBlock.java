package com.beanflame.ucemod.block;

import com.beanflame.ucemod.UCEmod;
import com.beanflame.ucemod.gui.UCECreativeTab;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;

/**
 * Creative by beanflame on 2020-01-15 16:23
 */

public class BlockPartBlock extends BlockDirectional
{
    public BlockPartBlock()
    {
        super(Material.ROCK);
        setCreativeTab(UCECreativeTab.UCETAB);
        
        setTranslationKey("uce.part_block");
        setRegistryName(UCEmod.MODID, "part_block");
    }

}
