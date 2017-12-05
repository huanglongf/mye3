package com.e3.manager.service;

import com.e3.pojo.TbItem;
import com.e3.utils.DatagridPagebean;

public interface ItemService {
	
	
	public TbItem findItemById(Long itemId );
	
	public DatagridPagebean findItemListByPage(Integer page,Integer rows);
}
	