package mods.PlasticCraft.common.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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