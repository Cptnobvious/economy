package economy.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import economy.ModInformation;
import economy.producers.trader.ContainerTrader;
import economy.producers.trader.TETrader;

public class PacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		ByteArrayDataInput reader = ByteStreams.newDataInput(packet.data);
		
		EntityPlayer entityPlayer = (EntityPlayer)player;
		
		byte packetId = reader.readByte();
		
		switch(packetId){
			case 0:
				byte buttonId = reader.readByte();
				Container container = entityPlayer.openContainer;
				if (container != null && container instanceof ContainerTrader){
					TETrader trader = ((ContainerTrader)container).getTrader();
					trader.recieveButtonEvent(buttonId);
				}
				break;
		}
	}
	
	public static void sendTraderPacket(byte id) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);

		try {
			dataStream.writeByte((byte)0);
			dataStream.writeByte(id);
			
			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(ModInformation.CHANNEL, byteStream.toByteArray()));
		}catch(IOException ex) {
			System.err.append("Failed to send button click packet");
		}
	}

}
