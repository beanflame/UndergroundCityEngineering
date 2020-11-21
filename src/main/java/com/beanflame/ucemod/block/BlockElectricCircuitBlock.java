package com.beanflame.ucemod.block;

import com.beanflame.ucemod.UCEmod;
import com.beanflame.ucemod.gui.UCECreativeTab;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;

/**
 * Creative by beanflame on 2020-01-15 16:23
 */

public class BlockElectricCircuitBlock extends BlockDirectional
{
    //ElectricCircuitBlock
    //ELECTRIC_CIRCUIT_BLOCK
    //electric_circuit_block
    //电路方块
    //电路方块
    public BlockElectricCircuitBlock()
    {
        super(Material.ROCK);
        setCreativeTab(UCECreativeTab.UCETAB);
        
        setTranslationKey(UCEmod.MODID+".electric_circuit_block");
        setRegistryName(UCEmod.MODID, "electric_circuit_block");
    }

}
