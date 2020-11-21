package com.beanflame.ucemod.item;

import com.beanflame.ucemod.UCEmod;
import com.beanflame.ucemod.gui.UCECreativeTab;
import net.minecraft.item.Item;

/**
 * Creative by beanflame on 2020/1/25
 */

public class ItemBucketWheel extends Item
{
    public ItemBucketWheel()
    {
        setCreativeTab(UCECreativeTab.UCETAB);
        
        setTranslationKey("uce.bucket_wheel");
        
        setRegistryName(UCEmod.MODID, "bucket_wheel");
    }
    
}
