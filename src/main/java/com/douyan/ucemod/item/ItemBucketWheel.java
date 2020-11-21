package com.douyan.ucemod.item;

import com.douyan.ucemod.UCEmod;
import com.douyan.ucemod.gui.UCECreativeTab;
import net.minecraft.item.Item;


public class ItemBucketWheel extends Item
{
    public ItemBucketWheel()
    {
        setCreativeTab(UCECreativeTab.UCETAB);
        
        setTranslationKey("uce.bucket_wheel");
        
        setRegistryName(UCEmod.MODID, "bucket_wheel");
    }
    
}
