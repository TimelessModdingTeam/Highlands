package com.sdj64.highlands.biome;

import java.util.Random;

import com.sdj64.highlands.HighlandsGenerators;
import com.sdj64.highlands.HighlandsMod;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenTallGrass;

public class BiomeGenHighlands extends BiomeGenBaseHighlands
{

	public BiomeGenHighlands(int par1)
	    {
	        super(par1);
	        
	        this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));
	        
	        theBiomeDecorator.treesPerChunk = 3;
	        theBiomeDecorator.grassPerChunk = 12;
	        theBiomeDecorator.flowersPerChunk = 6;
		    
	        minHeight = 0.3F;
	        maxHeight = 0.5F;
	        temperature = 0.6F;
	        rainfall = 0.2F;
	        
	    }

	    /**
	     * Gets a WorldGen appropriate for this biome.
	     */
	    public WorldGenAbstractTree genBigTreeChance(Random random)
	    {
	        return (random.nextInt(3) != 0 ? HighlandsGenerators.shrubGen : this.worldGeneratorTrees);
	    }
}
