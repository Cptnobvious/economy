package economy.producers.townhall;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import economy.producers.ProducersInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockTownHall extends BlockContainer{

	public BlockTownHall(int id) {
		super(id, Material.rock);
		
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(3F);
		setStepSound(Block.soundWoodFootstep);
		setUnlocalizedName(ProducersInfo.TOWNHALL_UNLOCALIZED_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register){
		blockIcon = register.registerIcon(ProducersInfo.TEXTURE_LOCATION + ":" + ProducersInfo.TOWNHALL_TEXTURE);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		return blockIcon;
	};

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}

}
