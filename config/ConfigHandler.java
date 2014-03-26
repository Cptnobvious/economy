package economy.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import economy.goods.GoodsInfo;
import economy.producers.ProducersInfo;
import economy.resources.ResourcesInfo;
import economy.standards.Standards;



public class ConfigHandler {

	public static void init(File file){
		Configuration config = new Configuration(file);
		
		config.load();
		
		/* Defaults
		 * Items:
		 * 24201 - Gold Coin
		 * 24202 - Value Guide
		 * 24203 - Copper Coin
		 * 
		 * Blocks:
		 * 2100 - Pinkstuff Ore
		 * 2101 - Trader
		 * 2102 - Town Hall
		 * 2103 - Hut
		 * 
		 */
		
		//Load resources
		ResourcesInfo.PINKSTUFF_ID = config.getBlock(ResourcesInfo.PINKSTUFF_KEY, ResourcesInfo.PINKSTUFF_DEFAULT).getInt();
		ResourcesInfo.GOLDCOIN_ID = config.getItem(ResourcesInfo.GOLDCOIN_KEY, ResourcesInfo.GOLDCOIN_DEFAULT).getInt() - 256;
		ResourcesInfo.COPPERCOIN_ID = config.getItem(ResourcesInfo.COPPERCOIN_KEY, ResourcesInfo.COPPERCOIN_DEFAULT).getInt() - 256;
		
		//Load producers
		ProducersInfo.TRADER_ID = config.getBlock(ProducersInfo.TRADER_KEY, ProducersInfo.TRADER_DEFAULT).getInt();
		ProducersInfo.TOWNHALL_ID = config.getBlock(ProducersInfo.TOWNHALL_KEY, ProducersInfo.TOWNHALL_DEFAULT).getInt();
		ProducersInfo.HUT_ID = config.getBlock(ProducersInfo.HUT_KEY, ProducersInfo.HUT_DEFAULT).getInt();
		
		//Load standards
		Standards.PINKSTUFFORE_VALUE = config.get("Standards", "Pinkstuff Ore Value", Standards.PINKSTUFFORE_VALUE_DEFAULT).getInt();
		
		//Load Goods
		GoodsInfo.VALUEGUIDE_ID = config.get("Goods", GoodsInfo.VALUEGUIDE_KEY, GoodsInfo.VALUEGUIDE_DEFAULT).getInt() - 256;
		
		config.save();
	}
	
}
