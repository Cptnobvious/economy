package economy.resources;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Resources {
	
	public static Block pinkStuff;
	
	public static Item currency;
	
	public static void init(){
		pinkStuff = new BlockPinkStuff(ResourcesInfo.PINKSTUFF_ID);
		GameRegistry.registerBlock(pinkStuff, ResourcesInfo.PINKSTUFF_KEY);
		
		currency = new ItemCurrency(ResourcesInfo.CURRENCY_ID);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(pinkStuff, ResourcesInfo.PINKSTUFF_NAME);
		
		LanguageRegistry.addName(currency, ResourcesInfo.CURRENCY_NAME);
	}
	
}
