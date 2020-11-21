package com.beanflame.ucemod;

import com.beanflame.ucemod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Creative by beanflame on 2020/1/25
 */

@Mod(modid = UCEmod.MODID, name = UCEmod.NAME, version = UCEmod.VERSION)
public class UCEmod
{
	@SidedProxy(clientSide = "com.beanflame.ucemod.proxy.ClientProxy", serverSide = "com.beanflame.ucemod.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static final String MODID = "underground_city_engineering";		//underground_city_engineering
	public static final String NAME = "Underground City Engineering";
	public static final String VERSION = "1.0.0";
	
	@Instance(UCEmod.MODID)
	public static UCEmod instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		instance = this;
		proxy.preInit(event);
	}
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
}
