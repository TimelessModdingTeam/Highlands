package com.sdj64.highlands.generator.layer;

import com.sdj64.highlands.biome.BiomeGenBaseHighlands;
import com.sdj64.highlands.biome.HighlandsBiomes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerHills;
import net.minecraft.world.gen.layer.IntCache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GenLayerHillsHighlands extends GenLayerHills
{
    private static final Logger logger = LogManager.getLogger();
    private GenLayer field_151628_d;
    private static final String __OBFID = "CL_00000563";

    public GenLayerHillsHighlands(long seed, GenLayer layer1, GenLayer layer2)
    {
        super(seed, layer1, layer2);
        this.parent = layer1;
        this.field_151628_d = layer2;
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = this.field_151628_d.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint2 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i1 = 0; i1 < areaHeight; ++i1)
        {
            for (int j1 = 0; j1 < areaWidth; ++j1)
            {
                this.initChunkSeed((long) (j1 + areaX), (long) (i1 + areaY));
                int k1 = aint[j1 + 1 + (i1 + 1) * (areaWidth + 2)];
                int l1 = aint1[j1 + 1 + (i1 + 1) * (areaWidth + 2)];
                boolean flag = (l1 - 2) % 29 == 0;

                if (k1 > 255)
                {
                    logger.debug("old! " + k1);
                }

                if (k1 != 0 && l1 >= 2 && (l1 - 2) % 29 == 1 && k1 < 128)
                {
                    if (BiomeGenBase.getBiome(k1 + 128) != null)
                    {
                        aint2[j1 + i1 * areaWidth] = k1 + 128;
                    }
                    else
                    {
                        aint2[j1 + i1 * areaWidth] = k1;
                    }
                }
                else if (this.nextInt(3) != 0 && !flag)
                {
                    aint2[j1 + i1 * areaWidth] = k1;
                }
                else
                {
                    int i2 = k1;
                    int j2;

                    if (k1 == BiomeGenBase.desert.biomeID)
                    {
                        i2 = BiomeGenBase.desertHills.biomeID;
                    }
                    else if (k1 == BiomeGenBase.forest.biomeID)
                    {
                        //Highlands code for bald hill as a sub of forest
                        j2 = this.nextInt(2);

                        if (j2 == 0)
                        {
                            i2 = BiomeGenBase.forestHills.biomeID;
                        }
                        else
                        {
                            i2 = HighlandsBiomes.baldHill.biomeID;
                        }
                    }
                    else if (k1 == BiomeGenBase.birchForest.biomeID)
                    {
                        i2 = BiomeGenBase.birchForestHills.biomeID;
                    }
                    else if (k1 == BiomeGenBase.roofedForest.biomeID)
                    {
                        i2 = BiomeGenBase.plains.biomeID;
                    }
                    else if (k1 == BiomeGenBase.taiga.biomeID)
                    {
                        i2 = BiomeGenBase.taigaHills.biomeID;
                    }
                    else if (k1 == BiomeGenBase.megaTaiga.biomeID)
                    {
                        i2 = BiomeGenBase.megaTaigaHills.biomeID;
                    }
                    else if (k1 == BiomeGenBase.coldTaiga.biomeID)
                    {
                        i2 = BiomeGenBase.coldTaigaHills.biomeID;
                    }
                    else if (k1 == BiomeGenBase.plains.biomeID)
                    {
                        if (this.nextInt(3) == 0)
                        {
                            i2 = BiomeGenBase.forestHills.biomeID;
                        }
                        else
                        {
                            i2 = BiomeGenBase.forest.biomeID;
                        }
                    }
                    else if (k1 == BiomeGenBase.icePlains.biomeID)
                    {
                        i2 = BiomeGenBase.iceMountains.biomeID;
                    }
                    else if (k1 == BiomeGenBase.jungle.biomeID)
                    {
                        i2 = BiomeGenBase.jungleHills.biomeID;
                    }
                    else if (k1 == BiomeGenBase.ocean.biomeID)
                    {
                        i2 = BiomeGenBase.deepOcean.biomeID;
                    }
                    else if (k1 == BiomeGenBase.extremeHills.biomeID)
                    {
                        i2 = BiomeGenBase.extremeHillsPlus.biomeID;
                    }
                    else if (k1 == BiomeGenBase.savanna.biomeID)
                    {
                        i2 = BiomeGenBase.savannaPlateau.biomeID;
                    }
                    else if (biomesEqualOrMesaPlateau(k1, BiomeGenBase.mesaPlateau_F.biomeID))
                    {
                        i2 = BiomeGenBase.mesa.biomeID;
                    }
                    else if (k1 == BiomeGenBase.deepOcean.biomeID && this.nextInt(3) == 0)
                    {
                        j2 = this.nextInt(2);

                        if (j2 == 0)
                        {
                            i2 = BiomeGenBase.plains.biomeID;
                        }
                        else
                        {
                            i2 = BiomeGenBase.forest.biomeID;
                        }
                    }
                    //Highlands code for any Highlands biome with subs
                    else if (BiomeGenBase.getBiomeGenArray()[k1] instanceof BiomeGenBaseHighlands)
                    {
                        BiomeGenBaseHighlands hlBiome = (BiomeGenBaseHighlands) BiomeGenBase.getBiomeGenArray()[k1];
                        if (hlBiome.subBiomes.size() > 0)
                        {
                            j2 = this.nextInt(hlBiome.subBiomes.size());
                            i2 = hlBiome.subBiomes.get(j2).biomeID;
                        }
                    }

                    if (flag && i2 != k1)
                    {
                        if (BiomeGenBase.getBiome(i2 + 128) != null)
                        {
                            i2 += 128;
                        }
                        else
                        {
                            i2 = k1;
                        }
                    }

                    if (i2 == k1)
                    {
                        aint2[j1 + i1 * areaWidth] = k1;
                    }
                    else
                    {
                        j2 = aint[j1 + 1 + (i1 + 1 - 1) * (areaWidth + 2)];
                        int k2 = aint[j1 + 1 + 1 + (i1 + 1) * (areaWidth + 2)];
                        int l2 = aint[j1 + 1 - 1 + (i1 + 1) * (areaWidth + 2)];
                        int i3 = aint[j1 + 1 + (i1 + 1 + 1) * (areaWidth + 2)];
                        int j3 = 0;

                        if (biomesEqualOrMesaPlateau(j2, k1))
                        {
                            ++j3;
                        }

                        if (biomesEqualOrMesaPlateau(k2, k1))
                        {
                            ++j3;
                        }

                        if (biomesEqualOrMesaPlateau(l2, k1))
                        {
                            ++j3;
                        }

                        if (biomesEqualOrMesaPlateau(i3, k1))
                        {
                            ++j3;
                        }

                        if (j3 >= 3)
                        {
                            aint2[j1 + i1 * areaWidth] = i2;
                        }
                        else
                        {
                            aint2[j1 + i1 * areaWidth] = k1;
                        }
                    }
                }
            }
        }

        return aint2;
    }
}