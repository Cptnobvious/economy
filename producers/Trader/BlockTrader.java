package economy.producers.Trader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import economy.producers.ProducersInfo;

public class BlockTrader extends Block {
	
	@SideOnly(Side.CLIENT)
	private Icon topIcon;

	public BlockTrader(int id) {
		super(id, Material.wood);
		
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(3F);
		setStepSound(Block.soundWoodFootstep);
		setUnlocalizedName(ProducersInfo.TRADER_UNLOCALIZED_NAME);
	}

	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register){
		blockIcon = register.registerIcon(ProducersInfo.TEXTURE_LOCATION + ":" + ProducersInfo.TRADER_SIDE_TEXTURE);
		topIcon = register.registerIcon(ProducersInfo.TEXTURE_LOCATION + ":" + ProducersInfo.TRADER_TOP_TEXTURE);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		if (side == 1){
			return topIcon;
		} else {
			return blockIcon;
		}
	}
	
}
