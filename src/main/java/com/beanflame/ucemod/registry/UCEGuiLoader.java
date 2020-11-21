package com.beanflame.ucemod.registry;

import com.beanflame.ucemod.UCEmod;
import com.beanflame.ucemod.block.tile.EntityEngineerWorktable;
import com.beanflame.ucemod.gui.UCEGuiContainer;
import com.beanflame.ucemod.inventory.UCEContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import javax.annotation.Nullable;

/**
 * Creative by GoldMain on 2020/1/25
 */

public class UCEGuiLoader
implements IGuiHandler {
    public static final int EngineerWorktable = 0;
    public static final int RobotInventory=1;
    public UCEGuiLoader(){
        NetworkRegistry.INSTANCE.registerGuiHandler(UCEmod.instance,this);
    }
    @Nullable
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        switch (id){
            case 0:{
               return new UCEContainer(player,(EntityEngineerWorktable) getTileEntity(world, x, y, z));

            }
            case 1:{
           //    return new RobotContainer(player);
            }
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return new UCEGuiContainer(new UCEContainer(player,(EntityEngineerWorktable) getTileEntity(world, x, y, z)));
    }
    public TileEntity getTileEntity(World world, int x, int y, int z) {
        return world.getTileEntity(new BlockPos(x, y, z));
    }
}
