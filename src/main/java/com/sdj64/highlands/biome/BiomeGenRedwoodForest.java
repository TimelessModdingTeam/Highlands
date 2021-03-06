package com.sdj64.highlands.biome;

import com.sdj64.highlands.generator.HighlandsGenerators;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenRedwoodForest extends BiomeGenBaseHighlands
{

    public BiomeGenRedwoodForest(int par1)
    {
        super(par1);

        theBiomeDecorator.treesPerChunk = 14;
        theBiomeDecorator.grassPerChunk = 5;
        theBiomeDecorator.flowersPerChunk = 0;

        minHeight = 0.5F;
        maxHeight = 0.7F;
        temperature = 0.6F;
        rainfall = 0.2F;

        this.topBlock = Blocks.dirt.getStateFromMeta(2);

    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random par1Random)
    {
        if (par1Random.nextInt(3) == 0)
            return HighlandsGenerators.redwoodGen;
        else if (par1Random.nextInt(2) == 0)
            return HighlandsGenerators.firGen;
        else return HighlandsGenerators.shrub2Gen;
    }

    public void decorate(World world, Random random, BlockPos pos)
    {
        super.decorate(world, random, pos);

        genStandardOre(theBiomeDecorator.chunkProviderSettings.redstoneCount / 2, theBiomeDecorator.redstoneGen, theBiomeDecorator.chunkProviderSettings.redstoneMinHeight, theBiomeDecorator.chunkProviderSettings.redstoneMaxHeight, world, random, pos);
    }

}
