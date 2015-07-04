package com.sdj64.highlands.biome;

import java.util.Random;

import com.sdj64.highlands.HighlandsMod;
import com.sdj64.highlands.generator.HighlandsGenerators;

import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenTallGrass;

public class BiomeGenMeadow extends BiomeGenBaseHighlands
{

	public BiomeGenMeadow(int par1)
    {
        super(par1);
        
        spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));
        
        theBiomeDecorator.treesPerChunk = 0;
        theBiomeDecorator.grassPerChunk = 15;
        theBiomeDecorator.flowersPerChunk = 8;
        
        theBiomeDecorator.generateLakes = false;
        
        minHeight = 0.1F;
        maxHeight = 0.12F;
        
        temperature = 0.6F;
        rainfall = 0.8F;
    }
    
    public WorldGenAbstractTree genBigTreeChance(Random par1Random)
    {
        return HighlandsGenerators.poplarGen;
    }

    public void decorate(World world, Random random, BlockPos pos)
    {
        super.decorate(world, random, pos);
        
        genStandardOre(10, HighlandsGenerators.hlwater, 10, 64, world, random, pos);
        genStandardOre(theBiomeDecorator.chunkProviderSettings.lapisCount/2, theBiomeDecorator.lapisGen, 0, 32, world, random, pos);
    }
}
