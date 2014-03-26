package economy.utility;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import economy.resources.ResourcesInfo;

public class SlotResource extends Slot {

	public SlotResource(IInventory inventory, int id, int x, int y) {
		super(inventory, id, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack){
		boolean acceptable = false;
		int id = stack.itemID;
		
		if (id == ResourcesInfo.PINKSTUFF_ID) {acceptable = true;}
		if (id == ResourcesInfo.GOLDCOIN_ID + 256) {acceptable = true;}
		if (id == ResourcesInfo.COPPERCOIN_ID + 256) {acceptable = true;}
		
		return acceptable;
	}

}
