package economy.producers.trader;

import java.text.DecimalFormat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import economy.resources.Resources;
import economy.standards.Standards;

@SideOnly(Side.CLIENT)
public class GuiTrader extends GuiContainer {
	
	private TETrader trader;
	private static final ResourceLocation texture = new ResourceLocation("economy", "textures/gui/tradergui.png");

	public GuiTrader(InventoryPlayer invplayer, TETrader te) {
		super(new ContainerTrader(invplayer, te));

		this.trader = te;
		
		xSize = 186;
		ySize = 177;
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
		
		
		str = "$";
		fontRenderer.drawString(str, 126, 10, 0x000000);
		
	}
}
