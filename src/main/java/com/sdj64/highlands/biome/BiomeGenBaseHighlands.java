package com.sdj64.highlands.biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class BiomeGenBaseHighlands extends BiomeGenBase
{
	
	public ArrayList<BiomeGenBase> subBiomes;

	public BiomeGenBaseHighlands(int a){
		super(a);
		subBiomes = new ArrayList<BiomeGenBase>();
	}
	
	public void setSpawnLists(List monster, List creature, List waterCreature){
		this.spawnableCreatureList = creature;
		this.spawnableMonsterList = monster;
		this.spawnableWaterCreatureList = waterCreature;
	}
	
	/**
	 * because BiomeDecorator won't let me see it...
	 * @param blobsPerChunk
	 * @param oreGenerator
	 * @param minHeight
	 * @param maxHeight
	 */
    protected void genStandardOre(int blobsPerChunk, WorldGenerator oreGenerator, int minHeight, int maxHeight)
    {
        int l;

        if (maxHeight < minHeight)
        {
            l = minHeight;
            minHeight = maxHeight;
            maxHeight = l;
        }
        else if (maxHeight == minHeight)
        {
            if (minHeight < 255)
            {
                ++maxHeight;
            }
            else
            {
                --minHeight;
            }
        }

        for (l = 0; l < blobsPerChunk; ++l)
        {
            BlockPos blockpos = theBiomeDecorator.field_180294_c.add(theBiomeDecorator.randomGenerator.nextInt(16),
            		theBiomeDecorator.randomGenerator.nextInt(maxHeight - minHeight) + minHeight, theBiomeDecorator.randomGenerator.nextInt(16));
            oreGenerator.generate(theBiomeDecorator.currentWorld, theBiomeDecorator.randomGenerator, blockpos);
        }
    }
}
