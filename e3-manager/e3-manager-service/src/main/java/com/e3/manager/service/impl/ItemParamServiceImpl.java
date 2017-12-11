package com.e3.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3.manager.service.ItemParamService;
import com.e3.mapper.TbItemParamMapper;
import com.e3.pojo.TbItemParam;
import com.e3.pojo.TbItemParamExample;
import com.e3.pojo.TbItemParamExample.Criteria;
import com.e3.utils.E3mallResult;


@Service
public class ItemParamServiceImpl implements ItemParamService {
	
	@Autowired
	private TbItemParamMapper tbItemParamMapper;

	@Override
	public E3mallResult findItemParamWithCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		TbItemParamExample example = new TbItemParamExample();
		
		Criteria createCriteria = example.createCriteria();
		createCriteria.andItemCatIdEqualTo(categoryId);
		
		
		
		List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
		
		TbItemParam tbItemParam = null;
		if(list!=null&&list.size()>0){
			tbItemParam = list.get(0);
		}
		
		return E3mallResult.ok(tbItemParam);
	}

}
