package com.sise.lbl.dao;

import java.util.List;

import com.sise.lbl.po.Category;
import com.sise.lbl.po.News;


public interface NewsDao {
	public void addNews(News news);
	public List<News> getAllNews();
	//public Category getCategoryByCateName(String cateName);
	
	public News updateNews(Integer nid);
	public void updateNews(News news);
	public News getNewsById(Integer id);
	public List<News> getNewsByCate(Category category);
	public void deleteNews(News news);
	public List<News> getNewsByTitle(String title);
}
