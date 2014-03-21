package economy.config;

import java.io.File;

import economy.producers.ProducersInfo;
import economy.resources.ResourcesInfo;
import net.minecraftforge.common.Configuration;



public class ConfigHandler {

	public static void init(File file){
		Configuration config = new Configuration(file);
		
		config.load();
		
		ResourcesInfo.PINKSTUFF_ID = config.getBlock(ResourcesInfo.PINKSTUFF_KEY, ResourcesInfo.PINKSTUFF_DEFAULT).getInt();
		
		ProducersInfo.TRADER_ID = config.getBlock(ProducersInfo.TRADER_KEY, ProducersInfo.TRADER_DEFAULT).getInt();
		
		config.save();
	}
	
}
