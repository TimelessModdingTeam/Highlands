package com.sdj64.highlands;

import java.io.File;

import com.sdj64.highlands.generator.GenerateTrees;
import com.sdj64.highlands.generator.WorldGenGreatOak;
import com.sdj64.highlands.generator.WorldGenHighlandsShrub;
import com.sdj64.highlands.generator.WorldGenTreeAsh;
import com.sdj64.highlands.generator.WorldGenTreeEuca;
import com.sdj64.highlands.generator.WorldGenTreeFir;
import com.sdj64.highlands.generator.WorldGenTreePalm;
import com.sdj64.highlands.generator.WorldGenTreePoplar;
import com.sdj64.highlands.generator.WorldGenTreeRedwood;

import net.minecraft.init.Blocks;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
		
		Initializer.constructSettings();
		Initializer.constructBiomes();
		Initializer.setUpAllSubBiomes();
		Initializer.setUpBiomeManager();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	
	
	
	
	
	
	
}
