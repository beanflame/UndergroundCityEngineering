package com.douyan.ucemod.utils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

/**
 * Creative by GoldMain on 2020/1/14
 */
public class InventoryUtils
{
    public static int addItemToSlot(IItemHandler itemHandler, ItemStack stack)
    {
        for(int i = 0;i<itemHandler.getSlots();i++)
        {
            ItemStack stack1 = itemHandler.getStackInSlot(i);
            if(stack1==ItemStack.EMPTY)
            {
                System.out.println(stack.getItem().getRegistryName());
                itemHandler.insertItem(i,new ItemStack(stack.getItem(),stack.getCount(),stack.getMetadata()),false);
                stack.shrink(stack.getCount());
                break;
            }else if(stack1.getItem()==stack.getItem()&&stack1.getMetadata()==stack.getMetadata()&&stack1.getCount()<64)
            {
                int nu;
                if(stack.getCount()+stack1.getCount()>64)
                {
                    nu = 64-stack1.getCount();
                }else

                {
                    nu = stack.getCount();
                }
                stack.shrink(nu);
                stack1.grow(nu);
                if(stack.getCount()<=0)break;
            }

        }
        return stack.getCount();
    }
    public static boolean canAddToSlot(IItemHandler handler,ItemStack stack)
    {
        for (int i = 0; i < handler.getSlots(); i++)
        {
            ItemStack stack1 = handler.getStackInSlot(i);
            if (stack1.isEmpty())
            {
                return true;
            } else if (stack1.getItem() == stack.getItem() && stack.getMetadata() == stack1.getMetadata())
            {
                if (stack.getCount() + stack1.getCount() <= 64)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isFull(IItemHandler itemHandler)
    {
        for(int i = 0;i<itemHandler.getSlots();i++)
        {
            ItemStack stack = itemHandler.getStackInSlot(i);
                if(stack.isEmpty())
                {
                    return false;
                }
        }
        return true;
    }

}
