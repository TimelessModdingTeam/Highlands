package com.sdj64.highlands;

import java.util.ArrayList;
import java.util.List;

import com.sdj64.highlands.biome.BiomeGenBaseHighlands;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.biome.BiomeGenBase;

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
    public static BiomeGenBase steppe;
    
    //Sub Biomes
    public static BiomeGenBase lake;
    public static BiomeGenBase baldHill;
    public static BiomeGenBase volcanoIsland;
    
    
    //ArrayList of biomes for the Highlands worldtype
    public static ArrayList<BiomeGenBase> biomesForHighlands = new ArrayList<BiomeGenBase>();
    
    //ArrayList of Highlands biomes (not including default ones, these will be added to the default world
    public static ArrayList<BiomeGenBase> biomesForDefault = new ArrayList<BiomeGenBase>();
    
    //ArrayList of sub-biomes, controls which Highlands biomes generate as sub-biomes (currently used for Lake and Bald Hill)
    public static ArrayList<BiomeGenBase> subBiomes = new ArrayList<BiomeGenBase>();
    
    
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







