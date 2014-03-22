package economy.producers.trader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import com.google.common.reflect.ClassPath.ResourceInfo;

import economy.resources.ResourcesInfo;
import economy.standards.Standards;

public class TETrader extends TileEntity implements IInventory {

	private ItemStack[] contents;
	private double stash;
	
	public TETrader(){
		contents = new ItemStack[3];
		stash = 0;
	}
	
	@Override
	public void updateEntity(){
		if (!worldObj.isRemote){
			if (getStackInSlot(0) != null){
				ItemStack stack = getStackInSlot(0);
				int amount = stack.stackSize;
				int id = stack.itemID;
				
				decrStackSize(0, amount);
				
				stash = stash + getValue(id, amount);
				System.out.println(stash);
			}
			
		}
		
	}
	
	private double getValue(int id, int amount){
		double total = 0;
		
		if (id == ResourcesInfo.PINKSTUFF_ID){
			total = amount * Standards.PINKSTUFFORE_VALUE;
		}
		
		System.out.println(id + " compared to " + ResourcesInfo.PINKSTUFF_ID);
		System.out.println(amount);
		System.out.println(total);
		
		return total;
	}

	public void setStash(double a){
		stash = a;
	}
	
	public double getStash(){
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
		
		onInventoryChanged();
	}

	@Override
	public String getInvName() {
		return "Trader";
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
		//This does nothing.
	}

	@Override
	public void closeChest() {
		//This does nothing.
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		
		if (i == 0){
			return true;
		} 
		
		return false;
	}

}
