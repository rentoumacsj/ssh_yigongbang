package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Admin;
import cn.itcast.service.IAdminService;

public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

	private static final long serialVersionUID = 6726906904592974964L;
	
	//封装请求数据
	private Admin admin = new Admin();
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@Override
	public Admin getModel() {
		return admin;
	}
	
	//调用Service
	private IAdminService adminService;
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	
	//登录
	public String login(){
		//登录验证
		Admin adminInfo = adminService.login(admin);
		//验证
		if(adminInfo == null){
			//登陆失败
			return "loginFailed";
		} else {
			//登录成功 , 保存数据到session
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "index";
		}
	}

}
