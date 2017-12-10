package com.e3.content.service;

import java.util.List;

import com.e3.pojo.TbContent;
import com.e3.utils.AdItem;
import com.e3.utils.DatagridPagebean;
import com.e3.utils.E3mallResult;

public interface ContentService {
	
	public DatagridPagebean  findContentListByPage(Long categoryId,Integer page,Integer rows);
	
	public E3mallResult  saveContent(TbContent content);

	public List<AdItem> findAdItemList(Long categoryId);
}
