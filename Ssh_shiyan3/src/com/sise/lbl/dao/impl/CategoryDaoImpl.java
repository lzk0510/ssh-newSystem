package com.sise.lbl.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sise.lbl.dao.CategoryDao;
import com.sise.lbl.po.Category;

public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	public void addCategory(Category category) {
		getHibernateTemplate().persist(category);
	}

	public Category updateCategory(Integer id) {
		Category category = getHibernateTemplate().get(Category.class, id);
		getHibernateTemplate().saveOrUpdate(category);
		return category;
	}

	public void updateCategory(Category category) {
		getHibernateTemplate().saveOrUpdate(category);
	}

	public void deleteCategory(Category category) {
		getHibernateTemplate().delete(category);
	}

	public Category getCategoryById(Integer id) {
		return getHibernateTemplate().get(Category.class, id);
	}
	public List<Category> getCategories() {
		return (List<Category>) getHibernateTemplate().find("from Category");
	}
}
