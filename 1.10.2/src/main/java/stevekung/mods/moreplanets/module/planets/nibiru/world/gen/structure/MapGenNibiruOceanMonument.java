package stevekung.mods.moreplanets.module.planets.nibiru.world.gen.structure;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.structure.*;
import stevekung.mods.moreplanets.init.MPBiomes;
import stevekung.mods.moreplanets.module.planets.nibiru.entity.EntityInfectedGuardian;
import stevekung.mods.moreplanets.util.MPLog;

public class MapGenNibiruOceanMonument extends MapGenStructure
{
    private int spacing;
    private int separation;
    public List<Biome> waterBiomes = Lists.newArrayList(MPBiomes.INFECTED_OCEAN, MPBiomes.INFECTED_DEEP_OCEAN, MPBiomes.INFECTED_RIVER);
    public Biome spawnBiome = MPBiomes.INFECTED_DEEP_OCEAN;
    private static List<SpawnListEntry> MONUMENT_ENEMIES = Lists.newArrayList();

    static
    {
        MONUMENT_ENEMIES.add(new SpawnListEntry(EntityInfectedGuardian.class, 1, 2, 4));
        MapGenStructureIO.registerStructure(StartMonument.class, "NibiruOceanMonument");
        StructureOceanMonumentPieces.registerOceanMonumentPieces();
    }

    public MapGenNibiruOceanMonument()
    {
        this.spacing = 32;
        this.separation = 5;
    }

    @Override
    public String getStructureName()
    {
        return "NibiruOceanMonument";
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ)
    {
        int i = chunkX;
        int j = chunkZ;

        if (chunkX < 0)
        {
            chunkX -= this.spacing - 1;
        }
        if (chunkZ < 0)
        {
            chunkZ -= this.spacing - 1;
        }

        int k = chunkX / this.spacing;
        int l = chunkZ / this.spacing;
        Random random = this.worldObj.setRandomSeed(k, l, 10387313);
        k = k * this.spacing;
        l = l * this.spacing;
        k = k + (random.nextInt(this.spacing - this.separation) + random.nextInt(this.spacing - this.separation)) / 2;
        l = l + (random.nextInt(this.spacing - this.separation) + random.nextInt(this.spacing - this.separation)) / 2;

        if (i == k && j == l)
        {
            if (!this.worldObj.getBiomeProvider().areBiomesViable(i * 16 + 8, j * 16 + 8, 16, Lists.newArrayList(this.spawnBiome)))
            {
                return false;
            }

            boolean flag = this.worldObj.getBiomeProvider().areBiomesViable(i * 16 + 8, j * 16 + 8, 29, this.waterBiomes);

            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ)
    {
        return new StartMonument(this.worldObj, this.rand, chunkX, chunkZ);
    }

    public List<SpawnListEntry> getSpawnList()
    {
        return MONUMENT_ENEMIES;
    }

    public static class StartMonument extends StructureStart
    {
        private Set<ChunkPos> processed = Sets.newHashSet();
        private boolean wasCreated;

        public StartMonument() {}

        public StartMonument(World world, Random rand, int x, int z)
        {
            super(x, z);
            MPLog.debug("Generate Nibiru Ocean Monument at %s %s", x * 16, z * 16);
            this.create(world, rand, x, z);
        }

        private void create(World world, Random rand, int x, int z)
        {
            rand.setSeed(world.getSeed());
            long i = rand.nextLong();
            long j = rand.nextLong();
            long k = x * i;
            long l = z * j;
            rand.setSeed(k ^ l ^ world.getSeed());
            int i1 = x * 16 + 8 - 29;
            int j1 = z * 16 + 8 - 29;
            EnumFacing enumfacing = EnumFacing.Plane.HORIZONTAL.random(rand);
            this.components.add(new StructureOceanMonumentPieces.MonumentBuilding(rand, i1, j1, enumfacing));
            this.updateBoundingBox();
            this.wasCreated = true;
        }

        @Override
        public void generateStructure(World world, Random rand, StructureBoundingBox box)
        {
            if (!this.wasCreated)
            {
                this.components.clear();
                this.create(world, rand, this.getChunkPosX(), this.getChunkPosZ());
            }
            super.generateStructure(world, rand, box);
        }

        @Override
        public boolean isValidForPostProcess(ChunkPos pair)
        {
            return this.processed.contains(pair) ? false : super.isValidForPostProcess(pair);
        }

        @Override
        public void notifyPostProcessAt(ChunkPos pair)
        {
            super.notifyPostProcessAt(pair);
            this.processed.add(pair);
        }

        @Override
        public void writeToNBT(NBTTagCompound tagCompound)
        {
            super.writeToNBT(tagCompound);
            NBTTagList nbttaglist = new NBTTagList();

            for (ChunkPos chunkpos : this.processed)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setInteger("X", chunkpos.chunkXPos);
                nbttagcompound.setInteger("Z", chunkpos.chunkZPos);
                nbttaglist.appendTag(nbttagcompound);
            }
            tagCompound.setTag("Processed", nbttaglist);
        }

        @Override
        public void readFromNBT(NBTTagCompound tagCompound)
        {
            super.readFromNBT(tagCompound);

            if (tagCompound.hasKey("Processed", 9))
            {
                NBTTagList nbttaglist = tagCompound.getTagList("Processed", 10);

                for (int i = 0; i < nbttaglist.tagCount(); ++i)
                {
                    NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
                    this.processed.add(new ChunkPos(nbttagcompound.getInteger("X"), nbttagcompound.getInteger("Z")));
                }
            }
        }
    }
}