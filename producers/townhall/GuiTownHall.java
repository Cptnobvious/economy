package economy.producers.townhall;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTownHall extends GuiContainer {

	private TETownHall townHall;
	private static final ResourceLocation texture = new ResourceLocation("economy", "textures/gui/townhallgui.png");
	
	
	public GuiTownHall(InventoryPlayer invplayer, TETownHall te) {
		super(new ContainerTownHall(invplayer, te));
		
		this.townHall = te;
		
		xSize = 191;
		ySize = 193;
	}
	
	@Override 
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j){
		GL11.glColor4f(1, 1, 1, 1);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
