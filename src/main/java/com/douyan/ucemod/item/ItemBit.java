package com.douyan.ucemod.item;

import com.douyan.ucemod.gui.UCECreativeTab;
import net.minecraft.item.Item;

public class ItemBit extends Item {
    public ItemBit(){
        setCreativeTab(UCECreativeTab.UCETAB)
                .setTranslationKey("uce.basic_bit")
                .setRegistryName("uce:basic_mining_ship");
    }
}
