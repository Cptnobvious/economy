package economy.producers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import economy.producers.hut.BlockHut;
import economy.producers.townhall.BlockTownHall;
import economy.producers.townhall.TETownHall;
import economy.producers.trader.BlockTrader;
import economy.producers.trader.TETrader;

public class Producers {

	public static Block trader;
	public static Block townHall;
	public static Block hut;
	
	public static void init(){
		trader = new BlockTrader(ProducersInfo.TRADER_ID);
		GameRegistry.registerBlock(trader, ProducersInfo.TRADER_KEY);
		
		townHall = new BlockTownHall(ProducersInfo.TOWNHALL_ID);
		GameRegistry.registerBlock(townHall, ProducersInfo.TOWNHALL_KEY);
		
		hut = new BlockHut(ProducersInfo.HUT_ID);
		GameRegistry.registerBlock(hut, ProducersInfo.HUT_KEY);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(trader, ProducersInfo.TRADER_NAME);
		LanguageRegistry.addName(townHall, ProducersInfo.TOWNHALL_NAME);
		LanguageRegistry.addName(hut, ProducersInfo.HUT_NAME);
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
		GameRegistry.registerTileEntity(TETownHall.class, ProducersInfo.TOWNHALL_TE_KEY);
	}
}
