package com.sdj64.highlands;

import com.sdj64.highlands.biome.ChunkProviderHighlands;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldTypeHighlands extends WorldType
{

    private String wtname;

    public WorldTypeHighlands(String name)
    {
        super(name);
        this.wtname = name;
    }

    @Override
    public net.minecraft.world.chunk.IChunkProvider getChunkGenerator(World world, String generatorOptions)
    {
        if (this == FLAT)
            return new net.minecraft.world.gen.ChunkProviderFlat(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
        if (this == DEBUG_WORLD) return new net.minecraft.world.gen.ChunkProviderDebug(world);
        return new ChunkProviderHighlands(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
    }

    /**
     * Gets the translation key for the name of this world type.
     */
    @SideOnly(Side.CLIENT)
    @Override
    public String getTranslateName()
    {
        return this.wtname;
    }

}
