package stevekung.mods.moreplanets.module.planets.chalos.blocks;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.module.planets.chalos.tileentity.TileEntityCheeseSporeChest;
import stevekung.mods.moreplanets.util.blocks.BlockChestMP;

public class BlockCheeseSporeChest extends BlockChestMP
{
    public BlockCheeseSporeChest(String name)
    {
        super();
        this.setUnlocalizedName(name);
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        super.onNeighborBlockChange(world, pos, state, neighborBlock);
        TileEntity tileentity = world.getTileEntity(pos);

        if (tileentity instanceof TileEntityCheeseSporeChest)
        {
            tileentity.updateContainingBlockInfo();
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            ILockableContainer lock = this.getLockableContainer(world, pos);

            if (lock != null)
            {
                player.displayGUIChest(lock);
            }
        }
        return true;
    }

    @Override
    public ILockableContainer getLockableContainer(World world, BlockPos pos)
    {
        TileEntity tileentity = world.getTileEntity(pos);

        if (!(tileentity instanceof TileEntityCheeseSporeChest))
        {
            return null;
        }
        else
        {
            Object object = tileentity;

            if (this.isBlocked(world, pos))
            {
                return null;
            }
            else
            {
                Iterator iterator = EnumFacing.Plane.HORIZONTAL.iterator();

                while (iterator.hasNext())
                {
                    EnumFacing enumfacing = (EnumFacing)iterator.next();
                    BlockPos blockpos1 = pos.offset(enumfacing);
                    Block block = world.getBlockState(blockpos1).getBlock();

                    if (block == this)
                    {
                        if (this.isBlocked(world, blockpos1))
                        {
                            return null;
                        }

                        TileEntity tileentity1 = world.getTileEntity(blockpos1);

                        if (tileentity1 instanceof TileEntityCheeseSporeChest)
                        {
                            if (enumfacing != EnumFacing.WEST && enumfacing != EnumFacing.NORTH)
                            {
                                object = new InventoryLargeChest(StatCollector.translateToLocal("container.chestDouble"), (ILockableContainer)object, (TileEntityCheeseSporeChest)tileentity1);
                            }
                            else
                            {
                                object = new InventoryLargeChest(StatCollector.translateToLocal("container.chestDouble"), (TileEntityCheeseSporeChest)tileentity1, (ILockableContainer)object);
                            }
                        }
                    }
                }
                return (ILockableContainer)object;
            }
        }
    }

    @Override
    public TileEntity getChestTile()
    {
        return new TileEntityCheeseSporeChest();
    }

    @Override
    public String getName()
    {
        return "cheese_spore_chest";
    }
}