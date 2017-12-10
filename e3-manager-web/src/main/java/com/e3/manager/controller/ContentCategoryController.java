package com.e3.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3.content.service.ContentCategoryService;
import com.e3.utils.E3mallResult;
import com.e3.utils.TreeNode;

@Controller
public class ContentCategoryController {
	
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<TreeNode> findContentCategoryTreeNode(@RequestParam(defaultValue="0",value="id") Long parnetId){
		List<TreeNode> list = contentCategoryService.findContentCategoryList(parnetId);
		return list;
	}
	
	
	@RequestMapping("/content/category/create")
	@ResponseBody
	public E3mallResult createNode(Long parentId,String name){
		E3mallResult result = contentCategoryService.createNode(parentId, name);
		return result;
	}
}
