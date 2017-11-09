package cn.itcast.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Activity;
import cn.itcast.entity.Volunteer;
import cn.itcast.service.IActivityService;
import net.sf.json.JSONArray;

public class ActivityAction extends ActionSupport implements ModelDriven<Activity>{

	private static final long serialVersionUID = 4836736837254946922L;
	
	private Activity activity = new Activity();
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public Activity getModel() {
		return activity;
	}

	//����service
	private IActivityService activityService;
	public void setActivityService(IActivityService activityService) {
		this.activityService = activityService;
	}
	
	//�������л����
	public String getNames() throws IOException{
		List<Activity> list = activityService.getAllActivities();
		List<String> names = new ArrayList<String>();
		for(Activity activity:list){
			names.add(activity.getActName());
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print(names.toString());
		return null;
	}
	
	//��ȡ���л������json����
	public String getAll() throws IOException{
		List<Activity> list = activityService.getAllActivities();
		JSONArray jsonArray = JSONArray.fromObject(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print(jsonArray.toString());
		return null;
	}
	
	//��ȡδ��ɵĻ������json����
	public String getFinished() throws IOException{
		Volunteer volunteer = (Volunteer) ActionContext.getContext().getSession().get("userInfo");
		List<Activity> list = activityService.getFinishedActivitiesByVolId(volunteer.getId());
		JSONArray jsonArray = JSONArray.fromObject(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print(jsonArray.toString());
		return null;
	}
	
	//��ȡ����ɵĻ������json����
	public String getUnFinished() throws IOException{
		Volunteer volunteer = (Volunteer) ActionContext.getContext().getSession().get("userInfo");
		List<Activity> list = activityService.getUnFinishedActivitiesByVolId(volunteer.getId());
		JSONArray jsonArray = JSONArray.fromObject(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print(jsonArray.toString());
		return null;
	}
	
	//��ȡ�ղصĻ������json����
	public String getCollected() throws IOException{
		Volunteer volunteer = (Volunteer) ActionContext.getContext().getSession().get("userInfo");
		List<Activity> list = activityService.getCollectedActivitiesByVolId(volunteer.getId());
		JSONArray jsonArray = JSONArray.fromObject(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print(jsonArray.toString());
		return null;
	}
	
	//��ȡ�ѱ����Ļ������json����
	public String getSigned() throws IOException{
		Volunteer volunteer = (Volunteer) ActionContext.getContext().getSession().get("userInfo");
		List<Activity> list = activityService.getJoinedActivitiesByVolId(volunteer.getId());
		JSONArray jsonArray = JSONArray.fromObject(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print(jsonArray.toString());
		return null;
	}	
	
}
