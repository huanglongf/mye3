package com.e3.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e3.content.service.ContentService;
import com.e3.utils.AdItem;
import com.e3.utils.JsonUtils;

@Controller
public class PageController {
	
	@Value("${BIG_ID_CONTENT_ID}")
	private Long BIG_ID_CONTENT_ID;
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("index")
	public String showIndex(Model model){
		
		List<AdItem> list = contentService.findAdItemList(BIG_ID_CONTENT_ID);
		String json = JsonUtils.objectToJson(list);
		model.addAttribute("ad1", json);
		return "index";
	}
}
