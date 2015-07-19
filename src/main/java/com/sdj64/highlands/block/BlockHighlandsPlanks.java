package com.sdj64.highlands.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockHighlandsPlanks extends Block
{

    private HighlandsBlocks.EnumType treeType;

    public BlockHighlandsPlanks(HighlandsBlocks.EnumType type, String treeName)
    {
        super(Material.wood);
        setHardness(2.0F);
        setResistance(0.5F);
        setStepSound(Block.soundTypeWood);
        setUnlocalizedName(treeName + "_planks");

        this.setCreativeTab(HighlandsBlocks.tabHighlands);

        treeType = type;
    }
}