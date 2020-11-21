package com.beanflame.ucemod.proxy;

import com.beanflame.ucemod.registry.*;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Creative by beanflame on 2020/1/25
 */

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        new UCEGuiLoader();
        new UCETileEntityLoader();
        UCERegistry.regListener(new UCEEntityLoader());
        
        UCERegistry.regListener(new UCEBlock());
        UCERegistry.regListener(new UCEItem());
        
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
    
}
