package com.mmall.permission.service;

import com.mmall.permission.exception.ParamException;
import com.mmall.permission.param.AclModuleParam;

public interface ISysAclModuleService {

    void save(AclModuleParam param) throws ParamException;

    void update(AclModuleParam param) throws ParamException;

    void delete(int aclModuleId);
}
