package com.douyan.ucemod.entity;

import net.minecraft.world.World;

public class RobotMining extends AbstractRobot{
    public RobotMining(World worldIn) {
        super(worldIn);
    }

    @Override
    boolean canRide() {
        return false;
    }

    @Override
    boolean hasInv() {
        return false;
    }

}
