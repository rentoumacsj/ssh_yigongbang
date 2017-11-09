package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Admin;
import cn.itcast.service.IAdminService;

public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

	private static final long serialVersionUID = 6726906904592974964L;
	
	//��װ��������
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
	
	//����Service
	private IAdminService adminService;
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	
	//��¼
	public String login(){
		//��¼��֤
		Admin adminInfo = adminService.login(admin);
		//��֤
		if(adminInfo == null){
			//��½ʧ��
			return "loginFailed";
		} else {
			//��¼�ɹ� , �������ݵ�session
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "index";
		}
	}

}
