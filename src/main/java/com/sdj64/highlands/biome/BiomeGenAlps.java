package com.sdj64.highlands.biome;

import java.util.List;
import java.util.Random;

import com.sdj64.highlands.HighlandsGenerators;
import com.sdj64.highlands.HighlandsMod;
import com.sdj64.highlands.generator.WorldGenTreeFir;

import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeGenAlps extends BiomeGenBaseHighlands{

	public BiomeGenAlps(int par1)
	{
	    super(par1);
	    
        theBiomeDecorator.treesPerChunk = 1;
        theBiomeDecorator.grassPerChunk = 0;
        theBiomeDecorator.flowersPerChunk = 0;
	    
	    this.spawnableCreatureList.clear();
	    this.topBlock = Blocks.snow.getDefaultState();
	    this.fillerBlock = Blocks.snow.getDefaultState();
	    
	    this.maxHeight = 0.8F;
	    this.minHeight = 0.4F;
	    this.temperature = 0.0F;
	    this.rainfall = 0.7F;
	        
	    this.setEnableSnow();
	}
	    
	public WorldGenAbstractTree genBigTreeChance(Random par1Random)
	{
	    return (par1Random.nextInt(5) == 0 ? HighlandsGenerators.firGen : HighlandsGenerators.shrubGen);
	}
	
	public void decorate(World world, Random random, BlockPos pos)
    {
        super.decorate(world, random, pos);
        
        genStandardOre(12, HighlandsGenerators.hlice, 32, 100);
        genStandardOre(theBiomeDecorator.chunkProviderSettings.ironCount/2, theBiomeDecorator.ironGen, theBiomeDecorator.chunkProviderSettings.ironMinHeight, theBiomeDecorator.chunkProviderSettings.ironMaxHeight);
        
        int i = 3 + random.nextInt(6);
        int j;
        int k;
        int l;

        for (j = 0; j < i; ++j)
        {
            k = random.nextInt(16);
            l = random.nextInt(28) + 4;
            int i1 = random.nextInt(16);
            BlockPos blockpos1 = pos.add(k, l, i1);

            if (world.getBlockState(blockpos1).getBlock().isReplaceableOreGen(world, blockpos1, net.minecraft.block.state.pattern.BlockHelper.forBlock(Blocks.stone)))
            {
                world.setBlockState(blockpos1, Blocks.emerald_ore.getDefaultState(), 2);
            }
        }
    }
	
	
    /*
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float par1)
    {
    	if(HighlandsMain.skyColorFlag)return 0xC6E3FF;
    	else return super.getSkyColorByTemp(par1);
    }
    */
    
    /*
    public void setSpawns(List hostile, List creature, List water){
    	this.spawnableMonsterList = hostile;
    	this.spawnableCreatureList = creature;
    	this.spawnableWaterCreatureList = water;
    }
    */
}
