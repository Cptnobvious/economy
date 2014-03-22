package economy.producers.trader;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
	}

}
