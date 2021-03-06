package com.sdj64.highlands.biome;

import com.sdj64.highlands.generator.HighlandsGenerators;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenTropDryForest extends BiomeGenBaseHighlands
{

    public BiomeGenTropDryForest(int par1)
    {
        super(par1);

        theBiomeDecorator.treesPerChunk = 12;
        theBiomeDecorator.grassPerChunk = 10;
        theBiomeDecorator.flowersPerChunk = 1;

        minHeight = 0.2F;
        maxHeight = 0.3F;
        temperature = 1.1F;
        rainfall = 0.3F;

    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random)
    {
        if (par1Random.nextInt(3) == 0)
            return HighlandsGenerators.aspenGen;
        else if (par1Random.nextInt(2) == 0)
            return this.worldGeneratorTrees;
        else return HighlandsGenerators.shrub2Gen;
    }

    public void decorate(World world, Random random, BlockPos pos)
    {
        super.decorate(world, random, pos);

        genStandardOre(2, HighlandsGenerators.hlsand, 0, 72, world, random, pos);
        genStandardOre(theBiomeDecorator.chunkProviderSettings.goldCount / 2, theBiomeDecorator.goldGen, theBiomeDecorator.chunkProviderSettings.goldMinHeight, theBiomeDecorator.chunkProviderSettings.goldMaxHeight, world, random, pos);
    }
}
