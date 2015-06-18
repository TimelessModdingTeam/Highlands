package com.sdj64.highlands;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import com.sdj64.highlands.generator.WorldGenGreatOak;
import com.sdj64.highlands.generator.WorldGenHighlandsShrub;
import com.sdj64.highlands.generator.WorldGenMinable2;
import com.sdj64.highlands.generator.WorldGenTreeAsh;
import com.sdj64.highlands.generator.WorldGenTreeEuca;
import com.sdj64.highlands.generator.WorldGenTreeFir;
import com.sdj64.highlands.generator.WorldGenTreePalm;
import com.sdj64.highlands.generator.WorldGenTreePoplar;
import com.sdj64.highlands.generator.WorldGenTreeRedwood;

public class HighlandsGenerators {

	/*
	 * List of trees:
	 * Ash: medium tree with straight branches.
	 * Great Oak: oak big tree but even bigger, with 2x2 trunk.
	 * Poplar: tall thin birch tree.
	 * Eucalyptus: tall birch tree with a unique crown shape.
	 * Highlands Shrub: like jungle shrubs but with oak or spruce.
	 * Palm: you know what a palm tree is.
	 * Spiral: oak tree with a spiraling circular trunk.
	 * Redwood: giant pine tree with a circular trunk.
	 */
	public static WorldGenAbstractTree ashGen = new WorldGenTreeAsh(Blocks.leaves2, Blocks.log2, 0, 0, 8, 13, false);
	public static WorldGenAbstractTree ashSapling = new WorldGenTreeAsh(Blocks.leaves2, Blocks.log2, 0, 0, 8, 13, true);
	public static WorldGenAbstractTree greatOakGen = new WorldGenGreatOak(Blocks.leaves, Blocks.log, 0, 0, 2, 20, true);
	public static WorldGenAbstractTree greatOakSapling = new WorldGenGreatOak(Blocks.leaves, Blocks.log, 0, 0, 2, 20, true);
	public static WorldGenAbstractTree poplarGen = new WorldGenTreePoplar(Blocks.leaves, Blocks.log, 2, 2, 7, 11, false);
	public static WorldGenAbstractTree poplarSapling = new WorldGenTreePoplar(Blocks.leaves, Blocks.log, 2, 2, 7, 11, true);
	public static WorldGenAbstractTree eucalyptusGen = new WorldGenTreeEuca(Blocks.leaves, Blocks.log, 2, 2, 14, 22, false);
	public static WorldGenAbstractTree eucalyptusSapling = new WorldGenTreeEuca(Blocks.leaves, Blocks.log, 2, 2, 14, 22, true);
	public static WorldGenAbstractTree palmGen = new WorldGenTreePalm(Blocks.leaves, Blocks.log, 3, 3, 6, 12, false);
	public static WorldGenAbstractTree palmSapling = new WorldGenTreePalm(Blocks.leaves, Blocks.log, 3, 3, 6, 12, true);
	public static WorldGenAbstractTree firGen = new WorldGenTreeFir(Blocks.leaves, Blocks.log, 1, 1, 6, 12, false);
	public static WorldGenAbstractTree firSapling = new WorldGenTreeFir(Blocks.leaves, Blocks.log, 1, 1, 6, 12, true);
	public static WorldGenAbstractTree redwoodGen = new WorldGenTreeRedwood(Blocks.leaves, Blocks.log, 1, 1, 27, 38, false);
	public static WorldGenAbstractTree redwoodSapling = new WorldGenTreeRedwood(Blocks.leaves, Blocks.log, 1, 1, 20, 30, true);
	public static WorldGenAbstractTree shrubGen = new WorldGenHighlandsShrub(Blocks.leaves, Blocks.log, 1, 1, false);
	public static WorldGenAbstractTree shrubSapling = new WorldGenHighlandsShrub(Blocks.leaves, Blocks.log, 1, 1, true);
	public static WorldGenAbstractTree shrub2Gen = new WorldGenHighlandsShrub(Blocks.leaves, Blocks.log, 0, 0, false);
	public static WorldGenAbstractTree shrub2Sapling = new WorldGenHighlandsShrub(Blocks.leaves, Blocks.log, 0, 0, true);
	
	
	
	/*
	 * List of ore generators:
	 * stoneInDirt: generates stone in large patches in dirt/grass
	 * sandInDirt: generates orange sand in large patches in dirt/grass
	 * hlwater: generates ore-like pockets of water underground
	 * hlice: generates ore-like pockets of Packed Ice underground
	 * hlsand: generates sand underground in large patches
	 */
	public static WorldGenMinable2 stoneInDirt = new WorldGenMinable2(Blocks.stone.getDefaultState(), 64, Blocks.dirt.getDefaultState());
	public static WorldGenMinable2 sandInDirt = new WorldGenMinable2(Blocks.sand.getStateFromMeta(1), 64, Blocks.dirt.getDefaultState());
	public static WorldGenMinable2 hlwater = new WorldGenMinable2(Blocks.water.getDefaultState(), 10, true);
	public static WorldGenMinable2 hlice = new WorldGenMinable2(Blocks.ice.getDefaultState(), 14, true);
	public static WorldGenMinable2 hlsand = new WorldGenMinable2(Blocks.sand.getDefaultState(), 30, true);
	
	
}
