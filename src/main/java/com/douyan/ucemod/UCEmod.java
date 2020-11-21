/**
 * Creative by DouYan on 2020-01-16 15:56
 */
package com.douyan.ucemod;

import com.douyan.ucemod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = UCEmod.MODID, name = UCEmod.NAME, version = UCEmod.VERSION)
public class UCEmod
{
	@SidedProxy(clientSide = "com.douyan.ucemod.proxy.ClientProxy", serverSide = "com.douyan.ucemod.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static final String MODID = "uce";
	public static final String NAME = "Underground City Engineering";
	public static final String VERSION = "0.0.7";
	
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
