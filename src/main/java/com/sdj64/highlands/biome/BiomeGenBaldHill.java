package com.sdj64.highlands.biome;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenBaldHill extends BiomeGenBaseHighlands
{

    public BiomeGenBaldHill(int par1)
    {
        super(par1);

        theBiomeDecorator.treesPerChunk = 0;
        theBiomeDecorator.grassPerChunk = 4;
        theBiomeDecorator.flowersPerChunk = 3;

        this.minHeight = 1.1F;
        this.maxHeight = 1.1F;
        this.temperature = 0.5F;
        this.rainfall = 0.7F;

    }

    public WorldGenAbstractTree genBigTreeChance(Random random)
    {
        return (random.nextInt(10) == 0 ? this.worldGeneratorBigTree : this.worldGeneratorTrees);
    }

}

