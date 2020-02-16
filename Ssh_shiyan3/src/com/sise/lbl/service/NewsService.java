package com.sise.lbl.service;

import java.util.List;

import com.sise.lbl.po.Category;
import com.sise.lbl.po.News;

public interface NewsService {
	public void addNews(News news);
	public List<News> getAllNews();
	//public Category getCategoryByCateName(String cateName);
	
	public News getNewsById(Integer id);
	public void updatedNews(News news);
	public void deleteNews(News news);
	public List<News> getNewsByCate(Category category);
	public List<News> getNewsByTitle(String title);
}
