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
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeGenSteppe extends BiomeGenBaseHighlands
{

	public BiomeGenSteppe(int par1)
    {
        super(par1);
        
        this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));
        
        theBiomeDecorator.treesPerChunk = 0;
        theBiomeDecorator.grassPerChunk = 12;
        theBiomeDecorator.flowersPerChunk = 0;
        
        this.minHeight = 1.0F;
        this.maxHeight = 1.0F;
        this.temperature = 0.6F;
        this.rainfall = 0.1F;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random)
    {
        return (par1Random.nextInt(3) != 0 ? HighlandsGenerators.shrub2Gen : this.worldGeneratorTrees);
    }
    
    
    public int getModdedBiomeGrassColor(int original)
    {
        return 0xCCB978;
    }
    
    public void decorate(World world, Random random, BlockPos pos)
    {
        super.decorate(world, random, pos);
        
        genStandardOre(theBiomeDecorator.chunkProviderSettings.redstoneCount/2, theBiomeDecorator.redstoneGen, theBiomeDecorator.chunkProviderSettings.redstoneMinHeight, theBiomeDecorator.chunkProviderSettings.redstoneMaxHeight, world, random, pos);
    }
}




