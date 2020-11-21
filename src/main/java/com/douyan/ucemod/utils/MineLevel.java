package com.douyan.ucemod.utils;

public enum MineLevel {
    DIRT(1.5F),STONE(3),ORE(5),OBSIDIAN(51);
    float hardness;
     MineLevel(float hardness){
        this.hardness=hardness;
    }
}
