package com.mmall.permission.service;

import com.mmall.permission.beans.PageQuery;
import com.mmall.permission.beans.PageResult;
import com.mmall.permission.exception.ParamException;
import com.mmall.permission.model.*;
import com.mmall.permission.param.SearchLogParam;

public interface ISysLogService {

    void recover(int id);

    PageResult<SysLogWithBLOBs> searchPageList(SearchLogParam param, PageQuery page) throws ParamException;

    void saveDeptLog(SysDept before, SysDept after);

    void saveUserLog(SysUser before, SysUser after);

    void saveAclModuleLog(SysAclModule before, SysAclModule after);

    void saveAclLog(SysAcl before, SysAcl after);

    void saveRoleLog(SysRole before, SysRole after);
}
