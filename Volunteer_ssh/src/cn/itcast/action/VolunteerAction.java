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
	
	//��װ��������
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

	//����service
	private IVolunteerService volunteerService;
	public void setVolunteerService(IVolunteerService volunteerService) {
		this.volunteerService = volunteerService;
	}

	//��¼
	public String login() throws IOException{
		 Volunteer volunteerInfo = volunteerService.login(volunteer);
		 System.out.println(volunteerInfo);
		 HttpServletResponse response = ServletActionContext.getResponse();
		 response.setContentType("text/html;charset=UTF-8");  
		 PrintWriter out = response.getWriter();
		 if(volunteerInfo==null){
			 out.print("�û������������");
			 return null;
		 }else{
			 out.print("��¼�ɹ�");
			 //�������ݵ�session
			 ActionContext.getContext().getSession().put("userInfo", volunteerInfo);
			 return null;
		 }
	} 
	
	//ע��
	public String register() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		try {
			volunteerService.register(volunteer);
			out.print("ע��ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			out.print("ע��ʧ��");
		}
		return null;
	}

	//�ж��Ƿ��¼
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
	
	//�ǳ�
	public String logout() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		ActionContext.getContext().getSession().remove("userInfo");
		out.print("logout");
		return null;
	}
	
	//�޸ĸ�����Ϣ
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
		out.print("����������ӳɹ�");
		return null;
	}
}
