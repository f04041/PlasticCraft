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
	public int dur1,dur2,dur3;
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
    	NBTTagCompound fnbt1 = par1ItemStack.getTagCompound();
    	if(fnbt1 == null)
		{
    		fnbt1 = new NBTTagCompound();
			par1ItemStack.setTagCompound(fnbt1);
		}
    	fnbt1.setInteger("dur1", 12);
    	fnbt1.setInteger("dur2", 120);
    	fnbt1.setInteger("dur3", 128);
    	fnbt1.setBoolean("mode", false);


    	if(i1 == Block.wood.blockID && par1ItemStack.getItemDamage() == 0&&par2EntityPlayer.inventory.hasItem(Item.bowlEmpty.itemID)){
   		 if(dur1==0){
			 --par1ItemStack.stackSize;
		 }else{
    		ItemStack item = new ItemStack(Item.bowlEmpty);
    		 dur1 = fnbt1.getInteger("dur1");
    		 dur1=dur1-1;
    		--item.stackSize;
    		fnbt1.setInteger("dur1",12);
		 }
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
    public int getDisplayDamage(ItemStack stack){
    	if(stack.getItemDamage()==0){
    		NBTTagCompound fnbt1 = stack.getTagCompound();
    		return dur1;
    	}else{
    		return 0;
    	}
    }
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return super.getUnlocalizedName() + "_" + par1ItemStack.getItemDamage();
	}

}
