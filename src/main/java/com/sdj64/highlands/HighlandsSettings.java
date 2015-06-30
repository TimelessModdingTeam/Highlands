package com.sdj64.highlands;

import java.util.List;

public class HighlandsSettings 
{
	
	public static int HighlandsBiomeSizeDefault;
	public static int HighlandsBiomeSizeLB;
	public static boolean highlandsInDefaultFlag;
	public static boolean useOreGens;
	
	public static List hlvillagebiomes;
	public static List defaultvillagebiomes;
	
	public static void constructSettings()
	{
		
		HighlandsSettings.HighlandsBiomeSizeDefault = Config.biomeSize.getInt();
		HighlandsSettings.HighlandsBiomeSizeLB = Config.LBbiomeSize.getInt();
		
		HighlandsSettings.highlandsInDefaultFlag = Config.genDefault.getBoolean(false);
		
		HighlandsSettings.useOreGens = Config.genOre.getBoolean(true);
	}
}
