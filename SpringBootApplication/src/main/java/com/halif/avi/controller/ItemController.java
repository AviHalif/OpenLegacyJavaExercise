package com.halif.avi.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.halif.avi.model.ItemInStock;
import com.halif.avi.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path="/api/items")
@Api(value = "ItemControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController 
{
	@Autowired
	ItemService itemService;
	
   @PostMapping("/addItem")
   @ApiOperation("Add item to stock")
   @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = String.class)})
	public String addItem(@RequestBody ItemInStock item)
	{
	   return itemService.addItem(item);
	}
   
   @DeleteMapping("/deleteItem/{itemNo}")
   @ApiOperation("Delete an item from stock")
   @ApiResponses(value = {@ApiResponse(code = 300, message = "OK")})
	public void deleteItem(@PathVariable(name="itemNo") int itemNo)
	{
	   itemService.deleteItem(itemNo);
	}
   
   @PutMapping("/addAmountItem/{itemNo}/{itemAmount}")
   @ApiOperation("Deposit quantity of a specific item to stock")
   @ApiResponses(value = {@ApiResponse(code = 400, message = "OK", response = String.class)})
	public String addAmountItem(@PathVariable(name="itemNo") int itemNo, @PathVariable(name="itemAmount") int itemAmount)
	{
	   ArrayList<ItemInStock> itemsList = new ArrayList<ItemInStock>();
	   itemsList.addAll(itemService.getItemByItemNo(itemNo));
	   
	   itemsList.get(0).setItemAmount(itemsList.get(0).getItemAmount() + itemAmount);
	   
	   return itemService.addAmountItem(itemsList.get(0));
	}
   
   @GetMapping("/getItemByItemNo/{itemNo}")
   @ApiOperation("Read item details (by item no)")
   @ApiResponses(value = {@ApiResponse(code = 500, message = "OK", response = ArrayList.class)})
	public ArrayList<ItemInStock> getItemByItemNo(@PathVariable(name="itemNo") int itemNo)
	{
       ArrayList<ItemInStock> itemsList = new ArrayList<ItemInStock>();
	   itemsList.addAll(itemService.getItemByItemNo(itemNo));
	   
	   return itemsList; 
	}
   
   @GetMapping("/getAmountItemByItemNo/{itemNo}")
   @ApiOperation("Withdrawal quantity of a specific item from stock")
   @ApiResponses(value = {@ApiResponse(code = 600, message = "OK", response = Integer.class)})
	public int getAmountItemByItemNo(@PathVariable(name="itemNo") int itemNo)
	{
	   int amountItem = itemService.getAmountItemByItemNo(itemNo);
	   
	   return amountItem;
	}
	
   @GetMapping("/getAllItems")
   @ApiOperation("List of the inventory items list (item no, name, amount, inventory code)")
   @ApiResponses(value = {@ApiResponse(code = 700, message = "OK", response = ArrayList.class)})
	public ArrayList<ItemInStock> getAllItems()
	{
	   ArrayList<ItemInStock> itemList = new ArrayList<ItemInStock>();
	   itemList.addAll(itemService.getAllItems());
	   
	   return itemList; 
	}
}
