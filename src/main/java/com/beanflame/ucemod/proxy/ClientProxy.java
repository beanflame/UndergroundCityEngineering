package com.beanflame.ucemod.proxy;

import com.beanflame.ucemod.registry.UCEModelLoader;
import com.beanflame.ucemod.registry.UCERegistry;
import com.beanflame.ucemod.registry.UCERenderLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Creative by beanflame on 2020/1/25
 */

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
