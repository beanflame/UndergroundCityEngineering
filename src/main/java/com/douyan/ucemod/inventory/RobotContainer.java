package com.douyan.ucemod.inventory;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class RobotContainer extends InventoryBasic
{
    public RobotContainer(String title) {
        super(title, false, 48);
    }

}
