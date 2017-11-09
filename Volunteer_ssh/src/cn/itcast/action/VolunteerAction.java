package cn.itcast.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Volunteer;
import cn.itcast.service.IVolunteerService;

public class VolunteerAction extends ActionSupport implements ModelDriven<Volunteer> {

	private static final long serialVersionUID = 2677383784269553583L;
	
	//封装请求数据
	private Volunteer volunteer = new Volunteer();
	public Volunteer getVolunteer() {
		return volunteer;
	}
	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}
	
	@Override
	public Volunteer getModel() {
		return volunteer;
	}

	//调用service
	private IVolunteerService volunteerService;
	public void setVolunteerService(IVolunteerService volunteerService) {
		this.volunteerService = volunteerService;
	}

	//登录
	public String login() throws IOException{
		 Volunteer volunteerInfo = volunteerService.login(volunteer);
		 System.out.println(volunteerInfo);
		 HttpServletResponse response = ServletActionContext.getResponse();
		 response.setContentType("text/html;charset=UTF-8");  
		 PrintWriter out = response.getWriter();
		 if(volunteerInfo==null){
			 out.print("用户名或密码错误");
			 return null;
		 }else{
			 out.print("登录成功");
			 //保存数据到session
			 ActionContext.getContext().getSession().put("userInfo", volunteerInfo);
			 return null;
		 }
	} 
	
	//注册
	public String register() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		try {
			volunteerService.register(volunteer);
			out.print("注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("注册失败");
		}
		return null;
	}

	//判断是否登录
	public String isLogin() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		Object info = ActionContext.getContext().getSession().get("userInfo");
		if(info!=null){
			out.print("on");
		}else{
			out.print("off");
		}
		return null;
	}
	
	//登出
	public String logout() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		ActionContext.getContext().getSession().remove("userInfo");
		out.print("logout");
		return null;
	}
	
	//修改个人信息
	public String updateInfo() throws IOException{
		volunteerService.update(volunteer);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print("update");
		return null;
	}
	
	
	public String get() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("与服务器连接成功");
		return null;
	}
}
