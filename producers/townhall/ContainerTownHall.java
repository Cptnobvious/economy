package economy.producers.townhall;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import economy.utility.SlotCurrency;
import economy.utility.SlotOutput;

public class ContainerTownHall extends Container{
	
	private TETownHall townHall;
	
	public ContainerTownHall(InventoryPlayer invPlayer, TETownHall townHall){
		this.townHall = townHall;
		
		//Adds the hotbar
		for (int x = 0; x < 9; x++){
			addSlotToContainer(new Slot(invPlayer, x, 12 + (19 * x), 175));
		}
				
				//Adds the inventory
		for (int y = 0; y < 3; y++){
			for (int x = 0; x < 9; x++){
				addSlotToContainer(new Slot(invPlayer, x + (y * 9) + 9, 12 + (19 * x), 111 + (y * 19)));
			}
		}
		
		addSlotToContainer(new SlotCurrency(townHall, 0, 9, 9));
		addSlotToContainer(new SlotOutput(townHall, 1, 126, 86));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer){
		return townHall.isUseableByPlayer(entityplayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i){
		return null;
	}
	
	@Override
	public void addCraftingToCrafters(ICrafting player){
		super.addCraftingToCrafters(player);
		
		player.sendProgressBarUpdate(this, 0, townHall.getStash());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data){
		switch(id){
			case 0:
				townHall.setStash(data);
		}
	}

	private int oldStash = -1;
	
	@Override
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		
		for (Object player : crafters){
			if (townHall.getStash() != oldStash){
				((ICrafting)player).sendProgressBarUpdate(this, 0, townHall.getStash());
			}
		}
	}
	
	public TETownHall getTownHall(){
		return townHall;
	}
}
