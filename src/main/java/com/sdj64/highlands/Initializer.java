package com.sdj64.highlands;

import java.util.ArrayList;








import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerAddIsland;
import net.minecraft.world.gen.layer.GenLayerAddMushroomIsland;
import net.minecraft.world.gen.layer.GenLayerAddSnow;
import net.minecraft.world.gen.layer.GenLayerDeepOcean;
import net.minecraft.world.gen.layer.GenLayerEdge;
import net.minecraft.world.gen.layer.GenLayerFuzzyZoom;
import net.minecraft.world.gen.layer.GenLayerHills;
import net.minecraft.world.gen.layer.GenLayerIsland;
import net.minecraft.world.gen.layer.GenLayerRareBiome;
import net.minecraft.world.gen.layer.GenLayerRemoveTooMuchOcean;
import net.minecraft.world.gen.layer.GenLayerRiver;
import net.minecraft.world.gen.layer.GenLayerRiverInit;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.layer.GenLayerShore;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

import com.sdj64.highlands.biome.*;
import com.sdj64.highlands.generator.layer.GenLayerHillsHighlands;


public class Initializer
{
	private static String biomePrefix = "";
	
	public static void constructSettings()
	{
		
		HighlandsSettings.HighlandsBiomeSizeDefault = Config.biomeSize.getInt();
		HighlandsSettings.HighlandsBiomeSizeLB = Config.LBbiomeSize.getInt();
		
		HighlandsSettings.highlandsInDefaultFlag = Config.genDefault.getBoolean(false);
		
		HighlandsSettings.useOreGens = Config.genOre.getBoolean(true);
	}
	
	
	
	
	
	public static void constructBiomes()
	{
		
		biomePrefix = Config.biomePrefix.getBoolean(false) ? "Highlands_" : "";
		
		//main biomes
		
		if(Config.alpsGenerate.getBoolean(true))
		{
			HighlandsBiomes.alps = new BiomeGenAlps(Config.alpsID.getInt()).setBiomeName(biomePrefix+"Alps");
			HighlandsBiomes.biomesForHighlands.add(HighlandsBiomes.alps);
		}
		if(Config.badlandsGenerate.getBoolean(true))
		{
			HighlandsBiomes.badlands = new BiomeGenBadlands(Config.badlandsID.getInt()).setBiomeName(biomePrefix+"Badlands");
			HighlandsBiomes.biomesForHighlands.add(HighlandsBiomes.badlands);
		}
		if(Config.poplarHillsGenerate.getBoolean(true))
		{
			HighlandsBiomes.poplarHills = new BiomeGenPoplarHills(Config.poplarHillsID.getInt()).setBiomeName(biomePrefix+"Poplar Hills");
			HighlandsBiomes.biomesForHighlands.add(HighlandsBiomes.poplarHills);
		}
		if(Config.highlandsbGenerate.getBoolean(true))
		{
			HighlandsBiomes.highlandsBiome = new BiomeGenHighlands(Config.highlandsbID.getInt()).setBiomeName(biomePrefix+"Highlands");
			HighlandsBiomes.biomesForHighlands.add(HighlandsBiomes.highlandsBiome);
		}
		if(Config.lowlandsGenerate.getBoolean(true))
		{
			HighlandsBiomes.lowlands = new BiomeGenLowlands(Config.lowlandsID.getInt()).setBiomeName(biomePrefix+"Lowlands");
			HighlandsBiomes.biomesForHighlands.add(HighlandsBiomes.lowlands);
		}
		if(Config.meadowGenerate.getBoolean(true))
		{
			HighlandsBiomes.meadow = new BiomeGenMeadow(Config.meadowID.getInt()).setBiomeName(biomePrefix+"Meadow");
			HighlandsBiomes.biomesForHighlands.add(HighlandsBiomes.meadow);
		}
		if(Config.pinelandsGenerate.getBoolean(true))
		{
			HighlandsBiomes.pinelands = new BiomeGenPinelands(Config.pinelandsID.getInt()).setBiomeName(biomePrefix+"Pinelands");
			HighlandsBiomes.biomesForHighlands.add(HighlandsBiomes.pinelands);
		}
		if(Config.redwoodForestGenerate.getBoolean(true))
		{
			HighlandsBiomes.redwoodForest = new BiomeGenRedwoodForest(Config.redwoodForestID.getInt()).setBiomeName(biomePrefix+"Redwood Forest");
			HighlandsBiomes.biomesForHighlands.add(HighlandsBiomes.redwoodForest);
		}
		if(Config.mojaveGenerate.getBoolean(true))
		{
			HighlandsBiomes.mojave = new BiomeGenMojave(Config.mojaveID.getInt()).setBiomeName(biomePrefix+"Mojave");
			HighlandsBiomes.biomesForHighlands.add(HighlandsBiomes.mojave);
		}
		if(Config.steppeGenerate.getBoolean(true))
		{
			HighlandsBiomes.steppe = new BiomeGenSteppe(Config.steppeID.getInt()).setBiomeName(biomePrefix+"Steppe");
			HighlandsBiomes.biomesForHighlands.add(HighlandsBiomes.steppe);
		}
		if(Config.tropicalIslandsGenerate.getBoolean(true))
		{
			HighlandsBiomes.tropicalIslands = new BiomeGenTropicalIslands(Config.tropicalIslandsID.getInt()).setBiomeName(biomePrefix+"Tropical Islands");
			HighlandsBiomes.biomesForHighlands.add(HighlandsBiomes.tropicalIslands);
		}
		
		//sub-biomes
		if(Config.lakeGenerate.getBoolean(true))
		{
			HighlandsBiomes.lake = new BiomeGenLake(Config.lakeID.getInt()).setBiomeName(biomePrefix+"Lake");
			HighlandsBiomes.subBiomes.add(HighlandsBiomes.lake);
		}
		if(Config.baldHillGenerate.getBoolean(true))
		{
			HighlandsBiomes.baldHill = new BiomeGenBaldHill(Config.baldHillID.getInt()).setBiomeName(biomePrefix+"Bald Hill");
			HighlandsBiomes.subBiomes.add(HighlandsBiomes.baldHill);
		}
		
		//sets up default world biome array
		if(HighlandsSettings.highlandsInDefaultFlag)
		{
			
		}
	}
	
	
	//sets up sub-biome lists after all biomes are initialized.
	public static void setUpAllSubBiomes()
	{
		ArrayList<BiomeGenBase> enabledBiomes = new ArrayList<BiomeGenBase>();
		for(BiomeGenBase b : HighlandsBiomes.biomesForHighlands)enabledBiomes.add(b);
		for(BiomeGenBase b : HighlandsBiomes.subBiomes)enabledBiomes.add(b);
		
		addSubBiome(HighlandsBiomes.alps, BiomeGenBase.frozenRiver, enabledBiomes);
		addSubBiome(HighlandsBiomes.tropicalIslands, HighlandsBiomes.volcanoIsland, enabledBiomes);
		addSubBiome(HighlandsBiomes.autumnForest, HighlandsBiomes.baldHill, enabledBiomes);
		addSubBiome(HighlandsBiomes.autumnForest, HighlandsBiomes.lake, enabledBiomes);
		addSubBiome(HighlandsBiomes.poplarHills, HighlandsBiomes.meadow, enabledBiomes);
		addSubBiome(HighlandsBiomes.meadow, HighlandsBiomes.lake, enabledBiomes);
		addSubBiome(BiomeGenBase.forest, HighlandsBiomes.baldHill, enabledBiomes);
		addSubBiome(HighlandsBiomes.highlandsBiome, BiomeGenBase.forest, enabledBiomes);
		addSubBiome(HighlandsBiomes.lowlands, HighlandsBiomes.baldHill, enabledBiomes);
		addSubBiome(HighlandsBiomes.lowlands, HighlandsBiomes.lake, enabledBiomes);
		addSubBiome(HighlandsBiomes.pinelands, HighlandsBiomes.autumnForest, enabledBiomes);
		addSubBiome(HighlandsBiomes.redwoodForest, HighlandsBiomes.highlandsBiome, enabledBiomes);
		addSubBiome(HighlandsBiomes.redwoodForest, HighlandsBiomes.lake, enabledBiomes);
		addSubBiome(HighlandsBiomes.mojave, BiomeGenBase.mesa, enabledBiomes);
		addSubBiome(HighlandsBiomes.mojave, BiomeGenBase.savanna, enabledBiomes);
	}
	
