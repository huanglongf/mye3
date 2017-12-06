package com.e3.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3.manager.service.TbItemCatService;
import com.e3.mapper.TbItemCatMapper;
import com.e3.pojo.TbItemCat;
import com.e3.pojo.TbItemCatExample;
import com.e3.pojo.TbItemCatExample.Criteria;
import com.e3.utils.TreeNode;

@Service
public class TbItemCatServiceImpl implements TbItemCatService {
	
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<TreeNode> findTreeNodeByTbItemCat(Long parentId) {
		// TODO Auto-generated method stub
		List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
		
		TbItemCatExample example = new TbItemCatExample();
		
		
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		for (TbItemCat tbItemCat : list) {
			TreeNode treeNode = new TreeNode();
			
			treeNode.setId(tbItemCat.getId());
			
			treeNode.setText(tbItemCat.getName());
			
			treeNode.setState(tbItemCat.getIsParent()==true?"closed":"open");
			
			treeNodeList.add(treeNode);
		}
		
		return treeNodeList;
	}

}
