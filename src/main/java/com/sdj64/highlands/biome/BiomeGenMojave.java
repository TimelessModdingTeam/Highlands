package com.sdj64.highlands.biome;

import java.util.Random;
import java.util.Random;

import com.sdj64.highlands.HighlandsGenerators;
import com.sdj64.highlands.HighlandsMod;

import net.minecraft.init.Blocks;
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
        
        this.topBlock = Blocks.sand.getStateFromMeta(1);
        this.fillerBlock = Blocks.sand.getStateFromMeta(1);
        
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

    /*
    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
    	biomedec.genOreHighlandsNoCheck(par1World, par2Random, par3, par4, 2, biomedec.HLdirt, 62, 80);
        biomedec.decorate(par1World, par2Random, par3, par4);
        biomedec.genOreHighlands(par1World, par2Random, par3, par4, 2, biomedec.goldGen, 0, 32);
        biomedec.genOreHighlands(par1World, par2Random, par3, par4, 10, biomedec.HLsand, 0, 64);
    }
    */
	    
}
