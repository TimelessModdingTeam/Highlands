package com.sdj64.highlands.biome;

import com.sdj64.highlands.generator.HighlandsGenerators;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMelon;
import net.minecraft.world.gen.feature.WorldGenVines;

import java.util.Random;

public class BiomeGenTropicalIslands extends BiomeGenBaseHighlands
{

    public BiomeGenTropicalIslands(int par1)
    {
        super(par1);

        theBiomeDecorator.treesPerChunk = 5;
        theBiomeDecorator.grassPerChunk = 8;
        theBiomeDecorator.flowersPerChunk = 5;

        this.minHeight = -0.2F;
        this.maxHeight = 0.2F;

        this.temperature = 0.95F;
        this.rainfall = 1.2F;
    }

    public WorldGenAbstractTree genBigTreeChance(Random random)
    {
        return HighlandsGenerators.palmGen;
    }

    public void decorate(World world, Random random, BlockPos pos)
    {
        super.decorate(world, random, pos);

        genStandardOre(theBiomeDecorator.chunkProviderSettings.diamondCount / 2, theBiomeDecorator.diamondGen, theBiomeDecorator.chunkProviderSettings.diamondMinHeight, theBiomeDecorator.chunkProviderSettings.diamondMaxHeight, world, random, pos);
        genStandardOre(5, HighlandsGenerators.hlsand, 0, 72, world, random, pos);
        genStandardOre(10, HighlandsGenerators.hlwater, 10, 64, world, random, pos);

        int i = random.nextInt(16) + 8;
        int j = random.nextInt(16) + 8;
        int height = world.getHorizon(pos.add(i, 0, j)).getY() * 2; // could == 0, which crashes nextInt
        if (height < 1) height = 1;
        int k = random.nextInt(height);
        (new WorldGenMelon()).generate(world, random, pos.add(i, k, j));
        WorldGenVines worldgenvines = new WorldGenVines();

        for (j = 0; j < 50; ++j)
        {
            k = random.nextInt(16) + 8;
            boolean flag = true;
            int l = random.nextInt(16) + 8;
            worldgenvines.generate(world, random, pos.add(k, 128, l));
        }
    }

}
