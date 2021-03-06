package com.beanflame.ucemod.registry;

import com.beanflame.ucemod.UCEmod;
import com.beanflame.ucemod.block.tile.TileEntityCoreBlock;
import com.beanflame.ucemod.block.tile.TileEntityMiningMachine;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Creative by beanflame on 2020/1/25
 * 豆焰 / 青蛙
 */

public class UCETileEntityLoader
{

    public UCETileEntityLoader()
    {
        registerTileEntity(TileEntityMiningMachine.class,"mining_machine");
        registerTileEntity(TileEntityCoreBlock.class,"core_block");
        //registerTileEntity(EntityEngineerWorktable.class,"log_xz");
    }
    public void registerTileEntity(Class<? extends TileEntity> tileEntityClass,String id)
    {
        GameRegistry.registerTileEntity(tileEntityClass, UCEmod.MODID+":"+id);
    }
}
