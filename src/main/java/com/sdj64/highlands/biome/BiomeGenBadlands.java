package com.sdj64.highlands.biome;

import com.sdj64.highlands.generator.HighlandsGenerators;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeGenBadlands extends BiomeGenBaseHighlands
{

    public BiomeGenBadlands(int par1)
    {
        super(par1);

        theBiomeDecorator.treesPerChunk = 1;
        theBiomeDecorator.grassPerChunk = 6;
        theBiomeDecorator.flowersPerChunk = 1;

        this.maxHeight = 0.6F;
        this.minHeight = 0.3F;
        this.temperature = 0.6F;
        this.rainfall = 0.1F;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random random)
    {
        return (random.nextInt(3) != 0 ? HighlandsGenerators.shrub2Gen : this.worldGeneratorTrees);
    }

    public void decorate(World world, Random random, BlockPos pos)
    {
        genStandardOre(6, HighlandsGenerators.stoneInDirt, 64, 128, world, random, pos);

        super.decorate(world, random, pos);

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


    public int getModdedBiomeGrassColor(int original)
    {
        return 0xCCB978;
    }
    
    /*
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float par1)
    {
    	if(HighlandsMain.skyColorFlag)return 0xFFCC8E;
    	else return super.getSkyColorByTemp(par1);
    }
    */
}




