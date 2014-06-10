package mods.PlasticCraft.common.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemPlastic1 extends Item
{
	public ItemPlastic1(int par1)
	{
		super(par1);
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}

    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int i = 0; i < 5; ++i)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	int i1 = par3World.getBlockId(par4, par5, par6);
    	Block block = Block.wood;
    	par1ItemStack.stackTagCompound = new NBTTagCompound();
    	par1ItemStack.stackTagCompound.setInteger("dur1", 12);
    	par1ItemStack.stackTagCompound.setInteger("dur2", 120);
    	par1ItemStack.stackTagCompound.setInteger("dur3", 128);


    	if(i1 == Block.sand.blockID && par1ItemStack.getItemDamage() == 0){

    		--par1ItemStack.stackSize;
    		return true;
    	}else{
    		return false;
    	}
    }

	@Override
	public int getItemStackLimit( ItemStack items ) {
		if(items.getItemDamage()==0){
			return 1;
		}else{
			return 64;
		}
	}



	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return super.getUnlocalizedName() + "_" + par1ItemStack.getItemDamage();
	}

}