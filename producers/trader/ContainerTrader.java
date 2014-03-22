package economy.producers.trader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import economy.utility.SlotCurrency;
import economy.utility.SlotResource;

public class ContainerTrader extends Container{

	private TETrader trader;
	
	public ContainerTrader(InventoryPlayer invPlayer, TETrader trader){
		this.trader = trader;
		
		//Adds the hotbar
		for (int x = 0; x < 9; x++){
			addSlotToContainer(new Slot(invPlayer, x, 5 + (19 * x), 155));
		}
		
		//Adds the inventory
		for (int y = 0; y < 3; y++){
			for (int x = 0; x < 9; x++){
				addSlotToContainer(new Slot(invPlayer, x + (y * 9) + 9, 5 + (19 * x), 91 + (y * 19)));
			}
		}
		
		/*for (int x = 0; x < 3; x++){
			addSlotToContainer(new Slot(trader, x, 8 + 18 * x, 17));
		}*/
		
		addSlotToContainer(new SlotResource(trader, 0, 42, 67));
		addSlotToContainer(new SlotCurrency(trader, 1, 108, 67));
		addSlotToContainer(new SlotCurrency(trader, 2, 128, 67));
		
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
	
	@Override
	public void addCraftingToCrafters(ICrafting player){
		super.addCraftingToCrafters(player);
		
		player.sendProgressBarUpdate(this, 0, trader.getStash());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data){
		switch (id){
			case 0:
				trader.setStash(data);
		}
	}
	
	private int oldStash = 0;
	
	@Override
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		
		for (Object player : crafters){
			if (trader.getStash() != oldStash){
				((ICrafting)player).sendProgressBarUpdate(this, 0, trader.getStash());
			}
		}
		
	}
	
}
