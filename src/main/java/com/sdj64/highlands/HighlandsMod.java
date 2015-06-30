package com.sdj64.highlands;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import com.sdj64.highlands.biome.HighlandsBiomes;
import com.sdj64.highlands.block.HighlandsBlocks;
import com.sdj64.highlands.generator.GenerateTrees;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MC_VERSION)
public class HighlandsMod {

	HLEventManager eventMgr = new HLEventManager();
	GenerateTrees genTrees = new GenerateTrees();
	
	/* world types not working yet.
	public static final WorldType HL = new WorldType("Highlands");
	public static final WorldType HLLB = new WorldType("Highlands LB");
	*/
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.TERRAIN_GEN_BUS.register(eventMgr);
		MinecraftForge.EVENT_BUS.register(eventMgr);
		
		Configuration config = new Configuration(new File(event.getModConfigurationDirectory() + File.separator + "Highlands.cfg"));
		config.load();
		Config.setUpConfig(config);
		config.save();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(genTrees, 1);
		
		HighlandsSettings.constructSettings();
		HighlandsBiomes.constructBiomes();
		HighlandsBiomes.setUpAllSubBiomes();
		HighlandsBiomes.setUpBiomeManager();
		
		HighlandsBlocks.constructBlocks();
		if(FMLCommonHandler.instance().getSide().equals(Side.CLIENT)) HighlandsBlocks.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	
	
	
	
	
	
	
}
