package economy.goods;

import cpw.mods.fml.common.registry.LanguageRegistry;
import economy.goods.books.ItemValueGuide;
import economy.resources.ResourcesInfo;
import net.minecraft.item.Item;

public class Goods {

	public static Item itemValueGuide;
	
	public static void init(){
		itemValueGuide = new ItemValueGuide(GoodsInfo.VALUEGUIDE_ID);
	}
	
	public static void addNames(){
		LanguageRegistry.addName(itemValueGuide, GoodsInfo.VALUEGUIDE_NAME);
	}
	
}
