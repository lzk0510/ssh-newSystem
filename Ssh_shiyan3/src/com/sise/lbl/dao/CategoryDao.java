package com.sise.lbl.dao;

import java.util.List;

import com.sise.lbl.po.Category;

public interface CategoryDao {
	public void addCategory(Category category);
	public Category updateCategory(Integer id);
	public void updateCategory(Category category);
	public void deleteCategory(Category category);
	public Category getCategoryById(Integer id);
	public List<Category> getCategories();
}
