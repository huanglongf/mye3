package com.e3.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3.manager.service.ItemService;
import com.e3.mapper.TbItemMapper;
import com.e3.pojo.TbItem;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper mapper;

	public TbItem findItemById(Long itemId) {
		// TODO Auto-generated method stub
		TbItem item = mapper.selectByPrimaryKey(itemId);
		return item;
	}

}
