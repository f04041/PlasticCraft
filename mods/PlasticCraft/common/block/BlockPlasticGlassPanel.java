package mods.PlasticCraft.common.block;

import java.util.List;

import mods.PlasticCraft.common.PlasticCraft;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlasticGlassPanel extends BlockPlasticPanel  {

	public BlockPlasticGlassPanel(int par1, String par2Str, String par3Str, Material par4Material, boolean par5) {
		super(par1, par3Str, par3Str, par4Material, par5);
		this.setCreativeTab(PlasticCraft.PlasticCaft);
		this.setLightOpacity(0);
		this.setBurnProperties(this.blockID, 5, 10);
		this.setTickRandomly(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return super.getIcon(par1, par2);
	}

	@Override
	public int getLightValue(final IBlockAccess world, final int x, final int y, final int z) {
		if(world.getBlockMetadata(x, y, z)==1) return 15;
		return 0;
	}

	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		// メタデータでブロックを追加する
		// par3List.add(new ItemStack(par1, 1, <メタデータ>));
		for (int i = 0; i < 2; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	  @Override
	  @SideOnly(Side.CLIENT)
	  public int getRenderBlockPass() {
	    return 1;
	  }

	@Override
    public boolean isOpaqueCube()
    {
        return false;
    }

	@Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta){
		return true;
	}

}