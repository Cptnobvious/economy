package economy.goods.books;

import java.util.List;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import economy.ModEconomy;
import economy.goods.GoodsInfo;
import economy.resources.ResourcesInfo;

public class ItemValueGuide extends Item {

	public ItemValueGuide(int id) {
		super(id);
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(1);
		setUnlocalizedName(GoodsInfo.VALUEGUIDE_UNLOCALIZED_NAME);
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ResourcesInfo.TEXTURE_LOCATION + ":" + GoodsInfo.VALUEGUIDE_TEXTURE);
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation) {
		info.add("A guide to what it's worth");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		return itemIcon;
	}


	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		/*
		if (!world.isRemote) {
			System.out.println("I got this far");
			FMLNetworkHandler.openGui(player, ModEconomy.instance, 1, world, x, y, z);
			return true;
		}
		
		return false;
		*/
		
		System.out.println("I got this far");
		FMLNetworkHandler.openGui(player, ModEconomy.instance, 1, world, x, y, z);
		return true;
		
	}
	
	
}
