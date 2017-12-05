package com.e3.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3.manager.service.ItemService;
import com.e3.mapper.TbItemMapper;
import com.e3.pojo.TbItem;
import com.e3.pojo.TbItemExample;
import com.e3.utils.DatagridPagebean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper mapper;

	public TbItem findItemById(Long itemId) {
		// TODO Auto-generated method stub
		TbItem item = mapper.selectByPrimaryKey(itemId);
		return item;
	}

	@Override
	public DatagridPagebean findItemListByPage(Integer page, Integer rows) {
		// TODO Auto-generated method stub
		//创建example对象
		TbItemExample example = new TbItemExample();
		//在查询之前设置分页
		PageHelper.startPage(page, rows);
		//执行查询
		List<TbItem> list = mapper.selectByExample(example);
		
		//创建pageInfo对象  pageInfo分页插件封装了所有的分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		
		//创建DatafgridPagebean对象  封装分页信息
		DatagridPagebean pagebean = new DatagridPagebean();
		
		pagebean.setTotal(pageInfo.getTotal());
		pagebean.setRows(list);
		
		return pagebean;
		
		
	}

}
