package com.beanflame.ucemod.registry;

import com.beanflame.ucemod.block.tile.TileEntityCoreBlock;
import com.beanflame.ucemod.render.EntityRenderFactory;
//import com.douyan.ucemod.render.entity.RenderBasicMiningShip;
import com.beanflame.ucemod.render.tesr.TESRCoreBlock;
import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.swing.text.html.parser.Entity;

/**
 * Creative by beanflame on 2020/1/25
 * 豆焰 / 青蛙
 */

// @SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber
public class UCERenderLoader
{
   public UCERenderLoader(){
   }
    @SubscribeEvent
    public void bindEntityRenderer(ModelRegistryEvent event)
    {
        registerTSERRenders();
        registerEntityRenders();
    }
    private void registerTSERRenders(){
    	//UCERegistry.regTileRender(TileEntityCoreBlock.class,new TESRCoreBlock());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCoreBlock.class,new TESRCoreBlock());
        
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMiningMachine.class,new TESRMiningMachine());
        //ClientRegistry.bindTileEntitySpecialRenderer(EntityEngineerWorktable.class,new TESREngineerWorktable());

    }

    public void registerEntityRenders(){

       //  registerEntityRender(MachineExplorer.class, RenderBasicMiningShip.class);
    }

    private static <T extends Entity> void registerEntityRender(Class<? extends net.minecraft.entity.Entity> entityClass, Class<? extends Render> render)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory(render));
    }
}
