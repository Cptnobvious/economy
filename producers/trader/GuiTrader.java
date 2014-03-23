package economy.producers.trader;

import java.text.DecimalFormat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import economy.network.PacketHandler;
import economy.resources.Resources;
import economy.standards.Standards;

@SideOnly(Side.CLIENT)
public class GuiTrader extends GuiContainer {
	
	private TETrader trader;
	private int layer;
	private static final ResourceLocation texture = new ResourceLocation("economy", "textures/gui/tradergui.png");
	//private static final ResourceLocation shopTexture = new ResourceLocation

	public GuiTrader(InventoryPlayer invplayer, TETrader te) {
		super(new ContainerTrader(invplayer, te));

		this.trader = te;
		
		xSize = 186;
		ySize = 178;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1, 1, 1, 1);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
		drawTexturedModelRectFromIcon(guiLeft + 10, guiTop + 10, Resources.pinkStuff.getIcon(1, 0), 16, 16);
		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y){
		super.drawGuiContainerForegroundLayer(x, y);
		String str = "= " + Standards.PINKSTUFFORE_VALUE;
		fontRenderer.drawString(str, 28, 18, 0x000000);
		
		
		str = "$" + trader.getStash();
		fontRenderer.drawString(str, 126, 10, 0x000000);
		
	}
	
	@Override
	public void initGui(){
		super.initGui();
		buttonList.clear();
		
		GuiButton withdrawOne = new GuiButton(0, guiLeft + 107, guiTop + 46, 40, 20, "1");
		withdrawOne.enabled = true;
		buttonList.add(withdrawOne);
		
		GuiButton buyValueGuide = new GuiButton(1, guiLeft + 80, guiTop + 10, 40, 20, "Value Guide - 25");
		buyValueGuide.enabled = true;
		buttonList.add(buyValueGuide);
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button){
		PacketHandler.sendTraderPacket((byte)button.id);
		PacketHandler.sendTraderPacket((byte)button.id);
	}
}
