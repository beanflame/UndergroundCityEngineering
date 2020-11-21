package com.douyan.ucemod.registry;

import com.douyan.ucemod.block.tile.TileEntityCoreBlock;
import com.douyan.ucemod.render.EntityRenderFactory;
import com.douyan.ucemod.render.entity.RenderBasicMiningShip;
import com.douyan.ucemod.render.tesr.TESRCoreBlock;
import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.swing.text.html.parser.Entity;

@SideOnly(Side.CLIENT)
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

         registerEntityRender(MachineExplorer.class, RenderBasicMiningShip.class);
    }

    private static <T extends Entity> void registerEntityRender(Class<? extends net.minecraft.entity.Entity> entityClass, Class<? extends Render> render)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory(render));
    }
}
