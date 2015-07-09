package com.sdj64.highlands.biome;

import java.util.ArrayList;
import java.util.List;

import com.sdj64.highlands.Config;
import com.sdj64.highlands.HighlandsSettings;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

/*
 * Highlands biomes - Highlands API
 * 
 * This class contains all of the biomes for Highlands.
 * Only access this class in Post Initialization!
 * The values are populated during Highlands initialization.
 */
public class HighlandsBiomes {

	//main biomes
    public static BiomeGenBase highlandsBiome;
    public static BiomeGenBase pinelands;
    public static BiomeGenBase autumnForest;
    public static BiomeGenBase alps;
    public static BiomeGenBase meadow;
    public static BiomeGenBase tropicDryForest;
    public static BiomeGenBase redwoodForest;
    public static BiomeGenBase lowlands;
    public static BiomeGenBase mojave;
    public static BiomeGenBase poplarHills;
    public static BiomeGenBase tropicalIslands;
    public static BiomeGenBase badlands;
    public static BiomeGenBase greyMtns;
    public static BiomeGenBase tropHills;
    public static BiomeGenBase dryForest;
    
    //Sub Biomes
    public static BiomeGenBase lake;
    public static BiomeGenBase baldHill;
    
    
    //ArrayList of biomes for the Highlands worldtype
    public static ArrayList<BiomeGenBase> biomesForHighlands = new ArrayList<BiomeGenBase>();
    
    //ArrayList of Highlands biomes not including default ones, these will be added to the default world
    //Currently not used since BiomeManager doesn't really do different biomes for different world types
    //public static ArrayList<BiomeGenBase> biomesForDefault = new ArrayList<BiomeGenBase>();
    
    //ArrayList of sub-biomes, controls which Highlands biomes generate as sub-biomes (currently used for Lake and Bald Hill)
    public static ArrayList<BiomeGenBase> subBiomes = new ArrayList<BiomeGenBase>();
    
    
private static String biomePrefix = "";
	
	public static void constructBiomes()
	{
		
		biomePrefix = Config.biomePrefix.getBoolean(false) ? "Highlands_" : "";
		
		//main biomes
		
		if(Config.alpsGenerate.getBoolean(true))
		{
			alps = new BiomeGenAlps(Config.alpsID.getInt()).setBiomeName(biomePrefix+"Alps");
			biomesForHighlands.add(alps);
		}
		if(Config.badlandsGenerate.getBoolean(true))
		{
			badlands = new BiomeGenBadlands(Config.badlandsID.getInt()).setBiomeName(biomePrefix+"Badlands");
			biomesForHighlands.add(badlands);
		}
		if(Config.poplarHillsGenerate.getBoolean(true))
		{
			poplarHills = new BiomeGenPoplarHills(Config.poplarHillsID.getInt()).setBiomeName(biomePrefix+"Poplar Hills");
			biomesForHighlands.add(poplarHills);
		}
		if(Config.highlandsbGenerate.getBoolean(true))
		{
			highlandsBiome = new BiomeGenHighlands(Config.highlandsbID.getInt()).setBiomeName(biomePrefix+"Highlands");
			biomesForHighlands.add(highlandsBiome);
		}
		if(Config.lowlandsGenerate.getBoolean(true))
		{
			lowlands = new BiomeGenLowlands(Config.lowlandsID.getInt()).setBiomeName(biomePrefix+"Lowlands");
			biomesForHighlands.add(lowlands);
		}
		if(Config.meadowGenerate.getBoolean(true))
		{
			meadow = new BiomeGenMeadow(Config.meadowID.getInt()).setBiomeName(biomePrefix+"Meadow");
			biomesForHighlands.add(meadow);
		}
		if(Config.pinelandsGenerate.getBoolean(true))
		{
			pinelands = new BiomeGenPinelands(Config.pinelandsID.getInt()).setBiomeName(biomePrefix+"Pinelands");
			biomesForHighlands.add(pinelands);
		}
		if(Config.redwoodForestGenerate.getBoolean(true))
		{
			redwoodForest = new BiomeGenRedwoodForest(Config.redwoodForestID.getInt()).setBiomeName(biomePrefix+"Redwood Forest");
			biomesForHighlands.add(redwoodForest);
		}
		if(Config.mojaveGenerate.getBoolean(true))
		{
			mojave = new BiomeGenMojave(Config.mojaveID.getInt()).setBiomeName(biomePrefix+"Mojave");
			biomesForHighlands.add(mojave);
		}
		if(Config.greyMtnsGenerate.getBoolean(true))
		{
			greyMtns = new BiomeGenGreyMountains(Config.greyMtnsID.getInt()).setBiomeName(biomePrefix+"Grey Mountains");
			biomesForHighlands.add(greyMtns);
		}
		if(Config.tropicalIslandsGenerate.getBoolean(true))
		{
			tropicalIslands = new BiomeGenTropicalIslands(Config.tropicalIslandsID.getInt()).setBiomeName(biomePrefix+"Tropical Islands");
			biomesForHighlands.add(tropicalIslands);
		}
		if(Config.tropHillsGenerate.getBoolean(true))
		{
			tropHills = new BiomeGenTropHills(Config.tropHillsID.getInt()).setBiomeName(biomePrefix+"Tropical Hills");
			biomesForHighlands.add(tropHills);
		}
		if(Config.dryForestGenerate.getBoolean(true))
		{
			dryForest = new BiomeGenTropDryForest(Config.tropHillsID.getInt()).setBiomeName(biomePrefix+"Dry Forest");
			biomesForHighlands.add(dryForest);
		}
		
		//sub-biomes
		if(Config.lakeGenerate.getBoolean(true))
		{
			lake = new BiomeGenLake(Config.lakeID.getInt()).setBiomeName(biomePrefix+"Lake");
			subBiomes.add(lake);
		}
		if(Config.baldHillGenerate.getBoolean(true))
		{
			baldHill = new BiomeGenBaldHill(Config.baldHillID.getInt()).setBiomeName(biomePrefix+"Bald Hill");
			subBiomes.add(baldHill);
		}
	}
	
	
	//sets up sub-biome lists after all biomes are initialized.
	public static void setUpAllSubBiomes()
	{
		ArrayList<BiomeGenBase> enabledBiomes = new ArrayList<BiomeGenBase>();
		for(BiomeGenBase b : biomesForHighlands)enabledBiomes.add(b);
		for(BiomeGenBase b : subBiomes)enabledBiomes.add(b);
		
		addSubBiome(alps, BiomeGenBase.frozenRiver, enabledBiomes);
		addSubBiome(autumnForest, baldHill, enabledBiomes);
		addSubBiome(autumnForest, lake, enabledBiomes);
		addSubBiome(poplarHills, meadow, enabledBiomes);
		addSubBiome(meadow, lake, enabledBiomes);
		addSubBiome(BiomeGenBase.forest, baldHill, enabledBiomes);
		addSubBiome(highlandsBiome, BiomeGenBase.forest, enabledBiomes);
		addSubBiome(lowlands, baldHill, enabledBiomes);
		addSubBiome(lowlands, lake, enabledBiomes);
		addSubBiome(pinelands, autumnForest, enabledBiomes);
		addSubBiome(redwoodForest, highlandsBiome, enabledBiomes);
		addSubBiome(redwoodForest, lake, enabledBiomes);
		addSubBiome(mojave, BiomeGenBase.mesa, enabledBiomes);
		addSubBiome(mojave, BiomeGenBase.savanna, enabledBiomes);
		addSubBiome(tropHills, lake, enabledBiomes);
		addSubBiome(dryForest, BiomeGenBase.savanna, enabledBiomes);
	}
	
