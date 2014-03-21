package economy.resources;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Resources {
	
	public static Block pinkStuff;
	
	public static void init(){
		pinkStuff = new BlockPinkStuff(ResourcesInfo.PINKSTUFF_ID);
		GameRegistry.registerBlock(pinkStuff, ResourcesInfo.PINKSTUFF_KEY);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(pinkStuff, ResourcesInfo.PINKSTUFF_NAME);
	}
	
}
