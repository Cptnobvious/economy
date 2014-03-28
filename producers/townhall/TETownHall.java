package economy.producers.townhall;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TETownHall extends TileEntity implements IInventory{
	
	ItemStack[] contents;
	private int stash;
	private String name = "Default";
	
	public TETownHall(){
		contents = new ItemStack[2];
		stash = 0;
	}

	public void setStash(int a){
		stash = a;
	}
	
	public int getStash() {
		return stash;
	}
	
	@Override
	public int getSizeInventory() {
		return contents.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return contents[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int count) {
		ItemStack itemstack = getStackInSlot(i);
		
		if (itemstack != null){
			if (itemstack.stackSize <= count){
				setInventorySlotContents(i, null);
			} else {
				itemstack = itemstack.splitStack(count);
				onInventoryChanged();
			}
		}
		
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		ItemStack item = getStackInSlot(i);
		
		setInventorySlotContents(i, null);
		
		return item;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		contents[i] = itemstack;
		
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()){
			itemstack.stackSize = getInventoryStackLimit();
		}
		
	}

	@Override
	public String getInvName() {
		return name;
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}


}
