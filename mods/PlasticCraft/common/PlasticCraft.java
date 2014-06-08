package mods.PlasticCraft.common;

import java.util.logging.Level;

import mods.PlasticCraft.common.block.BlockPlasitcGlassPanelC;
import mods.PlasticCraft.common.block.BlockPlastic;
import mods.PlasticCraft.common.block.BlockPlastic2;
import mods.PlasticCraft.common.block.BlockPlasticGlass;
import mods.PlasticCraft.common.block.BlockPlasticGlassC;
import mods.PlasticCraft.common.block.BlockPlasticGlassPanel;
import mods.PlasticCraft.common.enchant.EnchantmentFreefall;
import mods.PlasticCraft.common.enchant.FreefallEventHook;
import mods.PlasticCraft.common.item.ItemBlockPlastic;
import mods.PlasticCraft.common.item.ItemPlastic1;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="PlasticCraft", name="f04041-PlasticCraft", version="0.0")
public class PlasticCraft
{
	public static Item itemPlastic1;
	public static int itemRootId;
	public static Block blockPlastic;
	public static Block blockPlastic2;
	public static Block blockPlasticGlass;
	public static Block blockPlasticGlassPanel;
	public static Block blockPlasticGlassC;
	public static Block blockPlasticGlassC2;
	public static Block blockPlasticGlassPanelC;
	public static Block blockPlasticGlassPanelC2;
	public static Block blockPlastic3;
	public static int blockRootId;

	public static Enchantment freefall;
	public static int idFreefall;

	public static final CreativeTabs PlasticCaft = new CreativeTabFPC("PlasicCraft");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
		cfg.load();
		itemRootId = cfg.get("ItemId", "ItemRootId", 10000).getInt();
		blockRootId = cfg.get("BlockId" , "blockRootId", 4087).getInt();
		idFreefall = cfg.get(Configuration.CATEGORY_GENERAL, "idFreefall", 30, "Freefall Enchantment Id").getInt();

		}
		catch (Exception e)
		{

		FMLLog.log(Level.SEVERE, e, "Error Massage");
		}
		finally
		{
		cfg.save();
		}

	}

	@EventHandler
	public void init(FMLInitializationEvent event){
		itemPlastic1 = new ItemPlastic1(itemRootId).setUnlocalizedName("itemPlastic1").setTextureName("stick").setCreativeTab(PlasticCaft);

				blockPlastic=new BlockPlastic(blockRootId+0,Material.cloth).setHardness(0.2F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlastic");
		blockPlastic2=new BlockPlastic(blockRootId+1,Material.cloth).setHardness(0.2F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlastic2").setLightValue(1.0F);
		blockPlasticGlass=new BlockPlasticGlass(blockRootId+2,Material.glass,false).setHardness(0.2F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlasticGlass").setTextureName("glass");
		blockPlasticGlassPanel=new BlockPlasticGlassPanel(blockRootId+3, "glass", "glass", Material.glass, true).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlasticGlassPanel").setTextureName("glass");
		blockPlasticGlassC=new BlockPlasticGlassC(blockRootId+4,Material.glass,false).setHardness(0.2F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlasticGlassC").setTextureName("glass");
		blockPlasticGlassC2=new BlockPlasticGlassC(blockRootId+5,Material.glass,false).setHardness(0.2F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlasticGlassC2").setTextureName("glass").setLightValue(1.0F);
		blockPlasticGlassPanelC=new BlockPlasitcGlassPanelC(blockRootId+6, "glass", "glass", Material.glass, true).setHardness(0.2F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlasticGlassPanelC");
		blockPlasticGlassPanelC2=new BlockPlasitcGlassPanelC(blockRootId+7, "glass", "glass", Material.glass, true).setHardness(0.2F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlasticGlassPanelC2").setLightValue(1.0F);
		blockPlastic3=new BlockPlastic2(blockRootId+8,Material.cloth).setHardness(0.5F).setResistance(2000.0F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("blockPlastic3");
		freefall = new EnchantmentFreefall(idFreefall, 0).setName("freefall");
		MinecraftForge.EVENT_BUS.register(new FreefallEventHook());

		GameRegistry.registerBlock(blockPlastic, ItemBlockPlastic.class, "blockPlastic");
		GameRegistry.registerBlock(blockPlastic2, ItemBlockPlastic.class, "blockPlastic2");
		GameRegistry.registerBlock(blockPlasticGlass, ItemBlockPlastic.class, "blockPlasticGlass");
		GameRegistry.registerBlock(blockPlasticGlassPanel, ItemBlockPlastic.class, "blockPlasticGlassPanel");
		GameRegistry.registerBlock(blockPlasticGlassC, ItemBlockPlastic.class, "blockPlasticGlassC");
		GameRegistry.registerBlock(blockPlasticGlassC2, ItemBlockPlastic.class, "blockPlasticGlassC2");
		GameRegistry.registerBlock(blockPlasticGlassPanelC, ItemBlockPlastic.class, "blockPlasticGlassPanelC");
		GameRegistry.registerBlock(blockPlasticGlassPanelC2, ItemBlockPlastic.class, "blockPlasticGlassPanelC2");
		GameRegistry.registerBlock(blockPlastic3, ItemBlockPlastic.class, "blockPlastic3");

	}
}