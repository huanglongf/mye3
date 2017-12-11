package com.e3.manager.service;

import com.e3.pojo.TbItem;
import com.e3.utils.DatagridPagebean;
import com.e3.utils.E3mallResult;
import com.e3.pojo.TbItemDesc;

public interface ItemService {
	
	
	public TbItem findItemById(Long itemId );
	
	public DatagridPagebean findItemListByPage(Integer page,Integer rows);
	
	public E3mallResult  saveItem(TbItem tbItem,TbItemDesc itemDesc,String itemParams);
}
	