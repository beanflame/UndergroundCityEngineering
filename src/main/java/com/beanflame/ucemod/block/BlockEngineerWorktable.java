package com.beanflame.ucemod.block;

import com.beanflame.ucemod.UCEmod;
import com.beanflame.ucemod.block.tile.EntityEngineerWorktable;
import com.beanflame.ucemod.gui.UCECreativeTab;
import com.beanflame.ucemod.registry.UCEGuiLoader;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

/**
 * Creative by beanflame on 2020-01-15 16:23
 */

public class BlockEngineerWorktable extends BlockContainer
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	protected static final AxisAlignedBB NORTH_ENGINEER_WORKTABLE_AABB = new AxisAlignedBB(0 /16D, 0 /16D, 0 /16D, 16 /16D, 10 /16D, 16 /16D);
	protected static final AxisAlignedBB SOUTH_ENGINEER_WORKTABLE_AABB = new AxisAlignedBB(0 /16D, 0 /16D, 0 /16D, 16 /16D, 10 /16D, 16 /16D);
	protected static final AxisAlignedBB WEST_ENGINEER_WORKTABLE_AABB = new AxisAlignedBB(0 /16D, 0 /16D, 0 /16D, 16 /16D, 10 /16D, 16 /16D);
	protected static final AxisAlignedBB EAST_ENGINEER_WORKTABLE_AABB = new AxisAlignedBB(0 /16D, 0 /16D, 0 /16D, 16 /16D, 10 /16D, 16 /16D);


	public BlockEngineerWorktable()
    {
		super(Material.ROCK);
        setCreativeTab(UCECreativeTab.UCETAB);
        
        setTranslationKey("uce.engineer_worktable");
        setRegistryName(UCEmod.MODID, "engineer_worktable");
        
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		 return new EntityEngineerWorktable();
	}
		
		
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		if(tileEntity instanceof EntityEngineerWorktable)
		{
			EntityEngineerWorktable machine = (EntityEngineerWorktable)tileEntity;
			playerIn.openGui(UCEmod.instance, UCEGuiLoader.EngineerWorktable,worldIn,pos.getX(),pos.getY(),pos.getZ());
		}
		return true;
	}
	
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof EntityEngineerWorktable)
			{
				ItemStackHandler itemStackHandler = ((EntityEngineerWorktable) tileentity).items;
				for(int i = 0;i<itemStackHandler.getSlots();i++){
					EntityItem entityItem = new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(),itemStackHandler.getStackInSlot(i));
					entityItem.setDefaultPickupDelay();
					worldIn.spawnEntity(entityItem);
				}
			}

		super.breakBlock(worldIn, pos, state);
	}
	
	
	
	
	
	//-------------------------------------------------------------------------
	
	
	
	
	
	@Override
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	
	

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        if (source.getBlockState(pos.north()).getBlock() == this)
        {
            return NORTH_ENGINEER_WORKTABLE_AABB;
        }
        else if (source.getBlockState(pos.south()).getBlock() == this)
        {
            return SOUTH_ENGINEER_WORKTABLE_AABB;
        }
        else if (source.getBlockState(pos.west()).getBlock() == this)
        {
            return WEST_ENGINEER_WORKTABLE_AABB;
        }
        else
        {
           // return source.getBlockState(pos.east()).getBlock() == this ? EAST_ENGINEER_WORKTABLE_AABB : NOT_CONNECTED_AABB;
            
            return EAST_ENGINEER_WORKTABLE_AABB;
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*--------------------------------------------------------------------------*/
    /**
     * 方块自动更新。。。
     *
     *
     * */
	
	
	
	

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
    
    /*
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new EntityEngineerWorktable();
    }
    */
    
    
    /*--------------------------------------------------------------------------*/






    /*--------------------------------------------------------------------------*/
   /*
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityFurnace();
    }
*/


    /**
     * 从传递的blockstate返回具有给定旋转的blockstate。如果不适用，则返回通过的封锁状态。
     */

    @Override   //ok --- 每个方块里有！ 不要删除
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    /**
     * 从传递的blockstate返回具有给定旋转的blockstate。如果不适用，则返回通过的封锁状态。
     */

    @Override   //ok --- 每个方块里有！ 不要删除
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    /**
     * 调用的呈现函数的类型。混合的tesr模型和静态模型，只有tesr的MODELBLOCK_ANIMATED，
     * 液体为香草液体，不可见，跳过所有渲染
     */

    // OK ！！！不要删除
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }





    /**
     *在实际设置块之前由ItemBlocks调用，以允许对
     *伊布洛克状态
     */
    @Override   //ok 不要删除
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    /**
     *将给定的元数据转换为此块的块状态
     */
    @Override   //ok !
    public IBlockState getStateFromMeta(int meta)
    {
       return this.getDefaultState().withProperty(FACING, EnumFacing.byIndex(meta));
    }

    /**
     *将块状态转换为正确的元数据值
     */
    @Override   //ok +1
    public int getMetaFromState(IBlockState state)	//从状态获取元
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    /*--------------------------------------------------------------------------------------*/
    @Override   //ok +1
    protected BlockStateContainer createBlockState()	//块状态容器
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
    /*--------------------------------------------------------------------------------------*/



   /*--------------------------------------------------------------------------*/

    /**
	*获取查询面在给定位置和状态下的几何图形。这是用来决定
	*按钮可以放置在面上，或者玻璃面板如何与面连接，等等。
	*<p>
	*常见的值是{@code SOLID}，这是默认值，还有{@code UNDEFINED}，它表示
	*与其他描述不符，通常会导致其他事物与面部不相连。
	*
	*@返回给定表面形式的近似值
	*/
    /*
	@Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.SOLID;
    }
*/
}
