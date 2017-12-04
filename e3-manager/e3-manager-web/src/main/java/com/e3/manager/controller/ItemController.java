package com.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3.manager.service.ItemService;
import com.e3.pojo.TbItem;

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
}
