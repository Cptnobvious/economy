package economy.resources;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPinkStuff extends Block {

	public BlockPinkStuff(int id) {
		super(id, Material.rock);
		
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(3F);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(ResourcesInfo.PINKSTUFF_UNLOCALIZED_NAME);
	}

	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register){
		blockIcon = register.registerIcon(ResourcesInfo.TEXTURE_LOCATION + ":" + ResourcesInfo.PINKSTUFF_TEXTURE);
	}
}
