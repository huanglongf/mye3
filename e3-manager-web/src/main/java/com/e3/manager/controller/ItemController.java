package com.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3.manager.service.ItemService;
import com.e3.pojo.TbItem;
import com.e3.pojo.TbItemDesc;
import com.e3.utils.DatagridPagebean;
import com.e3.utils.E3mallResult;

@Controller
public  class ItemController {
	
	@Autowired
	private ItemService service;
	
	@RequestMapping("item/list/{itemId}")
	@ResponseBody
	public TbItem findItemById(@PathVariable Long itemId){
		TbItem item = service.findItemById(itemId);
		return item;
	
	};
	
	
	@RequestMapping("/item/list")
	@ResponseBody
	public DatagridPagebean findItemListByPage(@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="30") Integer rows){
		DatagridPagebean pagebean = service.findItemListByPage(page, rows);
		return pagebean;
	};
	
	@RequestMapping("/item/save")
	@ResponseBody
	public E3mallResult saveItem(TbItem tbItem,TbItemDesc itemDesc){
		E3mallResult result = service.saveItem(tbItem, itemDesc);
		return result;
	};
}
