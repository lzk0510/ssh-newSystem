package com.sise.lbl.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sise.lbl.po.Category;
import com.sise.lbl.po.News;
import com.sise.lbl.service.CategoryService;
import com.sise.lbl.service.NewsService;

public class NewsAction extends ActionSupport implements ModelDriven{
	@Resource
	private NewsService newsService;
	@Resource
	private CategoryService categoryService;
	private News news;
	private Category category;
	private List<News> newsList;
	private List<Category> categories;
	private String cateName;
	private Integer cid;
	
	public Object getModel() {
		return news;
	}
	public NewsAction() {
		news = new News();
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<News> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	//查询并返回新闻的类型，显示在新闻发布的页面
	public String showNewsCateName(){
		categories = categoryService.getAllCategories();
		return "show";
	}
	//插入新闻
	public String addNews(){
		category = categoryService.getCategoryById(cid);
		Date data = new Date();
		news.setIssueTime(data);
		news.setCategory(category);
		newsService.addNews(news);
		ActionContext.getContext().getSession().put("news", "发布成功!");
		return SUCCESS;
		/*ActionContext actionContext = ActionContext.getContext();
		if(news.getTitle()==null||news.getTitle().trim().length()==0){
			actionContext.put("title", "标题不能为空");
		}
		if(cid==-1){
			actionContext.put("category", "类型不能为空");
		}
		if(news.getContent()==null||news.getContent().trim().length()==0){
			actionContext.put("content", "内容不能为空");
		}
		if(news.getSource()==null||news.getSource().trim().length()==0){
			actionContext.put("source", "来源不能为空");
		}
		if(news.getTitle()!=null&&news.getTitle().trim().length()!=0&&cid!=-1&&news.getContent()!=null&&news.getSource()!=null){
			category = categoryService.getCategoryById(cid);
			Date data = new Date();
			news.setIssueTime(data);
			news.setCategory(category);
			newsService.addNews(news);
			return SUCCESS;
		}else {
			return "input";
		}*/
	}
	//查询显示全部新闻和根据类型查询的新闻
	public String showNews(){
		newsList = newsService.getAllNews();
		categories = categoryService.getAllCategories();
		return "showNews";
	}
	//显示单条新闻
	public String aNewsShow(){
		news = newsService.getNewsById(cid);
		return "aShow";
	}
	//更新新闻之前,把类型的id传过来，显示类型名称在页面
	public String updateNews(){
		news = newsService.getNewsById(cid);
		cid = news.getCategory().getId();
		categories = categoryService.getAllCategories();
		return "update";
	}
	//更新整条新闻
	public String updatedNews(){
		category = categoryService.getCategoryById(cid);
		news.setCategory(category);
		newsService.updatedNews(news);
		ActionContext.getContext().getSession().put("news", "更新成功!");
		return SUCCESS;
	}
	//删除新闻
	public String deleteNews(){
		news = newsService.getNewsById(cid);
		newsService.deleteNews(news);
		ActionContext.getContext().getSession().put("news", "删除成功!");
		return SUCCESS;
	}
	//显示根据新闻类型去查询新闻
	public String showNewsByCate(){
		if(cid==-1){
			newsList = newsService.getAllNews();
			categories = categoryService.getAllCategories();
		}else{
			category = categoryService.getCategoryById(cid);
			newsList = newsService.getNewsByCate(category);
			categories = categoryService.getAllCategories();
		}
		return "showNewsByCate";
	}
	//游客-查看所有新闻(类型)
	public String yk_showNews(){
		newsList = newsService.getAllNews();
		categories = categoryService.getAllCategories();
		return "yk_showNews";
	}
	//游客-根据类型查看新闻
	public String yk_showNewsByCate(){
		if(cid==-1){
			newsList = newsService.getAllNews();
			categories = categoryService.getAllCategories();
		}else{
			category = categoryService.getCategoryById(cid);
			newsList = newsService.getNewsByCate(category);
			categories = categoryService.getAllCategories();
		}
		return "yk_showNews";
	}
	//游客-查看所有新闻(标题)
	public String yk_showNews2(){
		newsList = newsService.getAllNews();
		return "yk_showNews2";
	}
	//游客-根据标题查看新闻
	public String yk_showNewsByTitle(){
		newsList = newsService.getNewsByTitle(news.getTitle());
		System.out.println("看到曾多次地产几点几分"+newsList);
		return "yk_showNews2";
	}
	//游客-查看所有新闻(标题)
	public String yk_showNews3(){
		newsList = newsService.getAllNews();
		return "yk_showNews3";
	}
	//游客-根据标题查看新闻
	public String yk_showNewsByTime(){
		//newsList = newsService.getNewsByTitle(news.getTitle());
		System.out.println("看到曾多次地产几点几分====="+cateName);
		return "yk_showNews3";
	}
}
