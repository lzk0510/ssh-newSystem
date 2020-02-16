package com.sise.lbl.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sise.lbl.po.Category;
import com.sise.lbl.service.CategoryService;

public class CategoryAction extends ActionSupport implements ModelDriven{
	@Resource
	private CategoryService categoryService;
	private Integer cid;
	private Category category;
	private List<Category> categories;
	
	public Object getModel() {
		return category;
	}
	public CategoryAction(){
		category = new Category();
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public String typePut(){
		return SUCCESS;
	}
	//�������
	public String add(){
		categoryService.addCategory(category);
		ActionContext.getContext().getSession().put("cate", "�����ɹ�!");
		return SUCCESS;
	}
	//��ʾȫ������
	public String show(){
		categories = categoryService.getAllCategories();
		return "show";
	}
	//��������,�����͵�id����������ʾ���������ڸ�������ҳ��
	public String update(){
		category = categoryService.updateCategory(cid);
		return "update";
	}
	//����������¼
	public String updated(){
		categoryService.updateCategory(category);
		ActionContext.getContext().getSession().put("cate", "���³ɹ�!");
		return SUCCESS;
	}
	//ɾ������
	public String delete(){
		category = categoryService.getCategoryById(cid);
		categoryService.deleteCategory(category);
		ActionContext.getContext().getSession().put("cate", "ɾ���ɹ�!");
		return SUCCESS;
	}
	
}
