package com.mmall.permission.filter;

import com.google.common.collect.Sets;
import com.mmall.permission.common.RequestHolder;
import com.mmall.permission.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@Component
public class LoginFilter implements Filter {





    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        SysUser sysUser = (SysUser)req.getSession().getAttribute("user");

        if (sysUser != null) {
            RequestHolder.add(sysUser);
            RequestHolder.add(req);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

    }

    public void destroy() {

    }
}
