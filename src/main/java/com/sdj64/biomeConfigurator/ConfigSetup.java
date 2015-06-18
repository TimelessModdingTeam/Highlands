package com.sdj64.biomeConfigurator;

import java.util.ArrayList;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigSetup {

	public static String CATEGORY_BIOME_ID = "Biome IDs";
	public static String CATEGORY_BIOME_GENERATE = "Generate Biomes true/false?";
	
	public static ArrayList<Property> biomeIDs = new ArrayList<Property>();
	
	public static ArrayList<Property> biomeGenerates = new ArrayList<Property>();
	
	
	
	public static void setup(Configuration config)
	{
		//biome id setup
		BiomeGenBase[] allBiomes = BiomeGenBase.getBiomeGenArray();
		
		for(int i = 0; i < allBiomes.length; i++)
		{
			if(!(allBiomes[i] == null))
				biomeIDs.set(i,  config.get(CATEGORY_BIOME_ID, allBiomes[i].biomeName + " ID", allBiomes[i].biomeID, "", 0, 256));
		}
		
		//do biomes generate?
		for(int i = 0; i < allBiomes.length; i++)
		{
			biomeGenerates.set(i,  config.get(CATEGORY_BIOME_GENERATE, allBiomes[i].biomeName, true));
		}
		
		
	}
	
}
