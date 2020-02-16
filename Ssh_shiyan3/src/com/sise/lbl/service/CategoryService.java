package com.sise.lbl.service;

import java.util.List;

import com.sise.lbl.po.Category;

public interface CategoryService {
	public void addCategory(Category category);
	public Category updateCategory(Integer id);
	public void updateCategory(Category category);
	public void deleteCategory(Category category);
	public Category getCategoryById(Integer id);
	public List<Category> getAllCategories();
}
