package com.mmall.permission.controller;

import com.mmall.permission.common.JsonData;
import com.mmall.permission.common.RequestHolder;
import com.mmall.permission.model.SysUser;
import com.mmall.permission.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
public class UserController extends BaseController{



    @Autowired
    private IUserService userService;

    @PostMapping("/logout")
    public JsonData logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return JsonData.success();
    }

    @PostMapping("/login")
    public JsonData login(@RequestParam("username")String username,@RequestParam("password") String password, HttpSession session){
        SysUser sysUser = userService.login(username,password);
        System.out.println(sysUser);
        session.setAttribute("user", sysUser);
        return JsonData.success();
    }
}
