package com.mmall.permission.service;

import com.mmall.permission.beans.PageQuery;
import com.mmall.permission.beans.PageResult;
import com.mmall.permission.exception.ParamException;
import com.mmall.permission.model.SysAcl;
import com.mmall.permission.param.AclParam;

public interface ISysAclService {

    void save(AclParam param) throws ParamException;

    void update(AclParam param) throws ParamException;

    boolean checkExist(int aclModuleId, String name, Integer id);

    String generateCode();

    PageResult<SysAcl> getPageByAclModuleId(int aclModuleId, PageQuery page);
}
