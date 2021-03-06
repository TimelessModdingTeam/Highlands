package com.sdj64.highlands.biome;

import com.sdj64.highlands.generator.HighlandsGenerators;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

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
        maxHeight = 0.3F;
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
        genStandardOre(theBiomeDecorator.chunkProviderSettings.diamondCount / 2, theBiomeDecorator.diamondGen, theBiomeDecorator.chunkProviderSettings.diamondMinHeight, theBiomeDecorator.chunkProviderSettings.diamondMaxHeight, world, random, pos);
    }
}
