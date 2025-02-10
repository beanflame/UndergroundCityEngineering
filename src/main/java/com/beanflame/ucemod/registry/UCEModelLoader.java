package com.beanflame.ucemod.registry;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Creative by beanflame on 2020/1/25
 */

// 2025/2/10 , "@SideOnly(Side.CLIENT)" Del.

// @SideOnly(Side.CLIENT)
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
        registerItemModel(Item.getItemFromBlock(UCEBlock.MINING_MACHINE));  //采矿机
        registerItemModel(Item.getItemFromBlock(UCEBlock.MINING_PIPE));     //采矿管道



        registerItemModel(Item.getItemFromBlock(UCEBlock.CORE_BLOCK));      //核心方块
        registerItemModel(Item.getItemFromBlock(UCEBlock.ELECTRIC_CIRCUIT_BLOCK));      //零件块


        registerItemModel(Item.getItemFromBlock(UCEBlock.MACHINERY_BLOCK));      //机械方块
        registerItemModel(Item.getItemFromBlock(UCEBlock.MACHINERY_CASING));      //机械外壳



       // registerItemModel(UCEItem.BUCKET_WHEEL);                            //斗轮 物品

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

