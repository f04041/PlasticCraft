package mods.PlasticCraft.common;

import java.util.logging.Level;

import mods.PlasticCraft.common.block.BlockPlasitcPanels;
import mods.PlasticCraft.common.block.BlockPlastic;
import mods.PlasticCraft.common.block.BlockPlasticGlass;
import mods.PlasticCraft.common.item.ItemBlockPlastic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="PlasticCraft", name="f04041-PlasticCraft", version="0.0")
public class PlasticCraft
{
	public static Block blockPlastic;
	public static Block blockPlastic2;
	public static Block blockPlasticGlass;
	public static Block blockPlasticGlass2;
	public static Block blockPlasticPanels;
	public static Block blockPlasticPanels2;
	public static int blockRootId = 4087;

	public static final CreativeTabs PlasticCaft = new CreativeTabFPC("PlasicCraft");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
		cfg.load();
		blockRootId = cfg.get("BlockId" , "blockRootId", 4087).getInt();

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
		//ブロックの登録
		blockPlastic=new BlockPlastic(blockRootId+0,Material.cloth).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlastic");
		blockPlastic2=new BlockPlastic(blockRootId+1,Material.cloth).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlastic2").setLightValue(1.0F);
		blockPlasticGlass=new BlockPlasticGlass(blockRootId+2,Material.glass,false).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlasticGlass").setTextureName("glass");
		blockPlasticGlass2=new BlockPlasticGlass(blockRootId+3,Material.glass,false).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlasticGlass2").setTextureName("glass").setLightValue(1.0F);
		blockPlasticPanels=new BlockPlasitcPanels(blockRootId+4, "glass", "glass", Material.glass, false).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlasticPanel");
		blockPlasticPanels2=new BlockPlasitcPanels(blockRootId+5, "glass", "glass", Material.glass, false).setHardness(0.0F).setResistance(2000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockPlasticPanel2").setLightValue(1.0F);

		GameRegistry.registerBlock(blockPlastic, ItemBlockPlastic.class, "blockPlastic");
		GameRegistry.registerBlock(blockPlastic2, ItemBlockPlastic.class, "blockPlastic2");
		GameRegistry.registerBlock(blockPlasticGlass, ItemBlockPlastic.class, "blockPlasticGlass");
		GameRegistry.registerBlock(blockPlasticGlass2, ItemBlockPlastic.class, "blockPlasticGlass2");
		GameRegistry.registerBlock(blockPlasticPanels, ItemBlockPlastic.class, "blockPlasticPanel");
		GameRegistry.registerBlock(blockPlasticPanels2, ItemBlockPlastic.class, "blockPlasticPanel2");
	}
}