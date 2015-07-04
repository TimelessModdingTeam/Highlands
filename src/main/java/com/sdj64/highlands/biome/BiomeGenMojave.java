package com.sdj64.highlands.biome;

import java.util.Random;
import java.util.Random;

import com.sdj64.highlands.HighlandsMod;
import com.sdj64.highlands.generator.HighlandsGenerators;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenMojave extends BiomeGenBaseHighlands
{

	public BiomeGenMojave(int par1){
		super(par1);
		
		theBiomeDecorator.treesPerChunk = 1;
        theBiomeDecorator.grassPerChunk = 5;
        theBiomeDecorator.flowersPerChunk = 0;
        
        this.spawnableCreatureList.clear();
        
        this.minHeight = 0.1F;
        this.maxHeight = 0.3F;
        this.temperature = 1.6F;
        this.rainfall = 0.1F;
    }

    
    public WorldGenAbstractTree genBigTreeChance(Random par1Random)
    {
        return (par1Random.nextInt(3) == 0 ? new WorldGenSavannaTree(false) : HighlandsGenerators.shrub2Gen);
    }
    
    public void decorate(World world, Random random, BlockPos pos)
    {
        genStandardOre(5, HighlandsGenerators.sandInDirt, 64, 90, world, random, pos);
    	
        super.decorate(world, random, pos);
        
        genStandardOre(5, HighlandsGenerators.hlsand, 0, 72, world, random, pos);
        genStandardOre(theBiomeDecorator.chunkProviderSettings.goldCount/2, theBiomeDecorator.goldGen, theBiomeDecorator.chunkProviderSettings.goldMinHeight, theBiomeDecorator.chunkProviderSettings.goldMaxHeight, world, random, pos);
    }
	    
}
