package com.sdj64.highlands.generator;

import java.util.Random;

import com.sdj64.highlands.HighlandsGenerators;
import com.sdj64.highlands.HighlandsMod;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.Event;

public class GenerateTrees implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.getDimensionId() == 0){
			int locX = chunkX*16 + random.nextInt(16);
			int locZ = chunkZ*16 + random.nextInt(16);
			BlockPos pos = new BlockPos(locX, 1, locZ);
			BlockPos pos2 = world.getTopSolidOrLiquidBlock(pos);
			
			BiomeGenBase biome = world.getBiomeGenForCoords(pos);
			
			if(biome.biomeID == BiomeGenBase.desert.biomeID+128 && random.nextInt(4) == 1){
				HighlandsGenerators.palmGen.generate(world, random, pos2);
			}
			if(biome.equals(BiomeGenBase.plains) && random.nextInt(6) == 1){
				HighlandsGenerators.poplarGen.generate(world, random, pos2);
			}
			if(biome.equals(BiomeGenBase.savanna) && random.nextInt(3) == 1){
				HighlandsGenerators.ashGen.generate(world, random, pos2);
			}
			if(biome.equals(BiomeGenBase.jungleEdge)){
				HighlandsGenerators.eucalyptusGen.generate(world, random, pos2);
			}
			
			//System.out.println("Generating Trees!");
			
			//MoreTreesMod.ashTreeGen.generate(world, random, pos2);
		}
	}

}
