package com.sdj64.highlands.generator;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenBigTree;


public class WorldGenGreatOak extends WorldGenBigTree
{
    int field_175943_g;
    int field_175950_h;
    int leafDistanceLimit;
    double leafDensity;
	
    public WorldGenGreatOak(Block woodBlock, Block leafBlock, int woodBlockMeta, int leafBlockMeta, int minH, int maxH, boolean notify)
    {
        super(notify);
        leafDensity = 0.8D;
        field_175943_g = 2;
        field_175950_h = maxH;
        leafDistanceLimit = 4;
    }
}