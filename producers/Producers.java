package economy.producers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import economy.producers.trader.BlockTrader;
import economy.producers.trader.TETrader;

public class Producers {

	public static Block trader;
	
	public static void init(){
		trader = new BlockTrader(ProducersInfo.TRADER_ID);
		GameRegistry.registerBlock(trader, ProducersInfo.TRADER_KEY);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(trader, ProducersInfo.TRADER_NAME);
	}

	public static void registerRecipes(){
		GameRegistry.addRecipe(new ItemStack(trader), 
				new Object[] {	"gpg",
								"www",
								"www",
								'g', Item.ingotGold,
								'p', Item.paper,
								'w', Block.wood});
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TETrader.class, ProducersInfo.TRADER_TE_KEY);
	}
}
