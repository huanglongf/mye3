package com.e3.manager.service;

import java.util.List;

import com.e3.utils.TreeNode;

public interface TbItemCatService {
	
	
	public List<TreeNode> findTreeNodeByTbItemCat(Long parentId);
}
