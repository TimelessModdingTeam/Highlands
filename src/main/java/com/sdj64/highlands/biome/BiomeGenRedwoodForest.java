package com.sdj64.highlands.biome;

import java.util.Random;

import com.sdj64.highlands.HighlandsGenerators;
import com.sdj64.highlands.HighlandsMod;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenRedwoodForest extends BiomeGenBaseHighlands
{

	public BiomeGenRedwoodForest(int par1)
    {
        super(par1);
        
        theBiomeDecorator.treesPerChunk = 8;
        theBiomeDecorator.grassPerChunk = 5;
        theBiomeDecorator.flowersPerChunk = 0;
	    
        minHeight = 0.3F;
        maxHeight = 0.3F;
        temperature = 0.6F;
        rainfall = 0.2F;
        
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random)
    {
    	if(par1Random.nextInt(3) == 0)
    		return HighlandsGenerators.redwoodGen;
    	else if(par1Random.nextInt(2) == 0)
    		return HighlandsGenerators.firGen;
    	else return HighlandsGenerators.shrub2Gen;
    }

}
