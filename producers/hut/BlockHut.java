package economy.producers.hut;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import economy.producers.ProducersInfo;

public class BlockHut extends BlockContainer{

	public BlockHut(int id) {
		super(id, Material.rock);

		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(3F);
		setStepSound(Block.soundWoodFootstep);
		setUnlocalizedName(ProducersInfo.HUT_UNLOCALIZED_NAME);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register){
		blockIcon = register.registerIcon(ProducersInfo.TEXTURE_LOCATION + ":" + ProducersInfo.HUT_TEXTURE);
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