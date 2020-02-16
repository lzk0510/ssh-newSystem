package com.sise.lbl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sise.lbl.dao.NewsDao;
import com.sise.lbl.po.Category;
import com.sise.lbl.po.News;
import com.sise.lbl.service.NewsService;

@Transactional(readOnly=false)
@Service
public class NewsServiceImpl implements NewsService {
	@Resource
	private NewsDao newsDao;

	public void addNews(News news) {
		newsDao.addNews(news);
	}

	public List<News> getAllNews() {
		return newsDao.getAllNews();
	}

	/*public Category getCategoryByCateName(String cateName) {
		return newsDao.getCategoryByCateName(cateName);
	}*/

	public News getNewsById(Integer id) {
		return newsDao.getNewsById(id);
	}

	public void updatedNews(News news) {
		newsDao.updateNews(news);
	}

	public void deleteNews(News news) {
		newsDao.deleteNews(news);
	}

	public List<News> getNewsByCate(Category category) {
		return newsDao.getNewsByCate(category);
	}
	
	public List<News> getNewsByTitle(String title){
		return newsDao.getNewsByTitle(title);
	}
}
