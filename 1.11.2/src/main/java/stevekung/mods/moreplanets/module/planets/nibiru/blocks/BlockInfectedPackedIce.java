package stevekung.mods.moreplanets.module.planets.nibiru.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import stevekung.mods.moreplanets.util.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.util.blocks.IIce;

public class BlockInfectedPackedIce extends BlockBaseMP implements IIce
{
    public BlockInfectedPackedIce(String name)
    {
        super(Material.PACKED_ICE);
        this.slipperiness = 0.98F;
        this.setHardness(0.5F);
        this.setSoundType(SoundType.GLASS);
        this.setUnlocalizedName(name);
    }

    @Override
    public int quantityDropped(Random rand)
    {
        return 0;
    }

    @Override
    public String getName()
    {
        return "infected_packed_ice";
    }
}