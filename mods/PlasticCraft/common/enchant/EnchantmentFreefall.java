package mods.PlasticCraft.common.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentFreefall extends Enchantment
{
	public EnchantmentFreefall(int id, int weight)
	{
		super(id,weight, EnumEnchantmentType.armor_feet);
	}

	public int getMinEnchantability(int par1)
	{
		return 15;
	}

	public int getMaxEnchantability(int par1)
	{
		return super.getMinEnchantability(par1) + 50;
	}

	public int getMaxLevel()
	{
		return 1;
	}
}