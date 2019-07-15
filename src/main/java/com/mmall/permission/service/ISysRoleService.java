package com.mmall.permission.service;

import com.mmall.permission.model.SysRole;
import com.mmall.permission.model.SysUser;
import com.mmall.permission.param.RoleParam;

import java.util.List;

public interface ISysRoleService {

    void save(RoleParam param);

    void update(RoleParam param);

    List<SysRole> getAll();

    List<SysRole> getRoleListByUserId(int userId);

    List<SysRole> getRoleListByAclId(int aclId);

    List<SysUser> getUserListByRoleList(List<SysRole> roleList);
}
