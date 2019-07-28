package com.halif.avi.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halif.avi.crud.repository.ItemRepository;
import com.halif.avi.model.ItemInStock;

@Service
public class ItemService 
{
	@Autowired
	ItemRepository itemRepository;

	public ArrayList<ItemInStock> getAllItems()
	{
		ArrayList<ItemInStock> itemsList = new ArrayList<ItemInStock>();
		itemRepository.findAll().forEach(itemsList::add);
		return itemsList;
	}

	public String addItem(ItemInStock item)
	{
		ItemInStock savedItem =  itemRepository.save(item);
		
		if(savedItem != null)
		{
			return "Saved : Item number - " + savedItem.getItemNo();
		}
		else
		{
			return "Failed : Item number - " + item.getItemNo();
		}
	}

	public void deleteItem(int itemNo) 
	{
		itemRepository.deleteById(itemNo);
	}

	public ArrayList<ItemInStock> getItemByItemNo(int itemNo) 
	{
		ArrayList<ItemInStock> itemsList = new ArrayList<ItemInStock>();
		itemsList.add(itemRepository.findById(itemNo).get());
		return itemsList; 
	}

	public int getAmountItemByItemNo(int itemNo) 
	{
		ArrayList<ItemInStock> itemsList = new ArrayList<ItemInStock>();
		itemsList.add(itemRepository.findById(itemNo).get());
		
		return itemsList.get(0).getItemAmount();
	}

	public String addAmountItem(ItemInStock itemWithUpdatedAmount)
	{
		ItemInStock savedItem =  itemRepository.save(itemWithUpdatedAmount);
		
		if(savedItem != null)
		{
			return "Update amount : Item number - " + savedItem.getItemNo();
		}
		else
		{
			return "Failed update amount : Item number - " + itemWithUpdatedAmount.getItemNo();
		}
	}
}
