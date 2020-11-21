package com.douyan.ucemod.registry;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber
public class UCEModelLoader
{
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event)
    {
    	registerItemModels();
    }
    
    
    public void registerItemModels()
    {
    	registerItemModel(Item.getItemFromBlock(UCEBlock.ENGINEER_WORKTABLE));
    	
        registerItemModel(Item.getItemFromBlock(UCEBlock.MINING_MACHINE));
        registerItemModel(Item.getItemFromBlock(UCEBlock.MINING_TUBE));
        
        registerItemModel(Item.getItemFromBlock(UCEBlock.CORE_BLOCK));
        registerItemModel(Item.getItemFromBlock(UCEBlock.PART_BLOCK));
        
        registerItemModel(UCEItem.BUCKET_WHEEL);
    }
    
    // 注册普通的物品的模型
    private void registerItemModel(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
    private void registerEntityModel()
    {

    }

}

