package mods.PlasticCraft.common.block;

import java.util.List;

import mods.PlasticCraft.common.PlasticCraft;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPlastic2 extends BlockColored {

	public BlockPlastic2(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(PlasticCraft.PlasticCaft);
		this.setTextureName("wood");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return super.getIcon(par1, par2);
	}

	@Override
	public int damageDropped(int par1)
	{
		return par1;
	}

	@Override
	public void onFallenUpon( World world, int bx, int by, int bz, Entity entity, float par6 ) {
		if(world.getBlockMetadata(bx, by, bz)==0) entity.fallDistance = 0;
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < 1; i++) {
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta){
		return true;
	}

}