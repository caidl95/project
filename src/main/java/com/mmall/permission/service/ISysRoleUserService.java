package com.mmall.permission.service;

import com.mmall.permission.model.SysUser;

import java.util.List;

public interface ISysRoleUserService {

    List<SysUser> getListByRoleId(int roleId);

    void changeRoleUsers(int roleId, List<Integer> userIdList);


}
