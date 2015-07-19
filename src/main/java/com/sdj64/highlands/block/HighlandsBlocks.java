package com.sdj64.highlands.block;

import com.sdj64.highlands.References;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class HighlandsBlocks
{

    public static final int NUM_TREE_TYPES = 7;

    public static final CreativeTabs tabHighlands = new CreativeTabs("Highlands")
    {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(Blocks.sapling);
        }
    };

    //tree blocks
    public static Block[] planks;
    public static Block[] woods;
    public static Block[] leaves;
    public static Block[] saplings;

    //wood products
    public static Block[] doors;
    public static Block[] fences;
    public static Block[] slabs;
    public static Block[] doubleSlabs;
    public static Block[] stairs;

    public static void constructBlocks()
    {
        //initialize EnumType meta lookup
        EnumType.ASPEN.setMetaLookup();
        EnumType.POPLAR.setMetaLookup();
        EnumType.EUCA.setMetaLookup();
        EnumType.PALM.setMetaLookup();
        EnumType.FIR.setMetaLookup();
        EnumType.REDWOOD.setMetaLookup();
        EnumType.BAMBOO.setMetaLookup();

        //initialize arrays
        planks = new Block[NUM_TREE_TYPES];
        woods = new Block[NUM_TREE_TYPES];
        leaves = new Block[NUM_TREE_TYPES];
        saplings = new Block[NUM_TREE_TYPES];
        doors = new Block[NUM_TREE_TYPES];
        fences = new Block[NUM_TREE_TYPES];
        slabs = new Block[NUM_TREE_TYPES];
        doubleSlabs = new Block[NUM_TREE_TYPES];
        stairs = new Block[NUM_TREE_TYPES];

        //initialize blocks within arrays
        for (int i = 0; i < NUM_TREE_TYPES; i++)
        {
            planks[i] = new BlockHighlandsPlanks(EnumType.META_LOOKUP[i], References.MOD_ID + "_" + EnumType.META_LOOKUP[i].getName());
            woods[i] = new BlockHighlandsLog(EnumType.META_LOOKUP[i], References.MOD_ID + "_" + EnumType.META_LOOKUP[i].getName());
            leaves[i] = new BlockHighlandsLeaves(EnumType.META_LOOKUP[i], References.MOD_ID + "_" + EnumType.META_LOOKUP[i].getName());
            saplings[i] = new BlockHighlandsSapling(EnumType.META_LOOKUP[i], References.MOD_ID + "_" + EnumType.META_LOOKUP[i].getName());

            System.out.println(planks[i].getUnlocalizedName());
            System.out.println(woods[i].getUnlocalizedName());
            System.out.println(leaves[i].getUnlocalizedName());
            System.out.println(saplings[i].getUnlocalizedName());

            GameRegistry.registerBlock(planks[i], planks[i].getUnlocalizedName().substring(15));
            GameRegistry.registerBlock(woods[i], woods[i].getUnlocalizedName().substring(15));
            GameRegistry.registerBlock(leaves[i], leaves[i].getUnlocalizedName().substring(15));
            GameRegistry.registerBlock(saplings[i], saplings[i].getUnlocalizedName().substring(15));

            OreDictionary.registerOre("logWood", woods[i]);
            OreDictionary.registerOre("plankWood", planks[i]);
            OreDictionary.registerOre("treeLeaves", leaves[i]);
            OreDictionary.registerOre("treeSapling", saplings[i]);

            Blocks.fire.setFireInfo(leaves[i], 30, 60);
            Blocks.fire.setFireInfo(planks[i], 5, 20);
            Blocks.fire.setFireInfo(woods[i], 5, 5);
        }


    }

    public static void registerRenders()
    {
        for (int i = 0; i < NUM_TREE_TYPES; i++)
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
                new ModelResourceLocation(References.MOD_ID + ":" + item.getUnlocalizedName().substring(15), "inventory"));
        /*
		if(block instanceof BlockHighlandsLeaves){
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, 
					new ModelResourceLocation(References.MOD_ID + ":" + item.getUnlocalizedName().substring(15), "check_decay=false,decayable=false"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, 
					new ModelResourceLocation(References.MOD_ID + ":" + item.getUnlocalizedName().substring(15), "check_decay=true,decayable=false"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, 
					new ModelResourceLocation(References.MOD_ID + ":" + item.getUnlocalizedName().substring(15), "check_decay=false,decayable=true"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, 
					new ModelResourceLocation(References.MOD_ID + ":" + item.getUnlocalizedName().substring(15), "check_decay=true,decayable=true"));
		}
		if(block instanceof BlockHighlandsSapling){
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, 
					new ModelResourceLocation(References.MOD_ID + ":" + item.getUnlocalizedName().substring(15), "stage=0"));
		}
		*/
    }


    public static enum EnumType implements IStringSerializable
    {
        ASPEN(0, "aspen"),
        POPLAR(1, "poplar"),
        EUCA(2, "eucalyptus"),
        PALM(3, "palm"),
        FIR(4, "fir"),
        REDWOOD(5, "redwood"),
        BAMBOO(6, "bamboo");
        private static final EnumType[] META_LOOKUP = new EnumType[values().length];
        private final int meta;
        private final String name;

        private EnumType(int meta, String name)
        {
            this.meta = meta;
            this.name = name;
        }

        public void setMetaLookup()
        {
            EnumType.META_LOOKUP[this.meta] = this;
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
