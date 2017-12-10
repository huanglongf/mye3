package com.e3.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3.content.service.ContentCategoryService;
import com.e3.mapper.TbContentCategoryMapper;
import com.e3.pojo.TbContentCategory;
import com.e3.pojo.TbContentCategoryExample;
import com.e3.pojo.TbContentCategoryExample.Criteria;
import com.e3.utils.E3mallResult;
import com.e3.utils.TreeNode;


@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	
	@Autowired
	TbContentCategoryMapper  contentCategoryMapper;

	public List<TreeNode> findContentCategoryList(Long parentId) {
		// TODO Auto-generated method stub
		List<TreeNode> treeNodeList = new ArrayList<>();
		
		TbContentCategoryExample example = new TbContentCategoryExample();
		
		Criteria criteria = example.createCriteria();
		//添加查询条件
		criteria.andParentIdEqualTo(parentId);
		
		
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		for (TbContentCategory tbContentCategory : list) {
			TreeNode node = new TreeNode();
			
			node.setId(tbContentCategory.getId());
			
			node.setText(tbContentCategory.getName());
			
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			
			treeNodeList.add(node);
		}
		
		return treeNodeList;
	}

	@Override
	public E3mallResult createNode(Long parentId, String name) {
		// TODO Auto-generated method stub
		TbContentCategory category = new TbContentCategory();
		
		category.setParentId(parentId);
		category.setName(name);
		category.setStatus(1);
		category.setSortOrder(1);
		category.setIsParent(false);
		Date date = new Date();
		category.setCreated(date);
		category.setUpdated(date);
		
		TbContentCategory tbContentCategory = contentCategoryMapper.selectByPrimaryKey(parentId);
		if(!tbContentCategory.getIsParent()){
			tbContentCategory.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
		}
		
		contentCategoryMapper.insert(category);
		return E3mallResult.ok(category);
	}

}
