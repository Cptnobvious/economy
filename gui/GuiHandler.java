package economy.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import economy.ModEconomy;
import economy.producers.trader.ContainerTrader;
import economy.producers.trader.GuiTrader;
import economy.producers.trader.TETrader;

public class GuiHandler implements IGuiHandler {
	
	public GuiHandler(){
		NetworkRegistry.instance().registerGuiHandler(ModEconomy.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID){
		case 0:
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if (te != null && te instanceof TETrader){
				return new ContainerTrader(player.inventory, (TETrader)te);
			}
			break;
		}
	
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID){
		case 0:
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if (te != null && te instanceof TETrader){
				return new GuiTrader(player.inventory, (TETrader)te);
			}
			break;
		}
	
		return null;
	}

}
