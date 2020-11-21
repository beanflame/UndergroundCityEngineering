/**
 * Creative by DouYan on 2020-01-15 16:23
 */
package com.douyan.ucemod.registry;

import com.douyan.ucemod.block.BlockCoreBlock;
import com.douyan.ucemod.block.BlockEngineerWorktable;
import com.douyan.ucemod.block.BlockMiningMachine;
import com.douyan.ucemod.block.BlockMiningTube;
import com.douyan.ucemod.block.BlockPartBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class UCEBlock
{
	
	public static final Block ENGINEER_WORKTABLE = new BlockEngineerWorktable();
	
	public static final Block MINING_MACHINE = new BlockMiningMachine();
	public static final Block MINING_TUBE = new BlockMiningTube();
	
	public static final Block CORE_BLOCK = new BlockCoreBlock();
	public static final Block PART_BLOCK = new BlockPartBlock();
	
	

	private RegistryEvent.Register<Block> blockRegister;
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event)
	{
		blockRegister=event;
		// 注册方块
		
		regBlock(UCEBlock.ENGINEER_WORKTABLE);
		
		regBlock(UCEBlock.MINING_MACHINE);
		regBlock(UCEBlock.MINING_TUBE);
		
		regBlock(UCEBlock.CORE_BLOCK);
		regBlock(UCEBlock.PART_BLOCK);
		
		
		
		
		
	}
	private void regBlock(Block block){
		blockRegister.getRegistry().register(block);
	}
	@SubscribeEvent
	public void registerItemBlocks(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new ItemBlock(UCEBlock.ENGINEER_WORKTABLE).setRegistryName(UCEBlock.ENGINEER_WORKTABLE.getRegistryName()));
		
		event.getRegistry().register(new ItemBlock(UCEBlock.MINING_MACHINE).setRegistryName(UCEBlock.MINING_MACHINE.getRegistryName()));
		event.getRegistry().register(new ItemBlock(UCEBlock.MINING_TUBE).setRegistryName(UCEBlock.MINING_TUBE.getRegistryName()));
		
		event.getRegistry().register(new ItemBlock(UCEBlock.CORE_BLOCK).setRegistryName(UCEBlock.CORE_BLOCK.getRegistryName()));
		event.getRegistry().register(new ItemBlock(UCEBlock.PART_BLOCK).setRegistryName(UCEBlock.PART_BLOCK.getRegistryName()));
		
	}

}
