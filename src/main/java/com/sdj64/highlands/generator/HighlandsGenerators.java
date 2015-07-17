package com.sdj64.highlands.generator;

import com.sdj64.highlands.block.BlockHighlandsLeaves;
import com.sdj64.highlands.block.HighlandsBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class HighlandsGenerators {

	/*
	 * List of trees:
	 * Aspen: medium tree with straight branches.
	 * Great Oak: oak big tree but even bigger, with 2x2 trunk.
	 * Poplar: tall thin tree.
	 * Eucalyptus: tall tree with a unique crown shape.
	 * Highlands Shrub: like jungle shrubs but with oak or spruce.
	 * Palm: palm leaves come out from the top in 8 directions.
	 * Fir: medium pine tree that can occasionally grow with a larger 2x2 trunk.
	 * Redwood: giant pine tree with a circular trunk.
	 * Bamboo: thin stem that gets more leafy at the top.
	 */
	public static WorldGenAbstractTree aspenGen = new WorldGenTreeAspen(HighlandsBlocks.leaves[0], HighlandsBlocks.woods[0], flmeta(0), 0,  8, 13, false);
	public static WorldGenAbstractTree aspenSapling = new WorldGenTreeAspen(HighlandsBlocks.leaves[0], HighlandsBlocks.woods[0], flmeta(0), 0, 8, 13, true);
	public static WorldGenAbstractTree greatOakGen = new WorldGenGreatOak(Blocks.leaves, Blocks.log, 0, 0, 2, 20, false);
	public static WorldGenAbstractTree greatOakSapling = new WorldGenGreatOak(Blocks.leaves, Blocks.log, 0, 0, 2, 20, true);
	public static WorldGenAbstractTree poplarGen = new WorldGenTreePoplar(HighlandsBlocks.leaves[1], HighlandsBlocks.woods[1], flmeta(1), 0, 7, 11, false);
	public static WorldGenAbstractTree poplarSapling = new WorldGenTreePoplar(HighlandsBlocks.leaves[1], HighlandsBlocks.woods[1], flmeta(1), 0, 7, 11, true);
	public static WorldGenAbstractTree eucalyptusGen = new WorldGenTreeEuca(HighlandsBlocks.leaves[2], HighlandsBlocks.woods[2], flmeta(2), 0, 14, 22, false);
	public static WorldGenAbstractTree eucalyptusSapling = new WorldGenTreeEuca(HighlandsBlocks.leaves[2], HighlandsBlocks.woods[2], flmeta(2), 0, 14, 22, true);
	public static WorldGenAbstractTree palmGen = new WorldGenTreePalm(HighlandsBlocks.leaves[3], HighlandsBlocks.woods[3], flmeta(3), 0, 6, 12, false);
	public static WorldGenAbstractTree palmSapling = new WorldGenTreePalm(HighlandsBlocks.leaves[3], HighlandsBlocks.woods[3], flmeta(3), 0, 6, 12, true);
	public static WorldGenAbstractTree firGen = new WorldGenTreeFir(HighlandsBlocks.leaves[4], HighlandsBlocks.woods[4], flmeta(4), 0, 9, 16, false);
	public static WorldGenAbstractTree firSapling = new WorldGenTreeFir(HighlandsBlocks.leaves[4], HighlandsBlocks.woods[4], flmeta(4), 0, 9, 16, true);
	public static WorldGenAbstractTree redwoodGen = new WorldGenTreeRedwood(HighlandsBlocks.leaves[5], HighlandsBlocks.woods[5], flmeta(5), 0, 27, 38, false);
	public static WorldGenAbstractTree redwoodSapling = new WorldGenTreeRedwood(HighlandsBlocks.leaves[5], HighlandsBlocks.woods[5], flmeta(5), 0, 20, 30, true);
	public static WorldGenAbstractTree shrubGen = new WorldGenHighlandsShrub(Blocks.leaves, Blocks.log, 1, 1, false);
	public static WorldGenAbstractTree shrubSapling = new WorldGenHighlandsShrub(Blocks.leaves, Blocks.log, 1, 1, true);
	public static WorldGenAbstractTree shrub2Gen = new WorldGenHighlandsShrub(Blocks.leaves, Blocks.log, 0, 0, false);
	public static WorldGenAbstractTree shrub2Sapling = new WorldGenHighlandsShrub(Blocks.leaves, Blocks.log, 0, 0, true);
	public static WorldGenAbstractTree bambooGen = new WorldGenTreeBamboo(HighlandsBlocks.leaves[6], HighlandsBlocks.woods[6], flmeta(6), 0, 6, 10, false);
	public static WorldGenAbstractTree bambooSapling = new WorldGenTreeBamboo(HighlandsBlocks.leaves[6], HighlandsBlocks.woods[6], flmeta(6), 0, 6, 10, true);
	
	
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
	public static WorldGenMinable2 hlice = new WorldGenMinable2(Blocks.packed_ice.getDefaultState(), 14, true);
	public static WorldGenMinable2 hlsand = new WorldGenMinable2(Blocks.sand.getDefaultState(), 30, true);
	
	
	
	//find leaf meta for tree leaves (check-decay and decayable both true)
	//not really working right now.  0 works so...
	private static int flmeta(int i) {
		return 0;//HighlandsBlocks.leaves[i].getMetaFromState(
				//HighlandsBlocks.leaves[i].getDefaultState().withProperty(BlockHighlandsLeaves.DECAYABLE, true).withProperty(BlockHighlandsLeaves.CHECK_DECAY, true));
	}
	
	
}
