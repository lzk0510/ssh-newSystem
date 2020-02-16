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
	//添加类型
	public String add(){
		categoryService.addCategory(category);
		ActionContext.getContext().getSession().put("cate", "发布成功!");
		return SUCCESS;
	}
	//显示全部类型
	public String show(){
		categories = categoryService.getAllCategories();
		return "show";
	}
	//更新类型,把类型的id传过来，显示类型名称在更新类型页面
	public String update(){
		category = categoryService.updateCategory(cid);
		return "update";
	}
	//更新整条记录
	public String updated(){
		categoryService.updateCategory(category);
		ActionContext.getContext().getSession().put("cate", "更新成功!");
		return SUCCESS;
	}
	//删除类型
	public String delete(){
		category = categoryService.getCategoryById(cid);
		categoryService.deleteCategory(category);
		ActionContext.getContext().getSession().put("cate", "删除成功!");
		return SUCCESS;
	}
	
}
