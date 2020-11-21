/**
 * Creative by DouYan on 2020-01-16 15:56
 */
package com.douyan.ucemod.proxy;


import com.douyan.ucemod.registry.UCEModelLoader;
import com.douyan.ucemod.registry.UCERegistry;
import com.douyan.ucemod.registry.UCERenderLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy extends CommonProxy
{

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        UCERegistry.regListener(new UCEModelLoader());
        UCERegistry.regListener(new UCERenderLoader());
    }
    @Override
    public void init(FMLInitializationEvent event)
    {
    super.init(event);
    }


}
