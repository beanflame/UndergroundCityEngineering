package com.beanflame.ucemod.registry;

import com.beanflame.ucemod.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Creative by beanflame on 2020/1/25
 */

@Mod.EventBusSubscriber
public class UCEBlock
{
	public static final Block MINING_MACHINE = new BlockMiningMachine();		//采矿机

	public static final Block MINING_PIPE = new BlockMiningPipe();				//采矿管
	
	public static final Block CORE_BLOCK = new BlockCoreBlock();				//核心方块

	public static final Block ELECTRIC_CIRCUIT_BLOCK = new BlockElectricCircuitBlock();		//电路块



	public static final Block MACHINERY_BLOCK = new BlockMachineryBlock();		//机械块
	public static final Block MACHINERY_CASING= new BlockMachineryCasing();		//机械外壳


	private RegistryEvent.Register<Block> blockRegister;


	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event)
	{
		blockRegister=event;
		// 注册方块

		regBlock(UCEBlock.MINING_MACHINE);				//采矿机
		regBlock(UCEBlock.MINING_PIPE);					//采矿管


		regBlock(UCEBlock.CORE_BLOCK);					//核心方块
		regBlock(UCEBlock.ELECTRIC_CIRCUIT_BLOCK);		//电路块

		regBlock(UCEBlock.MACHINERY_BLOCK);				//机械方块

		regBlock(UCEBlock.MACHINERY_CASING);			//机械外壳





	}


	private void regBlock(Block block){
		blockRegister.getRegistry().register(block);
	}
	@SubscribeEvent
	public void registerItemBlocks(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new ItemBlock(UCEBlock.MINING_MACHINE).setRegistryName(UCEBlock.MINING_MACHINE.getRegistryName()));
		event.getRegistry().register(new ItemBlock(UCEBlock.MINING_PIPE).setRegistryName(UCEBlock.MINING_PIPE.getRegistryName()));
		
		event.getRegistry().register(new ItemBlock(UCEBlock.CORE_BLOCK).setRegistryName(UCEBlock.CORE_BLOCK.getRegistryName()));
		event.getRegistry().register(new ItemBlock(UCEBlock.ELECTRIC_CIRCUIT_BLOCK).setRegistryName(UCEBlock.ELECTRIC_CIRCUIT_BLOCK.getRegistryName()));

		event.getRegistry().register(new ItemBlock(UCEBlock.MACHINERY_BLOCK).setRegistryName(UCEBlock.MACHINERY_BLOCK.getRegistryName()));


		event.getRegistry().register(new ItemBlock(UCEBlock.MACHINERY_CASING).setRegistryName(UCEBlock.MACHINERY_CASING.getRegistryName()));

	}

}
