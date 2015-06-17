package com.sdj64.highlands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sdj64.highlands.generator.layer.GenLayerHillsHighlands;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.event.terraingen.WorldTypeEvent.InitBiomeGens;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HLEventManager {

	private Random rand = new Random();
	
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
			if(biome.equals(BiomeGenBase.forest) && e.rand.nextInt(25) == 1){
				e.setResult(Event.Result.DENY);
				HighlandsGenerators.greatOakGen.generate(e.world, e.rand, e.pos);
			}
			
			if(biome.equals(BiomeGenBase.birchForest) && e.rand.nextInt(12) == 1){
				e.setResult(Event.Result.DENY);
				HighlandsGenerators.poplarGen.generate(e.world, e.rand, e.pos);
			}
			
			//All the trees will be mine!
		}
	}
	
	@SubscribeEvent
	public void onGenLayerInitiate(InitBiomeGens e)
	{
		e.newBiomeGens = GenLayerHillsHighlands.initializeAllBiomeGenerators(e.seed, e.worldType, "");
	}
	
	/* Method for testing trees, will maybe be used for Great Oak.
	@SubscribeEvent
	public void onSapling(SaplingGrowTreeEvent e)
	{
		e.setResult(Event.Result.DENY);
		MoreTreesMod.ashGen.generate(e.world, e.rand, e.pos);
		
		System.out.println("Sapling Event!");
	}
	*/
	
}




