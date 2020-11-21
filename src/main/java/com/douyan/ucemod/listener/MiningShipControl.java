package com.douyan.ucemod.listener;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MiningShipControl {

    //玩家在飞船上控制
    @SubscribeEvent(priority= EventPriority.NORMAL, receiveCanceled=true)
    public void onKey(InputEvent.KeyInputEvent event){

    }
    
    
    
    //玩家尝试坐上飞船
    public void onPlayerInteract(PlayerInteractEvent event){

     //   event.getEntityPlayer()
    }
    
}
