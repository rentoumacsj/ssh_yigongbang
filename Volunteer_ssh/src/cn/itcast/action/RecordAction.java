package cn.itcast.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Record;
import cn.itcast.entity.Volunteer;
import cn.itcast.service.IRecordService;

public class RecordAction extends ActionSupport implements ModelDriven<Record>{

	private static final long serialVersionUID = -7922587230504119562L;
	
	private Record record = new Record();
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	
	@Override
	public Record getModel() {
		return record;
	}

	//����service
	private IRecordService recordService;
	public void setRecordService(IRecordService recordService) {
		this.recordService = recordService;
	}
	
	//�ղأ���ҪactId����
	public String collect() throws IOException{
		Volunteer volunteer = (Volunteer) ActionContext.getContext().getSession().get("userInfo");
		record.setVolId(volunteer.getId());
		recordService.collect(record);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print("collected");
		return null;
	} 
	
	//ȡ���ղأ���ҪactId����
	public String cancelCollect() throws IOException{
		Volunteer volunteer = (Volunteer) ActionContext.getContext().getSession().get("userInfo");
		record.setVolId(volunteer.getId());
		recordService.cancelCollect(record);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print("cancelcollected");
		return null;
	}	 
	
	//��������ҪactId����
	public String join() throws IOException{
		Volunteer volunteer = (Volunteer) ActionContext.getContext().getSession().get("userInfo");
		record.setVolId(volunteer.getId());
		recordService.join(record);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print("joined");
		return null;
	}
	
	//ȡ����������ҪactId����
	public String cancelJoin() throws IOException{
		Volunteer volunteer = (Volunteer) ActionContext.getContext().getSession().get("userInfo");
		record.setVolId(volunteer.getId());
		recordService.cancelJoin(record);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print("canceljoined");
		return null;
	}
	
	//��ȡ��¼��Ϣ����ҪactId����
	public String getInfo() throws IOException{
		Volunteer volunteer = (Volunteer) ActionContext.getContext().getSession().get("userInfo");
		record.setVolId(volunteer.getId());
		Record r = recordService.getRecordInfo(record);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print(r.toString());
		return null;
	}
	
}
