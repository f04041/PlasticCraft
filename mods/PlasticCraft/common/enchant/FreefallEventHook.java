package mods.PlasticCraft.common.enchant;

import mods.PlasticCraft.common.PlasticCraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class FreefallEventHook
{
	@ForgeSubscribe
	public void jumpToHomeEvent(LivingHurtEvent event)
	{
		EntityLivingBase entity = event.entityLiving;
		ItemStack armor;
		boolean freefallEnchanted = false;
		int lv;
		for(int i = 1;i < 5; i++){
			armor = entity.getCurrentItemOrArmor(i);
			lv = EnchantmentHelper.getEnchantmentLevel(PlasticCraft.idFreefall, armor);
			if(lv > 0){
				freefallEnchanted = true;
				break;
			}
		}
		if(freefallEnchanted){
			entity.fallDistance = 0.0f;
			event.setCanceled(true);
		}
	}
}