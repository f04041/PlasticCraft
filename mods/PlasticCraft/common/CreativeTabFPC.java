package mods.PlasticCraft.common;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabFPC extends CreativeTabs {

	//クリエイティブタブのアイコン画像や名称の登録クラス
	public CreativeTabFPC(String type)
	{
		super(type);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return PlasticCraft.blockPlastic.blockID;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "MagicItems";
	}

}
