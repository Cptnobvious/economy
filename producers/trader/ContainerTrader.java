package economy.producers.trader;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTrader extends Container{

	private TETrader trader;
	
	public ContainerTrader(InventoryPlayer invPlayer, TETrader trader){
		this.trader = trader;
		
		//Adds the hotbar
		for (int x = 0; x < 9; x++){
			addSlotToContainer(new Slot(invPlayer, x, 5 + (19 * x), 157));
		}
		
		//Adds the inventory
		for (int y = 0; y < 3; y++){
			for (int x = 0; x < 9; x++){
				addSlotToContainer(new Slot(invPlayer, x + (y * 9) + 9, 5 + 19 * x, 95 + y * 19));
			}
		}
		
		/*for (int x = 0; x < 3; x++){
			addSlotToContainer(new Slot(trader, x, 8 + 18 * x, 17));
		}*/
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return trader.isUseableByPlayer(entityplayer);
	}

	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i){
		/*Slot slot = getSlot(i);
		if (slot != null && slot.getHasStack()){
			ItemStack stack = slot.getStack();
			ItemStack result = stack.copy();
			
			if (i >= 36){
				if (!mergeItemStack(stack, 0, 36, false)){
					return null;
				}
			} else if (stack.itemID != Block.anvil.blockID || !mergeItemStack(stack, 36, 36 + machine.getSizeInventory(), false)) {
				return null;
			}
			
			if (stack.stackSize == 0){
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
			
			slot.onPickupFromSlot(player, stack);
			
			return result;
		}*/
		
		return null;
	}
	
}