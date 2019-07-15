package com.mmall.permission.service;

import com.mmall.permission.beans.PageQuery;
import com.mmall.permission.beans.PageResult;
import com.mmall.permission.exception.ParamException;
import com.mmall.permission.model.SysUser;
import com.mmall.permission.param.UserParam;

import java.util.List;

public interface ISysUserService {

    void save(UserParam param) throws ParamException;

    void update(UserParam param) throws ParamException;

    boolean checkEmailExist(String mail, Integer userId);

    boolean checkTelephoneExist(String telephone, Integer userId);

    SysUser findByKeyword(String keyword);

    PageResult<SysUser> getPageByDeptId(int deptId, PageQuery page);

    List<SysUser> getAll();
}
