package com.sise.lbl.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sise.lbl.po.Admin;

public class LoginAction extends ActionSupport implements ModelDriven,ServletResponseAware{
	
	private javax.servlet.http.HttpServletResponse response;
	
	private Admin admin;
	
	public LoginAction() {
		admin = new Admin();
	}
	public Object getModel() {
		return admin;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	//�жϵ�½��Ϣ�Ƿ���ȷ
	public String login() throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");//��ֹ��������Ϣ��������
		PrintWriter out = response.getWriter();
		
		String adminName = "1740129327";
		String adminPasswrod = "520123";
		if(admin.getName().equals(adminName)&&admin.getPassword().equals(adminPasswrod)){
			ActionContext.getContext().put("message", "��¼�ɹ�!");
			session.put("admin", admin.getName());
			return SUCCESS;
		}else {
			ActionContext.getContext().put("message", "��¼ʧ��!");
			return "input";
		}
	}
	public String quit(){
		session.clear();
		return "input";
	}
	/*//�ж��Ƿ��½
	public String beforeAdmin(){
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		String admin = (String) session.get("admin");
		if(admin != null){
			System.out.println("��Ů����Ů�����������"+admin);
			return SUCCESS;
		}else {
			return "input";
		}
	}*/
	public String typePut(){
		return SUCCESS;
	}

}
