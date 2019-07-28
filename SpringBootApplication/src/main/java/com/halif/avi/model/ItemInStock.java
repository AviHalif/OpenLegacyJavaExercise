package com.halif.avi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemInStock {
	
	@Id
	private int itemNo;
	private String itemName;
	private int itemAmount;
	private int itemInventoryCode;

	
	public ItemInStock() {
		
		super();
	}
	
	public ItemInStock(int itemNo, String itemName, int itemAmount, int itemInventoryCode) {

		super();
		this.setItemNo(itemNo);
		this.setItemName(itemName);
		this.setItemAmount(itemAmount);
		this.setItemInventoryCode(itemInventoryCode);
	}
	
	public void setItemNo(int itemNo) {
		
		if(itemNo>0)
			this.itemNo = itemNo;
	}
	
	public int getItemNo() {
		return itemNo;
	}

	public void setItemName(String itemName) {
		
		if(itemName != null && !itemName.isEmpty())
			this.itemName = itemName;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemAmount(int itemAmount) {
		
		if(itemAmount>=0)
			this.itemAmount = itemAmount;
	}
	
	public int getItemAmount() {
		return itemAmount;
	}
	
	public void setItemInventoryCode(int itemInventoryCode) {
		
		if(itemInventoryCode>0)
			this.itemInventoryCode = itemInventoryCode;
	}
	
	public int getItemInventoryCode() {
		return itemInventoryCode;
	}
	
	@Override
	public String toString() {
		return "Item number: " + this.getItemNo() + " = " + " [ItemName: " + itemName + ", itemAmount: " + itemAmount + ", itemInventoryCode: " + itemInventoryCode + "]";
	}

}


