package com.beanflame.ucemod.gui;

import com.beanflame.ucemod.UCEmod;
import com.beanflame.ucemod.registry.UCEBlock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Creative by beanflame on 2020-01-15 16:23
 */

public class UCECreativeTab
{
	public static final CreativeTabs UCETAB = new CreativeTabs(UCEmod.MODID + ".uce" + ".name")
	{
		@SideOnly(Side.CLIENT)
		public ItemStack createIcon()
		{
			return new ItemStack(Item.getItemFromBlock(UCEBlock.MINING_MACHINE));

		}
	};
	
}
