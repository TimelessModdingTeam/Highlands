package com.sdj64.highlands.generator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTreePoplar extends WorldGenMTreeBase
{

    public WorldGenTreePoplar(Block leafBlock, Block woodBlock,
			int leafBlockMeta, int woodBlockMeta, int minH, int maxH,
			boolean notify) {
		super(leafBlock, woodBlock, leafBlockMeta, woodBlockMeta, minH, maxH, notify);
	}

	public boolean generate(World wor, Random rand,  BlockPos pos)
    {
    	world = wor;
    	random = rand;
    	
    	int locX = pos.getX();
        int locY = pos.getY();
        int locZ = pos.getZ();
        
        if(!isLegalTreePosition(pos, false, false))return false;
        if(!isCubeClear(pos.down(-2), 1, 8))return false;
    	
        //generates the trunk
    	int treeHeight = minHeight + random.nextInt(maxHeight-minHeight);
    	for(int i = 0; i < treeHeight; i++){
    		setBlockLog(pos.down(-i), 0);
    	}
    	
    	//generates the leaves.
    	int h = locY + 3;
    	generateLeafLayerCircle(1, locX, locZ, h);
    	h++;
    	generateLeafLayerCircle(1.5, locX, locZ, h);
    	h++;
    	generateLeafLayerCircle(2, locX, locZ, h);
    	
    	for(h = h + 1; h < locY + treeHeight; h++){
    		generateLeafLayerCircleNoise(2.8, locX, locZ, h);
    	}
    	generateLeafLayerCircleNoise(2, locX, locZ, h);
    	h++;
    	generateLeafLayerCircleNoise(1.5, locX, locZ, h);
    	h++;
    	generateLeafLayerCircleNoise(1, locX, locZ, h);
    	h++;
    	setBlockLeaf(pos.down(locY - h));
    	h++;
    	setBlockLeaf(pos.down(locY - h));
    	return true;
    }
    
}













