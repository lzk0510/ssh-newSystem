package com.sise.lbl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sise.lbl.dao.CategoryDao;
import com.sise.lbl.po.Category;
import com.sise.lbl.service.CategoryService;

@Transactional(readOnly=false)
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Resource
	private CategoryDao categoryDao;

	public void addCategory(Category category) {
		categoryDao.addCategory(category);
	}

	public Category updateCategory(Integer id) {
		return categoryDao.updateCategory(id);
	}

	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}

	public void deleteCategory(Category category) {
		categoryDao.deleteCategory(category);
	}

	public Category getCategoryById(Integer id) {
		return categoryDao.getCategoryById(id);
	}
	public List<Category> getAllCategories() {
		return categoryDao.getCategories();
	}
}
