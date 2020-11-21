package com.beanflame.ucemod.block;

import com.beanflame.ucemod.UCEmod;
import com.beanflame.ucemod.gui.UCECreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMachineryCasing extends Block {

    //machinery_casing


    //Machinery_Casing

    //BlockMachineryCasing

    //机械外壳

    public BlockMachineryCasing()
    {
        super(Material.ROCK);
        setCreativeTab(UCECreativeTab.UCETAB);

        setTranslationKey(UCEmod.MODID+".machinery_casing");
        setRegistryName(UCEmod.MODID, "machinery_casing");
    }
}
