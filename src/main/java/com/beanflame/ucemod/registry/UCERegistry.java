package com.beanflame.ucemod.registry;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;

/**
 * Creative by beanflame on 2020/1/25
 * 豆焰 / 青蛙
 */

public class UCERegistry
{
	//豆焰和青蛙的reg方法,就是EVENT_BUS.register
    public static void regListener(Object obj)
    {
        MinecraftForge.EVENT_BUS.register(obj);
    }
    public static void regTileRender(Class tileEntityClass, TileEntitySpecialRenderer specialRenderer){
        ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass,specialRenderer);
    }
}
