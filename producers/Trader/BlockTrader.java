package economy.producers.trader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import economy.ModEconomy;
import economy.producers.ProducersInfo;

public class BlockTrader extends BlockContainer {
	
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

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (!world.isRemote) {
			FMLNetworkHandler.openGui(player, ModEconomy.instance, 0, world, x, y, z);
			
		}
	
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TETrader();
	}
	
}
