/**
 * Creative by DouYan on 2020-01-15 16:23
 */
package com.douyan.ucemod.registry;

import com.douyan.ucemod.UCEmod;
import com.douyan.ucemod.block.tile.EntityEngineerWorktable;
import com.douyan.ucemod.block.tile.TileEntityCoreBlock;
import com.douyan.ucemod.block.tile.TileEntityMiningMachine;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UCETileEntityLoader
{

    public UCETileEntityLoader()
    {
        registerTileEntity(TileEntityMiningMachine.class,"mining_machine");
        registerTileEntity(TileEntityCoreBlock.class,"core_block");
        registerTileEntity(EntityEngineerWorktable.class,"log_xz");
    }
    public void registerTileEntity(Class<? extends TileEntity> tileEntityClass,String id)
    {
        GameRegistry.registerTileEntity(tileEntityClass, UCEmod.MODID+":"+id);
    }
}
