package com.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3.manager.service.ItemParamService;
import com.e3.utils.E3mallResult;

@Controller
public class ItemParamController {
	
	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/item/param/query/itemcatid/{categoryId}")
	@ResponseBody
	public E3mallResult findItemParamWithCategoryId(@PathVariable Long categoryId){
		E3mallResult result = itemParamService.findItemParamWithCategoryId(categoryId);
		
		return result;
	};
}
