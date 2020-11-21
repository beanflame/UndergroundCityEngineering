/**
 * Creative by DouYan on 2020-01-16 15:56
 */
package com.douyan.ucemod.proxy;

import com.douyan.ucemod.registry.*;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
