package com.e3.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3.manager.service.TbItemCatService;
import com.e3.utils.TreeNode;

@Controller
public class TbItemCatController {
	
	
	@Autowired
	private TbItemCatService service;
	
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<TreeNode> findTreeNodeByTbItemCat(@RequestParam(value="id",defaultValue="0") Long parentId){
		List<TreeNode> tbItemCat = service.findTreeNodeByTbItemCat(parentId);
		return tbItemCat;
	}
}
