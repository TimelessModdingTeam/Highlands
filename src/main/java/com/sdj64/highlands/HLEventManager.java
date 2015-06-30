package com.sdj64.highlands;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;
import net.minecraftforge.event.terraingen.WorldTypeEvent.InitBiomeGens;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.sdj64.highlands.generator.layer.GenLayerHighlands;

public class HLEventManager {
	
	@SubscribeEvent
	public void onDecorateTree(Decorate e)
	{
		if(e.type == Decorate.EventType.TREE){
			
			BiomeGenBase biome = e.world.getBiomeGenForCoords(e.pos);
			
			/*
			if(biome.equals(BiomeGenBase.forest) && e.rand.nextInt(18) == 1){
				e.setResult(Event.Result.DENY);
				HighlandsGenerators.ashGen.generate(e.world, e.rand, e.pos);
			}
			*/
			
			/*
			if(biome.equals(BiomeGenBase.forest) && e.rand.nextInt(20) == 1){
				e.setResult(Event.Result.DENY);
				HighlandsGenerators.greatOakGen.generate(e.world, e.rand, e.pos);
			}
			if(biome.equals(BiomeGenBase.forest) && e.rand.nextInt(7) == 1){
				e.setResult(Event.Result.DENY);
				new WorldGenBigTree(false).generate(e.world, e.rand, e.pos);
			}
			
			if(biome.equals(BiomeGenBase.birchForest) && e.rand.nextInt(12) == 1){
				e.setResult(Event.Result.DENY);
				HighlandsGenerators.poplarGen.generate(e.world, e.rand, e.pos);
			}
			*/
			if(biome.equals(BiomeGenBase.savanna) && e.rand.nextInt(3) != 1){
				e.setResult(Event.Result.DENY);
			}
		}
	}
	
	@SubscribeEvent
	public void onGenLayerInitiate(InitBiomeGens e)
	{
		e.newBiomeGens = GenLayerHighlands.initializeAllBiomeGenerators(e.seed, e.worldType, "");
	}
	
	// Method for testing trees, will maybe be used to grow Great Oak from a 2x2 oak sapling square.
	/*
	@SubscribeEvent
	public void onSapling(SaplingGrowTreeEvent e)
	{
		e.setResult(Event.Result.DENY);
		HighlandsGenerators.greatOakSapling.generate(e.world, e.rand, e.pos);
		
		System.out.println("Sapling Event!");
	}
	*/
	
}




