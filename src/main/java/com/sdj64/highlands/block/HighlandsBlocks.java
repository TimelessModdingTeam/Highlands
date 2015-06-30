package com.sdj64.highlands.block;

import com.sdj64.highlands.References;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HighlandsBlocks {

	public static final int NUM_TREE_TYPES = 5;
	
	public static final CreativeTabs tabHighlands = new CreativeTabs("Highlands")
    {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(Blocks.sapling);
        }
    };
	
    //tree blocks
	public static Block[] planks = new Block[NUM_TREE_TYPES];
	public static Block[] woods = new Block[NUM_TREE_TYPES];
	public static Block[] leaves = new Block[NUM_TREE_TYPES];
	public static Block[] saplings = new Block[NUM_TREE_TYPES];
	
	//wood products
	public static Block[] doors = new Block[NUM_TREE_TYPES];
	public static Block[] fences = new Block[NUM_TREE_TYPES];
	public static Block[] slabs = new Block[NUM_TREE_TYPES];
	public static Block[] doubleSlabs = new Block[NUM_TREE_TYPES];
	public static Block[] stairs = new Block[NUM_TREE_TYPES];
	
	public static void constructBlocks()
	{
		for(int i = 0; i < NUM_TREE_TYPES; i++)
		{
			planks[i] = new BlockHighlandsPlanks(References.MOD_ID + "_" + EnumType.META_LOOKUP[i].getName());
			woods[i] = new BlockHighlandsLog(References.MOD_ID + "_" + EnumType.META_LOOKUP[i].getName());
			
			GameRegistry.registerBlock(planks[i], planks[i].getUnlocalizedName());
			GameRegistry.registerBlock(woods[i], woods[i].getUnlocalizedName());
		}

		
	}
	
	public static void registerRenders()
	{
		for(int i = 0; i < NUM_TREE_TYPES; i++)
		{
			registerRender(planks[i]);
			registerRender(woods[i]);
			registerRender(leaves[i]);
			registerRender(saplings[i]);
		}
	}
	
	private static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, 
				new ModelResourceLocation(item.getUnlocalizedName(), "Inventory"));
	}
	
	
	
	
	public static enum EnumType implements IStringSerializable
    {
        ASPEN(0, "aspen"),
        POPLAR(1, "poplar"),
        EUCA(2, "eucalyptus"),
        PALM(3, "palm"),
        FIR(4, "fir"),
        REDWOOD(5, "redwood");
        private static final EnumType[] META_LOOKUP = new EnumType[values().length];
        private final int meta;
        private final String name;

        private EnumType(int meta, String name)
        {
            this.meta = meta;
            this.name = name;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.name;
        }

        public String getName()
        {
            return this.name;
        }
    }
}
