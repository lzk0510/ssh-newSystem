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
	//��ѯ���������ŵ����ͣ���ʾ�����ŷ�����ҳ��
	public String showNewsCateName(){
		categories = categoryService.getAllCategories();
		return "show";
	}
	//��������
	public String addNews(){
		category = categoryService.getCategoryById(cid);
		Date data = new Date();
		news.setIssueTime(data);
		news.setCategory(category);
		newsService.addNews(news);
		ActionContext.getContext().getSession().put("news", "�����ɹ�!");
		return SUCCESS;
		/*ActionContext actionContext = ActionContext.getContext();
		if(news.getTitle()==null||news.getTitle().trim().length()==0){
			actionContext.put("title", "���ⲻ��Ϊ��");
		}
		if(cid==-1){
			actionContext.put("category", "���Ͳ���Ϊ��");
		}
		if(news.getContent()==null||news.getContent().trim().length()==0){
			actionContext.put("content", "���ݲ���Ϊ��");
		}
		if(news.getSource()==null||news.getSource().trim().length()==0){
			actionContext.put("source", "��Դ����Ϊ��");
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
	//��ѯ��ʾȫ�����ź͸������Ͳ�ѯ������
	public String showNews(){
		newsList = newsService.getAllNews();
		categories = categoryService.getAllCategories();
		return "showNews";
	}
	//��ʾ��������
	public String aNewsShow(){
		news = newsService.getNewsById(cid);
		return "aShow";
	}
	//��������֮ǰ,�����͵�id����������ʾ����������ҳ��
	public String updateNews(){
		news = newsService.getNewsById(cid);
		cid = news.getCategory().getId();
		categories = categoryService.getAllCategories();
		return "update";
	}
	//������������
	public String updatedNews(){
		category = categoryService.getCategoryById(cid);
		news.setCategory(category);
		newsService.updatedNews(news);
		ActionContext.getContext().getSession().put("news", "���³ɹ�!");
		return SUCCESS;
	}
	//ɾ������
	public String deleteNews(){
		news = newsService.getNewsById(cid);
		newsService.deleteNews(news);
		ActionContext.getContext().getSession().put("news", "ɾ���ɹ�!");
		return SUCCESS;
	}
	//��ʾ������������ȥ��ѯ����
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
	//�ο�-�鿴��������(����)
	public String yk_showNews(){
		newsList = newsService.getAllNews();
		categories = categoryService.getAllCategories();
		return "yk_showNews";
	}
	//�ο�-�������Ͳ鿴����
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
	//�ο�-�鿴��������(����)
	public String yk_showNews2(){
		newsList = newsService.getAllNews();
		return "yk_showNews2";
	}
	//�ο�-���ݱ���鿴����
	public String yk_showNewsByTitle(){
		newsList = newsService.getNewsByTitle(news.getTitle());
		System.out.println("��������εز����㼸��"+newsList);
		return "yk_showNews2";
	}
	//�ο�-�鿴��������(����)
	public String yk_showNews3(){
		newsList = newsService.getAllNews();
		return "yk_showNews3";
	}
	//�ο�-���ݱ���鿴����
	public String yk_showNewsByTime(){
		//newsList = newsService.getNewsByTitle(news.getTitle());
		System.out.println("��������εز����㼸��====="+cateName);
		return "yk_showNews3";
	}
}
