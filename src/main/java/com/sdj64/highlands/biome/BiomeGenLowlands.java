package com.sdj64.highlands.biome;

import java.util.Random;

import com.sdj64.highlands.HighlandsGenerators;
import com.sdj64.highlands.HighlandsMod;

import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenLowlands extends BiomeGenBaseHighlands
{

	public BiomeGenLowlands(int par1)
    {
        super(par1);
        
        theBiomeDecorator.treesPerChunk = 2;
        theBiomeDecorator.grassPerChunk = 4;
        theBiomeDecorator.flowersPerChunk = 0;

        theBiomeDecorator.generateLakes = false;
        
        minHeight = -0.1F;
        maxHeight = 0.25F;
        temperature = 0.5F;
        rainfall = 1.2F;
        
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random)
    {
        return (par1Random.nextInt(8) == 0 ?
        		HighlandsGenerators.shrub2Gen : par1Random.nextInt(4) != 0 ?
        		this.worldGeneratorTrees : HighlandsGenerators.firGen);
    }

    public void decorate(World world, Random random, BlockPos pos)
    {
        super.decorate(world, random, pos);
        
        genStandardOre(10, HighlandsGenerators.hlwater, 10, 64, world, random, pos);
        genStandardOre(theBiomeDecorator.chunkProviderSettings.diamondCount/2, theBiomeDecorator.diamondGen, theBiomeDecorator.chunkProviderSettings.diamondMinHeight, theBiomeDecorator.chunkProviderSettings.diamondMaxHeight, world, random, pos);
    }
}
