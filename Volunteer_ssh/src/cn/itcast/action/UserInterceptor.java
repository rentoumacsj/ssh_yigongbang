package cn.itcast.action;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//校验用户是否登录，只有登录后才可以进行操作。没有登录，只能查看列表，不能操作！
public class UserInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 得到当前执行的方法
		String methodName = invocation.getProxy().getMethod();
		// 得到ActionContext对象
		ActionContext ac = invocation.getInvocationContext();
		
		//获取session, 从session中获取登录的管理员账号
		Object obj = ac.getSession().get("volunteerSession");
		
		//判断 只有登录和列表允许不登录访问
		if(!"login".equals(methodName) && !("list".equals(methodName))){
			
			//验证
			if(obj == null){
				//没有登录
				Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
				request.put("alert", "没有权限，请先登录!");
				return "login";
			} else {
				//执行Action
				return invocation.invoke();
			}
		} else {
			//允许访问登录、列表展示
			return invocation.invoke();
		}
	}

}