	public static void addSubBiome(BiomeGenBase parent, BiomeGenBase sub, ArrayList<BiomeGenBase> list)
	{
		if(parent != null && sub != null && list.contains(parent) && list.contains(sub) && parent instanceof BiomeGenBaseHighlands){
			((BiomeGenBaseHighlands)parent).subBiomes.add(sub);
		}
	}
	
	public static void setUpBiomeManager()
	{
		for(int i = 0; i < biomesForHighlands.size(); i++)
		{
			BiomeGenBase hlb = biomesForHighlands.get(i);
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
				if(hlb.equals(meadow) || hlb.equals(highlandsBiome)
						|| hlb.equals(lowlands) || hlb.equals(mojave))
					BiomeManager.addVillageBiome(hlb, true);
			}
			BiomeManager.addVillageBiome(BiomeGenBase.icePlains, true);
		}
	}
    
    /**
     * Adds a creature to spawn in a certain biome.  Not compatible with DrZhark's CustomMobSpawner.
     * @param biome the biome to add the creature to.  Only works with these biomes, not vanilla or other mods' biomes.
     * @param creature the creature to add
     */
    public static void addCreature(BiomeGenBaseHighlands biome, EntityCreature creature){
    	List creatureList = biome.getSpawnableList(EnumCreatureType.CREATURE);
    	creatureList.add(creature);
    	biome.setSpawnLists(
				biome.getSpawnableList(EnumCreatureType.MONSTER),
				creatureList,
				biome.getSpawnableList(EnumCreatureType.WATER_CREATURE)
				);
    }
    
    public static void addMob(BiomeGenBaseHighlands biome, EntityMob mob){
    	List mobList = biome.getSpawnableList(EnumCreatureType.MONSTER);
    	mobList.add(mob);
    	biome.setSpawnLists(
				mobList,
				biome.getSpawnableList(EnumCreatureType.CREATURE),
				biome.getSpawnableList(EnumCreatureType.WATER_CREATURE)
				);
    }
    
    public static void addWaterCreature(BiomeGenBaseHighlands biome, EntityCreature creature){
    	List waterCreatureList = biome.getSpawnableList(EnumCreatureType.WATER_CREATURE);
    	waterCreatureList.add(creature);
    	biome.setSpawnLists(
				biome.getSpawnableList(EnumCreatureType.MONSTER),
				biome.getSpawnableList(EnumCreatureType.CREATURE),
				waterCreatureList
				);
    }
}







