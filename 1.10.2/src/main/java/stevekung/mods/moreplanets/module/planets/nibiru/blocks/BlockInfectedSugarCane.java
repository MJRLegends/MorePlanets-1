package stevekung.mods.moreplanets.module.planets.nibiru.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.module.planets.nibiru.items.NibiruItems;
import stevekung.mods.moreplanets.util.blocks.BlockBushMP;
import stevekung.mods.moreplanets.util.helper.BlockEventHelper;

public class BlockInfectedSugarCane extends BlockBushMP
{
    public static PropertyInteger AGE = PropertyInteger.create("age", 0, 15);
    protected static AxisAlignedBB REED_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.0D, 0.875D);

    protected BlockInfectedSugarCane(String name)
    {
        super(Material.PLANTS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
        this.setUnlocalizedName(name);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return REED_AABB;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (world.getBlockState(pos.down()).getBlock() == NibiruBlocks.INFECTED_SUGAR_CANE_BLOCK || this.canBlockStay(world, pos, state))
        {
            if (world.isAirBlock(pos.up()))
            {
                int i;

                for (i = 1; world.getBlockState(pos.down(i)).getBlock() == this; ++i) {}

                if (i < 3)
                {
                    int j = state.getValue(AGE).intValue();

                    if (j == 15)
                    {
                        world.setBlockState(pos.up(), this.getDefaultState());
                        world.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(0)), 4);
                    }
                    else
                    {
                        world.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 4);
                    }
                }
            }
        }
    }

    @Override
    public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
    {
        Block block = world.getBlockState(pos.down()).getBlock();

        if (BlockEventHelper.isLiquidBlock(world, pos))
        {
            return false;
        }
        if (block == this)
        {
            return true;
        }
        else
        {
            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
                if ((block == NibiruBlocks.INFECTED_GRASS || block == NibiruBlocks.INFECTED_DIRT || block == NibiruBlocks.INFECTED_SAND) && world.getBlockState(pos.offset(enumfacing).down()).getBlock() == NibiruBlocks.INFECTED_WATER_FLUID_BLOCK)
                {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return NibiruItems.INFECTED_SUGAR_CANE;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(NibiruItems.INFECTED_SUGAR_CANE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(AGE).intValue();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {AGE});
    }
}