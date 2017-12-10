package com.e3.content.service;

import java.util.List;

import com.e3.utils.E3mallResult;
import com.e3.utils.TreeNode;

public interface ContentCategoryService {
	
	
	public List<TreeNode>  findContentCategoryList(Long parentId);
	
	public E3mallResult createNode(Long parentId,String name);
}
