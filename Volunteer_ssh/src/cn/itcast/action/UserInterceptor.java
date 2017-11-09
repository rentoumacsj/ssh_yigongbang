package cn.itcast.action;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//У���û��Ƿ��¼��ֻ�е�¼��ſ��Խ��в�����û�е�¼��ֻ�ܲ鿴�б����ܲ�����
public class UserInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// �õ���ǰִ�еķ���
		String methodName = invocation.getProxy().getMethod();
		// �õ�ActionContext����
		ActionContext ac = invocation.getInvocationContext();
		
		//��ȡsession, ��session�л�ȡ��¼�Ĺ���Ա�˺�
		Object obj = ac.getSession().get("volunteerSession");
		
		//�ж� ֻ�е�¼���б�������¼����
		if(!"login".equals(methodName) && !("list".equals(methodName))){
			
			//��֤
			if(obj == null){
				//û�е�¼
				Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
				request.put("alert", "û��Ȩ�ޣ����ȵ�¼!");
				return "login";
			} else {
				//ִ��Action
				return invocation.invoke();
			}
		} else {
			//������ʵ�¼���б�չʾ
			return invocation.invoke();
		}
	}

}
