package economy.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import economy.producers.ProducersInfo;
import economy.resources.ResourcesInfo;
import economy.standards.Standards;



public class ConfigHandler {

	public static void init(File file){
		Configuration config = new Configuration(file);
		
		config.load();
		
		ResourcesInfo.PINKSTUFF_ID = config.getBlock(ResourcesInfo.PINKSTUFF_KEY, ResourcesInfo.PINKSTUFF_DEFAULT).getInt();
		ResourcesInfo.CURRENCY_ID = config.getItem(ResourcesInfo.CURRENCY_KEY, ResourcesInfo.CURRENCY_DEFAULT).getInt() - 256;
		
		ProducersInfo.TRADER_ID = config.getBlock(ProducersInfo.TRADER_KEY, ProducersInfo.TRADER_DEFAULT).getInt();
		
		//Load standards
		Standards.PINKSTUFFORE_VALUE = config.get("Standards", "Pinkstuff Ore Value", Standards.PINKSTUFFORE_VALUE_DEFAULT).getInt();
		
		config.save();
	}
	
}
