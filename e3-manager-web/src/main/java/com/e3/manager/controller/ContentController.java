package com.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e3.content.service.ContentService;
import com.e3.pojo.TbContent;
import com.e3.utils.DatagridPagebean;
import com.e3.utils.E3mallResult;

@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/content/query/list")
	@ResponseBody
	public DatagridPagebean findContentListByPage(Long categoryId,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10") Integer rows){
		DatagridPagebean pagebean = contentService.findContentListByPage(categoryId, page, rows);
		return pagebean;
	};
	
	@RequestMapping("/content/save")
	@ResponseBody
	public E3mallResult saveContent(TbContent content){
		E3mallResult result = contentService.saveContent(content);
		return result;
	}
	
	
}
