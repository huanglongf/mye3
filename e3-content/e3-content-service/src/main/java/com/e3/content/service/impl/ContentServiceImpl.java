package com.e3.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.e3.content.service.ContentService;
import com.e3.mapper.TbContentMapper;
import com.e3.pojo.TbContent;
import com.e3.pojo.TbContentExample;
import com.e3.pojo.TbContentExample.Criteria;
import com.e3.utils.AdItem;
import com.e3.utils.DatagridPagebean;
import com.e3.utils.E3mallResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Value("${WIDTH}")
	private Integer WIDTH;
	@Value("${WIDTHB}")
	private Integer WIDTHB;
	
	@Value("${HEIGHT}")
	private Integer HEIGHT;
	@Value("${HEIGHTB}")
	private Integer HEIGHTB;
	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public DatagridPagebean findContentListByPage(Long categoryId, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		TbContentExample example = new TbContentExample();
		Criteria createCriteria = example.createCriteria();
		
		
		createCriteria.andCategoryIdEqualTo(categoryId);
		
		
		PageHelper.startPage(page, rows);
		
		
		List<TbContent> list = contentMapper.selectByExample(example);
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		DatagridPagebean pageBean = new DatagridPagebean();
		pageBean.setTotal(pageInfo.getTotal());
		pageBean.setRows(list);
		
		return pageBean;
	}

	@Override
	public E3mallResult saveContent(TbContent content) {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		content.setCreated(date);
		content.setUpdated(date);
		contentMapper.insertSelective(content);
		
		return E3mallResult.ok();
	}

	@Override
	public List<AdItem> findAdItemList(Long categoryId) {
		// TODO Auto-generated method stub
		List<AdItem> adItemList = new ArrayList<AdItem>();
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		
		List<TbContent> list = contentMapper.selectByExample(example);
		for (TbContent tbContent : list) {
			AdItem ad = new AdItem();
			ad.setAlt(tbContent.getTitle());
			ad.setHref(tbContent.getUrl());
			ad.setSrc(tbContent.getPic());
			ad.setSrcB(tbContent.getPic2());
			
			ad.setHeight(HEIGHT);
			ad.setHeightB(HEIGHTB);
			ad.setWidth(WIDTH);
			ad.setWidthB(WIDTHB);
			
			adItemList.add(ad);
		}
		return adItemList;
	}

}
