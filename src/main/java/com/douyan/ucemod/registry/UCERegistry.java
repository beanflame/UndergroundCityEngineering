package com.douyan.ucemod.registry;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;

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
