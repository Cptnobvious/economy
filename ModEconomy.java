package economy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import economy.config.ConfigHandler;
import economy.goods.Goods;
import economy.gui.GuiHandler;
import economy.network.PacketHandler;
import economy.producers.Producers;
import economy.proxies.CommonProxy;
import economy.resources.Resources;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION)
@NetworkMod(channels = {ModInformation.CHANNEL}, clientSideRequired = true, serverSideRequired = true, packetHandler = PacketHandler.class)
public class ModEconomy {
	
	@Instance(ModInformation.ID)
	public static ModEconomy instance;
	
	@SidedProxy(clientSide = "economy.proxies.ClientProxy", serverSide = "economy.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		Resources.init();
		Producers.init();
		Goods.init();
		
		proxy.initSounds();
		proxy.initRenderers();
	}
	
	
	@EventHandler
	public void load(FMLInitializationEvent event){
		Resources.addNames();
		Producers.addNames();
		Goods.addNames();
		
		Producers.registerTileEntities();
		
		Producers.registerRecipes();
		
		new GuiHandler();
	}
	
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event) {
	
	}

}
