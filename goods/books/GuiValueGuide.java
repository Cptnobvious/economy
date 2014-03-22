package economy.goods.books;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import economy.producers.trader.ContainerTrader;
import economy.producers.trader.TETrader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;


@SideOnly(Side.CLIENT)
public class GuiValueGuide extends GuiScreen{

	private static final ResourceLocation texture = new ResourceLocation("economy", "textures/gui/bookgui.png");

	public GuiValueGuide() {
		super();
		
		width = 128;
		height = 200;
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3) {
		this.drawDefaultBackground();
	}
	
}
