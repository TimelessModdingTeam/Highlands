package com.sdj64.highlands.biome;

import java.util.Random;

import com.sdj64.highlands.HighlandsGenerators;
import com.sdj64.highlands.HighlandsMod;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenTropHills extends BiomeGenBaseHighlands
{

	public BiomeGenTropHills(int par1)
    {
        super(par1);
        
        theBiomeDecorator.treesPerChunk = 12;
        theBiomeDecorator.grassPerChunk = 10;
        theBiomeDecorator.flowersPerChunk = 1;
	    
        minHeight = 0.4F;
        maxHeight = 0.6F;
        temperature = 0.95F;
        rainfall = 1.0F;
        
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random)
    {
        return HighlandsGenerators.eucalyptusGen;
    }
}