	public static void addSubBiome(BiomeGenBase parent, BiomeGenBase sub, ArrayList<BiomeGenBase> list)
	{
		if(parent != null && sub != null && list.contains(parent) && list.contains(sub) && parent instanceof BiomeGenBaseHighlands){
			((BiomeGenBaseHighlands)parent).subBiomes.add(sub);
		}
	}
	
	public static void setUpBiomeManager()
	{
		for(int i = 0; i < HighlandsBiomes.biomesForHighlands.size(); i++)
		{
			BiomeGenBase hlb = HighlandsBiomes.biomesForHighlands.get(i);
			if(!(hlb == null))
			{
				BiomeEntry entry = new BiomeEntry(hlb, 10);
				BiomeType type = (hlb.temperature < 0.3 ? BiomeType.ICY : hlb.temperature < 0.5 ? BiomeType.COOL
						: hlb.temperature < 1.0 ? BiomeType.WARM : BiomeType.DESERT);
				BiomeManager.addBiome(type, entry);
				if(hlb.temperature >= 0.5 && hlb.temperature <= 0.7)
					BiomeManager.addBiome(BiomeType.COOL, entry);
				BiomeManager.addSpawnBiome(hlb);
				BiomeManager.addStrongholdBiome(hlb);
				if(hlb.equals(HighlandsBiomes.meadow) || hlb.equals(HighlandsBiomes.highlandsBiome)
						|| hlb.equals(HighlandsBiomes.lowlands) || hlb.equals(HighlandsBiomes.steppe)
						|| hlb.equals(HighlandsBiomes.mojave))
					BiomeManager.addVillageBiome(hlb, true);
			}
		}
	}
	
}