package com.sdj64.highlands.biome;

import com.sdj64.highlands.generator.HighlandsGenerators;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;

import java.util.Random;

public class BiomeGenGreyMountains extends BiomeGenBaseHighlands
{

    private static final WorldGenBlockBlob blockBlob = new WorldGenBlockBlob(Blocks.cobblestone, 0);

    public BiomeGenGreyMountains(int par1)
    {
        super(par1);

        //this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));

        theBiomeDecorator.treesPerChunk = 0;
        theBiomeDecorator.grassPerChunk = 8;
        theBiomeDecorator.flowersPerChunk = 0;

        this.minHeight = 3.0F;
        this.maxHeight = 3.5F;
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
        return 0xEEC978;
    }

    public void decorate(World world, Random random, BlockPos pos)
    {
        super.decorate(world, random, pos);

        int i = random.nextInt(3) + 1;
        int j;
        int k;
        int l;
        for (j = 0; j < i; ++j)
        {
            k = random.nextInt(16) + 8;
            l = random.nextInt(16) + 8;
            BlockPos blockpos1 = world.getHorizon(pos.add(k, 0, l));
            blockBlob.generate(world, random, blockpos1);
        }

        genStandardOre(theBiomeDecorator.chunkProviderSettings.ironCount * 3 / 4, theBiomeDecorator.ironGen, theBiomeDecorator.chunkProviderSettings.ironMinHeight, theBiomeDecorator.chunkProviderSettings.ironMaxHeight * 3 / 2, world, random, pos);
    }
}




