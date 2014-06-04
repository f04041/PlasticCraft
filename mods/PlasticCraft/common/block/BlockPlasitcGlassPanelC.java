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

public class BlockPlasitcGlassPanelC extends BlockPlasticPanel  {

	public BlockPlasitcGlassPanelC(int par1, String par2Str, String par3Str, Material par4Material, boolean par5) {
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

    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==1) return 15435844;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==2) return 12801229;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==3) return 6719955;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==4) return 14602026;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==5) return 4312372;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==6) return 14188952;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==7) return 4408131;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==8) return 11250603;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==9) return 2651799;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==10) return 8073150;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==11) return 2437522;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==12) return 5320730;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==13) return 3887386;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==14) return 11743532;
    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4)==15) return 1973019;
    	return 15790320;
    }

	@Override
	public int getRenderColor(int par1) {
		return getTypeColor(par1);
	}

	private int getTypeColor(int j) {
		switch(j) {
		case 1:
			return 15435844;
		case 2:
			return 12801229;
		case 3:
			return 6719955;
		case 4:
			return 14602026;
		case 5:
			return 4312372;
		case 6:
			return 14188952;
		case 7:
			return 4408131;
		case 8:
			return 11250603;
		case 9:
			return 2651799;
		case 10:
			return 8073150;
		case 11:
			return 2437522;
		case 12:
			return 5320730;
		case 13:
			return 3887386;
		case 14:
			return 11743532;
		case 15:
			return 1973019;
		}
		return 15790320;
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
		for (int i = 0; i < 16; i++) {
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