package com.beanflame.ucemod.registry;

//import com.beanflame.ucemod.item.ItemExplorer;
//import com.beanflame.ucemod.item.ItemBucketWheel;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Creative by beanflame on 2020/1/25
 */

@Mod.EventBusSubscriber
public class UCEItem
{
	//public static final  ItemBucketWheel BUCKET_WHEEL = new ItemBucketWheel();
	//public static final ItemExplorer BASIC_MINING_SHIP=new ItemExplorer();
	
	@SubscribeEvent
	public void registerItemBlocks(RegistryEvent.Register<Item> event)
	{
		//event.getRegistry().register(BUCKET_WHEEL);
		//event.getRegistry().register(BASIC_MINING_SHIP);
	}
	


	
}
