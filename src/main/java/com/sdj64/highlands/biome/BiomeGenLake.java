package com.sdj64.highlands.biome;

import com.sdj64.highlands.generator.HighlandsGenerators;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenLake extends BiomeGenBaseHighlands
{

    public BiomeGenLake(int par1)
    {
        super(par1);

        theBiomeDecorator.treesPerChunk = 3;
        theBiomeDecorator.grassPerChunk = 12;
        theBiomeDecorator.flowersPerChunk = 0;

        this.minHeight = -0.5F;
        this.maxHeight = 0.05F;
        this.temperature = 0.8F;
        this.rainfall = 0.8F;

        this.spawnableCreatureList.clear();
    }

    public WorldGenAbstractTree genBigTreeChance(Random random)
    {
        return HighlandsGenerators.poplarGen;
    }
}
