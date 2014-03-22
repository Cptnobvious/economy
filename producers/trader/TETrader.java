package economy.producers.trader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import economy.resources.ResourcesInfo;
import economy.standards.Standards;

public class TETrader extends TileEntity implements IInventory {

	private ItemStack[] contents;
	private int stash;
	
	public TETrader(){
		contents = new ItemStack[3];
		stash = 0;
	}
	
	@Override
	public void updateEntity(){
		//if (!worldObj.isRemote){
			if (getStackInSlot(0) != null){
				ItemStack stack = getStackInSlot(0);
				int amount = stack.stackSize;
				int id = stack.itemID;
				
				decrStackSize(0, amount);
				
				stash = stash + getValue(id, amount);
			}
			
		//}
		
	}
	
	private int getValue(int id, int amount){
		int total = 0;
		
		if (id == ResourcesInfo.PINKSTUFF_ID){
			total = amount * Standards.PINKSTUFFORE_VALUE;
		} else if (id == ResourcesInfo.CURRENCY_ID +256){
			total = amount * Standards.CURRENCY_VALUE;
		}
		
		return total;
	}

	public void setStash(int a){
		stash = a;
	}
	
	public int getStash(){
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

	@Override
	public void writeToNBT(NBTTagCompound compound){
		super.writeToNBT(compound);
		
		NBTTagList items = new NBTTagList();
		
		for (int i = 0; i < getSizeInventory(); i++){
			ItemStack stack = getStackInSlot(i);
			
			if (stack != null){
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte)i);
				//Then use the stack's own nbt function
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		}
		
		compound.setTag("Items", items);
		
		compound.setInteger("Stash", stash);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
		super.readFromNBT(compound);
		
		NBTTagList items = compound.getTagList("Items");
		
		for (int i = 0; i < items.tagCount(); i++){
			NBTTagCompound item = (NBTTagCompound)items.tagAt(i);
			int slot = item.getByte("Slot");
			if (slot >= 0 && slot < getSizeInventory()){
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
		
		
		setStash(compound.getInteger("Stash"));
	}

	public void recieveButtonEvent(byte id) {
		switch (id){
			case 0:
				withdrawOne();
				break;
		}
	}

	private void withdrawOne() {

		if (getStash() >= 1){
			ItemStack stack = new ItemStack(ResourcesInfo.CURRENCY_ID + 256, 1, 0);
			setStash(getStash() - 1);
			if (getStackInSlot(1) != null && getStackInSlot(1).itemID == ResourcesInfo.CURRENCY_ID + 256){
				stack = getStackInSlot(1);
				if (stack.stackSize < 64) {
					stack.stackSize = stack.stackSize + 1;
					setInventorySlotContents(1, stack);
				}
			} else {
				setInventorySlotContents(1, stack);
			}
		}
	}
	
}
