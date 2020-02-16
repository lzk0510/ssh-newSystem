package com.sise.lbl.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sise.lbl.dao.NewsDao;
import com.sise.lbl.po.Category;
import com.sise.lbl.po.News;

public class NewsDaoImpl extends HibernateDaoSupport implements NewsDao {

	public void addNews(News news) {
		getHibernateTemplate().persist(news);
	}

	public List<News> getAllNews() {
		return (List<News>) getHibernateTemplate().find("from News");
	}


	/*public Category getCategoryByCateName(String cateName) {
		Category category = (Category) getHibernateTemplate().find("from Category where categoryName=?", cateName);
		return category;
	}*/
	
	public News updateNews(Integer nid) {
		return null;
	}

	public void updateNews(News news) {
		getHibernateTemplate().saveOrUpdate(news);
	}

	public News getNewsById(Integer id) {
		return getHibernateTemplate().get(News.class, id);
	}

	public List<News> getNewsByCate(Category category) {
		List<News> newsList = (List<News>) getHibernateTemplate().find("from News where category=?0", category);
		return newsList;
	}

	public void deleteNews(News news) {
		getHibernateTemplate().delete(news);
	}

	@Override
	public List<News> getNewsByTitle(String title) {
		List<News> newsList = (List<News>) getHibernateTemplate().find("from News where title like '%"+title+"%'");
		//List<News> newsList = (List<News>) getHibernateTemplate().find("from News where title like ?","'%"+title+"%'");
		return newsList;
	}

}
