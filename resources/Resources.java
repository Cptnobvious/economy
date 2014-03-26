package economy.resources;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Resources {
	
	public static Block pinkStuff;
	
	public static Item goldCoin;
	public static Item copperCoin;
	
	public static void init(){
		pinkStuff = new BlockPinkStuff(ResourcesInfo.PINKSTUFF_ID);
		GameRegistry.registerBlock(pinkStuff, ResourcesInfo.PINKSTUFF_KEY);
		
		goldCoin = new ItemGoldCoin(ResourcesInfo.GOLDCOIN_ID);
		copperCoin = new ItemCopperCoin(ResourcesInfo.COPPERCOIN_ID);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(pinkStuff, ResourcesInfo.PINKSTUFF_NAME);
		
		LanguageRegistry.addName(goldCoin, ResourcesInfo.GOLDCOIN_NAME);
		LanguageRegistry.addName(copperCoin, ResourcesInfo.COPPERCOIN_NAME);
	}
	
}
