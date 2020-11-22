package com.beanflame.ucemod.block;

import com.beanflame.ucemod.UCEmod;
import com.beanflame.ucemod.gui.UCECreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Creative by beanflame on 2020-11-21 16:55
 */

public class BlockMachineryBlock extends Block {

    //机械
    //机器方块
    //MachineBlock

    public BlockMachineryBlock()
    {
        super(Material.GLASS);
        setCreativeTab(UCECreativeTab.UCETAB);
        setTranslationKey(UCEmod.MODID + ".machinery_block");
        setRegistryName(UCEmod.MODID, "machinery_block");
    }
}
