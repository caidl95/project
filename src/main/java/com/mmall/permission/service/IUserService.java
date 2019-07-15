package com.mmall.permission.service;

import com.mmall.permission.model.SysUser;

public interface IUserService {

    SysUser login(String username, String password);
}
