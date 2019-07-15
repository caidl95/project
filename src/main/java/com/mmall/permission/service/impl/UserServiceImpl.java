package com.mmall.permission.service.impl;

import com.mmall.permission.exception.ParamException;
import com.mmall.permission.model.SysUser;
import com.mmall.permission.service.ISysUserService;
import com.mmall.permission.service.IUserService;
import com.mmall.permission.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private ISysUserService sysUserService;

    public SysUser login(String username,String password){
        if (username == null)
            throw new ParamException("用户名不可以为空");
        if (password == null)
            throw new ParamException("密码不可以为空");
        SysUser sysUser = sysUserService.findByKeyword(username);
        System.out.println("userservice查询后"+sysUser);
        if (sysUser == null)
            throw new ParamException("查询不到指定的用户");
        if (!sysUser.getPassword().equals(MD5Util.encrypt(password)))
            throw new ParamException("用户名或密码错误");
        if (sysUser.getStatus() != 1)
            throw new ParamException("用户已被冻结，请联系管理员");
        return sysUser;
    }


}
