package com.mmall.permission.service;

import com.mmall.permission.model.SysAcl;

import java.util.List;

public interface ISysCoreService {

    List<SysAcl> getCurrentUserAclList();

    List<SysAcl> getRoleAclList(int roleId);

    List<SysAcl> getUserAclList(int userId);

    boolean isSuperAdmin();

    boolean hasUrlAcl(String url);

    List<SysAcl> getCurrentUserAclListFromCache();
}
