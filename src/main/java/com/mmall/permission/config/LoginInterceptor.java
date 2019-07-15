package com.mmall.permission.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mmall.permission.common.RequestHolder;
import com.mmall.permission.model.SysUser;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * 登录页面
	 */
	public static final String LOGIN_URL = "/signin.html";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SysUser sysUser = (SysUser)request.getSession().getAttribute("user");
		if (sysUser == null) {
			response.sendRedirect(LOGIN_URL);
			return false;
		}
		RequestHolder.add(sysUser);
		RequestHolder.add(request);
		return true;
	}

}
