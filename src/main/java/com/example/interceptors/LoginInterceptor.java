package com.example.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

import com.example.pojo.User;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	private static String[] passpath = new String[]{
		"/user/toLogin",
		"/user/toRegister",
		"/user/login",
		"/user/register",
		"/user/logout"
	};
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String name = handler.getClass().getName();
		System.out.println(getClass().getName() + "---" + name);
		//静态资源放行
		if(handler instanceof DefaultServletHttpRequestHandler){
			return true;
		}
		
//		String contextPath = request.getContextPath();
//		System.out.println("contextPath=" + contextPath);
//		String requestURI = request.getRequestURI();
//		System.out.println(requestURI);
		//requestURI = contextPath + servletPath
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		if (containStr(servletPath)) {
			return true;
		}
		
		User loginUser = (User) request.getSession().getAttribute("loginUser");
		if (loginUser == null) {
			System.out.println("==============NO PASS==================");
			request.setAttribute("msg", "请您先登录！");
			request.getRequestDispatcher("/user/toLogin").forward(request, response);
		}
		
		return super.preHandle(request, response, handler);
	}
	
	public boolean containStr(String path){
		for (int i = 0; i < passpath.length; i++) {
			if (path.equals(passpath[i])) {
				return true;
			}
		}
		return false;
	}
	
}
